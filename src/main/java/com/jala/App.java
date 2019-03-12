/**
 * @(#)App.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jala;

import com.jala.utils.AssetLoadVideoAudio;

/**
 * App
 *
 * @version 0.0.1
 * @author Regis Humana
 */
public class App {

    /** Create a variable of Run*/
    private static Run runApp;

    /**
     * Executes the program
     * @param args
     */
    public static void main(String [] args) {
        runApp = new Run();
    }
}
