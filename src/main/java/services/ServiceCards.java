package services;

import java.util.List;

import javax.swing.JLabel;

import data.beans.secondaire.CityCard;

public interface ServiceCards {
    
    void transferOneCityCard(final CityCard cardSource, final CityCard cardCible);

    void addCardsToDiscard(final List<CityCard> listCardsDiscarded, final CityCard cardVisible);

    void addSixCardsVisible(final List<CityCard> listCardsVisible, final List<CityCard> listCardsRemaining, final JLabel lblCardRemaining);

    List<CityCard> shuffleListCards(final List<CityCard> listCards);
    
}
