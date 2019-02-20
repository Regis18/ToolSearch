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
        JPanel pList = pList();
        this.add(pList, BorderLayout.CENTER);
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
