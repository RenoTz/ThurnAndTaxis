package com.project.thurnandtaxis.coordinations;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.Adjacence;
import com.project.thurnandtaxis.data.beans.Bonus;
import com.project.thurnandtaxis.data.beans.Carriage;
import com.project.thurnandtaxis.data.beans.City;
import com.project.thurnandtaxis.data.beans.GameParams;
import com.project.thurnandtaxis.data.beans.House;
import com.project.thurnandtaxis.data.beans.Official;
import com.project.thurnandtaxis.data.beans.Province;
import com.project.thurnandtaxis.data.beans.ProvinceBonus;
import com.project.thurnandtaxis.data.beans.Tile;
import com.project.thurnandtaxis.data.constantes.ConstantesGameParams;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.utils.AfficheUtils;
import com.project.thurnandtaxis.utils.ColorUtils;
import com.project.thurnandtaxis.utils.ComparatorAdjacence;

public class CoordinationGameParams {
    
    public GameParams recupererGameParamsJSON(final JSONObject jsonGameParams) throws JSONException, IOException {

        final GameParams gameParams = new GameParams();
        
        gameParams.setName(jsonGameParams.getString(ConstantesGameParams.NAME));
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
        AfficheUtils.afficherGameParams(gameParams);
        
        return gameParams;
    }
    
    public List<Official> recupererListeOfficialsJSON(final JSONObject jsonOfficials) throws JSONException, IOException {

        final List<Official> listeOfficials = Lists.newArrayList();

        final JSONArray officials = (JSONArray) jsonOfficials.get(ConstantesGameParams.OFFICIAL);

        for (int i = 0; i < officials.length(); i++) {
            final JSONObject obj = officials.getJSONObject(i);
            // On récupère les informations
            final Official official = new Official();
            official.setName(obj.getString(ConstantesGameParams.NAME));

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
        AfficheUtils.afficherOfficials(listeOfficials);
        
        return listeOfficials;
    }
    
    public List<Carriage> recupererListeCarriagesJSON(final JSONObject jsonCarriages) throws JSONException, IOException {

        final List<Carriage> listeCarriages = Lists.newArrayList();

        final JSONArray carriages = (JSONArray) jsonCarriages.get(ConstantesGameParams.CARRIAGE);

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
        AfficheUtils.afficherCarriages(listeCarriages);
        
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
        AfficheUtils.afficherHouses(listehouses);
        
        return listehouses;
    }
    
    public List<Province> recupererListeProvincesJSON(JSONObject jsonProvinces) {
        
        final List<Province> listeProvinces = Lists.newArrayList();

        final JSONArray provinces = (JSONArray) jsonProvinces.get(ConstantesGameParams.PROVINCE);

        for (int i = 0; i < provinces.length(); i++) {
            final JSONObject objJSON = provinces.getJSONObject(i);
            // On récupère les informations
            final Province province = new Province();
            province.setName(objJSON.getString(ConstantesGameParams.NAME));
            province.setColor(ColorUtils.selectionnerCouleur(objJSON.getString(ConstantesGameParams.NAME)));

            // on récupère la liste des villes
            try {
                final JSONArray citiesJSON = (JSONArray) objJSON.get(ConstantesGameParams.CITY);
                for (int j = 0; j < citiesJSON.length(); j++) {
                    final JSONObject iterCityJSON = citiesJSON.getJSONObject(j);
                    // On récupère les informations
                    final City city = new City();
                    city.setName(iterCityJSON.getString(ConstantesGameParams.NAME));
                    if (StringUtils.isNotBlank(ConstantesStatics.RACINE_STATICS_IMG + iterCityJSON.getString(ConstantesGameParams.IMAGE))) {
                        city.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + iterCityJSON.getString(ConstantesGameParams.IMAGE)));
                    }
                    // on ajoute la ville dans la liste
                    province.getListeCity().add(city);
                }
            } catch (ClassCastException e) {
                final JSONObject cityJSON = (JSONObject) objJSON.get(ConstantesGameParams.CITY);
                // On récupère les informations
                final City citySingle = new City();
                citySingle.setName(cityJSON.getString(ConstantesGameParams.NAME));
                if (StringUtils.isNotBlank(ConstantesStatics.RACINE_STATICS_IMG + cityJSON.getString(ConstantesGameParams.IMAGE))) {
                    citySingle.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + cityJSON.getString(ConstantesGameParams.IMAGE)));
                }
                // on ajoute la ville dans la liste
                province.getListeCity().add(citySingle);
            }
            province.setNbCities(new Long(province.getListeCity().size()));
            // on ajoute le carriage dans la liste
            listeProvinces.add(province);
        }

        // TODO A VIRER !!!
        AfficheUtils.afficherProvinces(listeProvinces);

        return listeProvinces;
    }
    
    public List<Adjacence> recupererListeAdjacencesJSON(JSONObject jsonAdjacences) {

        final List<Adjacence> listeAdjacences = Lists.newArrayList();
        
        final JSONArray adjacences = (JSONArray) jsonAdjacences.get(ConstantesGameParams.DIRECT_ADJACENCE);

        for (int i = 0; i < adjacences.length(); i++) {
            final JSONObject adjacenceJSON = adjacences.getJSONObject(i);
            // On récupère les informations
            final Adjacence adjacence = new Adjacence();
            adjacence.setFromAdjacence(adjacenceJSON.getString(ConstantesGameParams.FROM));
            adjacence.setToAdjacence(adjacenceJSON.getString(ConstantesGameParams.TO));
            // creation de l'adjacence inverse car le fichier contient qu'un seul lien entre deux villes, dans un seul sens
            final Adjacence adjacenceReverse = new Adjacence();
            adjacenceReverse.setFromAdjacence(adjacenceJSON.getString(ConstantesGameParams.TO));
            adjacenceReverse.setToAdjacence(adjacenceJSON.getString(ConstantesGameParams.FROM));
            listeAdjacences.add(adjacence);
            listeAdjacences.add(adjacenceReverse);
        }
        
        final ComparatorAdjacence comparatorAdj = new ComparatorAdjacence();
        Collections.sort(listeAdjacences, comparatorAdj);
        
        // TODO A VIRER !!!
        AfficheUtils.afficherAdjacences(listeAdjacences);

        return listeAdjacences;
    }

    public Bonus recupererTousLesBonus(JSONObject jsonGameElements) {

        final Bonus bonus = new Bonus();
        
        // 1) on récupère les provinces_bonus
        final JSONObject jsonProvincesBonusJSON = jsonGameElements.getJSONObject(ConstantesGameParams.PROVINCES_BONUS);
        final JSONArray provinceBonusArray = (JSONArray) jsonProvincesBonusJSON.get(ConstantesGameParams.PROVINCE_BONUS);

        System.out.println("-------------------------------------");
        System.out.println("-------------- BONUS ----------------");
        System.out.println("-------------------------------------");

        for (int i = 0; i < provinceBonusArray.length(); i++) {
            final ProvinceBonus provinceBonus = new ProvinceBonus();
            
            final JSONObject provinceBonusJSON = provinceBonusArray.getJSONObject(i);
            // On récupère le nom ou la liste de nom de la (ou des) province(s)
            try {
                final JSONObject provinceJSON = provinceBonusJSON.getJSONObject(ConstantesGameParams.PROVINCE);
                provinceBonus.getListNames().add(provinceJSON.getString(ConstantesGameParams.NAME));
            } catch (JSONException e) {
                final JSONArray provinceArray = (JSONArray) provinceBonusJSON.get(ConstantesGameParams.PROVINCE);
                for (int j = 0; j < provinceArray.length(); j++) {
                    final JSONObject provinceArrayJSON = provinceArray.getJSONObject(j);
                    provinceBonus.getListNames().add(provinceArrayJSON.getString(ConstantesGameParams.NAME));
                }
            }
            // On récupère la liste des tiles
            final JSONArray tileArray = (JSONArray) provinceBonusJSON.get(ConstantesGameParams.TILE);
            for (int k = 0; k < tileArray.length(); k++) {
                final JSONObject tileJSON = tileArray.getJSONObject(k);
                final Tile tile = new Tile();
                tile.setNbVictoryPoints(tileJSON.getLong(ConstantesGameParams.NB_VICTORY_POINTS));
                tile.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + tileJSON.getString(ConstantesGameParams.IMAGE)));
                provinceBonus.getTiles().add(tile);
            }
            // on ajoute la province bonus à la liste
            bonus.getListeProvincesBonus().add(provinceBonus);
            
            AfficheUtils.afficherProvincesBonus(bonus.getListeProvincesBonus());
            
        }
        // 2) on récupère les all_provinces_bonus
        final JSONObject jsonAllProvincesBonusJSON = jsonGameElements.getJSONObject(ConstantesGameParams.ALL_PROVINCES_BONUS);
        // On récupère la liste des tiles
        final ProvinceBonus allProvinceBonus = new ProvinceBonus();
        final JSONArray tileArray = (JSONArray) jsonAllProvincesBonusJSON.get(ConstantesGameParams.TILE);
        for (int i = 0; i < tileArray.length(); i++) {
            final JSONObject tileJSON = tileArray.getJSONObject(i);
            final Tile tile = new Tile();
            tile.setNbVictoryPoints(tileJSON.getLong(ConstantesGameParams.NB_VICTORY_POINTS));
            tile.setImage(new ImageIcon(ConstantesStatics.RACINE_STATICS_IMG + tileJSON.getString(ConstantesGameParams.IMAGE)));
            allProvinceBonus.getTiles().add(tile);
        }
        bonus.setAllProvincesBonus(allProvinceBonus);

        AfficheUtils.afficherAllProvincesBonus(allProvinceBonus);
        // 3) on récupère les long_route_bonus

        // 4) on récupère les end_game_bonus
        
        return bonus;
    }
}
