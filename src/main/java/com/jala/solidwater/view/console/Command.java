package com.jala.solidwater.view.console;

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
     * Desciption of a command.
     */
    private String description;

    /**
     * this method creates a command without to send parameters.
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

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
