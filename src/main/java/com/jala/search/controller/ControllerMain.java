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
package com.jala.search.controller;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import com.jala.utils.Logs;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * ControllerMain
 *
 * @version 0.0.1
 * @author Regis Humana
 */
public class ControllerMain implements ActionListener {
    /*It controls the MainView*/

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();
    /** ViewApp: create a pointer of MainView, the object will provide other class.*/
    private MainView viewApp;

    /**
     * Create a constructor of Main Controller
     * @param viewApp
     */
    public ControllerMain(MainView viewApp){
        this.viewApp = viewApp;
    }

    /**
     * Loading the UI and Initialize the listener of the menu items
     */
    public void initView(){
        viewApp.init();
        log.info("Loading MainView form");
        viewApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        viewApp.setVisible(true);
        actionsListener();
    }

    /**
     * Initialize the action listener of the menu item of exit and item general, and Container Listener
     */
    private void actionsListener(){
        viewApp.getMenuItemExit().addActionListener(this);
        viewApp.getMenuItemGeneral().addActionListener(this);
        viewApp.getContentPane().addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println(viewApp.getContentPane().getComponent(0));
                if (viewApp.getContentPane().getComponent(0) == viewApp.getpSearchGral()) {
                    new ControllerSearch(viewApp.getpSearchGral());
                } else if (viewApp.getContentPane().getComponent(0) == viewApp.getpSearchAdvanced()) {
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
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewApp.getMenuItemExit()) {
            System.exit(0);
        }
    }
}
