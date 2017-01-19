package com.project.thurnandtaxis.utils;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.secondaire.Adjacence;
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

    public static String[] isPossibleToPutCard(final List<CityCard> listCardsRoad, final List<Adjacence> listAdjacences, final CityCard cardPlace) {
        
        boolean possible = false;
        String[] retour = new String[2];
        
        final CityCard firstCard = listCardsRoad.get(0);
        final CityCard lastCard = Iterables.getLast(listCardsRoad);
        // cas 1 : plus de place dans la listCardsRoad
        if (StringUtils.isBlank(firstCard.getNameCity()) && StringUtils.isBlank(lastCard.getNameCity())) {
            possible = true;
        }
        // cas 2 : contrôle s'il est possible de poser la carte - adjacence
        for (Adjacence adj : listAdjacences) {
            if (StringUtils.equals(adj.getFromAdjacence(), getLeftCardRoad(listCardsRoad).getNameCity())) {
                if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                    possible = true;
                    retour[0] = String.valueOf(possible);
                    retour[1] = "left";
                    break;
                }
            }
            if (StringUtils.equals(adj.getFromAdjacence(), getRightCardRoad(listCardsRoad).getNameCity())) {
                if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                    possible = true;
                    retour[0] = String.valueOf(possible);
                    retour[1] = "right";
                    break;
                }
            }

        }
        return retour;
    }
    
    private static CityCard getRightCardRoad(List<CityCard> listCardsRoad) {
        CityCard cardRight = null;
        Collections.reverse(listCardsRoad);
        for (CityCard card : listCardsRoad) {
            if (StringUtils.isNotBlank(card.getNameCity())) {
                cardRight = listCardsRoad.get(listCardsRoad.indexOf(card));
                break;
            }
        }
        Collections.reverse(listCardsRoad);
        return cardRight;
    }
    
    private static CityCard getLeftCardRoad(List<CityCard> listCardsRoad) {
        CityCard cardLeft = null;
        for (CityCard card : listCardsRoad) {
            if (StringUtils.isNotBlank(card.getNameCity())) {
                cardLeft = listCardsRoad.get(listCardsRoad.indexOf(card));
                break;
            }
        }
        return cardLeft;
    }
}
