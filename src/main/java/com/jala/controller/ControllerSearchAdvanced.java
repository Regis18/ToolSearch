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
package com.jala.controller;

import com.jala.model.search.SearchFile;
import com.jala.model.search.asset.Asset;
import com.jala.model.criteria.CriteriaSearch;
import com.jala.model.search.TernaryBooleanEnum;
import com.jala.utils.Logs;
import com.jala.view.JPanelAdvanced;
import com.jala.view.JPanelSearchAdvanced;
import org.apache.log4j.Logger;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControllerSearchAdvanced
 * It controls the JPanelSearchAdvanced and SearchFile
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerSearchAdvanced implements ActionListener {

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    /** ViewAdvanced: create a pointer of JPanelSearchAdvanced, the object will provide other class.*/
    private JPanelSearchAdvanced viewAdvanced;

    /** This is temporal, it is just for calculate a size of the file.*/
    private final static double BYTES = 1024.0;

    /** To save the values of the UI and send to SearchFile*/
    private CriteriaSearch criteriaSearch;

    /**
     * Creates the constructor of the class, this receive a object of JPanelSearchAdvanced and initialize
     * the actionListener of that Panel.
     * @param viewAdvanced receive the object of the main frame.
     */
    public ControllerSearchAdvanced(JPanelSearchAdvanced viewAdvanced) {
        log.info("Initialize the Control of Search Advanced");
        this.viewAdvanced = viewAdvanced;
        actionListener();
    }

    /**
     * Constructor without parameters.
     */
    public ControllerSearchAdvanced() {}

    /**
     * Initialize the action listener of the btnSearch button.
     */
    private void actionListener() {
        log.info("Initialize the adding of listener for the buttons in Search Advanced ");
        viewAdvanced.getJPanelAdvanced().getBtnSearch().addActionListener(this);
        log.info("Finish the actionListener");
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed
     * @param event this activates when a button is  pressed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        log.info("Action Detected");
        if (event.getSource() == viewAdvanced.getJPanelAdvanced().getBtnSearch()) {
            log.info("BtnSearch from Search Advanced was pressed");
            if (viewAdvanced.getJPanelAdvanced().getTxtPath().equals("")) {
                viewAdvanced.setMsgError("Path value is required!");
            } else {
                saveCriteria(viewAdvanced.getJPanelAdvanced());
                sendCriteriaToFile();
            }
        }
    }

    /**
     * The getCriteria method get CriteriaSearch of this class.
     * @param viewPanelAdvanced has the data in CriteriaSearch.
     * @return a CriteriaSearch class
     */
    public CriteriaSearch getCriteria(JPanelAdvanced viewPanelAdvanced) {
        saveCriteria(viewPanelAdvanced);
        return criteriaSearch;
    }

    /**
     * The saveCriteria method save data in a CriteriaSearch Class.
     * Save path, fileName and extension in criteriaSearch.
     * @param panelAdvanced has data for create a CriteriaSearch class.
     */
    private void saveCriteria(JPanelAdvanced panelAdvanced) {

        log.info("Saving data of Path, File Name and Extension in Criteria");
        criteriaSearch = new CriteriaSearch(panelAdvanced.getTxtPath());
        criteriaSearch.setFileName(panelAdvanced.getTxtFileName());
        criteriaSearch.setExtension(panelAdvanced.getTxtExtension());
        criteriaSearch.setOwner(panelAdvanced.getTxtOwner());
        criteriaSearch.setHidden(getEnumHidden(panelAdvanced));
        criteriaSearch.setReadOnly(getEnumReadOnly(panelAdvanced));
        criteriaSearch.setCreationDateFrom(panelAdvanced.getDateCreateStar());
        if (!panelAdvanced.getDateCreateEnd().equals("")) {
            criteriaSearch.setCreationDateTo(panelAdvanced.getDateCreateEnd());
        }
        criteriaSearch.setModificationDateFrom(panelAdvanced.getDateLastModBegin());
        if (!panelAdvanced.getDateLastModEnd().equals("")) {
            criteriaSearch.setModificationDateTo(panelAdvanced.getDateLastModEnd());
        }
        criteriaSearch.setLastDateFrom(panelAdvanced.getDateLatterAccesBegin());
        if (!panelAdvanced.getDateLatterAccesEnd().equals("")) {
            criteriaSearch.setLastDateTo(panelAdvanced.getDateLatterAccesEnd());
        }
        criteriaSearch.setSize(convertSize(panelAdvanced));
        criteriaSearch.setSizeCompareOption(!panelAdvanced.isMajorThanFile());
        log.info("Information saved");
    }
    /**
     * Save path, fileName and extension in criteriaSearch.
     */
    protected void saveCriteria() {
        log.info("Saving data of Path, File Name and Extension in Criteria");
        criteriaSearch = new CriteriaSearch(viewAdvanced.getJPanelAdvanced().getTxtPath());
        criteriaSearch.setFileName(viewAdvanced.getJPanelAdvanced().getTxtFileName());
        criteriaSearch.setExtension(viewAdvanced.getJPanelAdvanced().getTxtExtension());
        criteriaSearch.setOwner(viewAdvanced.getJPanelAdvanced().getTxtOwner());
        criteriaSearch.setHidden(getEnumHidden(viewAdvanced.getJPanelAdvanced()));
        criteriaSearch.setReadOnly(getEnumReadOnly(viewAdvanced.getJPanelAdvanced()));
        criteriaSearch.setCreationDateFrom(viewAdvanced.getJPanelAdvanced().getDateCreateStar());
        if (!viewAdvanced.getJPanelAdvanced().getDateCreateEnd().equals("")) {
            criteriaSearch.setCreationDateTo(viewAdvanced.getJPanelAdvanced().getDateCreateEnd());
        }
        criteriaSearch.setModificationDateFrom(viewAdvanced.getJPanelAdvanced().getDateLastModBegin());
        if (!viewAdvanced.getJPanelAdvanced().getDateLastModEnd().equals("")) {
            criteriaSearch.setModificationDateTo(viewAdvanced.getJPanelAdvanced().getDateLastModEnd());
        }
        criteriaSearch.setLastDateFrom(viewAdvanced.getJPanelAdvanced().getDateLatterAccesBegin());
        if (!viewAdvanced.getJPanelAdvanced().getDateLatterAccesEnd().equals("")) {
            criteriaSearch.setLastDateTo(viewAdvanced.getJPanelAdvanced().getDateLatterAccesEnd());
        }
        criteriaSearch.setSize(convertSize(viewAdvanced.getJPanelAdvanced()));
        criteriaSearch.setSizeCompareOption(!viewAdvanced.getJPanelAdvanced().isMajorThanFile());
        log.info("Information saved");
    }

    /**
     * Send criteriaSearch to SearchFile to search files like the filename or extension, receive a list of
     * results, and print the results in the UI table.
     */
    private void sendCriteriaToFile() {
        log.info("Preparing to send criteria to SearchFile");
        SearchFile searchFile = new SearchFile();
        List<Asset> results = searchFile.search(criteriaSearch);
        log.info("Information sending and waiting answers");
        viewAdvanced.getTbSearchAdvanced().removeRow();
        for (int i = 0; i < results.size(); i++) {
            Asset data = results.get(i);
            String hidden = String.valueOf(data.isHidden());
            String readOnly = String.valueOf(data.isReadOnly());
            viewAdvanced.getTbSearchAdvanced().addResultRow(Integer.toString(i + 1), data.getPath(), data.getFileName(),
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
    public String getFileSizeInKb(String fileLength) {
        Double file = Double.parseDouble(fileLength);
        log.info("Returns the size of the file");
        file = file / BYTES;
        int fs = (int) Math.pow(10,2);
        return Double.toString(Math.rint(file * fs)/fs);
    }

    /**
     * Method that returns a TernaryBooleanEnum value.
     * @param panelAdvanced has data for get TernaryBooleanEnum.
     * @return TernaryBooleanEnum.
     */
    private TernaryBooleanEnum getEnumHidden(JPanelAdvanced panelAdvanced) {
        if (panelAdvanced.getCmbHidden().equals("Not Hidden")) {
            return TernaryBooleanEnum.OnlyFalse;
        } else if (panelAdvanced.getCmbHidden().equals("Hidden")) {
            return TernaryBooleanEnum.OnlyTrue;
        } else  {
            return TernaryBooleanEnum.ALL;
        }
    }

    /**
     * Method that returns a TernaryBooleanEnum value.
     * @param panelAdvanced has data for get TernaryBooleanEnum.
     * @return TernaryBooleanEnum.
     */
    private TernaryBooleanEnum getEnumReadOnly(JPanelAdvanced panelAdvanced) {
        if (panelAdvanced.getComboReadOnly().equals("Not Read Only")) {
            return TernaryBooleanEnum.OnlyFalse;
        } else if (panelAdvanced.getComboReadOnly().equals("Read Only")) {
            return TernaryBooleanEnum.OnlyTrue;
        } else {
            return TernaryBooleanEnum.ALL;
        }
    }

    /**
     * method that performs the conversion to Kb, Mb and Gb
     */

    private String convertSize(JPanelAdvanced panelAdvanced) {
        double value;
        if (panelAdvanced.getComboTypeSizeFile().equals("Kb")) {
            value = Double.parseDouble(panelAdvanced.getSpinControlSizeFile());
            value = value * 1024;
        } else if (panelAdvanced.getComboTypeSizeFile().equals("Mb")) {
            value = Double.parseDouble(panelAdvanced.getSpinControlSizeFile());
            value = value * 1024 * 1024;
        } else {
            value = Double.parseDouble(panelAdvanced.getSpinControlSizeFile());
            value = value * 1024 * 1024 * 1024;
        }
        return Double.toString(value);
    }

    /**
     * Get the criteriaSearch of the Criteria advanced.
     * @return
     */
    public CriteriaSearch getCriteriaSearch() {
        return criteriaSearch;
    }
}
