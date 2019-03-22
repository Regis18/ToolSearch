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
import com.jala.model.search.TernaryBooleanEnum;
import com.jala.utils.Logs;
import com.jala.view.CustomLabel;
import com.jala.view.JPanelSearchAdvanced;
import org.apache.log4j.Logger;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * ControllerCriteriaSaved
 *
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerCriteriaSaved implements ActionListener {

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    /** Criteria search to charge. */
    private CriteriaSearch criteriaSearch;

    /** ViewAdvanced: create a pointer of JPanelSearchAdvanced, the object will provide other class.*/
    private JPanelSearchAdvanced viewAdvanced;

    /** Initialize criteriaDataBase */
    private CriteriaDataBase criteriaDataBase = new CriteriaDataBase();

    /** Initialize controllerSearchAdvanced. */
    private ControllerSearchAdvanced controllerSearchAdvanced;

    /**
     * ControllerCriteriaSaved and activates actionListener.
     * @param viewAdvanced
     */
    public ControllerCriteriaSaved(JPanelSearchAdvanced viewAdvanced, ControllerSearchAdvanced controllerSearchAdvanced) {
        log.info("Initialize the Control of Search Advanced");
        this.controllerSearchAdvanced = controllerSearchAdvanced;
        this.viewAdvanced = viewAdvanced;
        actionListener();
    }

    /**
     * Initialize the action listener of the delete and select buttons
     */
    private void actionListener() {
        log.info("Initialize the adding of listener for the buttons in Search Advanced ");
        viewAdvanced.getBtnCharge().addActionListener(this);
        viewAdvanced.getBtnDelete().addActionListener(this);
        viewAdvanced.getJPanelAdvanced().getBtnSave().addActionListener(this);
        log.info("Finish the actionListener");
    }

    /**
     * This method take the criteria search and send to Database.
     */
    private void sendCriteriaToDB(String name) {
        controllerSearchAdvanced.saveCriteria();
        criteriaSearch = controllerSearchAdvanced.getCriteriaSearch();
        criteriaSearch.setNameCriteria(name);
        criteriaDataBase.saveCriteria(criteriaSearch);
        setDBIntoTable();
    }

    /**
     * Delete the criteria of DB.
     */
    private void deleteCriteria() {
        int row = viewAdvanced.getTbDataBase().getSelectedRow();
        if (row != -1) {
            int id = Integer.parseInt(viewAdvanced.getTbDataBase().getValueAt(row, 1).toString());
            criteriaDataBase.deleteCriteria(id);
            setDBIntoTable();
        }

    }

    /**
     * Listen every change in the buttons.
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == viewAdvanced.getJPanelAdvanced().getBtnSave()) {
            JTextField criteriaName = new JTextField();
            final JComponent[] inputs = new JComponent[] {
                    new CustomLabel("Criteria Name: "),
                    criteriaName
            };
            int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                sendCriteriaToDB(criteriaName.getText());
            }

        } else if (event.getSource() == viewAdvanced.getBtnCharge()) {
            selectCriteria();
        } else if (event.getSource() == viewAdvanced.getBtnDelete()) {
            deleteCriteria();
        }
    }

    /**
     * Select a date in the table and recover to de DB.
     */
    private void selectCriteria() {
        int row = viewAdvanced.getTbDataBase().getSelectedRow();
        if (row != -1) {
            int id = Integer.parseInt(viewAdvanced.getTbDataBase().getValueAt(row, 1).toString());
            criteriaSearch = criteriaDataBase.getCriteria(id);
            setCriteria();
        }
    }

    /**
     * Set the criteria into the UI.
     */
    private void setCriteria() {
        viewAdvanced.getJPanelAdvanced().setTxtPath(criteriaSearch.getPath());
        viewAdvanced.getJPanelAdvanced().setTxtFileName(criteriaSearch.getFileName());
        viewAdvanced.getJPanelAdvanced().setDateCreateStar(criteriaSearch.getCreationDateFrom());
        viewAdvanced.getJPanelAdvanced().setDateCreateEnd(criteriaSearch.getCreationDateTo());
        viewAdvanced.getJPanelAdvanced().setDateLastModBegin(criteriaSearch.getModificationDateFrom());
        viewAdvanced.getJPanelAdvanced().setDateLastModEnd(criteriaSearch.getModificationDateTo());
        viewAdvanced.getJPanelAdvanced().setDateLatterAccesBegin(criteriaSearch.getLastDateFrom());
        viewAdvanced.getJPanelAdvanced().setDateLatterAccesEnd(criteriaSearch.getLastDateTo());
        viewAdvanced.getJPanelAdvanced().setTxtOwner(criteriaSearch.getOwner());
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setSelected(criteriaSearch.isSizeCompareOption());
        viewAdvanced.getJPanelAdvanced().setFileMajors(jCheckBox);
        viewAdvanced.getJPanelAdvanced().setCmbHidden(getMessage(criteriaSearch.getHidden(),true));
        viewAdvanced.getJPanelAdvanced().setComboReadOnly(getMessage(criteriaSearch.getReadOnly(),false));
        if (!criteriaSearch.getSize().equals("")) {
            JSpinner spinner = new JSpinner();
            spinner.setValue(Double.parseDouble(criteriaSearch.getSize()) / 1023);
            viewAdvanced.getJPanelAdvanced().setSpinControlSizeFile(spinner);
        }
    }

    /**
     * Obtain the message of hidden or read only.
     * @param enums
     * @param isHidden
     * @return
     */
    private String getMessage(TernaryBooleanEnum enums, boolean isHidden) {
        String result;
        if (enums == TernaryBooleanEnum.OnlyTrue) {
            if (isHidden) {
                result = "Hidden";
            } else {
                result = "Read Only";
            }
        } else if (enums == TernaryBooleanEnum.OnlyFalse){
            if (isHidden) {
                result = "Not Hidden";
            } else {
                result = "Not Read Only";
            }
        } else {
            result = "All";
        }
        return result;
    }

    /**
     * Set dates in to Table.
     */
    public void setDBIntoTable() {
        viewAdvanced.getTbDataBase().removeRow();
        List<CriteriaName> result = criteriaDataBase.loadCriteria();
        if (result != null) {
            for (int i = 0; i < result.size(); i++) {
                viewAdvanced.getTbDataBase().addResultRow(Integer.toString(i), Integer.toString(result.get(i).getId()), result.get(i).getName(), result.get(i).getDateCreation());

            }
        }
    }
}
