/**
 * @(#)ValidCommand.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

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

    /**
     * Create a instance of default commands.
     */
    private DefaultCommands defaultCommands = new DefaultCommands();

    /**
     * This method allows validate a command.
     *
     * @param command to validate.
     * @return true if command is valid and exist in default commands,
     * false if command isn't valid or not exist in default commands.
     */
    @Override
    public boolean validate(Command command) {
        boolean isCommandValid = false;
        if (command.getAcronym().startsWith("-")) {
            Command defaultCommand = new Command();
            for (int i = 0; i < defaultCommands.getDefaultCommands().size(); i++) {
                defaultCommand = defaultCommands.getDefaultCommands().get(i);
                if (command.getAcronym().equals(defaultCommand.getAcronym())) {
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
