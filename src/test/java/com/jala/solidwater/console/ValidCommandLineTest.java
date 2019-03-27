/**
 * @(#)ValidCommandLineTest.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.solidwater.console.models.CommandLine;
import com.jala.solidwater.console.validators.ValidCommandLine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidCommandLineTest {
    private String commandPath;
    private String commandFileName;
    private String valuePath;
    private String valueFileName;

    @Before
    public void setup(){
        commandPath = "-p";
        commandFileName = "-fn";
        valuePath = "'C:\\hola'";
        valueFileName = "'hola'";
    }

    @Test
    public void validateCommandLineSendingArrayPair() {
        String[] inputForCommandLine = {commandPath, valuePath};
        CommandLine commandLine = new CommandLine(inputForCommandLine);
        ValidCommandLine validCommandLine = new ValidCommandLine();
        assertEquals(true, validCommandLine.validate(commandLine));
    }

    @Test
    public void validateCommandLineWithoutCommandPath() {
        String[] inputForCommandLine = {commandFileName, valueFileName};
        CommandLine commandLine = new CommandLine(inputForCommandLine);
        ValidCommandLine validCommandLine = new ValidCommandLine();
        assertEquals(false,validCommandLine.validate(commandLine));
        assertEquals("The command -p is required",validCommandLine.getMessage());
    }

    @Test
    public void validateCommandLineWithSendingArrayNotValid() {
        String[] inputForCommandLine = {commandPath, valuePath, commandFileName, "hola"};
        CommandLine commandLine = new CommandLine(inputForCommandLine);
        ValidCommandLine validCommandLine = new ValidCommandLine();
        assertEquals(false,validCommandLine.validate(commandLine));
        assertEquals("The command line isn't valid you can use -help",validCommandLine.getMessage());
    }
}
