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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.project.thurnandtaxis.data.beans.AllItems;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.beans.Player;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;
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
        lblPlayer1.setVerticalAlignment(SwingConstants.BOTTOM);
        lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        panelLabelPlayer1.add(lblPlayer1);
        layeredThurnplan.setLayer(lblPlayer1, 0);
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

        JLabel lblNewLabel_2 = new JLabel("lblNewLabel_2");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        lblNewLabel_2.setBackground(ColorUtils.PERU);
        panelItemPlayer1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("lblNewLabel_3");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        lblNewLabel_3.setBackground(ColorUtils.PERU);
        panelItemPlayer1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("lblNewLabel_4");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        lblNewLabel_4.setBackground(ColorUtils.PERU);
        panelItemPlayer1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("lblNewLabel_5");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        lblNewLabel_5.setBackground(ColorUtils.PERU);
        panelItemPlayer1.add(lblNewLabel_5);

        JPanel panelCardsPlayer1 = new JPanel();
        panelCardsPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer1.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.setBounds(1167, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer1);
        panelCardsPlayer1.setLayout(new GridLayout(0, 1, 2, 2));

        JButton label_36 = new JButton("");
        label_36.setHorizontalAlignment(SwingConstants.CENTER);
        label_36.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_36.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.add(label_36);
        this.p1.getListHandCityCards().add(new CityCard(label_36));

        JButton label_37 = new JButton("");
        label_37.setHorizontalAlignment(SwingConstants.CENTER);
        label_37.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_37.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.add(label_37);
        this.p1.getListHandCityCards().add(new CityCard(label_37));

        JButton label_38 = new JButton("");
        label_38.setHorizontalAlignment(SwingConstants.CENTER);
        label_38.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_38.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.add(label_38);
        this.p1.getListHandCityCards().add(new CityCard(label_38));

        JButton label_39 = new JButton("");
        label_39.setHorizontalAlignment(SwingConstants.CENTER);
        label_39.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_39.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.add(label_39);
        this.p1.getListHandCityCards().add(new CityCard(label_39));

        JButton label_40 = new JButton("");
        label_40.setHorizontalAlignment(SwingConstants.CENTER);
        label_40.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_40.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.add(label_40);
        this.p1.getListHandCityCards().add(new CityCard(label_40));

        JButton label_41 = new JButton("");
        label_41.setHorizontalAlignment(SwingConstants.CENTER);
        label_41.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_41.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.add(label_41);
        this.p1.getListHandCityCards().add(new CityCard(label_41));

        // ----------------
        // PANEL - JOUEUR 2
        // ----------------

        JPanel panelItemPlayer2 = new JPanel();
        panelItemPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        panelItemPlayer2.setBackground(ColorUtils.PERU);
        panelItemPlayer2.setBounds(1310, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer2);
        panelItemPlayer2.setLayout(new GridLayout(0, 1, 2, 2));

        JLabel label_42 = new JLabel("");
        label_42.setHorizontalAlignment(SwingConstants.CENTER);
        label_42.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_42.setBackground(ColorUtils.PERU);
        panelItemPlayer2.add(label_42);

        JLabel label_43 = new JLabel("");
        label_43.setHorizontalAlignment(SwingConstants.CENTER);
        label_43.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_43.setBackground(ColorUtils.PERU);
        panelItemPlayer2.add(label_43);

        JLabel label_44 = new JLabel("");
        label_44.setHorizontalAlignment(SwingConstants.CENTER);
        label_44.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_44.setBackground(ColorUtils.PERU);
        panelItemPlayer2.add(label_44);

        JLabel label_45 = new JLabel("");
        label_45.setHorizontalAlignment(SwingConstants.CENTER);
        label_45.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_45.setBackground(ColorUtils.PERU);
        panelItemPlayer2.add(label_45);

        JPanel panelCardsPlayer2 = new JPanel();
        panelCardsPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer2.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.setBounds(1453, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer2);
        panelCardsPlayer2.setLayout(new GridLayout(0, 1, 2, 2));

        JButton label_48 = new JButton("");
        label_48.setHorizontalAlignment(SwingConstants.CENTER);
        label_48.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_48.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.add(label_48);

        JButton label_49 = new JButton("");
        label_49.setHorizontalAlignment(SwingConstants.CENTER);
        label_49.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_49.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.add(label_49);

        JButton label_50 = new JButton("");
        label_50.setHorizontalAlignment(SwingConstants.CENTER);
        label_50.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_50.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.add(label_50);

        JButton label_51 = new JButton("");
        label_51.setHorizontalAlignment(SwingConstants.CENTER);
        label_51.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_51.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.add(label_51);

        JButton label_52 = new JButton("");
        label_52.setHorizontalAlignment(SwingConstants.CENTER);
        label_52.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_52.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.add(label_52);

        JButton label_53 = new JButton("");
        label_53.setHorizontalAlignment(SwingConstants.CENTER);
        label_53.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_53.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.add(label_53);
        
        // ----------------
        // PANEL - JOUEUR 3
        // ----------------

        JPanel panelItemPlayer3 = new JPanel();
        panelItemPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelItemPlayer3.setBackground(ColorUtils.PERU);
        panelItemPlayer3.setBounds(1024, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer3);
        panelItemPlayer3.setLayout(new GridLayout(0, 1, 2, 2));

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label.setBackground(ColorUtils.PERU);
        panelItemPlayer3.add(label);

        JLabel label_1 = new JLabel("");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_1.setBackground(ColorUtils.PERU);
        panelItemPlayer3.add(label_1);

        JLabel label_2 = new JLabel("");
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_2.setBackground(ColorUtils.PERU);
        panelItemPlayer3.add(label_2);

        JLabel label_3 = new JLabel("");
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        label_3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_3.setBackground(ColorUtils.PERU);
        panelItemPlayer3.add(label_3);

        JPanel panelCardsPlayer3 = new JPanel();
        panelCardsPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer3.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.setBounds(1167, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer3);
        panelCardsPlayer3.setLayout(new GridLayout(0, 1, 2, 2));

        JButton label_6 = new JButton("");
        label_6.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_6.setHorizontalAlignment(SwingConstants.CENTER);
        label_6.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.add(label_6);

        JButton label_7 = new JButton("");
        label_7.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_7.setHorizontalAlignment(SwingConstants.CENTER);
        label_7.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.add(label_7);

        JButton label_8 = new JButton("");
        label_8.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_8.setHorizontalAlignment(SwingConstants.CENTER);
        label_8.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.add(label_8);

        JButton label_9 = new JButton("");
        label_9.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_9.setHorizontalAlignment(SwingConstants.CENTER);
        label_9.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.add(label_9);

        JButton label_10 = new JButton("");
        label_10.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_10.setHorizontalAlignment(SwingConstants.CENTER);
        label_10.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.add(label_10);

        JButton label_11 = new JButton("");
        label_11.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_11.setHorizontalAlignment(SwingConstants.CENTER);
        label_11.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.add(label_11);
        
        // ----------------
        // PANEL - JOUEUR 4
        // ----------------

        JPanel panelItemPlayer4 = new JPanel();
        panelItemPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelItemPlayer4.setBackground(ColorUtils.PERU);
        panelItemPlayer4.setBounds(1310, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer4);
        panelItemPlayer4.setLayout(new GridLayout(0, 1, 2, 2));

        JLabel label_12 = new JLabel("");
        label_12.setHorizontalAlignment(SwingConstants.CENTER);
        label_12.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_12.setBackground(ColorUtils.PERU);
        panelItemPlayer4.add(label_12);

        JLabel label_13 = new JLabel("");
        label_13.setHorizontalAlignment(SwingConstants.CENTER);
        label_13.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_13.setBackground(ColorUtils.PERU);
        panelItemPlayer4.add(label_13);

        JLabel label_14 = new JLabel("");
        label_14.setHorizontalAlignment(SwingConstants.CENTER);
        label_14.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_14.setBackground(ColorUtils.PERU);
        panelItemPlayer4.add(label_14);

        JLabel label_15 = new JLabel("");
        label_15.setHorizontalAlignment(SwingConstants.CENTER);
        label_15.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_15.setBackground(ColorUtils.PERU);
        panelItemPlayer4.add(label_15);

        JPanel panelCardsPlayer4 = new JPanel();
        panelCardsPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer4.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.setBounds(1453, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer4);
        panelCardsPlayer4.setLayout(new GridLayout(0, 1, 2, 2));

        JButton label_18 = new JButton("");
        label_18.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_18.setHorizontalAlignment(SwingConstants.CENTER);
        label_18.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.add(label_18);

        JButton label_19 = new JButton("");
        label_19.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_19.setHorizontalAlignment(SwingConstants.CENTER);
        label_19.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.add(label_19);

        JButton label_20 = new JButton("");
        label_20.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_20.setHorizontalAlignment(SwingConstants.CENTER);
        label_20.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.add(label_20);

        JButton label_21 = new JButton("");
        label_21.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_21.setHorizontalAlignment(SwingConstants.CENTER);
        label_21.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.add(label_21);

        JButton label_22 = new JButton("");
        label_22.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_22.setHorizontalAlignment(SwingConstants.CENTER);
        label_22.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.add(label_22);

        JButton label_23 = new JButton("");
        label_23.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        label_23.setHorizontalAlignment(SwingConstants.CENTER);
        label_23.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.add(label_23);

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
        panelNbCardRemaining.add(new JLabel());
        allItems.getAllLabels().setLblNbCardRemaining(lblNbCardRemaining);

        this.setSize(1600, 900);
        this.setVisible(true);
        
        return allItems;
    }
    
    private static String toVertical(String s) {
        StringBuffer b = new StringBuffer("<HTML>");
        for (int i = 0; i < s.length(); ++i) {
            b.append(s.charAt(i)).append("<BR>");
        }
        return b.append("</HTML>").toString();
    }
    
}
