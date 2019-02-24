/**
 * @(#)JPanelSearchAdvanced.java Copyright (c) 2019 Jala Foundation.
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
import java.awt.Dimension;

/**
 * Module view, ui/JPanelSearchAdvanced.
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JPanelSearchAdvanced extends JPanel {
    private JLabel lblSearch, lblPath, lblFileName, lblExt, lblList;
    private JTextField txtPath, txtFileName, txtExt;
    private JButton btnSearch, btnSearchAdvanced;
    private JTableResult tbSearchAdvanced;
    private Border border;

    /**
     * Class constructor.
     * @param layout define the main layout.
     */
    public JPanelSearchAdvanced(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * Returns the table with the Advanced Search information.
     * @return the result table.
     */
    public JTableResult getTbSearchAdvanced() {
        return tbSearchAdvanced;
    }

    /**
     * Tis method allow set the result table.
     * @param tbSearchAdvanced result table.
     */
    public void setTbSearchAdvanced(JTableResult tbSearchAdvanced) {
        this.tbSearchAdvanced = tbSearchAdvanced;
    }

    /**
     * Return the value of file name.
     * @return txtFileName the criteria File Name.
     */
    public JTextField getTxtFileName() {
        return txtFileName;
    }

    /**
     * @param txtFileName the criteria File name for the search.
     */
    public void setTxtFileName(JTextField txtFileName) {
        this.txtFileName = txtFileName;
    }

    /**
     * Return the value of extension.
     * @return txtExt the criteria Extension for tha search.
     */
    public JTextField getTxtExt() {
        return txtExt;
    }

    /**
     * @param txtExt the criteria Extension for the search.
     */
    public void setTxtExt(JTextField txtExt) {
        this.txtExt = txtExt;
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

        JPanel pnlCentral = pnlTableResult();
        this.add(pnlCentral, BorderLayout.CENTER);

        JPanel pnlSouth = pnlMessages();
        this.add(pnlSouth, BorderLayout.SOUTH);
    }

    /**
     * Return the instance of panel north with the path, file name, extension and the Search button.
     * @return pnlSearchAd the panel with the criteria of the advanced Search.
     */
    private JPanel pnlCriteria() {

        JPanel pnlSearchAd, pnlPath, pnlFileName, pnlExt;
        pnlSearchAd = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Search Advanced");
        pnlSearchAd.setBorder(titleBorder);

        pnlPath = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblPath = new JLabel("Path: ");
        pnlPath.add(lblPath);

        txtPath = new JTextField(50);
        pnlPath.add(txtPath);

        pnlFileName = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblFileName = new JLabel("File Name: ");
        pnlFileName.add(lblFileName);

        txtFileName = new JTextField(15);
        pnlFileName.add(txtFileName);

        pnlExt = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblExt = new JLabel("Extension: ");
        pnlExt.add(lblExt);

        txtExt = new JTextField(10);
        pnlExt.add(txtExt);

        btnSearch = new JButton("Search");
        pnlExt.add(btnSearch);

        pnlSearchAd.add(pnlPath, BorderLayout.NORTH);
        pnlSearchAd.add(pnlFileName, BorderLayout.WEST);
        pnlSearchAd.add(pnlExt, BorderLayout.SOUTH);

        return pnlSearchAd;

    }

    /**
     * Return the instance of center panel with the Table Result.
     * @return pnlTable the panel of the table.
     */
    private JPanel pnlTableResult() {
        JPanel pnlSearchAdvanced = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search Advanced");
        pnlSearchAdvanced.setBorder(titleBorder);

        tbSearchAdvanced = new JTableResult();
        JScrollPane scroll = new JScrollPane(tbSearchAdvanced);
        pnlSearchAdvanced.add(scroll, BorderLayout.CENTER);
        return pnlSearchAdvanced;
    }

    /**
     * Return the instance of south panel with the label messages.
     * @return pnlMessage the panel for messages.
     */
    private JPanel pnlMessages() {
        JPanel pnlMessage = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlMessage.setPreferredSize(new Dimension(200, 50));
        return pnlMessage;
    }
}
