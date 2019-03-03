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

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Container;
import java.awt.BorderLayout;
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
    private JMenu menuFile, menuSearch, menuConverter;
    private JMenuItem menuItemExit, menuItemGeneral, menuItemAdvanced;
    private JPanelHistorical pnlHistorical;
    private JPanelSearchGral pnlSearchGral;
    private JPanelSearchAdvanced pnlSearchAdvanced;
    private String currentPanel;
    private Border border;

    /**
     * Constructor.
     */
    public MainView() {
        setTitle("View Main");
    }

    /**
     * Return the panel where is the Search General.
     * @return General Search Panel .
     */
    public JPanelSearchGral getpSearchGral() {
        return pnlSearchGral;
    }

    /**
     * Return the panel where is the Search Advanced.
     * @return Advanced Search Panel .
     */
    public JPanelSearchAdvanced getpSearchAdvanced() {
        return pnlSearchAdvanced;
    }
    /**
     * Gets the Converter Menu.
     * @return the Menu option Converter
     */
    public JMenu getMenuConverter() {
        return menuConverter;
    }

    /**
     * Gets the Exit Menu option.
     * @return menuItemExit, the Exit menu item.
     */
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
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
     * Initialize the main window.
     */
    public void init() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();

        setLocationRelativeTo(null);
    }

    /**
     * Initialize the components.
     */
    private void initComponent() {
        Container content = getContentPane();
        createMenu();

        //Create panels.
        pnlHistorical = new JPanelHistorical(new BorderLayout());
        content.add(pnlHistorical, BorderLayout.CENTER);
        currentPanel = "Historical";
    }

    /**
     * Create menu.
     */
    private void createMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuSearch = new JMenu("Search");
        menuFile.add(menuSearch);
        menuItemGeneral = new JMenuItem("General");
        menuSearch.add(menuItemGeneral);
        menuItemGeneral.addActionListener(this);

        menuItemAdvanced = new JMenuItem("Advanced");
        menuSearch.add(menuItemAdvanced);
        menuItemAdvanced.addActionListener(this);

        menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);

        menuConverter = new JMenu("Converter");
        menuBar.add(menuConverter);
    }

    /**
     * The method actionPerformed receives the event of MenuItem Search General.
     * @param e, evento del MenuItem.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Container content = getContentPane();
        if (e.getSource() == menuItemGeneral) {
            if (currentPanel != "SearchGral") {
                pnlSearchGral = new JPanelSearchGral(new BorderLayout());
                content.removeAll();
                content.add(pnlSearchGral, BorderLayout.CENTER);
                currentPanel = "SearchGral";
                this.validate();
                this.repaint();
            }
        }
        if (e.getSource() == menuItemAdvanced) {
            if (currentPanel != "SearchAdvanced") {
                pnlSearchAdvanced = new JPanelSearchAdvanced(new BorderLayout());
                content.removeAll();
                content.add(pnlSearchAdvanced, BorderLayout.CENTER);
                currentPanel = "SearchAdvanced";
                this.validate();
                this.repaint();
            }
        }
    }
}

