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

    public ServiceActionButton(final JButton btnDeckCard, JLabel lblCardRemaining, List<JButton> listCardsHand, List<JButton> listCardsRoad) {
        this.serviceCards = new ServiceCards();
        this.btnDeckCard = btnDeckCard;
        this.lblCardRemaining = lblCardRemaining;
        this.listCardsHand = listCardsHand;
        this.listCardsRoad = listCardsRoad;
    }

    public void addActionButtonDeckCard(final Player player, final List<CityCard> listCardRemaining) {
        this.btnDeckCard.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(listCardRemaining)) {
                    ServiceActionButton.this.serviceCards.takeOneCityCard(player, listCardRemaining, ServiceActionButton.this.listCardsHand);
                    ServiceActionButton.this.updateLabelCardRemaining(listCardRemaining);
                } else {
                    JOptionPane.showMessageDialog(null, "Do you want shuffle cards ?");
                }
            }
        });
    }
    
    protected void updateLabelCardRemaining(List<CityCard> listCardRemaining) {
        this.lblCardRemaining.setText(String.valueOf(listCardRemaining.size()));
    }
    
    public void addActionButtonAdministrator(final JButton btnAdministrator, final List<CityCard> listeCityCards,
        final List<JButton> listeCardsVisible) {
        btnAdministrator.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(listeCityCards)) {
                    for (JButton cardVisible : listeCardsVisible) {
                        ServiceActionButton.this.serviceCards.addCardVisible(listeCityCards, cardVisible);
                        listeCityCards.remove(Iterables.getLast(listeCityCards));
                        ServiceActionButton.this.updateLabelCardRemaining(listeCityCards);
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Plus assez de cartes.");
                }
                System.out.println("cards remaining : " + listeCityCards.size());
            }
        });
        
    }

    public void addActionButtonCartwright(final JButton btnCartwright, List<CityCard> listeCityCards) {
        // TODO Auto-generated method stub
        
    }
    
    public void addActionButtonPostalCarrier(final JButton btnPostalCarrier, List<CityCard> listeCityCards) {
        // TODO Auto-generated method stub

    }
    
    public void addActionButtonPostmaster(final JButton btnPostmaster, List<CityCard> listeCityCards) {
        // TODO Auto-generated method stub

    }
    
    public void addActionsButtonsOfficials(List<JButton> listeButtonsOfficials, List<CityCard> listeCityCards, List<JButton> listeCardsVisible) {
        this.addActionButtonAdministrator(getOfficial(listeButtonsOfficials, EnumOfficials.ADMINISTRATOR.getName()), listeCityCards,
                        listeCardsVisible);
        this.addActionButtonCartwright(getOfficial(listeButtonsOfficials, EnumOfficials.CARTWRIGHT.getName()), listeCityCards);
        this.addActionButtonPostalCarrier(getOfficial(listeButtonsOfficials, EnumOfficials.POSTAL_CARRIER.getName()), listeCityCards);
        this.addActionButtonPostmaster(getOfficial(listeButtonsOfficials, EnumOfficials.POSTMASTER.getName()), listeCityCards);
    }
    
    private static JButton getOfficial(List<JButton> listeButtonsOfficials, String nameOfficial) {

        for (JButton btn : listeButtonsOfficials) {
            if (StringUtils.equals(btn.getToolTipText(), nameOfficial)) {
                return btn;
            }
        }
        return null;
    }
}
