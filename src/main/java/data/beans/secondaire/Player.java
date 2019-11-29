package data.beans.secondaire;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import data.beans.Actions;
import data.beans.bonus.Bonus;

public class Player implements Serializable
{

    private static final long serialVersionUID = 5765647774791670434L;

    private String name;

    private Color color;

    private List<House> listeHouses;

    private List<CityCard> listHandCityCards;

    private List<CityCard> listRoadCityCards;

    private List<Bonus> listeBonus;

    private Long points;

    private boolean won;

    private Actions actions;

    public Player()
    {
        this.listHandCityCards = Lists.newArrayList();
        this.listRoadCityCards = Lists.newArrayList();
        this.listeBonus = Lists.newArrayList();
        this.actions = new Actions();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(final Color color)
    {
        this.color = color;
    }

    public List<House> getListeHouses()
    {
        return this.listeHouses;
    }

    public void setListeHouses(final List<House> listeHouses)
    {
        this.listeHouses = listeHouses;
    }

    public List<CityCard> getListHandCityCards()
    {
        return this.listHandCityCards;
    }

    public void setListHandCityCards(final List<CityCard> listHandCityCards)
    {
        this.listHandCityCards = listHandCityCards;
    }

    public List<CityCard> getListRoadCityCards()
    {
        return this.listRoadCityCards;
    }

    public void setListRoadCityCards(final List<CityCard> listRoadCityCards)
    {
        this.listRoadCityCards = listRoadCityCards;
    }

    public List<Bonus> getListeBonus()
    {
        return this.listeBonus;
    }

    public void setListeBonus(final List<Bonus> listeBonus)
    {
        this.listeBonus = listeBonus;
    }

    public Long getPoints()
    {
        return this.points;
    }

    public void setPoints(final Long points)
    {
        this.points = points;
    }

    public boolean isWon()
    {
        return this.won;
    }

    public void setWon(final boolean won)
    {
        this.won = won;
    }

    public Actions getActions()
    {
        return this.actions;
    }

    public void setActions(final Actions actions)
    {
        this.actions = actions;
    }

}
