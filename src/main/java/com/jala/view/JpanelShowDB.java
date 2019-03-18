/*
 * @(#) JpanelShowDB.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

/**
 * JPanelSearchAdvanced class.
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JpanelShowDB extends JPanel {
    private JLabel lblPath, lblFileName, lblExtension;
    private JTextField txtPath, txtFileName, txtExtension;
    private JButton btnSearch, btnCharge, btnDelete;
    private JTableDB tbDataBase;
    private JTableResult tblResult;
    private Border border;
    private JPanel pnlPath;
    private GridBagConstraints constraints;

    public JpanelShowDB(LayoutManager layout) {
        super(layout);
        init();
    }

    public JTableDB getTbDataBase() {
        return tbDataBase;
    }

    /**
     * Gets the Path of the location to search.
     * @return txtPath, the location of file to search.
     */
    public JTextField txtPath() {
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
     * Gets the Path of the location to search.
     * @return txtFileName, the location of file to search.
     */
    public JTextField txtFileName() {
        return txtFileName;
    }

    /**
     * Sets the path field for the search location.
     * @param txtFileName, the location where to search.
     */
    public void setTxtFileName(JTextField txtFileName) {
        this.txtFileName = txtFileName;
    }

    /**
     * Gets the Path of the location to search.
     * @return txtFileName, the location of file to search.
     */
    public JTextField txtExtension() {
        return txtExtension;
    }

    /**
     * Sets the path field for the search location.
     * @param txtExtension, the location where to search.
     */
    public void setTxtExtension(JTextField txtExtension) {
        this.txtExtension = txtExtension;
    }

    /**
     * The init method will initialize this panel.
     */
    public void init() {
        initComponent();
    }

    /**
     * The initComponent method, is for add component itself class.
     */
    private void initComponent() {
        pnlPath = pnlCriteria();
        this.add(pnlPath, BorderLayout.CENTER);
    }

    /**
     * Return the instance of panel central with the path, file name, extension and Search button.
     * @return pnlCriteria  the panel with path, file name, extension.
     */
    private JPanel pnlCriteria() {
        pnlPath = new JPanel((new GridBagLayout()));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Dates : ");
        pnlPath.setBorder(titleBorder);

        constraints = new GridBagConstraints();

        lblPath = new JLabel("Path: ");
        addComponent(lblPath, 0, 0,GridBagConstraints.EAST , pnlPath);
        txtPath = new JTextField(10);
        addComponent(txtPath, 1, 0,GridBagConstraints.WEST , pnlPath);

        lblFileName = new JLabel("File Name: ");
        addComponent(lblFileName, 0, 1,GridBagConstraints.EAST , pnlPath);
        txtFileName = new JTextField(10);
        addComponent(txtFileName, 1, 1,GridBagConstraints.WEST, pnlPath);

        lblExtension = new JLabel("Extension: ");
        addComponent(lblExtension, 0, 2,GridBagConstraints.EAST, pnlPath);
        txtExtension = new JTextField(10);
        addComponent(txtExtension, 1, 2,GridBagConstraints.WEST, pnlPath);

        return pnlPath;
    }

    /**
     * The method pnlTableDB get a JPanel with the JTableResult.
     *
     * @return a JPanel class.
     */


    /**
     * Method that adds components to the GridBagConstraints.
     */
    public void addComponent(Component Component, int sizeX, int sizeY, int align, JPanel addPanel) {
        constraints.gridx = sizeX;
        constraints.gridy = sizeY;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.anchor = align;
        addPanel.add(Component , constraints);
    }
}
