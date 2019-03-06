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
 * The CriteriaSearch class is to set and get the criteria to search.
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
    public TernaryBooleanEnum hidden;

    /**
     * Criteria for read only of file.
     */
    public TernaryBooleanEnum readonly;

    /**
     * Criteria for size of file.
     */
    private String size;

    /**
     * Criteria for size greater than or less than.
     */
    private boolean sizeCompareOption;

    /**
     * Criteria for owner of file.
     */
    private String owner;

    /**
     * Criteria for creation date file.
     */
    private String creationDateFrom;
    private String creationDateTo;

    /**
     * Criteria for modification date file.
     */
    private String modificationDateFrom;
    private String modificationDateTo;

    /**
     * Criteria for last date file.
     */
    private String lastDateFrom;
    private String lastDateTo;

    /**
     * Type of criteria (video, audi, image, common, etc).
     */
    private int type;

    /**
     * Constructor of class CriteriaSearch.
     */
    public void CriteriaSearch() {
    this.setHidden(TernaryBooleanEnum.ALL);
    this.setReadonly(TernaryBooleanEnum.ALL);
    this.setSize("");
    this.setCreationDateFrom("");
    this.setCreationDateTo("");
    this.setModificationDateFrom("");
    this.setModificationDateTo("");
    this.setLastDateFrom("");
    this.setLastDateTo("");
    this.setOwner("");
    this.setFileName("");
    this.setExtension("");
}
    /**
     * Constructor that setting the path for then do a search.
     * @param path of the directory.
     */
    public CriteriaSearch(String path) {
        this.CriteriaSearch();
        this.path = path;
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
     * Get the type of search.
     * @return The type of search used.
     */
    public int getType() {
        return type;
    }

    /**
     * Set the type of search performed.
     * @param type The type of search used.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Get the Readonly file status criteria.
     * @return the readonly criteria used.
     */
    public TernaryBooleanEnum getReadonly() {
        return readonly;
    }

    /**
     * Set the readonly file status criteria.
     * @param readonly the readonly criteria used.
     */
    public void setReadonly(TernaryBooleanEnum readonly) {
        this.readonly = readonly;
    }

    /**
     * Get the size file status criteria.
     * @return the size criteria used.
     */
    public String getSize() {
        return size;
    }

    /**
     * Set the size file status criteria.
     * @param size the size criteria used.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Get the owner file status criteria.
     * @return the owner criteria used.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Get the size greater or less than.
     * @return a boolean value is es true is greater than and is
     * false is less than.
     */
    public boolean isSizeCompareOption() {
        return sizeCompareOption;
    }

    /**
     * Set de boolean value for size compare option.
     * @param sizeCompareOption can be true for is greater than and is
     * false for less than.
     */
    public void setSizeCompareOption(boolean sizeCompareOption) {
        this.sizeCompareOption = sizeCompareOption;
    }

    /**
     * Set the owner file criteria.
     * @param owner the owner of file.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get creation date Initial of search file.
     * @return the date initial for a Search a creation date.
     */
    public String getCreationDateFrom() {
        return creationDateFrom;
    }

    /**
     * Set creation date Initial of search file.
     * @param creationDateFrom the date initial for a Search a creation date.
     */
    public void setCreationDateFrom(String creationDateFrom) {
        this.creationDateFrom = creationDateFrom;
    }

    /**
     * Get creation date Final of search file.
     * @return the date final for a Search a creation date.
     */
    public String getCreationDateTo() {
        return creationDateTo;
    }

    /**
     * Set creation date final of search file.
     * @param creationDateTo the date final for a Search a creation date.
     */
    public void setCreationDateTo(String creationDateTo) {
        this.creationDateTo = creationDateTo;
    }

    /**
     * Get the date for a search of file with modification date initial.
     * @return The date initial for a modification date of file.
     */
    public String getModificationDateFrom() {
        return modificationDateFrom;
    }

    /**
     * Set the date for a search of file with modification date initial.
     * @param modificationDateFrom the date for initial modification date of file.
     */
    public void setModificationDateFrom(String modificationDateFrom) {
        this.modificationDateFrom = modificationDateFrom;
    }

    /**
     * Get the date for a search of file with modification date final.
     * @return The date final for a modification date of file.
     */
    public String getModificationDateTo() {
        return modificationDateTo;
    }

    /**
     * Set the date for a search of file with modification date final.
     * @param modificationDateTo the date for final modification date of file.
     */
    public void setModificationDateTo(String modificationDateTo) {
        this.modificationDateTo = modificationDateTo;
    }

    /**
     * Get the last date initial for a search of file.
     * @return the last date initial.
     */
    public String getLastDateFrom() {
        return lastDateFrom;
    }

    /**
     * Set the last date initial for a search of file.
     * @param lastDateFrom the last date initial.
     */
    public void setLastDateFrom(String lastDateFrom) {
        this.lastDateFrom = lastDateFrom;
    }

    /**
     * Get the last date final for a search of file.
     * @return the last date final of file.
     */
    public String getLastDateTo() {
        return lastDateTo;
    }

    /**
     * Set the last date final for a search of file.
     * @param lastDateTo the last date final.
     */
    public void setLastDateTo(String lastDateTo) {
        this.lastDateTo = lastDateTo;
    }

}
