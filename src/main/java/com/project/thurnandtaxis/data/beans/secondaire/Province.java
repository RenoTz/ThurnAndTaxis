package com.project.thurnandtaxis.data.beans.secondaire;

import java.awt.Color;
import java.util.List;

import com.google.common.collect.Lists;

public class Province {

    private String name;
    private Color color;
    private List<CityCard> listeCity;
    private Long nbCities;

    public Province() {
        this.listeCity = Lists.newArrayList();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<CityCard> getListeCity() {
        return this.listeCity;
    }

    public void setListeCity(List<CityCard> listeCity) {
        this.listeCity = listeCity;
    }
    
    public Long getNbCities() {
        return this.nbCities;
    }
    
    public void setNbCities(Long nbCities) {
        this.nbCities = nbCities;
    }
    
}
