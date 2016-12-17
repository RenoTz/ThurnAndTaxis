package com.project.thurnandtaxis.coordinations;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.Carriage;
import com.project.thurnandtaxis.data.beans.GameParams;
import com.project.thurnandtaxis.data.beans.House;
import com.project.thurnandtaxis.data.beans.Official;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;

public class CoordinationGameParams {

    public GameParams recupererGameParamsJSON(final JSONObject jsonGameParams) throws JSONException, IOException {
        
        final GameParams gameParams = new GameParams();

        gameParams.setName(jsonGameParams.getString("name"));
        gameParams.setCheminBackCardImage(ConstantesStatics.RACINE_STATICS_IMG + jsonGameParams.getString("back_card_image"));
        gameParams.setCheminGameBoardImage(ConstantesStatics.RACINE_STATICS_IMG + jsonGameParams.getString("game_board_image"));
        gameParams.setNbCopiesCityCards(jsonGameParams.getLong("nb_copies_city_cards"));
        gameParams.setNbMinCityCardsCloseRoute(jsonGameParams.getLong("nb_min_city_cards_close_route"));
        gameParams.setNbMaxCityCardsRouteClosed(jsonGameParams.getLong("nb_max_city_cards_route_closed"));
        
        if (StringUtils.isNotBlank(gameParams.getCheminBackCardImage())) {
            gameParams.setBackCardImage(new ImageIcon(jsonGameParams.getString("back_card_image")));
        }
        if (StringUtils.isNotBlank(gameParams.getCheminGameBoardImage())) {
            gameParams.setGameBoardImage(new ImageIcon(jsonGameParams.getString("game_board_image")));
        }

        // TODO A VIRER !!!
        System.out.println("-------------- GAME ----------------");
        System.out.println("name : " + gameParams.getName());
        System.out.println("back_card_image : " + gameParams.getCheminBackCardImage());
        System.out.println("game_board_image : " + gameParams.getCheminGameBoardImage());
        System.out.println("nb_copies_city_cards : " + gameParams.getNbCopiesCityCards());
        System.out.println("nb_min_city_cards_close_route : " + gameParams.getNbMinCityCardsCloseRoute());
        System.out.println("nb_max_city_cards_route_closed : " + gameParams.getNbMaxCityCardsRouteClosed());

        return gameParams;
    }

    public List<Official> recupererListeOfficialsJSON(final JSONObject jsonOfficials) throws JSONException, IOException {
        
        final List<Official> listeOfficials = Lists.newArrayList();
        
        final JSONArray officials = (JSONArray) jsonOfficials.get("official");
        
        for (int i = 0; i < officials.length(); i++) {
            final JSONObject obj = officials.getJSONObject(i);
            // On récupère les informations
            final Official official = new Official();
            official.setName(obj.getString("name"));
            official.setCheminSymbolImage(obj.getString("symbol_image"));
            official.setCheminPersonImage(obj.getString("person_image"));
            
            if (StringUtils.isNotBlank(official.getCheminSymbolImage())) {
                official.setSymbolImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + official.getCheminSymbolImage()));
            }
            if (StringUtils.isNotBlank(official.getCheminPersonImage())) {
                official.setPersonImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + official.getCheminPersonImage()));
            }
            // on ajoute l'official dans la liste
            listeOfficials.add(official);
        }
        
        // TODO A VIRER !!!
        System.out.println("-------------- OFFICIALS ----------------");
        for (Official official : listeOfficials) {
            System.out.println(official.getName());
            System.out.println(official.getSymbolImage());
            System.out.println(official.getPersonImage());
        }

        return listeOfficials;
    }

    public List<Carriage> recupererListeCarriagesJSON(final JSONObject jsonCarriages) throws JSONException, IOException {
        
        final List<Carriage> listeCarriages = Lists.newArrayList();
        
        final JSONArray carriages = (JSONArray) jsonCarriages.get("carriage");
        
        for (int i = 0; i < carriages.length(); i++) {
            final JSONObject obj = carriages.getJSONObject(i);
            // On récupère les informations
            final Carriage carriage = new Carriage();
            carriage.setNbVictoryPoints(obj.getLong("nb_victory_points"));
            carriage.setRouteLength(obj.getLong("route_length"));
            
            // on ajoute le carriage dans la liste
            listeCarriages.add(carriage);
        }
        
        // TODO A VIRER !!!
        System.out.println("-------------- CARRIAGES ----------------");
        for (Carriage carriage : listeCarriages) {
            System.out.println("nb_victory_points : " + carriage.getNbVictoryPoints());
            System.out.println("route_length : " + carriage.getRouteLength());
        }

        return listeCarriages;
    }

    public List<House> recupererListeHousesJSON(final JSONObject jsonHouses) throws JSONException, IOException {

        final List<House> listehouses = Lists.newArrayList();

        final Iterator<String> keys = jsonHouses.keys();
        
        while (keys.hasNext()) {
            // récupération key - value
            final String key = keys.next();
            final String value = (String) jsonHouses.get(key);
            // creation de la maison
            final House house = new House();
            house.setName(key);
            house.setCheminImage(value);
            house.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + value));
            // ajout à la liste des maisons
            listehouses.add(house);
        }

        // TODO A VIRER !!!
        System.out.println("-------------- HOUSES ----------------");
        for (House house : listehouses) {
            System.out.println(house.getName());
            System.out.println(house.getCheminImage());
        }

        return listehouses;
    }

}
