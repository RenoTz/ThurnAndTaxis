package com.project.thurnandtaxis.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;

public class ServiceActionButton {
    
    private ServiceCards serviceCards;
    
    public ServiceActionButton() {
        this.serviceCards = new ServiceCards();
    }
    
    public void addActionButtonDeckCard(final JButton btnDeckCard, final Player player, final List<CityCard> listCardRemaining) {
        btnDeckCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceActionButton.this.serviceCards.addCityCardToCardPlayer(player, listCardRemaining);
                ServiceActionButton.this.serviceCards.hiddenCardCatchInListCardsRemaining(listCardRemaining);
                ServiceActionButton.this.updateToolTipButtonDeckCard(listCardRemaining, btnDeckCard);
            }
        });
    }
    
    protected void updateToolTipButtonDeckCard(List<CityCard> listCardRemaining, JButton btnDeckCard) {
        btnDeckCard.setToolTipText(this.getSizeListeCardsRemaining(listCardRemaining) + " cards remaining");
    }

    private int getSizeListeCardsRemaining(final List<CityCard> listCardRemaining) {

        int size = 0;
        for (CityCard card : listCardRemaining) {
            if (!card.isHidden()) {
                size++;
            }
        }
        return size;
    }
}
