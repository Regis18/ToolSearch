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


import com.jala.utils.Logs;
import com.jala.view.MainView;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ControllerMain {
    Logger log = Logs.getInstance().getLog();

    MainView viewApp;
    JMenuItem menuItemExit;
    JMenuItem menuItemSearch;
    public ControllerMain(MainView viewApp){
        this.viewApp = viewApp;
    }

    public void initView(){
        viewApp.init();
        log.info("Loading MainView form");
        viewApp.setVisible(true);
        menuItemExit = viewApp.getMenuItemExit();
        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuItemSearch = null;
        menuItemSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerSearch controllerSearch = new ControllerSearch(viewApp.getSearchGral);
            }
        });

    }
}
