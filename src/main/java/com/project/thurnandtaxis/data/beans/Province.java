package com.project.thurnandtaxis.data.beans;

import java.awt.Color;
import java.util.List;

import com.google.common.collect.Lists;

public class Province {

    private String name;
    private Color color;
    private List<City> listeCity;
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

    public List<City> getListeCity() {
        return this.listeCity;
    }

    public void setListeCity(List<City> listeCity) {
        this.listeCity = listeCity;
    }
    
    public Long getNbCities() {
        return this.nbCities;
    }
    
    public void setNbCities(Long nbCities) {
        this.nbCities = nbCities;
    }
    
}
