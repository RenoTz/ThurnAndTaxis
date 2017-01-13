package com.project.thurnandtaxis.services.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.AllLabels;
import com.project.thurnandtaxis.data.beans.AllListsCards;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.constantes.ConstantesMsgBox;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;
import com.project.thurnandtaxis.services.ServiceActionOfficials;
import com.project.thurnandtaxis.services.ServiceCards;
import com.project.thurnandtaxis.utils.AfficheUtils;
import com.project.thurnandtaxis.utils.UpdateUtils;

public class ServiceActionOfficialsImpl implements ServiceActionOfficials {

    private ServiceCards serviceCards;
    private List<JButton> listOfficialsButtons;
    private List<CityCard> listCardsVisible;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listeCardsRemaining;
    private JLabel lblCardRemaining;

    public ServiceActionOfficialsImpl(List<JButton> listButtonsOfficials, AllListsCards listsCards, AllLabels allLabels) {
        this.serviceCards = new ServiceCards();
        this.listOfficialsButtons = listButtonsOfficials;
        this.listCardsVisible = listsCards.getListCardsVisibles();
        this.listCardsDiscarded = listsCards.getListCardsDiscarded();
        this.listeCardsRemaining = listsCards.getListeCardsRemaining();
        this.lblCardRemaining = allLabels.getLblNbCardRemaining();
    }
    
    @Override
    public void addActionButtonAdministrator(final EnumOfficials enumOfficial) {
        
        final JButton btnAdministrator = this.getOfficialByName(enumOfficial);
        btnAdministrator.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(ServiceActionOfficialsImpl.this.listeCardsRemaining)) {
                    // mise à la défausse des 6 cartes visibles
                    if (this.isCardsAlreadyLaid()) {
                        for (CityCard cardVisible : ServiceActionOfficialsImpl.this.listCardsVisible) {
                            ServiceActionOfficialsImpl.this.serviceCards.addCardsToDiscard(ServiceActionOfficialsImpl.this.listCardsDiscarded,
                                            cardVisible);
                        }
                    }
                    // ajout des six cartes visibles
                    for (CityCard cardVisible : ServiceActionOfficialsImpl.this.listCardsVisible) {
                        ServiceActionOfficialsImpl.this.serviceCards.addCardVisible(ServiceActionOfficialsImpl.this.listeCardsRemaining,
                                        cardVisible);
                        ServiceActionOfficialsImpl.this.listeCardsRemaining.remove(Iterables
                                        .getLast(ServiceActionOfficialsImpl.this.listeCardsRemaining));
                        UpdateUtils.updateLabelCardRemaining(ServiceActionOfficialsImpl.this.lblCardRemaining,
                                        ServiceActionOfficialsImpl.this.listeCardsRemaining.size());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_NO_CARDS, ConstantesMsgBox.INFORMATION,
                                    JOptionPane.INFORMATION_MESSAGE);
                }
            }

            private boolean isCardsAlreadyLaid() {
                for (CityCard card : ServiceActionOfficialsImpl.this.listCardsVisible) {
                    if (StringUtils.isNotBlank(card.getNameCity())) {
                        return true;
                    }
                }
                return false;
            }
        });

    }
    
    @Override
    public void addActionButtonCartwright(final EnumOfficials enumOfficial) {
        
        final JButton btnCartwright = this.getOfficialByName(enumOfficial);
        btnCartwright.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                AfficheUtils.aImplementer();
            }
        });
        
    }
    
    @Override
    public void addActionButtonPostalCarrier(final EnumOfficials enumOfficial) {

        final JButton btnPostalCarrier = this.getOfficialByName(enumOfficial);
        btnPostalCarrier.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                AfficheUtils.aImplementer();
            }
        });
        
    }
    
    @Override
    public void addActionButtonPostmaster(final EnumOfficials enumOfficial) {
        
        final JButton btnPostmaster = this.getOfficialByName(enumOfficial);
        btnPostmaster.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO le joueur prend 2 cartes
                AfficheUtils.aImplementer();
            }
        });
    }
    
    private JButton getOfficialByName(final EnumOfficials enumOfficial) {
        
        JButton retour = null;
        for (JButton btn : this.listOfficialsButtons) {
            if (StringUtils.equals(btn.getToolTipText(), enumOfficial.getName())) {
                retour = btn;
            }
        }
        return retour;
    }
    
}
