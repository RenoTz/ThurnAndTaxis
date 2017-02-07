package services.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import services.ServiceJoueur;
import services.ServiceActionOfficials;
import services.ServiceCards;
import utils.AfficheUtils;
import controler.Sounds;
import data.beans.principal.AllItems;
import data.beans.secondaire.CityCard;
import data.constantes.ConstantesMsgBox;
import data.enumerations.EnumOfficials;

public class ServiceActionOfficialsImpl implements ServiceActionOfficials {
    
    private ServiceCards serviceCards;
    private ServiceJoueur serviceActionJoueur;

    private List<CityCard> listCardsVisible;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listCardsRemaining;
    private JLabel lblCardRemaining;

    private ActionListener forbidden;
    private ActionListener alAdministrator;
    private ActionListener alPostalCarrier;
    private ActionListener alPostMaster;
    private ActionListener alCartwright;
    private JButton administrator;
    private JButton postalCarrier;
    private JButton postMaster;
    private JButton cartwright;

    private Sounds sounds;
    
    public ServiceActionOfficialsImpl(final AllItems allItems, final Sounds sounds) {
        this.initialiserLesVariables(allItems, sounds);
        // recuperation des boutons
        this.recupererBoutonOfficials(allItems.getAllButtons().getListOfficialsButtons());
        // creation des Action Listener
        this.creerLesActionsListener();
    }

    @Override
    public void addActionAdministrator() {
        this.administrator.removeActionListener(this.forbidden);
        this.administrator.addActionListener(this.alAdministrator);
    }

    @Override
    public void removeActionAdministrator() {
        this.administrator.removeActionListener(this.alAdministrator);
        this.administrator.addActionListener(this.forbidden);
    }
    
    @Override
    public void addActionCartwright() {
        this.cartwright.removeActionListener(this.forbidden);
        this.cartwright.addActionListener(this.alCartwright);
    }

    @Override
    public void removeActionCartwright() {
        this.cartwright.removeActionListener(this.alCartwright);
        this.cartwright.addActionListener(this.forbidden);
    }
    
    @Override
    public void addActionPostalCarrier() {
        this.postalCarrier.removeActionListener(this.forbidden);
        this.postalCarrier.addActionListener(this.alPostalCarrier);
    }

    @Override
    public void removeActionPostalCarrier() {
        this.postalCarrier.removeActionListener(this.alPostalCarrier);
        this.postalCarrier.addActionListener(this.forbidden);
    }

    @Override
    public void addActionPostmaster() {
        this.postalCarrier.removeActionListener(this.forbidden);
        this.postMaster.addActionListener(this.alPostMaster);
    }
    
    @Override
    public void removeActionPostmaster() {
        this.postMaster.removeActionListener(this.alPostMaster);
        this.postMaster.addActionListener(this.forbidden);
    }
    
    private void initialiserLesVariables(final AllItems allItems, final Sounds sounds) {
        this.sounds = sounds;
        this.serviceCards = new ServiceCardsImpl();
        this.serviceActionJoueur = new ServiceJoueurImpl();
        this.listCardsVisible = allItems.getAllListsCards().getListCardsVisibles();
        this.listCardsDiscarded = allItems.getAllListsCards().getListCardsDiscarded();
        this.listCardsRemaining = allItems.getAllListsCards().getListeCardsRemaining();
        this.lblCardRemaining = allItems.getAllLabels().getLblNbCardRemaining();
    }
    
    private void creerLesActionsListener() {
        this.clicForbidden();
        this.creerActionListenerAdministrator();
        this.creerActionListenerPostMaster();
        this.creerActionListenerCartwright();
        this.creerActionListenerPostalCarrier();
    }

    private void creerActionListenerAdministrator() {
        this.alAdministrator = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CollectionUtils.isNotEmpty(ServiceActionOfficialsImpl.this.listCardsRemaining)
                                && (ServiceActionOfficialsImpl.this.listCardsRemaining.size() > 6)) {
                    // mise à la défausse des 6 cartes visibles
                    if (this.isCardsAlreadyLaid()) {
                        for (CityCard cardVisible : ServiceActionOfficialsImpl.this.listCardsVisible) {
                            ServiceActionOfficialsImpl.this.serviceCards.addCardsToDiscard(ServiceActionOfficialsImpl.this.listCardsDiscarded,
                                            cardVisible);
                        }
                    }
                    ServiceActionOfficialsImpl.this.serviceCards.addSixCardsVisible(ServiceActionOfficialsImpl.this.listCardsVisible,
                                    ServiceActionOfficialsImpl.this.listCardsRemaining, ServiceActionOfficialsImpl.this.lblCardRemaining);
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
        };
    }
    
    private void creerActionListenerCartwright() {
        this.alCartwright = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AfficheUtils.aImplementer();
            }
        };
    }

    private void creerActionListenerPostalCarrier() {
        this.alPostalCarrier = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                AfficheUtils.aImplementer();
            }
        };
    }

    private void creerActionListenerPostMaster() {
        this.alPostMaster = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ServiceActionOfficialsImpl.this.postMaster, "Please, take one card.",
                                ConstantesMsgBox.INFORMATION, JOptionPane.INFORMATION_MESSAGE);
                ServiceActionOfficialsImpl.this.serviceActionJoueur.getPlayerEnCours().getActions().setUsePostMaster(true);
            }
        };
    }
    
    private void recupererBoutonOfficials(List<JButton> listOfficials) {
        for (JButton btn : listOfficials) {
            if (StringUtils.equals(btn.getToolTipText(), EnumOfficials.ADMINISTRATOR.getName())) {
                this.administrator = btn;
            }
            if (StringUtils.equals(btn.getToolTipText(), EnumOfficials.POSTAL_CARRIER.getName())) {
                this.postalCarrier = btn;
            }
            if (StringUtils.equals(btn.getToolTipText(), EnumOfficials.POSTMASTER.getName())) {
                this.postMaster = btn;
            }
            if (StringUtils.equals(btn.getToolTipText(), EnumOfficials.CARTWRIGHT.getName())) {
                this.cartwright = btn;
            }
        }
    }

    private void clicForbidden() {

        this.forbidden = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean endSound = false;
                while (!endSound) {
                    ServiceActionOfficialsImpl.this.sounds.getSoundButton().play();
                    endSound = true;
                }
                // button.setBackground(ColorUtils.PERU);
            }
        };
    }

}
