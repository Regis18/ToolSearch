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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.Border;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Module view, ui/JPanelConverterImage.
 * @version 0.0.1.
 * @autor Luis Guardia.
 */
public class JPanelConverterImage extends JPanel implements ActionListener {

    private JLabel lblPathFileOrigin, lblPathFolderDestiny, lblFileName, lblExtension, lblSizeWidth, lblSizeHeight;
    private JLabel lblChangeSize, lblSeparatorSpace, lblSeparatorSpace2, lblMaintainProportion, lblOwmer;
    private JTextField txtPathFileOrigin, txtFolderDestiny, txtFileName, txtExtension, txtSizeWidth, txtSizeHeight;
    private JButton btnPathOriginFile, btnPathFolderDestiny, btnConvertFile;
    private ButtonGroup typeOfResize;
    private JRadioButton resizePercentage, resizePixeles;
    private JCheckBox chekMaintainProportion, checkResizeImage;
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
     * Gets the content from TxtExtension.
     * @return TxtExtension, the content of the TxtExtension text field.
     */
    public String getTxtExtension() {
        return txtExtension.getText();
    }

    /**
     * Gets the content from TxtSizeWidth.
     * @return TxtSizeWidth, the content of the TxtSizeWidth text field.
     */
    public String getTxtSizeWidth() {
        return txtSizeWidth.getText();
    }

    /**
     * Gets the content from TxtSizeHeight.
     * @return TxtSizeHeight, the content of the TxtSizeHeight text field.
     */
    public String getTxtSizeHeight() {
        return txtSizeHeight.getText();
    }

    /**
     * Gets the button btnConvertFile
     * @return btnConvertFile
     */
    public JButton getBtnConvert() {
        return btnConvertFile;
    }

    /**
     * Gets the status from resizePixeles.
     * @return boolean value, true if radioButton is active and false if not activated.
     */
    public boolean isPixeles() {
        if (resizePixeles.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the status from chekMaintainProportion.
     * @return boolean value, true if checkBox is active and false if not activated.
     */
    public boolean isProprotion() {
        if (chekMaintainProportion.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the status from chekResizeImage.
     * @return boolean value, true if checkBox is active and false if not activated.
     */
    public boolean isResize() {
        if (checkResizeImage.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Class constructor.
     * @param borderLayout
     */
    public JPanelConverterImage(BorderLayout borderLayout) {
        esquema= new GridBagLayout();
        constraints = new GridBagConstraints();
        setLayout(esquema);

        lblPathFileOrigin = new CustomLabel("Path Origin File: ");
        addComponent(lblPathFileOrigin, 0, 0, 1, 1);

        lblPathFolderDestiny = new CustomLabel("Folder Destiny: ");
        addComponent(lblPathFolderDestiny, 0, 1, 1, 1);

        lblFileName = new CustomLabel("File Name: ");
        addComponent(lblFileName, 0, 2, 1, 1);

        lblExtension = new CustomLabel("Extension: ");
        addComponent(lblExtension, 3, 2, 1, 1);

        lblChangeSize = new CustomLabel("Change Size to: ");
        addComponent(lblChangeSize, 0, 3, 1, 1);

        lblSizeWidth = new CustomLabel("Size Width: ");
        addComponent(lblSizeWidth, 0, 4, 1, 1);

        lblSizeHeight = new CustomLabel("Size Height: ");
        addComponent(lblSizeHeight, 3, 4, 1, 1);

        lblSeparatorSpace = new CustomLabel("   ");
        addComponent(lblSeparatorSpace, 2, 2, 1, 1);

        lblSeparatorSpace2 = new CustomLabel("   ");
        addComponent(lblSeparatorSpace2, 5, 0, 1, 1);

        txtPathFileOrigin = new CustomTextField();
        addComponent(txtPathFileOrigin, 1, 0, 4, 1);

        txtFolderDestiny = new CustomTextField();
        addComponent(txtFolderDestiny, 1, 1, 4, 1);

        txtFileName = new CustomTextField();
        addComponent(txtFileName, 1, 2, 1, 1);

        txtExtension = new CustomTextField();
        addComponent(txtExtension, 4, 2, 1, 1);

        txtSizeWidth = new CustomTextField();
        addComponent(txtSizeWidth, 1, 4, 1, 1);

        txtSizeHeight = new CustomTextField();
        addComponent(txtSizeHeight, 4, 4, 1, 1);

        resizePixeles = new JRadioButton("Pixels",true);
        resizePixeles.setFont(new Font ("Calibri" , Font.BOLD , 14));
        addComponent(resizePixeles, 1, 3, 1, 1);

        resizePercentage = new JRadioButton("Percentage",false);
        resizePercentage.setFont(new Font ("Calibri" , Font.BOLD , 14));
        addComponent(resizePercentage, 3, 3, 1, 1);

        chekMaintainProportion = new JCheckBox("Maintain Proportion", true);
        chekMaintainProportion.setFont(new Font ("Calibri" , Font.BOLD , 14));
        addComponent(chekMaintainProportion, 4, 3, 1, 1);

        checkResizeImage = new JCheckBox("Resize", true);
        chekMaintainProportion.setFont(new Font ("Calibri" , Font.BOLD , 14));
        addComponent(checkResizeImage, 6, 4, 1, 1);

        typeOfResize = new ButtonGroup();
        typeOfResize.add(resizePixeles);
        typeOfResize.add(resizePercentage);

        btnPathOriginFile = new JButton("Search File");
        btnPathOriginFile.addActionListener(this);
        addComponent(btnPathOriginFile, 6, 0, 1, 1);

        btnPathFolderDestiny = new JButton("Destiny");
        btnPathFolderDestiny.addActionListener(this);
        addComponent(btnPathFolderDestiny, 6, 1, 1, 1);

        btnConvertFile = new JButton("Convert");
        addComponent(btnConvertFile, 1, 5, 1, 1);
    }

    /**
     * Method that adds components to the GridBagConstraints.
     */
    public void addComponent(Component Component, int sizeX, int sizeY, int sizeFieldX,int sizeFieldY) {
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
    }
}

