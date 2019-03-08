/*
 * @(#) CriteriaSearchVideo.java Copyright (c) 2019 Jala Foundation.
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

/**
 * CriteriaSearchVideo class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class CriteriaSearchVideo extends CriteriaSearch {
    private String path;
    private String videoCodec;
    private String audioCodec;
    private String frameRate;
    private String aspecRatio;
    private String dimension;

    /**
     * Constructor of CriteriaSearchVideo class.
     */
    public CriteriaSearchVideo() {
        super();
        LoadVideoCriteria();

    }

    /**
     * Load video criteria goes to init the empty values.
     */
    private void LoadVideoCriteria(){
        this.setVideoCodec("");
        this.setAudioCodec("");
        this.setFrameRate("");
        this.setAspecRatio("");
        this.setDimension("");
    }
    /**
     * Constructor CriteriaSearchVideo class with a path parameter.
     * @param path the path of file.
     */
    public CriteriaSearchVideo(String path) {
        this.LoadVideoCriteria();
        this.path = path;
    }
    /**
     * @return videoCodec get the video codec attribute for video search.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * @param videoCodec set the video codec attribute for video search.
     */
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * @return audioCodec get the audio codec attribute of video search.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * @param audioCodec set a audio codec attribute for video search.
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * @return frameRate get the frame rate attribute of video search.
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * @param frameRate set a frame rate attribute of video search.
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @return aspecRatio get aspect ratio attribute of video search.
     */
    public String getAspecRatio() {
        return aspecRatio;
    }

    /**
     * @param aspecRatio set aspect ratio attribute of video search.
     */
    public void setAspecRatio(String aspecRatio) {
        this.aspecRatio = aspecRatio;
    }

    /**
     * @return dimension get dimension attribute of video search.
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * @param dimension set dimension attribute os video search.
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
