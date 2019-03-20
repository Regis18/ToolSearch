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
        Command commandForPath = new Command("-p", "path", "Path of the file or directory");
        Command commandForFileName = new Command("-fn", "fileName", "Name of the file");
        Command commandForExtension = new Command("-ex", "extension", "Extension of the file");
        Command commandForSize = new Command("-s", "size", "Size of the file");
        Command commandForHidden = new Command("-hd", "hidden", "This command allows the values true and false");
        Command commandForReadOnly = new Command("-ro", "readOnly", "This command allows the values Yes and No");
        Command commandFromDateCreation = new Command("-fdc", "from date creation",
                "This command allows set a date to search the file from the date needed in formmat yyyy-mm-dd");
        Command commandToDateCreateion = new Command("-tdc", "to date creation", "");
        Command commandFromDateModified = new Command("-fdm", "From to date modified", "");
        Command commandToDateModified = new Command("-tdm", "to date modified", "");
        defaultCommands.add(commandForPath);
        defaultCommands.add(commandForFileName);
        defaultCommands.add(commandForExtension);
        defaultCommands.add(commandForSize);
        defaultCommands.add(commandForHidden);
        defaultCommands.add(commandForReadOnly);
        defaultCommands.add(commandFromDateCreation);
        defaultCommands.add(commandToDateCreateion);
        defaultCommands.add(commandFromDateModified);
        defaultCommands.add(commandToDateModified);
        return defaultCommands;
    }
}

