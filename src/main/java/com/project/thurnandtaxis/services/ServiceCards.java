package com.project.thurnandtaxis.services;

import java.util.List;

import com.project.thurnandtaxis.data.beans.CityCard;

public interface ServiceCards {
    
    void transferOneCityCard(final CityCard cardSource, final CityCard cardCible);
    
    void addCardsToDiscard(List<CityCard> listCardsDiscarded, CityCard cardVisible);
    
    List<CityCard> shuffleCardsFromDiscard(List<CityCard> listCardsDiscarded);

}
