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

/**
 * Command class defines the structure of a Command.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class Command {

    /**
     * Criterias for the acronym, name, description of a command.
     */
    private String acronym, name, description;

    /**
     * Constructor method of Command class.
     * This method create a instance of Command
     *
     * @param acronym of a command
     * @param name of a command
     * @param description of a command
     */
    public Command(String acronym, String name, String description) {
        this.acronym = acronym;
        this.name = name;
        this.description = description;
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
}
