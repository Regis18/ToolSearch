/**
 * @(#)File.java Copyright (c) 2019 Jala Foundation.
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
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
/*
class of the View main
 */

public class MainView extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuFile, menuSearch, menuConverter;
    private JMenuItem menuItemExit, menuItemGeneral, menuItemAdvanced;

    /*
    Constructor
     */
    public MainView() {
        setTitle("View Main");
    }
    /*
    get MenuConverter
     */

    public JMenu getMenuConverter() {
        return menuConverter;
    }
    /*
    set MenuConverter
     */

    public void setMenuConverter(JMenu menuConverter) {
        this.menuConverter = menuConverter;
    }

    /*
    get MenuItemExit
     */
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    /*
    setMenuItemExit
     */
    public void setMenuItemExit(JMenuItem menuItemExit) {
        this.menuItemExit = menuItemExit;
    }

    /*
    get MenuItemGeneral
     */
    public JMenuItem getMenuItemGeneral() {
        return menuItemGeneral;
    }

    /*
    set MenuItemGeneral
     */
    public void setMenuItemGeneral(JMenuItem menuItemGeneral) {
        this.menuItemGeneral = menuItemGeneral;
    }

    /*
    get MenuItemAdvanced
     */
    public JMenuItem getMenuItemAdvanced() {
        return menuItemAdvanced;
    }

    /*
    set MenuItemAdvanced
     */
    public void setMenuItemAdvanced(JMenuItem menuItemAdvanced) {
        this.menuItemAdvanced = menuItemAdvanced;
    }

    /*
    Initialize the main window
     */
    public void init() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    /*
    Initialize the public void initComponent() {

     */
    public void initComponent() {
        Container content = getContentPane();
        //create panels
        JPanel pNorth = _createPNorth();
        content.add(pNorth, BorderLayout.NORTH);

        JPanel pCentral = _createPCentral();
        content.add(pCentral, BorderLayout.CENTER);

        JPanel pSouth = _createPSouth();
        content.add(pSouth, BorderLayout.SOUTH);

        // setVisible(true);
    }

    /*
    Create Panel North
     */
    private JPanel _createPNorth() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        return p;

    }

    /*
    Create Panel Central
     */
    private JPanel _createPCentral() {
        JPanel p = new JPanel(new BorderLayout());
        return p;
    }

    /*
    Create Panel South
     */
    private JPanel _createPSouth() {
        JPanel p = new JPanel(new FlowLayout());
        return p;
    }

}
