/**
 * @(#)App.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.solidwater.console.controllers.ControllerConsole;

/**
 * AppB
 *
 * @author Regis Humana
 * @version 0.0.1
 */
public class App {

    /**
     * Create a variable of Run
     */
    private static Run runApp;

    /**
     * Attribute to execute search from console.
     */
    private static ControllerConsole controllerConsole;

    /**
     * Executes the program
     *
     * @param args that are entered from console.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            //Execute search for console.
            controllerConsole = new ControllerConsole(args);
        } else {
            //Execute the application with UI
            runApp = new Run();
        }
    }
}
