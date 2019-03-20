/**
 * @(#)ValidInputParameters.java Copyright (c) 2019 Jala Foundation.
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
 * ValidInputParameters class to validate the arguments that are sent from console.
 */
public class ValidInputParameters implements IValidable<String[]> {

    /**
     * Message to show if there is a error.
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

    @Override
    public boolean validate(String[] inputParameters) {
        boolean isValidInputParameters = false;
        if (inputParameters.length > 0 && (inputParameters.length % 2) == 0) {
            isValidInputParameters = true;
        } else if ( inputParameters.length > 0 && inputParameters.length % 2 != 0) {
            isValidInputParameters = isValidInputParameters;
            setMessage("you enterd a command line invalid");
        } else if (inputParameters.length == 1) {
            isValidInputParameters = isValidInputParameters;
            setMessage("invalid");
        }
        return isValidInputParameters;
    }
}
