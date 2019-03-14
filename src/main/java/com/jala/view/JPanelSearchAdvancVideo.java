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

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * JPanelSearchAdvancVideo class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchAdvancVideo extends JPanel{
    private JPanelAdvanced jpAdvancSearch;
    private JPanelSearchVideo jpSearchVideo;
    private JTableResult jtResult;

    Border border;

    public JPanelSearchAdvancVideo() {
        initComponent();
    }
    /**
     * The initComponent method will initialize the components.
     */
    private void initComponent() {
        setLayout(new BorderLayout());
        jpAdvancSearch = new JPanelAdvanced(new BorderLayout());
        TitledBorder advancedBorder = BorderFactory.createTitledBorder(border, "List Search Advanced");
        jpAdvancSearch.setBorder(advancedBorder);
        jpAdvancSearch.getBtnSearch().setVisible(false);
        jpAdvancSearch.getTxfExtension().setVisible(false);
        jpAdvancSearch.getLblExtension().setVisible(false);
        this.add(jpAdvancSearch, BorderLayout.WEST);
        jpSearchVideo = new JPanelSearchVideo();
        TitledBorder attributeBorder = BorderFactory.createTitledBorder(border, "Attributes");
        jpSearchVideo.setBorder(attributeBorder);
        this.add(jpSearchVideo, BorderLayout.EAST);
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

        jtResult = new JTableResult();
        JScrollPane scroll = new JScrollPane(jtResult);
        pnlSearchAdvanced.add(scroll, BorderLayout.CENTER);
        return pnlSearchAdvanced;
    }
}
