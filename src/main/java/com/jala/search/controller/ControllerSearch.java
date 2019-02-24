/**
 * @(#)ControllerSearch.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jala.search.controller;

import com.jala.search.models.CriteriaSearch;
import com.jala.search.models.SearchFile;
import com.jala.utils.Logs;
import com.jala.view.JPanelSearchGral;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

/**
 * ControllerSearch
 *
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerSearch implements ActionListener {
    /*It controls the JPanelSearchGral and SearchFile*/

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();
    /** ViewSearch: create a pointer of JPanelSearchGral the object will provide other class.*/
    private JPanelSearchGral viewSearch;
    /** This is temporal, it is just for calculate a size of the file.*/
    private final static double fB = 1024.0;

    /**
     * Create a constructor of this class and initialize the actions listener of the buttons
     * and receives the object of the actual frame
     * @param viewSearch
     */
    public ControllerSearch(JPanelSearchGral viewSearch) {
        log.info("Initialize the Control of Search General");
        this.viewSearch = viewSearch;
        actionsListener();
    }

    /**
     * Initialize the action listener of the btnSearch button.
     */
    private void actionsListener(){
        log.info("Initialize the adding of listener for the buttons in Search General");
        viewSearch.getBtnSearch().addActionListener(this);
        log.info("Finish the actionListener");
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed
     * @param e this activates when a button is  pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("Action Detected");
        if (e.getSource() == viewSearch.getBtnSearch()) {
            log.info("BtnSearch from Search General was pressed");
            sendPathToSearch(viewSearch.getTxtPath().getText());
        }
    }

    /**
     * Send path to SearchFile, receive a list of results, and print the results in the UI table.
     * @param Path, that is save in the CriteriaSearch object and send to SearchFile
     */
    private void sendPathToSearch(String Path){
        log.info("Preparing to send criteria to SearchFile");
        SearchFile search = new SearchFile();
        CriteriaSearch criteria = new CriteriaSearch(Path);
        List<File> results = search.search(criteria);
        log.info("Information sending and waiting answers");
        for (int i = 0; i < results.size(); i++) {
            File data = results.get(i);
            viewSearch.getTbSearchGral().AddResultRow(Integer.toString(i),data.getAbsolutePath(),data.getName(),
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

