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
     * @param commands to create the list of commands.
     * @param values   to create the list of command value.
     */
    public CommandLine(List<Command> commands, List<String> values) {
        this.commands = commands;
        this.values = values;
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
}
