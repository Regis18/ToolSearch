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
                "Path of the file or directory");
        Command commandForFileName = new Command("-fn", "File Name",
                "Name of the file");
        Command commandForExtension = new Command("-ex", "Extension",
                "Extension of the file");
        Command commandForSize = new Command("-s", "Size",
                "Size of the file");
        Command commandForHidden = new Command("-h", "Hidden",
                "This command allows the values true and false");
        Command commandForReadOnly = new Command("-ro", "Read Only",
                "This command allows the values Yes and No");
        Command commandCreationDateFrom = new Command("-cdf", "Creation Date From",
                "Allows search the files from a specific creation date. Format yyyy-mm-dd");
        Command commandCreationDateTo = new Command("-cdt", "Creation Date To",
                "Allows search files to a creation date in specific. Format yyyy-mm-dd");
        Command commandModificationDateFrom = new Command("-mdf", "Modification Date From",
                "Allows search the files from a modification date specific. Format yyyy-mm-dd");
        Command commandModificationDateTo = new Command("-mdt", "Modification Date To",
                "Allows search the to a modification date specific. Format yyyy-mm-dd");
        Command commandForLastDateFrom = new Command("-ldf", "Last Date From",
                "Allows search the files from a last date specific. Format yyyy-mm-dd");
        Command commandForLastDateTo = new Command("-ldt", "Last Date to",
                "Allows search the files to a last date specific. Format yyyy-mm-dd");
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
        return defaultCommands;
    }
}

