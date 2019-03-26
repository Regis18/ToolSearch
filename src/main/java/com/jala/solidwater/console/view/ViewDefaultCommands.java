package com.jala.solidwater.console.view;

import com.jala.solidwater.console.models.Command;

import java.util.List;

public class ViewDefaultCommands {

    public void printCommands(List<Command> defaultCommands) {

        System.out.println("These are common commands used to do the search:");
        System.out.printf("%-10s %-30s %-20s\n" , "Acronym", "Command name", "Description");
        for (int i = 0; i < defaultCommands.size(); i++) {
            Command defaultCommand = defaultCommands.get(i);
           // System.out.format("%-10s %-10s %-10s\\n", defaultCommand.getAcronym()  + defaultCommand.getName() + defaultCommand.getDescription());
            System.out.printf("%-10s %-30s %-20s\n" , defaultCommand.getAcronym(), defaultCommand.getName(), defaultCommand.getDescription());
        }
    }
}
