/*
 * @(#) JPanelHistoricalDB.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * JPanelHistorical class.
 *
 * @version 0.0.1
 * @autor Cxristian Lujan
 */
public class JPanelHistoricalDB extends JPanel {
    private JTableDB tbHistoricalDB;

    /**
     * @param layout, add the layout in this panel.
     */
    public JPanelHistoricalDB(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * Gets the historical table.
     *
     * @return tbHistoricalDB, get Historical table of the last searches.
     */
    public JTableDB getTbHistoricalDB() {
        return tbHistoricalDB;
    }

    /**
     * Method init call to initComponent method.
     */
    public void init() {
        initComponent();
    }

    /**
     * Start the components of this panel List.
     */
    private void initComponent() {
        JPanel pnlHistorical = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(null, "Historical DataBase Table");
        pnlHistorical.setBorder(titleBorder);

        tbHistoricalDB = new JTableDB();
        JScrollPane scroll = new JScrollPane(tbHistoricalDB);
        pnlHistorical.add(scroll, BorderLayout.CENTER);
        this.add(pnlHistorical, BorderLayout.CENTER);
    }
}
