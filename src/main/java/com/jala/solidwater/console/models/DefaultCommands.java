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
     * The method allows to instance the default commands.
     */
    public DefaultCommands() {
        createDefaultCommands();
    }

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
    private List<Command> createDefaultCommands() {
        defaultCommands = new ArrayList<>();
        Command commandForPath = new Command("-p", "Path",
                "Path of the directory");
        Command commandForFileName = new Command("-fn", "File Name",
                "Name of the file");
        Command commandForExtension = new Command("-ex", "Extension",
                "Extension of the file");
        Command commandForSize = new Command("-s", "Size",
                "Size of the file");
        Command commandForHidden = new Command("-h", "Hidden",
                "This command allows the values Yes, No and All");
        Command commandForReadOnly = new Command("-ro", "Read Only",
                "This command allows the values Yes, No and All");
        Command commandCreationDateFrom = new Command("-cdf", "Creation Date From",
                "Allows to search the files starting from a specific creation date. Format yyyy-mm-dd");
        Command commandCreationDateTo = new Command("-cdt", "Creation Date To",
                "Allows to search the files until a specific creation date. Format yyyy-mm-dd");
        Command commandModificationDateFrom = new Command("-mdf", "Modification Date From",
                "Allows to search the files starting from a specific modification date. Format yyyy-mm-dd");
        Command commandModificationDateTo = new Command("-mdt", "Modification Date To",
                "Allows to search the files until a specific modification date. Format yyyy-mm-dd");
        Command commandForLastDateFrom = new Command("-ldf", "Last Date From",
                "Allows to search the files starting from a specific last access date. Format yyyy-mm-dd");
        Command commandForLastDateTo = new Command("-ldt", "Last Date to",
                "Allows to search the files starting from a specific last access date. Format yyyy-mm-dd");
        Command commandForHelp = new Command("-help", "Help",
                "Show all command that can be used");
        defaultCommands.add(commandForPath);
        defaultCommands.add(commandForFileName);
        defaultCommands.add(commandForExtension);
        defaultCommands.add(commandForSize);
        defaultCommands.add(commandForHidden);
        defaultCommands.add(commandForReadOnly);
        defaultCommands.add(commandCreationDateFrom);
        defaultCommands.add(commandCreationDateTo);
        defaultCommands.add(commandModificationDateFrom);
        defaultCommands.add(commandModificationDateTo);
        defaultCommands.add(commandForLastDateFrom);
        defaultCommands.add(commandForLastDateTo);
        defaultCommands.add(commandForHelp);
        return defaultCommands;
    }
}

