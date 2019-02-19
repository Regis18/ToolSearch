/**
 * @(#)File.java Copyright (c) 2019 Jala Foundation.
2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
All rights reserved.
 *
 * This software is the confidential and proprietary information of
Jala Foundation, ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with Jala Foundation.
 */

package com.jala.seacrh.models;

import java.io.File;

/**
 * SearchFile class
 * @version 0.0.1
 * @author Areliez Vargas
 */
public class SearchFile implements Searchable{

    /**
     * This method return files that content the folder of a path.
     * @param path the path the folder.
     * @return a array of the files that content the folder.
     */
   @Override
    public File[] searchByPath(String path){
        File folder = new File(path);
        File[] findFiles = new File[0];
        if (folder.exists()){
            findFiles = folder.listFiles();
            for (int i = 0; i < findFiles.length; i++) {
                if(findFiles[i].isDirectory() || findFiles[i].isFile()) {
                    findFiles[i].getAbsoluteFile();
                }
            }
        }
        return findFiles;
    }
}
