package utils;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import data.beans.secondaire.Adjacence;
import data.beans.secondaire.CityCard;
import data.enumerations.EnumDirection;

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
        final String leftCity = getLeftCardRoad(listCardsRoad).getNameCity();
        final String rightRoadCard = getRightCardRoad(listCardsRoad).getNameCity();

        // 1. on regarde si il est possible de poser la carte dans la listCardsRoad
        if (verifierSiPossibleDePoserLaCarte(listCardsRoad, cardPlace) && isUniquementAdjacenteAuxExtremites(listCardsRoad, listAdjacences, cardPlace)) {
            // 2. Contrôle si la carte à poser est adjacente aux cartes aux extrémités
            // 2.a) left
            boolean toTheLeft = false;
            for (Adjacence adj : listAdjacences) {
                if (StringUtils.equals(adj.getFromAdjacence(), leftCity)) {
                    if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                        toTheLeft = true;
                        break;
                    }
                }
            }
            // 2.b) right
            boolean toTheRight = false;
            for (Adjacence adj : listAdjacences) {
                if (StringUtils.equals(adj.getFromAdjacence(), rightRoadCard)) {
                    if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
                        toTheRight = true;
                        break;
                    }
                }
            }
            // on récupère la direction
            if (StringUtils.equals(leftCity, rightRoadCard)) {
                enumDirection = EnumDirection.LEFT_OR_RIGHT;
            } else if ((toTheLeft) && (toTheRight)) {
                enumDirection = EnumDirection.NEANT;
            } else if (toTheLeft) {
                enumDirection = EnumDirection.LEFT;
            } else if (toTheRight) {
                enumDirection = EnumDirection.RIGHT;
            }
        }
        return enumDirection;
    }
    
    private static boolean verifierSiPossibleDePoserLaCarte(final List<CityCard> listCardsRoad, CityCard cardPlace) {
        return StringUtils.isBlank(Iterables.getLast(listCardsRoad).getNameCity()) && !isCarteDejaPresente(listCardsRoad, cardPlace);
    }
    
    private static boolean isUniquementAdjacenteAuxExtremites(final List<CityCard> listCardsRoad, final List<Adjacence> listAdjacences, final CityCard cardPlace){
    	
        if(isPlusDeDeuxCartesSurLaRoute(listCardsRoad)){
        	final String leftCity = getLeftCardRoad(listCardsRoad).getNameCity();
            final String rightCity = getRightCardRoad(listCardsRoad).getNameCity();
	    	for(CityCard cardRoad : listCardsRoad){
	    		for (Adjacence adj : listAdjacences) {
	                if (StringUtils.equals(adj.getFromAdjacence(), cardRoad.getNameCity())) {
	                    if (StringUtils.equals(adj.getToAdjacence(), cardPlace.getNameCity())) {
	                        if(!(StringUtils.equals(cardRoad.getNameCity(), leftCity) || StringUtils.equals(cardRoad.getNameCity(), rightCity))){
	                        	return false;
	                        }
	                    }
	                }
	            }
	    	}
        }
    	return true;
    }
    
    private static boolean isPlusDeDeuxCartesSurLaRoute(List<CityCard> listCardsRoad) {
		int nbRoadCard = 0;
		for(CityCard card : listCardsRoad){
			if(StringUtils.isNotBlank(card.getNameCity())){
				nbRoadCard++;
			}
		}
		return nbRoadCard > 2;
	}

	private static boolean isCarteDejaPresente(List<CityCard> listCardsRoad, CityCard cardPlace) {
        for (CityCard cardRoad : listCardsRoad) {
            if (StringUtils.equals(cardPlace.getNameCity(), cardRoad.getNameCity())) {
                return true;
            }
        }
        return false;
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
