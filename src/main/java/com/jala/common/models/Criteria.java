/*
 * @(#) Criteria.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.common.models;

/**
 * The Criteria class.
 *
 * @author Luis Guardia
 * @version 0.0.1
 */
public abstract class Criteria {

    /**
     * Criteria for the absolute path of the file.
     */
    private String path;

    /**
     * Criteria for the file name.
     */
    private String fileName;

    /**
     * Criteria Extension of the file.
     */
    private String extension;


    /**
     * Constructor that sets the absolute path of the file .
     *
     * @param path of the file.
     */
    public Criteria(String path) {
        this.path = path;
    }

    /**
     * Constructor Criteria class, without arguments.
     */
    public Criteria() {
    }

    /**
     * Return the path of the file.
     *
     * @return path origin as string.
     */
    public String getPath() {
        return path;
    }

    /**
     * This method allows set the path origin of the file.
     *
     * @param path of file.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Return the extension of the file.
     *
     * @return extension as string.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * This method allows set the extension of the file.
     *
     * @param extension of file.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Return the file name.
     *
     * @return file name as string.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method allows to set the file name.
     *
     * @param fileName for the name of the file.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
