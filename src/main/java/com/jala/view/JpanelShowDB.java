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
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;


public class JpanelShowDB extends JPanel {
    private JLabel lblCriteria;
    private JTextField txtCriteria;
    private JButton btnSearch;
    private JTableDB tbDataBase;
    private JTableResult tblResult;
    private Border border;

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
    public JTextField getTxtCriteria() {
        return txtCriteria;
    }

    /**
     * Sets the path field for the search location.
     * @param txtCriteria, the location where to search.
     */
    public void setTxtCriteria(JTextField txtCriteria) {
        this.txtCriteria = txtCriteria;
    }

    /**
     * Gets the search button.
     * @return btnSearch, the Search button.
     */
    public JButton getBtnSearch() {
        return btnSearch;
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
        JPanel pnlPath = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Search");
        pnlPath.setBorder(titleBorder);
        lblCriteria = new JLabel("Criteria: ");
        pnlPath.add(lblCriteria);

        txtCriteria = new JTextField(50);
        pnlPath.add(txtCriteria);

        btnSearch = new JButton("Search");
        pnlPath.add(btnSearch);
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
}
