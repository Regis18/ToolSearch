/*
 * @(#) AssetVideo.java Copyright (c) 2019 Jala Foundation.
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

import java.io.File;

/**
 * AssetVideo class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetVideo extends Asset implements IAsset {
    private String videoCode;
    private String AudioCodic;
    private String frameRaate;
    private String aspecRatio;

    /**
     * @return videoCode as a property of videos.
     */
    public String getVideoCode() {
        return videoCode;
    }

    /**
     * @param videoCode as String.
     */
    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    /**
     * @return AudioCodic as a property of video.
     */
    public String getAudioCodic() {
        return AudioCodic;
    }

    /**
     * @param audioCodic as String.
     */
    public void setAudioCodic(String audioCodic) {
        AudioCodic = audioCodic;
    }

    /**
     * @return frameRaate as a property of video.
     */
    public String getFrameRaate() {
        return frameRaate;
    }

    /**
     * @param frameRaate as String.
     */
    public void setFrameRaate(String frameRaate) {
        this.frameRaate = frameRaate;
    }

    /**
     * @return aspecRatio as a property of video.
     */
    public String getAspecRatio() {
        return aspecRatio;
    }

    /**
     * @param aspecRatio as String.
     */
    public void setAspecRatio(String aspecRatio) {
        this.aspecRatio = aspecRatio;
    }

    /**
     * The File class is an abstract representation of file and directory
     * pathnames and properties file.
     * @param file as File.
     */
    public void loadFile(File file) {
        super.loadFile(file);
        //TODO load the common properties file.


    }
}
