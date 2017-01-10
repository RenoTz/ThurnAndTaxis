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

import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.beans.Player;
import com.project.thurnandtaxis.utils.ColorUtils;

public class InterfaceJeu extends JFrame {
    
    private static final long serialVersionUID = 3006307486047180080L;
    
    private JButton btnDeckCard;

    public InterfaceJeu(final Game game, final List<Player> listPlayer) {
        this.setTitle("Thurn and Taxis");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredThurnplan = new JLayeredPane();
        layeredThurnplan.setBackground(ColorUtils.SANDY_BROWN);
        this.getContentPane().add(layeredThurnplan, BorderLayout.CENTER);

        JLabel lblThurnplan = new JLabel();
        lblThurnplan.setBounds(0, 0, 1024, 712);
        layeredThurnplan.add(lblThurnplan, 0);
        lblThurnplan.setHorizontalAlignment(SwingConstants.CENTER);
        lblThurnplan.setIcon(game.getGameParams().getGameBoardImage());

        JPanel panelCardVisible = new JPanel();
        panelCardVisible.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardVisible, 1);
        panelCardVisible.setBounds(20, 225, 167, 375);
        panelCardVisible.setVisible(true);
        layeredThurnplan.add(panelCardVisible, 1);
        panelCardVisible.setLayout(new GridLayout(3, 2, 10, 10));

        JButton cardVisible1 = new JButton();
        cardVisible1.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible1);
        layeredThurnplan.setLayer(cardVisible1, 1);

        JButton cardVisible2 = new JButton();
        cardVisible2.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible2);
        layeredThurnplan.setLayer(cardVisible2, 1);

        JButton cardVisible3 = new JButton();
        cardVisible3.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible3);

        JButton cardVisible4 = new JButton();
        cardVisible4.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible4);

        JButton cardVisible5 = new JButton();
        cardVisible5.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible5);

        JButton cardVisible6 = new JButton();
        cardVisible6.setBackground(ColorUtils.SANDY_BROWN);
        panelCardVisible.add(cardVisible6);

        JButton btnBonusBaden = new JButton();
        btnBonusBaden.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/baden/bonusbaden3.png")));
        btnBonusBaden.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusBaden.setToolTipText("Bonus Baden");
        btnBonusBaden.setBounds(429, 123, 34, 34);
        layeredThurnplan.add(btnBonusBaden, new Integer(1));
        
        JButton btnBonusBohmen = new JButton();
        btnBonusBohmen.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/bohmen/bonusbohmen4.png")));
        btnBonusBohmen.setToolTipText("Bonus Bohmen");
        btnBonusBohmen.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusBohmen.setBounds(906, 381, 34, 34);
        layeredThurnplan.add(btnBonusBohmen, new Integer(1));
        
        JButton btnBonusBaiern = new JButton();
        btnBonusBaiern.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/baiern/bonusbaiern5.png")));
        btnBonusBaiern.setToolTipText("Bonus Baiern");
        btnBonusBaiern.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusBaiern.setBounds(737, 388, 34, 34);
        layeredThurnplan.add(btnBonusBaiern, new Integer(1));
        
        JButton btnBonusSchweiz = new JButton();
        btnBonusSchweiz.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/schweiz/bonusschweiz3.png")));
        btnBonusSchweiz.setToolTipText("Bonus Schweiz");
        btnBonusSchweiz.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusSchweiz.setBounds(394, 659, 34, 34);
        layeredThurnplan.add(btnBonusSchweiz, new Integer(1));
        
        JButton btnBonusWruttemberg = new JButton();
        btnBonusWruttemberg.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonus_tile_city/wurttemberg/bonuswurttemberg3.png")));
        btnBonusWruttemberg.setToolTipText("Bonus Wruttemberg");
        btnBonusWruttemberg.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusWruttemberg.setBounds(378, 366, 34, 34);
        layeredThurnplan.add(btnBonusWruttemberg, new Integer(1));
        
        JButton btnBonusLongRoad5 = new JButton();
        btnBonusLongRoad5.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong5/bonus52.png")));
        btnBonusLongRoad5.setToolTipText("Bonus Long Road 5");
        btnBonusLongRoad5.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusLongRoad5.setBounds(32, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad5, new Integer(1));
        
        JButton btnBonusLongRoad6 = new JButton();
        btnBonusLongRoad6.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong6/bonus63.png")));
        btnBonusLongRoad6.setToolTipText("Bonus Long Road 6");
        btnBonusLongRoad6.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusLongRoad6.setBounds(85, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad6, new Integer(1));
        
        JButton btnBonusLongRoad7 = new JButton();
        btnBonusLongRoad7.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/bonustileroadlong/roadlong7/bonus74.png")));
        btnBonusLongRoad7.setToolTipText("Bonus Long Road 7");
        btnBonusLongRoad7.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusLongRoad7.setBounds(140, 635, 40, 40);
        layeredThurnplan.add(btnBonusLongRoad7, new Integer(1));

        JButton btnBonusAll = new JButton();
        btnBonusAll.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/com/project/thurnandtaxis/statics/img/allprovinces/bonusall6.png")));
        btnBonusAll.setToolTipText("Bonus all");
        btnBonusAll.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusAll.setBounds(326, 65, 35, 35);
        layeredThurnplan.add(btnBonusAll, new Integer(1));

        JButton btnBonusEnd = new JButton();
        btnBonusEnd.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/com/project/thurnandtaxis/statics/img/endgamebonus/bonusend0.png")));
        btnBonusEnd.setToolTipText("Bonus end");
        btnBonusEnd.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusEnd.setBounds(326, 25, 35, 35);
        layeredThurnplan.add(btnBonusEnd, new Integer(1));

        JPanel panelCardCaleche = new JPanel();
        panelCardCaleche.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardCaleche, 1);
        panelCardCaleche.setBounds(390, 24, 603, 75);
        layeredThurnplan.add(panelCardCaleche);
        panelCardCaleche.setLayout(new GridLayout(0, 5, 1, 0));
        
        JButton btnCaleche1 = new JButton();
        btnCaleche1.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche1);
        
        JButton btnCaleche2 = new JButton();
        btnCaleche2.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche2);
        
        JButton btnCaleche3 = new JButton();
        btnCaleche3.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche3);
        
        JButton btnCaleche4 = new JButton();
        btnCaleche4.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche4);
        
        JButton btnCaleche5 = new JButton();
        btnCaleche5.setBackground(ColorUtils.SANDY_BROWN);
        panelCardCaleche.add(btnCaleche5);
        
        JPanel panelCardsHandAndRoad = this.createPanelItemsCardsForPlayer();
        layeredThurnplan.setLayer(panelCardsHandAndRoad, 1);
        panelCardsHandAndRoad.setBounds(1, 712, 1024, 150);
        layeredThurnplan.add(panelCardsHandAndRoad);
        panelCardsHandAndRoad.setLayout(new GridLayout(1, 2, 1, 20));

        JPanel panelCardHand = new JPanel();
        panelCardHand.setBackground(ColorUtils.PERU);
        panelCardsHandAndRoad.add(panelCardHand);
        panelCardHand.setLayout(new GridLayout(1, 6, 2, 0));

        Dimension dimCard = new Dimension(10, 150);

        JButton btnNewButton = new JButton();
        btnNewButton.setPreferredSize(dimCard);
        btnNewButton.setBackground(ColorUtils.PERU);
        btnNewButton.setForeground(new Color(255, 215, 0));
        panelCardHand.add(btnNewButton);

        JButton btnNewButton_1 = new JButton();
        btnNewButton_1.setBackground(ColorUtils.PERU);
        btnNewButton_1.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton();
        btnNewButton_2.setBackground(ColorUtils.PERU);
        btnNewButton_2.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton();
        btnNewButton_3.setBackground(ColorUtils.PERU);
        btnNewButton_3.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton();
        btnNewButton_4.setBackground(ColorUtils.PERU);
        btnNewButton_4.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton();
        btnNewButton_5.setBackground(ColorUtils.PERU);
        btnNewButton_5.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_5);

        JPanel panelCardRoad = new JPanel();
        panelCardRoad.setBackground(ColorUtils.PERU);
        panelCardsHandAndRoad.add(panelCardRoad);
        panelCardRoad.setLayout(new GridLayout(1, 6, 2, 0));

        JButton btnRoad = new JButton();
        btnRoad.setBackground(ColorUtils.PERU);
        btnRoad.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad);

        JButton btnRoad_1 = new JButton();
        btnRoad_1.setBackground(ColorUtils.PERU);
        btnRoad_1.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_1);

        JButton btnRoad_2 = new JButton();
        btnRoad_2.setBackground(ColorUtils.PERU);
        btnRoad_2.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_2);

        JButton btnRoad_3 = new JButton();
        btnRoad_3.setBackground(ColorUtils.PERU);
        btnRoad_3.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_3);

        JButton btnRoad_4 = new JButton();
        btnRoad_4.setBackground(ColorUtils.PERU);
        btnRoad_4.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_4);

        JButton btnRoad_5 = new JButton();
        btnRoad_5.setBackground(ColorUtils.PERU);
        btnRoad_5.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_5);
        
        JPanel panelLabelPlayer1 = this.createPanelItemsCardsForPlayer();
        panelLabelPlayer1.setBounds(1024, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer1);

        JLabel lblPlayer1 = this.createLabelForPlayerName(listPlayer.get(0));
        panelLabelPlayer1.add(lblPlayer1);
        layeredThurnplan.setLayer(lblPlayer1, 0);
        lblPlayer1.setBackground(ColorUtils.SANDY_BROWN);
        
        JPanel panelLabelPlayer2 = this.createPanelItemsCardsForPlayer();
        panelLabelPlayer2.setBounds(1310, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer2);
        
        JLabel lblPlayer2 = new JLabel("Player 2");
        lblPlayer2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer2.add(lblPlayer2);
        lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer2.setBackground(ColorUtils.SANDY_BROWN);
        
        JPanel panelLabelPlayer3 = this.createPanelItemsCardsForPlayer();
        panelLabelPlayer3.setBounds(1024, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer3);
        
        JLabel lblPlayer3 = new JLabel("Player 3");
        lblPlayer3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer3.add(lblPlayer3);
        lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer3.setBackground(ColorUtils.SANDY_BROWN);
        
        JPanel panelLabelPlayer4 = this.createPanelItemsCardsForPlayer();
        panelLabelPlayer4.setBounds(1310, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer4);
        
        JLabel lblPlayer4 = new JLabel("Player 4");
        lblPlayer4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer4.add(lblPlayer4);
        lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer4.setBackground(ColorUtils.SANDY_BROWN);
        
        JPanel panelItemPlayer1 = this.createPanelItemsCardsForPlayer();
        panelItemPlayer1.setBounds(1024, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer1);
        panelItemPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel lblNewLabel_2 = this.createJLabelForPlayer();
        panelItemPlayer1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = this.createJLabelForPlayer();
        panelItemPlayer1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = this.createJLabelForPlayer();
        panelItemPlayer1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = this.createJLabelForPlayer();
        panelItemPlayer1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = this.createJLabelForPlayer();
        panelItemPlayer1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = this.createJLabelForPlayer();
        panelItemPlayer1.add(lblNewLabel_7);
        
        JPanel panelCardsPlayer1 = this.createPanelItemsCardsForPlayer();
        panelCardsPlayer1.setBounds(1167, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer1);
        panelCardsPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_36 = this.createJLabelForPlayer();
        panelCardsPlayer1.add(label_36);
        
        JLabel label_37 = this.createJLabelForPlayer();
        panelCardsPlayer1.add(label_37);
        
        JLabel label_38 = this.createJLabelForPlayer();
        panelCardsPlayer1.add(label_38);
        
        JLabel label_39 = this.createJLabelForPlayer();
        panelCardsPlayer1.add(label_39);
        
        JLabel label_40 = this.createJLabelForPlayer();
        panelCardsPlayer1.add(label_40);
        
        JLabel label_41 = this.createJLabelForPlayer();
        panelCardsPlayer1.add(label_41);
        
        JPanel panelItemPlayer2 = this.createPanelItemsCardsForPlayer();
        panelItemPlayer2.setBounds(1310, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer2);
        panelItemPlayer2.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_42 = this.createJLabelForPlayer();
        panelItemPlayer2.add(label_42);
        
        JLabel label_43 = this.createJLabelForPlayer();
        panelItemPlayer2.add(label_43);
        
        JLabel label_44 = this.createJLabelForPlayer();
        panelItemPlayer2.add(label_44);
        
        JLabel label_45 = this.createJLabelForPlayer();
        panelItemPlayer2.add(label_45);
        
        JLabel label_46 = this.createJLabelForPlayer();
        panelItemPlayer2.add(label_46);
        
        JLabel label_47 = this.createJLabelForPlayer();
        panelItemPlayer2.add(label_47);
        
        JPanel panelCardsPlayer2 = this.createPanelItemsCardsForPlayer();
        panelCardsPlayer2.setBounds(1453, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer2);
        panelCardsPlayer2.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_48 = this.createJLabelForPlayer();
        panelCardsPlayer2.add(label_48);
        
        JLabel label_49 = this.createJLabelForPlayer();
        panelCardsPlayer2.add(label_49);
        
        JLabel label_50 = this.createJLabelForPlayer();
        panelCardsPlayer2.add(label_50);
        
        JLabel label_51 = this.createJLabelForPlayer();
        panelCardsPlayer2.add(label_51);
        
        JLabel label_52 = this.createJLabelForPlayer();
        panelCardsPlayer2.add(label_52);
        
        JLabel label_53 = this.createJLabelForPlayer();
        panelCardsPlayer2.add(label_53);
        
        JPanel panelItemPlayer3 = this.createPanelItemsCardsForPlayer();
        panelItemPlayer3.setBounds(1024, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer3);
        panelItemPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label = this.createJLabelForPlayer();
        panelItemPlayer3.add(label);
        
        JLabel label_1 = this.createJLabelForPlayer();
        panelItemPlayer3.add(label_1);
        
        JLabel label_2 = this.createJLabelForPlayer();
        panelItemPlayer3.add(label_2);
        
        JLabel label_3 = this.createJLabelForPlayer();
        panelItemPlayer3.add(label_3);
        
        JLabel label_4 = this.createJLabelForPlayer();
        panelItemPlayer3.add(label_4);
        
        JLabel label_5 = this.createJLabelForPlayer();
        panelItemPlayer3.add(label_5);
        
        JPanel panelCardsPlayer3 = this.createPanelItemsCardsForPlayer();
        panelCardsPlayer3.setBounds(1167, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer3);
        panelCardsPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_6 = this.createJLabelForPlayer();
        panelCardsPlayer3.add(label_6);
        
        JLabel label_7 = this.createJLabelForPlayer();
        panelCardsPlayer3.add(label_7);
        
        JLabel label_8 = this.createJLabelForPlayer();
        panelCardsPlayer3.add(label_8);
        
        JLabel label_9 = this.createJLabelForPlayer();
        panelCardsPlayer3.add(label_9);
        
        JLabel label_10 = this.createJLabelForPlayer();
        panelCardsPlayer3.add(label_10);
        
        JLabel label_11 = this.createJLabelForPlayer();
        panelCardsPlayer3.add(label_11);
        
        JPanel panelItemPlayer4 = this.createPanelItemsCardsForPlayer();
        panelItemPlayer4.setBounds(1310, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer4);
        panelItemPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_12 = this.createJLabelForPlayer();
        panelItemPlayer4.add(label_12);
        
        JLabel label_13 = this.createJLabelForPlayer();
        panelItemPlayer4.add(label_13);
        
        JLabel label_14 = this.createJLabelForPlayer();
        panelItemPlayer4.add(label_14);
        
        JLabel label_15 = this.createJLabelForPlayer();
        panelItemPlayer4.add(label_15);
        
        JLabel label_16 = this.createJLabelForPlayer();
        panelItemPlayer4.add(label_16);
        
        JLabel label_17 = this.createJLabelForPlayer();
        panelItemPlayer4.add(label_17);
        
        JPanel panelCardsPlayer4 = this.createPanelItemsCardsForPlayer();
        panelCardsPlayer4.setBounds(1453, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer4);
        panelCardsPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_18 = this.createJLabelForPlayer();
        panelCardsPlayer4.add(label_18);
        
        JLabel label_19 = this.createJLabelForPlayer();
        panelCardsPlayer4.add(label_19);
        
        JLabel label_20 = this.createJLabelForPlayer();
        panelCardsPlayer4.add(label_20);
        
        JLabel label_21 = this.createJLabelForPlayer();
        panelCardsPlayer4.add(label_21);
        
        JLabel label_22 = this.createJLabelForPlayer();
        panelCardsPlayer4.add(label_22);
        
        JLabel label_23 = this.createJLabelForPlayer();
        panelCardsPlayer4.add(label_23);

        JPanel panelOfficials = new JPanel();
        panelOfficials.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelOfficials.setBackground(ColorUtils.PERU);
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
        btnCancel.setBackground(ColorUtils.PERU);

        JButton btnAdministrator = new JButton("");
        btnAdministrator.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/administratorTile.png")));
        panelOfficials.add(btnAdministrator);
        btnAdministrator.setToolTipText("Administrator");
        btnAdministrator.setBackground(ColorUtils.PERU);

        JButton btnPostmaster = new JButton("");
        btnPostmaster.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/postmasterTile.png")));
        panelOfficials.add(btnPostmaster);
        btnPostmaster.setToolTipText("Postmaster");
        btnPostmaster.setBackground(ColorUtils.PERU);

        JButton btnValidate = new JButton("Validate");
        btnValidate.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelOfficials.add(btnValidate);
        btnValidate.setBackground(ColorUtils.PERU);

        JButton btnPostalCarrier = new JButton();
        btnPostalCarrier.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/postalCarrierTile.png")));
        panelOfficials.add(btnPostalCarrier);
        btnPostalCarrier.setToolTipText("Postal carrier");
        btnPostalCarrier.setBackground(ColorUtils.PERU);

        JButton btnCartwright = new JButton();
        btnCartwright.setIcon(new ImageIcon(InterfaceJeu.class
                        .getResource("/com/project/thurnandtaxis/statics/img/officials/cartwrightTile.png")));
        panelOfficials.add(btnCartwright);
        btnCartwright.setToolTipText("Cartwright");
        btnCartwright.setBackground(ColorUtils.PERU);

        this.btnDeckCard = new JButton();
        this.btnDeckCard.setIcon(game.getGameParams().getBackCardImage());
        layeredThurnplan.setLayer(this.btnDeckCard, 1);
        this.btnDeckCard.setBounds(1452, 712, 100, 150);
        layeredThurnplan.add(this.btnDeckCard);
        this.btnDeckCard.setToolTipText(game.getListeCityCards().size() + " cards remaining");

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(244, 164, 96), null));
        panel.setBackground(new Color(205, 133, 63));
        panel.setBounds(1552, 712, 80, 150);
        this.setSize(1600, 900);
        this.setVisible(true);
    }

    private JLabel createLabelForPlayerName(Player player) {
        JLabel lblPlayer1 = new JLabel(player.getName());
        lblPlayer1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        lblPlayer1.setVerticalAlignment(SwingConstants.BOTTOM);
        lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        return lblPlayer1;
    }
    
    private JPanel createPanelItemsCardsForPlayer() {
        JPanel panelCardsPlayer1 = new JPanel();
        panelCardsPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer1.setBackground(ColorUtils.PERU);
        return panelCardsPlayer1;
    }

    private JLabel createJLabelForPlayer() {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(ColorUtils.PERU);
        return label;
    }
    
    public JButton getBtnDeckCard() {
        return this.btnDeckCard;
    }
    
    public void setBtnDeckCard(JButton btnDeckCard) {
        this.btnDeckCard = btnDeckCard;
    }
}
