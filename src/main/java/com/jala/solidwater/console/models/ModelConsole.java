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

import com.jala.search.models.Asset;
import com.jala.search.models.CriteriaSearch;
import com.jala.search.models.SearchFile;

import javax.xml.soap.SAAJResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ModelConsole class defines the structure of a ModelConsole.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ModelConsole {

    private static final String EMPTY_VALUE_FOR_SET_IN_ATTRIBUTES_OF_CRITERIA = "";
    private static final String FILE_NAME_COMMAND = "-fn";
    private static final String EXTENSION_COMMAND = "-ex";
    private static final String SIZE_COMMAND = "-s";

    /**
     * @param inputCommandLine are valid data for the search
     * @return a Asset list that were find
     */
    public List<Asset> getSearch(CommandLine inputCommandLine) {
        return getAsset(inputCommandLine);
    }

    /**
     * @param validCommand is a Map with all valid commands.
     * @return a Asset list with the criteria of search.
     */
    private List<Asset> getAsset(CommandLine validCommand) {
        String valuePath = getValueCommandByPositionOfCommand(validCommand, "-p");

        CriteriaSearch criteria = new CriteriaSearch(valuePath);
        criteria.setFileName(setCriteriaValueIfExistCommand(validCommand, FILE_NAME_COMMAND));
        criteria.setExtension(setCriteriaValueIfExistCommand(validCommand, EXTENSION_COMMAND));
        criteria.setSize(setCriteriaValueIfExistCommand(validCommand, SIZE_COMMAND));

        SearchFile searchFile = new SearchFile();
        ArrayList<Asset> listFileSearch = new ArrayList<>();
        try {
            listFileSearch = new ArrayList<>(searchFile.search(criteria));
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
        return listFileSearch;
    }

    private String setCriteriaValueIfExistCommand(CommandLine cl, String acronym) {
        String value = EMPTY_VALUE_FOR_SET_IN_ATTRIBUTES_OF_CRITERIA;
        for (int i =1; i < cl.getCommands().size(); i++) {
            Command command = cl.getCommands().get(i);
            if (command.getAcronym().equals(acronym)) {
                value = getValueCommandByPositionOfCommand(cl, acronym);
                i = cl.getCommands().size();
            } else {
                value = value;
            }
        }
        return value;
    }

    private String getValueCommandByPositionOfCommand(CommandLine validCommand, String acronymCommand) {

        int positionOfCommand = validCommand.getPositionOfCommandByAcronym(acronymCommand);
        String valueByPositionCommand = "";
        if (!validCommand.getValueCommands().get(positionOfCommand).isEmpty()
                && validCommand.getValueCommands().get(positionOfCommand) != null) {
            valueByPositionCommand =  validCommand.getValueCommands().get(positionOfCommand);
        } else {
            valueByPositionCommand = valueByPositionCommand;
        }
        return valueByPositionCommand;
    }
}
