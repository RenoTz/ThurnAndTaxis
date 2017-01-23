package services.impl;

import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;

import services.ServiceCards;
import utils.UpdateUtils;

import com.google.common.collect.Iterables;

import data.beans.secondaire.CityCard;

public class ServiceCardsImpl implements ServiceCards {
    
    @Override
    public void transferOneCityCard(final CityCard cardSource, final CityCard cardCible) {
        cardCible.cloneWithButton(cardSource);
    }

    @Override
    public List<CityCard> shuffleListCards(List<CityCard> listCards) {
        Collections.shuffle(listCards);
        return listCards;
    }
    
    @Override
    public void addCardsToDiscard(List<CityCard> listCardsDiscarded, CityCard cardVisible) {
        listCardsDiscarded.add(cardVisible.clone());
    }

    @Override
    public void addSixCardsVisible(List<CityCard> listCardsVisible, List<CityCard> listCardsRemaining, JLabel lblCardRemaining) {
        for (CityCard cardVisible : listCardsVisible) {
            this.transferOneCityCard(Iterables.getLast(listCardsRemaining), cardVisible);
            listCardsRemaining.remove(Iterables.getLast(listCardsRemaining));
            UpdateUtils.updateLabelCardRemaining(lblCardRemaining, listCardsRemaining.size());
        }
    }
    
}
