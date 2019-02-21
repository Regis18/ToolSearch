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

    private boolean doValidCommands(List<String> inputCommand) {
        boolean dotheyValid = false;
        if (validCommands.size() == inputCommand.size()) {
            for (int i = 0; i < inputCommand.size(); i++) {
                if (existCommand((String) inputCommand.get(i), validCommands)) {
                    dotheyValid = true;
                } else {
                    dotheyValid = false;
                    indexNotCommand = i;
                    i = inputCommand.size();
                }
            }
        }
        return dotheyValid;
    }

    private String invalidCommand(List<String> inputCommand, int indexNotCommand) {
        String message = "Error: ";
        if (inputCommand.size() == validCommands.size()) {
            message = "doesn't valid command : " + inputCommand.get(indexNotCommand);
        } else {
            message += "You shall manage " + validCommands.size() + " commands.";
        }
        return  message;
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
}
