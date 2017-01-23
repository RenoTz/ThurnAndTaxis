package data.beans.secondaire;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public class GameParams {
    
    private String name;
    private ImageIcon gameBoardImage;
    private ImageIcon backCardImage;
    private Long nbInitialHouses;
    private Long nbCopiesCityCards;
    private Long nbMinCityCardsCloseRoute;
    private Long nbMaxCityCardsRouteClosed;
    private Long nbCityCardsCartwrightAdvantage;
    
    public Dimension getDimensionGameBoardImage() {
        return new Dimension(this.gameBoardImage.getIconWidth(), this.gameBoardImage.getIconHeight());
    }

    public Dimension getDimensionBackCardImage() {
        return new Dimension(this.backCardImage.getIconWidth(), this.backCardImage.getIconHeight());
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getGameBoardImage() {
        return this.gameBoardImage;
    }
    
    public void setGameBoardImage(ImageIcon gameBoardImage) {
        this.gameBoardImage = gameBoardImage;
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

    public Long getNbCityCardsCartwrightAdvantage() {
        return this.nbCityCardsCartwrightAdvantage;
    }

    public void setNbCityCardsCartwrightAdvantage(Long nbCityCardsCartwrightAdvantage) {
        this.nbCityCardsCartwrightAdvantage = nbCityCardsCartwrightAdvantage;
    }

    public Long getNbInitialHouses() {
        return this.nbInitialHouses;
    }

    public void setNbInitialHouses(Long nbInitialHouses) {
        this.nbInitialHouses = nbInitialHouses;
    }

}
