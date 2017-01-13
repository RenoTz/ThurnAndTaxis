package com.project.thurnandtaxis.services.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.AllItems;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;
import com.project.thurnandtaxis.data.constantes.ConstantesMsgBox;
import com.project.thurnandtaxis.services.ServiceActionButton;
import com.project.thurnandtaxis.services.ServiceCards;
import com.project.thurnandtaxis.utils.UpdateUtils;

public class ServiceActionButtonImpl implements ServiceActionButton {
    
    private ServiceCards serviceCards;
    private JButton btnDeckCard;
    private JLabel lblCardRemaining;
    private List<CityCard> listCardsRoad;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listCardsVisible;
    private List<CityCard> listCardsRemaining;

    public ServiceActionButtonImpl(AllItems allItems) {
        this.serviceCards = new ServiceCards();
        this.listCardsRoad = allItems.getAllListsCards().getListCardsRoad();
        this.listCardsDiscarded = allItems.getAllListsCards().getListCardsDiscarded();
        this.listCardsVisible = allItems.getAllListsCards().getListCardsVisibles();
        this.listCardsRemaining = allItems.getAllListsCards().getListeCardsRemaining();
        this.btnDeckCard = allItems.getAllButtons().getBtnDeckCard();
        this.lblCardRemaining = allItems.getAllLabels().getLblNbCardRemaining();
    }
    
    @Override
    public void addActionButtonDeckCard(final Player player) {
        this.btnDeckCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(ServiceActionButtonImpl.this.listCardsRemaining)) {
                    if (ServiceActionButtonImpl.this.isListeCardsHandFull(player.getListHandCityCards())) {
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(player.getListHandCityCards(),
                                        Iterables.getLast(ServiceActionButtonImpl.this.listCardsRemaining));
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
                    if (option == JOptionPane.OK_OPTION) {
                        for (CityCard cardVisible : ServiceActionButtonImpl.this.listCardsVisible) {
                            ServiceActionButtonImpl.this.listCardsDiscarded.add(cardVisible.clone());
                            cardVisible.clear();
                        }
                        ServiceActionButtonImpl.this.listCardsRemaining.addAll(ServiceActionButtonImpl.this.listCardsDiscarded);
                        ServiceActionButtonImpl.this.listCardsDiscarded.clear();
                        Collections.shuffle(ServiceActionButtonImpl.this.listCardsRemaining);
                        this.addSixCardsVisible();
                        UpdateUtils.updateLabelCardRemaining(ServiceActionButtonImpl.this.lblCardRemaining,
                                        ServiceActionButtonImpl.this.getNbCardsRemaining());
                    }
                }
            }
            
            private void addSixCardsVisible() {
                // ajout des six cartes visibles
                for (CityCard cardVisible : ServiceActionButtonImpl.this.listCardsVisible) {
                    ServiceActionButtonImpl.this.serviceCards.addCardVisible(ServiceActionButtonImpl.this.listCardsRemaining, cardVisible);
                    ServiceActionButtonImpl.this.listCardsRemaining.remove(Iterables.getLast(ServiceActionButtonImpl.this.listCardsRemaining));
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
    public void addActionButtonCardVisible(final Player player) {
        
        for (final CityCard card : this.listCardsVisible) {
            card.getCityButton().addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(player.getListHandCityCards(), card);

                    for (CityCard cardToClear : ServiceActionButtonImpl.this.listCardsVisible) {
                        if (card.equals(cardToClear)) {
                            card.clear();
                            ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(ServiceActionButtonImpl.this.listCardsVisible,
                                            Iterables.getLast(ServiceActionButtonImpl.this.listCardsRemaining));
                            ServiceActionButtonImpl.this.listCardsRemaining.remove(Iterables
                                            .getLast(ServiceActionButtonImpl.this.listCardsRemaining));
                            UpdateUtils.updateLabelCardRemaining(ServiceActionButtonImpl.this.lblCardRemaining,
                                            ServiceActionButtonImpl.this.getNbCardsRemaining());
                            break;
                        }
                    }
                }

            });
        }
        
    }

    private int getNbCardsRemaining() {
        return ServiceActionButtonImpl.this.listCardsRemaining.size();
    }

    private boolean isListeCardsHandFull(List<CityCard> listCardsHand) {
        for (CityCard btn : listCardsHand) {
            if (StringUtils.isBlank(btn.getNameCity())) {
                return true;
            }
        }
        return false;
    }

}
