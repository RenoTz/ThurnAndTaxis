package com.project.thurnandtaxis.utils;

import java.awt.Color;

import com.project.thurnandtaxis.data.enumerations.EnumColor;

public class ColorUtils {

    // Liste de couleurs utiles
    public static final Color PERU = new Color(205, 133, 63);
    
    public static Color selectionnerCouleur(final String nameProvince) {

        Color color = null;

        switch (nameProvince) {
        
            case "Baden":
                color = EnumColor.VIOLET_RED.getColorRGB();
                break;
            case "Baiern":
                color = EnumColor.ANTIQUE_WHITE_3.getColorRGB();
                break;
            case "Bohmen":
                color = EnumColor.ORANGE.getColorRGB();
                break;
            case "Hohenzollern":
                color = EnumColor.FOREST_GREEN.getColorRGB();
                break;
            case "Polen":
                color = EnumColor.DIM_GRAY.getColorRGB();
                break;
            case "Salzburg":
                color = EnumColor.FIREBRICK.getColorRGB();
                break;
            case "Schweiz":
                color = EnumColor.SKY_BLUE.getColorRGB();
                break;
            case "Tyrol":
                color = EnumColor.ROYAL_BLUE.getColorRGB();
                break;
            case "Wurttemberg":
                color = EnumColor.YELLOW_GREEN.getColorRGB();
                break;
            default:
                break;
        }

        return color;
    }
    
}
