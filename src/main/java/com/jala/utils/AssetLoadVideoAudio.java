/*
 * @(#) AssetLoadVideoAudio.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.search.models.AssetVideo;
import com.jala.search.models.AssetAudio;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import java.io.File;

/**
 * AssetFactory class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetLoadVideoAudio {
    
    /**
     * Constant for the path of ffprobe.
     */
    private final String FFPROBE_PATH = getClass().getClassLoader()
            .getResource("ThirdParty/ffmpeg/bin").getPath() + "ffprobe";

    /**
     * Load Asset of the Video.
     * @param assetVideo the asset for video feature.
     * @param file the file to the load.
     */
    public void loadFileVideo(AssetVideo assetVideo, File file) {
        loadFileVideo(assetVideo, file);
        try {
            FFprobe ffprobe = new FFprobe(FFPROBE_PATH);
            FFmpegProbeResult ffprobeResult;
            ffprobeResult = ffprobe.probe(file.getPath());
            assetVideo.setVideoCodec(ffprobeResult.getStreams().get(0).codec_long_name);
            assetVideo.setAudioCodec(ffprobeResult.getStreams().get(0).codec_tag_string);
            assetVideo.setFrameRate(String.valueOf(ffprobeResult.getStreams().get(0).r_frame_rate.getNumerator()));
            assetVideo.setAspectRatio(ffprobeResult.getStreams().get(0).display_aspect_ratio);
            assetVideo.setDimentionWidth(String.valueOf(ffprobeResult.getStreams().get(0).width));
            assetVideo.setDimentionHeight(String.valueOf(ffprobeResult.getStreams().get(0).height));
            assetVideo.setAudioSampleRate(ffprobeResult.getStreams().get(0).sample_aspect_ratio);
            assetVideo.setDuration(String.valueOf(ffprobeResult.getStreams().get(0).duration));
        } catch (Exception ex) {
            //log error
        }
    }
    /**
     * Load Asset of the Video.
     * @param assetAudio the asset for video feature.
     * @param file the file to the load.
     */
    public void loadFileAudio(AssetAudio assetAudio, File file) {
        loadFileAudio(assetAudio, file);
        try {
            FFprobe ffprobe = new FFprobe(FFPROBE_PATH);
            FFmpegProbeResult ffprobeResult;
            ffprobeResult = ffprobe.probe(file.getPath());
            assetAudio.setAudioCodec(ffprobeResult.getStreams().get(0).codec_tag_string);
            assetAudio.setFrameRate(String.valueOf(ffprobeResult.getStreams().get(0).r_frame_rate));
            assetAudio.setChannel(ffprobeResult.getStreams().get(0).channel_layout);
            assetAudio.setAudioSampleRate(String.valueOf(ffprobeResult.getStreams().get(0).sample_rate));
            assetAudio.setDuration(String.valueOf(ffprobeResult.getStreams().get(0).duration));
        } catch (Exception ex) {
            //log error
        }
    }
}
