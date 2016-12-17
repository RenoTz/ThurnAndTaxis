package com.project.thurnandtaxis.data.beans;

import javax.swing.ImageIcon;

public class House {
    
    private String name;
    private String cheminImage;
    private ImageIcon image;
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheminImage() {
        return this.cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
    
    public ImageIcon getImage() {
        return this.image;
    }
    
    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
