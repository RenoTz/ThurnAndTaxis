package com.project.thurnandtaxis.utils;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.project.thurnandtaxis.data.beans.Adjacence;
import com.project.thurnandtaxis.data.beans.Carriage;
import com.project.thurnandtaxis.data.beans.City;
import com.project.thurnandtaxis.data.beans.GameParams;
import com.project.thurnandtaxis.data.beans.House;
import com.project.thurnandtaxis.data.beans.Official;
import com.project.thurnandtaxis.data.beans.Province;

public class AfficheUtils {

    public static void afficherGameParams(final GameParams gameParams) {
        System.out.println("-------------- GAME ----------------");
        System.out.println("name : " + gameParams.getName());
        System.out.println("back_card_image : " + gameParams.getBackCardImage().getDescription());
        System.out.println("game_board_image : " + gameParams.getGameBoardImage().getDescription());
        System.out.println("initial_nb_houses : " + gameParams.getNbInitialHouses());
        System.out.println("nb_city_cards_Cartwright_advantage : " + gameParams.getNbCityCardsCartwrightAdvantage());
        System.out.println("nb_copies_city_cards : " + gameParams.getNbCopiesCityCards());
        System.out.println("nb_min_city_cards_close_route : " + gameParams.getNbMinCityCardsCloseRoute());
        System.out.println("nb_max_city_cards_route_closed : " + gameParams.getNbMaxCityCardsRouteClosed());
    }

    public static void afficherOfficials(final List<Official> listeOfficials) {
        System.out.println("-------------- OFFICIALS ----------------");
        for (Official official : listeOfficials) {
            System.out.println(official.getName());
            System.out.println(official.getSymbolImage());
            System.out.println(official.getPersonImage());
        }
    }

    public static void afficherCarriages(final List<Carriage> listeCarriages) {
        System.out.println("-------------- CARRIAGES ----------------");
        for (Carriage carriage : listeCarriages) {
            System.out.println("nb_victory_points : " + carriage.getNbVictoryPoints());
            System.out.println("route_length : " + carriage.getRouteLength());
        }
    }

    public static void afficherHouses(final List<House> listehouses) {
        System.out.println("-------------- HOUSES ----------------");
        for (House house : listehouses) {
            System.out.println(house.getName());
            System.out.println(house.getImage().getDescription());
        }
    }

    public static void afficherProvinces(final List<Province> listeProvinces) {
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
    }

    public static void afficherAdjacences(final List<Adjacence> listeAdjacences) {
        System.out.println("-------------- ADJACENCES ----------------");
        for (Adjacence adjacence : listeAdjacences) {
            System.out.println("from : " + adjacence.getFromAdjacence());
            System.out.println("to : " + adjacence.getToAdjacence());
            System.out.println("--------------------------------------");
        }
    }
    
}
