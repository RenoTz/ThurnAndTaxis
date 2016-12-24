package com.project.thurnandtaxis.data.enumerations;

import java.awt.Color;

public enum EnumColor {
    
    VIOLET_RED(205, 192, 176), ANTIQUE_WHITE_3(205, 192, 176), ORANGE(255, 165, 0), FOREST_GREEN(34, 139, 34), DIM_GREY(105, 105, 105), FIREBRICK(
                    178, 34, 34), SKY_BLUE(135, 206, 235), ROYAL_BLUE(0, 35, 102), YELLOW_GREEN(127, 255, 0);
    
    private int r, g, b;
    
    private EnumColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Color getColorRGB() {
        return new Color(this.r, this.g, this.b);
    }

    public static EnumColor getEnumColorByColor(final Color color) {
        
        EnumColor enumColor = null;

        for (final EnumColor enumValue : values()) {
            if (enumValue.getColorRGB().getRGB() == color.getRGB()) {
                enumColor = enumValue;
                break;
            }
        }

        return enumColor;
    }
}
