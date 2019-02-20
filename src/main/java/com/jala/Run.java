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

package com.jala;

import com.jala.search.controller.ControllerMain;
import com.jala.view.MainView;

public class Run {
    private MainView viewApp = new MainView();
    private ControllerMain controller;

    public Run() {
        controller = new ControllerMain(viewApp);
        controller.initView();
        //controller.sendPathToSearch();
    }
}
