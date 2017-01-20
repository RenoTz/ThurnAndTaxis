package com.project.thurnandtaxis.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.project.thurnandtaxis.data.beans.principal.AllItems;
import com.project.thurnandtaxis.data.beans.principal.Game;
import com.project.thurnandtaxis.data.beans.secondaire.CityCard;
import com.project.thurnandtaxis.data.beans.secondaire.Player;
import com.project.thurnandtaxis.data.constantes.ConstantesStatics;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;
import com.project.thurnandtaxis.data.enumerations.EnumResolution;
import com.project.thurnandtaxis.utils.ColorUtils;

public class InterfaceJeu extends JFrame {

    private static final long serialVersionUID = 3006307486047180080L;

    private Player p1;
    
    public AllItems createInterface(final Game game) {
        this.setTitle("Thurn and Taxis");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLayeredPane layeredThurnplan = new JLayeredPane();
        layeredThurnplan.setBackground(ColorUtils.SANDY_BROWN);
        this.getContentPane().add(layeredThurnplan, BorderLayout.CENTER);
        
        JLabel lblThurnplan = new JLabel("");
        lblThurnplan.setBounds(0, 0, 1024, 712);
        layeredThurnplan.add(lblThurnplan, 0);
        lblThurnplan.setHorizontalAlignment(SwingConstants.CENTER);
        lblThurnplan.setIcon(game.getGameParams().getGameBoardImage());
        
        // creation du bean qui contiendra tous les items (JButton, JLabel)
        final AllItems allItems = new AllItems();

        // TODO Chargemement du joueur - A VIRER
        this.p1 = game.getAllPlayers().getPlayer1();
        
        // ---------------
        // CARDS VISIBLES
        // ---------------
        JPanel panelCardVisible = new JPanel();
        panelCardVisible.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardVisible, 1);
        panelCardVisible.setBounds(20, 225, 167, 375);
        panelCardVisible.setVisible(true);
        layeredThurnplan.add(panelCardVisible, 1);
        panelCardVisible.setLayout(new GridLayout(3, 2, 3, 3));
        
        JButton cardVisible1 = new JButton("");
        cardVisible1.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible1);
        layeredThurnplan.setLayer(cardVisible1, 1);
        allItems.getAllListsCards().getListCardsVisibles().add(new CityCard(cardVisible1));
        
        JButton cardVisible2 = new JButton("");
        cardVisible2.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible2);
        layeredThurnplan.setLayer(cardVisible2, 1);
        allItems.getAllListsCards().getListCardsVisibles().add(new CityCard(cardVisible2));
        
        JButton cardVisible3 = new JButton("");
        cardVisible3.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible3);
        allItems.getAllListsCards().getListCardsVisibles().add(new CityCard(cardVisible3));
        
        JButton cardVisible4 = new JButton("");
        cardVisible4.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible4);
        allItems.getAllListsCards().getListCardsVisibles().add(new CityCard(cardVisible4));
        
        JButton cardVisible5 = new JButton("");
        cardVisible5.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible5);
        allItems.getAllListsCards().getListCardsVisibles().add(new CityCard(cardVisible5));
        
        JButton cardVisible6 = new JButton("");
        cardVisible6.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible6);
        allItems.getAllListsCards().getListCardsVisibles().add(new CityCard(cardVisible6));

        // ---------------
        // BUTTONS - BONUS
        // ---------------
        
        JButton btnBonusBaden = new JButton("");
        btnBonusBaden.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/baden/bonusbaden3.png")));
        btnBonusBaden.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusBaden.setToolTipText("Bonus Baden");
        btnBonusBaden.setBounds(429, 123, 34, 34);
        layeredThurnplan.add(btnBonusBaden, new Integer(1));

        JButton btnBonusBohmen = new JButton("");
        btnBonusBohmen.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/bohmen/bonusbohmen4.png")));
        btnBonusBohmen.setToolTipText("Bonus Bohmen");
        btnBonusBohmen.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusBohmen.setBounds(906, 381, 34, 34);
        layeredThurnplan.add(btnBonusBohmen, new Integer(1));

        JButton btnBonusBaiern = new JButton("");
        btnBonusBaiern.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/baiern/bonusbaiern5.png")));
        btnBonusBaiern.setToolTipText("Bonus Baiern");
        btnBonusBaiern.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusBaiern.setBounds(737, 388, 34, 34);
        layeredThurnplan.add(btnBonusBaiern, new Integer(1));

        JButton btnBonusSchweiz = new JButton("");
        btnBonusSchweiz.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/schweiz/bonusschweiz3.png")));
        btnBonusSchweiz.setToolTipText("Bonus Schweiz");
        btnBonusSchweiz.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusSchweiz.setBounds(394, 659, 34, 34);
        layeredThurnplan.add(btnBonusSchweiz, new Integer(1));

        JButton btnBonusWruttemberg = new JButton("");
        btnBonusWruttemberg.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/wurttemberg/bonuswurttemberg3.png")));
        btnBonusWruttemberg.setToolTipText("Bonus Wruttemberg");
        btnBonusWruttemberg.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusWruttemberg.setBounds(378, 366, 34, 34);
        layeredThurnplan.add(btnBonusWruttemberg, new Integer(1));

        JButton btnBonusLongRoad5 = new JButton("");
        btnBonusLongRoad5.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong5/bonus52.png")));
        btnBonusLongRoad5.setToolTipText("Bonus Long Road 5");
        btnBonusLongRoad5.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusLongRoad5.setBounds(32, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad5, new Integer(1));

        JButton btnBonusLongRoad6 = new JButton("");
        btnBonusLongRoad6.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong6/bonus63.png")));
        btnBonusLongRoad6.setToolTipText("Bonus Long Road 6");
        btnBonusLongRoad6.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusLongRoad6.setBounds(85, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad6, new Integer(1));

        JButton btnBonusLongRoad7 = new JButton("");
        btnBonusLongRoad7.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong7/bonus74.png")));
        btnBonusLongRoad7.setToolTipText("Bonus Long Road 7");
        btnBonusLongRoad7.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusLongRoad7.setBounds(140, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad7, new Integer(1));
        
        JButton btnBonusAll = new JButton("");
        btnBonusAll.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/com/project/thurnandtaxis/statics/img/allprovinces/bonusall6.png")));
        btnBonusAll.setToolTipText("Bonus all");
        btnBonusAll.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusAll.setBounds(326, 65, 35, 35);
        layeredThurnplan.add(btnBonusAll, new Integer(1));
        
        JButton btnBonusEnd = new JButton("");
        btnBonusEnd.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/com/project/thurnandtaxis/statics/img/endgamebonus/bonusend0.png")));
        btnBonusEnd.setToolTipText("Bonus end");
        btnBonusEnd.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusEnd.setBounds(326, 25, 35, 35);
        layeredThurnplan.add(btnBonusEnd, new Integer(1));
        
        // ---------------------
        // PANEL - CARD CARRIAGE
        // ---------------------
        
        JPanel panelCardCaleche = new JPanel();
        panelCardCaleche.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardCaleche, 1);
        panelCardCaleche.setBounds(390, 24, 603, 75);
        layeredThurnplan.add(panelCardCaleche);
        panelCardCaleche.setLayout(new GridLayout(0, 5, 1, 0));

        JButton btnCaleche1 = new JButton("");
        btnCaleche1.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche1);

        JButton btnCaleche2 = new JButton("");
        btnCaleche2.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche2);

        JButton btnCaleche3 = new JButton("");
        btnCaleche3.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche3);

        JButton btnCaleche4 = new JButton("");
        btnCaleche4.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche4);

        JButton btnCaleche5 = new JButton("");
        btnCaleche5.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche5);
        
        // ------------------
        // PANEL - CARDS ROAD
        // ------------------
        JPanel panelCardRoad = new JPanel();
        panelCardRoad.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardRoad.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardRoad, 1);
        panelCardRoad.setBounds(1, 712, 1024, 150);
        layeredThurnplan.add(panelCardRoad);
        panelCardRoad.setLayout(new GridLayout(1, 10, 2, 0));

        final Dimension dimCard = new Dimension(10, 150);
        
        JButton btnLeftRoad = new JButton(toVertical("LEFT"));
        btnLeftRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        btnLeftRoad.setPreferredSize(dimCard);
        btnLeftRoad.setBackground(ColorUtils.PERU);
        btnLeftRoad.setForeground(new Color(255, 215, 0));
        btnLeftRoad.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnLeftRoad);
        
        JButton btnRoad1 = new JButton("");
        btnRoad1.setBackground(ColorUtils.PERU);
        btnRoad1.setPreferredSize(dimCard);
        btnRoad1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad1);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad1));
        
        JButton btnRoad2 = new JButton("");
        btnRoad2.setBackground(ColorUtils.PERU);
        btnRoad2.setPreferredSize(dimCard);
        btnRoad2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad2);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad2));

        JButton btnRoad3 = new JButton("");
        btnRoad3.setBackground(ColorUtils.PERU);
        btnRoad3.setPreferredSize(dimCard);
        btnRoad3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad3);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad3));
        
        JButton btnRoad4 = new JButton("");
        btnRoad4.setBackground(ColorUtils.PERU);
        btnRoad4.setPreferredSize(dimCard);
        btnRoad4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad4);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad4));
        
        JButton btnRoad5 = new JButton("");
        btnRoad5.setBackground(ColorUtils.PERU);
        btnRoad5.setPreferredSize(dimCard);
        btnRoad5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad5);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad5));

        JButton btnRoad6 = new JButton("");
        btnRoad6.setBackground(ColorUtils.PERU);
        btnRoad6.setPreferredSize(dimCard);
        btnRoad6.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad6);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad6));
        
        JButton btnRoad7 = new JButton("");
        btnRoad7.setBackground(ColorUtils.PERU);
        btnRoad7.setPreferredSize(dimCard);
        btnRoad7.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad7);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad7));

        JButton btnRoad8 = new JButton("");
        btnRoad8.setBackground(ColorUtils.PERU);
        btnRoad8.setPreferredSize(dimCard);
        btnRoad8.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnRoad8);
        allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad8));

        JButton btnRightRoad = new JButton(toVertical("RIGHT"));
        btnRightRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        btnRightRoad.setBackground(ColorUtils.PERU);
        btnRightRoad.setForeground(new Color(255, 215, 0));
        btnRightRoad.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
        btnRightRoad.setPreferredSize(dimCard);
        panelCardRoad.add(btnRightRoad);
        
        // ----------------
        // LABELS - PLAYERS
        // ----------------
        
        JPanel panelLabelPlayer1 = new JPanel();
        panelLabelPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer1.setBackground(ColorUtils.PERU);
        panelLabelPlayer1.setBounds(1024, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer1);

        JLabel lblPlayer1 = new JLabel(this.p1.getName());
        lblPlayer1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer1.add(lblPlayer1);
        lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer1.setBackground(ColorUtils.SANDY_BROWN);

        JPanel panelLabelPlayer2 = new JPanel();
        panelLabelPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer2.setBackground(ColorUtils.PERU);
        panelLabelPlayer2.setBounds(1310, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer2);

        JLabel lblPlayer2 = new JLabel("Player 2");
        lblPlayer2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer2.add(lblPlayer2);
        lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer2.setBackground(ColorUtils.SANDY_BROWN);

        JPanel panelLabelPlayer3 = new JPanel();
        panelLabelPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer3.setBackground(ColorUtils.PERU);
        panelLabelPlayer3.setBounds(1024, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer3);

        JLabel lblPlayer3 = new JLabel("Player 3");
        lblPlayer3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer3.add(lblPlayer3);
        lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer3.setBackground(ColorUtils.SANDY_BROWN);

        JPanel panelLabelPlayer4 = new JPanel();
        panelLabelPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer4.setBackground(ColorUtils.PERU);
        panelLabelPlayer4.setBounds(1310, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer4);

        JLabel lblPlayer4 = new JLabel("Player 4");
        lblPlayer4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer4.add(lblPlayer4);
        lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer4.setBackground(ColorUtils.SANDY_BROWN);
        
        // ----------------
        // PANEL - JOUEUR 1
        // ----------------

        JPanel panelItemPlayer1 = new JPanel();
        panelItemPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        panelItemPlayer1.setBackground(ColorUtils.PERU);
        panelItemPlayer1.setBounds(1024, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer1);
        panelItemPlayer1.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 4; i++) {
            JLabel lblNewLabel_2 = this.createLabelItemPlayer();
            panelItemPlayer1.add(lblNewLabel_2);
        }

        JPanel panelCardsPlayer1 = new JPanel();
        panelCardsPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer1.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.setBounds(1167, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer1);
        panelCardsPlayer1.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 6; i++) {
            JButton label_36 = this.createButtonCardPlayer();
            panelCardsPlayer1.add(label_36);
            this.p1.getListHandCityCards().add(new CityCard(label_36));
        }

        // ----------------
        // PANEL - JOUEUR 2
        // ----------------

        JPanel panelItemPlayer2 = new JPanel();
        panelItemPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        panelItemPlayer2.setBackground(ColorUtils.PERU);
        panelItemPlayer2.setBounds(1310, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer2);
        panelItemPlayer2.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 4; i++) {
            JLabel label_42 = this.createLabelItemPlayer();
            panelItemPlayer2.add(label_42);
        }

        JPanel panelCardsPlayer2 = new JPanel();
        panelCardsPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer2.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.setBounds(1453, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer2);
        panelCardsPlayer2.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 6; i++) {
            JButton label_48 = this.createButtonCardPlayer();
            panelCardsPlayer2.add(label_48);
        }
        
        // ----------------
        // PANEL - JOUEUR 3
        // ----------------

        JPanel panelItemPlayer3 = new JPanel();
        panelItemPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelItemPlayer3.setBackground(ColorUtils.PERU);
        panelItemPlayer3.setBounds(1024, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer3);
        panelItemPlayer3.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 4; i++) {
            JLabel label = this.createLabelItemPlayer();
            panelItemPlayer3.add(label);
        }

        JPanel panelCardsPlayer3 = new JPanel();
        panelCardsPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer3.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.setBounds(1167, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer3);
        panelCardsPlayer3.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 6; i++) {
            JButton label_6 = this.createButtonCardPlayer();
            panelCardsPlayer3.add(label_6);
        }
        
        // ----------------
        // PANEL - JOUEUR 4
        // ----------------

        JPanel panelItemPlayer4 = new JPanel();
        panelItemPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelItemPlayer4.setBackground(ColorUtils.PERU);
        panelItemPlayer4.setBounds(1310, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer4);
        panelItemPlayer4.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 4; i++) {
            JLabel label_12 = this.createLabelItemPlayer();
            panelItemPlayer4.add(label_12);
        }

        JPanel panelCardsPlayer4 = new JPanel();
        panelCardsPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer4.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.setBounds(1453, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer4);
        panelCardsPlayer4.setLayout(new GridLayout(0, 1, 2, 2));

        for (int i = 0; i < 6; i++) {
            JButton label_18 = this.createButtonCardPlayer();
            panelCardsPlayer4.add(label_18);
        }

        // -----------------
        // PANEL - OFFICIALS
        // -----------------
        
        JPanel panelOfficials = new JPanel();
        panelOfficials.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelOfficials.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelOfficials, 1);
        panelOfficials.setBounds(1025, 712, 427, 150);
        layeredThurnplan.add(panelOfficials);
        GridLayout gl_panelOfficials = new GridLayout(2, 3);
        gl_panelOfficials.setVgap(1);
        gl_panelOfficials.setHgap(2);
        panelOfficials.setLayout(gl_panelOfficials);
        
        JButton btnDiscardRoad = new JButton("DISCARD");
        btnDiscardRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelOfficials.add(btnDiscardRoad);
        btnDiscardRoad.setBackground(ColorUtils.PERU);
        btnDiscardRoad.setForeground(new Color(255, 215, 0));
        btnDiscardRoad.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
        allItems.getAllButtons().setBtnDiscardRoad(btnDiscardRoad);
        
        JButton btnAdministrator = new JButton("");
        btnAdministrator.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/administratorTile.png")));
        panelOfficials.add(btnAdministrator);
        btnAdministrator.setToolTipText(EnumOfficials.ADMINISTRATOR.getName());
        btnAdministrator.setBackground(ColorUtils.PERU);
        allItems.getAllButtons().getListOfficialsButtons().add(btnAdministrator);
        
        JButton btnPostmaster = new JButton("");
        btnPostmaster.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/postmasterTile.png")));
        panelOfficials.add(btnPostmaster);
        btnPostmaster.setToolTipText(EnumOfficials.POSTMASTER.getName());
        btnPostmaster.setBackground(ColorUtils.PERU);
        allItems.getAllButtons().getListOfficialsButtons().add(btnPostmaster);
        
        JButton btnBuildRoad = new JButton("BUILD");
        btnBuildRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelOfficials.add(btnBuildRoad);
        btnBuildRoad.setBackground(ColorUtils.PERU);
        btnBuildRoad.setForeground(new Color(255, 215, 0));
        btnBuildRoad.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
        allItems.getAllButtons().setBtnBuildRoad(btnBuildRoad);
        
        JButton btnPostalCarrier = new JButton("");
        btnPostalCarrier.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/postalCarrierTile.png")));
        panelOfficials.add(btnPostalCarrier);
        btnPostalCarrier.setToolTipText(EnumOfficials.POSTAL_CARRIER.getName());
        btnPostalCarrier.setBackground(ColorUtils.PERU);
        allItems.getAllButtons().getListOfficialsButtons().add(btnPostalCarrier);
        
        JButton btnCartwright = new JButton("");
        btnCartwright.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/cartwrightTile.png")));
        panelOfficials.add(btnCartwright);
        btnCartwright.setToolTipText(EnumOfficials.CARTWRIGHT.getName());
        btnCartwright.setBackground(ColorUtils.PERU);
        allItems.getAllButtons().getListOfficialsButtons().add(btnCartwright);
        
        JButton btnDeckCard = new JButton("");
        btnDeckCard.setIcon(game.getGameParams().getBackCardImage());
        layeredThurnplan.setLayer(btnDeckCard, 1);
        btnDeckCard.setBounds(1452, 712, 100, 150);
        layeredThurnplan.add(btnDeckCard);
        btnDeckCard.setToolTipText("Take one");
        allItems.getAllButtons().setBtnDeckCard(btnDeckCard);
        
        // -----------------------
        // PANEL - CARDS REMAINING
        // -----------------------
        
        JPanel panelNbCardRemaining = new JPanel();
        // panelNbCardRemaining.setBorder(new EtchedBorder(EtchedBorder.LOWERED, ColorUtils.SANDY_BROWN, null));
        panelNbCardRemaining.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        panelNbCardRemaining.setBackground(ColorUtils.PERU);
        panelNbCardRemaining.setBounds(1552, 712, 42, 150);
        layeredThurnplan.add(panelNbCardRemaining, 1);
        GridLayout gl_panelCardRemaining = new GridLayout(3, 1);
        gl_panelCardRemaining.setVgap(1);
        panelNbCardRemaining.setLayout(gl_panelCardRemaining);
        
        panelNbCardRemaining.add(new JLabel());
        JLabel lblNbCardRemaining = new JLabel(String.valueOf(game.getListCityCards().size()));
        panelNbCardRemaining.add(lblNbCardRemaining);
        lblNbCardRemaining.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
        lblNbCardRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton btnRules = new JButton();
        btnRules.setBackground(ColorUtils.PERU);
        btnRules.setIcon(new ImageIcon(ConstantesStatics.RACINE_IMG_ICONS + "rules_sifflet.jpg"));
        panelNbCardRemaining.add(btnRules);
        allItems.getAllButtons().setBtnRules(btnRules);
        allItems.getAllLabels().setLblNbCardRemaining(lblNbCardRemaining);

        final Dimension screenSize = this.getScreenResolution();

        if (screenSize != null) {
            this.setSize(screenSize);
            this.setVisible(true);
        } else {
            this.dispose();
        }
        
        return allItems;
    }

    private JButton createButtonCardPlayer() {
        final JButton label_36 = new JButton("");
        label_36.setHorizontalAlignment(SwingConstants.CENTER);
        label_36.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_36.setBackground(ColorUtils.PERU);
        return label_36;
    }

    private JLabel createLabelItemPlayer() {
        final JLabel label_12 = new JLabel("");
        label_12.setHorizontalAlignment(SwingConstants.CENTER);
        label_12.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_12.setBackground(ColorUtils.PERU);
        return label_12;
    }

    private Dimension getScreenResolution() {

        final String[] resolutions = EnumResolution.getAllResolutions();
        final String screenResolution = (String) JOptionPane.showInputDialog(null, "What is your screen resolution?", "Screen Resolution",
                        JOptionPane.QUESTION_MESSAGE, null, resolutions, resolutions[0]);
        final EnumResolution enumResolution = EnumResolution.getEnumResolutionByValue(screenResolution);
        return screenResolution != null ? EnumResolution.getDimensionByResolution(enumResolution) : null;
    }
    
    private static String toVertical(String s) {
        StringBuffer b = new StringBuffer("<HTML>");
        for (int i = 0; i < s.length(); ++i) {
            b.append(s.charAt(i)).append("<BR>");
        }
        return b.append("</HTML>").toString();
    }
    
}
