package com.project.thurnandtaxis.data.beans;

import java.util.List;

public class AllListsCards {

    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listeCardsRemaining;
    private List<CityCard> listCardsRoad;
    private List<CityCard> listCardsVisibles;

    public AllListsCards(List<CityCard> listCardsDiscarded, List<CityCard> listeCardsRemaining, List<CityCard> listCardsRoad,
        List<CityCard> listCardsVisibles) {
        this.listCardsDiscarded = listCardsDiscarded;
        this.listeCardsRemaining = listeCardsRemaining;
        this.listCardsRoad = listCardsRoad;
        this.listCardsVisibles = listCardsVisibles;
    }

    public List<CityCard> getListCardsVisibles() {
        return this.listCardsVisibles;
    }

    public void setListCardsVisibles(List<CityCard> listCardsVisibles) {
        this.listCardsVisibles = listCardsVisibles;
    }

    public List<CityCard> getListCardsDiscarded() {
        return this.listCardsDiscarded;
    }

    public void setListCardsDiscarded(List<CityCard> listCardsDiscarded) {
        this.listCardsDiscarded = listCardsDiscarded;
    }

    public List<CityCard> getListeCardsRemaining() {
        return this.listeCardsRemaining;
    }

    public void setListeCardsRemaining(List<CityCard> listeCardsRemaining) {
        this.listeCardsRemaining = listeCardsRemaining;
    }

    public List<CityCard> getListCardsRoad() {
        return this.listCardsRoad;
    }

    public void setListCardsRoad(List<CityCard> listCardsRoad) {
        this.listCardsRoad = listCardsRoad;
    }

}
