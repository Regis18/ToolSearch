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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * JPanelSearchVideo class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchVideo extends JPanel implements ActionListener {
    private JLabel lbFramRat, lbVideoCod,
                     lbAudioCod, lbAspectRadio, lbDimention, lbExtension;
    private JButton btSerach;
    private JComboBox cbFramRat, cbVideoCod, cbAudioCod, cbAspectRadio,
                        cbDimention, cbExtension;

    /**
     * The constructor method of the ViewConsole class to build an instance
     */
    public JPanelSearchVideo() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        lbFramRat = new JLabel("Frame Rate: ");
        constraintComponent(lbFramRat, 0, 2, GridBagConstraints.EAST);
        lbVideoCod = new JLabel("Video Codec: ");
        constraintComponent(lbVideoCod, 0, 3, GridBagConstraints.EAST);
        lbAudioCod = new JLabel("Audio Codec: ");
        constraintComponent(lbAudioCod, 0, 4, GridBagConstraints.EAST);
        cbFramRat = new JComboBox();
        cbFramRat.addItem("SELECT");
        cbFramRat.addItem("30");
        cbFramRat.addItem("25");
        cbFramRat.addItem("27");
        cbFramRat.addItem("60");
        cbFramRat.addItem("29.7");
        cbFramRat.addItem("24");
        cbFramRat.addItem("24.976");
        constraintComponent(cbFramRat, 1, 2, GridBagConstraints.WEST);
        cbVideoCod = new JComboBox();
        cbVideoCod.addItem("SELECT");
        cbVideoCod.addItem("H.264/MPEG-4 AVC");
        cbVideoCod.addItem("H.265/MPEG-H HEVC");
        cbVideoCod.addItem("H.263/MPEG-4 parte2 codecs");
        cbVideoCod.addItem("H.262/MPEG-2 codecs");
        cbVideoCod.addItem("MPEG-1");
        cbVideoCod.addItem("WMV");
        cbVideoCod.addItem("MJPEG");
        cbVideoCod.addItem("DV and HDV");
        cbVideoCod.addItem("MPEG-2");
        cbVideoCod.addItem("Microsoft VC-1");
        constraintComponent(cbVideoCod, 1, 3, GridBagConstraints.WEST);
        cbAudioCod = new JComboBox();
        cbAudioCod.addItem("SELECT");
        cbAudioCod.addItem("WAV");
        cbAudioCod.addItem("FLAC");
        cbAudioCod.addItem("MP3");
        cbAudioCod.addItem("WMA");
        cbAudioCod.addItem("ALAC");
        cbAudioCod.addItem("Ogg Vorbis");
        cbAudioCod.addItem("AAC");
        cbAudioCod.addItem("AIFF");
        cbAudioCod.addItem("DSD");
        constraintComponent(cbAudioCod, 1, 4, GridBagConstraints.WEST);
        lbAspectRadio = new JLabel("Aspect Ratio: ");
        constraintComponent(lbAspectRadio, 2, 2, GridBagConstraints.EAST);
        lbDimention = new JLabel("Dimension: ");
        constraintComponent(lbDimention, 2, 3, GridBagConstraints.EAST);
        cbAspectRadio = new JComboBox();
        lbExtension = new JLabel("Extension: ");
        constraintComponent(lbExtension, 2, 4, GridBagConstraints.EAST);
        cbAspectRadio = new JComboBox();
        cbAspectRadio.addItem("SELECT");
        cbAspectRadio.addItem("5:4");
        cbAspectRadio.addItem("4:3");
        cbAspectRadio.addItem("3:2");
        cbAspectRadio.addItem("16:10");
        cbAspectRadio.addItem("16:9");
        cbAspectRadio.addItem("1.85:1");
        cbAspectRadio.addItem("1.35:1");
        constraintComponent(cbAspectRadio, 3, 2, GridBagConstraints.WEST);
        cbDimention = new JComboBox();
        cbDimention.addItem("SELECT");
        cbDimention.addItem("400/300");
        cbDimention.addItem("1280/750");
        cbDimention.addItem("1000/780");
        cbDimention.addItem("400/300");
        cbDimention.addItem("400/300");
        constraintComponent(cbDimention, 3, 3, GridBagConstraints.WEST);
        cbExtension = new JComboBox();
        cbExtension.addItem("SELECT");
        cbExtension.addItem("FLV");
        cbExtension.addItem("AVI");
        cbExtension.addItem("MOV");
        cbExtension.addItem("MP4");
        cbExtension.addItem("MPG");
        cbExtension.addItem("WMV");
        constraintComponent(cbExtension, 3, 4, GridBagConstraints.WEST);
        btSerach = new JButton("Search");
        btSerach.addActionListener(this);
        constraintComponent(btSerach, 3, 5, GridBagConstraints.EAST);
    }

    /**
     * Section of getter methods
     */
    public JComboBox getCbFramRat() {
        return cbFramRat;
    }

    public JComboBox getCbVideoCod() {
        return cbVideoCod;
    }

    public JComboBox getCbAudioCod() {
        return cbAudioCod;
    }

    public JComboBox getCbAspectRadio() {
        return cbAspectRadio;
    }

    public JComboBox getCbDimention() {
        return cbDimention;
    }

    public JComboBox getCbExtension() {
        return cbExtension;
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

    /**
     * method that listen action on a button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You are searching video files");
    }
}
