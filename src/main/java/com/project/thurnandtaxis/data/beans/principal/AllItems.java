package com.project.thurnandtaxis.data.beans.principal;

public class AllItems {
    
    private AllButtons allButtons;
    private AllLabels allLabels;
    private AllBonus allBonus;
    private AllListsCards allListsCards;
    
    public AllItems() {
        this.allButtons = new AllButtons();
        this.allLabels = new AllLabels();
        this.allBonus = new AllBonus();
        this.allListsCards = new AllListsCards();
    }
    
    public AllButtons getAllButtons() {
        return this.allButtons;
    }
    
    public void setAllButtons(AllButtons allButtons) {
        this.allButtons = allButtons;
    }
    
    public AllLabels getAllLabels() {
        return this.allLabels;
    }
    
    public void setAllLabels(AllLabels allLabels) {
        this.allLabels = allLabels;
    }
    
    public AllBonus getAllBonus() {
        return this.allBonus;
    }
    
    public void setAllBonus(AllBonus allBonus) {
        this.allBonus = allBonus;
    }
    
    public AllListsCards getAllListsCards() {
        return this.allListsCards;
    }
    
    public void setAllListsCards(AllListsCards allListsCards) {
        this.allListsCards = allListsCards;
    }
    
}
