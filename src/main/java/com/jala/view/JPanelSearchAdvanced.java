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
    private JTableResult tbSearchAdvanced;
    private Border border;
    private JPanelAdvanced panelSearchAdvanced;

    /**
     * Class constructor.
     * @param layout define the main layout.
     */
    public JPanelSearchAdvanced(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * Gets the panel getJPanelAdvanced.
     * @return panelSearchAdvanced.
     */
    public JPanelAdvanced getJPanelAdvanced() {
        return panelSearchAdvanced;
    }

    /**
     * Returns the table with the Advanced Search information.
     * @return the result table.
     */
    public JTableResult getTbSearchAdvanced() {
        return tbSearchAdvanced;
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
        panelSearchAdvanced = new JPanelAdvanced(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search Advanced");
        panelSearchAdvanced.setBorder(titleBorder);
        this.add(panelSearchAdvanced, BorderLayout.NORTH);

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

        JPanel pnlSearchAdvanced = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search Advanced");
        pnlSearchAdvanced.setBorder(titleBorder);

        tbSearchAdvanced = new JTableResult();
        JScrollPane scroll = new JScrollPane(tbSearchAdvanced);
        pnlSearchAdvanced.add(scroll, BorderLayout.CENTER);
        return pnlSearchAdvanced;
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
