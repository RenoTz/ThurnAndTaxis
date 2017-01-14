package com.project.thurnandtaxis.services.impl;

import java.util.Collections;
import java.util.List;

import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.services.ServiceCards;

public class ServiceCardsImpl implements ServiceCards {
    
    @Override
    public void transferOneCityCard(final CityCard cardSource, final CityCard cardCible) {
        cardCible.cloneWithButton(cardSource);
    }

    @Override
    public List<CityCard> shuffleCardsFromDiscard(List<CityCard> listCardsDiscarded) {
        Collections.shuffle(listCardsDiscarded);
        return listCardsDiscarded;
    }
    
    @Override
    public void addCardsToDiscard(List<CityCard> listCardsDiscarded, CityCard cardVisible) {
        listCardsDiscarded.add(cardVisible.clone());
    }
    
}
