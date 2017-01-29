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
import utils.CardsUtils;
import utils.UpdateUtils;

import com.google.common.collect.Iterables;

import data.beans.principal.AllItems;
import data.beans.principal.AllPlayers;
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
    private JButton btnDeckCard;
    private JButton btnRules;
    private JButton btnDiscard;
    private JButton btnBuild;
    private JLabel lblCardRemaining;
    private List<CityCard> listCardsRoad;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listCardsVisible;
    private List<CityCard> listCardsRemaining;

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    public ServiceActionButtonImpl(AllItems allItems, AllPlayers allPlayers) {
        this.serviceCards = new ServiceCardsImpl();
        this.initialiserVariables(allItems, allPlayers);
    }
    
    @Override
    public void addActionButtonDeckCard() {
        this.btnDeckCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(ServiceActionButtonImpl.this.listCardsRemaining)) {
                    if (CardsUtils.isListeCardsHandNotFull(ServiceActionButtonImpl.this.player1.getListHandCityCards())) {
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(
                                        Iterables.getLast(ServiceActionButtonImpl.this.listCardsRemaining),
                                        CardsUtils.getFirstCardHandPlayerAvailable(ServiceActionButtonImpl.this.player1.getListHandCityCards()));
                        ServiceActionButtonImpl.this.listCardsRemaining.remove(Iterables
                                        .getLast(ServiceActionButtonImpl.this.listCardsRemaining));
                        UpdateUtils.updateLabelCardRemaining(ServiceActionButtonImpl.this.lblCardRemaining,
                                        ServiceActionButtonImpl.this.getNbCardsRemaining());
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
                    }
                }
            }
            
        });
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
    public void addActionButtonCardVisible() {
        
        for (final CityCard cardVisible : this.listCardsVisible) {
            cardVisible.getCityButton().addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (CardsUtils.isListeCardsHandNotFull(ServiceActionButtonImpl.this.player1.getListHandCityCards())) {
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(cardVisible,
                                        CardsUtils.getFirstCardHandPlayerAvailable(ServiceActionButtonImpl.this.player1.getListHandCityCards()));
                        
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
                    } else {
                        JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_TAKE_CARDS, ConstantesMsgBox.INFORMATION,
                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            });
        }
        
    }

    @Override
    public void addActionButtonPlayersCards(final List<Adjacence> listAdjacences) {

        for (final CityCard cardPlayer : this.player1.getListHandCityCards()) {
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
                        // TODO controle faisabilité posage de carte
                        EnumDirection enumDirection = CardsUtils.isPossibleToPutCard(ServiceActionButtonImpl.this.listCardsRoad, listAdjacences,
                                        cardPlayer);
                        if (enumDirection == EnumDirection.NEANT) {
                            JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_DONT_PLACE_THIS_CARD, ConstantesMsgBox.INFORMATION,
                                            JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (enumDirection == EnumDirection.LEFT_OR_RIGHT) {
                            final int option = JOptionPane.showOptionDialog(null, ConstantesMsgBox.QUESTION_RIGHT_OR_LEFT, "Put your card", 0,
                                            JOptionPane.QUESTION_MESSAGE, null, ConstantesMsgBox.OPTIONS_LEFT_RIGHT, null);
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
                    serviceCards.transferOneCityCard(cardPlayer, cardLeft);
                    cardPlayer.clear();
                }

                private void addRoadCardFromPlayerCardsToTheLeft(final CityCard cardPlayer) {
                    CardsUtils.moveCardsToTheRight(listCardsRoad);
                    final CityCard cardLeft = listCardsRoad.get(0);
                    serviceCards.transferOneCityCard(cardPlayer, cardLeft);
                    cardPlayer.clear();
                }
                
                private boolean islistCardsRoadEmpty() {
                    for (CityCard card : listCardsRoad) {
                        if (StringUtils.isNotBlank(card.getNameCity())) {
                            return false;
                        }
                    }
                    return true;
                }
                
                private boolean islistCardsRoadFull() {
                    return StringUtils.isNotBlank(listCardsRoad.get(0).getNameCity())
                                    && StringUtils.isNotBlank(Iterables.getLast(listCardsRoad).getNameCity());
                }
            });
        }
    }
    
    @Override
	public void addActionButtonDiscard() {
		
		btnDiscard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, ConstantesMsgBox.QUESTION_CONFIRM_DISCARD, ConstantesMsgBox.QUESTION,
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.YES_OPTION){
					for (CityCard cardRoad : listCardsRoad) {
			            serviceCards.addCardsToDiscard(listCardsDiscarded,
			                            cardRoad);
			        }
				}
			}
		});
		
	}

	@Override
	public void addActionButtonBuild() {
		// TODO Auto-generated method stub
		
	}
    
    @Override
    public void addActionButtonRules() {
        // TODO Auto-generated method stub
    }
    
    private void initialiserVariables(AllItems allItems, AllPlayers allPlayers) {
        this.listCardsRoad = allItems.getAllListsCards().getListCardsRoad();
        this.listCardsDiscarded = allItems.getAllListsCards().getListCardsDiscarded();
        this.listCardsVisible = allItems.getAllListsCards().getListCardsVisibles();
        this.listCardsRemaining = allItems.getAllListsCards().getListeCardsRemaining();
        this.btnDeckCard = allItems.getAllButtons().getBtnDeckCard();
        this.btnRules = allItems.getAllButtons().getBtnRules();
        this.btnDiscard = allItems.getAllButtons().getBtnDiscardRoad();
        this.btnBuild = allItems.getAllButtons().getBtnBuildRoad();
        this.lblCardRemaining = allItems.getAllLabels().getLblNbCardRemaining();
        this.player1 = allPlayers.getPlayer1();
        this.player2 = allPlayers.getPlayer2();
        this.player3 = allPlayers.getPlayer3();
        this.player4 = allPlayers.getPlayer4();
    }

    private int getNbCardsRemaining() {
        return this.listCardsRemaining.size();
    }

}
