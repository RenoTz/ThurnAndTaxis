package com.project.thurnandtaxis.services;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.coordinations.CoordinationGameParams;
import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.constantes.ConstantesGameParams;

public class ServiceLoading {
    
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
        game.setListeCityCards(this.coordGameParams.recupererListeCityCards(game.getListeProvinces()));
    }
    
}
