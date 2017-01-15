package com.project.thurnandtaxis.data.beans.principal;

import java.util.List;

import javax.swing.JButton;

import com.google.common.collect.Lists;

public class AllButtons {

    private List<JButton> listOfficialsButtons;
    private JButton btnDeckCard;
    private JButton btnRules;
    private JButton btnDiscardRoad;
    private JButton btnBuildRoad;
    private JButton btnRightRoad;
    private JButton btnLeftRoad;

    public AllButtons() {
        this.listOfficialsButtons = Lists.newArrayList();
    }
    
    public List<JButton> getListOfficialsButtons() {
        return this.listOfficialsButtons;
    }
    
    public void setListOfficialsButtons(List<JButton> listOfficialsButtons) {
        this.listOfficialsButtons = listOfficialsButtons;
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
    
    public JButton getBtnRules() {
        return this.btnRules;
    }
    
    public void setBtnRules(JButton btnRules) {
        this.btnRules = btnRules;
    }
    
}
