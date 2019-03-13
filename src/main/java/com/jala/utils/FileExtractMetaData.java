/*
 * @(#) FileExtractMetaData.java Copyright (c) 2019 Jala Foundation.
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExtractMetaData {
    private final  double BYTES = 1024.0;
    /**
     * Constant for the path of ffprobe.
     */
    private final String FFPROBE_PATH = getClass().getClassLoader()
            .getResource("ThirdParty/ffmpeg/bin").getPath() + "/ffprobe";
    //private  final String FFPROBE_PATH = "src\\resources\\ThirdParty\\ffmpeg\\bin\\ffprobe";
    /**
     * Asset Factory.
     *
     * @param criteria criteria of the search.
     * @param file     the file to the load.
     * @return the file to convert to asset.
     */
    public  Asset getAsset(CriteriaSearch criteria, File file) {
        Asset asset = AssetFactory.getAsset(criteria);
        if (criteria.getType() == "Common") {
            loadFile(asset, file);
            return asset;
        } else if (criteria.getType() == "Video") {
            loadFileVideo((AssetVideo) asset, file);
            return asset;
        } else {
            return new Asset();
        }
    }

    /**
     * Receive the size of the files and send in Kilobytes.     *
     *
     * @param fileLength size of file.
     * @return Size of files in KiloBytes
     */
    private double getFileSizeInKb(double fileLength) {
        fileLength = fileLength / BYTES;
        int fs = (int) Math.pow(10, 2);
        return Math.rint(fileLength * fs) / fs;
    }

    /**
     * Get the file creation date.
     *
     * @param filePath the path of the file.
     * @return the creation date of the file.
     */
    public String fileCreationDate(String filePath) {
        File file = new File(filePath);
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.creationTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format(new Date(time.toMillis()));
            return formatted;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get the file last access date.
     *
     * @param filePath the path of the file.
     * @return the file date last access date.
     */
    public String fileLastAccessDate(String filePath) {
        File file = new File(filePath);
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastAccessTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format(new Date(time.toMillis()));
            return formatted;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get the file last modified date.
     *
     * @param filePath the path of the file.
     * @return the date of file the las modified date.
     */
    public String fileLastModifiedDate(String filePath) {
        File file = new File(filePath);
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastModifiedTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format(new Date(time.toMillis()));
            return formatted;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get file owner.
     *
     * @param filePath the path of the file.
     * @return the owner of the file.
     */
    public String fileOwner(String filePath) {
        Path path = Paths.get(filePath);
        FileOwnerAttributeView ownerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        try {
            UserPrincipal owner = ownerAttributeView.getOwner();
            return owner.getName();
        } catch (java.io.IOException e) {
            return "";
        }
    }

    /**
     * Load Asset of the file.
     *
     * @param asset asset where file was load.
     * @param file  the file to load to asset.
     */
    public void loadFile(Asset asset, File file) {
        asset.setFileName(file.getName());
        asset.setPath(file.getPath());
        asset.setHidden(file.isHidden());
        asset.setReadOnly(!file.canWrite());
        asset.setExtension(FilenameUtils.getExtension(file.getName()));
        asset.setSizeView(Double.toString(getFileSizeInKb(file.length())));
        asset.setSize(Double.toString(file.length()));
        asset.setOwner(fileOwner(file.getPath()));
        asset.setCreationDate(fileCreationDate(file.getPath()));
        asset.setModificationDate(fileLastModifiedDate(file.getPath()));
        asset.setLastDate(fileLastAccessDate(file.getPath()));
    }

    /**
     * Load Asset of the Video.
     *
     * @param assetVideo the asset for video feature.
     * @param file       the file to the load.
     */
    public void loadFileVideo(AssetVideo assetVideo, File file) {
        loadFile(assetVideo, file);
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
     *
     * @param assetAudio the asset for video feature.
     * @param file       the file to the load.
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

    /**
     * Load Asset of the Common.
     *
     * @param assetCommon the asset for Common feature.
     * @param file        the file to the load.
     */
    public void loadFileCommon(AssetCommon assetCommon, File file) {
        loadFile(assetCommon, file);
        //TODO load the common properties file.
    }

    /**
     * Load Asset of the Text.
     *
     * @param assetText the asset for Text feature.
     * @param file      the file to the load.
     */
    public void loadFileText(AssetText assetText, File file) {
        loadFile(assetText, file);
        //TODO load the text properties file.
    }
}
