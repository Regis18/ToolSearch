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
 *
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
     * @param layout ,define the layout main.
     */
    public JPanelSearchGral(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * @return tbSearched, get searched table.
     */
    public JTable getTbSearched() {
        return tbSearched;
    }

    /**
     * @param tbSearched, set searched table.
     */
    public void setTbSearched(JTable tbSearched) {
        this.tbSearched = tbSearched;
    }

    /**
     * @return txtPath, get the location of file to search.
     */
    public JTextField getTxtPath() {
        return txtPath;
    }

    /**
     * @param txtPath, set the location of file to search.
     */
    public void setTxtPath(JTextField txtPath) {
        this.txtPath = txtPath;
    }

    /**
     * @return btnSearch, get the Search button.
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @param btnSearch, set the Search button.
     */
    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    /**
     * @return btnSearchAdvanced, get the Advanced Search button.
     */
    public JButton getBtnSearchAdvanced() {
        return btnSearchAdvanced;
    }

    /**
     * @param btnSearchAdvanced, set the Advanced Search button.
     */
    public void setBtnSearchAdvanced(JButton btnSearchAdvanced) {
        this.btnSearchAdvanced = btnSearchAdvanced;
    }

    /**
     * @return lstSearched, get the list searched.
     */
    public JList getLstSearched() {
        return lstSearched;
    }

    /**
     * @param lstSearched, set the list searched.
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

        JPanel pNorth = pNorth();
        this.add(pNorth(), BorderLayout.NORTH);

        JPanel pCentral = pCentral();
        this.add(pCentral, BorderLayout.CENTER);

        JPanel pSouth = pSouth();
        this.add(pSouth, BorderLayout.SOUTH);
    }

    /**
     * Return the instance of panel central with the path and the Search button.
     *
     * @return p
     */
    private JPanel pNorth() {

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Search");
        p.setBorder(titleBorder);
        lblPath = new JLabel("Path: ");
        p.add(lblPath);

        txtPath = new JTextField(100);
        p.add(txtPath);

        btnSearch = new JButton("Search");
        p.add(btnSearch);
        return p;
    }

    /**
     * Return the instance of center panel with the Advanced button.
     *
     * @return p
     */
    private JPanel pCentral() {

        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSearchAdvanced = new JButton("Advanced");
        p.add(btnSearchAdvanced);
        return p;
    }

    /**
     * Return the instance of south panel with the table of file founds .
     *
     * @return P
     */
    private JPanel pSouth() {
        JPanel p = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List");
        p.setBorder(titleBorder);

        // Headers for the table.
        String[] columns = new String[]{
                "Id", "Path", "File Name", "Ext.", "Size"
        };

        // Actual data for the table in a 2d array.
        Object[][] data = new Object[][]{
                {1, "c:github", "Test", "java", "98 bytes"},
        };

        // Create table with data.
        tbSearched = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(tbSearched);
        p.add(scroll, BorderLayout.CENTER);
        return p;
    }

}









