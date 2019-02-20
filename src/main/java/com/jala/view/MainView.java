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

/*
class of the View main
 */
public class MainView extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuFile, menuSearch, menuConverter;
    private JMenuItem menuItemExit, menuItemGeneral, menuItemAdvanced;
    private JPanelHistorical pHistorical;

    /**
     * Constructor
     */
    public MainView() {
        setTitle("View Main");
    }

    /**
     * @return menuConverter
     */
    public JMenu getMenuConverter() {
        return menuConverter;
    }

    /**
     * @param menuConverter
     */
    public void setMenuConverter(JMenu menuConverter) {
        this.menuConverter = menuConverter;
    }

    /**
     * @return menuItemExit
     */
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    /**
     * @param menuItemExit
     */
    public void setMenuItemExit(JMenuItem menuItemExit) {
        this.menuItemExit = menuItemExit;
    }

    /**
     * @return pHistorical
     */
    public JPanelHistorical getpHistorical() {
        return pHistorical;
    }

    /**
     * @param pCentral
     */
    public void setpHistorical(JPanelHistorical pCentral) {
        this.pHistorical = pHistorical;
    }

    /**
     * @return menuItemGeneral
     */
    public JMenuItem getMenuItemGeneral() {
        return menuItemGeneral;
    }

    /**
     * @param menuItemGeneral
     */
    public void setMenuItemGeneral(JMenuItem menuItemGeneral) {
        this.menuItemGeneral = menuItemGeneral;
    }

    /**
     * @return menuItemAdvanced
     */
    public JMenuItem getMenuItemAdvanced() {
        return menuItemAdvanced;
    }

    /**
     * @param menuItemAdvanced
     */
    public void setMenuItemAdvanced(JMenuItem menuItemAdvanced) {
        this.menuItemAdvanced = menuItemAdvanced;
    }

    /**
     * Initialize the main window
     */
    public void init() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        initComponent();
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    /**
     * Initialize the components
     */
    private void initComponent() {
        Container content = getContentPane();
        createMenu();

        //create panels

        pHistorical = new JPanelHistorical(new BorderLayout());
        content.add(pHistorical, BorderLayout.CENTER);

    }

    /**
     * create menu
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
        menuItemAdvanced = new JMenuItem("Advanced");
        menuSearch.add(menuItemAdvanced);

        menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);

        menuConverter = new JMenu("Converter");
        menuBar.add(menuConverter);
    }

}
