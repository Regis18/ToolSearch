/**
 * @(#)ValidCommandTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.console;

import com.jala.solidwater.console.models.Command;
import com.jala.solidwater.console.validators.ValidCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ValidCommandTest {
    @Test
    public void validCommandSendingACommandValid() {
        Command command = new Command();
        command.setAcronym("-p");
        ValidCommand validateCommand = new ValidCommand();
        assertEquals(true, validateCommand.validate(command));
    }

    @Test
    public void validCommandSendingACommandThatNotExitInDefaultCommands() {
        Command command = new Command();
        command.setAcronym("-cut");
        ValidCommand validateCommand = new ValidCommand();
        assertNotEquals(true, validateCommand.validate(command));
    }

    @Test
    public void validCommandSendingACommandWithoutDash() {
        Command command = new Command();
        command.setAcronym("p");
        ValidCommand validateCommand = new ValidCommand();
        assertNotEquals(true, validateCommand.validate(command));
    }
}
