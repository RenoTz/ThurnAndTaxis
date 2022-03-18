package model.beans.secondaire;

import lombok.Data;

import javax.swing.*;

@Data
public class GameParams {

    private String name;
    private ImageIcon gameBoardImage;
    private ImageIcon backCardImage;
    private Long nbInitialHouses;
    private Long nbCopiesCityCards;
    private Long nbMinCityCardsRoadClosed;
    private Long nbMaxCityCardsRoadClosed;
    private Long nbCityCardsCartwrightAdvantage;

}
