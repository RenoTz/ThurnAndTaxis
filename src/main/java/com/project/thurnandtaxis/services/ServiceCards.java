package com.project.thurnandtaxis.services;

import java.util.List;

import javax.swing.JLabel;

import com.project.thurnandtaxis.data.beans.secondaire.CityCard;

public interface ServiceCards {

    void transferOneCityCard(final CityCard cardSource, final CityCard cardCible);

    void addCardsToDiscard(List<CityCard> listCardsDiscarded, CityCard cardVisible);

    void addSixCardsVisible(List<CityCard> listCardsVisible, List<CityCard> listCardsRemaining, JLabel lblCardRemaining);

    List<CityCard> shuffleListCards(List<CityCard> listCards);
    
}
