/**
 * @(#)ValidCommandLine.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.console.validators;

import com.jala.solidwater.console.models.CommandLine;

/**
 * ValidCommandLine class will validate if the command line that is valid.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class ValidCommandLine implements IValidable<CommandLine> {

    /**
     * Message to show if there is a error.
     */
    private String message = "";

    /**
     * Return message to print in console.
     *
     * @return message as string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message to print in console.
     *
     * @param message for the error.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method allows validate a command line.
     *
     * @param commandLine to validate.
     * @return true if the size of commands
     * and values are equals and if the command content path command,
     * false if the size of commands and values are aren't equals
     * or not content path command.
     */
    @Override
    public boolean validate(CommandLine commandLine) {
        boolean validCommandLine = false;
        if (commandLine.getCommands().size() == commandLine.getValueCommands().size()) {
            if (existCommandPath("-p", commandLine)) {
                validCommandLine = true;
            } else {
                validCommandLine = validCommandLine;
                setMessage("The command -p is required");
            }
        } else {
            validCommandLine = validCommandLine;
            setMessage("The size of commands and values in command line are differents");
        }
        return validCommandLine;
    }

    /**
     * This method validate if the path command exists in command line.
     *
     * @param commandPath to validate the path.
     * @param commandLine to search the path command.
     * @return true if command line content path command,
     * false if command line doesn't content path command.
     */
    private boolean existCommandPath(String commandPath, CommandLine commandLine) {
        boolean exist = false;
        for (int j = 0; j < commandLine.getCommands().size(); j++) {
            try {
                if (commandLine.getCommands().get(j).getAcronym().equals(commandPath)) {
                    exist = true;
                    j = commandLine.getCommands().size();
                } else {
                    exist = exist;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return exist;
    }
}
