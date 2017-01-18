package com.project.thurnandtaxis.utils;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.project.thurnandtaxis.data.beans.secondaire.CityCard;

public class CardsUtils {
    
    public static void melangerLesCartes(List<CityCard> listeAMelanger) {
        Collections.shuffle(listeAMelanger);
    }

    public static CityCard getRightCardRoadAvailable(List<CityCard> listCardsRoad) {
        CityCard cardRight = null;
        Collections.reverse(listCardsRoad);
        for (CityCard card : listCardsRoad) {
            if (StringUtils.isNotBlank(card.getNameCity())) {
                cardRight = listCardsRoad.get(listCardsRoad.indexOf(card) - 1);
                break;
            }
        }
        Collections.reverse(listCardsRoad);
        return cardRight;
    }

    public static CityCard getLeftCardRoadAvailable(List<CityCard> listCardsRoad) {
        CityCard cardLeft = null;
        for (CityCard card : listCardsRoad) {
            if (StringUtils.isNotBlank(card.getNameCity())) {
                cardLeft = listCardsRoad.get(listCardsRoad.indexOf(card) - 1);
                break;
            }
        }
        return cardLeft;
    }
    
}
