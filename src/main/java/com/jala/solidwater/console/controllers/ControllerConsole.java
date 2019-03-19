/**
 * @(#)ControllerConsole.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.console.controllers;

import com.jala.model.search.asset.Asset;
import com.jala.solidwater.console.models.CommandLine;
import com.jala.solidwater.console.models.ModelConsole;
import com.jala.solidwater.console.validators.ValidCommandLine;
import com.jala.solidwater.console.validators.ValidInputParameters;
import com.jala.solidwater.console.view.ViewConsole;

import java.util.List;

/**
 * ControllerConsole class will manage the ViewConsole.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ControllerConsole {

    /**
     * Criteria for show the result of find.
     */
    private ViewConsole viewConsole;

    /**
     * Criteria for search of Asset.
     */
    private ModelConsole modelConsole;

    /**
     * Command line to set the arguments of console.
     */
    private CommandLine inputCommandLine;

    /**
     * Allows validate a command line.
     */
    private ValidCommandLine validCommandLine;

    /**
     * Allows validate the input parameters.
     */
    private ValidInputParameters validInputParameters;

    /**
     * This method is the constructor of ControllerConsole to create an instance.
     *
     * @param parameters are data to find Asset
     */
    public ControllerConsole(String[] parameters) {
        viewConsole = new ViewConsole();
        modelConsole = new ModelConsole();
        validCommandLine = new ValidCommandLine();
        validInputParameters = new ValidInputParameters();
        if (validInputParameters.validate(parameters)) {
            inputCommandLine = new CommandLine(parameters);
            searchAsset(inputCommandLine);
        } else {
            viewConsole.printMessage(validInputParameters.getMessage());
        }
    }

    /**
     * Print on console the asset by the command line that was entered.
     *
     * @param inputCommandLine to search the files.
     */
    private void searchAsset(CommandLine inputCommandLine) {

        if (validCommandLine.validate(inputCommandLine)) {
            List<Asset> assets = modelConsole.getSearch(inputCommandLine);
            viewConsole.showAssets(assets);
        } else {
            viewConsole.printMessage(validCommandLine.getMessage());
        }
    }
}
