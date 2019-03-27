/**
 * @(#)ValueCustomTest.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.utils.ValueCustom;
import org.junit.Before;
import org.junit.Test;

import static com.jala.utils.ValueCustom.ERROR_FOR_CONDITIONS;
import static com.jala.utils.ValueCustom.ERROR_FOR_LENGTH_LESS_THAN_1;
import static com.jala.utils.ValueCustom.ERROR_FOR_LENGTH_LESS_THAN_2;
import static org.junit.Assert.assertEquals;

/**
 * Class to unit test of Value custom.
 */
public class ValueCustomTest {

    /**
     * Constant to do the assert.
     */
    private static final String VALUE_RESULT = "Hello world";

    /**
     * Value with character to the start and end string.
     */
    private String valueWithCharacterToTheStarAndEndInString;

    /**
     * Value with character to the start and end string and between words.
     */
    private String valueWithCharacterBetweenWords;

    /**
     * Initialize the values before start the test.
     */
    @Before
    public void setup() {

        valueWithCharacterToTheStarAndEndInString = "'Hello world'";
        valueWithCharacterBetweenWords = "'Hello 'wor'ld'";
    }

    /**
     * Verify that the characters will be removed to the start and end of a string.
     */
    @Test
    public void removeTheCharactersToTheStartAndEndString() {
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals(VALUE_RESULT, valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 0));
    }

    /**
     * Verify that the characters will be removed with spaces between words.
     */
    @Test
    public void removeTheCharactersWithSpaceBetweenWords() {
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals(VALUE_RESULT, valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 0));
        assertEquals(VALUE_RESULT, valueCustomTest.removeCharacter(valueWithCharacterBetweenWords, "'", 1));
    }

    /**
     * Verify that all coincidence will be removed.
     */
    @Test
    public void removeAllCoincidenceOfCharacter() {
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals(VALUE_RESULT, valueCustomTest.removeCharacter(valueWithCharacterBetweenWords, "'", 1));
    }

    /**
     * Verify that characters will be removed in a string with length equals to 2.
     */
    @Test
    public void removeCharacterOfValueWithLengthEqualsTo2() {
        valueWithCharacterToTheStarAndEndInString = "''";
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals("", valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 1));
        assertEquals("", valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 0));
    }

    /**
     * Verify that characters will be removed in a string with length equals to 1.
     */
    @Test
    public void removeTheCharacterOfValueWithLengthEqualsTo1() {
        valueWithCharacterToTheStarAndEndInString = "'";
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals(ERROR_FOR_LENGTH_LESS_THAN_2, valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 0));
        assertEquals("", valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 1));
    }

    /**
     * Verify an error message for string with length equals to 0.
     */
    @Test
    public void removeTheCharacterOfValueWithLengthEqualsTo0() {
        valueWithCharacterToTheStarAndEndInString = "";
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals(ERROR_FOR_LENGTH_LESS_THAN_2, valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 0));
        assertEquals(ERROR_FOR_LENGTH_LESS_THAN_1, valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 1));
    }

    /**
     * Verify that characters will be removed in a string that contains only spaces.
     */
    @Test
    public void removeTheCharacterOfValueOnlyWithSpace() {
        valueWithCharacterToTheStarAndEndInString = "'  '";
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals("  ", valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 0));
        assertEquals("  ", valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 1));
    }

    /**
     * Verify that characters will be removed in a string that contains spaces in the end.
     */
    @Test
    public void removeTheCharacterOfValueWithSpaceInTheEndOfWord() {
        valueWithCharacterToTheStarAndEndInString = "'Hello' '";
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals("Hello' ", valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 0));
        assertEquals("Hello ", valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 1));
    }

    /**
     * Verify that the error message when enter a condition no valid.
     */
    @Test
    public void removeTheCharacterSendingInvalidValueToRemove() {
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals(ERROR_FOR_CONDITIONS, valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", -1));
        assertEquals(ERROR_FOR_CONDITIONS, valueCustomTest.removeCharacter(valueWithCharacterToTheStarAndEndInString, "'", 3));
    }
}
