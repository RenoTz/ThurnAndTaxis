package com.project.thurnandtaxis.services.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Iterables;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.constantes.ConstantesMsgBox;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;
import com.project.thurnandtaxis.services.ServiceActionOfficials;
import com.project.thurnandtaxis.services.ServiceCards;

public class ServiceActionOfficialsImpl implements ServiceActionOfficials {
    
    protected static final String INFORMATION = "Information";
    
    private ServiceCards serviceCards;
    private List<JButton> listButtonsOfficials;
    private List<CityCard> listCardsVisible;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listeCityCards;
    
    public ServiceActionOfficialsImpl(List<JButton> listButtonsOfficials, List<CityCard> listCardsVisible, List<CityCard> listCardsDiscarded,
        List<CityCard> listeCityCards) {
        this.serviceCards = new ServiceCards();
        this.listButtonsOfficials = listButtonsOfficials;
        this.listCardsVisible = listCardsVisible;
        this.listCardsDiscarded = listCardsDiscarded;
        this.listeCityCards = listeCityCards;
    }

    @Override
    public void addActionButtonAdministrator(final EnumOfficials enumOfficial) {

        final JButton btnAdministrator = this.getOfficialByName(enumOfficial);
        btnAdministrator.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(ServiceActionOfficialsImpl.this.listeCityCards)) {
                    // mise à la défausse des 6 cartes visibles
                    if (this.isCardsAlreadyLaid()) {
                        for (CityCard cardVisible : ServiceActionOfficialsImpl.this.listCardsVisible) {
                            ServiceActionOfficialsImpl.this.serviceCards.addCardsToDiscard(ServiceActionOfficialsImpl.this.listCardsDiscarded,
                                            cardVisible);
                        }
                    }
                    // ajout des six cartes visibles
                    for (CityCard cardVisible : ServiceActionOfficialsImpl.this.listCardsVisible) {
                        ServiceActionOfficialsImpl.this.serviceCards.addCardVisible(ServiceActionOfficialsImpl.this.listeCityCards, cardVisible);
                        ServiceActionOfficialsImpl.this.listeCityCards.remove(Iterables.getLast(ServiceActionOfficialsImpl.this.listeCityCards));
                        ServiceActionButtonImpl.updateLabelCardRemaining(ServiceActionOfficialsImpl.this.listeCityCards);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_NO_CARDS, INFORMATION, JOptionPane.INFORMATION_MESSAGE);
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

            }
        });
    }

    private JButton getOfficialByName(final EnumOfficials enumOfficial) {

        JButton retour = null;
        for (JButton btn : this.listButtonsOfficials) {
            if (StringUtils.equals(btn.getToolTipText(), enumOfficial.getName())) {
                retour = btn;
            }
        }
        return retour;
    }

}
