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

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

/**
 * Module view, ui/JPanelAdvanced.
 * @version 0.0.1.
 * @autor Luis Guardia.
 */
public class JPanelAdvanced extends JPanel implements ActionListener{

    private JLabel lblPath, lblFileName, lblExtension, lblHidden, lblReadOnly, lblTest , lblOwner, lblSeparatorEmpty, lblSeparatorEmpty2, lblSizeFile;
    private JLabel lblDateCreateStar, lblDateCreateEnd, lblDateLastModBegin, lblDateLastModEnd, lblDateLatterAccesBegin, lblDateLatterAccesEnd;
    private JTextField txtPath, txtFileName, txtExtension, txtOwner;
    private JButton btnSearchAdvanced, btnPathSearch;
    private JComboBox cmbHidden, comboReadOnly, comboTypeSizeFile;
    private JDateChooser dateCreateStar, dateCreateEnd, dateLastModBegin, dateLastModEnd, dateLatterAccesBegin, dateLatterAccesEnd;
    private GridBagLayout esquema;
    private GridBagConstraints constraints;
    private JSpinner spinControlSizeFile;
    private JCheckBox fileMajors;

    /**
     * The getLblExtension method get the data lblExtension
     * @return the JLabel component
     */
    public JLabel getLblExtension() {
        return lblExtension;
    }

    /**
     * The getTxtFieldExtension method get the data txtExtension
     * @return a component JTextField type
     */
    public JTextField getTxtFieldExtension() {
        return txtExtension;
    }

    /**
     * Gets the content from txtPath.
     * @return txtPath, the content of the txtPath text field.
     */
    public String getTxtPath() {
        return txtPath.getText().toString();
    }

    /**
     * Gets the content from txtFileName.
     * @return txtFileName, the content of the txtFileName text field.
     */
    public String getTxtFileName() {
        return txtFileName.getText().toString();
    }

    /**
     * Gets the content from txtExtension.
     * @return txtExtension, the content of the txtExtension text field.
     */
    public String getTxtExtension() {
        return txtExtension.getText().toString();
    }

    /**
     * Gets the content from txtOwner.
     * @return txtOwner, the content of the txtOwner text field.
     */
    public String getTxtOwner() {
        return txtOwner.getText().toString();
    }

    /**
     * Gets the content from cmbHidden.
     * @return cmbHidden, the content of the cmbHidden comboBox.
     */
    public String getCmbHidden() {
        return cmbHidden.getSelectedItem().toString();
    }

    /**
     * Gets the content from comboReadOnly.
     * @return comboReadOnly, the content of the comboReadOnly comboBox.
     */
    public String getComboReadOnly() {
        return comboReadOnly.getSelectedItem().toString();
    }

    /**
     * Gets the content from dateCreateStar.
     * @return dateCreateStar, the content of the dateCreateStar Date.
     */
    public String getDateCreateStar() {
        if(dateCreateStar.getDate() == null) {
            return "";
        } else {
            return dateCreateStar.getCalendar().get(Calendar.YEAR) + "-" + (dateCreateStar.getCalendar().get(Calendar.MONTH) + 1) + "-" + dateCreateStar.getCalendar().get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * Gets the content from dateCreateEnd.
     * @return dateCreateEnd, the content of the dateCreateEnd Date.
     */
    public String getDateCreateEnd() {
        if(dateCreateEnd.getDate() == null) {
            return "";
        } else {
            return dateCreateEnd.getCalendar().get(Calendar.YEAR) + "-" + (dateCreateEnd.getCalendar().get(Calendar.MONTH) + 1) + "-" + dateCreateEnd.getCalendar().get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * Gets the content from comboTypeSizeFile.
     * @return comboTypeSizeFile, the content of the comboTypeSizeFile comboBox.
     */
    public String getComboTypeSizeFile() {
        return comboTypeSizeFile.getSelectedItem().toString();
    }

    /**
     * Gets the content from SpinControlSizeFile.
     * @return SpinControlSizeFile, the content of the SpinControlSizeFile JSpinner.
     */
    public String getSpinControlSizeFile() {
        return spinControlSizeFile.getValue().toString();
    }

    /**
     * Gets the status from FileMajors.
     * @return boolean value, true if checkBox is active and false if not activated.
     */
    public boolean isMajorThanFile() {
        if( fileMajors.isSelected()){ return true; }
        else{ return false; }
    }

    /**
     * Gets the content from dateLastModBegin.
     * @return dateLastModBegin, the content of the dateLastModBegin Date.
     */
    public String getDateLastModBegin() {
        if(dateLastModBegin.getDate() == null) {
            return "";
        } else {
            return dateLastModBegin.getCalendar().get(Calendar.YEAR) + "-" + (dateLastModBegin.getCalendar().get(Calendar.MONTH) + 1) + "-" + dateLastModBegin.getCalendar().get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * Gets the content from dateLastModEnd.
     * @return dateLastModEnd, the content of the dateLastModEnd Date.
     */
    public String getDateLastModEnd() {
        if(dateLastModEnd.getDate() == null) {
            return "";
        } else {
            return dateLastModEnd.getCalendar().get(Calendar.YEAR) + "-" + (dateLastModEnd.getCalendar().get(Calendar.MONTH) + 1) + "-" + dateLastModEnd.getCalendar().get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * Gets the content from dateLatterAccesBegin.
     * @return dateLatterAccesBegin, the content of the dateLatterAccesBegin Date.
     */
    public String getDateLatterAccesBegin() {
        if(dateLatterAccesBegin.getDate() == null) {
            return "";
        } else {
            return dateLatterAccesBegin.getCalendar().get(Calendar.YEAR) + "-" + (dateLatterAccesBegin.getCalendar().get(Calendar.MONTH) + 1) + "-" + dateLatterAccesBegin.getCalendar().get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * Gets the content from dateLatterAccesEnd.
     * @return dateLatterAccesEnd, the content of the dateLatterAccesEnd Date.
     */
    public String getDateLatterAccesEnd() {
        if(dateLatterAccesEnd.getDate() == null) {
            return "";
        } else {
            return dateLatterAccesEnd.getCalendar().get(Calendar.YEAR) + "-" + (dateLatterAccesEnd.getCalendar().get(Calendar.MONTH) + 1) + "-" + dateLatterAccesEnd.getCalendar().get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * Gets the btnSearchAdvanced button.
     * @return btnSearchAdvanced button.
     */
    public JButton getBtnSearch() {
        return btnSearchAdvanced;
    }

    /**
     * Class constructor.
     * @param borderLayout
     */
    public JPanelAdvanced(BorderLayout borderLayout) {
        esquema= new GridBagLayout();
        constraints = new GridBagConstraints();
        setLayout(esquema);

        lblPath = new JLabel("Path: ");
        addComponent(lblPath, 0, 0, 1, 1);

        lblFileName = new JLabel("File Name: ");
        addComponent(lblFileName, 0, 1, 1, 1);

        lblSeparatorEmpty = new JLabel("   ");
        addComponent(lblSeparatorEmpty, 4, 0, 1, 1);

        lblSeparatorEmpty2 = new JLabel("   ");
        addComponent(lblSeparatorEmpty2, 2, 1, 1, 1);

        lblExtension = new JLabel("Extension: ");
        addComponent(lblExtension, 3, 1, 1, 1);

        lblHidden = new JLabel("Hidden: ");
        addComponent(lblHidden, 0, 2, 1, 1);


        lblReadOnly = new JLabel("ReadOnly: ");
        addComponent(lblReadOnly, 3, 2, 1, 1);

        lblDateCreateStar = new JLabel("Creation Date From: ");
        addComponent(lblDateCreateStar, 0, 3, 1, 1);

        lblDateCreateEnd = new JLabel("To: ");
        addComponent(lblDateCreateEnd, 3, 3, 1, 1);

        lblDateLastModBegin = new JLabel("Modification Date From:  ");
        addComponent(lblDateLastModBegin, 0, 4, 1, 1);

        lblDateLastModEnd = new JLabel("To: ");
        addComponent(lblDateLastModEnd, 3, 4, 1, 1);

        lblDateLatterAccesBegin = new JLabel("Last Date From: ");
        addComponent(lblDateLatterAccesBegin, 0, 5, 1, 1);

        lblDateLatterAccesEnd = new JLabel("To: ");
        addComponent(lblDateLatterAccesEnd, 3, 5, 1, 1);

        lblOwner = new JLabel("Owner: ");
        addComponent(lblOwner, 0, 7, 1, 1);

        lblSizeFile = new JLabel("Size File: ");
        addComponent(lblSizeFile, 0, 6, 1, 1);

        txtPath = new JTextField("");
        addComponent(txtPath, 1, 0, 5, 1);

        txtFileName = new JTextField("");
        txtFileName.setSize(200, 20);
        addComponent(txtFileName, 1, 1, 1, 1);

        txtExtension = new JTextField("");
        addComponent(txtExtension, 5, 1, 1, 1);

        txtOwner = new JTextField();
        addComponent(txtOwner, 1, 7, 3, 1);

        cmbHidden = new JComboBox();
        cmbHidden.addItem("Not Hidden");
        cmbHidden.addItem("Hidden");
        cmbHidden.addItem("All");
        addComponent(cmbHidden, 1, 2, 1, 1);

        comboReadOnly = new JComboBox();
        comboReadOnly.addItem("Not Read Only");
        comboReadOnly.addItem("Read Only");
        comboReadOnly.addItem("All");
        addComponent(comboReadOnly, 5, 2, 1, 1);

        comboTypeSizeFile = new JComboBox();
        comboTypeSizeFile.addItem("Kb");
        comboTypeSizeFile.addItem("Mb");
        comboTypeSizeFile.addItem("Gb");
        addComponent(comboTypeSizeFile, 3, 6, 1, 1);

        btnSearchAdvanced = new JButton("Search");
        addComponent(btnSearchAdvanced, 5, 7, 1, 1);

        btnPathSearch = new JButton(" .... ");
        btnPathSearch.addActionListener(this);
        addComponent(btnPathSearch, 6, 0, 1, 1);

        dateCreateStar = new JDateChooser();
        dateCreateStar.setDateFormatString("yyyy-MM-dd");
        addComponent(dateCreateStar, 1, 3, 1, 1);

        dateCreateEnd = new JDateChooser();
        dateCreateEnd.setDateFormatString("yyyy-MM-dd");
        addComponent(dateCreateEnd, 5, 3, 1, 1);

        dateLastModBegin = new JDateChooser();
        dateLastModBegin.setDateFormatString("yyyy-MM-dd");
        addComponent(dateLastModBegin, 1, 4, 1, 1);

        dateLastModEnd = new JDateChooser();
        dateLastModEnd.setDateFormatString("yyyy-MM-dd");
        addComponent(dateLastModEnd, 5, 4, 1, 1);

        dateLatterAccesBegin = new JDateChooser();
        dateLatterAccesBegin.setDateFormatString("yyyy-MM-dd");
        addComponent(dateLatterAccesBegin, 1, 5, 1, 1);

        dateLatterAccesEnd = new JDateChooser();
        dateLatterAccesEnd.setDateFormatString("yyyy-MM-dd");
        addComponent(dateLatterAccesEnd, 5, 5, 1, 1);

        spinControlSizeFile = new JSpinner(new SpinnerNumberModel( 0 , 0 , 100000 , 1));
        addComponent(spinControlSizeFile, 1, 6, 1, 1);

        fileMajors = new JCheckBox("Major", true);
        addComponent(fileMajors, 5, 6, 1, 1);
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
        this.add (Component , constraints);
    }

    /**
     * method that adds action to a button
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnPathSearch)) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                txtPath.setText("" + chooser.getSelectedFile());
            }
        }
    }
}
