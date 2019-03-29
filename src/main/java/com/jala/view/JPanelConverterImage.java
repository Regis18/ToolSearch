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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Module view, ui/JPanelConverterImage.
 *
 * @version 0.0.1.
 * @autor Luis Guardia.
 */
public class JPanelConverterImage extends JPanel implements ActionListener {

    private JLabel lblPathFileOrigin, lblPathFolderDestiny, lblFileName, lblExtension, lblSizeWidth, lblSizeHeight;
    private JLabel lblChangeSize, lblSeparatorSpace, lblSeparatorSpace2;
    private JTextField txtPathFileOrigin, txtFolderDestiny, txtFileName, txtSizeWidth, txtSizeHeight;
    private JButton btnPathOriginFile, btnPathFolderDestiny, btnConvertFile;
    private ButtonGroup typeOfResize;
    private JRadioButton resizePercentage, resizePixeles;
    private JCheckBox chekMaintainProportion, checkResizeImage;
    private JComboBox cmbExtension;
    private GridBagLayout esquema;
    private GridBagConstraints constraints;
    private CustomErrorMessage msgError;

    /**
     * Sets the Message Error for a pop-up
     * @param msgError define the message of error.
     */
    public void setMsgError(String msgError) {
        this.msgError = new CustomErrorMessage(msgError);
    }

    /**
     * Gets the content from TxtPathFileOrigin.
     *
     * @return TxtPathFileOrigin, the content of the TxtPathFileOrigin text field.
     */
    public String getTxtPathFileOrigin() {
        return txtPathFileOrigin.getText();
    }

    /**
     * Gets the content from TxtFolderDestiny.
     *
     * @return TxtFolderDestiny, the content of the TxtFolderDestiny text field.
     */
    public String getTxtFolderDestiny() {
        return txtFolderDestiny.getText();
    }

    /**
     * Gets the content from TxtFileName.
     *
     * @return TxtFileName, the content of the TxtFileName text field.
     */
    public String getTxtFileName() {
        return txtFileName.getText();
    }

    /**
     * Gets the content from CmbExtension.
     * @return TxtExtension, the content of the TxtExtension JcomboBox
     */
    public String getTxtExtension() {
        return cmbExtension.getSelectedItem().toString();
    }

    /**
     * Gets the content from TxtSizeWidth.
     *
     * @return TxtSizeWidth, the content of the TxtSizeWidth text field.
     */
    public String getTxtSizeWidth() {
        return txtSizeWidth.getText();
    }

    /**
     * Gets the content from TxtSizeHeight.
     *
     * @return TxtSizeHeight, the content of the TxtSizeHeight text field.
     */
    public String getTxtSizeHeight() {
        return txtSizeHeight.getText();
    }

    /**
     * Gets the button btnConvertFile
     *
     * @return btnConvertFile
     */
    public JButton getBtnConvert() {
        return btnConvertFile;
    }

    /**
     * Gets the status from resizePixeles.
     *
     * @return boolean value, true if radioButton is active and false if not activated.
     */
    public boolean isPixeles() {
        return resizePixeles.isSelected();
    }

    /**
     * Gets the status from chekMaintainProportion.
     *
     * @return boolean value, true if checkBox is active and false if not activated.
     */
    public boolean isProprotion() {
        return chekMaintainProportion.isSelected();
    }

    /**
     * Gets the status from chekResizeImage.
     *
     * @return boolean value, true if checkBox is active and false if not activated.
     */
    public boolean isResize() {
        return checkResizeImage.isSelected();
    }

    /**
     * Class constructor.
     *
     * @param borderLayout
     */
    public JPanelConverterImage(BorderLayout borderLayout) {
        esquema = new GridBagLayout();
        constraints = new GridBagConstraints();
        setLayout(esquema);

        lblPathFileOrigin = new CustomLabel("Source Path File: ");
        addComponent(lblPathFileOrigin, 0, 0, 1, 1);

        lblPathFolderDestiny = new CustomLabel("Destination Folder: ");
        addComponent(lblPathFolderDestiny, 0, 1, 1, 1);

        lblFileName = new CustomLabel("File Name: ");
        addComponent(lblFileName, 0, 2, 1, 1);

        lblExtension = new CustomLabel("Extension: ");
        addComponent(lblExtension, 3, 2, 1, 1);

        lblChangeSize = new CustomLabel("Change Size to: ");
        addComponent(lblChangeSize, 0, 3, 1, 1);

        lblSizeWidth = new CustomLabel("Width: ");
        addComponent(lblSizeWidth, 0, 4, 1, 1);

        lblSizeHeight = new CustomLabel("Height: ");
        addComponent(lblSizeHeight, 3, 4, 1, 1);

        lblSeparatorSpace = new CustomLabel("   ");
        addComponent(lblSeparatorSpace, 2, 2, 1, 1);

        lblSeparatorSpace2 = new CustomLabel("   ");
        addComponent(lblSeparatorSpace2, 5, 0, 1, 1);

        txtPathFileOrigin = new CustomTextField();
        txtPathFileOrigin.setEditable(false);
        addComponent(txtPathFileOrigin, 1, 0, 4, 1);

        txtFolderDestiny = new CustomTextField();
        txtFolderDestiny.setEditable(false);
        addComponent(txtFolderDestiny, 1, 1, 4, 1);

        txtFileName = new CustomTextField();
        addComponent(txtFileName, 1, 2, 1, 1);

        cmbExtension = new CustomJCombo();
        cmbExtension.addItem("");
        cmbExtension.addItem("jpg");
        cmbExtension.addItem("bmp");
        cmbExtension.addItem("eps");
        cmbExtension.addItem("gif");
        cmbExtension.addItem("map");
        cmbExtension.addItem("odg");
        cmbExtension.addItem("pal");
        cmbExtension.addItem("pcd");
        cmbExtension.addItem("pdf");
        cmbExtension.addItem("png");
        cmbExtension.addItem("ppm");
        cmbExtension.addItem("psd");
        cmbExtension.addItem("raw");
        cmbExtension.addItem("svg");
        cmbExtension.addItem("tga");
        cmbExtension.addItem("tif");
        cmbExtension.addItem("tiff");
        cmbExtension.addItem("wbmp");
        cmbExtension.addItem("webp");
        addComponent(cmbExtension, 4, 2, 1, 1);

        txtSizeWidth = new CustomTextField();
        addComponent(txtSizeWidth, 1, 4, 1, 1);

        txtSizeHeight = new CustomTextField();
        addComponent(txtSizeHeight, 4, 4, 1, 1);

        resizePixeles = new CustomRadioButton("Pixels");
        addComponent(resizePixeles, 1, 3, 1, 1);

        resizePercentage = new CustomRadioButton("Percentage");
        resizePercentage.setSelected(false);
        addComponent(resizePercentage, 3, 3, 1, 1);

        chekMaintainProportion = new CustomCheckBox("Keep Proportion");
        addComponent(chekMaintainProportion, 4, 3, 1, 1);

        checkResizeImage = new CustomCheckBox("Resize");
        addComponent(checkResizeImage, 6, 4, 1, 1);

        typeOfResize = new ButtonGroup();
        typeOfResize.add(resizePixeles);
        typeOfResize.add(resizePercentage);

        btnPathOriginFile = new CustomButton();
        btnPathOriginFile.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\searchFile24.png"));
        btnPathOriginFile.setToolTipText("Search File");
        btnPathOriginFile.addActionListener(this);
        addComponent(btnPathOriginFile, 6, 0, 1, 1);

        btnPathFolderDestiny = new CustomButton();
        btnPathFolderDestiny.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\output24.png"));
        btnPathFolderDestiny.setToolTipText("Output");
        btnPathFolderDestiny.addActionListener(this);
        addComponent(btnPathFolderDestiny, 6, 1, 1, 1);

        btnConvertFile = new CustomButton();
        btnConvertFile.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\converter36.png"));
        btnConvertFile.setToolTipText("Convert");
        addComponent(btnConvertFile, 1, 5, 1, 1);
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
        this.add(Component, constraints);
    }

    /**
     * Method that adds action to the buttons.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnPathOriginFile)) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filterImage=new FileNameExtensionFilter("Only Image","jpg",
                    "png", "gif", "bmp", "cdr", "eps", "map", "odg", "psd", "raw", "svg", "tif", "tiff", "wbmp", "webp");
            fileChooser.setFileFilter(filterImage);
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
                    System.out.println();
                }
            }
        }
    }
}

