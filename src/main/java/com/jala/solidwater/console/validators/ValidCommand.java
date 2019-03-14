package com.jala.solidwater.console.validators;

import com.jala.solidwater.console.models.Command;
import com.jala.solidwater.console.models.DefaultCommands;

/**
 * ValidCommand class will validate if the commands that entered are valid.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class ValidCommand implements IValidable<Command> {
    private DefaultCommands defaultCommands = new DefaultCommands();

    @Override
    public boolean validate(Command command) {
        boolean isCommandValid = false;
        if (command.getAcronym().startsWith("-")) {

            defaultCommands.createDefaultCommands();
            Command defaultComand = new Command();
            for (int i = 0; i < defaultCommands.getDefaultCommands().size(); i++) {
                 defaultComand = defaultCommands.getDefaultCommands().get(i);
                if (command.getAcronym().equals(defaultComand.getAcronym())) {
                    isCommandValid = true;
                    i = defaultCommands.getDefaultCommands().size();
                } else {
                    isCommandValid = isCommandValid;
                }
            }
        } else {
            isCommandValid = isCommandValid;
        }

       return isCommandValid;
    }
}
