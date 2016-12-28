package com.project.thurnandtaxis.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceTest extends JFrame {
    private final JPanel panel_1 = new JPanel();
    
    public InterfaceTest() {
        this.setTitle("Thurn and Taxis");
        this.setResizable(false);
        this.getContentPane().add(this.panel_1, BorderLayout.SOUTH);
        this.panel_1.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panel_4 = new JPanel();
        this.panel_1.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 6, 0, 0));

        JButton btnNewButton = new JButton("Card1");
        btnNewButton.setBackground(new Color(205, 133, 63));
        btnNewButton.setForeground(new Color(205, 133, 63));
        panel_4.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Card2");
        panel_4.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Card3");
        panel_4.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Card4");
        panel_4.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Card5");
        panel_4.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Card6");
        panel_4.add(btnNewButton_5);

        JPanel panel_5 = new JPanel();
        this.panel_1.add(panel_5);
        panel_5.setLayout(new GridLayout(1, 6, 0, 0));

        JButton btnRoad = new JButton("Road1");
        panel_5.add(btnRoad);

        JButton btnRoad_1 = new JButton("Road2");
        panel_5.add(btnRoad_1);

        JButton btnRoad_2 = new JButton("Road3");
        panel_5.add(btnRoad_2);

        JButton btnRoad_3 = new JButton("Road4");
        panel_5.add(btnRoad_3);

        JButton btnRoad_4 = new JButton("Road5");
        panel_5.add(btnRoad_4);

        JButton btnRoad_5 = new JButton("Road6");
        panel_5.add(btnRoad_5);

        JPanel panel = new JPanel();
        this.getContentPane().add(panel, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(InterfaceTest.class.getResource("/com/project/thurnandtaxis/statics/img/thurnplan.jpg")));
        panel.add(lblNewLabel);
        
        JPanel panel_2 = new JPanel();
        this.getContentPane().add(panel_2, BorderLayout.EAST);
        panel_2.setLayout(new GridLayout(4, 2, 2, 2));
        
        JLabel lblNewLabel_1 = new JLabel("Player 1");
        panel_2.add(lblNewLabel_1);
        
        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        panel_3.setLayout(new GridLayout(6, 2, 2, 2));
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        panel_3.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        panel_3.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        panel_3.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("New label");
        panel_3.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        panel_3.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        panel_3.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("New label");
        panel_3.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("New label");
        panel_3.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("New label");
        panel_3.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("New label");
        panel_3.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("New label");
        panel_3.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("New label");
        panel_3.add(lblNewLabel_13);
        
        this.setSize(1600, 900);
        this.setVisible(true);
    }
    
}
