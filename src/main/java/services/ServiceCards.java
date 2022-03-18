package services;

import model.beans.secondaire.CityCard;
import utils.UpdateUtils;

import com.google.common.collect.Iterables;

import org.apache.commons.collections.CollectionUtils;

import javax.swing.*;

import java.util.Collections;
import java.util.List;

public class ServiceCards{

    public void transferOneCityCard(final CityCard cardSource, final CityCard cardCible) {
        cardCible.cloneWithButton(cardSource);
    }
    
    public List<CityCard> shuffleListCards(final List<CityCard> listCards) {
        Collections.shuffle(listCards);
        return listCards;
    }

    public void addCardsToDiscard(final List<CityCard> listCardsDiscarded, final CityCard cardToDiscard) {
        listCardsDiscarded.add(cardToDiscard.clone());
    }
    
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
