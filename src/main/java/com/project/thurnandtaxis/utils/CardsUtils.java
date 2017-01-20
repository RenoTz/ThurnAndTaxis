package com.project.thurnandtaxis.utils;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.secondaire.Adjacence;
import com.project.thurnandtaxis.data.beans.secondaire.CityCard;
import com.project.thurnandtaxis.data.enumerations.EnumDirection;

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

    public static EnumDirection isPossibleToPutCard(final List<CityCard> listCardsRoad, final List<Adjacence> listAdjacences,
        final CityCard cardPlace) {

        EnumDirection enumDirection = EnumDirection.NEANT;

        final CityCard firstCard = listCardsRoad.get(0);
        final CityCard lastCard = Iterables.getLast(listCardsRoad);

        // 1. Placement de cartes possible dans la listCardsRoad
        if (StringUtils.isBlank(firstCard.getNameCity()) && StringUtils.isBlank(lastCard.getNameCity())) {
            // 2. Contrôle si la carte à poser est adjacente aux cartes aux extrémités
            for (Adjacence adj : listAdjacences) {
                if (StringUtils.equals(adj.getFromAdjacence(), getLeftCardRoad(listCardsRoad).getNameCity())) {
                    if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                        enumDirection = EnumDirection.LEFT;
                        break;
                    }
                }
                if (StringUtils.equals(adj.getFromAdjacence(), getRightCardRoad(listCardsRoad).getNameCity())) {
                    if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                        enumDirection = EnumDirection.RIGHT;
                        break;
                    }
                }
                
            }
        }
        return enumDirection;
    }
    
    public static CityCard getFirstCardHandPlayerAvailable(final List<CityCard> listHandCityCards) {
        
        for (CityCard cardPlayer : listHandCityCards) {
            if (StringUtils.isBlank(cardPlayer.getNameCity())) {
                return cardPlayer;
            }
        }
        return null;
    }
    
    public static boolean isListeCardsHandNotFull(final List<CityCard> listCardsHand) {
        for (CityCard btn : listCardsHand) {
            if (StringUtils.isBlank(btn.getNameCity())) {
                return true;
            }
        }
        return false;
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
