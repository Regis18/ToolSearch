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

/**
 * Module view, ui/JPanelSearchGral
 *
 * @version 0.0.1
 * @autor Melvi Caballero M.
 */
public class JPanelSearchGral extends JPanel {
    private JLabel lblSearch, lblPath, lblList;
    private JTextField txtPath;
    private JButton btnSearch, btnSearchAdvanced;
    private JList lstSearched;
    private Border border;

    /**
     * @param layout
     */
    public JPanelSearchGral(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * @return txtPath
     */
    public JTextField getTxtPath() {
        return txtPath;
    }

    /**
     * @param txtPath
     */
    public void setTxtPath(JTextField txtPath) {
        this.txtPath = txtPath;
    }

    /**
     * @return btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @param btnSearch
     */
    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    /**
     * @return btnSearchAdvanced
     */
    public JButton getBtnSearchAdvanced() {
        return btnSearchAdvanced;
    }

    /**
     * @param btnSearchAdvanced
     */
    public void setBtnSearchAdvanced(JButton btnSearchAdvanced) {
        this.btnSearchAdvanced = btnSearchAdvanced;
    }

    /**
     * @return lstSearched
     */
    public JList getLstSearched() {
        return lstSearched;
    }

    /**
     * @param lstSearched
     */
    public void setLstSearched(JList lstSearched) {
        this.lstSearched = lstSearched;
    }

    /**
     * El metodo init va inicializar el panel
     */
    public void init() {
        initComponent();
    }

    /**
     * el metodo initComponent va a inicializar los componetes que creamos
     * que estan divididos en tres areas
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
     * devuelve la instancia del panel central en el objeto p
     *
     * @return p
     */
    private JPanel pNorth() {

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Search");
        p.setBorder(titleBorder);
        lblPath = new JLabel("Path: ");
        p.add(lblPath);

        txtPath = new JTextField(15);
        p.add(txtPath);

        btnSearch = new JButton("...");
        p.add(btnSearch);
        return p;
    }

    /**
     * devuelve la instancia del panel derecho en el objeto p
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
     * devuelve la instancia del panel norte en el objeto p
     *
     * @return P
     */
    private JPanel pSouth() {
        JPanel p = new JPanel(new FlowLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List");
        p.setBorder(titleBorder);
        lstSearched = new JList();
        JScrollPane scroll = new JScrollPane(lstSearched);
        p.add(scroll, BorderLayout.CENTER);
        return p;
    }
}









