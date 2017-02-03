package coordinations;

import java.awt.Color;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utils.ColorUtils;
import utils.ComparatorAdjacence;
import utils.ImageUtils;

import com.google.common.collect.Lists;

import data.beans.bonus.Bonus;
import data.beans.bonus.LongRoadBonus;
import data.beans.bonus.ProvinceBonus;
import data.beans.secondaire.Adjacence;
import data.beans.secondaire.Carriage;
import data.beans.secondaire.CityCard;
import data.beans.secondaire.GameParams;
import data.beans.secondaire.House;
import data.beans.secondaire.Official;
import data.beans.secondaire.Province;
import data.beans.secondaire.Tile;
import data.constantes.ConstantesGameParams;
import data.constantes.ConstantesStatics;
import data.enumerations.EnumColor;

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
            
            if (StringUtils.isNotBlank(obj.getString(ConstantesGameParams.OFFICIAL_SYMBOL_IMAGE))) {
                official.setImage(new ImageIcon(ConstantesStatics.RACINE_IMG_OFFICIALS
                                + obj.getString(ConstantesGameParams.OFFICIAL_SYMBOL_IMAGE)));
            }
            // on ajoute l'official dans la liste
            listeOfficials.add(official);
        }
        
        return listeOfficials;
    }

    public List<Carriage> recupererListeCarriagesJSON(final JSONObject jsonCarriages) throws JSONException, IOException {
        
        final List<Carriage> listeCarriages = Lists.newArrayList();
        
        final JSONArray carriages = (JSONArray) jsonCarriages.get(ConstantesGameParams.CARRIAGE);
        
        for (int i = 0; i < carriages.length(); i++) {
            final JSONObject obj = carriages.getJSONObject(i);
            // On récupère les informations
            final Carriage carriage = new Carriage();
            carriage.setNbVictoryPoints(obj.getLong(ConstantesGameParams.NB_VICTORY_POINTS));
            carriage.setRouteLength(obj.getLong(ConstantesGameParams.ROUTE_LENGTH));
            
            // on ajoute le carriage dans la liste
            listeCarriages.add(carriage);
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
                house.setImage(new ImageIcon(ConstantesStatics.RACINE_IMG_HOUSES + value));
            }
            // ajout à la liste des maisons
            listehouses.add(house);
        }

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
            final Color provinceColor = ColorUtils.selectionnerCouleur(objJSON.getString(ConstantesGameParams.NAME));
            province.setColor(provinceColor);
            final EnumColor enumColor = EnumColor.getEnumColorByColor(provinceColor);
            
            // on récupère la liste des villes
            try {
                final JSONArray citiesJSON = (JSONArray) objJSON.get(ConstantesGameParams.CITY);
                for (int j = 0; j < citiesJSON.length(); j++) {
                    final JSONObject iterCityJSON = citiesJSON.getJSONObject(j);
                    // On récupère les informations
                    final CityCard city = new CityCard();
                    city.setNameCity(iterCityJSON.getString(ConstantesGameParams.NAME));
                    city.setImage(ImageUtils.selectImageCityCardByColor(iterCityJSON, enumColor));
                    // on ajoute la ville dans la liste
                    province.getListeCity().add(city);
                }
            } catch (ClassCastException e) {
                final JSONObject cityJSON = (JSONObject) objJSON.get(ConstantesGameParams.CITY);
                // On récupère les informations
                final CityCard citySingle = new CityCard();
                citySingle.setNameCity(cityJSON.getString(ConstantesGameParams.NAME));
                citySingle.setImage(ImageUtils.selectImageCityCardByColor(cityJSON, enumColor));
                // on ajoute la ville dans la liste
                province.getListeCity().add(citySingle);
            }
            province.setNbCities(new Long(province.getListeCity().size()));
            // on ajoute le carriage dans la liste
            listeProvinces.add(province);
        }
        
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

        return listeAdjacences;
    }
    
    public Bonus recupererTousLesBonus(JSONObject jsonGameElements) {
        
        final Bonus bonus = new Bonus();

        // 1) on récupère les provinces_bonus
        final JSONObject jsonProvincesBonusJSON = jsonGameElements.getJSONObject(ConstantesGameParams.PROVINCES_BONUS);
        final JSONArray provinceBonusArray = (JSONArray) jsonProvincesBonusJSON.get(ConstantesGameParams.PROVINCE_BONUS);
        
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
                tile.setImage(ImageUtils.selectImageTileCityByName(tileJSON, provinceBonus.getListNames().get(0)));
                provinceBonus.getTiles().add(tile);
            }
            // on inverse l'ordre des tuiles - meilleure utilisation
            Collections.reverse(provinceBonus.getTiles());
            // on ajoute la province bonus à la liste
            bonus.getListProvincesBonus().add(provinceBonus);
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
            tile.setImage(new ImageIcon(ConstantesStatics.RACINE_IMG_ALL_PROVINCES_BONUS + tileJSON.getString(ConstantesGameParams.IMAGE)));
            allProvinceBonus.getTiles().add(tile);
        }
        // on inverse l'ordre des tuiles -> meilleure utilisation
        Collections.reverse(allProvinceBonus.getTiles());
        bonus.setAllProvincesBonus(allProvinceBonus);
        
        // 3) on récupère les long_route_bonus
        final JSONObject jsonLongRouteBonusJSON = jsonGameElements.getJSONObject(ConstantesGameParams.LONG_ROUTE_BONUS);
        // On récupère la liste des tiles
        final JSONArray tileLRBArray = (JSONArray) jsonLongRouteBonusJSON.get(ConstantesGameParams.TILE);
        final LongRoadBonus longRoadBonus7 = new LongRoadBonus();
        final LongRoadBonus longRoadBonus6 = new LongRoadBonus();
        final LongRoadBonus longRoadBonus5 = new LongRoadBonus();
        for (int i = 0; i < tileLRBArray.length(); i++) {
            final JSONObject tileJSON = tileLRBArray.getJSONObject(i);
            final Tile tile = new Tile();
            final Long roadLength = tileJSON.getLong(ConstantesGameParams.ROUTE_LENGTH);
            if (roadLength == 7) {
                tile.setRouteLength(roadLength);
                tile.setNbVictoryPoints(tileJSON.getLong(ConstantesGameParams.NB_VICTORY_POINTS));
                tile.setImage(ImageUtils.selectImageLongRoadByLength(tileJSON, roadLength));
                longRoadBonus7.getListLongRoadTile().add(tile);
            } else if (roadLength == 6) {
                tile.setRouteLength(roadLength);
                tile.setNbVictoryPoints(tileJSON.getLong(ConstantesGameParams.NB_VICTORY_POINTS));
                tile.setImage(ImageUtils.selectImageLongRoadByLength(tileJSON, roadLength));
                longRoadBonus6.getListLongRoadTile().add(tile);
            } else if (roadLength == 5) {
                tile.setRouteLength(roadLength);
                tile.setNbVictoryPoints(tileJSON.getLong(ConstantesGameParams.NB_VICTORY_POINTS));
                tile.setImage(ImageUtils.selectImageLongRoadByLength(tileJSON, roadLength));
                longRoadBonus5.getListLongRoadTile().add(tile);
            }
        }
        // on inverse l'ordre des tuiles - meilleure utilisation
        Collections.reverse(longRoadBonus7.getListLongRoadTile());
        Collections.reverse(longRoadBonus6.getListLongRoadTile());
        Collections.reverse(longRoadBonus5.getListLongRoadTile());
        bonus.getListLongRouteBonus().add(longRoadBonus7);
        bonus.getListLongRouteBonus().add(longRoadBonus6);
        bonus.getListLongRouteBonus().add(longRoadBonus5);
        
        // 4) on récupère les end_game_bonus
        final JSONObject jsonEndGameBonusJSON = jsonGameElements.getJSONObject(ConstantesGameParams.END_GAME_BONUS);
        // On récupère la liste des tiles
        final JSONArray tileEGBArray = (JSONArray) jsonEndGameBonusJSON.get(ConstantesGameParams.TILE);
        for (int i = 0; i < tileEGBArray.length(); i++) {
            final JSONObject tileJSON = tileEGBArray.getJSONObject(i);
            final Tile tile = new Tile();
            tile.setNbVictoryPoints(tileJSON.getLong(ConstantesGameParams.NB_VICTORY_POINTS));
            tile.setImage(new ImageIcon(ConstantesStatics.RACINE_IMG_END_GAME_BONUS + tileJSON.getString(ConstantesGameParams.IMAGE)));
            bonus.getListEndGameBonus().add(tile);
        }
        // on inverse l'ordre des tuiles -> meilleure utilisation
        Collections.reverse(bonus.getListEndGameBonus());

        return bonus;
    }
    
    public List<CityCard> recupererListeCityCards(List<Province> listeProvinces) {

        final List<CityCard> listeCityCards = Lists.newArrayList();
        
        for (Province province : listeProvinces) {
            for (CityCard city : province.getListeCity()) {
                final CityCard cityCard = new CityCard();
                cityCard.setNameCity(city.getNameCity());
                cityCard.setNameProvince(province.getName());
                cityCard.setColorProvince(province.getColor());
                cityCard.setImage(city.getImage());
                listeCityCards.add(cityCard);
            }
        }
        return listeCityCards;
    }

}
