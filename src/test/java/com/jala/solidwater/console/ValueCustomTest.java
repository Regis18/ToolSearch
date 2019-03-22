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

import com.jala.solidwater.console.models.ValueCustom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValueCustomTest {

    private String valuePath;
    private String valueFileName;

    @Before
    public void setup(){

        valuePath = "'C:\\hola'";
        valueFileName = "'hola mundo'";
    }

    @Test
    public void removeTheCharacterOfValueWithSimpleQuotes() {
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals("C:\\hola",valueCustomTest.removeCharSpecial(valuePath, "'", 0));
    }

    @Test
    public void removeTheCharacterOfValueWithSimpleQuotesAndSpaceBetweenWords() {
        ValueCustom valueCustomTest = new ValueCustom();
        assertEquals("hola mundo",valueCustomTest.removeCharSpecial(valueFileName, "'", 0));
    }
}
