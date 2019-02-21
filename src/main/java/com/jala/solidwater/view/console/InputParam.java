/**
 * InputParam class receive all params for the init the SolidWater app for validate them
 **/
package com.jala.solidwater.view.console;

import java.util.ArrayList;
import java.util.List;

public class InputParam {
    List<String> validCommands = new ArrayList<>();
    int indexNotCommand;

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
        }
        if (existCommand("-p", inputCommand)) {
            message = doValidCommands(inputCommand) ?
                        "Valid Commands!!" : invalidCommand(inputCommand,indexNotCommand);
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
            if (existCommand((String) inputCommand.get(i), validCommands)) {
                doTheyValid = true;
            } else {
                doTheyValid = false;
                indexNotCommand = i;
                i = inputCommand.size();
            }
        }
        return doTheyValid;
    }

    private String invalidCommand(List<String> inputCommand, int indexNotCommand) {
        String message = "";
        try {
            message = "Error: doesn't valid command : " + inputCommand.get(indexNotCommand);
        } catch (Exception e) {
            System.out.println("The index: " + indexNotCommand + "isn't valid.");
        }
        return message;
    }
}
