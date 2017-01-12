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
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;
import com.project.thurnandtaxis.data.constantes.ConstantesMsgBox;
import com.project.thurnandtaxis.services.ServiceActionButton;
import com.project.thurnandtaxis.services.ServiceCards;

public class ServiceActionButtonImpl implements ServiceActionButton {
    
    private ServiceCards serviceCards;
    private JButton btnDeckCard;
    private static JLabel lblCardRemaining;
    private List<CityCard> listCardsHand;
    private List<CityCard> listCardsRoad;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listCardsVisible;
    
    public ServiceActionButtonImpl(final JButton btnDeckCard, JLabel lblCardRemaining, List<CityCard> listCardsHand,
        List<CityCard> listCardsRoad, List<CityCard> listCardsDiscarded, List<CityCard> listCardsVisible) {
        this.serviceCards = new ServiceCards();
        this.btnDeckCard = btnDeckCard;
        ServiceActionButtonImpl.lblCardRemaining = lblCardRemaining;
        this.listCardsHand = listCardsHand;
        this.listCardsRoad = listCardsRoad;
        this.listCardsDiscarded = listCardsDiscarded;
        this.listCardsVisible = listCardsVisible;
    }
    
    @Override
    public void addActionButtonDeckCard(final Player player, final List<CityCard> listCardRemaining) {
        this.btnDeckCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(listCardRemaining)) {
                    if (ServiceActionButtonImpl.this.isListeCardsHandFull(ServiceActionButtonImpl.this.listCardsHand)) {
                        ServiceActionButtonImpl.this.serviceCards.takeOneCityCard(player, Iterables.getLast(listCardRemaining));
                        listCardRemaining.remove(Iterables.getLast(listCardRemaining));
                        ServiceActionButtonImpl.updateLabelCardRemaining(listCardRemaining);
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
                        ServiceActionButtonImpl.updateLabelCardRemaining(listCardRemaining);
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
                    ServiceActionButtonImpl.this.serviceCards.takeOneCityCard(player, card);
                    for (CityCard cardRemove : ServiceActionButtonImpl.this.listCardsDiscarded) {
                        if (card.equals(cardRemove)) {
                            ServiceActionButtonImpl.this.listCardsDiscarded.remove(cardRemove);
                            break;
                        }
                    }
                }
            });
        }
        
    }

    protected static void updateLabelCardRemaining(List<CityCard> listCardRemaining) {
        lblCardRemaining.setText(String.valueOf(listCardRemaining.size()));
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
