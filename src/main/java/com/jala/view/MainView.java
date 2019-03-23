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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

/**
 * Module view, ui/mainview.
 * MainView class.
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class MainView extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuSearch;
    private JMenu menuConverter;
    private JMenu menuPlayerVideo;
    private JMenuItem menuItemExit, menuItemGeneral, menuItemAdvanced, menuItemConverter, menuItemConverterVideo,
            menuItemSearchVideo, menuItemVideoPlayer;
    private JPanelSearchGral pnlSearchGral;
    private JPanelSearchAdvanced pnlSearchAdvanced;
    private JPanelSearchAdvancedVideo pnlSearchAdvancedVideo;
    private JPanelConverter panelConverterImage;
    private JPanelVideo panelConverterVideo;
    private JPanelHistoricalDB panelHistoricalDB;
    private String currentPanel;
    private Border border;

    ImageIcon imgSearch = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\search.png");
    ImageIcon imgGSearchGral = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\searchGral.png");
    ImageIcon imgGSearchAdvanced = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\searchAdv.png");
    ImageIcon imgGSearchAdvVideo = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\searchVideo.png");
    ImageIcon imgConverter = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\Convert.png");
    ImageIcon imgImageConverter = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\imageConverter.png");
    ImageIcon imgVideoConverter = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\videoConverter.png");
    ImageIcon imgVideoPlayer = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\videoPlayer1.png");
    ImageIcon imgExit = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\exit.png");
    ImageIcon imgExitTemp = new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\exit.png");

    /**
     * Constructor with title.
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
     * The getPnlSearchAdvancedVideo method get  a JPanelSearchAdvancedVideo
     * @return a pnlSearchAdvancedVideo attribute of this class.
     */
    public JPanelSearchAdvancedVideo getPnlSearchAdvancedVideo() {
        return pnlSearchAdvancedVideo;
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
     * Initialize the main window.
     */
    public void init() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 400));
        initComponent();

    }

    /**
     * Initialize the components.
     */
    private void initComponent() {
        createMenu();
        this.getContentPane().setBackground(new Color(71, 71, 71));
    }

    /**
     * Create menu.
     */
    private void createMenu() {
        menuSearch = new JMenu("Search");
        menuSearch.setIcon(imgSearch);
        menuSearch.setForeground(Color.WHITE);
        menuConverter = new JMenu("Converter");
        menuConverter.setIcon(imgConverter);
        menuConverter.setForeground(Color.WHITE);
        menuPlayerVideo = new JMenu("Video Player");
        menuPlayerVideo.setIcon(imgVideoPlayer);
        menuPlayerVideo.setForeground(Color.WHITE);

        //Add a Submenu with an image in the builder
        menuItemGeneral = new JMenuItem("General", imgGSearchGral );
        menuSearch.add(menuItemGeneral);
        menuSearch.addSeparator();
        menuItemGeneral.addActionListener(this);

        menuItemAdvanced = new JMenuItem("Advanced", imgGSearchAdvanced);
        menuSearch.add(menuItemAdvanced);
        menuSearch.addSeparator();
        menuItemAdvanced.addActionListener(this);

        menuItemSearchVideo = new JMenuItem("Multimedia", imgGSearchAdvVideo);
        menuSearch.add(menuItemSearchVideo);
        menuItemSearchVideo.addActionListener(this);

        menuItemConverter = new JMenuItem("Converter Image", imgImageConverter);
        menuConverter.add(menuItemConverter);
        menuConverter.addSeparator();
        menuItemConverter.addActionListener(this);

        menuItemConverterVideo = new JMenuItem("Converter Video", imgVideoConverter);
        menuConverter.add(menuItemConverterVideo);
        menuItemConverterVideo.addActionListener(this);

        menuItemExit = new JMenuItem("Exit", imgExitTemp);
        menuSearch.addSeparator();
        menuSearch.add(menuItemExit);
        //Add a menu with an image in the builder
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menuSearch);
        menuBar.add(menuConverter);
        menuBar.add(menuPlayerVideo);
        menuBar.setBorderPainted(true);

        menuBar.setBackground(new Color(21, 81, 154, 240));
        menuSearch.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuConverter.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuPlayerVideo.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuItemGeneral.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuItemAdvanced.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuItemSearchVideo.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuItemConverter.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuItemConverterVideo.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        menuItemExit.setCursor(Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
    }

    /**
     * The method actionPerformed receives the event of MenuItem Search General.
     * @param event, evento del MenuItem.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        Container content = getContentPane();
        if (event.getSource() == menuItemGeneral) {
            if (currentPanel != "SearchGral") {
                pnlSearchGral = new JPanelSearchGral(new BorderLayout());
                content.removeAll();
                content.add(pnlSearchGral, BorderLayout.CENTER);
                currentPanel = "SearchGral";
                this.validate();
                this.repaint();
            }
        }
        if (event.getSource() == menuItemAdvanced) {
            if (currentPanel != "SearchAdvanced") {
                pnlSearchAdvanced = new JPanelSearchAdvanced(new BorderLayout());
                content.removeAll();
                content.add(pnlSearchAdvanced, BorderLayout.CENTER);
                currentPanel = "SearchAdvanced";
                this.validate();
                this.repaint();
            }
        }
        if (event.getSource() == menuItemConverter) {
            if (currentPanel != "ConverterImage") {
                panelConverterImage = new JPanelConverter(new BorderLayout());
                content.removeAll();
                content.add(panelConverterImage, BorderLayout.CENTER);
                currentPanel = "ConverterImage";
                this.validate();
                this.repaint();
            }
        }
        if (event.getSource() == menuItemConverterVideo) {
            if (currentPanel != "ConverterVideo") {
                panelConverterVideo = new JPanelVideo(new BorderLayout());
                content.removeAll();
                content.add(panelConverterVideo, BorderLayout.CENTER);
                currentPanel = "ConverterVideo";
                this.validate();
                this.repaint();
            }
        }
        if (event.getSource() == menuItemSearchVideo) {
            if (currentPanel != "SearchAdvancedVideo") {
                pnlSearchAdvancedVideo = new JPanelSearchAdvancedVideo();
                content.removeAll();
                content.add(pnlSearchAdvancedVideo, BorderLayout.CENTER);
                currentPanel = "SearchAdvancedVideo";
                this.validate();
                this.repaint();
            }
        }
        if (event.getSource() == menuItemVideoPlayer) {
            if (currentPanel != "VideoPlayer") {
                pnlSearchAdvancedVideo = new JPanelSearchAdvancedVideo();
                content.removeAll();
                content.add(pnlSearchAdvancedVideo, BorderLayout.CENTER);
                currentPanel = "VideoPlayer";
                this.validate();
                this.repaint();
            }
        }
    }

}
