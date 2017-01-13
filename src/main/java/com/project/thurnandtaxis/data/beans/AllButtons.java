package com.project.thurnandtaxis.data.beans;

import java.util.List;

import javax.swing.JButton;

public class AllButtons {

    private List<JButton> listOfficialsButtons;
    private ListBonusButton listBonusButtons;
    private JButton btnDeckCard;

    public AllButtons(List<JButton> listOfficialsButtons, ListBonusButton listBonusButtons, JButton btnDeckCard) {
        this.listOfficialsButtons = listOfficialsButtons;
        this.listBonusButtons = listBonusButtons;
        this.btnDeckCard = btnDeckCard;
    }
    
    public List<JButton> getListOfficialsButtons() {
        return this.listOfficialsButtons;
    }
    
    public void setListOfficialsButtons(List<JButton> listOfficialsButtons) {
        this.listOfficialsButtons = listOfficialsButtons;
    }
    
    public ListBonusButton getListBonusButtons() {
        return this.listBonusButtons;
    }
    
    public void setListBonusButtons(ListBonusButton listBonusButtons) {
        this.listBonusButtons = listBonusButtons;
    }
    
    public JButton getBtnDeckCard() {
        return this.btnDeckCard;
    }
    
    public void setBtnDeckCard(JButton btnDeckCard) {
        this.btnDeckCard = btnDeckCard;
    }
    
}
