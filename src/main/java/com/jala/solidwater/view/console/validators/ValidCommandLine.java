package com.jala.solidwater.view.console.validators;

import com.jala.solidwater.view.console.models.Command;

public class ValidCommandLine implements IValidable<Command.CommandLine> {
    @Override
    public boolean validate(Command.CommandLine commandLine) {
        boolean validCommandLine = false;
        if (commandLine.getCommands().size() == commandLine.getValueCommands().size()) {
            exitCommandPath("-p", commandLine);
            validCommandLine = true;
        }
        return validCommandLine;
    }

    private boolean exitCommandPath(String commandPath, Command.CommandLine commandLine) {
        boolean exist = true;
        for (int j = 0 ; j < commandLine.getCommands().size(); j++) {
            try {
                if (commandLine.getCommands().get(j).getAcronym().equals(commandPath)) {
                    exist = true;
                    j = commandLine.getCommands().size();
                } else {
                    exist = false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return exist;
    }

   /* private boolean areCommandsValid(List<Command> inputCommand) {
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
    }*/
}
