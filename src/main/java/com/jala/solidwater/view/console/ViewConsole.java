/*
 * @(#)CriteriaSearch.java
 *
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.view.console;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;

/**
 * ViewConsole class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ViewConsole {

    /**
     * @param files are all files for be displayed into a table for console.
     */
    public void testShow (List<File> files){

        for (int i = 0; i < files.size() ; i++) {

            File file = files.get(i);
            File path = files.get(i);
            String name = files.get(i).getName();
            String extension = FilenameUtils.getExtension(files.get(i).getAbsolutePath());

            System.out.format("%d | %s | %s | %s%n", i, file.getName(), path, extension);
        }
    }

    /**
     * Test method for show a simulate of table.
     */
   /* public void testShow () {
        for (int i = 0; i < 10 ; i++) {
            System.out.format("%d | %s | %s | %s%n", i, "path", "name", "extension");
        }
    }*/
}
