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
