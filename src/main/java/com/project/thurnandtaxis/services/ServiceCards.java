package com.project.thurnandtaxis.services;

import java.util.List;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;

public class ServiceCards {

    public void takeOneCityCard(final Player player, final List<CityCard> listCardRemaining, List<JButton> listCardsHand) {
        this.addCityCardToCardPlayer(player, listCardRemaining);
        this.addCityCardToCardHand(player, listCardsHand);
    }
    
    public void addCityCardToCardPlayer(final Player player, final List<CityCard> listCardRemaining) {
        
        final CityCard cardToPlayer = Iterables.getLast(listCardRemaining).clone();
        player.getListHandCityCards().add(cardToPlayer);
        listCardRemaining.remove(Iterables.getLast(listCardRemaining));
    }

    public void addCityCardToCardHand(final Player player, final List<JButton> listCardsHand) {
        
        clear(listCardsHand);
        for (CityCard cardPlayer : player.getListHandCityCards()) {
            this.addCardTolistCardsHand(cardPlayer, listCardsHand);
        }
    }

    private static void clear(List<JButton> listCardsHand) {
        for (JButton btn : listCardsHand) {
            btn.setIcon(null);
            btn.setToolTipText(StringUtils.EMPTY);
        }
    }

    private void addCardTolistCardsHand(CityCard cardToHand, List<JButton> listCardsHand) {
        for (JButton btn : listCardsHand) {
            if (StringUtils.isBlank(btn.getToolTipText())) {
                btn.setIcon(cardToHand.getImage());
                btn.setToolTipText(cardToHand.getNameCity());
                break;
            }
        }
    }

    public void addCardVisible(List<CityCard> listCardRemaining, JButton cardVisible) {
        cardVisible.setIcon(Iterables.getLast(listCardRemaining).getImage());
        cardVisible.setToolTipText(Iterables.getLast(listCardRemaining).getNameCity());
    }

}
