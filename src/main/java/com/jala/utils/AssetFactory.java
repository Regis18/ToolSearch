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
import com.jala.search.models.CriteriaSearch;

import java.io.File;

/**
 * AssetFactory class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetFactory {
    /**
     * Asset Factory.
     * @param criteria of search.
     * @param file class abstract.
     * @return an asset object.
     */
    public static Asset GetAsset(CriteriaSearch criteria, File file) {
        if (criteria.getType() == 0) {
            Asset newAsset = new Asset();
            loadFile(newAsset,file);
            return newAsset;
        } else if (criteria.getType() == 1) {
            AssetVideo newAsset = new AssetVideo();
            loadFileVideo(newAsset,file);
            return newAsset;
        } else
            return new Asset();

    }
    public static void loadFile(Asset asset,File file) {
        asset.setFileName(file.getName());
        asset.setPath(file.getPath());
        asset.setHidden(file.isHidden());
        asset.setReadOnly(!file.canWrite());

    }

    /**
     * The File class is an abstract representation of file and directory
     * pathnames and properties file.
     * @param file as File.
     */
    public static void loadFileVideo(AssetVideo assetVideo,File file) {
        loadFile(assetVideo, file);
        //TODO load the common properties file.


    }
}
