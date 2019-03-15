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
    public static Asset getAsset(String path, String fileName, String extension,
                                 boolean hidden, String owner, String size, boolean readOnly,
                                 String creationDate, String modificationDate, String lastDate) {
        Asset assetVerify = new Asset();
        assetVerify.setFileName(fileName);
        assetVerify.setPath(path);
        assetVerify.setHidden(hidden);
        assetVerify.setReadOnly(readOnly);
        assetVerify.setExtension(extension);
        assetVerify.setSize(size);
        assetVerify.setOwner(SearchCommon.fileOwner(owner));
        assetVerify.setCreationDate(creationDate);
        assetVerify.setModificationDate(modificationDate);
        assetVerify.setLastDate(lastDate);
        return assetVerify;
    }

    /**
     * Constructor that create the type Asset Video
     * @param asset
     * @param videoCodec of the video
     * @param audioCodec of the video
     * @param frameRate of the video
     * @param aspectRatio of the video
     * @return file convert a new asset
     */
    public static Asset getAsset(Asset asset, String videoCodec,
                                 String audioCodec, String frameRate, String aspectRatio, String audioSampleRate, String duration) {
        Asset assetVerify = new AssetVideo();
        assetVerify.setFileName(asset.getFileName());
        assetVerify.setPath(asset.getPath());
        assetVerify.setHidden(asset.isHidden());
        assetVerify.setReadOnly(asset.isReadOnly());
        assetVerify.setExtension(asset.getExtension());
        assetVerify.setSize(asset.getSize());
        assetVerify.setOwner(SearchCommon.fileOwner(asset.getOwner()));
        assetVerify.setCreationDate(asset.getCreationDate());
        assetVerify.setModificationDate(asset.getModificationDate());
        assetVerify.setLastDate(asset.getLastDate());
        ((AssetVideo) assetVerify).setVideoCodec(videoCodec);
        ((AssetVideo) assetVerify).setAudioCodec(audioCodec);
        ((AssetVideo) assetVerify).setAspectRatio(aspectRatio);
        ((AssetVideo) assetVerify).setFrameRate(frameRate);
        ((AssetVideo) assetVerify).setFrameRate(audioSampleRate);
        ((AssetVideo) assetVerify).setFrameRate(duration);
        return assetVerify;
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
