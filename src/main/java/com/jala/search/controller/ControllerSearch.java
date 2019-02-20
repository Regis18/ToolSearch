/**
 * @(#)File.java Copyright (c) 2019 Jala Foundation.
2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
All rights reserved.
 *
 * This software is the confidential and proprietary information of
Jala Foundation, ("Confidential Information"). You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with Jala Foundation.
 */
package com.jala.search.controller;

import com.jala.seacrh.models.SearchFile;
import com.jala.view.JPanelSearchGral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;


public class ControllerSearch {
    private SearchFile search = new SearchFile();
    private JPanelSearchGral viewSearch;

    public ControllerSearch(JPanelSearchGral viewSearch) {
        this.viewSearch = viewSearch;
        viewSearch.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendPathToSearch();
            }
        });
    }

    private void sendPathToSearch(){
        List<File> results = search.searchByPath(viewSearch.getTxtPath().getText());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}

