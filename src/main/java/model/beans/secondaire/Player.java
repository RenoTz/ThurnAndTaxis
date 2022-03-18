package model.beans.secondaire;

import lombok.Data;
import model.beans.Actions;
import model.beans.bonus.Bonus;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Player implements Serializable {

    private static final long serialVersionUID = 5765647774791670434L;

    private String name;
    private Color color;
    private Long points;
    private boolean won;
    private Actions actions;
    private List<House> houses;
    private List<CityCard> handCityCards;
    private List<CityCard> roadCityCards;
    private List<Bonus> bonuses;

    public Player() {
        this.handCityCards = new ArrayList<>();
        this.roadCityCards = new ArrayList<>();
        this.bonuses = new ArrayList<>();
        this.actions = new Actions();
    }

}
