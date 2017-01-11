package com.project.thurnandtaxis.services;

import java.util.Collections;
import java.util.List;

import javax.swing.JButton;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;

public class ServiceCards {

    public void addCityCardToCardPlayer(final Player player, final List<CityCard> listCardRemaining) {
        
        final CityCard cardToPlayer = getLast(listCardRemaining).clone();
        player.getListHandCityCards().add(cardToPlayer);
    }

    public void addSixCardsVisible(List<CityCard> listCardRemaining, List<JButton> listeCardsVisible) {
        
        for (JButton button : listeCardsVisible) {
            button.setIcon(getLast(listCardRemaining).getImage());
            button.setToolTipText(Iterables.getLast(listCardRemaining).getNameCity());
        }
    }

    private static CityCard getLast(List<CityCard> listCardRemaining) {
        
        Collections.reverse(listCardRemaining);
        CityCard retour = new CityCard();

        for (CityCard card : listCardRemaining) {
            if (!card.isHidden()) {
                retour = card.clone();
                card.setHidden(true);
                break;
            }
        }
        Collections.reverse(listCardRemaining);
        return retour;
    }

}
