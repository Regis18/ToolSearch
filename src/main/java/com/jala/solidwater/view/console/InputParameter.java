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

import com.jala.search.models.CriteriaSearch;
import com.jala.search.models.SearchFile;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String notValidCommands = "";

    /**
     * Constructor method of InputParameter.
     * This method create a instance of InputParameter.
     */

    List<File> listFileSearch = new ArrayList<>();

    public InputParameter() {

        validCommands.add("-p");
        validCommands.add("-ex");
        validCommands.add("-fn");
    }

    /**
     * The validateCommands method verify whether input commands exist.
     * @param commands are the input commands to evaluate.
     */
    public void validateCommands(String[] commands) {
        String message = "";
        List<String> inputCommand = new ArrayList<>();
        for (int i = 0; i < commands.length; i += 2) {
            inputCommand.add(commands[i]);
        }
        if (existCommand("-p", inputCommand)) {
            if (areCommandsValid(inputCommand)) {
                message = "Valid Commands!!";
                getSearch(createMap(commands));
            } else {
                message = invalidCommand();
            }
        } else {
            message = "The command (-p) is required";
        }
        System.out.println(message);
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

    /**
     * @return a string with the message and value of the invalid command.
     */
    private String invalidCommand() {
        return  "Error: doesn't valid command : " + notValidCommands;
    }

    /**
     * @param inputCommands are all commands valid
     * @return a Map with the key = command and value = value command.
     */
    private Map<String, String> createMap(String[] inputCommands) {
        Map<String, String> validCommandsInMap = new HashMap<>();
        int positionKey, positionValue = 0;
        for (int i = 0; i < inputCommands.length ; i += 2) {
            positionKey = i;
            positionValue = positionKey + 1;
            validCommandsInMap.put(inputCommands[positionKey], inputCommands[positionValue]);
        }
        return validCommandsInMap;
    }

    /**
     * @param validCommand is a Map with all valid commands.
     * @return a file list with the criteria of search.
     */
    private List<File> getSearch(Map<String, String> validCommand) {

        CriteriaSearch criteria = new CriteriaSearch(validCommand.get("-p"));
        /*criteria.setPath(validCommand.get("-p"));
        criteria.setFileName(validCommand.get("-fn"));
        criteria.setExtension("-ex");*/
        criteria.setFileName("");
        criteria.setExtension("");
        SearchFile searchFile = new SearchFile();
        try {
            listFileSearch = new ArrayList<>(searchFile.search(criteria));
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
        return searchFile.search(criteria);
    }

    public List<File> getListFileSearch() {
        return listFileSearch;
    }
}