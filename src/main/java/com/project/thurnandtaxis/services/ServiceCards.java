package com.project.thurnandtaxis.services;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;

public class ServiceCards {
    
    public void takeOneCityCard(final Player player, final List<CityCard> listCardRemaining, List<CityCard> listCardsHand) {
        CityCard cityCard = this.addCityCardToCardPlayer(player, listCardRemaining);
        this.addCityCardToCardHand(cityCard, listCardsHand);
    }

    public CityCard addCityCardToCardPlayer(final Player player, final List<CityCard> listCardRemaining) {

        final CityCard cardToPlayer = Iterables.getLast(listCardRemaining).clone();
        player.getListHandCityCards().add(cardToPlayer);
        listCardRemaining.remove(Iterables.getLast(listCardRemaining));
        return cardToPlayer;
    }
    
    public void addCityCardToCardHand(final CityCard cityCard, final List<CityCard> listCardsHand) {

        for (CityCard cardHand : listCardsHand) {
            if (StringUtils.isBlank(cardHand.getNameCity())) {
                cardHand.cloneWithButton(cityCard);
                break;
            }
        }
    }
    
    public void addCardVisible(List<CityCard> listCardRemaining, CityCard cardVisible) {
        cardVisible.cloneWithButton(Iterables.getLast(listCardRemaining).clone());
    }
    
    public List<CityCard> shuffleCardsFromDiscard(List<CityCard> listCardsDiscarded) {
        Collections.shuffle(listCardsDiscarded);
        return listCardsDiscarded;
    }
    
    public void addCardsToDiscard(List<CityCard> listCardsDiscarded, CityCard cardVisible) {
        listCardsDiscarded.add(cardVisible);
    }
    
}
