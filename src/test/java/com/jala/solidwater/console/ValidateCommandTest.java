package com.jala.solidwater.console;

import com.jala.solidwater.view.console.models.Command;
import com.jala.solidwater.view.console.validators.ValidateCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ValidateCommandTest {
    @Test
    public void validCommandSendingACommandValid() {
        Command command = new Command();
        command.setAcronym("-p");
        ValidateCommand validateCommand = new ValidateCommand();
        assertEquals(true, validateCommand.validate(command));
    }

    @Test
    public void validCommandSendingACommandNotValid() {
        Command command = new Command();
        command.setAcronym("-cut");
        ValidateCommand validateCommand = new ValidateCommand();
        assertNotEquals(true, validateCommand.validate(command));
    }

    @Test
    public void validCommandSendingACommandWithoutGuion() {
        Command command = new Command();
        command.setAcronym("p");
        ValidateCommand validateCommand = new ValidateCommand();
        assertNotEquals(true, validateCommand.validate(command));
    }
}
