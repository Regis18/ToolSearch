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

package com.jala.search.models;

import com.jala.utils.AssetFactory;
import com.jala.utils.Logs;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SearchBasic implements ISearchable {
    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();
    private List<Asset> result;

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
                    asset = AssetFactory.getAsset(file.getPath(), file.getName(), FilenameUtils.getExtension(file.getName()),
                                file.isHidden(), fileOwner(file.getPath()), String.valueOf(file.length()), file.canWrite(),
                                fileCreationDate(file.getPath()), fileLastModifiedDate(file.getPath()), fileLastAccessDate(file.getPath()));
                    result.add(asset);
                }
            }
        }
        return result;
    }

    /**
     * Get the file creation date.
     * @param filePath the path of the file.
     * @return the creation date of the file.
     */
    public static String fileCreationDate(String filePath){
        File file = new File(filePath);
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.creationTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format( new java.util.Date( time.toMillis() ) );
            return formatted;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get file owner.
     * @param filePath the path of the file.
     * @return the owner of the file.
     */
    public static String fileOwner(String filePath) {
        Path path = Paths.get(filePath);
        FileOwnerAttributeView ownerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        try {
            UserPrincipal owner = ownerAttributeView.getOwner();
            return owner.getName();
        } catch(java.io.IOException event){
            return "";
        }
    }

    /**
     * Get the file last access date.
     * @param filePath the path of the file.
     * @return the file date last access date.
     */
    public static String fileLastAccessDate(String filePath){
        File file = new File(filePath);
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastAccessTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format(new java.util.Date(time.toMillis()));
            return formatted ;
        } catch (IOException event) {
            return "";
        }
    }

    /**
     * Get the file last modified date.
     * @param filePath the path of the file.
     * @return the date of file the las modified date.
     */
    public static String fileLastModifiedDate(String filePath){
        File file = new File(filePath);
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastModifiedTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format( new java.util.Date( time.toMillis() ) );
            return formatted ;
        } catch (IOException event) {
            return "";
        }
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
