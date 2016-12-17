package com.project.thurnandtaxis.utils;

import java.awt.Color;

public class ColorUtils {
    
    public static Color selectionnerCouleur(final String nameProvince) {

        Color color = null;

        switch (nameProvince) {
        
            case "Baden":
                color = new Color(199, 21, 133); // violet red
                break;
            case "Baiern":
                color = new Color(205, 192, 176); // AntiqueWhite3
                break;
            case "Bohmen":
                color = Color.ORANGE; // orange
                break;
            case "Hohenzollern":
                color = new Color(34, 139, 34); // forest green
                break;
            case "Polen":
                color = new Color(105, 105, 105); // dim gray
                break;
            case "Salzburg":
                color = new Color(178, 34, 34); // firebrick
                break;
            case "Schweiz":
                color = new Color(135, 206, 235); // sky blue
                break;
            case "Tyrol":
                color = new Color(0, 35, 102); // royal blue
                break;
            case "Wurttemberg":
                color = new Color(127, 255, 0); // yellow green
                break;
            default:
                break;
        }

        return color;
    }
    
}
