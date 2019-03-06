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

import com.jala.search.models.Asset;
import com.jala.solidwater.view.console.ModelConsole;
import com.jala.solidwater.view.console.InputParameter;
import com.jala.solidwater.view.console.ViewConsole;

import java.util.List;

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
        String [] listTest = {"-p", "D:\\Cxrisstian"};
        //validator.validateCommands(listTest);
        ViewConsole viewConsole = new ViewConsole();
        ModelConsole modelConsole = new ModelConsole();
        //InputParameter inputParameter = new InputParameter();

        if (validator.validateCommands(listTest)) {

            viewConsole.testShow(modelConsole.getSearch(listTest));
        } else {
            viewConsole.errorPrint(validator.notValidCommands);
        }

    }
}
