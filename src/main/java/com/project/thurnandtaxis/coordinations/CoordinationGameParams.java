package com.project.thurnandtaxis.coordinations;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.Carriage;
import com.project.thurnandtaxis.data.beans.City;
import com.project.thurnandtaxis.data.beans.GameParams;
import com.project.thurnandtaxis.data.beans.House;
import com.project.thurnandtaxis.data.beans.Official;
import com.project.thurnandtaxis.data.beans.Province;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.utils.ColorUtils;

public class CoordinationGameParams {

    public GameParams recupererGameParamsJSON(final JSONObject jsonGameParams) throws JSONException, IOException {
        
        final GameParams gameParams = new GameParams();

        gameParams.setName(jsonGameParams.getString("name"));
        gameParams.setNbInitialHouses(jsonGameParams.getLong("initial_nb_houses"));
        gameParams.setNbCityCardsCartwrightAdvantage(jsonGameParams.getLong("nb_city_cards_Cartwright_advantage"));
        gameParams.setNbCopiesCityCards(jsonGameParams.getLong("nb_copies_city_cards"));
        gameParams.setNbMinCityCardsCloseRoute(jsonGameParams.getLong("nb_min_city_cards_close_route"));
        gameParams.setNbMaxCityCardsRouteClosed(jsonGameParams.getLong("nb_max_city_cards_route_closed"));
        
        if (StringUtils.isNotBlank(jsonGameParams.getString("back_card_image"))) {
            gameParams.setBackCardImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + jsonGameParams.getString("back_card_image")));
        }
        if (StringUtils.isNotBlank(jsonGameParams.getString("game_board_image"))) {
            gameParams.setGameBoardImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + jsonGameParams.getString("game_board_image")));
        }

        // TODO A VIRER !!!
        System.out.println("-------------- GAME ----------------");
        System.out.println("name : " + gameParams.getName());
        System.out.println("back_card_image : " + gameParams.getBackCardImage().getDescription());
        System.out.println("game_board_image : " + gameParams.getGameBoardImage().getDescription());
        System.out.println("initial_nb_houses : " + gameParams.getNbInitialHouses());
        System.out.println("nb_city_cards_Cartwright_advantage : " + gameParams.getNbCityCardsCartwrightAdvantage());
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
            
            if (StringUtils.isNotBlank(obj.getString("symbol_image"))) {
                official.setSymbolImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + obj.getString("symbol_image")));
            }
            if (StringUtils.isNotBlank(obj.getString("person_image"))) {
                official.setPersonImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + obj.getString("person_image")));
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
            if (StringUtils.isNotBlank(value)) {
                house.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + value));
            }
            // ajout à la liste des maisons
            listehouses.add(house);
        }

        // TODO A VIRER !!!
        System.out.println("-------------- HOUSES ----------------");
        for (House house : listehouses) {
            System.out.println(house.getName());
            System.out.println(house.getImage().getDescription());
        }

        return listehouses;
    }

    public List<Province> recupererListeProvincesJSON(JSONObject jsonProvinces) {

        final List<Province> listeProvinces = Lists.newArrayList();
        
        final JSONArray provinces = (JSONArray) jsonProvinces.get("province");
        
        for (int i = 0; i < provinces.length(); i++) {
            final JSONObject objJSON = provinces.getJSONObject(i);
            // On récupère les informations
            final Province province = new Province();
            province.setName(objJSON.getString("name"));
            province.setColor(ColorUtils.selectionnerCouleur(objJSON.getString("name")));
            
            // on récupère la liste des villes
            JSONArray citiesJSON = null;
            JSONObject cityJSON = null;
            try {
                citiesJSON = (JSONArray) objJSON.get("city");
            } catch (ClassCastException e) {
                cityJSON = (JSONObject) objJSON.get("city");
            }
            if (citiesJSON != null) {
                
                for (int j = 0; j < citiesJSON.length(); j++) {
                    final JSONObject iterCityJSON = citiesJSON.getJSONObject(j);
                    // On récupère les informations
                    final City city = new City();
                    city.setName(iterCityJSON.getString("name"));
                    if (StringUtils.isNotBlank(ConstantesStatics.RACINE_STATICS_IMG + iterCityJSON.getString("image"))) {
                        city.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + iterCityJSON.getString("image")));
                    }
                    // on ajoute la ville dans la liste
                    province.getListeCity().add(city);
                }
            } else {
                // On récupère les informations
                final City citySingle = new City();
                citySingle.setName(cityJSON.getString("name"));
                if (StringUtils.isNotBlank(ConstantesStatics.RACINE_STATICS_IMG + cityJSON.getString("image"))) {
                    citySingle.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + cityJSON.getString("image")));
                }
                // on ajoute la ville dans la liste
                province.getListeCity().add(citySingle);
            }
            province.setNbCities(new Long(province.getListeCity().size()));
            // on ajoute le carriage dans la liste
            listeProvinces.add(province);
        }
        
        // TODO A VIRER !!!
        System.out.println("-------------- PROVINCES ----------------");
        for (Province province : listeProvinces) {
            System.out.println("-------------- PROVINCE ----------------");
            System.out.println("name : " + province.getName());
            System.out.println("color : " + province.getColor().toString());
            System.out.println("nbCities : " + province.getNbCities().toString());
            if (CollectionUtils.isNotEmpty(province.getListeCity())) {
                System.out.println("-------------- CITIES ----------------");
                for (City city : province.getListeCity()) {
                    System.out.println("name : " + city.getName());
                    System.out.println("image : " + city.getImage().getDescription());
                }
            }
        }
        
        return listeProvinces;
    }
}
