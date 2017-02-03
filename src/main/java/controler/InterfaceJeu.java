package controler;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import org.apache.commons.lang3.StringUtils;

import utils.ColorUtils;

import com.google.common.collect.Iterables;

import data.beans.principal.AllItems;
import data.beans.principal.Game;
import data.beans.secondaire.CityCard;
import data.beans.secondaire.LongRoadBonus;
import data.beans.secondaire.Official;
import data.beans.secondaire.Player;
import data.beans.secondaire.ProvinceBonus;
import data.beans.secondaire.Tile;
import data.constantes.ConstantesStatics;
import data.enumerations.EnumOfficials;
import data.enumerations.EnumResolution;

public class InterfaceJeu extends JFrame {
    
    private static final long serialVersionUID = 3006307486047180080L;
    
    private Player p1;
    
	public AllItems createInterface(final Game game) {
        this.setTitle("Thurn and Taxis");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLayeredPane layeredThurnplan = new JLayeredPane();
        layeredThurnplan.setBackground(ColorUtils.SANDY_BROWN);
        this.getContentPane().add(layeredThurnplan, BorderLayout.CENTER);

        final JLabel lblThurnplan = new JLabel("");
        lblThurnplan.setBounds(0, 0, 1024, 712);
        layeredThurnplan.add(lblThurnplan, 0);
        lblThurnplan.setHorizontalAlignment(SwingConstants.CENTER);
        lblThurnplan.setIcon(game.getGameParams().getGameBoardImage());

        // creation du bean qui contiendra tous les items (JButton, JLabel, ...)
        final AllItems allItems = new AllItems();
        
        // TODO Chargemement du joueur - A VIRER
        this.p1 = game.getAllPlayers().getPlayer1();

        // --------------------------------
        // PANEL / BUTTONS - CARDS VISIBLES
        // --------------------------------
        final JPanel panelCardVisible = new JPanel();
        panelCardVisible.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardVisible, 1);
        panelCardVisible.setBounds(20, 225, 167, 375);
        panelCardVisible.setVisible(true);
        layeredThurnplan.add(panelCardVisible, 1);
        panelCardVisible.setLayout(new GridLayout(3, 2, 3, 3));

        for (int i = 0; i < 6; i++) {
            final JButton cardVisible = new JButton("");
            cardVisible.setBackground(ColorUtils.SANDY_BROWN);
            panelCardVisible.add(cardVisible);
            allItems.getAllListsCards().getListCardsVisibles().add(new CityCard(cardVisible));
        }

        // ------------------------
        // BUTTONS - PROVINCE BONUS
        // ------------------------
        for (ProvinceBonus provinceBonus : game.getBonus().getListProvincesBonus()) {
            // BADEN BONUS
            if (StringUtils.equalsIgnoreCase(provinceBonus.getListNames().get(0), "Baden")) {
                final Tile tile = Iterables.getLast(provinceBonus.getTiles());
                final JButton btnBonusBaden = this.createBonusTileCity(429, 123, tile.getImage());
                btnBonusBaden.setToolTipText("Bonus Baden");
                layeredThurnplan.add(btnBonusBaden, new Integer(1));
            }
            // BOHMEN BONUS
            if (StringUtils.equalsIgnoreCase(provinceBonus.getListNames().get(0), "Bohmen")) {
                final Tile tile = Iterables.getLast(provinceBonus.getTiles());
                final JButton btnBonusBohmen = this.createBonusTileCity(906, 381, tile.getImage());
                btnBonusBohmen.setToolTipText("Bonus Bohmen");
                layeredThurnplan.add(btnBonusBohmen, new Integer(1));
            }
            // BOHMEN BONUS
            if (StringUtils.equalsIgnoreCase(provinceBonus.getListNames().get(0), "Baiern")) {
                final Tile tile = Iterables.getLast(provinceBonus.getTiles());
                final JButton btnBonusBaiern = this.createBonusTileCity(737, 388, tile.getImage());
                btnBonusBaiern.setToolTipText("Bonus Baiern");
                layeredThurnplan.add(btnBonusBaiern, new Integer(1));
            }
            // SCHWEIZ BONUS
            if (StringUtils.equalsIgnoreCase(provinceBonus.getListNames().get(0), "Schweiz")) {
                final Tile tile = Iterables.getLast(provinceBonus.getTiles());
                final JButton btnBonusSchweiz = this.createBonusTileCity(394, 659, tile.getImage());
                btnBonusSchweiz.setToolTipText("Bonus Schweiz");
                layeredThurnplan.add(btnBonusSchweiz, new Integer(1));
            }
            // WRUTTEMBERG BONUS
            if (StringUtils.equalsIgnoreCase(provinceBonus.getListNames().get(0), "Wurttemberg")) {
                final Tile tile = Iterables.getLast(provinceBonus.getTiles());
                final JButton btnBonusWruttemberg = this.createBonusTileCity(378, 366, tile.getImage());
                btnBonusWruttemberg.setToolTipText("Bonus Wurttemberg");
                layeredThurnplan.add(btnBonusWruttemberg, new Integer(1));
            }
        }

        // -------------------------
        // BUTTONS - LONG ROAD BONUS
        // -------------------------
        for (LongRoadBonus longRoadBonus : game.getBonus().getListLongRouteBonus()) {
            final Tile tile = Iterables.getLast(longRoadBonus.getListLongRoadTile());
            // ROAD LENGTH 5
            if (tile.getRouteLength() == 5) {
                final JButton btnBonusLongRoad5 = this.createLongRoadBonus(32, 635, tile.getImage());
                btnBonusLongRoad5.setToolTipText("Bonus Long Road 5");
                layeredThurnplan.add(btnBonusLongRoad5, new Integer(1));
            }
            // ROAD LENGTH 6
            if (tile.getRouteLength() == 6) {
                final JButton btnBonusLongRoad6 = this.createLongRoadBonus(85, 635, tile.getImage());
                btnBonusLongRoad6.setToolTipText("Bonus Long Road 6");
                layeredThurnplan.add(btnBonusLongRoad6, new Integer(1));
            }
            // ROAD LENGTH 7
            if (tile.getRouteLength() == 7) {
                final JButton btnBonusLongRoad7 = this.createLongRoadBonus(140, 635, tile.getImage());
                btnBonusLongRoad7.setToolTipText("Bonus Long Road 7");
                layeredThurnplan.add(btnBonusLongRoad7, new Integer(1));
            }
        }

        // -----------------------------
        // BUTTONS - ALL PROVINCES BONUS
        // -----------------------------
        JButton btnBonusAll = new JButton("");
        btnBonusAll.setIcon(Iterables.getLast(game.getBonus().getAllProvincesBonus().getTiles()).getImage());
        btnBonusAll.setToolTipText("Bonus all");
        btnBonusAll.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusAll.setBounds(326, 65, 35, 35);
        layeredThurnplan.add(btnBonusAll, new Integer(1));

        // ------------------------
        // BUTTONS - END GAME BONUS
        // ------------------------
        JButton btnBonusEnd = new JButton("");
        btnBonusEnd.setIcon(Iterables.getLast(game.getBonus().getListEndGameBonus()).getImage());
        btnBonusEnd.setToolTipText("Bonus end");
        btnBonusEnd.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusEnd.setBounds(326, 25, 35, 35);
        layeredThurnplan.add(btnBonusEnd, new Integer(1));
        
        // -------------------------------
        // PANEL / BUTTONS - CARD CARRIAGE
        // -------------------------------
        JPanel panelCardCaleche = new JPanel();
        panelCardCaleche.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardCaleche, 1);
        panelCardCaleche.setBounds(390, 24, 603, 75);
        layeredThurnplan.add(panelCardCaleche);
        panelCardCaleche.setLayout(new GridLayout(0, 5, 1, 0));

        for (int i = 0; i < 5; i++) {
            final JButton btnCaleche = new JButton("");
            btnCaleche.setBackground(ColorUtils.SANDY_BROWN);
            btnCaleche.setToolTipText("Carriage " + (i + 1));
            panelCardCaleche.add(btnCaleche);
        }
        
        // ----------------------------
        // PANEL / BUTTONS - CARDS ROAD
        // ----------------------------
        final JPanel panelCardRoad = new JPanel();
        panelCardRoad.setBorder(new BevelBorder(BevelBorder.RAISED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardRoad.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelCardRoad, 1);
        panelCardRoad.setBounds(1, 712, 1024, 150);
        layeredThurnplan.add(panelCardRoad);
        panelCardRoad.setLayout(new GridLayout(1, 10, 2, 0));
        
        final Dimension dimCard = new Dimension(10, 150);
        
        final JButton btnLeftRoad = new JButton(toVertical("LEFT"));
        btnLeftRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        btnLeftRoad.setPreferredSize(dimCard);
        btnLeftRoad.setBackground(ColorUtils.PERU);
        btnLeftRoad.setForeground(new Color(255, 215, 0));
        btnLeftRoad.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
        panelCardRoad.add(btnLeftRoad);
        
        for (int i = 0; i < 8; i++) {
            final JButton btnRoad = new JButton("");
            btnRoad.setBackground(ColorUtils.PERU);
            btnRoad.setPreferredSize(dimCard);
            btnRoad.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
            panelCardRoad.add(btnRoad);
            allItems.getAllListsCards().getListCardsRoad().add(new CityCard(btnRoad));
        }
        
        final JButton btnRightRoad = new JButton(toVertical("RIGHT"));
        btnRightRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        btnRightRoad.setBackground(ColorUtils.PERU);
        btnRightRoad.setForeground(new Color(255, 215, 0));
        btnRightRoad.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
        btnRightRoad.setPreferredSize(dimCard);
        panelCardRoad.add(btnRightRoad);
        
        // ----------------
        // LABELS - PLAYERS
        // ----------------
        // PLAYER 1
        final JPanel panelLabelPlayer1 = new JPanel();
        panelLabelPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer1.setBackground(ColorUtils.PERU);
        panelLabelPlayer1.setBounds(1024, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer1);
        final JLabel lblPlayer1 = new JLabel(this.p1.getName());
        lblPlayer1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer1.add(lblPlayer1);
        lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer1.setBackground(ColorUtils.SANDY_BROWN);

        // PLAYER 2
        final JPanel panelLabelPlayer2 = new JPanel();
        panelLabelPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer2.setBackground(ColorUtils.PERU);
        panelLabelPlayer2.setBounds(1310, 0, 286, 40);
        layeredThurnplan.add(panelLabelPlayer2);
        final JLabel lblPlayer2 = new JLabel("Player 2");
        lblPlayer2.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer2.add(lblPlayer2);
        lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer2.setBackground(ColorUtils.SANDY_BROWN);

        // PLAYER 3
        final JPanel panelLabelPlayer3 = new JPanel();
        panelLabelPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer3.setBackground(ColorUtils.PERU);
        panelLabelPlayer3.setBounds(1024, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer3);
        final JLabel lblPlayer3 = new JLabel("Player 3");
        lblPlayer3.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer3.add(lblPlayer3);
        lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer3.setBackground(ColorUtils.SANDY_BROWN);

        // PLAYER 4
        final JPanel panelLabelPlayer4 = new JPanel();
        panelLabelPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelLabelPlayer4.setBackground(ColorUtils.PERU);
        panelLabelPlayer4.setBounds(1310, 356, 286, 40);
        layeredThurnplan.add(panelLabelPlayer4);
        final JLabel lblPlayer4 = new JLabel("Player 4");
        lblPlayer4.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelLabelPlayer4.add(lblPlayer4);
        lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer4.setBackground(ColorUtils.SANDY_BROWN);
        
        // ----------------
        // PANEL - JOUEUR 1
        // ----------------
        
        final JPanel panelItemPlayer1 = new JPanel();
        panelItemPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        panelItemPlayer1.setBackground(ColorUtils.PERU);
        panelItemPlayer1.setBounds(1024, 40, 143, 316);
        layeredThurnplan.add(panelItemPlayer1);
        panelItemPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        for (int i = 0; i < 4; i++) {
            final JLabel lblNewLabel_2 = this.createLabelItemPlayer();
            panelItemPlayer1.add(lblNewLabel_2);
        }
        
        final JPanel panelCardsPlayer1 = new JPanel();
        panelCardsPlayer1.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer1.setBackground(ColorUtils.PERU);
        panelCardsPlayer1.setBounds(1167, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer1);
        panelCardsPlayer1.setLayout(new GridLayout(0, 1, 2, 2));
        
        for (int i = 0; i < 6; i++) {
            final JButton label_36 = this.createButtonCardPlayer();
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
            final JLabel label_42 = this.createLabelItemPlayer();
            panelItemPlayer2.add(label_42);
        }
        
        JPanel panelCardsPlayer2 = new JPanel();
        panelCardsPlayer2.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer2.setBackground(ColorUtils.PERU);
        panelCardsPlayer2.setBounds(1453, 40, 143, 316);
        layeredThurnplan.add(panelCardsPlayer2);
        panelCardsPlayer2.setLayout(new GridLayout(0, 1, 2, 2));
        
        for (int i = 0; i < 6; i++) {
            final JButton label_48 = this.createButtonCardPlayer();
            panelCardsPlayer2.add(label_48);
        }
        
        // ----------------
        // PANEL - JOUEUR 3
        // ----------------
        
        final JPanel panelItemPlayer3 = new JPanel();
        panelItemPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelItemPlayer3.setBackground(ColorUtils.PERU);
        panelItemPlayer3.setBounds(1024, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer3);
        panelItemPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        for (int i = 0; i < 4; i++) {
            final JLabel label = this.createLabelItemPlayer();
            panelItemPlayer3.add(label);
        }
        
        final JPanel panelCardsPlayer3 = new JPanel();
        panelCardsPlayer3.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer3.setBackground(ColorUtils.PERU);
        panelCardsPlayer3.setBounds(1167, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer3);
        panelCardsPlayer3.setLayout(new GridLayout(0, 1, 2, 2));
        
        for (int i = 0; i < 6; i++) {
            final JButton label_6 = this.createButtonCardPlayer();
            panelCardsPlayer3.add(label_6);
        }
        
        // ----------------
        // PANEL - JOUEUR 4
        // ----------------
        
        final JPanel panelItemPlayer4 = new JPanel();
        panelItemPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelItemPlayer4.setBackground(ColorUtils.PERU);
        panelItemPlayer4.setBounds(1310, 396, 143, 316);
        layeredThurnplan.add(panelItemPlayer4);
        panelItemPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        for (int i = 0; i < 4; i++) {
            final JLabel label_12 = this.createLabelItemPlayer();
            panelItemPlayer4.add(label_12);
        }
        
        final JPanel panelCardsPlayer4 = new JPanel();
        panelCardsPlayer4.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelCardsPlayer4.setBackground(ColorUtils.PERU);
        panelCardsPlayer4.setBounds(1453, 396, 143, 316);
        layeredThurnplan.add(panelCardsPlayer4);
        panelCardsPlayer4.setLayout(new GridLayout(0, 1, 2, 2));
        
        for (int i = 0; i < 6; i++) {
            final JButton label_18 = this.createButtonCardPlayer();
            panelCardsPlayer4.add(label_18);
        }
        
        // -----------------
        // PANEL - OFFICIALS
        // -----------------
        
        final JPanel panelOfficials = new JPanel();
        panelOfficials.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.SANDY_BROWN, null, null));
        panelOfficials.setBackground(ColorUtils.PERU);
        layeredThurnplan.setLayer(panelOfficials, 1);
        panelOfficials.setBounds(1025, 712, 427, 150);
        layeredThurnplan.add(panelOfficials);
        final GridLayout gl_panelOfficials = new GridLayout(2, 3);
        gl_panelOfficials.setVgap(1);
        gl_panelOfficials.setHgap(2);
        panelOfficials.setLayout(gl_panelOfficials);
        
        final JButton btnDiscardRoad = new JButton("DISCARD");
        btnDiscardRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
        panelOfficials.add(btnDiscardRoad);
        btnDiscardRoad.setBackground(ColorUtils.PERU);
        btnDiscardRoad.setForeground(new Color(255, 215, 0));
        btnDiscardRoad.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
        allItems.getAllButtons().setBtnDiscardRoad(btnDiscardRoad);
        
        for (Official official : game.getListOfficials()) {
            final JButton btnAdministrator = this.createButtonOfficial(official);
            panelOfficials.add(btnAdministrator);
            allItems.getAllButtons().getListOfficialsButtons().add(btnAdministrator);

            if (StringUtils.equals(official.getName(), EnumOfficials.POSTMASTER.getName())) {
                final JButton btnBuildRoad = new JButton("BUILD");
                btnBuildRoad.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
                panelOfficials.add(btnBuildRoad);
                btnBuildRoad.setBackground(ColorUtils.PERU);
                btnBuildRoad.setForeground(new Color(255, 215, 0));
                btnBuildRoad.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
                allItems.getAllButtons().setBtnBuildRoad(btnBuildRoad);
            }
        }

        final JButton btnDeckCard = new JButton("");
        btnDeckCard.setIcon(game.getGameParams().getBackCardImage());
        layeredThurnplan.setLayer(btnDeckCard, 1);
        btnDeckCard.setBounds(1452, 712, 100, 150);
        layeredThurnplan.add(btnDeckCard);
        btnDeckCard.setToolTipText("Take one");
        allItems.getAllButtons().setBtnDeckCard(btnDeckCard);
        
        // -----------------------
        // PANEL - CARDS REMAINING
        // -----------------------
        
        final JPanel panelNbCardRemaining = new JPanel();
        panelNbCardRemaining.setBorder(new BevelBorder(BevelBorder.LOWERED, ColorUtils.SANDY_BROWN, ColorUtils.PERU, null, null));
        panelNbCardRemaining.setBackground(ColorUtils.PERU);
        panelNbCardRemaining.setBounds(1552, 712, 42, 150);
        layeredThurnplan.add(panelNbCardRemaining, 1);
        GridLayout gl_panelCardRemaining = new GridLayout(3, 1);
        gl_panelCardRemaining.setVgap(1);
        panelNbCardRemaining.setLayout(gl_panelCardRemaining);
        
        panelNbCardRemaining.add(new JLabel());
        final JLabel lblNbCardRemaining = new JLabel(String.valueOf(game.getListCityCards().size()));
        panelNbCardRemaining.add(lblNbCardRemaining);
        lblNbCardRemaining.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
        lblNbCardRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        
        final JButton btnRules = new JButton();
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
    
    private JButton createButtonOfficial(Official official) {
        JButton btnAdministrator = new JButton("");
        btnAdministrator.setIcon(official.getImage());
        btnAdministrator.setBackground(ColorUtils.PERU);
        btnAdministrator.setToolTipText(official.getName());
        return btnAdministrator;
    }
    
    private JButton createLongRoadBonus(final int x, final int y, final ImageIcon image) {
        final JButton btnBonusLongRoad5 = new JButton("");
        btnBonusLongRoad5.setIcon(image);
        btnBonusLongRoad5.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusLongRoad5.setBounds(x, y, 40, 40);
        return btnBonusLongRoad5;
    }

    private JButton createBonusTileCity(final int posX, final int posY, final ImageIcon image) {
        final JButton btnBonusBaden = new JButton("");
        btnBonusBaden.setIcon(image);
        btnBonusBaden.setBackground(ColorUtils.SANDY_BROWN);
        btnBonusBaden.setBounds(posX, posY, 34, 34);
        return btnBonusBaden;
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
