/*
 * @(#)ControllerConsole.java
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

package com.jala.solidwater.console.controllers;

import com.jala.search.models.Asset;
import com.jala.solidwater.console.models.Command;
import com.jala.solidwater.console.models.CommandLine;
import com.jala.solidwater.console.validators.ValidCommand;
import com.jala.solidwater.console.validators.ValidCommandLine;
import com.jala.solidwater.view.console.ModelConsole;
import com.jala.solidwater.view.console.ViewConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * ControllerConsole class will manage the ModelConsole, ViewConsole.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ControllerConsole {

    /**
     * Criteria for show the result of find
     */
    private ViewConsole viewConsole;

    /**
     * Criteria for search of Asset
     */
    private ModelConsole modelConsole;

    private CommandLine inputCommandLine;
    private ValidCommandLine validCommandLine;

    /**
     * This method is the constructor of ControllerConsole to create an instance
     * @param parameters are data to find Asset
     */
    public ControllerConsole(String[] parameters) {
        viewConsole = new ViewConsole();
        modelConsole = new ModelConsole();
        validCommandLine = new ValidCommandLine();
        searchAsset(parameters);
    }
    private void searchAsset(String[] parameters) {
        createCommandLineInput(parameters);
        if (validCommandLine.validate(inputCommandLine)) {
            List<Asset> assets = modelConsole.getSearch(inputCommandLine);
            viewConsole.showAssets(assets);
        } else {
            viewConsole.printMessage(validCommandLine.getMessage());
        }
    }

    private CommandLine createCommandLineInput(String[] input) {
        List<Command> inputCommands = new ArrayList<>();
        List<String> commandValues = new ArrayList<>();
        for (int i = 0; i < input.length ; i += 2) {
            Command inputCommand = new Command();
            String valueCommand = "";
            inputCommand.setAcronym(input[i]);
            ValidCommand validCommand = new ValidCommand();
            if(validCommand.validate(inputCommand)) {
                inputCommands.add(inputCommand);
                valueCommand = input[i+1];
                commandValues.add(valueCommand);
            } else {
                i = input.length;
            }
        }
        inputCommandLine = new CommandLine(inputCommands, commandValues);
        return inputCommandLine;
    }
}
