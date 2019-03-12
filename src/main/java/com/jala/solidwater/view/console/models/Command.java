package com.jala.solidwater.view.console.models;

import java.util.ArrayList;
import java.util.List;

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
     * @return
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Set the acronym to a command.
     * @param acronym for the command as string.
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Return the command of
     * @return
     */
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

    /**
     * This class allows to create a command line.
     *
     * @author Areliez Vargas.
     * @version 0.0.1
     */
    public static class CommandLine {

        private List<Command> commands;
        private List<String> valueCommands;

        public CommandLine(List<Command> commands, List<String> valueCommands) {
            this.commands = new ArrayList<>();
            this.commands = commands;
            this.valueCommands = new ArrayList<>();
            this.valueCommands = valueCommands;
        }

        public List<Command> getCommands() {
            return commands;
        }

        public void setCommands(List<Command> commands) {
            this.commands = commands;
        }

        public List<String> getValueCommands() {
            return valueCommands;
        }

        public void setValueCommands(List<String> valueCommands) {
            this.valueCommands = valueCommands;
        }

        public Command getCommandByAcronym(String acronym) {
            Command command = new Command();
            for (int i = 0; i<getCommands().size(); i++) {
                command = commands.get(i);
                if (command.getAcronym().equals(acronym)) {
                    i = getCommands().size();
                }
            }
            return command;
        }
    }
}
