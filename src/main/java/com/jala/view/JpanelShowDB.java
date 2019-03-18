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


public class JpanelShowDB extends JPanel {
    private JLabel lblPath, lblFileName, lblExtension;
    private JTextField txtPath, txtFileName, txtExtension;
    private JButton btnSearch;
    private JTableDB tbDataBase;
    private JTableResult tblResult;
    private Border border;
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
        JPanel pnlNorth = pnlCriteria();
        this.add(pnlNorth, BorderLayout.EAST);

        JPanel pnlSouth = pnlTableDB();
        this.add(pnlSouth, BorderLayout.CENTER);

        JPanel jpForTable = pnlTableResult();
        this.add(jpForTable, BorderLayout.SOUTH);
    }

    /**
     * Return the instance of panel central with the path, file name, extension and Search button.
     * @return pnlCriteria  the panel with path, file name, extension.
     */
    private JPanel pnlCriteria() {
        JPanel pnlPath = new JPanel((new BorderLayout()));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Dates : ");
        pnlPath.setBorder(titleBorder);

        constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        lblPath = new JLabel("Path: ");
        addComponent(lblPath, 0, 0, 1, 1);
        txtPath = new JTextField("");
        addComponent(txtPath, 1, 0, 5, 1);

        lblFileName = new JLabel("File Name: ");
        addComponent(lblFileName, 0, 1, 1, 1);
        txtFileName = new JTextField("");
        txtFileName.setSize(200, 20);
        addComponent(txtFileName, 1, 1, 1, 1);

        lblExtension = new JLabel("Extension: ");
        addComponent(lblExtension, 0, 2, 1, 1);
        txtExtension = new JTextField("");
        addComponent(txtExtension, 1, 2, 1, 1);

        return pnlPath;
    }

    /**
     * The method pnlTableResult get a JPanel with the JTableResult.
     *
     * @return a JPanel class.
     */
    private JPanel pnlTableResult() {
        JPanel pnlSearchAdvanced = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search");
        pnlSearchAdvanced.setBorder(titleBorder);
        tblResult = new JTableResult();
        JScrollPane scroll = new JScrollPane(tblResult);
        pnlSearchAdvanced.add(scroll, BorderLayout.CENTER);
        return pnlSearchAdvanced;
    }

    /**
     * The method pnlTableDB get a JPanel with the JTableResult.
     *
     * @return a JPanel class.
     */
    private JPanel pnlTableDB() {
        JPanel pnlSearchGral = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search Data Base");
        pnlSearchGral.setBorder(titleBorder);

        tbDataBase = new JTableDB();
        JScrollPane scroll = new JScrollPane(tbDataBase);
        pnlSearchGral.add(scroll, BorderLayout.CENTER);
        return pnlSearchGral;
    }

    /**
     * Method that adds components to the GridBagConstraints.
     */
    public void addComponent(Component Component, int sizeX, int sizeY, int sizeFieldX,int sizeFieldY) {
        constraints.gridx = sizeX;
        constraints.gridy = sizeY;
        constraints.gridwidth = sizeFieldX;
        constraints.gridheight = sizeFieldY;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 1.0;
        this.add (Component , constraints);
    }
}
