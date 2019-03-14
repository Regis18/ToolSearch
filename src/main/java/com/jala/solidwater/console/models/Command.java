/**
 * @(#) Command.java Copyright (c) 2019 Jala Foundation.
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

/**
 * This class allows to create a command customized.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class Command {

    /**
     * Acronym of a command.
     */
    private String acronym;

    /**
     * Name of a command.
     */
    private String name;

    /**
     * Description of a command.
     */
    private String description;

    /**
     * This method creates a command without to send parameters.
     */
    public Command() {
    }

    /**
     * Constructor method of Command class.
     * This method create a instance of Command.
     *
     * @param acronym     for the command
     * @param name        for the  command
     * @param description for the  command
     */
    public Command(String acronym, String name, String description) {
        this.acronym = acronym;
        this.name = name;
        this.description = description;
    }

    /**
     * Return the acronym of a command.
     *
     * @return acronym as string.
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Set the acronym to a command.
     *
     * @param acronym for the command as string.
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Return the command name.
     *
     * @return name as string.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the command name.
     *
     * @param name for the command as string.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the command description.
     *
     * @return the description as string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description for a command.
     *
     * @param description for the command as string.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

