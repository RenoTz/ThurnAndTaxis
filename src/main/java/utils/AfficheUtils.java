package utils;

import model.beans.bonus.Bonus;
import model.beans.bonus.ProvinceBonus;
import model.beans.secondaire.Adjacence;
import model.beans.secondaire.Carriage;
import model.beans.secondaire.CityCard;
import model.beans.secondaire.GameParams;
import model.beans.secondaire.House;
import model.beans.secondaire.Official;
import model.beans.secondaire.Province;
import model.beans.secondaire.Tile;
import model.constantes.ConstantesMsgBox;

import org.apache.commons.collections.CollectionUtils;

import javax.swing.*;

import java.util.List;

public class AfficheUtils {

    public static final void aImplementer() {
        JOptionPane.showMessageDialog(null, ConstantesMsgBox.A_IMPLEMENTER, ConstantesMsgBox.INFORMATION, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showGameParams(final GameParams gameParams) {
        System.out.println("-------------- GAME ----------------");
        System.out.println("name : " + gameParams.getName());
        System.out.println("back_card_image : " + gameParams.getBackCardImage().getDescription());
        System.out.println("game_board_image : " + gameParams.getGameBoardImage().getDescription());
        System.out.println("initial_nb_houses : " + gameParams.getNbInitialHouses());
        System.out.println("nb_city_cards_Cartwright_advantage : " + gameParams.getNbCityCardsCartwrightAdvantage());
        System.out.println("nb_copies_city_cards : " + gameParams.getNbCopiesCityCards());
        System.out.println("nb_min_city_cards_close_route : " + gameParams.getNbMinCityCardsRoadClosed());
        System.out.println("nb_max_city_cards_route_closed : " + gameParams.getNbMaxCityCardsRoadClosed());
    }

    public static void printCityCards(final List<CityCard> cityCards) {
        System.out.println("-------------- CITY CARDS ----------------");
        for (CityCard city : cityCards) {
            System.out.println(city.getNameCity());
            System.out.println(city.getNameProvince());
            System.out.println(city.getColorProvince().toString());
            System.out.println(city.getImage().getDescription());
        }
    }
    
    public static void printOfficials(final List<Official> officials) {
        System.out.println("-------------- OFFICIALS ----------------");
        for (Official official : officials) {
            System.out.println(official.getName());
            System.out.println(official.getImage());
        }
    }

    public static void printCarriages(final List<Carriage> carriages) {
        System.out.println("-------------- CARRIAGES ----------------");
        for (Carriage carriage : carriages) {
            System.out.println("nb_victory_points : " + carriage.getNbVictoryPoints());
            System.out.println("route_length : " + carriage.getRouteLength());
        }
    }

    public static void printHouses(final List<House> houses) {
        System.out.println("-------------- HOUSES ----------------");
        for (House house : houses) {
            System.out.println(house.getName());
            System.out.println(house.getImage().getDescription());
        }
    }

    public static void printProvinces(final List<Province> provinces) {
        System.out.println("-------------- PROVINCES ----------------");
        for (Province province : provinces) {
            System.out.println("-------------- PROVINCE ----------------");
            System.out.println("name : " + province.getName());
            System.out.println("color : " + province.getColor().toString());
            System.out.println("nbCities : " + province.getNbCities().toString());
            if (CollectionUtils.isNotEmpty(province.getCities())) {
                System.out.println("-------------- CITIES ----------------");
                for (CityCard city : province.getCities()) {
                    System.out.println("name : " + city.getNameCity());
                    System.out.println("image : " + city.getImage().getDescription());
                }
            }
        }
    }

    public static void printAdjacences(final List<Adjacence> adjacences) {
        System.out.println("-------------- ADJACENCES ----------------");
        for (Adjacence adjacence : adjacences) {
            System.out.println("from : " + adjacence.getFromAdjacence());
            System.out.println("to : " + adjacence.getToAdjacence());
            System.out.println("--------------------------------------");
        }
    }

    public static void printProvinceBonus(ProvinceBonus provinceBonus) {
        System.out.println("-------------- ALL PROVINCES BONUS ----------------");
        System.out.println("-------------------- NAMES -------------------");
        for (String name : provinceBonus.getNames()) {
            System.out.println("name : " + name);
        }
        System.out.println("-------------------- TILES ------------------------");
        for (Tile tile : provinceBonus.getTiles()) {
            System.out.println("nb_victory_points : " + tile.getNbVictoryPoints().toString());
            System.out.println("image : " + tile.getImage().getDescription());
            System.out.println("-------------------------------------------------");
        }
    }
    
    public static void printProvinceBonuses(List<ProvinceBonus> provinceBonuses) {
        System.out.println("-------------- PROVINCES BONUS ----------------");
        for (ProvinceBonus provinceBonus : provinceBonuses) {
            System.out.println("------------------ NAMES ---------------------");
            for (String name : provinceBonus.getNames()) {
                System.out.println("name : " + name);
            }
            System.out.println("------------------ TILES ----------------");
            for (Tile tile : provinceBonus.getTiles()) {
                System.out.println("nb_victory_points : " + tile.getNbVictoryPoints().toString());
                System.out.println("image : " + tile.getImage().getDescription());
                System.out.println("-------------------------------------------");
            }
        }
    }
    
    public static void showLongRoadBonuses(List<Tile> longRouteBonus) {
        System.out.println("-------------- LONG ROAD BONUSES --------------");
        for (Tile tile : longRouteBonus) {
            System.out.println("------------------ TILES ----------------");
            System.out.println("route_lentgh : " + tile.getRoadLength().toString());
            System.out.println("nb_victory_points : " + tile.getNbVictoryPoints().toString());
            System.out.println("image : " + tile.getImage().getDescription());
            System.out.println("-------------------------------------------");
        }
    }
    
    public static void showEndGameBonuses(List<Tile> endGameBonuses) {
        System.out.println("-------------- END GAME BONUSES --------------");
        for (Tile tile : endGameBonuses) {
            System.out.println("------------------ TILES ----------------");
            System.out.println("nb_victory_points : " + tile.getNbVictoryPoints().toString());
            System.out.println("image : " + tile.getImage().getDescription());
            System.out.println("-------------------------------------------");
        }
    }

    public static void showBonus(Bonus bonus) {
        System.out.println("-------------------------------------");
        System.out.println("-------------- BONUS ----------------");
        System.out.println("-------------------------------------");
        AfficheUtils.printProvinceBonuses(bonus.getProvinceBonuses());
        AfficheUtils.printProvinceBonus(bonus.getProvinceBonus());
        // AfficheUtils.afficherLongRouteBonus(bonus.getLongRouteBonus());
        AfficheUtils.showEndGameBonuses(bonus.getEndGameBonuses());
    }

}
