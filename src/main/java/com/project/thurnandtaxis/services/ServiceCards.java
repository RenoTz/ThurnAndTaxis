package com.project.thurnandtaxis.services;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.CityCard;

public class ServiceCards {

    public void transferOneCityCard(final List<CityCard> listCardsTarget, final CityCard card) {
        final CityCard cardToClone = card.clone();
        this.addCityCardToCardPlayer(listCardsTarget, cardToClone);
    }
    
    public void addCityCardToCardPlayer(final List<CityCard> listPlayerCards, final CityCard cardToClone) {

        for (CityCard playerCard : listPlayerCards) {
            if (StringUtils.isBlank(playerCard.getNameCity())) {
                playerCard.cloneWithButton(cardToClone);
                break;
            }
        }
    }

    public void addCityCardToCardRoad(final List<CityCard> listCardsRoad, final CityCard cityCard) {
        
        for (CityCard cardRoad : listCardsRoad) {
            if (StringUtils.isBlank(cardRoad.getNameCity())) {
                cardRoad.cloneWithButton(cityCard);
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
