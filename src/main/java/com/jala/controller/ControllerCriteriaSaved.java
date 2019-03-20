/*
 * @(#) ControllerCriteriaSaved.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.controller;

import com.jala.model.connection.CriteriaDataBase;
import com.jala.model.criteria.CriteriaName;
import com.jala.model.criteria.CriteriaSearch;
import com.jala.utils.Logs;
import com.jala.view.JPanelSearchAdvanced;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerCriteriaSaved implements ActionListener {

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    private CriteriaSearch criteriaSearch;

    /** ViewAdvanced: create a pointer of JPanelSearchAdvanced, the object will provide other class.*/
    private JPanelSearchAdvanced viewAdvanced;
    private CriteriaDataBase criteriaDataBase = new CriteriaDataBase();

    public ControllerCriteriaSaved(JPanelSearchAdvanced viewAdvanced) {
        log.info("Initialize the Control of Search Advanced");
        this.viewAdvanced = viewAdvanced;
        actionListener();
    }

    /**
     * Initialize the action listener of the delete and select buttons
     */
    private void actionListener() {
        log.info("Initialize the adding of listener for the buttons in Search Advanced ");
        //TODO put the buttons of Delete and Select.
        log.info("Finish the actionListener");
    }

    private void sendCriteriaToDB(CriteriaSearch criteriaSearch) {
        criteriaDataBase.saveCriteria(criteriaSearch);
    }
    private void deleteCriteria(int id) {
        List<CriteriaName> criteria = criteriaDataBase.deleteCriteria(id);
        //TODO set to tableDB
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //TODO button
    }
    private void selectCriteria() {
        //TODO recover ID from table
        int id = 0;
        criteriaSearch = criteriaDataBase.getCriteria(id);
        setCriteria();
    }

    private void setCriteria() {
        //TODO set the parameters.
    }
}
