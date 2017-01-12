package com.project.thurnandtaxis.data.beans;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CityCard {

    private String nameCity;
    private String nameProvince;
    private Color colorProvince;
    private ImageIcon image;
    private JButton cityButton;
    
    public CityCard() {
    }

    public CityCard(final JButton btnCardVisible) {
        this.setCityButton(btnCardVisible);
    }

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

    public JButton getCityButton() {
        return this.cityButton;
    }

    public void setCityButton(JButton cityButton) {
        this.cityButton = cityButton;
    }
    
    @Override
    public CityCard clone() {
        final CityCard card = new CityCard();
        card.setColorProvince(this.getColorProvince());
        card.setImage(this.getImage());
        card.setNameCity(this.getNameCity());
        card.setNameProvince(this.getNameProvince());
        return card;
    }
    
    public void cloneWithButton(final CityCard cardToClone) {
        this.setColorProvince(cardToClone.getColorProvince());
        this.setImage(cardToClone.getImage());
        this.setNameCity(cardToClone.getNameCity());
        this.setNameProvince(cardToClone.getNameProvince());
        this.getCityButton().setToolTipText(cardToClone.getNameCity());
        this.getCityButton().setIcon(cardToClone.getImage());
    }
    
}
