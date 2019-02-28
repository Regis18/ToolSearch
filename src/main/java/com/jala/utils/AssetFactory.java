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

import java.io.File;

/**
 * AssetFactory class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetFactory {
    private final static double BYTES = 1024.0;

    /**
     * Asset Factory.
     * @param criteria of search.
     * @param file     class abstract.
     * @return an asset object.
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
     * Receive the size of the files and send in Kilobytes
     * @param fileLength
     * @return Size of files in KiloBytes
     */
    private static double getFileSizeInKb(double fileLength) {
        fileLength = fileLength / BYTES;
        int fs = (int) Math.pow(10,2);
        return Math.rint(fileLength*fs)/fs;
    }

    /**
     * Load Asset class of File class.
     * @param asset as Asset.
     * @param file  as File.
     */
    public static void loadFile(Asset asset, File file) {
        asset.setFileName(file.getName());
        asset.setPath(file.getPath());
        asset.setHidden(file.isHidden());
        asset.setReadOnly(!file.canWrite());
        asset.setExtension(FilenameUtils.getExtension(file.getName()));
        asset.setSizeView(Double.toString(getFileSizeInKb(file.length())));
        asset.setSize(Double.toString(file.length()));
    }

    /**
     * Load Asset Video of File class.
     * @param assetVideo as AssetVideo.
     * @param file       as File.
     */
    public static void loadFileVideo(AssetVideo assetVideo, File file) {
        loadFile(assetVideo, file);
        //TODO load the common properties file.
    }

    /**
     * Load Asset Common of File class.
     * @param assetCommon as AssetCommon.
     * @param file        as File.
     */
    public void loadFileCommon(AssetCommon assetCommon, File file) {
        loadFile(assetCommon, file);
        //TODO load the common properties file.
    }

    /**
     * Load Asset Text of Text class.
     * @param assetText as AssetText.
     * @param file      as File.
     */
    public void loadFileText(AssetText assetText, File file) {
        loadFile(assetText, file);
        //TODO load the text properties file.
    }
}
