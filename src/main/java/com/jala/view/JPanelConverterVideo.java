/*
 * @(#) JPanelConverterVideo.java Copyright (c) 2019 Jala Foundation.
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

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Module view, UI/JPanelConverterImage.
 * @version 0.0.1.
 * @autor Luis Guardia.
 */
public class JPanelConverterVideo extends JPanel implements ActionListener {

    private JLabel lblPathFileOrigin, lblPathFolderDestiny, lblFileName, lblExtension, lblResolutionVideo, lblAudioChannel, lblFrameRate;
    private JLabel lblSeparatorSpace, lblSeparatorSpace2, lblBitRate, lblSampleRate, lblTypeConversion;
    private JTextField txtPathFileOrigin, txtFolderDestiny, txtFileName;
    private JButton btnPathOriginFile, btnPathFolderDestiny, btnConvertVideo;
    private ButtonGroup typeOfAudioChannel, selectTypeConvertor;
    private JComboBox comboVideoResolution, comboFrameRate, comboExtension, comboBitRate, comboSampleRate;
    private JRadioButton radioStereo, radioMono, radioConvertVideo, radioConvertAudio;
    private JCheckBox checkOptionAdvanced;
    private GridBagLayout esquema;
    private GridBagConstraints constraints;
    private Border border;

    /**
     * Gets the content from TxtPathFileOrigin.
     * @return TxtPathFileOrigin, the content of the TxtPathFileOrigin text field.
     */
    public String getTxtPathFileOrigin() {
        return txtPathFileOrigin.getText().toString();
    }

    /**
     * Gets the content from TxtFolderDestiny.
     * @return TxtFolderDestiny, the content of the TxtFolderDestiny text field.
     */
    public String getTxtFolderDestiny() {
        return txtFolderDestiny.getText().toString();
    }

    /**
     * Gets the content from TxtFileName.
     * @return TxtFileName, the content of the TxtFileName text field.
     */
    public String getTxtFileName() {
        return txtFileName.getText().toString();
    }

    /**
     * Gets the content from comboVideoResolution.
     * @return comboVideoResolution, the selected comboBox element.
     */
    public String getComboVideoResolution() {
        return separateValues(comboVideoResolution.getSelectedItem().toString());
    }

    /**
     * Gets the content from comboFrameRate.
     * @return comboFrameRate, the selected comboBox element.
     */
    public Double getComboFrameRate() {
        return Double.parseDouble(comboFrameRate.getSelectedItem().toString());
    }

    /**
     * Gets the content from comboExtension.
     * @return comboExtension, the selected comboBox element.
     */
    public String getComboExtension() {
        return comboExtension.getSelectedItem().toString();
    }

    /**
     * Gets the content from comboBitRate.
     * @return comboBitRate, the selected comboBox element.
     */
    public Long getComboBitRate() {
        return Long.parseLong(separateValues(comboBitRate.getSelectedItem().toString())) * 1024;
    }

    /**
     * Gets the content from comboSampleRate.
     * @return comboSampleRate, the selected comboBox element
     */
    public int getComboSampleRate() {
        return Integer.parseInt(separateValues(comboSampleRate.getSelectedItem().toString()));
    }

    /**
     * Gets the status from checkOptionAdvanced.
     * @return boolean value, true if checkOptionAdvanced is active and false if not activated.
     */
    public boolean isAdvanced() {
        if (checkOptionAdvanced.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the status from radioConvertVideo.
     * @return boolean value, true if radioConvertVideo is active and false if not activated.
     */
    public boolean isVideo() {
        if (radioConvertVideo.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the status from radioStereo.
     * @return boolean value, true if radioStereo is active and false if not activated.
     */
    public boolean isStereo() {
        if (radioStereo.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get event button Convert Video.
     * @return btnConvertVideo the even button.
     */
    public JButton getBtnConvertVideo() {
        return btnConvertVideo;
    }

    /**
     * Class constructor.
     * @param borderLayout
     */
    public JPanelConverterVideo(BorderLayout borderLayout) {
        initComponents();
    }

    /**
     * Method that creates the components of the graphical interface.
     */
    private void initComponents(){
        esquema= new GridBagLayout();
        constraints = new GridBagConstraints();
        setLayout(esquema);

        lblTypeConversion = new JLabel("Type Conversion:");
        addComponent(lblTypeConversion, 0, 0, 1, 1);

        lblPathFileOrigin = new JLabel("Path Origin File:   ");
        addComponent(lblPathFileOrigin, 0, 1, 1, 1);

        lblPathFolderDestiny = new JLabel("Folder Destiny");
        addComponent(lblPathFolderDestiny, 0, 2, 1, 1);

        lblFileName = new JLabel("File Name");
        addComponent(lblFileName, 0, 3, 1, 1);

        lblExtension = new JLabel("Extension");
        addComponent(lblExtension, 3, 3, 1, 1);

        lblAudioChannel = new JLabel("AudioChannel:  ");
        addComponent(lblAudioChannel, 0, 5, 1, 1);

        lblResolutionVideo = new JLabel("Video Resolution: ");
        addComponent(lblResolutionVideo, 0, 6, 1, 1);

        lblFrameRate = new JLabel("Frame Rate");
        addComponent(lblFrameRate, 3, 6, 1, 1);

        lblSeparatorSpace = new JLabel("   ");
        addComponent(lblSeparatorSpace, 2, 3, 1, 1);

        lblSeparatorSpace2 = new JLabel("   ");
        addComponent(lblSeparatorSpace2, 5, 1, 1, 1);

        lblBitRate = new JLabel("Bit Rate: ");
        addComponent(lblBitRate, 0, 7, 1, 1);

        lblSampleRate = new JLabel("Sample Rate: ");
        addComponent(lblSampleRate, 3, 7, 1, 1);

        txtPathFileOrigin = new JTextField("");
        addComponent(txtPathFileOrigin, 1, 1, 4, 1);

        txtFolderDestiny = new JTextField();
        addComponent(txtFolderDestiny, 1, 2, 4, 1);

        txtFileName = new JTextField();
        addComponent(txtFileName, 1, 3, 1, 1);

        comboExtension = new JComboBox();
        comboExtension.addItem("");
        comboExtension.addItem("mp3");
        comboExtension.addItem("wma");
        comboExtension.addItem("aac");
        comboExtension.addItem("flv");
        comboExtension.addItem("mpeg");
        comboExtension.addItem("avi");
        comboExtension.addItem("mp4");
        comboExtension.addItem("VOB");
        comboExtension.addItem("mkv");
        comboExtension.addItem("MOV");
        addComponent(comboExtension, 4, 3, 1, 1);

        comboVideoResolution = new JComboBox();
        comboVideoResolution.addItem("");
        comboVideoResolution.addItem("ntsc    (720 X 480)");
        comboVideoResolution.addItem("pal     (720 X 576)");
        comboVideoResolution.addItem("film    (352 X 240)");
        comboVideoResolution.addItem("qqvga   (320 X 240)");
        comboVideoResolution.addItem("vga     (640 X 280)");
        comboVideoResolution.addItem("svga    (800 X 600)");
        comboVideoResolution.addItem("xga     (1024 X 768)");
        comboVideoResolution.addItem("uxga    (1600 X 1200)");
        comboVideoResolution.addItem("qxga    (2048 X 1536)");
        comboVideoResolution.addItem("svga    (1280 X 1024)");
        comboVideoResolution.addItem("wvga    (852 X 480)");
        comboVideoResolution.addItem("wxga    (1366 X 768)");
        comboVideoResolution.addItem("wsxga   (1600 X 1024)");
        comboVideoResolution.addItem("wuxga   (1920 X 1200)");
        comboVideoResolution.addItem("cga     (320 X 200)");
        comboVideoResolution.addItem("ega     (640 X 350)");
        comboVideoResolution.addItem("hd480   (852 X 480)");
        comboVideoResolution.addItem("hd720   (1280 X 720)");
        comboVideoResolution.addItem("hd1080  (1920 X 1080)");
        comboVideoResolution.addItem("2k      (2048 X 1080)");
        comboVideoResolution.addItem("4k      (4096 X 2160)");
        comboVideoResolution.addItem("hqvga   (240 X 160)");
        comboVideoResolution.addItem("hvga    (480 X 320)");
        comboVideoResolution.addItem("qhd     (960 X 540)");
        comboVideoResolution.addItem("2kdci   (2048 X 1080)");
        comboVideoResolution.addItem("4kdci   (4096 X 2160)");
        comboVideoResolution.addItem("uhd2160 (3840 X 2160)");
        comboVideoResolution.addItem("uhd4320 (7680 X 4320)");
        addComponent(comboVideoResolution, 1, 6, 1, 1);

        comboFrameRate = new JComboBox();
        comboFrameRate.addItem("");
        comboFrameRate.addItem("30");
        comboFrameRate.addItem("60");
        comboFrameRate.addItem("29.97");
        comboFrameRate.addItem("24");
        comboFrameRate.addItem("24.976");
        addComponent(comboFrameRate, 4, 6, 1, 1);

        comboBitRate = new JComboBox();
        comboBitRate.addItem("");
        comboBitRate.addItem("4 K");
        comboBitRate.addItem("8 K");
        comboBitRate.addItem("32 K");
        comboBitRate.addItem("96 K");
        comboBitRate.addItem("128 K");
        comboBitRate.addItem("192 K");
        comboBitRate.addItem("320 K");
        addComponent(comboBitRate, 1, 7, 1, 1);

        comboSampleRate = new JComboBox();
        comboSampleRate.addItem("");
        comboSampleRate.addItem("8000 Hz");
        comboSampleRate.addItem("11025 Hz");
        comboSampleRate.addItem("12000 Hz");
        comboSampleRate.addItem("16000 Hz");
        comboSampleRate.addItem("22050 Hz");
        comboSampleRate.addItem("32000 Hz");
        comboSampleRate.addItem("44100 Hz");
        comboSampleRate.addItem("48000 Hz");
        comboSampleRate.addItem("96000 Hz");
        addComponent(comboSampleRate, 4, 7, 1, 1);

        radioStereo = new JRadioButton("Stereo      ",true);
        addComponent(radioStereo, 1, 5, 1, 1);

        radioMono = new JRadioButton("Mono ",false);
        addComponent(radioMono, 3, 5, 1, 1);

        radioConvertVideo = new JRadioButton("Video ",true);
        radioConvertVideo.addActionListener(this);
        addComponent(radioConvertVideo, 1, 0, 1, 1);

        radioConvertAudio = new JRadioButton("Audio ",false);
        radioConvertAudio.addActionListener(this);
        addComponent(radioConvertAudio, 3, 0, 1, 1);

        checkOptionAdvanced = new JCheckBox("Option Advanced", true);
        checkOptionAdvanced.addActionListener(this);
        addComponent(checkOptionAdvanced, 1, 4, 1, 1);

        typeOfAudioChannel = new ButtonGroup();
        typeOfAudioChannel.add(radioStereo);
        typeOfAudioChannel.add(radioMono);

        selectTypeConvertor = new ButtonGroup();
        selectTypeConvertor.add(radioConvertAudio);
        selectTypeConvertor.add(radioConvertVideo);

        btnPathOriginFile = new JButton("Search File");
        btnPathOriginFile.addActionListener(this);
        addComponent(btnPathOriginFile, 6, 1, 1, 1);

        btnPathFolderDestiny = new JButton("Destiny");
        btnPathFolderDestiny.addActionListener(this);
        addComponent(btnPathFolderDestiny, 6, 2, 1, 1);

        btnConvertVideo = new JButton("Convert Video");
        btnConvertVideo.addActionListener(this);
        addComponent(btnConvertVideo, 1, 8, 1, 1);
    }

    /**
     * Method that adds components to the GridBagConstraints.
     */
    public void addComponent(Component Component, int sizeX, int sizeY, int sizeFieldX, int sizeFieldY) {
        constraints.gridx = sizeX;
        constraints.gridy = sizeY;
        constraints.gridwidth = sizeFieldX;
        constraints.gridheight = sizeFieldY;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        this.add(Component , constraints);
    }

    /**
     * Method that adds action to the buttons.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnPathOriginFile)) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fileChooser.showOpenDialog(this);
            if (result != JFileChooser.CANCEL_OPTION) {
                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    txtPathFileOrigin.setText("...");
                } else {
                    txtPathFileOrigin.setText(fileName.getAbsolutePath());
                }
            }
        }
        if (e.getSource() == btnPathFolderDestiny) {
            if (e.getSource().equals(btnPathFolderDestiny)) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    txtFolderDestiny.setText("" + chooser.getSelectedFile());
                } else {
                    System.out.println("");
                }
            }
        }

        if (e.getSource() == checkOptionAdvanced) {
            if(checkOptionAdvanced.isSelected() && radioConvertAudio.isSelected() ) {
                enableOptionsAudio();
                disableOptionsVideo();
            }
            if (checkOptionAdvanced.isSelected() && radioConvertVideo.isSelected() ) {
                enableOptionsVideo();
                enableOptionsAudio();
            }
            if (!checkOptionAdvanced.isSelected()) {
                disableOptionsAudio();
                disableOptionsVideo();
            }
        }

        if (e.getSource() == radioConvertAudio) {
            if(radioConvertAudio.isSelected()) {
                checkOptionAdvanced.setSelected(true);
                btnConvertVideo.setText("Convert Audio");
                enableOptionsAudio();
                disableOptionsVideo();
            }
        }

        if (e.getSource() == radioConvertVideo) {
            if(radioConvertVideo.isSelected()) {
                checkOptionAdvanced.setSelected(true);
                btnConvertVideo.setText("Convert Video");
                enableOptionsVideo();
                enableOptionsAudio();
            }
        }

        if (e.getSource() == btnConvertVideo) {
            System.out.println(""+getComboExtension());
            System.out.println(""+getComboVideoResolution());
            System.out.println(""+getTxtFileName());
            System.out.println(""+getComboBitRate());
            System.out.println(""+getComboFrameRate());
            System.out.println(""+getComboSampleRate());
        }
    }

    /**
     * Method that adds action to the buttons.
     */
    private void enableOptionsVideo() {
        comboFrameRate.setEnabled(true);
        comboVideoResolution.setEnabled(true);
    }

    /**
     * Method that adds action to the buttons.
     */
    private void disableOptionsVideo() {
        comboFrameRate.setEnabled(false);
        comboVideoResolution.setEnabled(false);
    }

    /**
     * method that enables audio and video conversion options.
     */
    private void enableOptionsAudio() {
        comboBitRate.setEnabled(true);
        comboSampleRate.setEnabled(true);
        radioMono.setEnabled(true);
        radioStereo.setEnabled(true);
    }

    /**
     * method that disables audio and video conversion options.
     */
    private void disableOptionsAudio() {
        comboBitRate.setEnabled(false);
        comboSampleRate.setEnabled(false);
        radioMono.setEnabled(false);
        radioStereo.setEnabled(false);
    }

    /**
     * Method that adds action to the buttons.
     */
    private String separateValues(String getValue) {
        String[] getString = getValue.split(" ");
        return getString[0];
    }
}