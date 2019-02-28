/*
 * @(#) Asset.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.search.models;

import java.io.File;

/**
 * Asset class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class Asset implements IAsset {
    private String path;
    private String fileName;
    private String extension;
    private boolean hidden;
    private String owner;
    private String size;
    private boolean readOnly;
    private String creationDate;
    private String modificationDate;
    private String lastDate;

    /**
     * Return the value of path as string.
     *
     * @return path as String.
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path as String.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return fileName of the file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName as String.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return extension of the file.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension as String.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return hidden for the file, that is a boolean value.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden as boolean value.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return owner of the file.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner as String value.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return size of the file.
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size as String value.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return readOnly as a property of file.
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly as boolean value.
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return creationDate as a property of file.
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate as String.
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return modificationDate as a property of file.
     */
    public String getModificationDate() {
        return modificationDate;
    }

    /**
     * @param modificationDate as String.
     */
    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * @return lastDate as a property of file.
     */
    public String getLastDate() {
        return lastDate;
    }

    /**
     * @param lastDate as String.
     */
    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    /**
     * @param file of the File class of java.
     */


}
