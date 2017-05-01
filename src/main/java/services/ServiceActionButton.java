package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import utils.CardsUtils;
import utils.PlayerUtils;
import utils.UpdateUtils;

import com.google.common.collect.Iterables;

import controler.Sounds;
import data.beans.principal.AllItems;
import data.beans.secondaire.Adjacence;
import data.beans.secondaire.CityCard;
import data.beans.secondaire.Player;
import data.constantes.ConstantesMsgBox;
import data.enumerations.EnumDirection;

public class ServiceActionButton  {
    
    protected static final String LEFT = "left";
    protected static final String RIGHT = "right";
    protected static final int CARD_TO_LEFT = 0;
    protected static final int CARD_TO_RIGHT = 1;
    
    private ServiceCards serviceCards;
    private JButton btnDeckCard;
    private JButton btnRules;
    private JButton btnDiscard;
    private JButton btnBuild;
    private JLabel lblCardRemaining;
    private List<CityCard> listCardsRoad;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listCardsVisible;
    private List<CityCard> listCardsRemaining;

    private Sounds sounds;
    
    // Actions Listener
    private ActionListener alBtnDeckCard;
    private ActionListener alBtnDiscard;
    private ActionListener alBtnCardVisible;

    public ServiceActionButton(AllItems allItems, Sounds sounds) {
        this.initialiserVariables(allItems);
        this.creerActionListenerBtnDeckCard();
        this.sounds = sounds;
    }
    
    // ------------------------------
    // METODES PUBLIQUES : ACTIVATION
    // ------------------------------
    
    
    public void addActionButtonDeckCard() {
        this.btnDeckCard.addActionListener(this.alBtnDeckCard);
    }

    /**
     * ActionListener sur <strong>buttonCardVisible</strong> permettant de sélectionner une carte à partir des cartes visibles. <br>
     * 1 - on transfère la carte visible dans les cartes en main du joueur <br>
     * 2 - on nettoie la carte visible, sans la supprimer <br>
     * 3 - on transfère une carte du tas de cartes sur la carte visible <br>
     * 4 - on supprime la carte prise précédemment <br>
     * 5 - on met à jour le label du nombre de cartes restantes <br>
     */
    
    public void addActionVisibleCards() {
        
        for (final CityCard cardVisible : this.listCardsVisible) {
            this.alBtnCardVisible = new ActionListener() {
                
            	@Override
                public void actionPerformed(ActionEvent e) {

                    if (CardsUtils.isListeCardsHandNotFull(PlayerUtils.getPlayerEnCours().getListHandCityCards())) {
                        ServiceActionButton.this.serviceCards.transferOneCityCard(cardVisible,
                                        CardsUtils.getFirstCardHandPlayerAvailable(PlayerUtils.getPlayerEnCours().getListHandCityCards()));

                        for (CityCard cardToClear : ServiceActionButton.this.listCardsVisible) {
                            if (cardVisible.equals(cardToClear)) {
                                cardVisible.clear();
                                if (CollectionUtils.isNotEmpty(ServiceActionButton.this.listCardsRemaining)) {
                                    ServiceActionButton.this.serviceCards.transferOneCityCard(
                                                    Iterables.getLast(ServiceActionButton.this.listCardsRemaining), cardVisible);
                                    ServiceActionButton.this.listCardsRemaining.remove(Iterables
                                                    .getLast(ServiceActionButton.this.listCardsRemaining));
                                    UpdateUtils.updateLabelCardRemaining(ServiceActionButton.this.lblCardRemaining,
                                                    ServiceActionButton.this.getNbCardsRemaining());
                                }
                                break;
                            }
                        }
                        // on signale que le joueur a pris une carte
                        PlayerUtils.getPlayerEnCours().getActions().setTakeOneCard(true);
                        ServiceActionButton.this.sounds.getSoundTakeCard().play();
                    } else {
                        JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_TAKE_CARDS, ConstantesMsgBox.INFORMATION,
                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            };
            cardVisible.getCityButton().addActionListener(this.alBtnCardVisible);
        }
        
    }

    
    public void addActionButtonPlayersCards(final List<Adjacence> listAdjacences, final List<Player> listPlayers) {

        for (Player player : listPlayers) {
            for (final CityCard cardPlayer : player.getListHandCityCards()) {
                cardPlayer.getCityButton().addActionListener(new ActionListener() {

                	@Override
                    public void actionPerformed(ActionEvent e) {

                        if (this.islistCardsRoadEmpty()) {
                            final CityCard cardRoad = ServiceActionButton.this.listCardsRoad.get(0);
                            this.addRoadCardFromPlayerCardsToTheRight(cardPlayer, cardRoad);
                        } else if (this.islistCardsRoadFull()) {
                            JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_PLACE_ADDITIONAL_CARDS,
                                            ConstantesMsgBox.INFORMATION, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // controle si possible de poser la carte
                            EnumDirection enumDirection = CardsUtils.isPossibleToPutCard(ServiceActionButton.this.listCardsRoad,
                                            listAdjacences, cardPlayer);
                            if (enumDirection == EnumDirection.NEANT) {
                                JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_PLACE_THIS_CARD,
                                                ConstantesMsgBox.INFORMATION, JOptionPane.INFORMATION_MESSAGE);
                            }
                            if (enumDirection == EnumDirection.LEFT_OR_RIGHT) {
                                final int option = JOptionPane.showOptionDialog(null, ConstantesMsgBox.QUESTION_RIGHT_OR_LEFT, "Put your card",
                                                0, JOptionPane.QUESTION_MESSAGE, null, ConstantesMsgBox.OPTIONS_LEFT_RIGHT, null);
                                enumDirection = EnumDirection.getEnumDirectionByOption(option);
                            }
                            if (enumDirection == EnumDirection.LEFT) {
                                this.addRoadCardFromPlayerCardsToTheLeft(cardPlayer);
                            } else if (enumDirection == EnumDirection.RIGHT) {
                                final CityCard cardRight = CardsUtils.getRightCardRoadAvailable(ServiceActionButton.this.listCardsRoad);
                                this.addRoadCardFromPlayerCardsToTheRight(cardPlayer, cardRight);
                            }
                        }
                    }

                    private void addRoadCardFromPlayerCardsToTheRight(final CityCard cardPlayer, CityCard cardLeft) {
                        ServiceActionButton.this.serviceCards.transferOneCityCard(cardPlayer, cardLeft);
                        cardPlayer.clear();
                    }

                    private void addRoadCardFromPlayerCardsToTheLeft(final CityCard cardPlayer) {
                        CardsUtils.moveCardsToTheRight(ServiceActionButton.this.listCardsRoad);
                        final CityCard cardLeft = ServiceActionButton.this.listCardsRoad.get(0);
                        ServiceActionButton.this.serviceCards.transferOneCityCard(cardPlayer, cardLeft);
                        cardPlayer.clear();
                    }

                    private boolean islistCardsRoadEmpty() {
                        for (CityCard card : ServiceActionButton.this.listCardsRoad) {
                            if (StringUtils.isNotBlank(card.getNameCity())) {
                                return false;
                            }
                        }
                        return true;
                    }

                    private boolean islistCardsRoadFull() {
                        return StringUtils.isNotBlank(ServiceActionButton.this.listCardsRoad.get(0).getNameCity())
                                        && StringUtils.isNotBlank(Iterables.getLast(ServiceActionButton.this.listCardsRoad).getNameCity());
                    }
                });
            }
        }
    }
    
    
    public void addActionButtonDiscard() {

        this.creerActionListenerBtnDiscard();
        this.btnDiscard.addActionListener(this.alBtnDiscard);

    }
    
    
    public void addActionButtonBuild() {
        
        this.btnBuild.addActionListener(new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, ConstantesMsgBox.QUESTION_CONFIRM_BUILD, ConstantesMsgBox.QUESTION,
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    // on défause les cartes de la route + les cartes en main qui restent
                    for (CityCard cardRoad : ServiceActionButton.this.listCardsRoad) {
                        ServiceActionButton.this.serviceCards.addCardsToDiscard(ServiceActionButton.this.listCardsDiscarded, cardRoad);
                        cardRoad.clear();
                    }
                    for (CityCard cardPlayer : PlayerUtils.getPlayerEnCours().getListHandCityCards()) {
                        ServiceActionButton.this.serviceCards.addCardsToDiscard(ServiceActionButton.this.listCardsDiscarded, cardPlayer);
                        cardPlayer.clear();
                    }
                }
            }
        });
    }
    
    
    public void addActionButtonRules() {
        // TODO Auto-generated method stub
    }
    
    // ---------------------------------
    // METODES PUBLIQUES : DESACTIVATION
    // ---------------------------------
    
    
    public void removeActionButtonDeckCard() {
        this.btnDeckCard.removeActionListener(this.alBtnDeckCard);
    }
    
    
    public void removeActionButtonDiscard() {
        this.btnDiscard.removeActionListener(this.alBtnDiscard);
    }
    
    
    public void removeActionVisibleCards() {
        for (final CityCard cardVisible : this.listCardsVisible) {
            cardVisible.getCityButton().removeActionListener(this.alBtnCardVisible);
        }
    }

    // ------------------------------
    // METHODES SPECIFIQUES : PRIVEES
    // ------------------------------

    private void initialiserVariables(final AllItems allItems) {
        // services
        this.serviceCards = new ServiceCards();
        // listes
        this.listCardsRoad = allItems.getAllListsCards().getListCardsRoad();
        this.listCardsDiscarded = allItems.getAllListsCards().getListCardsDiscarded();
        this.listCardsVisible = allItems.getAllListsCards().getListCardsVisibles();
        this.listCardsRemaining = allItems.getAllListsCards().getListeCardsRemaining();
        // boutons / labels
        this.btnDeckCard = allItems.getAllButtons().getBtnDeckCard();
        this.btnRules = allItems.getAllButtons().getBtnRules();
        this.btnDiscard = allItems.getAllButtons().getBtnDiscardRoad();
        this.btnBuild = allItems.getAllButtons().getBtnBuildRoad();
        this.lblCardRemaining = allItems.getAllLabels().getLblNbCardRemaining();
    }

    private void creerActionListenerBtnDeckCard() {
        this.alBtnDeckCard = new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(ServiceActionButton.this.listCardsRemaining)) {
                    if (CardsUtils.isListeCardsHandNotFull(PlayerUtils.getPlayerEnCours().getListHandCityCards())) {
                        ServiceActionButton.this.serviceCards.transferOneCityCard(
                                        Iterables.getLast(ServiceActionButton.this.listCardsRemaining),
                                        CardsUtils.getFirstCardHandPlayerAvailable(PlayerUtils.getPlayerEnCours().getListHandCityCards()));
                        ServiceActionButton.this.listCardsRemaining.remove(Iterables
                                        .getLast(ServiceActionButton.this.listCardsRemaining));
                        UpdateUtils.updateLabelCardRemaining(ServiceActionButton.this.lblCardRemaining,
                                        ServiceActionButton.this.getNbCardsRemaining());
                        
                        // on signale que le joueur a pris une carte
                        PlayerUtils.getPlayerEnCours().getActions().setTakeOneCard(true);
                        ServiceActionButton.this.sounds.getSoundTakeCard().play();
                    } else {
                        JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_TAKE_CARDS, ConstantesMsgBox.INFORMATION,
                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    final int option = JOptionPane.showConfirmDialog(null, ConstantesMsgBox.QUESTION_SHUFFLE_CARDS, ConstantesMsgBox.QUESTION,
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        for (CityCard cardVisible : ServiceActionButton.this.listCardsVisible) {
                            ServiceActionButton.this.listCardsDiscarded.add(cardVisible.clone());
                            cardVisible.clear();
                        }
                        ServiceActionButton.this.listCardsRemaining.addAll(ServiceActionButton.this.listCardsDiscarded);
                        ServiceActionButton.this.listCardsDiscarded.clear();
                        Collections.shuffle(ServiceActionButton.this.listCardsRemaining);
                        ServiceActionButton.this.serviceCards.addSixCardsVisible(ServiceActionButton.this.listCardsVisible,
                                        ServiceActionButton.this.listCardsRemaining, ServiceActionButton.this.lblCardRemaining);
                        UpdateUtils.updateLabelCardRemaining(ServiceActionButton.this.lblCardRemaining,
                                        ServiceActionButton.this.getNbCardsRemaining());
                        ServiceActionButton.this.sounds.getSoundShuffleCards().play();
                    }
                }
            }
        };
    }

    private void creerActionListenerBtnDiscard() {
        this.alBtnDiscard = new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, ConstantesMsgBox.QUESTION_CONFIRM_DISCARD, ConstantesMsgBox.QUESTION,
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    for (CityCard cardRoad : ServiceActionButton.this.listCardsRoad) {
                        ServiceActionButton.this.serviceCards.addCardsToDiscard(ServiceActionButton.this.listCardsDiscarded, cardRoad);
                        cardRoad.clear();
                    }
                }
            }
        };
    }

    private int getNbCardsRemaining() {
        return this.listCardsRemaining.size();
    }

}
