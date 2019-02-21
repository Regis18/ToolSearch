/**
 * @(#)SearchFile.java Copyright (c) 2019 Jala Foundation.
2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
All rights reserved.
 *
 * This software is the confidential and proprietary information of
Jala Foundation, ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with Jala Foundation.
 */

package com.jala.search.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SearchFile class
 * @version 0.0.1
 * @author Areliez Vargas
 */
public class SearchFile implements ISearchable {

    /**
     * This method return files that content the folder of a path.
     * @param path the path the folder.
     * @return a array of the files that content the folder.
     */
   @Override
    public File[] searchByPath(String path){
        File folder = new File(path);
        File[] findFiles = new File[0];
        File file;
        if (folder.exists()){
            findFiles = folder.listFiles();
        }
        return findFiles;
    }

    @Override
    public List<File> searchByName(String name) {
        File folder = new File("C:\\hola");

        List<File> filesByName = new ArrayList<>();
        if (folder.exists()){
            File[] findFiles = folder.listFiles();
            List<File> filesOfDir = Arrays.asList(findFiles);
            for (int i = 0; i < filesOfDir.size(); i++) {
                File file = findFiles[i];
                if(file.isFile() && file.getName().contains(name)) {
                    file = findFiles[i];
                    filesByName.add(file);
                    filesByName = filesByName;
                } else {
                  //  searchByName(file.getName());
                    //filesByName.addAll(searchByName(file.getName()));
                    filesByName = filesByName;
                }
            }
        }
        return filesByName;
    }

}
