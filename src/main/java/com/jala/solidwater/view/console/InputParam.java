/**
 * @(#)CriteriaSearch.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jala.solidwater.view.console;

import com.jala.search.models.CriteriaSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * InputParam class receive all params for the init the SolidWater app for validate them
 * @version 0.0.1
 * @author Raul Choque
 */
public class InputParam {

    /**
     * List for the all commands valid
     */
    List<String> validCommands = new ArrayList<>();

    /**
     * List of the all commands not valid
     */
    String notValidCommands = "";

    public InputParam(String[] commands) {

        validCommands.add("-p");
        validCommands.add("-ex");
        validCommands.add("-fn");
        validateCommands(commands);
    }

    private void validateCommands(String[] commands) {
        String message = "";
        List<String> inputCommand = new ArrayList<>();
        for (int i = 0; i < commands.length; i += 2) {
            inputCommand.add(commands[i]);
            //System.out.println(i++);
        }
        if (existCommand("-p", inputCommand)) {
            /*message = doValidCommands(inputCommand) ?
                        "Valid Commands!!" : invalidCommand(inputCommand,indexNotCommand);*/
            if (doValidCommands(inputCommand)) {
                message = "Valid Commands!!";
               // createCriteria(commands);

            } else {
                message = invalidCommand(notValidCommands);
            }
        } else {
            message = "The command (-p) is required";
        }
        System.out.println(message);
    }

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

    private boolean doValidCommands(List<String> inputCommand) {
        boolean doTheyValid = false;
        for (int i = 0; i < inputCommand.size(); i++) {
            String comand = (String) inputCommand.get(i);
            if (existCommand(comand, validCommands)) {
                doTheyValid = true;
            } else {
                doTheyValid = false;
                notValidCommands =comand;
                i = inputCommand.size();
            }
        }
        return doTheyValid;
    }

    private String invalidCommand(String notCommand) {
           return  "Error: doesn't valid command : " + notCommand;
        /*try {
            message = "Error: doesn't valid command : " + inputCommand.get(indexNotCommand);
        } catch (Exception e) {
            System.out.println("The index: " + indexNotCommand + "isn't valid.");
        }*/
    }
    private CriteriaSearch createCriteria(Map<String, String> validCommand) {
        return new CriteriaSearch("");
    }
}
