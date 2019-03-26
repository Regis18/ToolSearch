/**
 * @(#) CommandLine.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.console.models;

import com.jala.solidwater.console.validators.ValidCommand;
import com.jala.solidwater.console.validators.ValidValueOfCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class allows to create a command line.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class CommandLine {

    /**
     * List for the commands of command line.
     */
    private List<Command> commands;

    /**
     * List for the command values of command line.
     */
    private List<String> values;

    /**
     * This constructor allows instance a command line sending a command list and command value list.
     *
     * @param inputParameters to set the command list and value list.
     */
    public CommandLine(String[] inputParameters) {
        createCommandLineInput(inputParameters);
    }

    /**
     * Return the command list of command line.
     *
     * @return a list of Command type.
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * Set a command list a command line.
     *
     * @param commands for set the command list.
     */
    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    /**
     * Return a list of values for the commands.
     *
     * @return a list with the value of the commands.
     */
    public List<String> getValueCommands() {
        return values;
    }

    /**
     * Set the list of values for the commands.
     *
     * @param values for set the list de values.
     */
    public void setValueCommands(List<String> values) {
        this.values = values;
    }

    /**
     * Return the position of a command by the acronym sent.
     *
     * @param acronym to get the position of command.
     * @return the position of command as int.
     */
    public int getPositionOfCommandByAcronym(String acronym) {
        int positionOfCommand = -1;
        for (int i = 0; i < commands.size(); i++) {
            Command command = commands.get(i);
            if (command.getAcronym().equals(acronym)) {
                positionOfCommand = i;
                i = commands.size();
            }
        }
        return positionOfCommand;
    }

    /**
     * Set the command list and value list with parameter that was entered in console.
     *
     * @param inputParameters to set the list.
     */
    private void createCommandLineInput(String[] inputParameters) {
        commands = new ArrayList<>();
        values = new ArrayList<>();
        List<String> parameterList = convertValueListToPair(inputParameters);
        for (int i = 0; i < parameterList.size(); i += 2) {
            Command inputCommand = new Command();
            String valueCommand = "";
            inputCommand.setAcronym(parameterList.get(i));
            ValidCommand validCommand = new ValidCommand();
            if (validCommand.validate(inputCommand)) {
                commands.add(inputCommand);
                valueCommand = parameterList.get(i+1);
                ValidValueOfCommand validValueOfCommand = new ValidValueOfCommand();
                if (validValueOfCommand.validate(valueCommand)) {
                    values.add(valueCommand);
                } else {
                    i = parameterList.size();
                }
            } else {
                i = parameterList.size();
            }
        }
    }

    private List<String> convertValueListToPair(String[] inputParameters) {
        List<String> parameterList = new ArrayList<>();
        parameterList.addAll(Arrays.asList(inputParameters));
        
        if (parameterList.size() % 2 != 0){
            parameterList.add("");
        } else {
            parameterList = parameterList;
        }
        return parameterList;
    }
}
