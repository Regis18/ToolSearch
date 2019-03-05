/*
 * @(#)CriteriaSearch.java
 *
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

import com.jala.solidwater.view.console.InputParameter;
import com.jala.solidwater.view.console.ViewConsole;

public class App {

    /**
     *
     * Main method in order to execute the SolidWater app
     * @param args are the input parameters send for console.
     */
    public static void main(String[] args) {

        /* Created a validator instance */
        InputParameter validator = new InputParameter();

        /* Use the method validateCommand for validate the input commands. */
        String [] listTest = {"-p", "D:\\Fundacion-Jala"};
        validator.validateCommands(listTest);

        /* Created a viewCommand instance */
        ViewConsole viewConsole = new ViewConsole();
        
        /* Use the testShow to simulate the create of a table with files as data. */
        viewConsole.testShow( validator.getListFileSearch());

        /*for (String value:args
             ) {
            System.out.println("input parameters : " + value);
        }*/

    }
}
