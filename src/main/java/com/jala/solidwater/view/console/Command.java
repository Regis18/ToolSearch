/**
 * Command class manage the commands that the SolidWater app use for console
 **/
package com.jala.solidwater.view.console;

public class Command {
    private String name, acronym, description, value;

    public Command(String name, String acronym, String description) {
        this.name = name;
        this.acronym = acronym;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }
}
