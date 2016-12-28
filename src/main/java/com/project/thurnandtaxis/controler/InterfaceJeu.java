package com.project.thurnandtaxis.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.City;
import com.project.thurnandtaxis.data.beans.Game;
import com.project.thurnandtaxis.data.beans.Province;
import com.project.thurnandtaxis.utils.ColorUtils;

public class InterfaceJeu extends JFrame {
    public InterfaceJeu() {

        JPanel panel = new JPanel();
        this.getContentPane().add(panel, BorderLayout.CENTER);
    }

    private static final long serialVersionUID = -5238383102407162217L;
    
    private JFrame frame;
    private List<City> listeCityCards;
    private List<JButton> listeButtonCityCardsHandPlayer;
    private List<JButton> listeButtonCityCardsRoadPlayer;

    public void createInterfaceToPlay(final Game game) {
        this.createGameElementsLifeCycle(game);
        this.createWindow();
        this.addGameElements(game);
    }
    
    private void createGameElementsLifeCycle(Game game) {
        // liste de city cards
        this.listeCityCards = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(game.getListeProvinces())) {
            for (Province p : game.getListeProvinces()) {
                if (CollectionUtils.isNotEmpty(p.getListeCity())) {
                    for (City city : p.getListeCity()) {
                        this.listeCityCards.add(city);
                    }
                }
            }
        }
    }
    
    private void addGameElements(final Game game) {
        
        // Panneau plateau
        final JPanel panelBoard = new JPanel();
        panelBoard.setBackground(Color.black);
        final JLabel plateau = new JLabel(game.getGameParams().getGameBoardImage());
        // ajout du plateau et de la zone des joueurs
        panelBoard.add(plateau);

        // ----------------------------------------------------------------------------
        
        // Panneau pour la zone des joueurs
        JPanel panelZonePlayers = new JPanel();
        panelZonePlayers.setLayout(new GridLayout(4, 2));
        panelZonePlayers.setBackground(ColorUtils.PERU);

        JPanel panP1 = new JPanel();
        GridLayout glP1Global = new GridLayout(5, 2);
        panP1.setLayout(glP1Global);
        JLabel labelJoueur1 = new JLabel("Joueur 1");
        JLabel infoP1_1 = new JLabel("info 1");
        JLabel infoP1_2 = new JLabel("info 2");
        JLabel infoP1_3 = new JLabel("info 3");
        JLabel infoP1_4 = new JLabel("info 4");
        JLabel infoP1_5 = new JLabel("info 5");

        JLabel cardP1_1 = new JLabel("card 1");
        JLabel cardP1_2 = new JLabel("card 2");
        JLabel cardP1_3 = new JLabel("card 3");
        JLabel cardP1_4 = new JLabel("card 4");
        JLabel cardP1_5 = new JLabel("card 5");

        panP1.add(infoP1_1);
        panP1.add(cardP1_1);
        panP1.add(infoP1_2);
        panP1.add(cardP1_2);
        panP1.add(infoP1_3);
        panP1.add(cardP1_3);
        panP1.add(infoP1_4);
        panP1.add(cardP1_4);
        panP1.add(infoP1_5);
        panP1.add(cardP1_5);

        JLabel labelJoueur2 = new JLabel("Joueur 2");
        JLabel labelJoueur3 = new JLabel("Joueur 3");
        JLabel labelJoueur4 = new JLabel("Joueur 4");

        panelZonePlayers.add(panP1);
        panelZonePlayers.add(labelJoueur2);
        panelZonePlayers.add(labelJoueur3);
        panelZonePlayers.add(labelJoueur4);
        
        // panelPrincipal.add(panelZonePlayers);
        
        // -----------------------------------------------------------------------------

        JPanel panelZoneCards = new JPanel();
        panelZoneCards.setLayout(new GridLayout(2, 2));
        panelZoneCards.setBackground(Color.DARK_GRAY);

        // ajout du paquet de city cards
        JPanel panelZoneOfficials = new JPanel();
        panelZoneOfficials.setLayout(new GridLayout(1, 2));
        panelZoneOfficials.setBackground(ColorUtils.PERU);
        
        JButton deckCardButton = new JButton(game.getGameParams().getBackCardImage());
        deckCardButton.setText(String.valueOf(this.listeCityCards.size()));
        deckCardButton.setSize(game.getGameParams().getDimensionBackCardImage());
        panelZoneOfficials.add(deckCardButton, BorderLayout.EAST);

        // creation de la zone des cartes dans la main du joueur et de la route construite
        JPanel panCityCardsHandAndRoad = new JPanel();
        panCityCardsHandAndRoad.setBackground(ColorUtils.PERU);
        panCityCardsHandAndRoad.setLayout(new GridLayout(1, 16));
        // creation des boutons des cartes dans la main du joueur
        this.listeButtonCityCardsHandPlayer = this.creationDesBoutonsDansPanCityCardsPlayer("player's card");
        // creation des boutons de la route construite par le joueur
        this.listeButtonCityCardsRoadPlayer = this.creationDesBoutonsDansPanCityCardsPlayer("road card");
        // ajouts des boutons dans la zone des cartes dans la main et pour la route du joueur
        this.ajoutsDesBoutonsDansPanCityCardsPlayer(panCityCardsHandAndRoad);

        // panelZoneCards.add(panCityCardsHandAndRoad);
        panelZoneCards.add(deckCardButton);

        // slit : zone joueurs - zone officials
        JSplitPane splitJoueursOfficials = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelZonePlayers, panelZoneOfficials);
        splitJoueursOfficials.setDividerLocation(712);
        splitJoueursOfficials.setDividerSize(2);
        
        JSplitPane splitPlateauZoneCards = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelBoard, panCityCardsHandAndRoad);
        splitPlateauZoneCards.setDividerLocation(712);
        splitPlateauZoneCards.setDividerSize(2);
        
        JSplitPane splitGlobal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPlateauZoneCards, splitJoueursOfficials);
        splitGlobal.setDividerLocation(1024);
        splitGlobal.setDividerSize(2);

        // this.frame.setLayout(new GridLayout(2, 1));
        this.frame.getContentPane().add(splitGlobal, BorderLayout.CENTER);
        // this.frame.add(panelZoneCards);
        // Et enfin, la rendre visible
        this.frame.setSize(1324 + 30, 900);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
    
    private List<JButton> creationDesBoutonsDansPanCityCardsPlayer(String textButton) {
        final List<JButton> listeButton = Lists.newArrayList();
        for (int i = 0; i < 8; i++) {
            JButton buttonCityCards = new JButton();
            buttonCityCards.setText(textButton + (i + 1));
            buttonCityCards.setSize(30, 10);
            buttonCityCards.setBackground(ColorUtils.PERU);
            buttonCityCards.setForeground(Color.YELLOW);
            listeButton.add(buttonCityCards);
        }
        return listeButton;
    }

    private void ajoutsDesBoutonsDansPanCityCardsPlayer(JPanel panCityCardsInHandPlayer) {
        for (int i = 0; i < 8; i++) {
            panCityCardsInHandPlayer.add(this.listeButtonCityCardsHandPlayer.get(i));
        }
        for (int i = 0; i < 8; i++) {
            panCityCardsInHandPlayer.add(this.listeButtonCityCardsRoadPlayer.get(i));
        }
    }

    private void createWindow() {
        this.frame = new JFrame("Thurn and Taxis");
        // Termine le processus lorsqu'on clique sur la croix rouge
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Nous demandons maintenant à notre objet de se positionner au centre
        this.frame.setLocationRelativeTo(null);
    }
}
