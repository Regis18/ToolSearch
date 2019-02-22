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
import com.jala.view.JPanelSearchGral;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

/**
 * ControllerSearch
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerSearch implements ActionListener {
    private SearchFile search = new SearchFile();
    private JPanelSearchGral viewSearch;

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
     *
     */
    private void actionsListener(){
        viewSearch.getBtnSearch().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewSearch.getBtnSearch()) {
            sendPathToSearch(viewSearch.getTxtPath().getText());
        }
    }
    private void sendPathToSearch(String Path){
        CriteriaSearch criteria = new CriteriaSearch(Path);
        //puede ser que borres table
        DefaultTableModel table = new DefaultTableModel(0, 5);
        List<File> results = search.search(criteria);
        String [] columns = new String[]{
                "Id", "Path", "File Name", "Ext.", "Size"
        };
        String [] dataArray;
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
            File data = results.get(i);
            dataArray = new String[]{data.getAbsolutePath(), data.getName()};
            table.addRow(dataArray);
        }
    }
}

