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

package com.jala.model.criteria;

import com.jala.model.criteria.CriteriaConverter;

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
     * Audio channel can be Stereo or Mono
     */
    private String audioChannel;

    /**
     * The frame rate can be 30, 60, 29.97, 24, 24.976 fps
     */
    private double frameRate;

    /**
     * bitRate can be 4096, 8192, 32768, 98304, 131072, 199608, 320000
     */
    private long bitRate;

    /**
     * sampleRate can be 8000, 11025, 12000, 16000, 22050, 32000, 44100, 48000, 96000
     */
    private int sampleRate;

    /**
     * Determinate if the converter is advanced.
     */
    private boolean isAdvanced;

    /**
     * Accepts criteria path origin, destination and extension.
     * @param path
     * @param destinationPath
     * @param extension
     */
    public CriteriaConverterVideo(String path, String destinationPath, String extension) {
        super(path, destinationPath, extension);
        isAdvanced = false;
        frameRate = 0;
        audioChannel = "";
        videoResolution = "";
        bitRate = 0;
        sampleRate = 0;
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
    public Double getFrameRate() {
        return frameRate;
    }

    /**
     * Set frameRate
     * @param frameRate
     */
    public void setFrameRate(Double frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * Establish if the ConverterVIDEO is advanced
     * @param isAdvanced
     */
    public void setIsAdvanced(Boolean isAdvanced) {
        this.isAdvanced = isAdvanced;
    }

    /**
     * Return is the Advanced Converter
     * @return
     */
    public Boolean getIsAdvanced() {
        return isAdvanced;
    }

    /**
     * Get bitRate
     * @return long bitRate
     */
    public long getBitRate() {
        return bitRate;
    }

    /**
     * Set bitRate
     * @param bitRate long
     */
    public void setBitRate(long bitRate) {
        this.bitRate = bitRate;
    }

    /**
     * Get sampleRate
     * @return
     */
    public int getSampleRate() {
        return sampleRate;
    }

    /**
     * Set sampleRate
     * @param sampleRate
     */
    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

}
