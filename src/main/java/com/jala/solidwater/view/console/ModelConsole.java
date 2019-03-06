/*
 * @(#)CriteriaSearch.java
 *
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.view.console;

import com.jala.search.models.Asset;
import com.jala.search.models.CriteriaSearch;
import com.jala.search.models.SearchFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ModelConsole class defines the structure of a ModelConsole.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ModelConsole {

    /**
     * Criterias for the acronym, name, description of a command.
     */
    private String acronym, name, description;

    /**
     * Constructor method of ModelConsole class.
     * This method create a instance of ModelConsole
     *
     * @param acronym of a command
     * @param name of a command
     * @param description of a command
     */
    public ModelConsole(String acronym, String name, String description) {
        this.acronym = acronym;
        this.name = name;
        this.description = description;
    }
    /**
     * This method create a instance of ModelConsole class
     */
    public ModelConsole() {
    }

    /**
     * @return acronym as string
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * @param acronym set up.
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * @return name as string
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set up
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description as string
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description set up
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param validCommands are valid data for the search
     * @return a Asset list that were find
     */
    public List<Asset> getSearch(String[] validCommands){
        return getAsset(createMap(validCommands));
    }
    /**
     * @param inputCommands are all commands valid
     * @return a Map with the key = command and value = value command.
     */
    private Map<String, String> createMap(String[] inputCommands) {
        Map<String, String> validCommandsInMap = new HashMap<>();
        int positionKey, positionValue = 0;
        for (int i = 0; i < inputCommands.length ; i += 2) {
            positionKey = i;
            positionValue = positionKey + 1;
            validCommandsInMap.put(inputCommands[positionKey], inputCommands[positionValue]);
        }
        return validCommandsInMap;
    }

    /**
     * @param validCommand is a Map with all valid commands.
     * @return a Asset list with the criteria of search.
     */
    private List<Asset> getAsset(Map<String, String> validCommand) {

        ArrayList<Asset> listFileSearch = new ArrayList<>();
        CriteriaSearch criteria = new CriteriaSearch(validCommand.get("-p"));
        SearchFile searchFile = new SearchFile();
        try {
            listFileSearch = new ArrayList<>(searchFile.search(criteria));
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
        return listFileSearch;
    }
}
