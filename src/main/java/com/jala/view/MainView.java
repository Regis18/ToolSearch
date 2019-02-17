package com.jala.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class MainView extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuFile, menuSearch, menuConverter;
    private JMenuItem menuItemExit, menuItemGeneral, menuItemAdvanced;

    public MainView() {
        setTitle("View Main");
    }

    public JMenu getMenuConverter() {
        return menuConverter;
    }

    public void setMenuConverter(JMenu menuConverter) {
        this.menuConverter = menuConverter;
    }

    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    public void setMenuItemExit(JMenuItem menuItemExit) {
        this.menuItemExit = menuItemExit;
    }

    public JMenuItem getMenuItemGeneral() {
        return menuItemGeneral;
    }

    public void setMenuItemGeneral(JMenuItem menuItemGeneral) {
        this.menuItemGeneral = menuItemGeneral;
    }

    public JMenuItem getMenuItemAdvanced() {
        return menuItemAdvanced;
    }

    public void setMenuItemAdvanced(JMenuItem menuItemAdvanced) {
        this.menuItemAdvanced = menuItemAdvanced;
    }

    public void init() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public void initComponent() {
        Container content = getContentPane();
        //create panels
        JPanel pNorth = _crearPNorth();
        content.add(pNorth, BorderLayout.NORTH);

        JPanel pCentral = _crearPCentral();
        content.add(pCentral, BorderLayout.CENTER);

        JPanel pSouth = _crearPSouth();
        content.add(pSouth, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel _crearPNorth() {
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

    private JPanel _crearPCentral() {
        JPanel p = new JPanel(new BorderLayout());
        return p;
    }

    private JPanel _crearPSouth() {
        JPanel p = new JPanel(new FlowLayout());
        return p;
    }

}
