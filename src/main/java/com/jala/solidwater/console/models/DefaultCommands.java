/**
 * @(#) DefaultCommands.java Copyright (c) 2019 Jala Foundation.
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

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows create the default commands.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class DefaultCommands {

    /**
     * List for the default commands.
     */
    private List<Command> defaultCommands;

    /**
     * Return the lis of default commands to do search.
     *
     * @return
     */
    public List<Command> getDefaultCommands() {
        return defaultCommands;
    }

    /**
     * This method creates a list of the default commands to do search file.
     *
     * @return the default commands list.
     */
    public List<Command> createDefaultCommands() {
        defaultCommands = new ArrayList<>();
        Command commandPath = new Command("-p", "path", "Path of the file or directory");
        Command commandFileName = new Command("-fn", "fileName", "Name of the file");
        Command commandExtension = new Command("-ex", "extension", "Extension of the file");
        Command commandSize = new Command("-s", "size", "Size of the file");
        defaultCommands.add(commandPath);
        defaultCommands.add(commandFileName);
        defaultCommands.add(commandExtension);
        defaultCommands.add(commandSize);
        return defaultCommands;
    }
}

