/*
 * @(#) CriteriaConverter.java Copyright (c) 2019 Jala Foundation.
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
 * The CriteriaConverter class is used to establish and obtain the conversion criteria.
 * @version 0.0.1
 * @author Luis Guardia
 */
public class CriteriaConverter extends Criteria {

    /**
     * Criteria for path destiny of the file.
     */
    private String pathDestination;

    /**
     * It is characteristic for add a new file name to the converted stuff
     */
    private String newFileName;

    /**
     * The extension for the image to convert.
     */
    private String newExtension;

    /**
     * Constructor that establishes the source and destination path of the file to perform a conversion.
     * @param pathOrigin of the file.
     * @param pathDestiny of the file.
     */
    public CriteriaConverter(String pathOrigin, String pathDestiny, String newExtension) {
        super(pathOrigin);
        this.pathDestination = pathDestiny;
        this.newExtension = newExtension;
        newFileName = "";
    }

    /**
     * Returns the value of the file's destination path as a string.
     * @return path destiny as string.
     */
    public String getPathDestination() {
        return pathDestination;
    }

    /**
     * This method allows you to set the path of the destination by sending a string.
     * @param pathDestiny of the directory.
     */
    public void setPathDestination(String pathDestiny) {
        this.pathDestination = pathDestiny;
    }

    /**
     * This method return the new file name to convert.
     * @return the content of newFileName.
     */
    public String getNewFileName() {
        return newFileName;
    }

    /**
     * Set the new file with configuration of the user.
     * @param newFileName for name of new image file.
     */
    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    /**
     * This method return the new extension to convert an image.
     * @return the extension for the new image file.
     */
    public String getNewExtension() {
        return newExtension;
    }

    /**
     * Set the new extension to convert the image file.
     * @param newExtension for the new image file.
     */
    public void setNewExtension(String newExtension) {
        this.newExtension = newExtension;
    }

    /**
     * This method return the path absolute for the new image file.
     * @return the path absolute for new image file as string.
     */
    public String getPathAbsoluteNewFile() {
        String pathAbsoluteNewImage = getPathDestination() + getNewFileName() + getNewExtension();
        return pathAbsoluteNewImage;
    }

}
