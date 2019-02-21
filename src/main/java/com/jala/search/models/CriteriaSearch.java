/**
 * @(#)CriteriaSearch.java Copyright (c) 2019 Jala Foundation.
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

/**
 * The CriteriaSearch class is to set and get the criterias to search.
 * @version 0.0.1
 * @author Areliez Vargas
 */
public class CriteriaSearch {

    /**
     * Criteria for path of the directory.
     */
    private String path;
    /**
     * Criteria for the file name of the directory.
     */
    private String fileName;

    /**
     * Constructor that setting the path for then do a search.
     * @param path
     */
    public CriteriaSearch(String path) {
        this.path = path;
    }

    /**
     *
     * @return the string path set.
     */
    public String getPath() {
        return path;
    }

    /**
     * This method allows to set the path sending a string.
     * @param path of the directory.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *
     * @return the file name.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName of the directory.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}