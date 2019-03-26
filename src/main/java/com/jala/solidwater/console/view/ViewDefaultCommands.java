package com.jala.solidwater.console.view;

import com.jala.solidwater.console.models.Command;

import java.util.List;

public class ViewDefaultCommands {

    public void printCommands(List<Command> defaultCommands) {

        for (int i = 0; i < defaultCommands.size(); i++) {
            Command defaultCommand = defaultCommands.get(i);
            System.out.println(defaultCommand.getAcronym() + " " + defaultCommand.getName() + " " + defaultCommand.getDescription());
        }
    }
}
