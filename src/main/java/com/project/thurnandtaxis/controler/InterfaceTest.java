package com.project.thurnandtaxis.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceTest extends JFrame {
    private final JPanel panelCardsHandAndRoad = new JPanel();
    
    public InterfaceTest() {
        this.setTitle("Thurn and Taxis");
        this.setResizable(false);
        this.getContentPane().add(this.panelCardsHandAndRoad, BorderLayout.SOUTH);
        this.panelCardsHandAndRoad.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panelCardHand = new JPanel();
        this.panelCardsHandAndRoad.add(panelCardHand);
        panelCardHand.setLayout(new GridLayout(1, 6, 0, 0));

        Dimension dimCard = new Dimension(10, 150);

        JButton btnNewButton = new JButton("Card1");
        btnNewButton.setPreferredSize(dimCard);
        btnNewButton.setBackground(new Color(205, 133, 63));
        btnNewButton.setForeground(new Color(255, 215, 0));
        panelCardHand.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Card2");
        btnNewButton_1.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Card3");
        btnNewButton_2.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Card4");
        btnNewButton_3.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Card5");
        btnNewButton_4.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Card6");
        btnNewButton_5.setPreferredSize(dimCard);
        panelCardHand.add(btnNewButton_5);

        JPanel panelCardRoad = new JPanel();
        this.panelCardsHandAndRoad.add(panelCardRoad);
        panelCardRoad.setLayout(new GridLayout(1, 6, 0, 0));

        JButton btnRoad = new JButton("Road1");
        btnRoad.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad);

        JButton btnRoad_1 = new JButton("Road2");
        btnRoad_1.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_1);

        JButton btnRoad_2 = new JButton("Road3");
        btnRoad_2.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_2);

        JButton btnRoad_3 = new JButton("Road4");
        btnRoad_3.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_3);

        JButton btnRoad_4 = new JButton("Road5");
        btnRoad_4.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_4);

        JButton btnRoad_5 = new JButton("Road6");
        btnRoad_5.setPreferredSize(dimCard);
        panelCardRoad.add(btnRoad_5);

        JPanel panelThurnPlan = new JPanel();
        FlowLayout fl_panelThurnPlan = (FlowLayout) panelThurnPlan.getLayout();
        fl_panelThurnPlan.setAlignment(FlowLayout.LEADING);
        fl_panelThurnPlan.setVgap(0);
        fl_panelThurnPlan.setHgap(0);
        this.getContentPane().add(panelThurnPlan, BorderLayout.CENTER);
        
        JLabel lblThurnplan = new JLabel("");
        lblThurnplan.setHorizontalAlignment(SwingConstants.CENTER);
        lblThurnplan.setIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/thurnplan.jpg")));
        panelThurnPlan.add(lblThurnplan);
        
        JPanel panelPlayers = new JPanel();
        this.getContentPane().add(panelPlayers, BorderLayout.EAST);
        panelPlayers.setLayout(new GridLayout(4, 2, 2, 2));
        
        JLabel lblPlayer1 = new JLabel("Player 1");
        panelPlayers.add(lblPlayer1);
        
        JLabel lblPlayer2 = new JLabel("Player 2");
        panelPlayers.add(lblPlayer2);
        
        JPanel panelPlayer1 = new JPanel();
        panelPlayers.add(panelPlayer1);
        panelPlayer1.setLayout(new GridLayout(6, 2, 2, 2));
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("New label");
        panelPlayer1.add(lblNewLabel_13);
        
        JPanel panelPlayer2 = new JPanel();
        panelPlayers.add(panelPlayer2);
        panelPlayer2.setLayout(new GridLayout(6, 2, 2, 2));
        
        JLabel label = new JLabel("New label");
        panelPlayer2.add(label);
        
        JLabel label_1 = new JLabel("New label");
        panelPlayer2.add(label_1);
        
        JLabel label_2 = new JLabel("New label");
        panelPlayer2.add(label_2);
        
        JLabel label_3 = new JLabel("New label");
        panelPlayer2.add(label_3);
        
        JLabel label_4 = new JLabel("New label");
        panelPlayer2.add(label_4);
        
        JLabel label_5 = new JLabel("New label");
        panelPlayer2.add(label_5);
        
        JLabel label_6 = new JLabel("New label");
        panelPlayer2.add(label_6);
        
        JLabel label_7 = new JLabel("New label");
        panelPlayer2.add(label_7);
        
        JLabel label_8 = new JLabel("New label");
        panelPlayer2.add(label_8);
        
        JLabel label_9 = new JLabel("New label");
        panelPlayer2.add(label_9);
        
        JLabel label_10 = new JLabel("New label");
        panelPlayer2.add(label_10);
        
        JLabel label_11 = new JLabel("New label");
        panelPlayer2.add(label_11);
        
        JLabel lblPlayer3 = new JLabel("Player 3");
        panelPlayers.add(lblPlayer3);
        
        JLabel lblPlayer4 = new JLabel("Player 4");
        panelPlayers.add(lblPlayer4);
        
        JPanel panelPlayer3 = new JPanel();
        panelPlayers.add(panelPlayer3);
        panelPlayer3.setLayout(new GridLayout(6, 2, 2, 2));
        
        JLabel label_12 = new JLabel("New label");
        panelPlayer3.add(label_12);
        
        JLabel label_13 = new JLabel("New label");
        panelPlayer3.add(label_13);
        
        JLabel label_14 = new JLabel("New label");
        panelPlayer3.add(label_14);
        
        JLabel label_15 = new JLabel("New label");
        panelPlayer3.add(label_15);
        
        JLabel label_16 = new JLabel("New label");
        panelPlayer3.add(label_16);
        
        JLabel label_17 = new JLabel("New label");
        panelPlayer3.add(label_17);
        
        JLabel label_18 = new JLabel("New label");
        panelPlayer3.add(label_18);
        
        JLabel label_19 = new JLabel("New label");
        panelPlayer3.add(label_19);
        
        JLabel label_20 = new JLabel("New label");
        panelPlayer3.add(label_20);
        
        JLabel label_21 = new JLabel("New label");
        panelPlayer3.add(label_21);
        
        JLabel label_22 = new JLabel("New label");
        panelPlayer3.add(label_22);
        
        JLabel label_23 = new JLabel("New label");
        panelPlayer3.add(label_23);
        
        JPanel panelPlayer4 = new JPanel();
        panelPlayers.add(panelPlayer4);
        panelPlayer4.setLayout(new GridLayout(6, 2, 2, 2));
        
        JLabel label_24 = new JLabel("New label");
        panelPlayer4.add(label_24);
        
        JLabel label_25 = new JLabel("New label");
        panelPlayer4.add(label_25);
        
        JLabel label_26 = new JLabel("New label");
        panelPlayer4.add(label_26);
        
        JLabel label_27 = new JLabel("New label");
        panelPlayer4.add(label_27);
        
        JLabel label_28 = new JLabel("New label");
        panelPlayer4.add(label_28);
        
        JLabel label_29 = new JLabel("New label");
        panelPlayer4.add(label_29);
        
        JLabel label_30 = new JLabel("New label");
        panelPlayer4.add(label_30);
        
        JLabel label_31 = new JLabel("New label");
        panelPlayer4.add(label_31);
        
        JLabel label_32 = new JLabel("New label");
        panelPlayer4.add(label_32);
        
        JLabel label_33 = new JLabel("New label");
        panelPlayer4.add(label_33);
        
        JLabel label_34 = new JLabel("New label");
        panelPlayer4.add(label_34);
        
        JLabel label_35 = new JLabel("New label");
        panelPlayer4.add(label_35);
        
        this.setSize(1600, 900);
        this.setVisible(true);
    }
    
}
