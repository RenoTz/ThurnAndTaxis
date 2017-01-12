package com.project.thurnandtaxis.utils;

import java.util.Collections;
import java.util.List;

import com.project.thurnandtaxis.data.beans.CityCard;

public class CardsUtils {

    public static void melangerLesCartes(List<CityCard> listeAMelanger) {
        Collections.shuffle(listeAMelanger);
    }

}
