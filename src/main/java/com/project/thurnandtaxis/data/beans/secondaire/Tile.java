package com.project.thurnandtaxis.data.beans.secondaire;

import javax.swing.ImageIcon;

public class Tile {
    
    private ImageIcon image;
    private Long nbVictoryPoints;
    private Long routeLength;

    public ImageIcon getImage() {
        return this.image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Long getNbVictoryPoints() {
        return this.nbVictoryPoints;
    }

    public void setNbVictoryPoints(Long nbVictoryPoints) {
        this.nbVictoryPoints = nbVictoryPoints;
    }
    
    public Long getRouteLength() {
        return this.routeLength;
    }
    
    public void setRouteLength(Long routeLength) {
        this.routeLength = routeLength;
    }
    
}
