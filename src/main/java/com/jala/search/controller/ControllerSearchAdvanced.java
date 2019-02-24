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
import com.jala.utils.Logs;
import com.jala.view.JPanelSearchAdvanced;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
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

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();
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
        log.info("Initialize the Control of Search Advanced");
        this.viewAdvanced = viewAdvanced;
        actionListener();
    }

    /**
     * Initialize the action listener of the btnSearch button.
     */
    private void actionListener () {
        log.info("Initialize the adding of listener for the buttons in Search Advanced ");
        viewAdvanced.getBtnSearch().addActionListener(this);
        log.info("Finish the actionListener");
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed
     * @param e this activates when a button is  pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("Action Detected");
        if (e.getSource() == viewAdvanced.getBtnSearch()) {
            log.info("BtnSearch from Search Advanced was pressed");
            saveCriteria();
            sendCriteriaToFile();
        }
    }

    /**
     * Save path, fileName and extension in criteriaSearch.
     */
    private void saveCriteria() {
        log.info("Saving data of Path, File Name and Extension in Criteria");
        criteriaSearch = new CriteriaSearch(viewAdvanced.getTxtPath().getText());
        criteriaSearch.setFileName(viewAdvanced.getTxtFileName().getText());
        criteriaSearch.setExtension(viewAdvanced.getTxtExt().getText());
        log.info("Information saved");
    }

    /**
     * Send criteriaSearch to SearchFile to search files like the filename or extension, receive a list of
     * results, and print the results in the UI table.
     */
    private void sendCriteriaToFile () {
        log.info("Preparing to send criteria to SearchFile");
        SearchFile searchFile = new SearchFile();
        List<File> results = searchFile.search(criteriaSearch);
        log.info("Information sending and waiting answers");
        for (int i = 0; i < results.size(); i++) {
            File data = results.get(i);
            viewAdvanced.getTbSearchAdvanced().AddResultRow(Integer.toString(i),data.getAbsolutePath(),data.getName(),
                    FilenameUtils.getExtension(data.getAbsolutePath()), Double.toString(getFileSizeInKB(data.length())));
        }
        log.info("Results implemented in the JTable of the UI");
    }

    /**
     * Receive the size of the files and send in Kilobytes
     * @param fileLength
     * @return Size of files in KiloBytes
     */
    private double getFileSizeInKB (double fileLength) {
        log.info("Returns the size of the file");
        fileLength = fileLength / fB;
        int fs = (int) Math.pow(10,2);
        return Math.rint(fileLength*fs)/fs;
    }
}
