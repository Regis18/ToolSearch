/*
 * @(#) JPanelAdvanced.java Copyright (c) 2019 Jala Foundation.
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

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPanelConverterImage extends JPanel{

    private JLabel lblPathFileOrigin, lblPathFolderDestiny, lblFileName, lblExtension, lblSizeWidth, lblSizeHeight;
    private JLabel lblChangeSize, lblSeparatorSpace, lblSeparatorSpace2, lblMaintainProportion, lblOwmer;
    private JTextField txtPathFileOrigin, txtFolderDestiny, txtFileName, txtExtension, txtSizeWidth, txtSizeHeight;
    private JButton btnPathOriginFile, btnPathFolderDestiny, btnConvertFile;
    private ButtonGroup typeOfResize;
    private JRadioButton resizePercentage, resizePixeles;
    private JCheckBox chekMaintainProportion;
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
     * Class constructor.
     * @param borderLayout
     */
    public JPanelConverterImage(BorderLayout borderLayout){
        esquema= new GridBagLayout();
        constraints = new GridBagConstraints();
        setLayout(esquema);

        lblPathFileOrigin = new JLabel("Path Origin File:   ");
        addComponent(lblPathFileOrigin, 0, 0, 1, 1);

        lblPathFolderDestiny = new JLabel("Folder Destiny");
        addComponent(lblPathFolderDestiny, 0, 1, 1, 1);

        lblFileName = new JLabel("File Name");
        addComponent(lblFileName, 0, 2, 1, 1);

        lblExtension = new JLabel("Extension");
        addComponent(lblExtension, 3, 2, 1, 1);

        lblChangeSize = new JLabel("Change Size to:  ");
        addComponent(lblChangeSize, 0, 3, 1, 1);

        lblSizeWidth = new JLabel("Size Width");
        addComponent(lblSizeWidth, 0, 4, 1, 1);

        lblSizeHeight = new JLabel("Size Height");
        addComponent(lblSizeHeight, 3, 4, 1, 1);

        lblSeparatorSpace = new JLabel("   ");
        addComponent(lblSeparatorSpace, 2, 2, 1, 1);

        lblSeparatorSpace2 = new JLabel("   ");
        addComponent(lblSeparatorSpace2, 5, 0, 1, 1);

        txtPathFileOrigin = new JTextField("");
        addComponent(txtPathFileOrigin, 1, 0, 4, 1);

        txtFolderDestiny = new JTextField();
        addComponent(txtFolderDestiny, 1, 1, 4, 1);

        txtFileName = new JTextField();
        addComponent(txtFileName, 1, 2, 1, 1);

        txtExtension = new JTextField();
        addComponent(txtExtension, 4, 2, 1, 1);

        txtSizeWidth = new JTextField();
        addComponent(txtSizeWidth, 1, 4, 1, 1);

        txtSizeHeight = new JTextField();
        addComponent(txtSizeHeight, 4, 4, 1, 1);

        resizePixeles = new JRadioButton("Pixeles      ",true);
        addComponent(resizePixeles, 1, 3, 1, 1);

        resizePercentage = new JRadioButton("Percentage",false);
        addComponent(resizePercentage, 3, 3, 1, 1);

        chekMaintainProportion = new JCheckBox("Maintain Proportion", true);
        addComponent(chekMaintainProportion, 4, 3, 1, 1);

        typeOfResize = new ButtonGroup();
        typeOfResize.add(resizePixeles);
        typeOfResize.add(resizePercentage);

        btnPathOriginFile = new JButton("Search File");
        //btnPathOriginFile.addActionListener(this);
        addComponent(btnPathOriginFile, 6, 0, 1, 1);

        btnPathFolderDestiny = new JButton("Destiny");
        //btnPathFolderDestiny.addActionListener(this);
        addComponent(btnPathFolderDestiny, 6, 1, 1, 1);

        btnConvertFile = new JButton("Convert");
        addComponent(btnConvertFile, 1, 5, 1, 1);
    }

    /**
     * Method that adds components to the GridBagConstraints.
     */
    public void addComponent(Component Component, int sizeX, int sizeY, int sizeFieldX,int sizeFieldY){
        constraints.gridx = sizeX;
        constraints.gridy = sizeY;
        constraints.gridwidth = sizeFieldX;
        constraints.gridheight = sizeFieldY;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 1.0;
        this.add (Component , constraints);
    }
}

