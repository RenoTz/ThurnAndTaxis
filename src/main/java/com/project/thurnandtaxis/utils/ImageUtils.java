package com.project.thurnandtaxis.utils;

import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.project.thurnandtaxis.data.beans.City;
import com.project.thurnandtaxis.data.constantes.ConstantesGameParams;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.data.enumerations.EnumColor;

public class ImageUtils {
    
    public static ImageIcon selectImageTileCityByName(final JSONObject tileJSON, final String name) {
        
        String racineTileCity = StringUtils.EMPTY;

        switch (name) {
        
            case "Baden":
                racineTileCity = ConstantesStatics.RACINE_IMG_TILE_CITY_BONUS_BADEN;
                break;
            case "Wurttemberg":
                racineTileCity = ConstantesStatics.RACINE_IMG_TILE_CITY_BONUS_WURTTEMBERG;
                break;
            case "Baiern":
                racineTileCity = ConstantesStatics.RACINE_IMG_TILE_CITY_BONUS_BAIERN;
                break;
            case "Bohmen":
                racineTileCity = ConstantesStatics.RACINE_IMG_TILE_CITY_BONUS_BOHMEN;
                break;
            case "Schweiz":
                racineTileCity = ConstantesStatics.RACINE_IMG_TILE_CITY_BONUS_SCHWEIZ;
                break;
            default:
                break;
        }
        
        return new ImageIcon(racineTileCity + tileJSON.getString(ConstantesGameParams.IMAGE));
    }
    
    public static ImageIcon selectImageCityCardByColor(final JSONObject iterCityJSON, final City city, final EnumColor enumColor) {

        String racineCityCards = StringUtils.EMPTY;

        switch (enumColor) {
        
            case VIOLET_RED:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_VIOLET_RED;
                break;
            case ANTIQUE_WHITE_3:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_ANTIQUEWHITE3;
                break;
            case ORANGE:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_ORANGE;
                break;
            case FOREST_GREEN:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_FORESTGREEN;
                break;
            case YELLOW_GREEN:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_YELLOWGREEN;
                break;
            case DIM_GRAY:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_DIMGRAY;
                break;
            case FIREBRICK:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_FIREBRICK;
                break;
            case SKY_BLUE:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_SKYBLUE;
                break;
            case ROYAL_BLUE:
                racineCityCards = ConstantesStatics.RACINE_IMG_CITY_CARDS_ROYALBLUE;
                break;
            default:
                break;
        }
        return new ImageIcon(racineCityCards + iterCityJSON.getString(ConstantesGameParams.IMAGE));
    }
    
    public static ImageIcon selectImageLongRoadByLength(final JSONObject tileJSON, final Long routeLength) {

        String racineLongRouteBonus = StringUtils.EMPTY;

        switch (routeLength.intValue()) {
            case 5:
                racineLongRouteBonus = ConstantesStatics.RACINE_IMG_LONG_ROUTE_5;
                break;
            case 6:
                racineLongRouteBonus = ConstantesStatics.RACINE_IMG_LONG_ROUTE_6;
                break;
            case 7:
                racineLongRouteBonus = ConstantesStatics.RACINE_IMG_LONG_ROUTE_7;
                break;
            default:
                break;
        }
        return new ImageIcon(racineLongRouteBonus + tileJSON.getString(ConstantesGameParams.IMAGE));
    }
    
}
