package com.project.thurnandtaxis.data.beans;

import javax.swing.ImageIcon;

public class Official {

    private String name;
    private ImageIcon symbolImage;
    private ImageIcon personImage;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ImageIcon getSymbolImage() {
        return this.symbolImage;
    }

    public void setSymbolImage(ImageIcon symbolImage) {
        this.symbolImage = symbolImage;
    }

    public ImageIcon getPersonImage() {
        return this.personImage;
    }

    public void setPersonImage(ImageIcon personImage) {
        this.personImage = personImage;
    }

}
