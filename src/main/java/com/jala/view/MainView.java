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

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Module view, ui/mainview.
 *
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class MainView extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile, menuSearch, menuConverter;
    private JMenuItem menuItemExit, menuItemGeneral, menuItemAdvanced;
    private JPanelHistorical pHistorical;
    private JPanelSearchGral pSearchGral;
    private String currentPanel;

    /**
     * Constructor.
     */
    public MainView() {
        setTitle("View Main");

    }

    /**
     * Return the panel where is the Search General.
     *
     * @return pSearchGral .
     */
    public JPanelSearchGral getpSearchGral() {
        return pSearchGral;
    }

    /**
     * setter of the panel where is the Search General.
     *
     * @param pSearchGral .
     */
    public void setpSearchGral(JPanelSearchGral pSearchGral) {
        this.pSearchGral = pSearchGral;
    }

    /**
     * Return the Converter menu.
     *
     * @return menuConverter .
     */
    public JMenu getMenuConverter() {
        return menuConverter;
    }

    /**
     * @param menuConverter , set the Converter menu.
     */
    public void setMenuConverter(JMenu menuConverter) {
        this.menuConverter = menuConverter;
    }

    /**
     * @return menuItemExit, get the Exit menu item.
     */
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    /**
     * @param menuItemExit, set the Exit menu item.
     */
    public void setMenuItemExit(JMenuItem menuItemExit) {
        this.menuItemExit = menuItemExit;
    }

    /**
     * @return pHistorical, get the last searches.
     */
    public JPanelHistorical getpHistorical() {
        return pHistorical;
    }

    /**
     * @param pCentral, set the last searches.
     */
    public void setpHistorical(JPanelHistorical pCentral) {
        this.pHistorical = pHistorical;
    }

    /**
     * @return menuItemGeneral, get to General menu item for Search menu.
     */
    public JMenuItem getMenuItemGeneral() {
        return menuItemGeneral;
    }

    /**
     * @param menuItemGeneral, set to General menu item of the Search menu.
     */
    public void setMenuItemGeneral(JMenuItem menuItemGeneral) {
        this.menuItemGeneral = menuItemGeneral;
    }

    /**
     * @return menuItemAdvanced, get option Advanced menu item of the Search menu.
     */
    public JMenuItem getMenuItemAdvanced() {
        return menuItemAdvanced;
    }

    /**
     * @param menuItemAdvanced, set option Advanced menu item of the Search menu.
     */
    public void setMenuItemAdvanced(JMenuItem menuItemAdvanced) {
        this.menuItemAdvanced = menuItemAdvanced;
    }

    /**
     * Initialize the main window.
     */
    public void init() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        initComponent();
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    /**
     * Initialize the components.
     */
    private void initComponent() {
        Container content = getContentPane();
        createMenu();

        //Create panels.
        pHistorical = new JPanelHistorical(new BorderLayout());
        content.add(pHistorical, BorderLayout.CENTER);
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

        menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);

        menuConverter = new JMenu("Converter");
        menuBar.add(menuConverter);
    }

    /**
     * The method actionPerformed receives the event of MenuItem Search General.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Container content = getContentPane();
        if (e.getSource() == menuItemGeneral) {
            if (currentPanel != "SearchGral") {
                pSearchGral = new JPanelSearchGral(new BorderLayout());
                content.removeAll();

                content.add(pSearchGral, BorderLayout.CENTER);
                currentPanel = "SearchGral";
                this.validate();
                this.repaint();
            }
        }
    }
}
