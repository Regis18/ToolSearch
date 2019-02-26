/**
 * @(#)SearchFile.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.search.models;

import com.jala.utils.Logs;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SearchFile class
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class SearchFile implements ISearchable {

    /**
     * This method return a file list by attributes of criteria.
     * @param criteria to do the search with the path is required and other attributes are optional.
     * @return a list of the files that content the folder set in the path of criteria.
     */
    @Override
    public List<File> search(CriteriaSearch criteria) {
        File folder = new File(criteria.getPath());
        List<File> filesResult = new ArrayList<>();
        if (folder.exists()) {
            File[] findFiles = folder.listFiles();
            List<File> files = Arrays.asList(findFiles);
            try {
                for (int i = 0; i < files.size(); i++) {
                    File file = files.get(i);
                    if (file.isFile()) {
                        String nameFile = file.getName();
                        String extensionFile = FilenameUtils.getExtension(nameFile);
                        String nameCriteria = criteria.getFileName();
                        String extensionCriteria = criteria.getExtension();
                        boolean hiddenCriteria = criteria.isHidden();
                       // var auxiliar.
                        boolean hidden = true;
                        if (hiddenCriteria && !file.isHidden() || !hiddenCriteria && file.isHidden()) {
                            hidden=false;
                        }
                        if (!nameCriteria.isEmpty() && !nameFile.contains(nameCriteria)) {
                            hidden = false;
                        }
                        if (!extensionCriteria.isEmpty() && !extensionFile.equals(extensionCriteria) ) {
                            hidden = false;
                        }
                        if (hidden) {
                            filesResult.add(file);
                        }
                    } else if (file.isDirectory()) {
                        //TODO recursion to get files of folder
                        filesResult = filesResult;
                    }
                }
            } catch (NullPointerException e) {
                Logs.getInstance().getLog().error("The criteria values shouldn't be null",e);
            }
        }
        return filesResult;
    }
}
