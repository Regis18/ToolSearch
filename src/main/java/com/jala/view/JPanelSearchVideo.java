/*
 * @(#) JPanelConverter.java Copyright (c) 2019 Jala Foundation.
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Insets;

/**
 * JPanelSearchVideo class is the panel with new attributes
 * for to do search advanced video.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchVideo extends JPanel {
    private JLabel lblFrameRate, lblVideoCodec, lblAudioCodec,
                    lblAspectRatio, lblDimension, lblExtension;
    private JButton btnSearch;
    private JComboBox cmbFrameRate, cmbVideoCodec, cmbAudioCodec,
                        cmbAspectRatio, cmbDimension, cmbExtension;

    /**
     * The JPanelSearchVideo method is the constructor of ViewConsole class,
     * it is for build an instance of itself class.
     */
    public JPanelSearchVideo() {

        initUI();
        initComponent();
    }

    /**
     * The initUI method personalise attribute of itself class.
     */
    private void initUI() {
        setLayout(new GridBagLayout());
    }

    /**
     * The initComponent method, is for add component itself class.
     */
    private void initComponent() {

        lblFrameRate = new JLabel("Frame Rate: ");
        constraintComponent(lblFrameRate, 0, 2, GridBagConstraints.EAST);

        lblVideoCodec = new JLabel("Video Codec: ");
        constraintComponent(lblVideoCodec, 0, 3, GridBagConstraints.EAST);

        lblAudioCodec = new JLabel("Audio Codec: ");
        constraintComponent(lblAudioCodec, 0, 4, GridBagConstraints.EAST);

        cmbFrameRate = new JComboBox();
        String[] myFrameRat = {" ", "24", "24.976", "25", "27", "29.7", "30", "60"};
        addItemsComboBox(myFrameRat, cmbFrameRate);
        constraintComponent(cmbFrameRate, 1, 2, GridBagConstraints.WEST);

        cmbVideoCodec = new JComboBox();
        String[] myVideoCod = {" ", "H.264/MPEG-4 AVC", "H.265/MPEG-H HEVC",
                                "H.263/MPEG-4 parte2 codecs", "H.262/MPEG-2 codecs", "MPEG-1",
                                "WMV", "MJPEG", "DV and HDV", "MPEG-2", "Microsoft VC-1"};
        addItemsComboBox(myVideoCod, cmbVideoCodec);
        constraintComponent(cmbVideoCodec, 1, 3, GridBagConstraints.WEST);

        cmbAudioCodec = new JComboBox();
        String[] myAudioCod = {" ", "WAV", "FLAC", "MP3", "WMA", "MPEG-1", "WMV", "ALAC",
                                "Ogg Vorbis", "AAC", "AIFF", "DSD"};
        addItemsComboBox(myAudioCod, cmbAudioCodec);
        constraintComponent(cmbAudioCodec, 1, 4, GridBagConstraints.WEST);

        lblAspectRatio = new JLabel("Aspect Ratio: ");
        constraintComponent(lblAspectRatio, 2, 2, GridBagConstraints.EAST);

        lblDimension = new JLabel("Dimension: ");
        constraintComponent(lblDimension, 2, 3, GridBagConstraints.EAST);

        lblExtension = new JLabel("Extension: ");
        constraintComponent(lblExtension, 2, 4, GridBagConstraints.EAST);

        cmbAspectRatio = new JComboBox();
        String[] myAspectRatio = {" ", "3:2", "4:3", "5:4", "16:9", "16:10", "1.35:1", "1.85:1"};
        addItemsComboBox(myAspectRatio, cmbAspectRatio);
        constraintComponent(cmbAspectRatio, 3, 2, GridBagConstraints.WEST);

        cmbDimension = new JComboBox();
        String[] myDimension = {" ", "400/300", "1280/750", "1000/780"};
        addItemsComboBox(myDimension, cmbDimension);
        constraintComponent(cmbDimension, 3, 3, GridBagConstraints.WEST);

        cmbExtension = new JComboBox();
        String[] myExtension = {" ", "FLV", "AVI", "MOV", "MP4", "MPG", "WMV"};
        addItemsComboBox(myExtension, cmbExtension);
        constraintComponent(cmbExtension, 3, 4, GridBagConstraints.WEST);

        btnSearch = new JButton("Search");
        constraintComponent(btnSearch, 3, 5, GridBagConstraints.EAST);
    }

    /**
     * This method addItemsComboBox add myItems into a cmb.
     * @param myItems is a string array
     * @param cmb is a JComboBox class component
     */
    private void addItemsComboBox(String[] myItems, JComboBox cmb) {

        for (String item : myItems) {
            cmb.addItem(item);
        }
    }

    /**
     * The constraintComponent method add constraint for a component.
     * @param component is data that receive a constraint
     * @param posX is data for position on row
     * @param posY is data for position on column
     * @param align is data for place the component.
     */
    private void constraintComponent(Component component, int posX, int posY, int align) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.insets = new Insets(1, 1, 1, 1);
        constraints.anchor = align;
        add(component, constraints);
    }

    /**
     * The getBtnSearch method get JButton attribute of itself class.
     * @return a JButton class
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * The getCmbFrameRate method get String of ComboBox selected.
     */
    public String getCmbFrameRate() {
        return cmbFrameRate.getSelectedItem().toString();
    }

    /**
     * The getCmbVideoCodec method get String of ComboBox selected.
     */
    public String getCmbVideoCodec() {
        return cmbVideoCodec.getSelectedItem().toString();
    }

    /**
     * The getCmbAudioCodec method get String of ComboBox selected.
     */
    public String getCmbAudioCodec() {
        return cmbAudioCodec.getSelectedItem().toString();
    }
    /**
     * The getCmbAspectRatio method get String of ComboBox selected.
     */
    public String getCmbAspectRatio() {
        return cmbAspectRatio.getSelectedItem().toString();
    }

    /**
     * The getCmbDimension method get String of ComboBox selected.
     */
    public String getCmbDimension() {
        return cmbDimension.getSelectedItem().toString();
    }

    /**
     * The getCmbExtension method get String of ComboBox selected.
     */
    public String getCmbExtension() {
        return cmbExtension.getSelectedItem().toString();
    }
}
