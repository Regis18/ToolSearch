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
     * This method allows remove an specific character of a string.
     * @param value of string to delete a specific character.
     * @param characterToRemove the character that will be deleted of the string.
     * @param valueToRemoveChar value that define if all coincidences will be deleted
     * or only the start and final of the value.
     * When 0 is to delete all coincidences and 1 to remove only the start and final of the value.
     * @return a string without the character that was sent to delete.
     */
    public String removeCharSpecial(String value, String characterToRemove, int valueToRemoveChar) {
        String valueWithoutChars = "";
        if (valueToRemoveChar == 0 && value.length() > 2) {
            String newValue1 = " ";
            valueWithoutChars = value.replace(characterToRemove, newValue1).trim();
        }
        return valueWithoutChars;
    }
}
