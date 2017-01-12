package com.project.thurnandtaxis.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.CityCard;
import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.enumerations.EnumOfficials;

public class InterfaceJeu extends JFrame {
    
    private static final long serialVersionUID = 3006307486047180080L;
    
    private JLabel lblNbCardRemaining;
    private JButton btnDeckCard;
    private JButton btnAdministrator;
    private JButton btnPostmaster;
    private JButton btnPostalCarrier;
    private JButton btnCartwright;
    private List<CityCard> listeCardsVisible;
    private List<CityCard> listeCardsHand;
    private List<CityCard> listeCardsRoad;
    private List<JButton> listeButtonsOfficials;

    public InterfaceJeu() {
        this.listeCardsVisible = Lists.newArrayList();
        this.listeCardsHand = Lists.newArrayList();
        this.listeCardsRoad = Lists.newArrayList();
        this.listeButtonsOfficials = Lists.newArrayList();
    }
    
    public void createInterface(final Game game) {
        this.setTitle("Thurn and Taxis");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredThurnplan = new JLayeredPane();
        layeredThurnplan.setBackground(new Color(244, 164, 96));
        this.getContentPane().add(layeredThurnplan, BorderLayout.CENTER);

        JLabel lblThurnplan = new JLabel("");
        lblThurnplan.setBounds(0, 0, 1024, 712);
        layeredThurnplan.add(lblThurnplan, 0);
        lblThurnplan.setHorizontalAlignment(SwingConstants.CENTER);
        lblThurnplan.setIcon(game.getGameParams().getGameBoardImage());

        // ---------------
        // CARDS VISIBLES
        // ---------------
        JPanel panelCardVisible = new JPanel();
        panelCardVisible.setBackground(new Color(205, 133, 63));
        layeredThurnplan.setLayer(panelCardVisible, 1);
        panelCardVisible.setBounds(20, 225, 167, 375);
        panelCardVisible.setVisible(true);
        layeredThurnplan.add(panelCardVisible, 1);
        panelCardVisible.setLayout(new GridLayout(3, 2, 3, 3));

        JButton cardVisible1 = new JButton("");
        cardVisible1.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible1);
        layeredThurnplan.setLayer(cardVisible1, 1);
        this.listeCardsVisible.add(new CityCard(cardVisible1));

        JButton cardVisible2 = new JButton("");
        cardVisible2.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible2);
        layeredThurnplan.setLayer(cardVisible2, 1);
        this.listeCardsVisible.add(new CityCard(cardVisible2));

        JButton cardVisible3 = new JButton("");
        cardVisible3.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible3);
        this.listeCardsVisible.add(new CityCard(cardVisible3));

        JButton cardVisible4 = new JButton("");
        cardVisible4.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible4);
        this.listeCardsVisible.add(new CityCard(cardVisible4));

        JButton cardVisible5 = new JButton("");
        cardVisible5.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible5);
        this.listeCardsVisible.add(new CityCard(cardVisible5));

        JButton cardVisible6 = new JButton("");
        cardVisible6.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible6);
        this.listeCardsVisible.add(new CityCard(cardVisible6));

        JButton btnBonusBaden = new JButton("");
        btnBonusBaden.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/baden/bonusbaden3.png")));
        btnBonusBaden.setBackground(new Color(244, 164, 96));
        btnBonusBaden.setToolTipText("Bonus Baden");
        btnBonusBaden.setBounds(429, 123, 34, 34);
        layeredThurnplan.add(btnBonusBaden, new Integer(1));
        
        JButton btnBonusBohmen = new JButton("");
        btnBonusBohmen.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/bohmen/bonusbohmen4.png")));
        btnBonusBohmen.setToolTipText("Bonus Bohmen");
        btnBonusBohmen.setBackground(new Color(244, 164, 96));
        btnBonusBohmen.setBounds(906, 381, 34, 34);
        layeredThurnplan.add(btnBonusBohmen, new Integer(1));
        
        JButton btnBonusBaiern = new JButton("");
        btnBonusBaiern.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/baiern/bonusbaiern5.png")));
        btnBonusBaiern.setToolTipText("Bonus Baiern");
        btnBonusBaiern.setBackground(new Color(244, 164, 96));
        btnBonusBaiern.setBounds(737, 388, 34, 34);
        layeredThurnplan.add(btnBonusBaiern, new Integer(1));
        
        JButton btnBonusSchweiz = new JButton("");
        btnBonusSchweiz.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/schweiz/bonusschweiz3.png")));
        btnBonusSchweiz.setToolTipText("Bonus Schweiz");
        btnBonusSchweiz.setBackground(new Color(244, 164, 96));
        btnBonusSchweiz.setBounds(394, 659, 34, 34);
        layeredThurnplan.add(btnBonusSchweiz, new Integer(1));
        
        JButton btnBonusWruttemberg = new JButton("");
        btnBonusWruttemberg.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/wurttemberg/bonuswurttemberg3.png")));
        btnBonusWruttemberg.setToolTipText("Bonus Wruttemberg");
        btnBonusWruttemberg.setBackground(new Color(244, 164, 96));
        btnBonusWruttemberg.setBounds(378, 366, 34, 34);
        layeredThurnplan.add(btnBonusWruttemberg, new Integer(1));
        
        JButton btnBonusLongRoad5 = new JButton("");
        btnBonusLongRoad5.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong5/bonus52.png")));
        btnBonusLongRoad5.setToolTipText("Bonus Long Road 5");
        btnBonusLongRoad5.setBackground(new Color(244, 164, 96));
        btnBonusLongRoad5.setBounds(32, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad5, new Integer(1));
        
        JButton btnBonusLongRoad6 = new JButton("");
        btnBonusLongRoad6.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong6/bonus63.png")));
        btnBonusLongRoad6.setToolTipText("Bonus Long Road 6");
        btnBonusLongRoad6.setBackground(new Color(244, 164, 96));
        btnBonusLongRoad6.setBounds(85, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad6, new Integer(1));
        
        JButton btnBonusLongRoad7 = new JButton("");
        btnBonusLongRoad7.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong7/bonus74.png")));
        btnBonusLongRoad7.setToolTipText("Bonus Long Road 7");
        btnBonusLongRoad7.setBackground(new Color(244, 164, 96));
        btnBonusLongRoad7.setBounds(140, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad7, new Integer(1));

        JButton btnBonusAll = new JButton("");
        btnBonusAll.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/com/project/thurnandtaxis/statics/img/allprovinces/bonusall6.png")));
        btnBonusAll.setToolTipText("Bonus all");
        btnBonusAll.setBackground(new Color(244, 164, 96));
        btnBonusAll.setBounds(326, 65, 35, 35);
        layeredThurnplan.add(btnBonusAll, new Integer(1));

        JButton btnBonusEnd = new JButton("");
        btnBonusEnd.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/com/project/thurnandtaxis/statics/img/endgamebonus/bonusend0.png")));
        btnBonusEnd.setToolTipText("Bonus end");
        btnBonusEnd.setBackground(new Color(244, 164, 96));
        btnBonusEnd.setBounds(326, 25, 35, 35);
        layeredThurnplan.add(btnBonusEnd, new Integer(1));

        JPanel panelCardCaleche = new JPanel();
        panelCardCaleche.setBackground(new Color(205, 133, 63));
        layeredThurnplan.setLayer(panelCardCaleche, 1);
        panelCardCaleche.setBounds(390, 24, 603, 75);
        layeredThurnplan.add(panelCardCaleche);
        panelCardCaleche.setLayout(new GridLayout(0, 5, 1, 0));
        
        JButton btnCaleche1 = new JButton("");
        btnCaleche1.setBackground(new Color(244, 164, 96));
        panelCardCaleche.add(btnCaleche1);
        
        JButton btnCaleche2 = new JButton("");
        btnCaleche2.setBackground(new Color(244, 164, 96));
        panelCardCaleche.add(btnCaleche2);
        
        JButton btnCaleche3 = new JButton("");
        btnCaleche3.setBackground(new Color(244, 164, 96));
        panelCardCaleche.add(btnCaleche3);
        
        JButton btnCaleche4 = new JButton("");
        btnCaleche4.setBackground(new Color(244, 164, 96));
        panelCardCaleche.add(btnCaleche4);
        
        JButton btnCaleche5 = new JButton("");
        btnCaleche5.setBackground(new Color(244, 164, 96));
        panelCardCaleche.add(btnCaleche5);
        
        JPanel panelCardsHandAndRoad = new JPanel();
        panelCardsHandAndRoad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsHandAndRoad.setBackground(new Color(205, 133, 63));
        layeredThurnplan.setLayer(panelCardsHandAndRoad, 1);
        panelCardsHandAndRoad.setBounds(1, 712, 1024, 150);
        layeredThurnplan.add(panelCardsHandAndRoad);
        panelCardsHandAndRoad.setLayout(new GridLayout(1, 2, 1, 20));

        // -----------------------
        // CARDS IN PLAYER'S HAND
        // -----------------------
        JPanel panelCardHand = new JPanel();
        panelCardHand.setBackground(new Color(205, 133, 63));
        panelCardsHandAndRoad.add(panelCardHand);
        panelCardHand.setLayout(new GridLayout(1, 6, 2, 0));
        
        final Dimension dimCard = new Dimension(10, 150);

        JButton btnCardHand1 = new JButton("");
        btnCardHand1.setPreferredSize(dimCard);
        btnCardHand1.setBackground(new Color(205, 133, 63));
        btnCardHand1.setForeground(new Color(255, 215, 0));
        panelCardHand.add(btnCardHand1);
        this.listeCardsHand.add(new CityCard(btnCardHand1));

        JButton btnCardHand2 = new JButton("");
        btnCardHand2.setBackground(new Color(205, 133, 63));
        btnCardHand2.setPreferredSize(dimCard);
        panelCardHand.add(btnCardHand2);
        this.listeCardsHand.add(new CityCard(btnCardHand2));

        JButton btnCardHand3 = new JButton("");
        btnCardHand3.setBackground(new Color(205, 133, 63));
        btnCardHand3.setPreferredSize(dimCard);
        panelCardHand.add(btnCardHand3);
        this.listeCardsHand.add(new CityCard(btnCardHand3));
        
        JButton btnCardHand4 = new JButton("");
        btnCardHand4.setBackground(new Color(205, 133, 63));
        btnCardHand4.setPreferredSize(dimCard);
        panelCardHand.add(btnCardHand4);
        this.listeCardsHand.add(new CityCard(btnCardHand4));

        JButton btnCardHand5 = new JButton("");
        btnCardHand5.setBackground(new Color(205, 133, 63));
        btnCardHand5.setPreferredSize(dimCard);
        panelCardHand.add(btnCardHand5);
        this.listeCardsHand.add(new CityCard(btnCardHand5));

        JButton btnCardHand6 = new JButton("");
        btnCardHand6.setBackground(new Color(205, 133, 63));
        btnCardHand6.setPreferredSize(dimCard);
        panelCardHand.add(btnCardHand6);
        this.listeCardsHand.add(new CityCard(btnCardHand6));
        
        // --------------------
        // CARDS PLAYER'S ROAD
        // --------------------
        JPanel panelCardRoad = new JPanel();
        panelCardRoad.setBackground(new Color(205, 133, 63));
        panelCardsHandAndRoad.add(panelCardRoad);
        panelCardRoad.setLayout(new GridLayout(1, 6, 2, 0));

        JButton btnRoad = new JButton("");
        btnRoad.setBackground(new Color(205, 133, 63));
        btnRoad.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad);
        this.listeCardsRoad.add(new CityCard(btnRoad));

        JButton btnRoad_1 = new JButton("");
        btnRoad_1.setBackground(new Color(205, 133, 63));
        btnRoad_1.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_1);
        this.listeCardsRoad.add(new CityCard(btnRoad_1));

        JButton btnRoad_2 = new JButton("");
        btnRoad_2.setBackground(new Color(205, 133, 63));
        btnRoad_2.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_2);
        this.listeCardsRoad.add(new CityCard(btnRoad_2));

        JButton btnRoad_3 = new JButton("");
        btnRoad_3.setBackground(new Color(205, 133, 63));
        btnRoad_3.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_3);
        this.listeCardsRoad.add(new CityCard(btnRoad_3));

        JButton btnRoad_4 = new JButton("");
        btnRoad_4.setBackground(new Color(205, 133, 63));
        btnRoad_4.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_4);
        this.listeCardsRoad.add(new CityCard(btnRoad_4));

        JButton btnRoad_5 = new JButton("");
        btnRoad_5.setBackground(new Color(205, 133, 63));
        btnRoad_5.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_5);
        this.listeCardsRoad.add(new CityCard(btnRoad_5));
        
        JPanel panelLabelPlayer1 = new JPanel();
        panelLabelPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelLabelPlayer1.setBackground(new Color(205, 133, 63));
        panelLabelPlayer1.setBounds(1024, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer1);

        JLabel lblPlayer1 = new JLabel(game.getListPlayers().get(0).getName());
        lblPlayer1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        lblPlayer1.setVerticalAlignment(SwingConstants.BOTTOM);
        lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        panelLabelPlayer1.add(lblPlayer1);
        layeredThurnplan.setLayer(lblPlayer1, 0);
        lblPlayer1.setBackground(new Color(244, 164, 96));
        
        JPanel panelLabelPlayer2 = new JPanel();
        panelLabelPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelLabelPlayer2.setBackground(new Color(205, 133, 63));
        panelLabelPlayer2.setBounds(1310, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer2);
        
        JLabel lblPlayer2 = new JLabel("Player 2");
        lblPlayer2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer2.add(lblPlayer2);
        lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer2.setBackground(new Color(244, 164, 96));
        
        JPanel panelLabelPlayer3 = new JPanel();
        panelLabelPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelLabelPlayer3.setBackground(new Color(205, 133, 63));
        panelLabelPlayer3.setBounds(1024, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer3);
        
        JLabel lblPlayer3 = new JLabel("Player 3");
        lblPlayer3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer3.add(lblPlayer3);
        lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer3.setBackground(new Color(244, 164, 96));
        
        JPanel panelLabelPlayer4 = new JPanel();
        panelLabelPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelLabelPlayer4.setBackground(new Color(205, 133, 63));
        panelLabelPlayer4.setBounds(1310, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer4);
        
        JLabel lblPlayer4 = new JLabel("Player 4");
        lblPlayer4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer4.add(lblPlayer4);
        lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer4.setBackground(new Color(244, 164, 96));
        
        JPanel panelItemPlayer1 = new JPanel();
        panelItemPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer1.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.setBounds(1024, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer1);
        panelItemPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_7);
        
        JPanel panelCardsPlayer1 = new JPanel();
        panelCardsPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer1.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.setBounds(1167, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer1);
        panelCardsPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_36 = new JLabel("");
        label_36.setHorizontalAlignment(SwingConstants.CENTER);
        label_36.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_36);
        
        JLabel label_37 = new JLabel("");
        label_37.setHorizontalAlignment(SwingConstants.CENTER);
        label_37.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_37);
        
        JLabel label_38 = new JLabel("");
        label_38.setHorizontalAlignment(SwingConstants.CENTER);
        label_38.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_38);
        
        JLabel label_39 = new JLabel("");
        label_39.setHorizontalAlignment(SwingConstants.CENTER);
        label_39.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_39);
        
        JLabel label_40 = new JLabel("");
        label_40.setHorizontalAlignment(SwingConstants.CENTER);
        label_40.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_40);
        
        JLabel label_41 = new JLabel("");
        label_41.setHorizontalAlignment(SwingConstants.CENTER);
        label_41.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_41);
        
        JPanel panelItemPlayer2 = new JPanel();
        panelItemPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer2.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.setBounds(1310, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer2);
        panelItemPlayer2.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_42 = new JLabel("");
        label_42.setHorizontalAlignment(SwingConstants.CENTER);
        label_42.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_42);
        
        JLabel label_43 = new JLabel("");
        label_43.setHorizontalAlignment(SwingConstants.CENTER);
        label_43.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_43);
        
        JLabel label_44 = new JLabel("");
        label_44.setHorizontalAlignment(SwingConstants.CENTER);
        label_44.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_44);
        
        JLabel label_45 = new JLabel("");
        label_45.setHorizontalAlignment(SwingConstants.CENTER);
        label_45.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_45);
        
        JLabel label_46 = new JLabel("");
        label_46.setHorizontalAlignment(SwingConstants.CENTER);
        label_46.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_46);
        
        JLabel label_47 = new JLabel("");
        label_47.setHorizontalAlignment(SwingConstants.CENTER);
        label_47.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_47);
        
        JPanel panelCardsPlayer2 = new JPanel();
        panelCardsPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer2.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.setBounds(1453, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer2);
        panelCardsPlayer2.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_48 = new JLabel("");
        label_48.setHorizontalAlignment(SwingConstants.CENTER);
        label_48.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_48);
        
        JLabel label_49 = new JLabel("");
        label_49.setHorizontalAlignment(SwingConstants.CENTER);
        label_49.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_49);
        
        JLabel label_50 = new JLabel("");
        label_50.setHorizontalAlignment(SwingConstants.CENTER);
        label_50.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_50);
        
        JLabel label_51 = new JLabel("");
        label_51.setHorizontalAlignment(SwingConstants.CENTER);
        label_51.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_51);
        
        JLabel label_52 = new JLabel("");
        label_52.setHorizontalAlignment(SwingConstants.CENTER);
        label_52.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_52);
        
        JLabel label_53 = new JLabel("");
        label_53.setHorizontalAlignment(SwingConstants.CENTER);
        label_53.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_53);
        
        JPanel panelItemPlayer3 = new JPanel();
        panelItemPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer3.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.setBounds(1024, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer3);
        panelItemPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label);
        
        JLabel label_1 = new JLabel("");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_1);
        
        JLabel label_2 = new JLabel("");
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_2);
        
        JLabel label_3 = new JLabel("");
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        label_3.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_3);
        
        JLabel label_4 = new JLabel("");
        label_4.setHorizontalAlignment(SwingConstants.CENTER);
        label_4.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_4);
        
        JLabel label_5 = new JLabel("");
        label_5.setHorizontalAlignment(SwingConstants.CENTER);
        label_5.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_5);
        
        JPanel panelCardsPlayer3 = new JPanel();
        panelCardsPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer3.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.setBounds(1167, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer3);
        panelCardsPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_6 = new JLabel("");
        label_6.setHorizontalAlignment(SwingConstants.CENTER);
        label_6.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_6);
        
        JLabel label_7 = new JLabel("");
        label_7.setHorizontalAlignment(SwingConstants.CENTER);
        label_7.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_7);
        
        JLabel label_8 = new JLabel("");
        label_8.setHorizontalAlignment(SwingConstants.CENTER);
        label_8.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_8);
        
        JLabel label_9 = new JLabel("");
        label_9.setHorizontalAlignment(SwingConstants.CENTER);
        label_9.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_9);
        
        JLabel label_10 = new JLabel("");
        label_10.setHorizontalAlignment(SwingConstants.CENTER);
        label_10.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_10);
        
        JLabel label_11 = new JLabel("");
        label_11.setHorizontalAlignment(SwingConstants.CENTER);
        label_11.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_11);
        
        JPanel panelItemPlayer4 = new JPanel();
        panelItemPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer4.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.setBounds(1310, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer4);
        panelItemPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_12 = new JLabel("");
        label_12.setHorizontalAlignment(SwingConstants.CENTER);
        label_12.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_12);
        
        JLabel label_13 = new JLabel("");
        label_13.setHorizontalAlignment(SwingConstants.CENTER);
        label_13.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_13);
        
        JLabel label_14 = new JLabel("");
        label_14.setHorizontalAlignment(SwingConstants.CENTER);
        label_14.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_14);
        
        JLabel label_15 = new JLabel("");
        label_15.setHorizontalAlignment(SwingConstants.CENTER);
        label_15.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_15);
        
        JLabel label_16 = new JLabel("");
        label_16.setHorizontalAlignment(SwingConstants.CENTER);
        label_16.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_16);
        
        JLabel label_17 = new JLabel("");
        label_17.setHorizontalAlignment(SwingConstants.CENTER);
        label_17.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_17);
        
        JPanel panelCardsPlayer4 = new JPanel();
        panelCardsPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer4.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.setBounds(1453, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer4);
        panelCardsPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_18 = new JLabel("");
        label_18.setHorizontalAlignment(SwingConstants.CENTER);
        label_18.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_18);
        
        JLabel label_19 = new JLabel("");
        label_19.setHorizontalAlignment(SwingConstants.CENTER);
        label_19.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_19);
        
        JLabel label_20 = new JLabel("");
        label_20.setHorizontalAlignment(SwingConstants.CENTER);
        label_20.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_20);
        
        JLabel label_21 = new JLabel("");
        label_21.setHorizontalAlignment(SwingConstants.CENTER);
        label_21.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_21);
        
        JLabel label_22 = new JLabel("");
        label_22.setHorizontalAlignment(SwingConstants.CENTER);
        label_22.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_22);
        
        JLabel label_23 = new JLabel("");
        label_23.setHorizontalAlignment(SwingConstants.CENTER);
        label_23.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_23);

        JPanel panelOfficials = new JPanel();
        panelOfficials.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelOfficials.setBackground(new Color(205, 133, 63));
        layeredThurnplan.setLayer(panelOfficials, 1);
        panelOfficials.setBounds(1025, 712, 427, 150);
        layeredThurnplan.add(panelOfficials);
        GridLayout gl_panelOfficials = new GridLayout(2, 3);
        gl_panelOfficials.setVgap(1);
        gl_panelOfficials.setHgap(2);
        panelOfficials.setLayout(gl_panelOfficials);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelOfficials.add(btnCancel);
        btnCancel.setBackground(new Color(205, 133, 63));

        this.btnAdministrator = new JButton("");
        this.btnAdministrator.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/administratorTile.png")));
        panelOfficials.add(this.btnAdministrator);
        this.btnAdministrator.setToolTipText(EnumOfficials.ADMINISTRATOR.getName());
        this.btnAdministrator.setBackground(new Color(205, 133, 63));
        this.listeButtonsOfficials.add(this.btnAdministrator);

        this.btnPostmaster = new JButton("");
        this.btnPostmaster.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/postmasterTile.png")));
        panelOfficials.add(this.btnPostmaster);
        this.btnPostmaster.setToolTipText(EnumOfficials.POSTMASTER.getName());
        this.btnPostmaster.setBackground(new Color(205, 133, 63));
        this.listeButtonsOfficials.add(this.btnPostmaster);

        JButton btnValidate = new JButton("Validate");
        btnValidate.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelOfficials.add(btnValidate);
        btnValidate.setBackground(new Color(205, 133, 63));

        this.btnPostalCarrier = new JButton("");
        this.btnPostalCarrier.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/postalCarrierTile.png")));
        panelOfficials.add(this.btnPostalCarrier);
        this.btnPostalCarrier.setToolTipText(EnumOfficials.POSTAL_CARRIER.getName());
        this.btnPostalCarrier.setBackground(new Color(205, 133, 63));
        this.listeButtonsOfficials.add(this.btnPostalCarrier);

        this.btnCartwright = new JButton("");
        this.btnCartwright.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/cartwrightTile.png")));
        panelOfficials.add(this.btnCartwright);
        this.btnCartwright.setToolTipText(EnumOfficials.CARTWRIGHT.getName());
        this.btnCartwright.setBackground(new Color(205, 133, 63));
        this.listeButtonsOfficials.add(this.btnCartwright);

        this.btnDeckCard = new JButton("");
        this.btnDeckCard.setIcon(game.getGameParams().getBackCardImage());
        layeredThurnplan.setLayer(this.btnDeckCard, 1);
        this.btnDeckCard.setBounds(1452, 712, 100, 150);
        layeredThurnplan.add(this.btnDeckCard);
        this.btnDeckCard.setToolTipText(game.getListCityCards().size() + " cards remaining");
        
        JPanel panelNbCardRemaining = new JPanel();
        panelNbCardRemaining.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(244, 164, 96), null));
        panelNbCardRemaining.setBackground(new Color(205, 133, 63));
        panelNbCardRemaining.setBounds(1552, 712, 42, 150);
        layeredThurnplan.add(panelNbCardRemaining, 1);

        this.lblNbCardRemaining = new JLabel(String.valueOf(game.getListCityCards().size()));
        this.lblNbCardRemaining.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lblNbCardRemaining.setVerticalTextPosition(SwingConstants.BOTTOM);
        panelNbCardRemaining.add(this.lblNbCardRemaining);
        this.lblNbCardRemaining.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        
        this.setSize(1600, 900);
        this.setVisible(true);
    }

    // -------------------------
    // GETTERS / SETTERS Publics
    // -------------------------
    
    public JLabel getLblNbCardRemaining() {
        return this.lblNbCardRemaining;
    }

    public void setLblNbCardRemaining(JLabel lblNbCardRemaining) {
        this.lblNbCardRemaining = lblNbCardRemaining;
    }

    public JButton getBtnDeckCard() {
        return this.btnDeckCard;
    }
    
    public void setBtnDeckCard(JButton btnDeckCard) {
        this.btnDeckCard = btnDeckCard;
    }
    
    public List<CityCard> getListeCardsVisible() {
        return this.listeCardsVisible;
    }
    
    public void setListeCardsVisible(List<CityCard> listeCardsVisible) {
        this.listeCardsVisible = listeCardsVisible;
    }

    public List<CityCard> getListeCardsHand() {
        return this.listeCardsHand;
    }
    
    public void setListeCardsHand(List<CityCard> listeCardsHand) {
        this.listeCardsHand = listeCardsHand;
    }
    
    public List<JButton> getListeButtonsOfficials() {
        return this.listeButtonsOfficials;
    }
    
    public void setListeButtonsOfficials(List<JButton> listeButtonsOfficials) {
        this.listeButtonsOfficials = listeButtonsOfficials;
    }

    public List<CityCard> getListeCardsRoad() {
        return this.listeCardsRoad;
    }

    public void setListeCardsRoad(List<CityCard> listeCardsRoad) {
        this.listeCardsRoad = listeCardsRoad;
    }
}
