package com.jala.solidwater.console;

import com.jala.solidwater.view.console.models.Command;
import com.jala.solidwater.view.console.models.CommandLine;
import com.jala.solidwater.view.console.validators.ValidCommandLine;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValidCommandLineTest {
    List<Command> commands;
    List<String> values;
   // CommandLine commandLine;
    @Before
    public void setup(){
        commands = new ArrayList<>();
        Command commandPath = new Command();
        commandPath.setAcronym("-p");
        Command commandFileName = new Command();
        commandFileName.setAcronym("-fn");
        commands.add(commandPath);
        commands.add(commandFileName);
        values = new ArrayList<>();
        String valuePath = "C:\\hola";
        String valueFileName = "hola";
        values.add(valuePath);
        values.add(valueFileName);
    }

    @Test
    public void validateCommandLine() {
        CommandLine commandLine = new CommandLine(commands, values);
        ValidCommandLine validCommandLine = new ValidCommandLine();
        assertEquals(true, validCommandLine.validate(commandLine));
    }

    @Test
    public void validateCommandLineWithoutCommandPath() {
        List<Command> commands1 = new ArrayList<>();

        Command commandFileName = new Command();
        commandFileName.setAcronym("-fn");

        commands1.add(commandFileName);
        List<String> values1 = new ArrayList<>();

        String valueFileName = "hola";

        values1.add(valueFileName);
        CommandLine commandLine = new CommandLine(commands1, values1);
        ValidCommandLine validCommandLine = new ValidCommandLine();
        assertEquals(false,validCommandLine.validate(commandLine));
    }
}
