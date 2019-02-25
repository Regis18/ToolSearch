/**
 * @(#)ControllerMain.java Copyright (c) 2019 Jala Foundation.
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

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import com.jala.search.controller.ControllerSearch;
import com.jala.search.controller.ControllerSearchAdvanced;
import com.jala.utils.Logs;
import com.jala.view.MainView;
import org.apache.log4j.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * ControllerMain
 * It controls the MainView
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerMain implements ActionListener {

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    /** ViewApp: create a pointer of MainView, the object will provide other class.*/
    private MainView viewApp;

    /**
     * Create a constructor of Main Controller
     * @param viewApp
     */
    public ControllerMain(MainView viewApp){
        log.info("Initialize the Controller of MainView");
        this.viewApp = viewApp;
    }

    /**
     * Loading the UI and Initialize the listener of the menu items
     */
    public void initView(){
        log.info("Loading of the MainView from Controller");
        viewApp.init();
        viewApp.setVisible(true);
        actionsListener();
        log.info("Finished the loading");
    }

    /**
     * Initialize the action listener of the menu item of exit and item general, and Container Listener
     */
    private void actionsListener(){
        log.info("Initialize actions listener in ControllerMain");
        viewApp.getMenuItemExit().addActionListener(this);
        viewApp.getMenuItemGeneral().addActionListener(this);
        viewApp.getContentPane().addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                if (viewApp.getContentPane().getComponent(0) == viewApp.getpSearchGral()) {
                    log.info("Loading Search General Form");
                    new ControllerSearch(viewApp.getpSearchGral());
                } else if (viewApp.getContentPane().getComponent(0) == viewApp.getpSearchAdvanced()) {
                    log.info("Loading Search Advanced Form");
                    new ControllerSearchAdvanced(viewApp.getpSearchAdvanced());
                }
            }
            @Override
            public void componentRemoved(ContainerEvent e) {
            }
        });
    }

    /**
     * This method listens the an action that was performed
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == viewApp.getMenuItemExit()) {
            log.info("Item Exit was pressed and Program exits");
            log.info("Program Exits");
            System.exit(0);
        }
    }
}
