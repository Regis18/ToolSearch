/**
 * @(#)ModelConsole.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.model.criteria.CriteriaSearch;
import com.jala.model.search.SearchFile;
import com.jala.model.search.asset.Asset;

import java.util.ArrayList;
import java.util.List;

/**
 * ModelConsole class defines the structure of a ModelConsole.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ModelConsole {

    /**
     * Constant for set empty values in criteria.
     */
    private static final String EMPTY_VALUE_FOR_SET_IN_ATTRIBUTES_OF_CRITERIA = "";

    /**
     * Constant to get command by file name acronym.
     */
    private static final String FILE_NAME_COMMAND = "-fn";

    /**
     * Constant to get command by extension acronym.
     */
    private static final String EXTENSION_COMMAND = "-ex";

    /**
     * Constant to get command by size acronym.
     */
    private static final String SIZE_COMMAND = "-s";

    /**
     * This method return a asset list sending
     * a command line valid and according to the setting of criteria.
     *
     * @param validCommand command valid to search file.
     * @return a Asset list according to the criteria set.
     */
    public List<Asset> getSearch(CommandLine validCommand) {
        String valuePath = getValueCommandByPositionOfCommand(validCommand, "-p");

        CriteriaSearch criteria = new CriteriaSearch(valuePath);
        criteria.setFileName(setValueIfExistCommand(validCommand, FILE_NAME_COMMAND));
        criteria.setExtension(setValueIfExistCommand(validCommand, EXTENSION_COMMAND));
        criteria.setSize(setValueIfExistCommand(validCommand, SIZE_COMMAND));

        SearchFile searchFile = new SearchFile();
        ArrayList<Asset> listFileSearch = new ArrayList<>();
        try {
            listFileSearch = new ArrayList<>(searchFile.search(criteria));
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
        return listFileSearch;
    }

    /**
     * This method set the criteria if the command exist in command line.
     *
     * @param commandLine to search the acronym sent.
     * @param acronym     to search in command line and get its value.
     * @return if command exist return the value its value, else return value as empty.
     */
    private String setValueIfExistCommand(CommandLine commandLine, String acronym) {
        String value = EMPTY_VALUE_FOR_SET_IN_ATTRIBUTES_OF_CRITERIA;
        for (int i = 1; i < commandLine.getCommands().size(); i++) {
            Command command = commandLine.getCommands().get(i);
            if (command.getAcronym().equals(acronym)) {
                value = getValueCommandByPositionOfCommand(commandLine, acronym);
                i = commandLine.getCommands().size();
            } else {
                value = value;
            }
        }
        return value;
    }

    /**
     * Get the value the a command getting the position del command by acronym.
     *
     * @param validCommand   to get the value of a command.
     * @param acronymCommand to get the position of command.
     * @return value as string of an command by its position.
     */
    private String getValueCommandByPositionOfCommand(CommandLine validCommand, String acronymCommand) {
        int positionOfCommand = validCommand.getPositionOfCommandByAcronym(acronymCommand);
        String valueByPositionCommand = "";
        if (!validCommand.getValueCommands().get(positionOfCommand).isEmpty()
                && validCommand.getValueCommands().get(positionOfCommand) != null) {
            valueByPositionCommand = validCommand.getValueCommands().get(positionOfCommand);
        } else {
            valueByPositionCommand = valueByPositionCommand;
        }
        return valueByPositionCommand;
    }
}
