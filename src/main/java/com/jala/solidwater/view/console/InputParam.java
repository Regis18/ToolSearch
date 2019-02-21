/**
 * InputParam class receive all params for the init the SolidWater app for validate them
 **/
package com.jala.solidwater.view.console;


import java.util.ArrayList;
import java.util.List;

public class InputParam {
    List<String> validCommands = new ArrayList<>();

    public InputParam(String[] commands) {
        validCommands.add("-p");
        validCommands.add("-ex");
        validCommands.add("-fn");
        validateCommands(commands);
    }

    private void validateCommands(String[] commands) {
        String message = "";
        Boolean areValidCommands = true;
        for (int i = 0; i < commands.length; i += 2) {
            if (existCommand(commands[i]) == false) {
                message += "doesn't valid command : " + commands[i];
                areValidCommands = false;
                i = commands.length;
            }
        }
        message = areValidCommands ? " Valid commands" : "Error " + message;
        System.out.println(message);
    }
    private boolean existCommand(String command) {
        boolean exist = true;
        for (int j = 0 ; j < validCommands.size() ; j++) {
            try {
                if (validCommands.get(j).equals(command)) {
                    exist = true;
                    j = validCommands.size();
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
