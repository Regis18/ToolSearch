/*
 * @(#) ExtractMetaDatas.java Copyright (c) 2019 Jala Foundation.
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
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.apache.commons.io.FilenameUtils;

import java.io.File;


public class ExtractMetaDatas {

    private final static double BYTES = 1024.0;

    /**
     * Constant for the path of ffprobe.
     */
    private static String FFPROBE_PATH = ExtractMetaDatas.class.getClassLoader()
            .getResource("ThirdParty/ffmpeg/bin").getPath() + "ffprobe";

    /**
     * Receive the size of the files and send in Kilobytes.     *
     * @param fileLength size of file.
     * @return Size of files in KiloBytes
     */
    private static double getFileSizeInKb(double fileLength) {
        fileLength = fileLength / BYTES;
        int fs = (int) Math.pow(10, 2);
        return Math.rint(fileLength * fs) / fs;
    }


    /**
     * Load Asset of the file.
     * @param asset asset where file was load.
     * @param file  the file to load to asset.
     */
    public static void loadFile(Asset asset, File file) {
        asset.setFileName(file.getName());
        asset.setPath(file.getPath());
        asset.setHidden(file.isHidden());
        asset.setReadOnly(!file.canWrite());
        asset.setExtension(FilenameUtils.getExtension(file.getName()));
        asset.setSizeView(Double.toString(getFileSizeInKb(file.length())));
        asset.setSize(Double.toString(file.length()));
        asset.setOwner(SearchCommon.fileOwner(file.getPath()));
        asset.setCreationDate(SearchCommon.fileCreationDate(file.getPath()));
        asset.setModificationDate(SearchCommon.fileLastModifiedDate(file.getPath()));
        asset.setLastDate(SearchCommon.fileLastAccessDate(file.getPath()));
    }

    /**
     * Load Asset of the Video.
     * @param assetVideo the asset for video feature.
     * @param file the file to the load.
     */
    public static void loadFileVideo(AssetVideo assetVideo, File file) {
        //loadFileVideo(assetVideo, file);
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
    public static void loadFileAudio(AssetAudio assetAudio, File file) {
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

    /**
     * Load Asset of the Text.
     * @param assetText the asset for Text feature.
     * @param file the file to the load.
     */
    public void loadFileText(AssetText assetText, File file) {
        loadFile(assetText, file);
        //TODO load the text properties file.
    }
}
