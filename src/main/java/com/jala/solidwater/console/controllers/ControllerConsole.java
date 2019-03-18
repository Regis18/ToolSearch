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
import com.jala.solidwater.console.models.Command;
import com.jala.solidwater.console.models.CommandLine;
import com.jala.solidwater.console.models.ModelConsole;
import com.jala.solidwater.console.validators.ValidCommand;
import com.jala.solidwater.console.validators.ValidCommandLine;
import com.jala.solidwater.console.view.ViewConsole;

import java.util.ArrayList;
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
     * This method is the constructor of ControllerConsole to create an instance.
     *
     * @param parameters are data to find Asset
     */
    public ControllerConsole(String[] parameters) {
        viewConsole = new ViewConsole();
        modelConsole = new ModelConsole();
        validCommandLine = new ValidCommandLine();
        searchAsset(parameters);
    }

    /**
     * Print on console the asset by the command line that was entered.
     *
     * @param parameters to create a command line.
     */
    private void searchAsset(String[] parameters) {
        createCommandLineInput(parameters);
        if (validCommandLine.validate(inputCommandLine)) {
            List<Asset> assets = modelConsole.getSearch(inputCommandLine);
            viewConsole.showAssets(assets);
        } else {
            viewConsole.printMessage(validCommandLine.getMessage());
        }
    }

    /**
     * Create the command line with parameter that was entered in console.
     *
     * @param inputParameters to create a command line.
     * @return command line valid if of commands are valid and
     * invalid if the command at least one commando is invalid.
     */
    private CommandLine createCommandLineInput(String[] inputParameters) {
        List<Command> inputCommands = new ArrayList<>();
        List<String> commandValues = new ArrayList<>();
        for (int i = 0; i < inputParameters.length; i += 2) {
            Command inputCommand = new Command();
            String valueCommand = "";
            inputCommand.setAcronym(inputParameters[i]);
            ValidCommand validCommand = new ValidCommand();
            if (validCommand.validate(inputCommand)) {
                inputCommands.add(inputCommand);
                valueCommand = inputParameters[i + 1];
                commandValues.add(valueCommand);
            } else {
                i = inputParameters.length;
            }
        }
        inputCommandLine = new CommandLine(inputCommands, commandValues);
        return inputCommandLine;
    }
}
