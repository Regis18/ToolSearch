package com.jala.solidwater.view.console.validators;

import com.jala.solidwater.view.console.models.Command;
import com.jala.solidwater.view.console.models.DefaultCommands;

/**
 * ValidateCommand class will validate if the commands that entered are valid.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class ValidateCommand implements IValidable<Command> {
    private DefaultCommands defaultCommands;

    @Override
    public boolean validate(Command argument) {
       return false;
    }


}
