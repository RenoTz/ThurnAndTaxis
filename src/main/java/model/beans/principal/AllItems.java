package model.beans.principal;

import lombok.Data;

@Data
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
    
}
