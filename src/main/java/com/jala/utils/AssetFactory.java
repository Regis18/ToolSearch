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
import java.io.File;

import static com.jala.utils.ExtractMetaDatas.*;


/**
 * AssetFactory class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetFactory {

    /**
     * Constructor that create the type Asset Common
     * @param file the file to the load
     * @param path of the file
     * @param fileName Name of the file
     * @param extension of the file
     * @param hidden of the file
     * @param owner of the file
     * @param size of the file
     * @param readOnly of the file
     * @param creationDate of the file
     * @param modificationDate of the file
     * @param lastDate of the file
     * @return file convert a new asset
     */
    public static Asset getAsset(File file, String path, String fileName, String extension,
                                 TernaryBooleanEnum hidden, String owner, String size, TernaryBooleanEnum readOnly,
                                 String creationDate, String modificationDate, String lastDate) {
        Asset newAssetVerify = new Asset();
        loadFile(newAssetVerify, file);
        return newAssetVerify;
    }

    /**
     * Constructor that create the type Asset Video
     * @param file the file to the load
     * @param path of the file
     * @param fileName Name of the file
     * @param extension of the file
     * @param hidden of the file
     * @param owner of the file
     * @param size of the file
     * @param readOnly of the file
     * @param creationDate of the file
     * @param modificationDate of the file
     * @param lastDate of the file
     * @param videoCodec of the video
     * @param audioCodec of the video
     * @param frameRate of the video
     * @param aspecRatio of the video
     * @return file convert a new asset
     */
    public static Asset getAsset(File file, String path, String fileName, String extension,
                                 TernaryBooleanEnum hidden, String owner, String size, TernaryBooleanEnum readOnly,
                                 String creationDate, String modificationDate, String lastDate, String videoCodec,
                                 String audioCodec, String frameRate, String aspecRatio) {
            Asset newAssetVerify = new AssetVideo();
        loadFileVideo((AssetVideo) newAssetVerify, file);
        return newAssetVerify;
    }

    /**
     * Constructor that create the type Asset Document
     * @param file the file to the load
     * @param path of the file
     * @param fileName Name of the file
     * @param extension of the file
     * @param hidden of the file
     * @param owner of the file
     * @param size of the file
     * @param readOnly of the file
     * @param creationDate of the file
     * @param modificationDate of the file
     * @param lastDate of the file
     * @param contain of the Document
     * @return file convert a new asset
     */
    public static Asset getAsset(File file, String path, String fileName, String extension,
                                 TernaryBooleanEnum hidden, String owner, String size, TernaryBooleanEnum readOnly,
                                 String creationDate, String modificationDate, String lastDate, String contain) {
        Asset newAssetVerify = new AssetText();
        loadFileAudio((AssetAudio) newAssetVerify, file);
        return newAssetVerify;
    }
}
