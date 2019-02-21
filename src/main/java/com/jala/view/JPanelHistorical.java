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
 * Module view, ui/JPanelHistorical
 *
 * @version 0.0.1
 * @autor Melvi Caballero M.
 */
public class JPanelHistorical extends JPanel {
    private JList lstHistorical;
    private Border border;

    /**
     * @param layout
     */
    public JPanelHistorical(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * @return lstHistorical
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
     *
     */

    public void init() {
        initComponent();
    }

    /**
     * iniciamoa los componentes de este panel pList
     */
    private void initComponent() {
//headers for the table
        String[] columns = new String[] {
                "Id", "Name", "Hourly Rate", "Part Time"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
        };
        //create table with data
        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        this.add(scroll, BorderLayout.CENTER);
       //JPanel pList = pList();
      // this.add(table, BorderLayout.CENTER);
    }

    /**
     * Devuelve la instancia del panel pList en el objeto p
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
