package com.project.thurnandtaxis.controler;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.project.thurnandtaxis.data.beans.Game;

public class InterfaceJeu extends JFrame {

    private static final long serialVersionUID = -5238383102407162217L;
    
    private Game game;
    private JFrame fenetre;

    public InterfaceJeu(final Game game) {
        this.game = game;
        this.creerLaFenetre();
        this.ajouterLePlateau();
    }
    
    private void ajouterLePlateau() {
        JLabel plateau = new JLabel(this.game.getGameParams().getGameBoardImage());
        plateau.setSize(this.game.getGameParams().getDimensionGameBoardImage());

        JButton bonusLongRoad5 = new JButton(this.game.getBonus().getLongRouteBonus().get(0).getImage());
        // ajout du paquet de city cards
        JButton deckCardButton = new JButton(this.game.getGameParams().getBackCardImage());
        deckCardButton.setSize(this.game.getGameParams().getDimensionBackCardImage());

        // On définit le layout à utiliser sur le content pane
        // Trois lignes sur deux colonnes
        // GridLayout gridPrincipal = new GridLayout(2, 2);
        // GridLayout gridCards = new GridLayout(2, 2);
        // On ajoute le bouton au content pane de la JFrame
        // this.getContentPane().add(plateau);
        // this.getContentPane().add(new JButton("1"));
        // this.getContentPane().add(new JButton("2"));
        // this.getContentPane().add(deckCardButton);

        // this.setLayout(gridPrincipal);

        this.add(plateau);
        this.add(bonusLongRoad5);

        this.setVisible(true);
    }
    
    private void creerLaFenetre() {
        this.setTitle("Thurn and Taxis");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
