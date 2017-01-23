package data.beans.principal;

import java.util.List;

import com.google.common.collect.Lists;

import data.beans.secondaire.Adjacence;
import data.beans.secondaire.Bonus;
import data.beans.secondaire.Carriage;
import data.beans.secondaire.CityCard;
import data.beans.secondaire.GameParams;
import data.beans.secondaire.House;
import data.beans.secondaire.Official;
import data.beans.secondaire.Province;

public class Game {
    
    private List<Official> listOfficials;
    private List<House> listHouses;
    private List<Carriage> listCarriages;
    private GameParams gameParams;
    private List<CityCard> listCityCards;
    private List<Province> listProvinces;
    private List<Adjacence> listAdjacences;
    private Bonus bonus;
    private AllPlayers allPlayers;
    private List<CityCard> listCardsDiscarded;
    
    public Game() {
        this.listOfficials = Lists.newArrayList();
        this.listHouses = Lists.newArrayList();
        this.listCarriages = Lists.newArrayList();
        this.listCityCards = Lists.newArrayList();
        this.listProvinces = Lists.newArrayList();
        this.listAdjacences = Lists.newArrayList();
        this.listCardsDiscarded = Lists.newArrayList();
    }
    
    public GameParams getGameParams() {
        return this.gameParams;
    }
    
    public void setGameParams(GameParams gameParams) {
        this.gameParams = gameParams;
    }
    
    public Bonus getBonus() {
        return this.bonus;
    }
    
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public List<Official> getListOfficials() {
        return this.listOfficials;
    }

    public void setListOfficials(List<Official> listOfficials) {
        this.listOfficials = listOfficials;
    }

    public List<House> getListHouses() {
        return this.listHouses;
    }

    public void setListHouses(List<House> listHouses) {
        this.listHouses = listHouses;
    }

    public List<Carriage> getListCarriages() {
        return this.listCarriages;
    }

    public void setListCarriages(List<Carriage> listCarriages) {
        this.listCarriages = listCarriages;
    }

    public List<CityCard> getListCityCards() {
        return this.listCityCards;
    }

    public void setListCityCards(List<CityCard> listCityCards) {
        this.listCityCards = listCityCards;
    }

    public List<Province> getListProvinces() {
        return this.listProvinces;
    }

    public void setListProvinces(List<Province> listProvinces) {
        this.listProvinces = listProvinces;
    }

    public List<Adjacence> getListAdjacences() {
        return this.listAdjacences;
    }

    public void setListAdjacences(List<Adjacence> listAdjacences) {
        this.listAdjacences = listAdjacences;
    }

    public List<CityCard> getListCardsDiscarded() {
        return this.listCardsDiscarded;
    }

    public void setListCardsDiscarded(List<CityCard> listCardsDiscarded) {
        this.listCardsDiscarded = listCardsDiscarded;
    }
    
    public AllPlayers getAllPlayers() {
        if (this.allPlayers == null) {
            this.allPlayers = new AllPlayers();
        }
        return this.allPlayers;
    }
    
    public void setAllPlayers(AllPlayers allPlayers) {
        this.allPlayers = allPlayers;
    }

}
