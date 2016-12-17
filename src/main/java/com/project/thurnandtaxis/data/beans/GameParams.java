package com.project.thurnandtaxis.data.beans;

import javax.swing.ImageIcon;

public class GameParams {

    private String name;
    private String cheminGameBoardImage;
    private ImageIcon gameBoardImage;
    private String cheminBackCardImage;
    private ImageIcon backCardImage;
    private Long nbCopiesCityCards;
    private Long nbMinCityCardsCloseRoute;
    private Long nbMaxCityCardsRouteClosed;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheminGameBoardImage() {
        return this.cheminGameBoardImage;
    }

    public void setCheminGameBoardImage(String cheminGameBoardImage) {
        this.cheminGameBoardImage = cheminGameBoardImage;
    }

    public ImageIcon getGameBoardImage() {
        return this.gameBoardImage;
    }

    public void setGameBoardImage(ImageIcon gameBoardImage) {
        this.gameBoardImage = gameBoardImage;
    }

    public String getCheminBackCardImage() {
        return this.cheminBackCardImage;
    }

    public void setCheminBackCardImage(String cheminBackCardImage) {
        this.cheminBackCardImage = cheminBackCardImage;
    }

    public ImageIcon getBackCardImage() {
        return this.backCardImage;
    }

    public void setBackCardImage(ImageIcon backCardImage) {
        this.backCardImage = backCardImage;
    }

    public Long getNbCopiesCityCards() {
        return this.nbCopiesCityCards;
    }

    public void setNbCopiesCityCards(Long nbCopiesCityCards) {
        this.nbCopiesCityCards = nbCopiesCityCards;
    }

    public Long getNbMinCityCardsCloseRoute() {
        return this.nbMinCityCardsCloseRoute;
    }

    public void setNbMinCityCardsCloseRoute(Long nbMinCityCardsCloseRoute) {
        this.nbMinCityCardsCloseRoute = nbMinCityCardsCloseRoute;
    }

    public Long getNbMaxCityCardsRouteClosed() {
        return this.nbMaxCityCardsRouteClosed;
    }

    public void setNbMaxCityCardsRouteClosed(Long nbMaxCityCardsRouteClosed) {
        this.nbMaxCityCardsRouteClosed = nbMaxCityCardsRouteClosed;
    }
    
}
