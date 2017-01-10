package com.project.thurnandtaxis.data.beans;

import java.awt.Color;

import javax.swing.ImageIcon;

public class CityCard {
    
    private String nameCity;
    private String nameProvince;
    private Color colorProvince;
    private ImageIcon image;
    private boolean hidden;
    
    public String getNameCity() {
        return this.nameCity;
    }
    
    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
    
    public String getNameProvince() {
        return this.nameProvince;
    }
    
    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }
    
    public Color getColorProvince() {
        return this.colorProvince;
    }
    
    public void setColorProvince(Color colorProvince) {
        this.colorProvince = colorProvince;
    }
    
    public ImageIcon getImage() {
        return this.image;
    }
    
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public boolean isHidden() {
        return this.hidden;
    }
    
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

}
