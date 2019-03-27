/**
 * @(#)ValidValueOfCommand.java Copyright (c) 2019 Jala Foundation.
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

/**
 * ValidValueOfCommand class to validate the value of command.
 */
public class ValidValueOfCommand implements IValidable<String> {
    /**
     * Save the error message.
     */
    private String message = "";

    /**
     * Return message to print in console.
     *
     * @return message as string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message to print in console.
     *
     * @param message for the error.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method allows validate a command line.
     *
     * @param valueOfCommand to validate.
     * @return true if the the value start and finish with single quotes
     * and false if the value doesn't start with single quotes
     * or start with dash.
     */
    @Override
    public boolean validate(String valueOfCommand) {
        boolean isValid = false;
        if (valueOfCommand.startsWith("'") && valueOfCommand.endsWith("'")) {
            isValid = true;
        } else if (valueOfCommand.startsWith("-") || !valueOfCommand.startsWith("'") && !valueOfCommand.endsWith("'")) {
            setMessage("The value for the command shouldn't start with -");
            isValid = isValid;
        }
        return isValid;
    }
}
