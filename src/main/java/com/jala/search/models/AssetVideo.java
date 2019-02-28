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
public class AssetVideo extends Asset {
    private String videoCodec;
    private String AudioCodec;
    private String frameRaate;
    private String aspecRatio;

    /**
     * @return videoCode as a property of videos.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * @param videoCode as String.
     */
    public void setVideoCodec(String videoCode) {
        this.videoCodec = videoCode;
    }

    /**
     * @return AudioCodic as a property of video.
     */
    public String getAudioCodec() {
        return AudioCodec;
    }

    /**
     * @param audioCodec as String.
     */
    public void setAudioCodic(String audioCodec) {
        AudioCodec = audioCodec;
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


}
