/*
 * @(#) CriteriaConverterVideo.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.convertor.models;

/**
 * CriteriaConverterVideo
 *
 * @version 0.0.3
 * @author Regis Humana
 */
public class CriteriaConverterVideo extends CriteriaConverter {

    /**
     * The resolution will be standard
     */
    private String videoResolution;

    /**
     * Audio channel can be stereo or mono
     */
    private String audioChannel;

    /**
     * The frame rate can be 30, 60, 29.97, 24, 24.976 fps
     */
    private String frameRate;

    /**
     * Accepts criteria path origin, destination and extension.
     * @param path
     * @param destinationPath
     * @param extension
     */
    public CriteriaConverterVideo(String path, String destinationPath, String extension) {
        super(path, destinationPath, extension);
    }

    /**
     * @return videoResolution
     */
    public String getVideoResolution() {
        return videoResolution;
    }

    /**
     * Set videoResolution
     * @param videoResolution
     */
    public void setVideoResolution(String videoResolution) {
        this.videoResolution = videoResolution;
    }

    /**
     * @return audioChannel
     */
    public String getAudioChannel() {
        return audioChannel;
    }

    /**
     * Set audioChannel
     * @param audioChannel
     */
    public void setAudioChannel(String audioChannel) {
        this.audioChannel = audioChannel;
    }

    /**
     * @return frameRate
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Set frameRate
     * @param frameRate
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }
}
