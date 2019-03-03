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
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetVideo extends Asset {
    private String videoCodec;
    private String audioCodec;
    private String frameRate;
    private String aspecRatio;

    /**
     * Constructor of AssetVideo class
     */
    public void AssetVideo() {
        videoCodec = "";
        audioCodec = "";
        frameRate = "";
        aspecRatio = "";
    }

    /**
     * @return videoCode as a property of videos.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * @param videoCodec as String.
     */
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * @return audioCodec as a property of video.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * @param audioCodec as String.
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * @return frameRate as a property of video.
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * @param frameRate as String.
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
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
}
