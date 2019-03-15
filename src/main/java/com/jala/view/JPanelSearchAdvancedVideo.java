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
 * JPanelSearchAdvancedVideo class is the panel to do
 * the search advanced video.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchAdvancedVideo extends JPanel{

    private JPanelAdvanced panelAdvanceSearch;
    private JPanelSearchVideo panelSearchVideo;
    private JTableResult tblResult;
    private Border border;

    /**
     * The JPanelSearchAdvancedVideo method is the constructor for JPanelSearchAdvancedVideo class,
     * it is for build an instance of itself class.
     */
    public JPanelSearchAdvancedVideo() {

        initUI();
        initComponent();
    }

    /**
     * The initUI method personalise attribute of itself class.
     */
    private void initUI() { setLayout(new BorderLayout()); }

    /**
     * The initComponent method, is for add component itself class.
     */
    private void initComponent() {

        panelAdvanceSearch = new JPanelAdvanced(new BorderLayout());
        TitledBorder advancedBorder = BorderFactory.createTitledBorder(border, "List Search Advanced");
        panelAdvanceSearch.setBorder(advancedBorder);
        panelAdvanceSearch.getBtnSearch().setVisible(false);
        panelAdvanceSearch.getTxtFieldExtension().setVisible(false);
        panelAdvanceSearch.getLblExtension().setVisible(false);
        this.add(panelAdvanceSearch, BorderLayout.WEST);

        panelSearchVideo = new JPanelSearchVideo();
        TitledBorder attributeBorder = BorderFactory.createTitledBorder(border, "Attributes");
        panelSearchVideo.setBorder(attributeBorder);
        this.add(panelSearchVideo, BorderLayout.CENTER);

        JPanel jpForTable = pnlTableResult();
        this.add(jpForTable, BorderLayout.SOUTH);
    }

    /**
     * The method pnlTableResult get a JPanel with the JTableResult.
     *
     * @return a JPanel component.
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

    /**
     * The getPanelAdvanceSearch method get JPanelAdvanced attribute of itself class.
     *
     * @return a JPanelAdvanced class
     */
    public JPanelAdvanced getPanelAdvanceSearch() {
        return panelAdvanceSearch;
    }

    /**
     * The getPanelSearchVideo method get JPanelSearchVideo attribute of itself class.
     *
     * @return JPanelSearchVideo class
     */
    public JPanelSearchVideo getPanelSearchVideo() {
        return panelSearchVideo;
    }

    /**
     * The getTblResult method get JTableResult attribute of itself class.
     *
     * @return JTableResult class
     */
    public JTableResult getTblResult() {
        return tblResult;
    }
}
