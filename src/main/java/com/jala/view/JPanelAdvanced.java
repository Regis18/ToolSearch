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
import java.awt.*;
import java.awt.event.ActionListener;

public class JPanelAdvanced extends JPanel{

    private JLabel lblPath, lblFileName, lblExtension, lblHidden, lblReadOnly, lblTest ,lblOwner,lblSeparatorEmpty,lblSeparatorEmpty2;
    private JLabel lblDateCreateStar, lblDateCreateEnd, lblDateLastModBegin, lblDateLastModEnd, lblDateLatterAccesBegin, lblDateLatterAccesEnd;
    private JTextField txtPath, txtFileName, txtExtension, txtOwner;
    private JButton getBtnSearch, btnPathSearch;
    private JComboBox cmbHidden,comboReadOnly;
    private JDateChooser dateCreateStar, dateCreateEnd, dateLastModBegin, dateLastModEnd, dateLatterAccesBegin, dateLatterAccesEnd;
    private GridBagLayout esquema;
    private GridBagConstraints constraints;


    public String getTxtPath() {
        return txtPath.getText().toString();
    }

    public String getTxtFileName() {
        return txtFileName.getText().toString();
    }

    public String getTxtExtension() {
        return txtExtension.getText().toString();
    }

    public String getTxtOwner() {
        return txtOwner.getText().toString();
    }
/*
    public String getCmbHidden() {
        return cmbHidden;
    }

    public String getComboReadOnly() {
        return comboReadOnly;
    }

    public String getDateCreateStar() {
        return dateCreateStar;
    }

    public String getDateCreateEnd() {
        return dateCreateEnd;
    }

    public String getDateLastModBegin() {
        return dateLastModBegin;
    }

    public String getDateLastModEnd() {
        return dateLastModEnd;
    }

    public String getDateLatterAccesBegin() {
        return dateLatterAccesBegin;
    }

    public String getDateLatterAccesEnd() {
        return dateLatterAccesEnd;
    }*/

    /**
     * Class constructor.
     */
    public JPanelAdvanced(){
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

        lblDateCreateStar = new JLabel("Date Creation: ");
        addComponent(lblDateCreateStar, 0, 3, 1, 1);

        lblDateCreateEnd = new JLabel("Date end: ");
        addComponent(lblDateCreateEnd, 3, 3, 1, 1);

        lblDateLastModBegin = new JLabel("Last Modification Begin:  ");
        addComponent(lblDateLastModBegin, 0, 4, 1, 1);

        lblDateLastModEnd = new JLabel("Last Modification End:  ");
        addComponent(lblDateLastModEnd, 3, 4, 1, 1);

        lblDateLatterAccesBegin = new JLabel("Date Latter Begin:  ");
        addComponent(lblDateLatterAccesBegin, 0, 5, 1, 1);

        lblDateLatterAccesEnd = new JLabel("Date Latter End: ");
        addComponent(lblDateLatterAccesEnd, 3, 5, 1, 1);

        lblOwner = new JLabel("Owner: ");
        addComponent(lblOwner, 0, 6, 1, 1);

        txtPath = new JTextField("");
        addComponent(txtPath, 1, 0, 3, 1);

        txtFileName = new JTextField("");
        txtFileName.setSize(200, 20);
        addComponent(txtFileName, 1, 1, 1, 1);

        txtExtension = new JTextField("");
        addComponent(txtExtension, 5, 1, 1, 1);

        txtOwner = new JTextField();
        addComponent(txtOwner, 1, 6, 1, 1);

        cmbHidden = new JComboBox();
        cmbHidden.addItem(" Hidden ");
        cmbHidden.addItem(" Not Hidden   ");
        cmbHidden.addItem(" All ");
        addComponent(cmbHidden, 1, 2, 1, 1);

        comboReadOnly = new JComboBox();
        comboReadOnly.addItem(" Not Read Only");
        comboReadOnly.addItem(" Read Only ");
        comboReadOnly.addItem(" All ");
        addComponent(comboReadOnly, 5, 2, 1, 1);

        getBtnSearch = new JButton("Search");
        addComponent(getBtnSearch, 6, 0, 1, 1);

        btnPathSearch = new JButton("Folder Address");
        //btnPathSearch.addActionListener(this);
        addComponent(btnPathSearch, 5, 0, 1, 1);

        dateCreateStar = new JDateChooser();
        addComponent(dateCreateStar, 1, 3, 1, 1);

        dateCreateEnd = new JDateChooser();
        addComponent(dateCreateEnd, 5, 3, 1, 1);

        dateLastModBegin = new JDateChooser();
        addComponent(dateLastModBegin, 1, 4, 1, 1);

        dateLastModEnd = new JDateChooser();
        addComponent(dateLastModEnd, 5, 4, 1, 1);

        dateLatterAccesBegin = new JDateChooser();
        addComponent(dateLatterAccesBegin, 1, 5, 1, 1);

        dateLatterAccesEnd = new JDateChooser();
        addComponent(dateLatterAccesEnd, 5, 5, 1, 1);
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
    /*
    public void actionPerformed(ActionEvent e){
        if( e.getSource().equals(btnPathSearch) ){
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                txtPath.setText("" + chooser.getSelectedFile());
            } else {
                System.out.println("");
            }
        }
    }*/

}

