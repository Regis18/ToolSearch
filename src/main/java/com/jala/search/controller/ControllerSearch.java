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
import org.apache.commons.io.FilenameUtils;
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
        this.viewSearch = viewSearch;
        actionsListener();
    }

    /**
     * Initialize the action listener of the btnSearch button.
     */
    private void actionsListener(){
        viewSearch.getBtnSearch().addActionListener(this);
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed
     * @param e this activates when a button is  pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewSearch.getBtnSearch()) {
            sendPathToSearch(viewSearch.getTxtPath().getText());
        }
    }

    /**
     * Send path to SearchFile, receive a list of results, and print the results in the UI table.
     * @param Path, that is save in the CriteriaSearch object and send to SearchFile
     */
    private void sendPathToSearch(String Path){
        SearchFile search = new SearchFile();
        CriteriaSearch criteria = new CriteriaSearch(Path);
        List<File> results = search.search(criteria);
        for (int i = 0; i < results.size(); i++) {
            File data = results.get(i);
            viewSearch.getTbSearchGral().AddResultRow(Integer.toString(i),data.getAbsolutePath(),data.getName(),
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

