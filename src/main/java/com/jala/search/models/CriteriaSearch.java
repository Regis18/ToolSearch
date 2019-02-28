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
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class CriteriaSearch {

    /**
     * Criteria for path of the directory.
     */
    private String path;

    /**
     * Criteria for the file name.
     */
    private String fileName;

    /**
     * Criteria for extension of file.
     */
    private String extension;

    /**
     * Criteria for hidden of file.
     */
    private TernaryBooleanEnum hidden;

    /**
     * Criteria for read only of file.
     */
    private TernaryBooleanEnum readOnly;

    /**
     * Type of criteria (video, audi, image, common, etc).
     */
    private int type;

    /**
     * Constructor that setting the path for then do a search.
     * @param path of the directory.
     */
    public CriteriaSearch(String path) {
        this.path = path;
        fileName = "";
        extension = "";
        setHidden(TernaryBooleanEnum.ALL);
        setReadonly(TernaryBooleanEnum.ALL);
        type = 0;
    }

    /**
     * Return the path of the directory as string.
     * @return the string of the path.
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
     * Return the value of file name as string.
     * @return file name as string.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method allows to set the file name sending a string.
     * @param fileName of the file.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Return the value of extension of a file.
     * @return the extension as string.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * This method allows to set the file extension sending a string.
     * @param extension of the file.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Return the values of hidden of a file.
     * @return the hidden property of the file.
     */
    public TernaryBooleanEnum getHidden() {
        return hidden;
    }

    /**
     * This method allows to set the hidden criteria for the file search.
     * @param hidden the value to use of the search.
     */
     public void setHidden(TernaryBooleanEnum hidden) {
        this.hidden = hidden;
    }

    /**
     * Get the type of search
     * @return The type of search used
     */
    public int getType() {
        return type;
    }

    /**
     * Set the type of search perfomed.
     * @param type The type of search used
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Get the Readonly file status criteria.
     * @return the readonly criteria used
     */
    public TernaryBooleanEnum getReadonly() {
        return readOnly;
    }

    /**
     * Set the readonly file status criteria.
     * @param readOnly the redonly criteria used
     */
    public void setReadonly(TernaryBooleanEnum readOnly) {
        this.readOnly = readOnly;
    }
}
