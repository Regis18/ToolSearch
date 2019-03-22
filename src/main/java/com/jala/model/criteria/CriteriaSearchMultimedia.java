/*
 * @(#) CriteriaSearchMultimedia.java Copyright (c) 2019 Jala Foundation.
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

/**
 * CriteriaSearchMultimedia class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class CriteriaSearchMultimedia extends CriteriaSearch {

    /**
     * Criteria of video codec_long_name.
     */
    private String videoCodec;

    /**
     * Criteria of video.
     */
    private String audioCodec;

    /**
     * Criteria of video.
     */
    private String frameRate;

    /**
     * Criteria of video.
     */
    private String aspectRatio;

    /**
     * Criteria of video.
     */
    private String dimension;

    /**
     * Criteria of audio.
     */
    private String channel;

    /**
     * Criteria of audio and video.
     */
    private String audioSampleRate;

    /**
     * Criteria of audio and video.
     */
    private String duration;

    /**
     * Constructor of CriteriaSearchMultimedia class.
     */
    public CriteriaSearchMultimedia() {
        super();
        loadVideoCriteria();
    }

    /**
     * Constructor CriteriaSearchMultimedia class with a path parameter.
     * @param path the path of file.
     */
    public CriteriaSearchMultimedia(String path) {
        super(path);
        this.loadVideoCriteria();
    }

    /**
     * Constructor CriteriaSearchMultimedia class with a path parameter.
     * @param criteriaSearch the path of file.
     */
    public CriteriaSearchMultimedia(CriteriaSearch criteriaSearch) {
        super(criteriaSearch);
        this.loadVideoCriteria();
    }

    /**
     * Load video criteria goes to init the empty values.
     */
    private void loadVideoCriteria() {
        this.setVideoCodec("");
        this.setAudioCodec("");
        this.setFrameRate("");
        this.setAspectRatio("");
        this.setDimension("");
        this.setChannel("");
        this.setAudioSampleRate("");
        this.setDuration("");
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
     * @return aspectRatio get aspect ratio attribute of video search.
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * @param aspectRatio set aspect ratio attribute of video search.
     */
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * @return dimension get dimension attribute of video search.
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * @param dimension set dimension attribute of video search.
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     * @return channel get this attribute of audio search.
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel set this attribute of audio search.
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * @return getAudioSampleRate get this attribute of audio and video search.
     */
    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * @param audioSampleRate set this attribute of audio and video search.
     */
    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    /**
     * @returnget getDuration get this attribute of audio and video search.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration set this attribute of audio and video search.
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
