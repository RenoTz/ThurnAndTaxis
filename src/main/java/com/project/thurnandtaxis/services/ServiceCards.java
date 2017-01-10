package com.project.thurnandtaxis.services;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;

public class ServiceCards {

    public void addCityCardToCardPlayer(final Player player, final List<CityCard> listCardRemaining) {
        
        final CityCard cardToPlayer = new CityCard();
        cardToPlayer.setColorProvince(Iterables.getLast(listCardRemaining).getColorProvince());
        cardToPlayer.setImage(Iterables.getLast(listCardRemaining).getImage());
        cardToPlayer.setNameCity(Iterables.getLast(listCardRemaining).getNameCity());
        cardToPlayer.setNameProvince(Iterables.getLast(listCardRemaining).getNameProvince());

        player.getListHandCityCards().add(cardToPlayer);
    }

    public void hiddenCardCatchInListCardsRemaining(List<CityCard> listCardRemaining) {
        Collections.reverse(listCardRemaining);
        for (CityCard card : listCardRemaining) {
            if (!card.isHidden()) {
                card.setHidden(true);
                break;
            }
        }
        Collections.reverse(listCardRemaining);
    }

}
