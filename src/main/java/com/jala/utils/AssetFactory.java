/*
 * @(#) AssetFactory.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.utils;

import com.jala.search.models.Asset;
import com.jala.search.models.AssetVideo;
import com.jala.search.models.AssetCommon;
import com.jala.search.models.AssetText;
import com.jala.search.models.CriteriaSearch;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

/**
 * AssetFactory class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetFactory {
    private final static double BYTES = 1024.0;

    /**
     * Asset Factory.
     * @param criteria criteria of the search.
     * @param file the file to the load.
     * @return the file to convert to asset.
     */
    public static Asset GetAsset(CriteriaSearch criteria, File file) {
        if (criteria.getType() == 0) {
            Asset newAsset = new Asset();
            loadFile(newAsset, file);
            return newAsset;
        } else if (criteria.getType() == 1) {
            AssetVideo newAsset = new AssetVideo();
            loadFileVideo(newAsset, file);
            return newAsset;
        } else
            return new Asset();
    }

    /**
     * Receive the size of the files and send in Kilobytes.     *
     * @param fileLength size of file.
     * @return Size of files in KiloBytes
     */
    private static double getFileSizeInKb(double fileLength) {
        fileLength = fileLength / BYTES;
        int fs = (int) Math.pow(10, 2);
        return Math.rint(fileLength * fs) / fs;
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
            String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );
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
            String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );
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
            String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );
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

    /**
     * Load Asset of the file.
     * @param asset asset where file was load.
     * @param file  the file to load to asset.
     */
    public static void loadFile(Asset asset, File file) {
        asset.setFileName(file.getName());
        asset.setPath(file.getPath());
        asset.setHidden(file.isHidden());
        asset.setReadOnly(!file.canWrite());
        asset.setExtension(FilenameUtils.getExtension(file.getName()));
        asset.setSizeView(Double.toString(getFileSizeInKb(file.length())));
        asset.setSize(Double.toString(file.length()));
        asset.setOwner(fileOwner(file.getPath()));
        asset.setCreationDate(fileCreationDate(file.getPath()));
        asset.setModificationDate(fileLastModifiedDate(file.getPath()));
        asset.setLastDate(fileLastAccessDate(file.getPath()));
    }

    /**
     * Load Asset of the Video.
     * @param assetVideo the asset for video feature.
     * @param file the file to the load.
     */
    public static void loadFileVideo(AssetVideo assetVideo, File file) {
        loadFile(assetVideo, file);
        //TODO load the common properties file.
    }

    /**
     * Load Asset of the Common.
     * @param assetCommon the asset for Common feature.
     * @param file the file to the load.
     */
    public void loadFileCommon(AssetCommon assetCommon, File file) {
        loadFile(assetCommon, file);
        //TODO load the common properties file.
    }

    /**
     * Load Asset of the Text.
     * @param assetText the asset for Text feature.
     * @param file the file to the load.
     */
    public void loadFileText(AssetText assetText, File file) {
        loadFile(assetText, file);
        //TODO load the text properties file.
    }
}
