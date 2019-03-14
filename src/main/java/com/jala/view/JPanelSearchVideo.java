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
 * JPanelSearchVideo class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchVideo extends JPanel {
    private JLabel lblFramRat, lblVideoCod,
            lblAudioCod, lblAspectRadio, lblDimension, lblExtension;
    private JButton btnSearch;
    private JComboBox cmbFrameRat, cmbVideoCod, cmbAudioCod, cmbAspectRadio,
            cmbDimension, cmbExtension;

    /**
     * The constructor method of the ViewConsole class to build an instance
     */
    public JPanelSearchVideo() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        lblFramRat = new JLabel("Frame Rate: ");
        constraintComponent(lblFramRat, 0, 2, GridBagConstraints.EAST);
        lblVideoCod = new JLabel("Video Codec: ");
        constraintComponent(lblVideoCod, 0, 3, GridBagConstraints.EAST);
        lblAudioCod = new JLabel("Audio Codec: ");
        constraintComponent(lblAudioCod, 0, 4, GridBagConstraints.EAST);
        cmbFrameRat = new JComboBox();
        String[] myFrameRat = {"SELECT", "24", "24.976", "25", "27", "29.7", "30", "60"};
        addItemsComboBox(myFrameRat, cmbFrameRat);
        constraintComponent(cmbFrameRat, 1, 2, GridBagConstraints.WEST);
        cmbVideoCod = new JComboBox();
        String[] myVideoCod = {"SELECT", "H.264/MPEG-4 AVC", "H.265/MPEG-H HEVC", "H.263/MPEG-4 parte2 codecs",
                    "H.262/MPEG-2 codecs", "MPEG-1", "WMV", "MJPEG", "DV and HDV", "MPEG-2", "Microsoft VC-1"};
        addItemsComboBox(myVideoCod, cmbVideoCod);
        constraintComponent(cmbVideoCod, 1, 3, GridBagConstraints.WEST);
        cmbAudioCod = new JComboBox();
        String[] myAudioCod = {"SELECT", "WAV", "FLAC", "MP3", "WMA", "MPEG-1", "WMV", "ALAC", "Ogg Vorbis",
                                "AAC", "AIFF", "DSD"};
        addItemsComboBox(myAudioCod, cmbAudioCod);
        constraintComponent(cmbAudioCod, 1, 4, GridBagConstraints.WEST);
        lblAspectRadio = new JLabel("Aspect Ratio: ");
        constraintComponent(lblAspectRadio, 2, 2, GridBagConstraints.EAST);
        lblDimension = new JLabel("Dimension: ");
        constraintComponent(lblDimension, 2, 3, GridBagConstraints.EAST);
        cmbAspectRadio = new JComboBox();
        lblExtension = new JLabel("Extension: ");
        constraintComponent(lblExtension, 2, 4, GridBagConstraints.EAST);
        cmbAspectRadio = new JComboBox();
        String[] myAspectRatio = {"SELECT", "3:2", "4:3", "5:4", "16:9", "16:10", "1.35:1", "1.85:1"};
        addItemsComboBox(myAspectRatio, cmbAspectRadio);
        constraintComponent(cmbAspectRadio, 3, 2, GridBagConstraints.WEST);
        cmbDimension = new JComboBox();
        String[] myDimention = {"SELECT", "400/300", "1280/750", "1000/780"};
        addItemsComboBox(myDimention, cmbDimension);
        constraintComponent(cmbDimension, 3, 3, GridBagConstraints.WEST);
        cmbExtension = new JComboBox();
        String[] myExtension = {"SELECT", "FLV", "AVI", "MOV", "MP4", "MPG", "WMV"};
        addItemsComboBox(myExtension, cmbExtension);
        constraintComponent(cmbExtension, 3, 4, GridBagConstraints.WEST);
        btnSearch = new JButton("Search");
        constraintComponent(btnSearch, 3, 5, GridBagConstraints.EAST);
    }

    /**
     * This method add items in combo box
     * @param myItems are data for add at cbFrameRat
     * @param cbFramRat is a data where add items
     */
    private void addItemsComboBox(String[] myItems, JComboBox cbFramRat) {
        for (String item : myItems) {
            cbFramRat.addItem(item);
        }
    }

    /**
     * Section of getter methods
     */
    public JComboBox getCmbFrameRat() {
        return cmbFrameRat;
    }

    public JComboBox getCmbVideoCod() {
        return cmbVideoCod;
    }

    public JComboBox getCmbAudioCod() {
        return cmbAudioCod;
    }

    public JComboBox getCmbAspectRadio() {
        return cmbAspectRadio;
    }

    public JComboBox getCmbDimension() {
        return cmbDimension;
    }

    public JComboBox getCmbExtension() {
        return cmbExtension;
    }

    /**
     * The method constraintComponent add constraint for a component
     * @param component is data that receive a constraint
     * @param posX is data for position on row
     * @param posY is data for position on column
     * @param align is data for place the component.
     */
    private void constraintComponent(Component component, int posX, int posY, int align) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.anchor = align;
        add(component, constraints);
    }
}
