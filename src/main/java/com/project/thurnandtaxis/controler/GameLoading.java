package com.project.thurnandtaxis.controler;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.thurnandtaxis.coordinations.CoordinationGameParams;
import com.project.thurnandtaxis.data.beans.Carriage;
import com.project.thurnandtaxis.data.beans.GameParams;
import com.project.thurnandtaxis.data.beans.House;
import com.project.thurnandtaxis.data.beans.Official;
import com.project.thurnandtaxis.data.constantes.ConstantesGameParams;

public class GameLoading {

    private List<Official> listeOfficials = null;
    private List<House> listeHouses = null;
    private List<Carriage> listeCarriages = null;
    private GameParams gameParams = null;

    public GameLoading(final JSONObject jsonGameElements) throws JSONException, IOException {
        this.chargerTousLesParametresDuJeu(jsonGameElements);
    }

    private void chargerTousLesParametresDuJeu(final JSONObject jsonGameElements) throws JSONException, IOException {

        final CoordinationGameParams coordGameParams = new CoordinationGameParams();

        this.gameParams = coordGameParams.recupererGameParamsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.GAME));
        this.listeOfficials = coordGameParams.recupererListeOfficialsJSON(jsonGameElements.getJSONObject(ConstantesGameParams.OFFICIALS));
        this.listeHouses = coordGameParams.recupererListeHousesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.HOUSES));
        this.listeCarriages = coordGameParams.recupererListeCarriagesJSON(jsonGameElements.getJSONObject(ConstantesGameParams.CARRIAGES));
    }

    public List<Official> getListeOfficials() {
        return this.listeOfficials;
    }

    public List<House> getListeHouses() {
        return this.listeHouses;
    }
    
    public List<Carriage> getListeCarriages() {
        return this.listeCarriages;
    }

    public GameParams getGameParams() {
        return this.gameParams;
    }

}
