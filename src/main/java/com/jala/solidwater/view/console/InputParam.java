/**
 * InputParam class receive all params for the init the SolidWater app
 **/
package com.jala.solidwater.view.console;

import java.util.HashMap;
import java.util.Map;

public class InputParam {
    private Map<String, String> validCommands = new HashMap<>();
    public InputParam(String[] commands) {
         validCommands.put("-p", "c://java/test.class");
         validCommands.put("-ex", ".mp3");
         validateInputParam(commands);

    }
    private void validateInputParam(String[] commands) {
        String message = "";
        Map<String, String> posibleCommand = new HashMap<>();
        int pos = 0;
        for (int i = 0; i < commands.length ; i = i + 2) {
            pos = i;
            String command = commands[pos];
            String commandValue = commands[++pos];
            if (isValidCommand(command)) {
                posibleCommand.put(command, commandValue);
                System.out.println(posibleCommand.size());
                message += "The command: " + command + " is valid.";
            } else {
                message += "The command: " + command + " isn't valid.";
            }
        }
        System.out.println(message);
        validateCommands(posibleCommand);
    }
    private boolean isValidCommand(String command) {
        return command.charAt(0) == '-' ? true : false;
    }
    private void validateCommands(Map<String, String> posibleCommands) {
            String message = "";
        for (String commandName: posibleCommands.keySet()) {
            if (!validCommands.isEmpty()){
                if (validCommands.containsKey(commandName)) {
                    message += "The command: " + commandName + " exist.";
                } else {
                    message += "The command: " + commandName + " doesn't exist.";
                }
            }
        }
        System.out.println(message);
    }

}
