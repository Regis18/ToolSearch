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
 *
 * @author Luis Guardia
 * @version 0.0.1
 */
public class CriteriaConvertor extends Criteria {

    /**
     * Criteria for the absolute path of the file.
     */
    private String pathOrigin;

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

    /**
     * Value that define if the conversion will be by percentage or pixel.
     */
    private boolean percentage;

    /**
     * Value that define if the conversion will apply resize.
     */
    private boolean resize;

    /**
     * Value that define if the resize will maintain the proportion.
     */
    private boolean maintainProportion;

    /**
     * Constructor that establishes the source and destination path of the file to perform a conversion.
     *
     * @param pathOrigin  of the file.
     * @param pathDestiny of the file.
     */
    public CriteriaConvertor(String pathOrigin, String pathDestiny, String newExtension) {
        super(pathOrigin);
        this.pathDestiny = pathDestiny;
        this.newExtension = newExtension;
        newFileName = "";
        height = -1;
        width = -1;
        percentage = false;
        resize = false;
        maintainProportion = false;
    }

    /**
     * Return the value of the path origin file for convert.
     *
     * @return pathOrigin path file for convert.
     */
    public String getPathOrigin() {
        return pathOrigin;
    }

    /**
     * This method allows you to set the path origin file for convert.
     *
     * @param pathOrigin set file path for convert.
     */
    public void setPathOrigin(String pathOrigin) {
        this.pathOrigin = pathOrigin;
    }

    /**
     * Returns the value of the file's destination path as a string.
     *
     * @return path destiny as string.
     */
    public String getPathDestiny() {
        return pathDestiny;
    }

    /**
     * This method allows you to set the path of the destination by sending a string.
     *
     * @param pathDestiny of the directory.
     */
    public void setPathDestiny(String pathDestiny) {
        this.pathDestiny = pathDestiny;
    }

    /**
     * This method return the new file name to convert.
     *
     * @return the content of newFileName.
     */
    public String getNewFileName() {
        return newFileName;
    }

    /**
     * Set the new file with configuration of the user.
     *
     * @param newFileName for name of new image file.
     */
    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    /**
     * This method return the new extension to convert an image.
     *
     * @return the extension for the new image file.
     */
    public String getNewExtension() {
        return newExtension;
    }

    /**
     * Set the new extension to convert the image file.
     *
     * @param newExtension for the new image file.
     */
    public void setNewExtension(String newExtension) {
        this.newExtension = newExtension;
    }

    /**
     * This method return the new width for the new image file.
     *
     * @return the width of the image.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the new width for the new image file.
     *
     * @param width of the new image file.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * This method return the new height of the new image file.
     *
     * @return the height of the new image file.
     */
    public int getHeight() {
        return height;
    }

    /**
     * set the new height  for the new image file.
     *
     * @param height for the new image file.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * This method return if resize will be by percentage.
     *
     * @return true to apply resize by percentage and false to apply resize by pixel.
     */
    public boolean isPercentage() {
        return percentage;
    }

    /**
     * Set if the resize will be by percentage.
     *
     * @param percentage to convert by percentage.
     */
    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }

    /**
     * This method return if the conversion will be resize.
     *
     * @return true to resize the image, and false to doesn't resize.
     */
    public boolean isResize() {
        return resize;
    }

    /**
     * Set if the conversion will be the resize.
     *
     * @param resize to change the resize.
     */
    public void setResize(boolean resize) {
        this.resize = resize;
    }

    /**
     * Return if the resize will maintain the proportion.
     *
     * @return true to maintain the aspect ratio and resize and
     * false to disregard aspect ratio and resize to exact/specific dimensions.
     */
    public boolean isMaintainProportion() {
        return maintainProportion;
    }

    /**
     * Set if aspect ratio and resize will change to exact/specific dimensions.
     *
     * @param maintainProportion for maintain the proportion.
     */
    public void setMaintainProportion(boolean maintainProportion) {
        this.maintainProportion = maintainProportion;
    }

    /**
     * This method return the path absolute for the new image file.
     *
     * @return the path absolute for new image file as string.
     */
    public String getPathAbsoluteNewFile() {
        String pathAbsoluteNewImage = getPathDestiny() + getNewFileName() + getNewExtension();
        return pathAbsoluteNewImage;
    }
}
