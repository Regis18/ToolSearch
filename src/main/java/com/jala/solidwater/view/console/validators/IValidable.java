package com.jala.solidwater.view.console.validators;

/**
 * This interface allows validate.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public interface IValidable {

    /**
     * this method allows validate a set of arguments.
     * @param argument
     * @return
     */
    boolean validate(String[] argument);
}
