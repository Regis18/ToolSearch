package com.jala.solidwater.view.console.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows to create a command line.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class CommandLine {

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
}
