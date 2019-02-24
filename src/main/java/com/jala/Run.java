package com.jala;

import com.jala.search.controller.ControllerMain;

public class Run {
    public Run() {
        MainView mainView =  new MainView();
        ControllerMain controllerMain = new ControllerMain(mainView);
        controllerMain.initView();
    }
}
