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

import com.jala.search.models.*;
import org.apache.commons.io.FilenameUtils;

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

import static com.jala.utils.FileExtra.loadFile;

/**
 * AssetFactory class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetFactory {

    /**
     * Asset Factory.
     *
     * @param file the file to the load.
     * @return the file to convert to asset.
     */
    public static Asset getAsset(String type, File file, String path, String fileName, String extension,
                                 TernaryBooleanEnum hidden, String owner, String size, TernaryBooleanEnum readOnly,
                                 String creationDate, String modificationDate, String lastDate) {
        Asset newAsset = new Asset();
        if (type.equals("Common")) {
            Asset newAssetVerify = new Asset();
            loadFile(newAssetVerify, file);
            newAsset = newAssetVerify;
        }
        return newAsset;
    }

    public static Asset getAsset(String type, File file, String path, String fileName, String extension,
                                 TernaryBooleanEnum hidden, String owner, String size, TernaryBooleanEnum readOnly,
                                 String creationDate, String modificationDate, String lastDate, String videoCodec,
                                 String audioCodec, String frameRate, String aspecRatio) {
        Asset newAsset = new Asset();
        if (type.equals("Video")) {
            Asset newAssetVerify = new AssetVideo();
            loadFile(newAssetVerify, file);
            newAsset = newAssetVerify;
        }
        return newAsset;
    }

    public static Asset getAsset(String type, File file, String path, String fileName, String extension,
                                 TernaryBooleanEnum hidden, String owner, String size, TernaryBooleanEnum readOnly,
                                 String creationDate, String modificationDate, String lastDate, String contain) {
        Asset newAsset = new Asset();
        if (type.equals("Document")) {
            Asset newAssetVerify = new AssetText();
            loadFile(newAssetVerify, file);
            newAsset = newAssetVerify;
        }
        return newAsset;
    }
}
