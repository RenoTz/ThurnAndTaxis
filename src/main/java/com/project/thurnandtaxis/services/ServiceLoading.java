package com.project.thurnandtaxis.services;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.coordinations.CoordinationGameParams;
import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.constantes.ConstantesGameParams;

public class ServiceLoading {

    public Game chargerTousLesParametresDuJeu(final JSONObject jsonGameElements) throws JSONException, IOException {

        final Game game = new Game();

        final CoordinationGameParams coordGameParams = new CoordinationGameParams();

        game.setGameParams(coordGameParams.recupererGameParamsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.GAME)));
        game.setListeOfficials(coordGameParams.recupererListeOfficialsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.OFFICIALS)));
        game.setListeHouses(coordGameParams.recupererListeHousesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.HOUSES)));
        game.setListeCarriages(coordGameParams.recupererListeCarriagesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.CARRIAGES)));
        game.setListeProvinces(coordGameParams.recupererListeProvincesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.PROVINCES)));
        game.setListeAdjacences(coordGameParams.recupererListeAdjacencesJSON(jsonGameElements
                        .getJSONObject(ConstantesGameParams.DIRECT_ADJACENCES)));
        game.setBonus(coordGameParams.recupererTousLesBonus(jsonGameElements.getJSONObject(ConstantesGameParams.BONUS)));
        
        return game;
    }

}
