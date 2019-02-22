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
     * @return General Search Panel .
     */
    public JPanelSearchGral getpSearchGral() {
        return pSearchGral;
    }

    /**
     * Sets the General Search Panel.
     * @param pSearchGral .
     */
    public void setpSearchGral(JPanelSearchGral pSearchGral) {
        this.pSearchGral = pSearchGral;
    }

    /**
     * Gets the Converter Menu.
     * @return the Menu option Converter
     */
    public JMenu getMenuConverter() {
        return menuConverter;
    }

    /**
     * Sets the Converte menu option.
     * @param menuConverter , The menu to set as Converter.
     */
    public void setMenuConverter(JMenu menuConverter) {
        this.menuConverter = menuConverter;
    }

    /**
     * Gets the Exit Menu option.
     * @return menuItemExit, the Exit menu item.
     */
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    /**
     * Set the menu for the Exit option.
     * @param menuItemExit, the Exit menu item to set.
     */
    public void setMenuItemExit(JMenuItem menuItemExit) {
        this.menuItemExit = menuItemExit;
    }

    /**
     * Gets the Historical Panel.
     * @return pHistorical, the last searches history Panel.
     */
    public JPanelHistorical getpHistorical() {
        return pHistorical;
    }

    /**
     * Set the Historical Panel.
     * @param pCentral, set the last searches history panel.
     */
    public void setpHistorical(JPanelHistorical pCentral) {
        this.pHistorical = pHistorical;
    }

    /**
     * Gets the General Search Menu option.
     * @return menuItemGeneral, the General Search menu item from the Search menu.
     */
    public JMenuItem getMenuItemGeneral() {
        return menuItemGeneral;
    }

    /**
     * Sets the General Search Menu option.
     * @param menuItemGeneral, the General menu item of the Search menu.
     */
    public void setMenuItemGeneral(JMenuItem menuItemGeneral) {
        this.menuItemGeneral = menuItemGeneral;
    }

    /**
     * Gets the advanced Search menu option.
     * @return menuItemAdvanced, the option Advanced menu item of the Search menu.
     */
    public JMenuItem getMenuItemAdvanced() {
        return menuItemAdvanced;
    }

    /**
     * Gets the Advanced Search menu option.
     * @param menuItemAdvanced, the Advanced menu item of the Search menu.
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
     * @param e, evento del MenuItem.
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
