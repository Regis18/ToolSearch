/*
 * @(#) CriteriaConvertor.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.convertor.models;

import com.jala.common.models.Criteria;

/**
 * The CriteriaConvertor class is used to establish and obtain the conversion criteria.
 * @version 0.0.1
 * @author Luis Guardia
 */
public class CriteriaConvertor extends Criteria {

    /**
     * Criteria for path destiny of the file.
     */
    private String pathDestiny;

    /**
     * It is characteristic for add a new file name to the converted stuff
     */
    private String newFileName;

    private String newExtension;

    /**
     * Constructor that establishes the source and destination path of the file to perform a conversion.
     *
     * @param pathOrigin of the file.
     * @param pathDestiny of the file.
     */
    public CriteriaConvertor( String pathOrigin, String pathDestiny) {
        super(pathOrigin);
        this.pathDestiny = pathDestiny;
    }

    /**
     * Returns the value of the file's destination path as a string.
     * @return path destiny as string.
     */
    public String getPathDestiny() {
        return pathDestiny;
    }

    /**
     * This method allows you to set the path of the destination by sending a string..
     * @param pathDestiny of the directory.
     */
    public void setPathDestiny(String pathDestiny) {
        this.pathDestiny = pathDestiny;
    }

    /**
     * @return the content of newFileName
     */
    public String getNewFileName() {
        return newFileName;
    }

    /**
     * Set the new file with configuration of the user
     * @param newFileName
     */
    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getNewExtension() {
        return newExtension;
    }

    public void setNewExtension(String newExtension) {
        this.newExtension = newExtension;
    }
}
