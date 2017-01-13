package com.project.thurnandtaxis.data.beans;

import javax.swing.JLabel;

public class AllLabels {

    private JLabel lblNbCardRemaining;

    public AllLabels(JLabel lblNbCardRemaining) {
        this.setLblNbCardRemaining(lblNbCardRemaining);
    }
    
    public JLabel getLblNbCardRemaining() {
        return this.lblNbCardRemaining;
    }
    
    public void setLblNbCardRemaining(JLabel lblNbCardRemaining) {
        this.lblNbCardRemaining = lblNbCardRemaining;
    }
    
}
