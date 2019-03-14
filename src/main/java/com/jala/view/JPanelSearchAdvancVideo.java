/*
 * @(#) JPanelConverterImage.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;

/**
 * JPanelSearchAdvancVideo class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchAdvancVideo extends JPanel{
    private JPanelAdvanced panelAdvancSearch;
    private JPanelSearchVideo panelSearchVideo;
    private JTableResult tblResult;
    private Border border;

    /**
     * This is the constructor method for create an instance
     */
    public JPanelSearchAdvancVideo() {
        initComponent();
    }

    /**
     * The initComponent method will initialize the components.
     */
    private void initComponent() {
        setLayout(new BorderLayout());
        panelAdvancSearch = new JPanelAdvanced(new BorderLayout());
        TitledBorder advancedBorder = BorderFactory.createTitledBorder(border, "List Search Advanced");
        panelAdvancSearch.setBorder(advancedBorder);
        panelAdvancSearch.getBtnSearch().setVisible(false);
        panelAdvancSearch.getTxfExtension().setVisible(false);
        panelAdvancSearch.getLblExtension().setVisible(false);
        this.add(panelAdvancSearch, BorderLayout.WEST);
        panelSearchVideo = new JPanelSearchVideo();
        TitledBorder attributeBorder = BorderFactory.createTitledBorder(border, "Attributes");
        panelSearchVideo.setBorder(attributeBorder);
        this.add(panelSearchVideo, BorderLayout.EAST);
        JPanel jpForTable = pnlTableResult();
        this.add(jpForTable, BorderLayout.SOUTH);
    }

    /**
     * Return the instance of center panel with the Table Result.
     * @return pnlTable the panel of the table.
     */
    private JPanel pnlTableResult() {
        JPanel pnlSearchAdvanced = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search Video");
        pnlSearchAdvanced.setBorder(titleBorder);

        tblResult = new JTableResult();
        JScrollPane scroll = new JScrollPane(tblResult);
        pnlSearchAdvanced.add(scroll, BorderLayout.CENTER);
        return pnlSearchAdvanced;
    }
}
