package services.impl;

import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;

import org.apache.commons.collections.CollectionUtils;

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
    public List<CityCard> shuffleListCards(final List<CityCard> listCards) {
        Collections.shuffle(listCards);
        return listCards;
    }

    @Override
    public void addCardsToDiscard(final List<CityCard> listCardsDiscarded, final CityCard cardToDiscard) {
        listCardsDiscarded.add(cardToDiscard.clone());
    }
    
    @Override
    public void addSixCardsVisible(final List<CityCard> listCardsVisible, final List<CityCard> listCardsRemaining, final JLabel lblCardRemaining) {
        
        for (CityCard cardVisible : listCardsVisible) {
            if (CollectionUtils.isNotEmpty(listCardsRemaining)) {
                this.transferOneCityCard(Iterables.getLast(listCardsRemaining), cardVisible);
                listCardsRemaining.remove(Iterables.getLast(listCardsRemaining));
                UpdateUtils.updateLabelCardRemaining(lblCardRemaining, listCardsRemaining.size());
            }
        }
    }

}
