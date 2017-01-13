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
import com.project.thurnandtaxis.data.beans.AllButtons;
import com.project.thurnandtaxis.data.beans.AllLabels;
import com.project.thurnandtaxis.data.beans.AllListsCards;
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
    
    private AllListsCards listsCards;// TODO A VIRER

    public ServiceActionButtonImpl(AllButtons allButtons, AllLabels allLabels, AllListsCards listsCards) {
        this.serviceCards = new ServiceCards();
        this.listCardsRoad = listsCards.getListCardsRoad();
        this.listCardsDiscarded = listsCards.getListCardsDiscarded();
        this.listCardsVisible = listsCards.getListCardsVisibles();
        this.listCardsRemaining = listsCards.getListeCardsRemaining();
        this.listsCards = listsCards;
        this.btnDeckCard = allButtons.getBtnDeckCard();
        this.lblCardRemaining = allLabels.getLblNbCardRemaining();
    }

    @Override
    public void addActionButtonDeckCard(final Player player, final List<CityCard> listCardRemaining) {
        this.btnDeckCard.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(listCardRemaining)) {
                    if (ServiceActionButtonImpl.this.isListeCardsHandFull(player.getListHandCityCards())) {
                        ServiceActionButtonImpl.this.serviceCards.transferOneCityCard(player.getListHandCityCards(),
                                        Iterables.getLast(listCardRemaining));
                        System.out.println("AVANT taille liste dans AllListsCards - listCardsRemaining > "
                                        + ServiceActionButtonImpl.this.listsCards.getListeCardsRemaining().size());
                        listCardRemaining.remove(Iterables.getLast(listCardRemaining));
                        System.out.println("APRES taille liste dans AllListsCards - listCardsRemaining > "
                                        + ServiceActionButtonImpl.this.listsCards.getListeCardsRemaining().size());
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
                        listCardRemaining.addAll(ServiceActionButtonImpl.this.listCardsDiscarded);
                        ServiceActionButtonImpl.this.listCardsDiscarded.clear();
                        Collections.shuffle(listCardRemaining);
                        UpdateUtils.updateLabelCardRemaining(ServiceActionButtonImpl.this.lblCardRemaining,
                                        ServiceActionButtonImpl.this.getNbCardsRemaining());
                    }
                }
            }
            
        });
    }

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
