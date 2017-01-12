package com.project.thurnandtaxis.services;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.coordinations.CoordinationGameParams;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.constantes.ConstantesGameParams;

public class ServiceLoading {
    
    private static final int NB_OCCURENCES_CITY_CARDS = 3;
    final CoordinationGameParams coordGameParams;

    public ServiceLoading() {
        this.coordGameParams = new CoordinationGameParams();
    }
    
    public Game chargerTousLesParametresDuJeuDepuisFichier(final JSONObject jsonGameElements) throws JSONException, IOException {
        
        final Game game = new Game();
        game.setGameParams(this.coordGameParams.recupererGameParamsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.GAME)));
        game.setListeOfficials(this.coordGameParams.recupererListeOfficialsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.OFFICIALS)));
        game.setListeHouses(this.coordGameParams.recupererListeHousesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.HOUSES)));
        game.setListeCarriages(this.coordGameParams.recupererListeCarriagesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.CARRIAGES)));
        game.setListeProvinces(this.coordGameParams.recupererListeProvincesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.PROVINCES)));
        game.setListeAdjacences(this.coordGameParams.recupererListeAdjacencesJSON(jsonGameElements
                        .getJSONObject(ConstantesGameParams.DIRECT_ADJACENCES)));
        game.setBonus(this.coordGameParams.recupererTousLesBonus(jsonGameElements.getJSONObject(ConstantesGameParams.BONUS)));
        
        // éléments supplémentaires
        this.chargerLesElementsDuJeuSupplementaires(game);
        
        return game;
    }

    private void chargerLesElementsDuJeuSupplementaires(final Game game) {

        final List<CityCard> listeCityCards = this.coordGameParams.recupererListeCityCards(game.getListeProvinces());

        if (CollectionUtils.isNotEmpty(listeCityCards)) {
            for (CityCard card : listeCityCards) {
                for (int i = 0; i < NB_OCCURENCES_CITY_CARDS; i++) {
                    final CityCard cityCard = new CityCard();
                    cityCard.setColorProvince(card.getColorProvince());
                    cityCard.setImage(card.getImage());
                    cityCard.setNameCity(card.getNameCity());
                    cityCard.setNameProvince(card.getNameProvince());
                    game.getListeCityCards().add(cityCard);
                }
            }
        }

    }
    
}
