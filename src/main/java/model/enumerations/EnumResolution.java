package model.enumerations;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;

public enum EnumResolution {
    _1024x712("1024 x 712"), _1024x768("1024 x 768"), _1280x720("1280 x 720"), _1600x900("1600 x 900"), _1920x1080("1920 x 1080"), _2560x1440(
                    "2560 x 1440"), _3840x2160("3840 x 2160"), DEFAULT("Default");
    
    private String value;
    
    private EnumResolution(final String value) {
        this.setValue(value);
    }

    public static EnumResolution getEnumResolutionByValue(final String value) {

        EnumResolution enumResolution = null;
        
        for (final EnumResolution enumValue : values()) {
            if (StringUtils.equals(enumValue.getValue(), value)) {
                enumResolution = enumValue;
                break;
            }
        }
        
        return enumResolution;
    }

    public static Dimension getDimensionByResolution(final EnumResolution enumResolution) {
        
        final Dimension dimension = new Dimension();
        
        switch (enumResolution) {
        
            case _1024x768:
                dimension.setSize(1024, 768);
                break;
            case _1280x720:
                dimension.setSize(1280, 720);
                break;
            case _1600x900:
                dimension.setSize(1600, 900);
                break;
            case _1920x1080:
                dimension.setSize(1920, 1080);
                break;
            case _2560x1440:
                dimension.setSize(2560, 1440);
                break;
            case _3840x2160:
                dimension.setSize(3840, 2160);
                break;
            default:
                dimension.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        }
        return dimension;

    }
    
    public static String[] getAllResolutions() {
        final String[] resolutions = {DEFAULT.getValue(), _1024x712.getValue(), _1024x768.getValue(), _1280x720.getValue(),
                        _1600x900.getValue(), _1920x1080.getValue(), _2560x1440.getValue(), _3840x2160.getValue()};
        return resolutions;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
