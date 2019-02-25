/**
 * @(#)Run.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jala;

import com.jala.controller.ControllerMain;
import com.jala.view.MainView;

/**
 * Run
 * Establish the sequence of the running program.
 *
 * @version 0.0.1
 * @author Regis Humana
 */
public class Run {
    /**
     * Build a constructor to do run the program and arise the main controller
     */
    public Run() {
        MainView mainView = new MainView();
        ControllerMain controllerMain = new ControllerMain(mainView);
        controllerMain.initView();
    }
}
