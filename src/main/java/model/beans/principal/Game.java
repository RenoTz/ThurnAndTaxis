package model.beans.principal;

import lombok.Data;
import model.beans.bonus.Bonus;
import model.beans.secondaire.Adjacence;
import model.beans.secondaire.Carriage;
import model.beans.secondaire.CityCard;
import model.beans.secondaire.GameParams;
import model.beans.secondaire.House;
import model.beans.secondaire.Official;
import model.beans.secondaire.Player;
import model.beans.secondaire.Province;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private List<Official> officials;
    private List<House> houses;
    private List<Carriage> carriages;
    private List<CityCard> cityCards;
    private List<Province> provinces;
    private List<Adjacence> adjacences;
    private List<Player> players;
    private List<CityCard> cardsDiscarded;
    private GameParams gameParams;
    private Bonus bonus;
    
    public Game() {
        this.officials = new ArrayList<>();
        this.houses = new ArrayList<>();
        this.carriages = new ArrayList<>();
        this.cityCards = new ArrayList<>();
        this.provinces = new ArrayList<>();
        this.adjacences = new ArrayList<>();
        this.cardsDiscarded = new ArrayList<>();
        this.players = new ArrayList<>();
    }
    
}
