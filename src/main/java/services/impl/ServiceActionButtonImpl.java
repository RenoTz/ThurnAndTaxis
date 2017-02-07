package services.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import services.ServiceActionButton;
import services.ServiceCards;
import services.ServiceJoueur;
import utils.CardsUtils;
import utils.UpdateUtils;

import com.google.common.collect.Iterables;

import controler.Sounds;
import data.beans.principal.AllItems;
import data.beans.secondaire.Adjacence;
import data.beans.secondaire.CityCard;
import data.beans.secondaire.Player;
import data.constantes.ConstantesMsgBox;
import data.enumerations.EnumDirection;

public class ServiceActionButtonImpl implements ServiceActionButton {
    
    protected static final String LEFT = "left";
    protected static final String RIGHT = "right";
    protected static final int CARD_TO_LEFT = 0;
    protected static final int CARD_TO_RIGHT = 1;
    
    private ServiceCards serviceCards;
    private ServiceJoueur serviceJoueur;
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
    private ActionListener alBtnCardVisible;

    public ServiceActionButtonImpl(AllItems allItems, Sounds sounds) {
        this.initialiserVariables(allItems);
        this.creerActionListenerBtnDeckCard();
        this.sounds = sounds;
    }
    
    @Override
    public void addActionButtonDeckCard() {
        this.btnDeckCard.addActionListener(this.alBtnDeckCard);
    }

    @Override
    public void removeActionButtonDeckCard() {
        this.btnDeckCard.removeActionListener(this.alBtnDeckCard);
    }
    
    private void creerActionListenerBtnDeckCard() {
        this.alBtnDeckCard = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(ServiceActionButtonImpl.this.listCardsRemaining)) {
                    if (CardsUtils.isListeCardsHandNotFull(ServiceActionButtonImpl.this.serviceJoueur.getPlayerEnCours().getListHandCityCards())) {
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(Iterables
                                        .getLast(ServiceActionButtonImpl.this.listCardsRemaining), CardsUtils
                                        .getFirstCardHandPlayerAvailable(ServiceActionButtonImpl.this.serviceJoueur.getPlayerEnCours()
                                                        .getListHandCityCards()));
                        ServiceActionButtonImpl.this.listCardsRemaining.remove(Iterables
                                        .getLast(ServiceActionButtonImpl.this.listCardsRemaining));
                        UpdateUtils.updateLabelCardRemaining(ServiceActionButtonImpl.this.lblCardRemaining,
                                        ServiceActionButtonImpl.this.getNbCardsRemaining());
                        
                        // on signale que le joueur a pris une carte
                        ServiceActionButtonImpl.this.serviceJoueur.getPlayerEnCours().getActions().setTakeOneCard(true);
                        ServiceActionButtonImpl.this.sounds.getSoundTakeCard().play();
                    } else {
                        JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_TAKE_CARDS, ConstantesMsgBox.INFORMATION,
                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    final int option = JOptionPane.showConfirmDialog(null, ConstantesMsgBox.QUESTION_SHUFFLE_CARDS, ConstantesMsgBox.QUESTION,
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        for (CityCard cardVisible : ServiceActionButtonImpl.this.listCardsVisible) {
                            ServiceActionButtonImpl.this.listCardsDiscarded.add(cardVisible.clone());
                            cardVisible.clear();
                        }
                        ServiceActionButtonImpl.this.listCardsRemaining.addAll(ServiceActionButtonImpl.this.listCardsDiscarded);
                        ServiceActionButtonImpl.this.listCardsDiscarded.clear();
                        Collections.shuffle(ServiceActionButtonImpl.this.listCardsRemaining);
                        ServiceActionButtonImpl.this.serviceCards.addSixCardsVisible(ServiceActionButtonImpl.this.listCardsVisible,
                                        ServiceActionButtonImpl.this.listCardsRemaining, ServiceActionButtonImpl.this.lblCardRemaining);
                        UpdateUtils.updateLabelCardRemaining(ServiceActionButtonImpl.this.lblCardRemaining,
                                        ServiceActionButtonImpl.this.getNbCardsRemaining());
                        ServiceActionButtonImpl.this.sounds.getSoundShuffleCards().play();
                    }
                }
            }
        };
    }
    
    /**
     * ActionListener sur <strong>buttonCardVisible</strong> permettant de sélectionner une carte à partir des cartes visibles. <br>
     * 1 - on transfère la carte visible dans les cartes en main du joueur <br>
     * 2 - on nettoie la carte visible, sans la supprimer <br>
     * 3 - on transfère une carte du tas de cartes sur la carte visible <br>
     * 4 - on supprime la carte prise précédemment <br>
     * 5 - on met à jour le label du nombre de cartes restantes <br>
     */
    @Override
    public void addActionVisibleCards() {
        
        for (final CityCard cardVisible : this.listCardsVisible) {
            this.alBtnCardVisible = new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (CardsUtils.isListeCardsHandNotFull(ServiceActionButtonImpl.this.serviceJoueur.getPlayerEnCours().getListHandCityCards())) {
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(cardVisible, CardsUtils
                                        .getFirstCardHandPlayerAvailable(ServiceActionButtonImpl.this.serviceJoueur.getPlayerEnCours()
                                                        .getListHandCityCards()));

                        for (CityCard cardToClear : ServiceActionButtonImpl.this.listCardsVisible) {
                            if (cardVisible.equals(cardToClear)) {
                                cardVisible.clear();
                                if (CollectionUtils.isNotEmpty(ServiceActionButtonImpl.this.listCardsRemaining)) {
                                    ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(
                                                    Iterables.getLast(ServiceActionButtonImpl.this.listCardsRemaining), cardVisible);
                                    ServiceActionButtonImpl.this.listCardsRemaining.remove(Iterables
                                                    .getLast(ServiceActionButtonImpl.this.listCardsRemaining));
                                    UpdateUtils.updateLabelCardRemaining(ServiceActionButtonImpl.this.lblCardRemaining,
                                                    ServiceActionButtonImpl.this.getNbCardsRemaining());
                                }
                                break;
                            }
                        }
                        // on signale que le joueur a pris une carte
                        ServiceActionButtonImpl.this.serviceJoueur.getPlayerEnCours().getActions().setTakeOneCard(true);
                        ServiceActionButtonImpl.this.sounds.getSoundTakeCard().play();
                    } else {
                        JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_TAKE_CARDS, ConstantesMsgBox.INFORMATION,
                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            };
            cardVisible.getCityButton().addActionListener(this.alBtnCardVisible);
        }
        
    }

    @Override
    public void removeActionVisibleCards() {
        for (final CityCard cardVisible : this.listCardsVisible) {
            cardVisible.getCityButton().removeActionListener(this.alBtnCardVisible);
        }
    }

    @Override
    public void addActionButtonPlayersCards(final List<Adjacence> listAdjacences, final List<Player> listPlayers) {

        for (Player player : listPlayers) {
            for (final CityCard cardPlayer : player.getListHandCityCards()) {
                cardPlayer.getCityButton().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (this.islistCardsRoadEmpty()) {
                            final CityCard cardRoad = ServiceActionButtonImpl.this.listCardsRoad.get(0);
                            this.addRoadCardFromPlayerCardsToTheRight(cardPlayer, cardRoad);
                        } else if (this.islistCardsRoadFull()) {
                            JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_PLACE_ADDITIONAL_CARDS,
                                            ConstantesMsgBox.INFORMATION, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // controle si possible de poser la carte
                            EnumDirection enumDirection = CardsUtils.isPossibleToPutCard(ServiceActionButtonImpl.this.listCardsRoad,
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
                                final CityCard cardRight = CardsUtils.getRightCardRoadAvailable(ServiceActionButtonImpl.this.listCardsRoad);
                                this.addRoadCardFromPlayerCardsToTheRight(cardPlayer, cardRight);
                            }
                        }
                    }

                    private void addRoadCardFromPlayerCardsToTheRight(final CityCard cardPlayer, CityCard cardLeft) {
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(cardPlayer, cardLeft);
                        cardPlayer.clear();
                    }

                    private void addRoadCardFromPlayerCardsToTheLeft(final CityCard cardPlayer) {
                        CardsUtils.moveCardsToTheRight(ServiceActionButtonImpl.this.listCardsRoad);
                        final CityCard cardLeft = ServiceActionButtonImpl.this.listCardsRoad.get(0);
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(cardPlayer, cardLeft);
                        cardPlayer.clear();
                    }

                    private boolean islistCardsRoadEmpty() {
                        for (CityCard card : ServiceActionButtonImpl.this.listCardsRoad) {
                            if (StringUtils.isNotBlank(card.getNameCity())) {
                                return false;
                            }
                        }
                        return true;
                    }

                    private boolean islistCardsRoadFull() {
                        return StringUtils.isNotBlank(ServiceActionButtonImpl.this.listCardsRoad.get(0).getNameCity())
                                        && StringUtils.isNotBlank(Iterables.getLast(ServiceActionButtonImpl.this.listCardsRoad).getNameCity());
                    }
                });
            }
        }
    }
    
    @Override
    public void addActionButtonDiscard() {

        this.btnDiscard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, ConstantesMsgBox.QUESTION_CONFIRM_DISCARD, ConstantesMsgBox.QUESTION,
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    for (CityCard cardRoad : ServiceActionButtonImpl.this.listCardsRoad) {
                        ServiceActionButtonImpl.this.serviceCards.addCardsToDiscard(ServiceActionButtonImpl.this.listCardsDiscarded, cardRoad);
                        cardRoad.clear();
                    }
                }
            }
        });

    }

    @Override
    public void addActionButtonBuild() {
        
        this.btnBuild.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, ConstantesMsgBox.QUESTION_CONFIRM_BUILD, ConstantesMsgBox.QUESTION,
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    // on défause les cartes de la route + les cartes en main qui restent
                    for (CityCard cardRoad : ServiceActionButtonImpl.this.listCardsRoad) {
                        ServiceActionButtonImpl.this.serviceCards.addCardsToDiscard(ServiceActionButtonImpl.this.listCardsDiscarded, cardRoad);
                        cardRoad.clear();
                    }
                    for (CityCard cardPlayer : ServiceActionButtonImpl.this.serviceJoueur.getPlayerEnCours().getListHandCityCards()) {
                        ServiceActionButtonImpl.this.serviceCards.addCardsToDiscard(ServiceActionButtonImpl.this.listCardsDiscarded, cardPlayer);
                        cardPlayer.clear();
                    }
                }
            }
        });
    }
    
    @Override
    public void addActionButtonRules() {
        // TODO Auto-generated method stub
    }

    private void initialiserVariables(AllItems allItems) {
        // services
        this.serviceCards = new ServiceCardsImpl();
        this.serviceJoueur = new ServiceJoueurImpl();
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

    private int getNbCardsRemaining() {
        return this.listCardsRemaining.size();
    }

}
