/**
 * @(#)JPanelHistorical.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view;

import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Module view, ui/JPanelHistorical.
 *
 * @version 0.0.1
 * @autor Melvi Caballero M.
 */
public class JPanelHistorical extends JPanel {
    private JList lstHistorical;
    private JTable tbHistorical;
    private Border border;

    /**
     * @param layout, add the layout in this panel.
     */
    public JPanelHistorical(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * @return tbHistorical, get Historical table.
     */
    public JTable getTbHistorical() {
        return tbHistorical;
    }

    /**
     * @param tbHistorical, set Historical table.
     */
    public void setTbHistorical(JTable tbHistorical) {
        this.tbHistorical = tbHistorical;
    }

    /**
     * @return lstHistorical, get
     */
    public JList getLstHistorical() {
        return lstHistorical;
    }

    /**
     * @param lstHistorical
     */
    public void setLstHistorical(JList lstHistorical) {
        this.lstHistorical = lstHistorical;
    }

    /**
     * Method init call to initComponent method.
     */
    public void init() {
        initComponent();
    }

    /**
     * Start the components of this panel pList.
     */
    private void initComponent() {

        // Headers for the table.
        String[] columns = new String[]{
                "Id", "Path", "File Name", "Ext.", "Size"
        };

        // Actual data for the table in a 2d array.
        Object[][] data = new Object[][]{
                {1, "c:github", "Test", "java", "98 bytes"},


        };

        // Create table with data.
        tbHistorical = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(tbHistorical);
        this.add(scroll, BorderLayout.CENTER);
    }

    /**
     * Return the instance of panel pList in the object p.
     *
     * @return p
     */
    private JPanel pList() {
        JPanel p = new JPanel(new FlowLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Historical");
        p.setBorder(titleBorder);
        lstHistorical = new JList();
        JScrollPane scroll = new JScrollPane(lstHistorical);
        p.add(scroll, BorderLayout.CENTER);
        return p;
    }
}
