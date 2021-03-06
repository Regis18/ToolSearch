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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JPanelSearchVideo class is the panel with new attributes
 * for to do search advanced video.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPanelSearchVideo extends JPanel implements ActionListener {
    private JLabel lblFrameRate, lblVideoCodec, lblAudioCodec,
            lblAspectRatio, lblAudioChannel, lblAudioSampleRate, lblExtension, lblDuration;
    private JTextField txtAudioSampleRate, txtDuration;
    private JButton btnSearch;
    private JComboBox cmbFrameRate, cmbVideoCodec, cmbAudioCodec,
            cmbAspectRatio, cmbExtensionVideo, cmbExtensionAudio;
    private ButtonGroup typeOfAudioChannel, selectTypeSearch;
    private JRadioButton radioStereo, radioMono, radioVideo, radioAudio;
    private CustomErrorMessage msgError;

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

        lblFrameRate = new CustomLabel("Frame Rate: ");
        constraintComponent(lblFrameRate, 0, 2, GridBagConstraints.EAST);

        lblVideoCodec = new CustomLabel("Video Codec: ");
        constraintComponent(lblVideoCodec, 0, 3, GridBagConstraints.EAST);

        lblAudioCodec = new CustomLabel("Audio Codec: ");
        constraintComponent(lblAudioCodec, 0, 4, GridBagConstraints.EAST);

        cmbFrameRate = new CustomJCombo();
        String[] myFrameRat = {"", "24", "24.976", "25", "27", "29.7", "30", "60"};
        addItemsComboBox(myFrameRat, cmbFrameRate);
        constraintComponent(cmbFrameRate, 1, 2, GridBagConstraints.WEST);

        cmbVideoCodec = new CustomJCombo();
        String[] myVideoCod = {"", "H.264/MPEG-4 AVC", "H.265/MPEG-H HEVC",
                "H.263/MPEG-4 parte2 codecs", "H.262/MPEG-2 codecs", "MPEG-1",
                "WMV", "MJPEG", "DV and HDV", "MPEG-2", "Microsoft VC-1"};
        addItemsComboBox(myVideoCod, cmbVideoCodec);
        constraintComponent(cmbVideoCodec, 1, 3, GridBagConstraints.WEST);

        cmbAudioCodec = new CustomJCombo();
        String[] myAudioCod = {"", "WAV", "FLAC", "MP3", "WMA", "MPEG-1", "WMV", "ALAC",
                "Ogg Vorbis", "AAC", "AIFF", "DSD"};
        addItemsComboBox(myAudioCod, cmbAudioCodec);
        constraintComponent(cmbAudioCodec, 1, 4, GridBagConstraints.WEST);

        lblAspectRatio = new CustomLabel("Aspect Ratio: ");
        constraintComponent(lblAspectRatio, 2, 2, GridBagConstraints.EAST);

        lblExtension = new CustomLabel("Extension: ");
        constraintComponent(lblExtension, 2, 3, GridBagConstraints.EAST);

        cmbAspectRatio = new CustomJCombo();
        String[] myAspectRatio = {"", "1:1", "3:2", "4:3", "5:4", "16:9", "16:10", "1.35:1", "1.85:1"};
        addItemsComboBox(myAspectRatio, cmbAspectRatio);
        constraintComponent(cmbAspectRatio, 3, 2, GridBagConstraints.WEST);

        cmbExtensionVideo = new CustomJCombo();
        String[] myExtensionVideo = {"", "Mp4", "Flv", "Avi", "Mov", "Wmv", "Mpg", "Dat", "Flv"};
        addItemsComboBox(myExtensionVideo, cmbExtensionVideo);
        constraintComponent(cmbExtensionVideo, 3, 3, GridBagConstraints.WEST);

        cmbExtensionAudio = new CustomJCombo();
        String[] myExtensionAudio = {"", "Mp3", "M4a", "Wma", "Wav", "Ogg", "Midi", "Aac"};
        addItemsComboBox(myExtensionAudio, cmbExtensionAudio);
        constraintComponent(cmbExtensionAudio, 3, 3, GridBagConstraints.WEST);

        lblAudioChannel = new CustomLabel("AudioChannel: ");
        constraintComponent(lblAudioChannel, 4, 1, GridBagConstraints.EAST);
        radioStereo = new CustomRadioButton("Stereo");
        constraintComponent(radioStereo, 4, 2, GridBagConstraints.WEST);
        radioMono = new CustomRadioButton("Mono");
        radioMono.setSelected(false);
        constraintComponent(radioMono, 4, 3, GridBagConstraints.WEST);

        radioVideo = new CustomRadioButton("Video");
        radioVideo.addActionListener(this);
        constraintComponent(radioVideo, 1, 0, GridBagConstraints.EAST);
        radioAudio = new CustomRadioButton("Audio");
        radioAudio.setSelected(false);
        radioAudio.addActionListener(this);
        constraintComponent(radioAudio, 2, 0, GridBagConstraints.WEST);

        typeOfAudioChannel = new ButtonGroup();
        typeOfAudioChannel.add(radioStereo);
        typeOfAudioChannel.add(radioMono);

        selectTypeSearch = new ButtonGroup();
        selectTypeSearch.add(radioAudio);
        selectTypeSearch.add(radioVideo);

        lblAudioSampleRate = new CustomLabel("Audio Sample Rate: ");
        constraintComponent(lblAudioSampleRate, 0, 5, GridBagConstraints.EAST);
        txtAudioSampleRate = new CustomTextField(10);
        constraintComponent(txtAudioSampleRate, 1, 5, GridBagConstraints.WEST);
        lblDuration = new CustomLabel("Duration: ");
        constraintComponent(lblDuration, 2, 5, GridBagConstraints.EAST);
        txtDuration = new CustomTextField(10);
        constraintComponent(txtDuration, 3, 5, GridBagConstraints.EAST);

        btnSearch = new CustomButton();
        btnSearch.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\search36.png"));
        btnSearch.setToolTipText("Search");
        constraintComponent(btnSearch, 4, 7, GridBagConstraints.EAST);
    }

    /**
     * Method that adds action to the buttons.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == radioVideo) {
            if (radioVideo.isSelected()) {
                btnSearch.setToolTipText("Search Video");
                enableOptionsVideo();
                cmbExtensionVideo.setVisible(true);
                cmbExtensionAudio.setVisible(false);
            }
        }
        if (event.getSource() == radioAudio) {
            if (radioAudio.isSelected()) {
                btnSearch.setToolTipText("Search Audio");
                disableOptionsVideo();
                cmbExtensionVideo.setVisible(false);
                cmbExtensionAudio.setVisible(true);
            }
        }
    }

    /**
     * Method that adds action to the buttons.
     */
    private void enableOptionsVideo() {
        cmbFrameRate.setEnabled(true);
        cmbVideoCodec.setEnabled(true);
        cmbAspectRatio.setEnabled(true);
    }

    /**
     * Method that adds action to the buttons.
     */
    private void disableOptionsVideo() {
        cmbFrameRate.setEnabled(false);
        cmbVideoCodec.setEnabled(false);
        cmbAspectRatio.setEnabled(false);
    }

    /**
     * This method addItemsComboBox add myItems into a cmb.
     *
     * @param myItems is a string array
     * @param cmb     is a JComboBox class component
     */
    private void addItemsComboBox(String[] myItems, JComboBox cmb) {
        for (String item : myItems) {
            cmb.addItem(item);
        }
    }

    /**
     * The constraintComponent method add constraint for a component.
     *
     * @param component is data that receive a constraint
     * @param posX      is data for position on row
     * @param posY      is data for position on column
     * @param align     is data for place the component.
     */
    private void constraintComponent(Component component, int posX, int posY, int align) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = align;
        add(component, constraints);
    }

    /**
     * Sets the Message Error for a pop-up
     * @param msgError define the message of error.
     */
    public void setMsgError(String msgError) {
        this.msgError = new CustomErrorMessage(msgError);
    }

    /**
     * The radioStereo method get RadioButton.
     */
    public JRadioButton getRadioStereo() {
        return radioStereo;
    }

    /**
     * The radioMono method get RadioButton.
     */
    public JRadioButton getRadioMono() {
        return radioMono;
    }

    /**
     * The radioVideo method get RadioButton.
     */
    public JRadioButton getRadioVideo() {
        return radioVideo;
    }

    /**
     * The RadioAudio method get RadioButton
     */
    public JRadioButton getRadioAudio() {
        return radioAudio;
    }

    /**
     * The txtDuration method get String of txtField selected.
     */
    public String getTxtAudioSampleRate() {
        return txtAudioSampleRate.getText();
    }

    /**
     * The txtDuration method get String of txtField selected.
     */
    public String getTxtDuration() {
        return txtDuration.getText();
    }

    /**
     * The getBtnSearch method get JButton attribute of itself class.
     *
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
     * The getCmbExtensionVideo method get String of ComboBox selected.
     */
    public String getCmbExtensionVideo() {
        return cmbExtensionVideo.getSelectedItem().toString();
    }

    /**
     * The getCmbExtensionAudio method get String of ComboBox selected.
     */
    public String getCmbExtensionAudio() {
        return cmbExtensionAudio.getSelectedItem().toString();
    }

    /**
     * Gets the status from radioConvertVideo.
     *
     * @return boolean value, true if radioConvertVideo is active and false if not activated.
     */
    public boolean isVideo() {
        return radioVideo.isSelected();
    }

    /**
     * Gets the status from radioStereo.
     *
     * @return boolean value, true if radioStereo is active and false if not activated.
     */
    public boolean isStereo() {
        return radioStereo.isSelected();
    }
}
