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

    /**
     * The extension for the image to convert.
     */
    private String newExtension;

    /**
     * The new width for the image file to convert.
     */
    private int width;

    /**
     * The new height for the image file to convert.
     */
    private int height;

    private boolean percentage;

    private boolean resize;

    /**
     * Constructor that establishes the source and destination path of the file to perform a conversion.
     * @param pathOrigin of the file.
     * @param pathDestiny of the file.
     */
    public CriteriaConvertor(String pathOrigin, String pathDestiny, String newExtension) {
        super(pathOrigin);
        this.pathDestiny = pathDestiny;
        this.newExtension = newExtension;
        height = -1;
        percentage = false;
        resize = false;
    }

    /**
     * Returns the value of the file's destination path as a string.
     * @return path destiny as string.
     */
    public String getPathDestiny() {
        return pathDestiny;
    }

    /**
     * This method allows you to set the path of the destination by sending a string.
     * @param pathDestiny of the directory.
     */
    public void setPathDestiny(String pathDestiny) {
        this.pathDestiny = pathDestiny;
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
     * This method return the new width for the new image file.
     * @return the width of the image.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the new width for the new image file.
     * @param width of the new image file.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * This method return the new height of the new image file.
     * @return the height of the new image file.
     */
    public int getHeight() {
        return height;
    }

    /**
     * set the new height  for the new image file.
     * @param height for the new image file.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isPercentage() {
        return percentage;
    }

    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }

    public boolean isResize() {
        return resize;
    }

    public void setResize(boolean resize) {
        this.resize = resize;
    }
}
