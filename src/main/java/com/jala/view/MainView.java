/**
 * @(#)MainView.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 * Module view, ui/mainview.
 * MainView class.
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class MainView extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuExit, menuSearch, menuConverter, menuPlayerVideo, menuDB;
    private JMenuItem menuItemExit, menuItemGeneral, menuItemAdvanced, menuItemConverter, menuItemConverterVideo,
            menuItemSearchVideo, menuItemVideoPlayer, menuItemDB;
    private JPanelHistorical pnlHistorical;
    private JPanelSearchGral pnlSearchGral;
    private JPanelSearchAdvanced pnlSearchAdvanced;
    private JPanelSearchAdvancedVideo pnlSearchAdvancedVideo;
    private JPanelConverter panelConverterImage;
    private JPanelVideo panelConverterVideo;
    private JpanelShowDB panelShowDB;
    private JPanelHistoricalDB panelHistoricalDB;
    private String currentPanel;
    private Border border;

    //Creamos un menu y modificamos el icono
    ImageIcon imgSearh = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\search.png");
    ImageIcon imgGSearchGral = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\searchGral.png");
    ImageIcon imgGSearchAdvanced = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\searchAdv.png");
    ImageIcon imgGSearchAdvVideo = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\searchVideo.png");
    ImageIcon imgConverter = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\Convert.png");
    ImageIcon imgImageConverter = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\imageConverter.png");
    ImageIcon imgVideoConverter = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\videoConverter.png");
    ImageIcon imgVideoPlayer = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\videoPlayer2.png");
    ImageIcon imgDBHistorical = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\dbHistorical.png");
    ImageIcon imgDBH = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\dbHistorical48.png");
    ImageIcon imgExit = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\exitB.png");
    ImageIcon imgExitTemp = new ImageIcon("D:\\Fundacion-Jala\\IU\\ToolSearch\\src\\main\\resources\\Icons\\exit.png");

    /**
     * Constructor.
     */
    public MainView() {
        setTitle("SolidWater");
    }

    /**
     * Return the panel where is the Search General.
     * @return General Search Panel .
     */
    public JPanelSearchGral getpSearchGral() {
        return pnlSearchGral;
    }

    /**
     * Return the panel for convert Video and Audio.
     * @return panelConverterVideo panel for convert video and audio.
     */
    public JPanelVideo getPanelConverterVideo() {
        return panelConverterVideo;
    }

    /**
     * Return the panel where is the Search Advanced.
     * @return Advanced Search Panel .
     */
    public JPanelSearchAdvanced getpSearchAdvanced() {
        return pnlSearchAdvanced;
    }

    /**
     * Return the panel where is the Search Advanced.
     * @return Advanced Search Panel .
     */
    public JPanelConverter getpConverterImage() {
        return panelConverterImage;
    }

    /**
     * Gets the Exit Menu option.
     * @return menuItemExit, the Exit menu item.
     */
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    /**
     * Gets the Converter Menu.
     * @return the Menu option Converter
     */
    public JPanelHistoricalDB getHistoricalDB() {
        return panelHistoricalDB;
    }

    /**
     * Gets the Historical Panel.
     * @return pHistorical, the last searches history Panel.
     */
    public JPanelHistorical getpHistorical() {
        return pnlHistorical;
    }

    /**
     * Gets the General Search Menu option.
     * @return menuItemGeneral, the General Search menu item from the Search menu.
     */
    public JMenuItem getMenuItemGeneral() {
        return menuItemGeneral;
    }

    /**
     * Gets the advanced Search menu option.
     * @return menuItemAdvanced, the option Advanced menu item of the Search menu.
     */
    public JMenuItem getMenuItemAdvanced() {
        return menuItemAdvanced;
    }

    /**
     * Gets the Converter menu option.
     * @return menuItemConverter, the option Advanced menu item of the Converter menu.
     */
    public JMenuItem getMenuItemConverter() {
        return menuItemConverter;
    }

    /**
     * Gets the video player menu option.
     * @return menuItemVideoPlayer
     */
    public JMenuItem getMenuItemVideoPlayer() {return menuItemVideoPlayer; }

    /**
     * Gets the show data base menu option.
     * @return menuItemDB
     */
    public JMenuItem getMenuItemDB() {return menuItemDB; }

    /**
     * Initialize the main window.
     */
    public void init() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 400));
        initComponent();
        //setLocationRelativeTo(null);
    }

    /**
     * Initialize the components.
     */
    private void initComponent() {
        //Container content = getContentPane();
        createMenu();
        //content.removeAll();
        this.getContentPane().setBackground(new Color(166, 166, 166));
    }

    /**
     * Create menu.
     */
    private void createMenu() {

        menuSearch = new JMenu("Search");
        menuSearch.setIcon(imgSearh);
        menuConverter = new JMenu("Converter");
        menuConverter.setIcon(imgConverter);
        menuPlayerVideo = new JMenu("Video Player");
        menuPlayerVideo.setIcon(imgVideoPlayer);
        menuExit = new JMenu("Exit");
        menuExit.setIcon(imgExit);
        menuDB = new JMenu("Historical DB");
        menuDB.setIcon(imgDBHistorical);

        //Add a Submenu with an image in the builder
        menuItemGeneral = new JMenuItem("General", imgGSearchGral );
        menuSearch.add(menuItemGeneral);
        menuSearch.addSeparator();
        menuItemGeneral.addActionListener(this);

        menuItemAdvanced = new JMenuItem("Advanced", imgGSearchAdvanced);
        menuSearch.add(menuItemAdvanced);
        menuSearch.addSeparator();
        menuItemAdvanced.addActionListener(this);

        menuItemSearchVideo = new JMenuItem("Advanced Video", imgGSearchAdvVideo);
        menuSearch.add(menuItemSearchVideo);
        menuItemSearchVideo.addActionListener(this);

        menuItemConverter = new JMenuItem("Converter Image", imgImageConverter);
        menuConverter.add(menuItemConverter);
        menuConverter.addSeparator();
        menuItemConverter.addActionListener(this);

        menuItemConverterVideo = new JMenuItem("Converter Video", imgVideoConverter);
        menuConverter.add(menuItemConverterVideo);
        menuItemConverterVideo.addActionListener(this);

        menuItemDB = new JMenuItem("Table Data Base", imgDBH);
        menuDB.add(menuItemDB);
        menuItemDB.addActionListener(this);

        menuItemExit = new JMenuItem("Exit", imgExitTemp);
        menuSearch.add(menuItemExit);

        //Add a menu with an image in the builder
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menuSearch);
        menuBar.add(menuConverter);
        menuBar.add(menuPlayerVideo);
        menuBar.add(menuDB);
        menuBar.add(menuExit);
        menuBar.setBorderPainted(true);

        menuBar.setBackground(new Color(0, 119, 100));
        menuSearch.setCursor(new Cursor(HAND_CURSOR));
        menuConverter.setCursor(new Cursor(HAND_CURSOR));
        menuPlayerVideo.setCursor(new Cursor(HAND_CURSOR));
        menuDB.setCursor(new Cursor(HAND_CURSOR));
        menuExit.setCursor(new Cursor(HAND_CURSOR));
        menuItemGeneral.setCursor(new Cursor(HAND_CURSOR));
        menuItemAdvanced.setCursor(new Cursor(HAND_CURSOR));
        menuItemSearchVideo.setCursor(new Cursor(HAND_CURSOR));
        menuItemConverter.setCursor(new Cursor(HAND_CURSOR));
        menuItemConverterVideo.setCursor(new Cursor(HAND_CURSOR));

    }

    /**
     * The method actionPerformed receives the event of MenuItem Search General.
     * @param event, evento del MenuItem.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        Container content = getContentPane();
        if (event.getSource() == menuItemGeneral) {
            //if (currentPanel != "SearchGral") {
                pnlSearchGral = new JPanelSearchGral(new BorderLayout());
                content.removeAll();
                content.add(pnlSearchGral, BorderLayout.CENTER);
                currentPanel = "SearchGral";
            this.validate();
            this.repaint();
           // }
        }
        if (event.getSource() == menuItemAdvanced) {
            //if (currentPanel != "SearchAdvanced") {
                pnlSearchAdvanced = new JPanelSearchAdvanced(new BorderLayout());
                content.removeAll();
                content.add(pnlSearchAdvanced, BorderLayout.CENTER);
                currentPanel = "SearchAdvanced";
                this.validate();
                this.repaint();
           //}
        }
        if (event.getSource() == menuItemConverter) {
            panelConverterImage = new JPanelConverter(new BorderLayout());
            content.removeAll();
            content.add(panelConverterImage, BorderLayout.CENTER);
            currentPanel = "ConverterImage";
            this.validate();
            this.repaint();
        }
        if (event.getSource() == menuItemConverterVideo) {
            panelConverterVideo = new JPanelVideo(new BorderLayout());
            content.removeAll();
            content.add(panelConverterVideo, BorderLayout.CENTER);
            currentPanel = "ConverterVideo";
            this.validate();
            this.repaint();
        }
        if (event.getSource() == menuItemSearchVideo) {
           // if (currentPanel == "SearchAdvancedVideo") {
                pnlSearchAdvancedVideo = new JPanelSearchAdvancedVideo();
                content.removeAll();
                content.add(pnlSearchAdvancedVideo, BorderLayout.CENTER);
                currentPanel = "SearchAdvancedVideo";
                this.validate();
                this.repaint();
           // }
        }
        if (event.getSource() == menuItemVideoPlayer) {
            pnlSearchAdvancedVideo = new JPanelSearchAdvancedVideo();
            content.removeAll();
            content.add(pnlSearchAdvancedVideo, BorderLayout.CENTER);
            currentPanel = "VideoPlayer";
            this.validate();
            this.repaint();
        }

        if (event.getSource() == menuItemDB) {
           //if (currentPanel != "HistoricalDB") {
                panelShowDB = new JpanelShowDB(new BorderLayout());
                content.removeAll();
                content.add(panelShowDB, BorderLayout.CENTER);
                currentPanel = "HistoricalDB";
                this.validate();
                this.repaint();
           // }
        }
    }

}
