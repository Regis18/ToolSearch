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

package com.jala.model.search.asset;

/**
 * AssetVideo class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetVideo extends Asset {

    /** Save VideoCodec valid for AssetVideo. */
    private String videoCodec;

    /** Save audioCodec valid for AssetVideo. */
    private String audioCodec;

    /** Save frameRate valid for AssetVideo. */
    private String frameRate;

    /** Save aspectRatio valid for AssetVideo. */
    private String aspectRatio;

    /** Save dimensionWidth valid for AssetVideo. */
    private String dimensionWidth;

    /** Save dimensionHeight valid for AssetVideo. */
    private String dimensionHeight;

    /** Save audioSampleRate valid for AssetVideo. */
    private String audioSampleRate;

    /** Save duration valid for AssetVideo. */
    private String duration;

    /**
     * Constructor of AssetVideo class
     */
    public void AssetVideo() {
        videoCodec = "";
        audioCodec = "";
        frameRate = "";
        aspectRatio = "";
        dimensionWidth = "";
        dimensionHeight = "";
        audioSampleRate = "";
        duration = "";
    }

    /**
     * @return videoCode as a property of videos.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * @param videoCodec this is the video codec an attribute of audio for the advanced searched.
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
     * @param audioCodec this is the audio codec an attribute of audio for the advanced searched.
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
     * @param frameRate this is the frame rate an attribute of audio for the advanced searched.
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @return aspectRatio as a property of video.
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * @param aspectRatio as String.
     */
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * @return dimensionWidth as a property of video.
     */
    public String getDimensionWidth() {
        return dimensionWidth;
    }

    /**
     * @param dimensionWidth this is the dimention with an attribute of video for the advanced searched.
     */
    public void setDimensionWidth(String dimensionWidth) {
        this.dimensionWidth = dimensionWidth;
    }

    /**
     * @return dimensionHeight as a property of video.
     */
    public String getDimensionHeight() {
        return dimensionHeight;
    }

    /**
     * @param dimensionHeight this is the dimention height an attribute of audio for the advanced searched.
     */
    public void setDimensionHeight(String dimensionHeight) {
        this.dimensionHeight = dimensionHeight;
    }

    /**
     * @return audioSampleRate as a property of video.
     */
    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * @param audioSampleRate this is the audio samples rate an attribute of audio for the advanced searched.
     */
    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    /**
     * @return duration as a property of video.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration this is the duration an attribute of audio for the advanced searched.
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }
}

