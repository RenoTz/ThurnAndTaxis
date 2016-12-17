package com.project.thurnandtaxis.data.beans;

import javax.swing.ImageIcon;

public class Official {

    private String name;
    private String cheminSymbolImage;
    private ImageIcon symbolImage;
    private String cheminPersonImage;
    private ImageIcon personImage;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheminSymbolImage() {
        return this.cheminSymbolImage;
    }

    public void setCheminSymbolImage(String cheminSymbolImage) {
        this.cheminSymbolImage = cheminSymbolImage;
    }

    public ImageIcon getSymbolImage() {
        return this.symbolImage;
    }

    public void setSymbolImage(ImageIcon symbolImage) {
        this.symbolImage = symbolImage;
    }

    public String getCheminPersonImage() {
        return this.cheminPersonImage;
    }

    public void setCheminPersonImage(String cheminPersonImage) {
        this.cheminPersonImage = cheminPersonImage;
    }

    public ImageIcon getPersonImage() {
        return this.personImage;
    }

    public void setPersonImage(ImageIcon personImage) {
        this.personImage = personImage;
    }

}
