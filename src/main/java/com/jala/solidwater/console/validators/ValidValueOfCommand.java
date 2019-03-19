package com.jala.solidwater.console.validators;

public class ValidValueOfCommand implements IValidable<String> {
    private String message = "";

    public String getMessage() {
        return message;
    }

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
        } else if (valueOfCommand.startsWith("-") || !valueOfCommand.startsWith("'")) {
            setMessage("The value for the command shouldn't start with -");
            isValid = isValid;
        }
        return isValid;
    }
}
