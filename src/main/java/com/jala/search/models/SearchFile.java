/**
 * @(#)SearchFile.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.utils.Logs;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.jala.utils.AssetFactory;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * SearchFile class.
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class SearchFile implements ISearchable {

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    /**
     * This method return a IAsset list by attributes of criteria.
     * @param criteria to do the search with the path is required and other attributes are optional.
     * @return a list of the files that content the folder set in the path of criteria.
     */
    @Override
    public List<Asset> search(CriteriaSearch criteria) {
    log.info("Searching on "+criteria.getPath());
        List<Asset> result = new ArrayList<>();
        File folder = new File(criteria.getPath());
        if (folder.exists()) {
            List<File> files = new ArrayList<File>();

            GetAllFiles(folder,files);
            try {
                for (int i = 0; i < files.size(); i++) {
                    File file = files.get(i);
                    if (file.isFile()) {
                        Asset asset = AssetFactory.getAsset(criteria, file);
                        String nameCriteria = criteria.getFileName();
                        String extensionCriteria = criteria.getExtension();
                        String sizeCriteria = criteria.getSize();
                        String ownerCriteria = criteria.getOwner();

                       // var aux.
                        boolean addFileToResults = true;
                        if ((criteria.getHidden() == TernaryBooleanEnum.OnlyTrue) && !(file.isHidden())) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && criteria.getHidden() == TernaryBooleanEnum.OnlyFalse && (file.isHidden())) {
                            addFileToResults = false;
                        }
                       if (addFileToResults && (!criteria.getCreationDateFrom().isEmpty()) && !criteria.getCreationDateTo().isEmpty()) {
                                if(  ( Date.valueOf( fileCreationDate(file.getPath())).before(Date.valueOf(criteria.getCreationDateFrom()) ))
                                ||  ( Date.valueOf(fileCreationDate(file.getPath())).after(Date.valueOf(criteria.getCreationDateTo()))))

                                addFileToResults = false;
                        }
                        if (addFileToResults && (!criteria.getModificationDateFrom().isEmpty()) && !criteria.getModificationDateTo().isEmpty()) {
                            if(  ( Date.valueOf(fileLastModifiedDate(file.getPath())).before(Date.valueOf(criteria.getModificationDateFrom()) ))
                                    ||  ( Date.valueOf(fileLastModifiedDate(file.getPath())).after(Date.valueOf(criteria.getModificationDateTo()) ))                           )
                                addFileToResults = false;
                        }
                        if (addFileToResults && (!criteria.getLastDateFrom().isEmpty()) && !criteria.getLastDateTo().isEmpty()) {
                            if(  ( Date.valueOf(fileLastAccessDate(file.getPath())).before(Date.valueOf(criteria.getLastDateFrom()) ))
                                    ||  ( Date.valueOf(fileLastAccessDate(file.getPath())).after(Date.valueOf(criteria.getLastDateTo()) )))
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!ownerCriteria.isEmpty()) && (!fileOwner(file.getPath()).contains(ownerCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!sizeCriteria.isEmpty())) {
                            if (criteria.isSizeCompareOption() && !(Double.parseDouble( sizeCriteria) > file.length()))
                                addFileToResults = false;
                            if (!criteria.isSizeCompareOption() && !(Double.parseDouble( sizeCriteria) <= file.length()))
                                addFileToResults = false;
                        }
                        if (addFileToResults && (!nameCriteria.isEmpty()) && (!file.getName().contains(nameCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!extensionCriteria.isEmpty()) && (!FilenameUtils.getExtension(file.getName()).equals(extensionCriteria))) {
                            addFileToResults = false;
                        }
                        if(addFileToResults && (criteria.getReadonly() == TernaryBooleanEnum.OnlyTrue) && !(!file.canWrite())) {
                                addFileToResults = false;
                        }
                        if(addFileToResults && (criteria.getReadonly() == TernaryBooleanEnum.OnlyFalse) && (!file.canWrite())) {
                            addFileToResults = false;
                        }
                        //video.
                        if (criteria.getType() == 1) {
                            //TODO verify video extension.
                         }

                        if (addFileToResults) {
                            result.add(asset);
                        }
                    }
                }
            } catch (NullPointerException e) {
               log.error("The criteria values shouldn't be null", e);
            }
        }
        return result;
    }

    /**
     * Search files recursively.
     * @param currentFile the starting file.
     * @param result list of files.
     */
    private void GetAllFiles(File currentFile, List<File> result) {
        if (currentFile.isFile()) {
            result.add(currentFile);
        }else{
           File[] findFiles = currentFile.listFiles();
            List<File> files = Arrays.asList(findFiles);
            for (int i = 0; i < files.size(); i++) {
                GetAllFiles(files.get(i) , result);
            }
        }
    }
    /**
     * Get the file creation date.
     * @param filePath the path of the file.
     * @return the creation date of the file.
     */
    public static String fileCreationDate(String filePath){
        File file = new File( filePath );
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
     * Get the file last access date.
     * @param filePath the path of the file.
     * @return the file date last access date.
     */
    public static String fileLastAccessDate(String filePath){
        File file = new File( filePath );
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastAccessTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format( new java.util.Date( time.toMillis() ) );
            return formatted ;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get the file last modified date.
     * @param filePath the path of the file.
     * @return the date of file the las modified date.
     */
    public static String fileLastModifiedDate(String filePath){
        File file = new File( filePath );
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastModifiedTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format( new java.util.Date( time.toMillis() ) );
            return formatted ;
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
        try{
            UserPrincipal owner = ownerAttributeView.getOwner();
            return owner.getName();
        }catch(java.io.IOException e){
            return "";
        }
    }
}
