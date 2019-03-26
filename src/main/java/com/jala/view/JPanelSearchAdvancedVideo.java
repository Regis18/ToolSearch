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
import com.jala.view.player.VideoMusicPlayer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * JPanelSearchAdvancedVideo class is the panel to do
 * the search advanced video.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchAdvancedVideo extends JPanel {

    private JPanelAdvanced panelAdvanceSearch;
    private JPanelSearchVideo panelSearchVideo;
    private JTableResult tblResult;
    private Border border;
    private ArrayList myListPlayer = new ArrayList();
    private JButton btnPlay;
    private CustomErrorMessage msgError;

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
    private void initUI() {
        setLayout(new BorderLayout());
    }

    /**
     * The initComponent method, is for add component itself class.
     */
    private void initComponent() {

        panelAdvanceSearch = new JPanelAdvanced(new BorderLayout());
        TitledBorder advancedBorder = new CustomTitleBorder("List Search Advanced: ");
        panelAdvanceSearch.setBorder(advancedBorder);
        panelAdvanceSearch.setBackground(new Color(172, 175, 177));
        panelAdvanceSearch.setBorder(advancedBorder);
        panelAdvanceSearch.getBtnSearch().setVisible(false);
        panelAdvanceSearch.getBtnSave().setVisible(false);
        panelAdvanceSearch.getTxtFieldExtension().setVisible(false);
        panelAdvanceSearch.getLblExtension().setVisible(false);
        this.add(panelAdvanceSearch, BorderLayout.CENTER);

        panelSearchVideo = new JPanelSearchVideo();
        TitledBorder attributeBorder = new CustomTitleBorder("Attributes: ");
        panelSearchVideo.setBorder(attributeBorder);
        panelSearchVideo.setBackground(new Color(172, 175, 177));
        this.add(panelSearchVideo, BorderLayout.WEST);

        JPanel jpForTable = pnlTableResult();
        this.add(jpForTable, BorderLayout.SOUTH);
    }

    /**
     * The method pnlTableResult get a JPanel with the JTableResult.
     *
     * @return a JPanel class.
     */
    private JPanel pnlTableResult() {

        JPanel pnlSearchAdvanced = new JPanel(new BorderLayout());
        TitledBorder titleBorder = new CustomTitleBorder("List Search Video");
        pnlSearchAdvanced.setBorder(titleBorder);
        pnlSearchAdvanced.setBackground(new Color(172, 175, 177));
        tblResult = new JTableResult(400);
        JScrollPane scroll = new JScrollPane(tblResult, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnlSearchAdvanced.add(scroll, BorderLayout.CENTER);
        return pnlSearchAdvanced;
    }

    /**
     * Sets the Message Error for a pop-up
     * @param msgError define the message of error.
     */
    public void setMsgError(String msgError) {
        this.msgError = new CustomErrorMessage(msgError);
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

    /**
     * method that adds audio and video path to an ArrayList
     * @return ArrayList.
     */
    public ArrayList getMyListPlayer() {
        myListPlayer.clear();
        for (int i = 0; i < tblResult.getRowCount(); i++) {
            if (tblResult.getValueAt(i, 17).toString().equals("true")) {
                myListPlayer.add(tblResult.getValueAt(i, 1));
            }
        }
        return myListPlayer;
    }
}
