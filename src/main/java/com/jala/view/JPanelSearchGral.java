/**
 * @(#)JPanelSearchGral.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
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
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * Module view, ui/JPanelSearchAdvanced.
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JPanelSearchGral extends JPanel {
    private JLabel lblSearch, lblPath, lblList;
    private JTextField txtPath;
    private JButton btnSearch, btnSearchAdvanced;
    private JTableResult tbSearchGral;
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
     *  Get the table with the general search.
     * @return tbSearchGral the table with the general search.
     */
    public JTableResult getTbSearchGral() {
        return tbSearchGral;
    }

    /**
     * Sets the Searched Results table.
     * @param tbSearchGral the searched table to set.
     */
    public void setTbSearchGral(JTableResult tbSearchGral) {
        this.tbSearchGral = tbSearchGral;
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
     * The init method will initialize this panel.
     */
    public void init() {
        initComponent();
    }

    /**
     * The initComponent method will initialize the components.
     */
    private void initComponent() {

        JPanel pnlNorth = pnlCriteria();
        this.add(pnlNorth, BorderLayout.NORTH);

        JPanel pnlCentral = pnlButtonAdvanced();
        this.add(pnlCentral, BorderLayout.CENTER);

        JPanel pnlSouth = pnlTableResult();
        this.add(pnlSouth, BorderLayout.SOUTH);
    }

    /**
     * Return the instance of panel central with the path, file name, extension and Search button.
     * @return pnlCriteria  the panel with path, file name, extension.
     */
    private JPanel pnlCriteria() {

        JPanel pnlPath = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Search");
        pnlPath.setBorder(titleBorder);
        lblPath = new JLabel("Path: ");
        pnlPath.add(lblPath);

        txtPath = new JTextField(50);
        pnlPath.add(txtPath);

        btnSearch = new JButton("Search");
        pnlPath.add(btnSearch);
        return pnlPath;
    }

    /**
     * Return the instance of center panel with the Advanced button.
     * @return pnlButtonAdvanced the Advanced button panel.
     */
    private JPanel pnlButtonAdvanced() {

        JPanel pnlSearchAdvanced = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSearchAdvanced = new JButton("Advanced");
        pnlSearchAdvanced.add(btnSearchAdvanced);
        return pnlSearchAdvanced;
    }

    /**
     * Return the instance of south panel with the table of file founds.
     * @return pnlTableResult the south panel with the table of file founds.
     */
    private JPanel pnlTableResult() {
        JPanel pnlSearchGral = new JPanel(new  BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search General");
        pnlSearchGral.setBorder(titleBorder);

        tbSearchGral = new JTableResult();
        JScrollPane scroll = new JScrollPane(tbSearchGral);
        pnlSearchGral.add(scroll, BorderLayout.CENTER);
        return pnlSearchGral;
    }
}









