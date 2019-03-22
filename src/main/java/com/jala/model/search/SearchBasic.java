/*
 * @(#) SearchBasic.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.search;

import com.jala.model.criteria.CriteriaSearch;
import com.jala.model.search.asset.Asset;
import com.jala.utils.AssetFactory;
import com.jala.utils.Logs;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SearchBasic.
 *
 * @version 0.0.1
 * @author Regis Humana
 */
public abstract class SearchBasic implements ISearchable {

    /** It creates to follow up the instruction of the class. */
    private static Logger log = Logs.getInstance().getLog();

    /** Asset list. */
    private List<Asset> result;

	/**
     * Search all the files in the path without filters.
     * @param criteria to do the search.
	 * @return List<Asset> result.
	 */
    public List<Asset> search(CriteriaSearch criteria) {
        result = new ArrayList<>();
        File folder = new File(criteria.getPath());
        if (folder.exists()) {
            List<File> files = new ArrayList<>();
            getAllFiles(folder, files);
            for (int i = 0; i < files.size(); i++) {
                File file = files.get(i);
                if (file.isFile()) {
                    Asset asset;
                    asset = AssetFactory.getAsset(file.getPath(),
                            file.getName(),
                            FilenameUtils.getExtension(file.getName()),
                            file.isHidden(),
                            getFileOwner(file),
                            String.valueOf(file.length()),
                            file.canWrite(),
                            getFileDate(file,"Creation"),
                            getFileDate(file,"Modification"),
                            getFileDate(file, "LastAccess"));
                    result.add(asset);
                }
            }
        }
        return result;
    }

    /**
     * Get creation modification and last access date of a file.
     * @param file to search.
     * @param typeDate creation, modification and last access.
     * @return new format date.
     */
    public String getFileDate(File file, String typeDate) {
        BasicFileAttributes attributes;
        String formatted;
        FileTime time;
        try {
            attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            if(typeDate.equals("Creation")) {
                time = attributes.creationTime();
            } else if (typeDate.equals("Modification")) {
                time =attributes.lastModifiedTime();
            } else {
                time =attributes.lastAccessTime();
            }
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            formatted = simpleDateFormat.format(new java.util.Date(time.toMillis()));

        } catch (IOException event) {
            log.error("Error in : " + event.getMessage(), event);
            formatted = "";
        }
        return formatted;
    }

    /**
     * Get file owner.
     * @param file the file to search.
     * @return the owner of the file.
     */
    public String getFileOwner(File file) {
        FileOwnerAttributeView ownerAttributeView = Files.getFileAttributeView(file.toPath(), FileOwnerAttributeView.class);
        String owner;
        try {
            UserPrincipal owners = ownerAttributeView.getOwner();
            owner = owners.getName();
        } catch (IOException event) {
            log.error("Error in " + event.getMessage(), event);
            owner = "";
        }
        return owner;
    }

    /**
     * Search files recursively.
     * @param currentFile the starting file.
     * @param result list of files.
     */
    private void getAllFiles(File currentFile, List<File> result) {
        if (currentFile.isFile()) {
            result.add(currentFile);
        } else {
            File[] findFiles = currentFile.listFiles();
            List<File> files = Arrays.asList(findFiles);
            for (int i = 0; i < files.size(); i++) {
                getAllFiles(files.get(i) , result);
            }
        }
    }
}
