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
package com.jala.controller;

import com.jala.model.search.SearchFile;
import com.jala.model.search.asset.Asset;
import com.jala.model.criteria.CriteriaSearch;
import com.jala.utils.Logs;
import com.jala.view.JPanelSearchGral;
import org.apache.log4j.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * ControllerSearch
 * It controls the JPanelSearchGral and SearchFile
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerSearch implements ActionListener {

     /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    /** ViewSearch: create a pointer of JPanelSearchGral the object will provide other class.*/
    private JPanelSearchGral viewSearch;

    /** This is temporal, it is just for calculate a size of the file.*/
    private final static double BYTES = 1024.0;

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
    private void actionsListener() {
        log.info("Initialize the adding of listener for the buttons in Search General");
        viewSearch.getBtnSearch().addActionListener(this);
        log.info("Finish the actionListener");
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed
     * @param event this activates when a button is  pressed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        log.info("Action Detected");
        if (event.getSource() == viewSearch.getBtnSearch()) {
            log.info("BtnSearch from Search General was pressed");
            if (viewSearch.getTxtPath().getText().equals("")) {
                viewSearch.setMsgError("Path value is required!");
            } else {
                sendPathToSearch(viewSearch.getTxtPath().getText());
            }
        }
    }

    /**
     * Send path to SearchFile, receive a list of results, and print the results in the UI table.
     * @param path, that is save in the CriteriaSearch object and send to SearchFile
     */
    private void sendPathToSearch(String path) {
        log.info("Preparing to send criteria to SearchFile");
        SearchFile search = new SearchFile();
        CriteriaSearch criteria = new CriteriaSearch(path);
        List<Asset> results = search.search(criteria);
        log.info("Information sending and waiting answers");
        viewSearch.getTbSearchGral().removeRow();
        for (int i = 0; i < results.size(); i++) {
            Asset data = results.get(i);
            String hidden = String.valueOf(data.isHidden());
            String readOnly = String.valueOf(data.isReadOnly());
            viewSearch.getTbSearchGral().addResultRow(Integer.toString(i + 1), data.getPath(), data.getFileName(),
                    data.getExtension(), getFileSizeInKb(data.getSize()), hidden, readOnly, data.getCreationDate(),
                    data.getModificationDate(), data.getLastDate());
        }
        log.info("Results implemented in the JTable of the UI");
    }

    /**
     * Receive the size of the files and send in Kilobytes
     * @param fileLength
     * @return TernaryBooleanEnum.
     */
    private String getFileSizeInKb(String fileLength) {
        Double file = Double.parseDouble(fileLength);
        log.info("Returns the size of the file");
        file = file / BYTES;
        int fs = (int) Math.pow(10,2);
        return Double.toString(Math.rint(file * fs)/fs);
    }
}
