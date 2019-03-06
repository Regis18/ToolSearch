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

package com.jala.solidwater.view.console;

import java.util.ArrayList;
import java.util.List;

/**
 * InputParameter class, validates the input parameters for console.
 * Verify if these input parameter are valid.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class InputParameter {

    /**
     * List of valid commands.
     */
    List<String> validCommands = new ArrayList<>();

    /**
     * Criteria for not valid command.
     */
    private String notValidCommands = "";

    /**
     * Criteria for show text.
     */
    private String message = "";

    /**
     * Constructor method of InputParameter.
     * This method create a instance of InputParameter.
     */
    public InputParameter() {

        validCommands.add("-p");
        validCommands.add("-ex");
        validCommands.add("-fn");
    }

    /**
     * @return a test to shows
     */
    public String getMessage() {
        return message;
    }

    /**
     * The validateCommands method verify whether input commands exist.
     * @param commands are the input commands to evaluate.
     */
    public boolean validateCommands(String[] commands) {
        boolean areValid = false;
        List<String> inputCommand = new ArrayList<>();
        for (int i = 0; i < commands.length; i += 2) {
            inputCommand.add(commands[i]);
        }
        if (existCommand("-p", inputCommand)) {
            if (areCommandsValid(inputCommand)) {
                message = "SUCCESSFUL: Valid Commands!!";
                areValid = true;
            } else {
                message = "ERROR: The command " + "'" +  notValidCommands + "'" + " is not valid.";
            }
        } else {
            message = "ERROR: The command '-p' is required.";
        }
        return areValid;
    }

    /**
     * The existCommand method return the boolean value if exist the command in the command list.
     * @param command is the value of the command to search.
     * @param commands are the list of commands
     * @return "true" if @param command exist into the @param commands, otherwise "false".
     */
    private boolean existCommand(String command, List<String> commands) {
        boolean exist = true;
        for (int j = 0 ; j < commands.size() ; j++) {
            try {
                if (commands.get(j).equals(command)) {
                    exist = true;
                    j = commands.size();
                } else {
                    exist = false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return exist;
    }

    /**
     * @param inputCommand list of commands to validate
     * @return "true" if commands list are valid, otherwise "false".
     */
    private boolean areCommandsValid(List<String> inputCommand) {
        boolean doTheyValid = false;
        for (int i = 0; i < inputCommand.size(); i++) {
            String command = (String) inputCommand.get(i);
            if (existCommand(command, validCommands)) {
                doTheyValid = true;
            } else {
                doTheyValid = false;
                notValidCommands = command;
                i = inputCommand.size();
            }
        }
        return doTheyValid;
    }
}
