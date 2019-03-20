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
import javax.swing.border.Border;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
    private ButtonGroup typeOfAudioChannel, selectTypeConverter;
    private JComboBox cmbVideoResolution, cmbFrameRate, cmbExtension, cmbBitRate, cmbSampleRate;
    private JRadioButton radioStereo, radioMono, radioConvertVideo, radioConvertAudio;
    private JCheckBox chkOptionAdvanced;
    private GridBagLayout gridBag;
    private GridBagConstraints constraints;
    private Border border;

    /**
     * Gets the content from TxtPathFileOrigin.
     * @return TxtPathFileOrigin, the content of the TxtPathFileOrigin text field.
     */
    public String getTxtPathFileOrigin() {
        return txtPathFileOrigin.getText();
    }

    /**
     * Gets the content from TxtFolderDestiny.
     * @return TxtFolderDestiny, the content of the TxtFolderDestiny text field.
     */
    public String getTxtFolderDestiny() {
        return txtFolderDestiny.getText();
    }

    /**
     * Gets the content from TxtFileName.
     * @return TxtFileName, the content of the TxtFileName text field.
     */
    public String getTxtFileName() {
        return txtFileName.getText();
    }

    /**
     * Gets the content from cmbVideoResolution.
     * @return cmbVideoResolution, the selected comboBox element.
     */
    public String getCmbVideoResolution() {
        return separateValues(cmbVideoResolution.getSelectedItem().toString());
    }

    /**
     * Gets the content from cmbFrameRate.
     * @return cmbFrameRate, the selected comboBox element.
     */
    public Double getCmbFrameRate() {
        double send = 0;
        if (cmbFrameRate.getSelectedItem() != "") {
            send = Double.parseDouble(cmbFrameRate.getSelectedItem().toString());
        }
        return send;
    }

    /**
     * Gets the content from cmbExtension.
     * @return cmbExtension, the selected comboBox element.
     */
    public String getCmbExtension() {
        return cmbExtension.getSelectedItem().toString();
    }

    /**
     * Gets the content from cmbBitRate.
     * @return cmbBitRate, the selected comboBox element.
     */
    public Long getCmbBitRate() {
        long send = 0;
        if (cmbBitRate.getSelectedItem() != "") {
            send = Long.parseLong(separateValues(cmbBitRate.getSelectedItem().toString())) * 1024;
        }
        return send;
    }

    /**
     * Gets the content from cmbSampleRate.
     * @return cmbSampleRate, the selected comboBox element
     */
    public int getCmbSampleRate() {
        int send = 0;
        if (cmbSampleRate.getSelectedItem() != "") {
            send = Integer.parseInt(separateValues(cmbSampleRate.getSelectedItem().toString()));
        }
        return send;
    }

    /**
     * Gets the status from chkOptionAdvanced.
     * @return boolean value, true if chkOptionAdvanced is active and false if not activated.
     */
    public boolean isAdvanced() {
        if (chkOptionAdvanced.isSelected()) {
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
    private void initComponents() {
        gridBag = new GridBagLayout();
        constraints = new GridBagConstraints();
        setLayout(gridBag);

        lblTypeConversion = new CustomLabel("Type Conversion: ");
        addComponent(lblTypeConversion, 0, 0, 1, 1);

        lblPathFileOrigin = new CustomLabel("Path Origin File: ");
        addComponent(lblPathFileOrigin, 0, 1, 1, 1);

        lblPathFolderDestiny = new CustomLabel("Folder Destiny: ");
        addComponent(lblPathFolderDestiny, 0, 2, 1, 1);

        lblFileName = new CustomLabel("File Name: ");
        addComponent(lblFileName, 0, 3, 1, 1);

        lblExtension = new CustomLabel("Extension: ");
        addComponent(lblExtension, 3, 3, 1, 1);

        lblAudioChannel = new CustomLabel("AudioChannel: ");
        addComponent(lblAudioChannel, 0, 5, 1, 1);

        lblResolutionVideo = new CustomLabel("Video Resolution: ");
        addComponent(lblResolutionVideo, 0, 6, 1, 1);

        lblFrameRate = new CustomLabel("Frame Rate: ");
        addComponent(lblFrameRate, 3, 6, 1, 1);

        lblSeparatorSpace = new JLabel("   ");
        addComponent(lblSeparatorSpace, 2, 3, 1, 1);

        lblSeparatorSpace2 = new JLabel("   ");
        addComponent(lblSeparatorSpace2, 5, 1, 1, 1);

        lblBitRate = new CustomLabel("Bit Rate: ");
        addComponent(lblBitRate, 0, 7, 1, 1);

        lblSampleRate = new CustomLabel("Sample Rate: ");
        addComponent(lblSampleRate, 3, 7, 1, 1);

        txtPathFileOrigin = new JTextField(" ");
        addComponent(txtPathFileOrigin, 1, 1, 4, 1);

        txtFolderDestiny = new JTextField();
        addComponent(txtFolderDestiny, 1, 2, 4, 1);

        txtFileName = new JTextField();
        addComponent(txtFileName, 1, 3, 1, 1);

        cmbExtension = new CustomJCombo();
        cmbExtension.addItem(" ");
        cmbExtension.addItem("mp3");
        cmbExtension.addItem("wma");
        cmbExtension.addItem("aac");
        cmbExtension.addItem("flv");
        cmbExtension.addItem("mpeg");
        cmbExtension.addItem("avi");
        cmbExtension.addItem("mp4");
        cmbExtension.addItem("VOB");
        cmbExtension.addItem("mkv");
        cmbExtension.addItem("MOV");
        addComponent(cmbExtension, 4, 3, 1, 1);

        cmbVideoResolution = new CustomJCombo();
        cmbVideoResolution.addItem(" ");
        cmbVideoResolution.addItem("ntsc    (720 X 480)");
        cmbVideoResolution.addItem("pal     (720 X 576)");
        cmbVideoResolution.addItem("film    (352 X 240)");
        cmbVideoResolution.addItem("qqvga   (320 X 240)");
        cmbVideoResolution.addItem("vga     (640 X 280)");
        cmbVideoResolution.addItem("svga    (800 X 600)");
        cmbVideoResolution.addItem("xga     (1024 X 768)");
        cmbVideoResolution.addItem("uxga    (1600 X 1200)");
        cmbVideoResolution.addItem("qxga    (2048 X 1536)");
        cmbVideoResolution.addItem("svga    (1280 X 1024)");
        cmbVideoResolution.addItem("wvga    (852 X 480)");
        cmbVideoResolution.addItem("wxga    (1366 X 768)");
        cmbVideoResolution.addItem("wsxga   (1600 X 1024)");
        cmbVideoResolution.addItem("wuxga   (1920 X 1200)");
        cmbVideoResolution.addItem("cga     (320 X 200)");
        cmbVideoResolution.addItem("ega     (640 X 350)");
        cmbVideoResolution.addItem("hd480   (852 X 480)");
        cmbVideoResolution.addItem("hd720   (1280 X 720)");
        cmbVideoResolution.addItem("hd1080  (1920 X 1080)");
        cmbVideoResolution.addItem("2k      (2048 X 1080)");
        cmbVideoResolution.addItem("4k      (4096 X 2160)");
        cmbVideoResolution.addItem("hqvga   (240 X 160)");
        cmbVideoResolution.addItem("hvga    (480 X 320)");
        cmbVideoResolution.addItem("qhd     (960 X 540)");
        cmbVideoResolution.addItem("2kdci   (2048 X 1080)");
        cmbVideoResolution.addItem("4kdci   (4096 X 2160)");
        cmbVideoResolution.addItem("uhd2160 (3840 X 2160)");
        cmbVideoResolution.addItem("uhd4320 (7680 X 4320)");
        addComponent(cmbVideoResolution, 1, 6, 1, 1);

        cmbFrameRate = new CustomJCombo();
        cmbFrameRate.addItem(" ");
        cmbFrameRate.addItem("30");
        cmbFrameRate.addItem("60");
        cmbFrameRate.addItem("29.97");
        cmbFrameRate.addItem("24");
        cmbFrameRate.addItem("24.976");
        addComponent(cmbFrameRate, 4, 6, 1, 1);

        cmbBitRate = new CustomJCombo();
        cmbBitRate.addItem(" ");
        cmbBitRate.addItem("4 K");
        cmbBitRate.addItem("8 K");
        cmbBitRate.addItem("32 K");
        cmbBitRate.addItem("96 K");
        cmbBitRate.addItem("128 K");
        cmbBitRate.addItem("192 K");
        cmbBitRate.addItem("320 K");
        addComponent(cmbBitRate, 1, 7, 1, 1);

        cmbSampleRate = new CustomJCombo();
        cmbSampleRate.addItem("");
        cmbSampleRate.addItem("8000 Hz");
        cmbSampleRate.addItem("11025 Hz");
        cmbSampleRate.addItem("12000 Hz");
        cmbSampleRate.addItem("16000 Hz");
        cmbSampleRate.addItem("22050 Hz");
        cmbSampleRate.addItem("32000 Hz");
        cmbSampleRate.addItem("44100 Hz");
        cmbSampleRate.addItem("48000 Hz");
        cmbSampleRate.addItem("96000 Hz");
        addComponent(cmbSampleRate, 4, 7, 1, 1);

        radioStereo = new JRadioButton("Stereo",true);
        addComponent(radioStereo, 1, 5, 1, 1);

        radioMono = new JRadioButton("Mono",false);
        addComponent(radioMono, 3, 5, 1, 1);

        radioConvertVideo = new JRadioButton("Video",true);
        radioConvertVideo.addActionListener(this);
        addComponent(radioConvertVideo, 1, 0, 1, 1);

        radioConvertAudio = new JRadioButton("Audio",false);
        radioConvertAudio.addActionListener(this);
        addComponent(radioConvertAudio, 3, 0, 1, 1);

        chkOptionAdvanced = new JCheckBox("Option Advanced", true);
        chkOptionAdvanced.addActionListener(this);
        addComponent(chkOptionAdvanced, 1, 4, 1, 1);

        typeOfAudioChannel = new ButtonGroup();
        typeOfAudioChannel.add(radioStereo);
        typeOfAudioChannel.add(radioMono);

        selectTypeConverter = new ButtonGroup();
        selectTypeConverter.add(radioConvertAudio);
        selectTypeConverter.add(radioConvertVideo);

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
        constraints.insets = new Insets(2, 2, 2, 2);
        this.add(Component , constraints);
    }

    /**
     * Method that adds action to the buttons.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(btnPathOriginFile)) {
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
        if (event.getSource() == btnPathFolderDestiny) {
            if (event.getSource().equals(btnPathFolderDestiny)) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    txtFolderDestiny.setText("" + chooser.getSelectedFile());
                }
            }
        }
        if (event.getSource() == chkOptionAdvanced) {
            if (chkOptionAdvanced.isSelected() && radioConvertAudio.isSelected()) {
                enableOptionsAudio();
                disableOptionsVideo();
            }
            if (chkOptionAdvanced.isSelected() && radioConvertVideo.isSelected()) {
                enableOptionsVideo();
                enableOptionsAudio();
            }
            if (!chkOptionAdvanced.isSelected()) {
                disableOptionsAudio();
                disableOptionsVideo();
            }
        }
        if (event.getSource() == radioConvertAudio) {
            if (radioConvertAudio.isSelected()) {
                chkOptionAdvanced.setSelected(true);
                btnConvertVideo.setText("Convert Audio");
                enableOptionsAudio();
                disableOptionsVideo();
            }
        }
        if (event.getSource() == radioConvertVideo) {
            if (radioConvertVideo.isSelected()) {
                chkOptionAdvanced.setSelected(true);
                btnConvertVideo.setText("Convert Video");
                enableOptionsVideo();
                enableOptionsAudio();
            }
        }
    }

    /**
     * Method that adds action to the buttons.
     */
    private void enableOptionsVideo() {
        cmbFrameRate.setEnabled(true);
        cmbVideoResolution.setEnabled(true);
    }

    /**
     * Method that adds action to the buttons.
     */
    private void disableOptionsVideo() {
        cmbFrameRate.setEnabled(false);
        cmbVideoResolution.setEnabled(false);
    }

    /**
     * Method that enables audio and video conversion options.
     */
    private void enableOptionsAudio() {
        cmbBitRate.setEnabled(true);
        cmbSampleRate.setEnabled(true);
        radioMono.setEnabled(true);
        radioStereo.setEnabled(true);
    }

    /**
     * Method that disables audio and video conversion options.
     */
    private void disableOptionsAudio() {
        cmbBitRate.setEnabled(false);
        cmbSampleRate.setEnabled(false);
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