package com.jala.solidwater.console.validators;

import com.jala.solidwater.view.console.models.CommandLine;

public class ValidCommandLine implements IValidable<CommandLine> {
    @Override
    public boolean validate(CommandLine commandLine) {
        boolean validCommandLine = false;
        if (commandLine.getCommands().size() == commandLine.getValueCommands().size()) {
            if (exitCommandPath("-p", commandLine)) {
                validCommandLine = true;
            } else {
                validCommandLine = validCommandLine;
            }
        }
        return validCommandLine;
    }

    private boolean exitCommandPath(String commandPath, CommandLine commandLine) {
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
}
