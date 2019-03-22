/**
 * @(#)ValueCustom.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jala.solidwater.console.models;

/**
 * ValueCustom class allows remove a character of a string.
 */
public class ValueCustom {

    /**
     * Constant for error message when entering string with length less that two.
     */
    public static final String ERROR_TO_LENGTH_LESS_THAN_2 = "Enter a String with length greater equals than 2";

    /**
     * Constant for error message when entering string with length less that one.
     */
    public static final String ERROR_FOR_LENGTH_LESS_THAN_1 = "Enter a String with length greater equals than 1";

    /**
     * Constant for error message when entering condicion no valid.
     */
    public static final String ERROR_FOR_CONDITIONS = "Enter 1 or 0";

    /**
     * This method allows remove an specific character of a string.
     *
     * @param value             of string to delete a specific character.
     * @param characterToRemove the character that will be deleted of the string.
     * @param condition         value that define that coincidences will be deleted.
     *                          0 to delete all coincidences of a string.
     *                          1 to remove only the start and end of a string.
     * @return a string without the character that was sent to delete.
     */
    public String removeCharSpecial(String value, String characterToRemove, int condition) {
        String valueWithoutChars = "";
        if (condition == 0 || condition == 1) {
            if (condition == 0 && value.length() >= 2) {
                if (value.startsWith(characterToRemove) && value.endsWith(characterToRemove)) {
                    valueWithoutChars = value.substring(1, value.length() - 1);
                }
            } else if (condition == 0 && value.length() < 2) {
                valueWithoutChars = ERROR_TO_LENGTH_LESS_THAN_2;
            } else if (condition == 1 && value.length() >= 1) {
                String newValue = "";
                valueWithoutChars = value.replace(characterToRemove, newValue);
            } else if (condition == 1 && value.length() < 1) {
                valueWithoutChars = ERROR_FOR_LENGTH_LESS_THAN_1;
            }
        } else {
            valueWithoutChars = ERROR_FOR_CONDITIONS;
        }
        return valueWithoutChars;
    }
}
