package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import utils.AfficheUtils;
import utils.PlayerUtils;
import controler.Sounds;
import data.beans.principal.AllItems;
import data.beans.secondaire.CityCard;
import data.constantes.ConstantesMsgBox;
import data.enumerations.EnumOfficials;

public class ServiceActionOfficials{

    // services
    private ServiceCards serviceCards;
    // cards lists
    private List<CityCard> listCardsVisible;
    private List<CityCard> listCardsDiscarded;
    private List<CityCard> listCardsRemaining;
    // action listener
    private ActionListener forbidden;
    private ActionListener alAdministrator;
    private ActionListener alPostalCarrier;
    private ActionListener alPostMaster;
    private ActionListener alCartwright;
    // buttons
    private JButton administrator;
    private JButton postalCarrier;
    private JButton postMaster;
    private JButton cartwright;
    // labels
    private JLabel lblCardRemaining;
    
    private Sounds sounds;

    public ServiceActionOfficials(final AllItems allItems, final Sounds sounds) {
        this.initialiserLesVariables(allItems, sounds);
        // recuperation des boutons
        this.recupererBoutonOfficials(allItems.getAllButtons().getListOfficialsButtons());
        // creation des Action Listener
        this.creerLesActionsListener();
    }
    
    // ------------------------------
    // METODES PUBLIQUES : ACTIVATION
    // ------------------------------
    
    
    public void addActionAdministrator() {
        this.administrator.removeActionListener(this.forbidden);
        this.administrator.addActionListener(this.alAdministrator);
    }

    
    public void addActionCartwright() {
        this.cartwright.removeActionListener(this.forbidden);
        this.cartwright.addActionListener(this.alCartwright);
    }

    
    public void addActionPostalCarrier() {
        this.postalCarrier.removeActionListener(this.forbidden);
        this.postalCarrier.addActionListener(this.alPostalCarrier);
    }

    
    public void addActionPostmaster() {
        this.postalCarrier.removeActionListener(this.forbidden);
        this.postMaster.addActionListener(this.alPostMaster);
    }
    
    // ---------------------------------
    // METODES PUBLIQUES : DESACTIVATION
    // ---------------------------------
    
    
    public void removeActionAdministrator() {
        this.administrator.removeActionListener(this.alAdministrator);
        this.administrator.addActionListener(this.forbidden);
    }
    
    
    public void removeActionCartwright() {
        this.cartwright.removeActionListener(this.alCartwright);
        this.cartwright.addActionListener(this.forbidden);
    }
    
    
    public void removeActionPostalCarrier() {
        this.postalCarrier.removeActionListener(this.alPostalCarrier);
        this.postalCarrier.addActionListener(this.forbidden);
    }
    
    
    public void removeActionPostmaster() {
        this.postMaster.removeActionListener(this.alPostMaster);
        this.postMaster.addActionListener(this.forbidden);
    }
    
    // ------------------------------
    // METHODES SPECIFIQUES : PRIVEES
    // ------------------------------

    private void initialiserLesVariables(final AllItems allItems, final Sounds sounds) {
        this.sounds = sounds;
        this.serviceCards = new ServiceCards();
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
                if (CollectionUtils.isNotEmpty(ServiceActionOfficials.this.listCardsRemaining)
                                && (ServiceActionOfficials.this.listCardsRemaining.size() > 6)) {
                    // mise à la défausse des 6 cartes visibles
                    if (this.isCardsAlreadyLaid()) {
                        for (CityCard cardVisible : ServiceActionOfficials.this.listCardsVisible) {
                            ServiceActionOfficials.this.serviceCards.addCardsToDiscard(ServiceActionOfficials.this.listCardsDiscarded,
                                            cardVisible);
                        }
                    }
                    ServiceActionOfficials.this.serviceCards.addSixCardsVisible(ServiceActionOfficials.this.listCardsVisible,
                                    ServiceActionOfficials.this.listCardsRemaining, ServiceActionOfficials.this.lblCardRemaining);
                } else {
                    JOptionPane.showMessageDialog(null, ConstantesMsgBox.INFORMATION_NO_CARDS, ConstantesMsgBox.INFORMATION,
                                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            private boolean isCardsAlreadyLaid() {
                for (CityCard card : ServiceActionOfficials.this.listCardsVisible) {
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
                JOptionPane.showMessageDialog(ServiceActionOfficials.this.postMaster, "Please, take one card.",
                                ConstantesMsgBox.INFORMATION, JOptionPane.INFORMATION_MESSAGE);
                PlayerUtils.getPlayerEnCours().getActions().setUsePostMaster(true);
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
                ServiceActionOfficials.this.sounds.getSoundButton().play();
            }
        };
    }
    
}
