package com.project.thurnandtaxis.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Player;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;

public class ServiceActionButton {
    
    private ServiceCards serviceCards;
    private JButton btnDeckCard;
    private JLabel lblCardRemaining;
    private List<JButton> listCardsHand;
    private List<JButton> listCardsRoad;
    private List<JButton> listeButtonsOfficials;
    private List<JButton> listCardsVisible;
    
    public ServiceActionButton(final JButton btnDeckCard, JLabel lblCardRemaining, List<JButton> listCardsHand, List<JButton> listCardsRoad,
        List<JButton> listeButtonsOfficials, List<JButton> listCardsVisible) {
        this.serviceCards = new ServiceCards();
        this.btnDeckCard = btnDeckCard;
        this.lblCardRemaining = lblCardRemaining;
        this.listCardsHand = listCardsHand;
        this.listCardsRoad = listCardsRoad;
        this.listeButtonsOfficials = listeButtonsOfficials;
        this.listCardsVisible = listCardsVisible;
    }
    
    public void addActionButtonDeckCard(final Player player, final List<CityCard> listCardRemaining) {
        this.btnDeckCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(listCardRemaining)) {
                    if (ServiceActionButton.this.isListeCardsHandFull(ServiceActionButton.this.listCardsHand)) {
                        ServiceActionButton.this.serviceCards.takeOneCityCard(player, listCardRemaining, ServiceActionButton.this.listCardsHand);
                        ServiceActionButton.this.updateLabelCardRemaining(listCardRemaining);
                    } else {
                        JOptionPane.showMessageDialog(null, "You can't take another card.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Do you want to shuffle cards ?");
                }
            }
            
        });
    }

    protected void updateLabelCardRemaining(List<CityCard> listCardRemaining) {
        this.lblCardRemaining.setText(String.valueOf(listCardRemaining.size()));
    }
    
    public void addActionsButtonsOfficials(List<CityCard> listeCityCards) {
        this.addActionButtonAdministrator(this.getOfficialByName(EnumOfficials.ADMINISTRATOR.getName()), listeCityCards);
        this.addActionButtonCartwright(this.getOfficialByName(EnumOfficials.CARTWRIGHT.getName()), listeCityCards);
        this.addActionButtonPostalCarrier(this.getOfficialByName(EnumOfficials.POSTAL_CARRIER.getName()), listeCityCards);
        this.addActionButtonPostmaster(this.getOfficialByName(EnumOfficials.POSTMASTER.getName()), listeCityCards);
    }
    
    private void addActionButtonAdministrator(final JButton btnAdministrator, final List<CityCard> listeCityCards) {
        btnAdministrator.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(listeCityCards)) {
                    for (JButton cardVisible : ServiceActionButton.this.listCardsVisible) {
                        ServiceActionButton.this.serviceCards.addCardVisible(listeCityCards, cardVisible);
                        listeCityCards.remove(Iterables.getLast(listeCityCards));
                        ServiceActionButton.this.updateLabelCardRemaining(listeCityCards);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Plus assez de cartes.");
                }
            }
        });

    }
    
    private void addActionButtonCartwright(final JButton btnCartwright, List<CityCard> listeCityCards) {
        // TODO Auto-generated method stub

    }

    private void addActionButtonPostalCarrier(final JButton btnPostalCarrier, List<CityCard> listeCityCards) {
        // TODO Auto-generated method stub
        
    }

    private void addActionButtonPostmaster(final JButton btnPostmaster, List<CityCard> listeCityCards) {
        // TODO Auto-generated method stub
        
    }

    private JButton getOfficialByName(String nameOfficial) {
        
        for (JButton btn : this.listeButtonsOfficials) {
            if (StringUtils.equals(btn.getToolTipText(), nameOfficial)) {
                return btn;
            }
        }
        return null;
    }
    
    private boolean isListeCardsHandFull(List<JButton> listCardsHand) {
        for (JButton btn : listCardsHand) {
            if (StringUtils.isBlank(btn.getToolTipText())) {
                return true;
            }
        }
        return false;
    }
}
