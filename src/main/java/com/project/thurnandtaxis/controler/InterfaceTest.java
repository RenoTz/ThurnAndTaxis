package com.project.thurnandtaxis.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class InterfaceTest extends JFrame {
    
    public InterfaceTest() {
        this.setTitle("Thurn and Taxis");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredThurnplan = new JLayeredPane();
        layeredThurnplan.setBackground(new Color(244, 164, 96));
        this.getContentPane().add(layeredThurnplan, BorderLayout.CENTER);

        JLabel lblThurnplan = new JLabel("");
        lblThurnplan.setBounds(0, 0, 1024, 712);
        layeredThurnplan.add(lblThurnplan, new Integer(0));
        lblThurnplan.setHorizontalAlignment(SwingConstants.CENTER);
        lblThurnplan.setIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/thurnplan.jpg")));

        JPanel panelCardVisible = new JPanel();
        panelCardVisible.setBackground(new Color(205, 133, 63));
        layeredThurnplan.setLayer(panelCardVisible, 1);
        panelCardVisible.setBounds(20, 225, 167, 375);
        panelCardVisible.setVisible(true);
        layeredThurnplan.add(panelCardVisible, new Integer(1));
        panelCardVisible.setLayout(new GridLayout(3, 2, 10, 10));

        JButton cardVisible1 = new JButton("");
        cardVisible1.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible1);
        layeredThurnplan.setLayer(cardVisible1, 1);

        JButton cardVisible2 = new JButton("");
        cardVisible2.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible2);
        layeredThurnplan.setLayer(cardVisible2, 1);

        JButton cardVisible3 = new JButton("");
        cardVisible3.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible3);

        JButton cardVisible4 = new JButton("");
        cardVisible4.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible4);

        JButton cardVisible5 = new JButton("");
        cardVisible5.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible5);

        JButton cardVisible6 = new JButton("");
        cardVisible6.setBackground(new Color(244, 164, 96));
        panelCardVisible.add(cardVisible6);

        JButton btnBonusBaden = new JButton("");
        btnBonusBaden.setBackground(new Color(244, 164, 96));
        btnBonusBaden.setToolTipText("Bonus Baden");
        btnBonusBaden.setBounds(429, 123, 35, 35);
        layeredThurnplan.add(btnBonusBaden, new Integer(1));
        
        JButton btnBonusBohmen = new JButton("");
        btnBonusBohmen.setToolTipText("Bonus Bohmen");
        btnBonusBohmen.setBackground(new Color(244, 164, 96));
        btnBonusBohmen.setBounds(906, 381, 35, 35);
        layeredThurnplan.add(btnBonusBohmen, new Integer(1));
        
        JButton btnBonusBaiern = new JButton("");
        btnBonusBaiern.setToolTipText("Bonus Baiern");
        btnBonusBaiern.setBackground(new Color(244, 164, 96));
        btnBonusBaiern.setBounds(737, 388, 35, 35);
        layeredThurnplan.add(btnBonusBaiern, new Integer(1));
        
        JButton btnBonusSchweiz = new JButton("");
        btnBonusSchweiz.setToolTipText("Bonus Schweiz");
        btnBonusSchweiz.setBackground(new Color(244, 164, 96));
        btnBonusSchweiz.setBounds(394, 659, 35, 35);
        layeredThurnplan.add(btnBonusSchweiz, new Integer(1));
        
        JButton btnBonusWruttemberg = new JButton("");
        btnBonusWruttemberg.setToolTipText("Bonus Wruttemberg");
        btnBonusWruttemberg.setBackground(new Color(244, 164, 96));
        btnBonusWruttemberg.setBounds(378, 366, 35, 35);
        layeredThurnplan.add(btnBonusWruttemberg, new Integer(1));
        
        JButton btnBonusLongRoad5 = new JButton("");
        btnBonusLongRoad5.setToolTipText("Bonus Long Road 5");
        btnBonusLongRoad5.setBackground(new Color(244, 164, 96));
        btnBonusLongRoad5.setBounds(32, 635, 35, 35);
        layeredThurnplan.add(btnBonusLongRoad5, new Integer(1));
        
        JButton btnBonusLongRoad6 = new JButton("");
        btnBonusLongRoad6.setToolTipText("Bonus Long Road 6");
        btnBonusLongRoad6.setBackground(new Color(244, 164, 96));
        btnBonusLongRoad6.setBounds(85, 635, 35, 35);
        layeredThurnplan.add(btnBonusLongRoad6, new Integer(1));
        
        JButton btnBonusLongRoad7 = new JButton("");
        btnBonusLongRoad7.setToolTipText("Bonus Long Road 7");
        btnBonusLongRoad7.setBackground(new Color(244, 164, 96));
        btnBonusLongRoad7.setBounds(140, 635, 35, 35);
        layeredThurnplan.add(btnBonusLongRoad7, new Integer(1));

        JButton btnBonusAll = new JButton("");
        btnBonusAll.setToolTipText("Bonus all");
        btnBonusAll.setBackground(new Color(244, 164, 96));
        btnBonusAll.setBounds(326, 65, 35, 35);
        layeredThurnplan.add(btnBonusAll, new Integer(1));

        JButton btnBonusEnd = new JButton("");
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
        
        // ------------------------------------------------------
        JPanel panelCardsHandAndRoad = new JPanel();
        panelCardsHandAndRoad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsHandAndRoad.setBackground(new Color(205, 133, 63));
        layeredThurnplan.setLayer(panelCardsHandAndRoad, 1);
        panelCardsHandAndRoad.setBounds(0, 705, 1024, 150);
        layeredThurnplan.add(panelCardsHandAndRoad);
        panelCardsHandAndRoad.setLayout(new GridLayout(1, 2, 1, 20));

        JPanel panelCardHand = new JPanel();
        panelCardHand.setBackground(new Color(205, 133, 63));
        panelCardsHandAndRoad.add(panelCardHand);
        panelCardHand.setLayout(new GridLayout(1, 6, 2, 0));

        Dimension dimCard = new Dimension(10, 150);

        JButton btnNewButton = new JButton("Card1");
        btnNewButton.setPreferredSize(dimCard);
        btnNewButton.setBackground(new Color(205, 133, 63));
        btnNewButton.setForeground(new Color(255, 215, 0));
        panelCardHand.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Card2");
        btnNewButton_1.setBackground(new Color(205, 133, 63));
        btnNewButton_1.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Card3");
        btnNewButton_2.setBackground(new Color(205, 133, 63));
        btnNewButton_2.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Card4");
        btnNewButton_3.setBackground(new Color(205, 133, 63));
        btnNewButton_3.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Card5");
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton_4.setBackground(new Color(205, 133, 63));
        btnNewButton_4.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Card6");
        btnNewButton_5.setBackground(new Color(205, 133, 63));
        btnNewButton_5.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_5);

        JPanel panelCardRoad = new JPanel();
        panelCardRoad.setBackground(new Color(205, 133, 63));
        panelCardsHandAndRoad.add(panelCardRoad);
        panelCardRoad.setLayout(new GridLayout(1, 6, 2, 0));

        JButton btnRoad = new JButton("Road1");
        btnRoad.setBackground(new Color(205, 133, 63));
        btnRoad.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad);

        JButton btnRoad_1 = new JButton("Road2");
        btnRoad_1.setBackground(new Color(205, 133, 63));
        btnRoad_1.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_1);

        JButton btnRoad_2 = new JButton("Road3");
        btnRoad_2.setBackground(new Color(205, 133, 63));
        btnRoad_2.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_2);

        JButton btnRoad_3 = new JButton("Road4");
        btnRoad_3.setBackground(new Color(205, 133, 63));
        btnRoad_3.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_3);

        JButton btnRoad_4 = new JButton("Road5");
        btnRoad_4.setBackground(new Color(205, 133, 63));
        btnRoad_4.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_4);

        JButton btnRoad_5 = new JButton("Road6");
        btnRoad_5.setBackground(new Color(205, 133, 63));
        btnRoad_5.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_5);
        
        JPanel panelLabelPlayer1 = new JPanel();
        panelLabelPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelLabelPlayer1.setBackground(new Color(205, 133, 63));
        panelLabelPlayer1.setBounds(1024, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer1);
        
        JLabel lblPlayer1 = new JLabel("Player 1");
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
        panelLabelPlayer3.setBounds(1024, 352, 286, 40);
        layeredThurnplan.add(panelLabelPlayer3);
        
        JLabel lblPlayer3 = new JLabel("Player 3");
        lblPlayer3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer3.add(lblPlayer3);
        lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer3.setBackground(new Color(244, 164, 96));
        
        JPanel panelLabelPlayer4 = new JPanel();
        panelLabelPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelLabelPlayer4.setBackground(new Color(205, 133, 63));
        panelLabelPlayer4.setBounds(1310, 352, 286, 40);
        layeredThurnplan.add(panelLabelPlayer4);
        
        JLabel lblPlayer4 = new JLabel("Player 4");
        lblPlayer4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer4.add(lblPlayer4);
        lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer4.setBackground(new Color(244, 164, 96));
        
        JPanel panelItemPlayer1 = new JPanel();
        panelItemPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer1.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.setBounds(1024, 40, 143, 312);
        layeredThurnplan.add(panelItemPlayer1);
        panelItemPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBackground(new Color(205, 133, 63));
        panelItemPlayer1.add(lblNewLabel_7);
        
        JPanel panelCardsPlayer1 = new JPanel();
        panelCardsPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer1.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.setBounds(1167, 40, 143, 312);
        layeredThurnplan.add(panelCardsPlayer1);
        panelCardsPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_36 = new JLabel("New label");
        label_36.setHorizontalAlignment(SwingConstants.CENTER);
        label_36.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_36);
        
        JLabel label_37 = new JLabel("New label");
        label_37.setHorizontalAlignment(SwingConstants.CENTER);
        label_37.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_37);
        
        JLabel label_38 = new JLabel("New label");
        label_38.setHorizontalAlignment(SwingConstants.CENTER);
        label_38.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_38);
        
        JLabel label_39 = new JLabel("New label");
        label_39.setHorizontalAlignment(SwingConstants.CENTER);
        label_39.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_39);
        
        JLabel label_40 = new JLabel("New label");
        label_40.setHorizontalAlignment(SwingConstants.CENTER);
        label_40.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_40);
        
        JLabel label_41 = new JLabel("New label");
        label_41.setHorizontalAlignment(SwingConstants.CENTER);
        label_41.setBackground(new Color(205, 133, 63));
        panelCardsPlayer1.add(label_41);
        
        JPanel panelItemPlayer2 = new JPanel();
        panelItemPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer2.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.setBounds(1310, 40, 143, 312);
        layeredThurnplan.add(panelItemPlayer2);
        panelItemPlayer2.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_42 = new JLabel("New label");
        label_42.setHorizontalAlignment(SwingConstants.CENTER);
        label_42.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_42);
        
        JLabel label_43 = new JLabel("New label");
        label_43.setHorizontalAlignment(SwingConstants.CENTER);
        label_43.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_43);
        
        JLabel label_44 = new JLabel("New label");
        label_44.setHorizontalAlignment(SwingConstants.CENTER);
        label_44.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_44);
        
        JLabel label_45 = new JLabel("New label");
        label_45.setHorizontalAlignment(SwingConstants.CENTER);
        label_45.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_45);
        
        JLabel label_46 = new JLabel("New label");
        label_46.setHorizontalAlignment(SwingConstants.CENTER);
        label_46.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_46);
        
        JLabel label_47 = new JLabel("New label");
        label_47.setHorizontalAlignment(SwingConstants.CENTER);
        label_47.setBackground(new Color(205, 133, 63));
        panelItemPlayer2.add(label_47);
        
        JPanel panelCardsPlayer2 = new JPanel();
        panelCardsPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer2.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.setBounds(1453, 40, 143, 312);
        layeredThurnplan.add(panelCardsPlayer2);
        panelCardsPlayer2.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_48 = new JLabel("New label");
        label_48.setHorizontalAlignment(SwingConstants.CENTER);
        label_48.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_48);
        
        JLabel label_49 = new JLabel("New label");
        label_49.setHorizontalAlignment(SwingConstants.CENTER);
        label_49.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_49);
        
        JLabel label_50 = new JLabel("New label");
        label_50.setHorizontalAlignment(SwingConstants.CENTER);
        label_50.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_50);
        
        JLabel label_51 = new JLabel("New label");
        label_51.setHorizontalAlignment(SwingConstants.CENTER);
        label_51.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_51);
        
        JLabel label_52 = new JLabel("New label");
        label_52.setHorizontalAlignment(SwingConstants.CENTER);
        label_52.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_52);
        
        JLabel label_53 = new JLabel("New label");
        label_53.setHorizontalAlignment(SwingConstants.CENTER);
        label_53.setBackground(new Color(205, 133, 63));
        panelCardsPlayer2.add(label_53);
        
        JPanel panelItemPlayer3 = new JPanel();
        panelItemPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer3.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.setBounds(1024, 392, 143, 312);
        layeredThurnplan.add(panelItemPlayer3);
        panelItemPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label = new JLabel("New label");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label);
        
        JLabel label_1 = new JLabel("New label");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_1);
        
        JLabel label_2 = new JLabel("New label");
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_2);
        
        JLabel label_3 = new JLabel("New label");
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        label_3.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_3);
        
        JLabel label_4 = new JLabel("New label");
        label_4.setHorizontalAlignment(SwingConstants.CENTER);
        label_4.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_4);
        
        JLabel label_5 = new JLabel("New label");
        label_5.setHorizontalAlignment(SwingConstants.CENTER);
        label_5.setBackground(new Color(205, 133, 63));
        panelItemPlayer3.add(label_5);
        
        JPanel panelCardsPlayer3 = new JPanel();
        panelCardsPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer3.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.setBounds(1167, 392, 143, 312);
        layeredThurnplan.add(panelCardsPlayer3);
        panelCardsPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_6 = new JLabel("New label");
        label_6.setHorizontalAlignment(SwingConstants.CENTER);
        label_6.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_6);
        
        JLabel label_7 = new JLabel("New label");
        label_7.setHorizontalAlignment(SwingConstants.CENTER);
        label_7.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_7);
        
        JLabel label_8 = new JLabel("New label");
        label_8.setHorizontalAlignment(SwingConstants.CENTER);
        label_8.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_8);
        
        JLabel label_9 = new JLabel("New label");
        label_9.setHorizontalAlignment(SwingConstants.CENTER);
        label_9.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_9);
        
        JLabel label_10 = new JLabel("New label");
        label_10.setHorizontalAlignment(SwingConstants.CENTER);
        label_10.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_10);
        
        JLabel label_11 = new JLabel("New label");
        label_11.setHorizontalAlignment(SwingConstants.CENTER);
        label_11.setBackground(new Color(205, 133, 63));
        panelCardsPlayer3.add(label_11);
        
        JPanel panelItemPlayer4 = new JPanel();
        panelItemPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelItemPlayer4.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.setBounds(1310, 392, 143, 312);
        layeredThurnplan.add(panelItemPlayer4);
        panelItemPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_12 = new JLabel("New label");
        label_12.setHorizontalAlignment(SwingConstants.CENTER);
        label_12.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_12);
        
        JLabel label_13 = new JLabel("New label");
        label_13.setHorizontalAlignment(SwingConstants.CENTER);
        label_13.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_13);
        
        JLabel label_14 = new JLabel("New label");
        label_14.setHorizontalAlignment(SwingConstants.CENTER);
        label_14.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_14);
        
        JLabel label_15 = new JLabel("New label");
        label_15.setHorizontalAlignment(SwingConstants.CENTER);
        label_15.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_15);
        
        JLabel label_16 = new JLabel("New label");
        label_16.setHorizontalAlignment(SwingConstants.CENTER);
        label_16.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_16);
        
        JLabel label_17 = new JLabel("New label");
        label_17.setHorizontalAlignment(SwingConstants.CENTER);
        label_17.setBackground(new Color(205, 133, 63));
        panelItemPlayer4.add(label_17);
        
        JPanel panelCardsPlayer4 = new JPanel();
        panelCardsPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelCardsPlayer4.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.setBounds(1453, 392, 143, 312);
        layeredThurnplan.add(panelCardsPlayer4);
        panelCardsPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        JLabel label_18 = new JLabel("New label");
        label_18.setHorizontalAlignment(SwingConstants.CENTER);
        label_18.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_18);
        
        JLabel label_19 = new JLabel("New label");
        label_19.setHorizontalAlignment(SwingConstants.CENTER);
        label_19.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_19);
        
        JLabel label_20 = new JLabel("New label");
        label_20.setHorizontalAlignment(SwingConstants.CENTER);
        label_20.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_20);
        
        JLabel label_21 = new JLabel("New label");
        label_21.setHorizontalAlignment(SwingConstants.CENTER);
        label_21.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_21);
        
        JLabel label_22 = new JLabel("New label");
        label_22.setHorizontalAlignment(SwingConstants.CENTER);
        label_22.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_22);
        
        JLabel label_23 = new JLabel("New label");
        label_23.setHorizontalAlignment(SwingConstants.CENTER);
        label_23.setBackground(new Color(205, 133, 63));
        panelCardsPlayer4.add(label_23);

        JPanel panelOfficials = new JPanel();
        panelOfficials.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(244, 164, 96), new Color(244, 164, 96), null, null));
        panelOfficials.setBackground(new Color(205, 133, 63));
        layeredThurnplan.setLayer(panelOfficials, 1);
        panelOfficials.setBounds(1024, 705, 470, 150);
        layeredThurnplan.add(panelOfficials);
        panelOfficials.setLayout(new GridLayout(2, 3, 0, 0));

        JButton btnValidate = new JButton("Validate");
        panelOfficials.add(btnValidate);
        btnValidate.setBackground(new Color(205, 133, 63));

        JButton btnAdministrator = new JButton("");
        panelOfficials.add(btnAdministrator);
        btnAdministrator.setToolTipText("Administrator");
        btnAdministrator.setBackground(new Color(205, 133, 63));
        btnAdministrator.setSelectedIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/bailiff.jpg")));

        JButton btnPostmaster = new JButton("");
        panelOfficials.add(btnPostmaster);
        btnPostmaster.setToolTipText("Postmaster");
        btnPostmaster.setBackground(new Color(205, 133, 63));
        btnPostmaster.setSelectedIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/postmaster.jpg")));

        JButton btnCancel = new JButton("Cancel");
        panelOfficials.add(btnCancel);
        btnCancel.setBackground(new Color(205, 133, 63));

        JButton btnPostalCarrier = new JButton("");
        panelOfficials.add(btnPostalCarrier);
        btnPostalCarrier.setToolTipText("Postal carrier");
        btnPostalCarrier.setBackground(new Color(205, 133, 63));
        btnPostalCarrier.setSelectedIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/coachman.jpg")));

        JButton btnCartwright = new JButton("");
        panelOfficials.add(btnCartwright);
        btnCartwright.setToolTipText("Cartwright");
        btnCartwright.setBackground(new Color(205, 133, 63));
        btnCartwright.setSelectedIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/wainwright.jpg")));

        JButton btnDeckCard = new JButton("");
        layeredThurnplan.setLayer(btnDeckCard, 1);
        btnDeckCard.setBounds(1494, 705, 100, 150);
        layeredThurnplan.add(btnDeckCard);
        btnDeckCard.setHorizontalAlignment(SwingConstants.LEADING);
        btnDeckCard.setSelectedIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/deck.jpg")));
        btnDeckCard.setToolTipText("Deck");

        this.setSize(1600, 900);
        this.setVisible(true);
    }
}
