/**
 * @(#)ControllerSearchAdvanced.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jala.search.controller;

import com.jala.search.models.CriteriaSearch;
import com.jala.search.models.SearchFile;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControllerSearchAdvanced
 *
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerSearchAdvanced implements ActionListener{
    /*It controls the JPanelSearchAdvanced and SearchFile*/

    /** ViewAdvanced: create a pointer of JPanelSearchAdvanced, the object will provide other class.*/
    private JPanelSearchAdvanced viewAdvanced;
    /** This is temporal, it is just for calculate a size of the file.*/
    private final static double fB = 1024.0;
    /** To save the values of the UI and send to SearchFile*/
    private CriteriaSearch criteriaSearch;

    /**
     * Creates the constructor of the class, this receive a object of JPanelSearchAdvanced and initialize
     * the actionListener of that Panel.
     * @param viewAdvanced receive the object of the main frame.
     */
    public ControllerSearchAdvanced (JPanelSearchAdvanced viewAdvanced) {
        this.viewAdvanced = viewAdvanced;
        actionListener();
    }

    /**
     * Initialize the action listener of the btnSearch button.
     */
    private void actionListener () {
        viewAdvanced.getBtnSearch().addActionListener(this);
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed
     * @param e this activates when a button is  pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAdvanced.getBtnSearch()) {
            saveCriteria();
            sendCriteriaToFile();
        }
    }

    /**
     * Save path, fileName and extension in criteriaSearch.
     */
    private void saveCriteria() {
        criteriaSearch = new CriteriaSearch(viewAdvanced.getTxtPath().getText());
        criteriaSearch.setFileName(viewAdvanced.getTxtFileName().getText());
        //criteriaSearch.setExtension(viewAdvanced.getTxtExt().getText());
    }

    /**
     * Send criteriaSearch to SearchFile to search files like the filename or extension, receive a list of
     * results, and print the results in the UI table.
     */
    private void sendCriteriaToFile () {
        SearchFile searchFile = new SearchFile();
        List<File> results = searchFile.search(criteriaSearch);
        for (int i = 0; i < results.size(); i++) {
            File data = results.get(i);
            viewAdvanced.getTbSearchAdvanced().AddResultRow(Integer.toString(i),data.getAbsolutePath(),data.getName(),
                    FilenameUtils.getExtension(data.getAbsolutePath()), Double.toString(getFileSizeInKB(data.length())));
        }
    }

    /**
     * Receive the size of the files and send in Kilobytes
     * @param fileLength
     * @return Size of files in KiloBytes
     */
    private double getFileSizeInKB (double fileLength) {
        fileLength = fileLength / fB;
        int fs = (int) Math.pow(10,2);
        return Math.rint(fileLength*fs)/fs;
    }
}
