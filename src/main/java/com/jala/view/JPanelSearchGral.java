/**
 * @(#)JPanelSearchGral.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;

/**
 * Module view, ui/JPanelSearchGral.
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JPanelSearchGral extends JPanel {
    private JLabel lblSearch, lblPath, lblList;
    private JTextField txtPath;
    private JButton btnSearch, btnSearchAdvanced;
    private JList lstSearched;
    private JTable tbSearched;
    private Border border;

    /**
     * Class constructor.
     * @param layout define the main layout.
     */
    public JPanelSearchGral(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * Gets the Searched Results Table
     * @return tbSearched, the searched table.
     */
    public JTable getTbSearched() {
        return tbSearched;
    }

    /**
     //* Sets the Searched Results table
    // * @param tbSearched, the searched table to set.
     */
  /*  public void setTbSearched(JTable tbSearched) {
        this.tbSearched = tbSearched;
    }
*/
  public void setFiles(int x,int y, String value){

  }
    /**
     * Gets the Path of the location to search.
     * @return txtPath, the location of file to search.
     */
    public JTextField getTxtPath() {
        return txtPath;
    }

    /**
     * Sets the path field for the search location.
     * @param txtPath, the location where to search.
     */
    public void setTxtPath(JTextField txtPath) {
        this.txtPath = txtPath;
    }

    /**
     * Gets the search button.
     * @return btnSearch, the Search button.
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * Sets the Search Button.
     * @param btnSearch, the Search button.
     */
    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    /**
     * Gets the advanced search button.
     * @return btnSearchAdvanced, the Advanced Search button.
     */
    public JButton getBtnSearchAdvanced() {
        return btnSearchAdvanced;
    }

    /**
     * Sets the advanced search button.
     * @param btnSearchAdvanced, the Advanced Search button.
     */
    public void setBtnSearchAdvanced(JButton btnSearchAdvanced) {
        this.btnSearchAdvanced = btnSearchAdvanced;
    }

    /**
     * Gets the Search List.
     * @return lstSearched, the list of searches.
     */
    public JList getLstSearched() {
        return lstSearched;
    }

    /**
     * Sets the List for searches.
     * @param lstSearched, the list searched.
     */
    public void setLstSearched(JList lstSearched) {
        this.lstSearched = lstSearched;
    }

    /**
     * The init method will initialize this panel.
     */
    public void init() {
        initComponent();
    }

    /**
     * The initComponent method will initialize the components.
     */
    private void initComponent() {

        JPanel pnlNorth = pnlNorth();
        this.add(pnlNorth(), BorderLayout.NORTH);

        JPanel pnlCentral = pnlNorth();
        this.add(pnlCentral, BorderLayout.CENTER);

        JPanel pnlSouth = pnlSouth();
        this.add(pnlSouth, BorderLayout.SOUTH);
    }

    /**
     * Return the instance of panel central with the path and the Search button.
     * @return p
     */
    private JPanel pnlNorth() {

        JPanel pnlPath = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Search");
        pnlPath.setBorder(titleBorder);
        lblPath = new JLabel("Path: ");
        pnlPath.add(lblPath);

        txtPath = new JTextField(100);
        pnlPath.add(txtPath);

        btnSearch = new JButton("Search");
        pnlPath.add(btnSearch);
        return pnlPath;
    }

    /**
     * Return the instance of center panel with the Advanced button.
     * @return p the Central panel.
     */
    private JPanel pnlCentral() {

        JPanel pnlSearchAdvanced = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSearchAdvanced = new JButton("Advanced");
        pnlSearchAdvanced.add(btnSearchAdvanced);
        return pnlSearchAdvanced;
    }

    /**
     * Return the instance of south panel with the table of file founds .
     * @return the south panel of Pnl
     */
    private JPanel pnlSouth() {
        JPanel pnlTable = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List");
        pnlTable.setBorder(titleBorder);
/*
        // Headers for the table.
        String[] columns = new String[]{
                "Id", "Path", "File Name", "Ext.", "Size"
        };

        // Actual data for the table in a 2d array.
        Object[][] data = new Object[][]{
                {1, "c:github", "Test", "java", "98 bytes"},
        };
*/
        // Create table with data.
       // tbSearched = new JTable(data, columns);
        lstSearched = new JList();
        JScrollPane scroll = new JScrollPane(lstSearched);
        pnlTable.add(scroll, BorderLayout.CENTER);
        return pnlTable;
    }

}









