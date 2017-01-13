package com.project.thurnandtaxis.data.beans;

import java.util.List;

import javax.swing.JButton;

public class AllButtons {

    private List<JButton> listOfficialsButtons;
    private AllBonus listBonusButtons;
    private JButton btnDeckCard;
    private JButton btnDiscardRoad;
    private JButton btnBuildRoad;
    private JButton btnRightRoad;
    private JButton btnLeftRoad;

    public AllButtons(List<JButton> listOfficialsButtons, AllBonus listBonusButtons, JButton btnDeckCard) {
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
    
    public AllBonus getListBonusButtons() {
        return this.listBonusButtons;
    }
    
    public void setListBonusButtons(AllBonus listBonusButtons) {
        this.listBonusButtons = listBonusButtons;
    }
    
    public JButton getBtnDeckCard() {
        return this.btnDeckCard;
    }
    
    public void setBtnDeckCard(JButton btnDeckCard) {
        this.btnDeckCard = btnDeckCard;
    }

    public JButton getBtnDiscardRoad() {
        return this.btnDiscardRoad;
    }

    public void setBtnDiscardRoad(JButton btnDiscardRoad) {
        this.btnDiscardRoad = btnDiscardRoad;
    }

    public JButton getBtnBuildRoad() {
        return this.btnBuildRoad;
    }

    public void setBtnBuildRoad(JButton btnBuildRoad) {
        this.btnBuildRoad = btnBuildRoad;
    }

    public JButton getBtnRightRoad() {
        return this.btnRightRoad;
    }

    public void setBtnRightRoad(JButton btnRightRoad) {
        this.btnRightRoad = btnRightRoad;
    }

    public JButton getBtnLeftRoad() {
        return this.btnLeftRoad;
    }

    public void setBtnLeftRoad(JButton btnLeftRoad) {
        this.btnLeftRoad = btnLeftRoad;
    }
    
}
