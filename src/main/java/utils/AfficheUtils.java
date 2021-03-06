package utils;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;

import data.beans.bonus.Bonus;
import data.beans.bonus.ProvinceBonus;
import data.beans.secondaire.Adjacence;
import data.beans.secondaire.Carriage;
import data.beans.secondaire.CityCard;
import data.beans.secondaire.GameParams;
import data.beans.secondaire.House;
import data.beans.secondaire.Official;
import data.beans.secondaire.Province;
import data.beans.secondaire.Tile;
import data.constantes.ConstantesMsgBox;

public class AfficheUtils {

    public static final void aImplementer() {
        JOptionPane.showMessageDialog(null, ConstantesMsgBox.A_IMPLEMENTER, ConstantesMsgBox.INFORMATION, JOptionPane.INFORMATION_MESSAGE);
    }

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

    public static void afficherCityCards(final List<CityCard> listeCityCards) {
        System.out.println("-------------- CITY CARDS ----------------");
        for (CityCard city : listeCityCards) {
            System.out.println(city.getNameCity());
            System.out.println(city.getNameProvince());
            System.out.println(city.getColorProvince().toString());
            System.out.println(city.getImage().getDescription());
        }
    }
    
    public static void afficherOfficials(final List<Official> listeOfficials) {
        System.out.println("-------------- OFFICIALS ----------------");
        for (Official official : listeOfficials) {
            System.out.println(official.getName());
            System.out.println(official.getImage());
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
                for (CityCard city : province.getListeCity()) {
                    System.out.println("name : " + city.getNameCity());
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

    public static void afficherAllProvincesBonus(ProvinceBonus allProvinceBonus) {
        System.out.println("-------------- ALL PROVINCES BONUS ----------------");
        System.out.println("-------------------- NAMES -------------------");
        for (String name : allProvinceBonus.getListNames()) {
            System.out.println("name : " + name);
        }
        System.out.println("-------------------- TILES ------------------------");
        for (Tile tile : allProvinceBonus.getTiles()) {
            System.out.println("nb_victory_points : " + tile.getNbVictoryPoints().toString());
            System.out.println("image : " + tile.getImage().getDescription());
            System.out.println("-------------------------------------------------");
        }
    }
    
    public static void afficherProvincesBonus(List<ProvinceBonus> listeProvincesBonus) {
        System.out.println("-------------- PROVINCES BONUS ----------------");
        for (ProvinceBonus provinceBonus : listeProvincesBonus) {
            System.out.println("------------------ NAMES ---------------------");
            for (String name : provinceBonus.getListNames()) {
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
    
    public static void afficherLongRouteBonus(List<Tile> longRouteBonus) {
        System.out.println("-------------- LONG ROUTE BONUS ----------------");
        for (Tile tile : longRouteBonus) {
            System.out.println("------------------ TILES ----------------");
            System.out.println("route_lentgh : " + tile.getRouteLength().toString());
            System.out.println("nb_victory_points : " + tile.getNbVictoryPoints().toString());
            System.out.println("image : " + tile.getImage().getDescription());
            System.out.println("-------------------------------------------");
        }
    }
    
    public static void afficherEndGameBonus(List<Tile> endGameBonus) {
        System.out.println("-------------- END GAME BONUS ----------------");
        for (Tile tile : endGameBonus) {
            System.out.println("------------------ TILES ----------------");
            System.out.println("nb_victory_points : " + tile.getNbVictoryPoints().toString());
            System.out.println("image : " + tile.getImage().getDescription());
            System.out.println("-------------------------------------------");
        }
    }

    public static void afficherLesBonus(Bonus bonus) {
        System.out.println("-------------------------------------");
        System.out.println("-------------- BONUS ----------------");
        System.out.println("-------------------------------------");
        AfficheUtils.afficherProvincesBonus(bonus.getListProvincesBonus());
        AfficheUtils.afficherAllProvincesBonus(bonus.getAllProvincesBonus());
        // AfficheUtils.afficherLongRouteBonus(bonus.getLongRouteBonus());
        AfficheUtils.afficherEndGameBonus(bonus.getListEndGameBonus());
    }

}
