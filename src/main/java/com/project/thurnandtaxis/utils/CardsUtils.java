package com.project.thurnandtaxis.utils;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.secondaire.Adjacence;
import com.project.thurnandtaxis.data.beans.secondaire.CityCard;
import com.project.thurnandtaxis.data.enumerations.EnumDirection;

public class CardsUtils {
    
    public static void melangerLesCartes(List<CityCard> listeAMelanger) {
        Collections.shuffle(listeAMelanger);
    }

    public static void moveCardsToTheRight(List<CityCard> listCardsRoad) {
        List<CityCard> listMoved = Lists.newArrayList();
        
        for (CityCard cardRoad : listCardsRoad) {
            final CityCard cardMoved = new CityCard(cardRoad.getCityButton());
            cardMoved.cloneWithButton(cardRoad);
            listMoved.add(cardMoved);
            cardRoad.clear();
        }
        for (CityCard cardMoved : listMoved) {
            if (StringUtils.isNotBlank(cardMoved.getNameCity())) {
                listCardsRoad.get(listMoved.indexOf(cardMoved) + 1).setNameCity(cardMoved.getNameCity());
                listCardsRoad.get(listMoved.indexOf(cardMoved) + 1).setNameProvince(cardMoved.getNameProvince());
                listCardsRoad.get(listMoved.indexOf(cardMoved) + 1).setColorProvince(cardMoved.getColorProvince());
                listCardsRoad.get(listMoved.indexOf(cardMoved) + 1).setImage(cardMoved.getImage());
                listCardsRoad.get(listMoved.indexOf(cardMoved) + 1).getCityButton().setToolTipText(cardMoved.getNameCity());
                listCardsRoad.get(listMoved.indexOf(cardMoved) + 1).getCityButton().setIcon(cardMoved.getImage());
            }
        }
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
    
    public static EnumDirection isPossibleToPutCard(final List<CityCard> listCardsRoad, final List<Adjacence> listAdjacences,
        final CityCard cardPlace) {
        
        EnumDirection enumDirection = EnumDirection.NEANT;
        
        // 1. on regarde si il reste une place dans la listCardsRoad
        if (StringUtils.isBlank(Iterables.getLast(listCardsRoad).getNameCity())) {
            // 2. Contrôle si la carte à poser est adjacente aux cartes aux extrémités
            // 2.a) left
            EnumDirection enumDirLeft = null;
            for (Adjacence adj : listAdjacences) {
                if (StringUtils.equals(adj.getFromAdjacence(), getLeftCardRoad(listCardsRoad).getNameCity())) {
                    if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                        enumDirLeft = EnumDirection.LEFT;
                        break;
                    }
                }
            }
            // 2.b) right
            EnumDirection enumDirRight = null;
            for (Adjacence adj : listAdjacences) {
                if (StringUtils.equals(adj.getFromAdjacence(), getRightCardRoad(listCardsRoad).getNameCity())) {
                    if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                        enumDirRight = EnumDirection.RIGHT;
                        break;
                    }
                }
            }
            // on récupère la direction
            if ((enumDirLeft != null) && (enumDirRight != null)) {
                enumDirection = EnumDirection.LEFT_OR_RIGHT;
            } else if (enumDirLeft != null) {
                enumDirection = enumDirLeft;
            } else if (enumDirRight != null) {
                enumDirection = enumDirRight;
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
