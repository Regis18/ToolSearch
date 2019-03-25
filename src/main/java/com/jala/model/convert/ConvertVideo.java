/*
 * @(#) ConvertVideo.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.convert;

import com.jala.model.criteria.CriteriaConverterVideo;
import com.jala.utils.Logs;
import com.jala.view.JPanelConverterVideo;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.builder.FFmpegOutputBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;

import org.apache.log4j.Logger;
import com.jala.utils.Common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * This class used the FFmpeg app for Convert of format a Video.
 *
 * @author Regis Humana
 * @version 0.0.3
 */
public class ConvertVideo implements IConvertible {

    /**
     * It creates to follow up the instruction of the class.
     */
    private Logger log = Logs.getInstance().getLog();

    /**
     * Store the path destination with the path of folder, name of file and the extension.
     */
    private String pathDestination;

    /**
     * Var for error messages.
     */
    private String convertResult;

    /**
     * Convert formats of video into another extension - basic.
     *
     * @param criteriaObject criteria for convert video.
     */
    public void convert(Object criteriaObject) {
        CriteriaConverterVideo criteria = (CriteriaConverterVideo) criteriaObject;
        try {
            String pathFFmpeg = getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin/ffmpeg.exe").getPath();
            FFmpeg fmpeg = new FFmpeg(Common.cleanPath(pathFFmpeg));
            String pathFFprobe = getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin/ffprobe.exe").getPath();
            FFprobe fprobe = new FFprobe(Common.cleanPath(pathFFprobe));
            FFmpegBuilder builder = new FFmpegBuilder();
            pathDestination = criteria.getPathDestination() + criteria.getNewFileName() + criteria.getNewExtension();
            builder.addInput(criteria.getPath()).overrideOutputFiles(true);
            if (!criteria.getIsAdvanced()) {
                builder.addOutput(pathDestination);
                FFmpegProbeResult probeResult = fprobe.probe(criteria.getPath());
                FFmpegExecutor executor = new FFmpegExecutor(fmpeg, fprobe);
                convertVideoProgress(executor, builder, probeResult);
            } else {
                convertAdvancedVideo(criteria, builder, fmpeg, fprobe);
            }
        } catch (IOException error) {
            log.error("Error in ConvertVideo", error);
        }
    }

    /**
     * Convert the video with advances parameters like audioChannel, BitRate, SampleRate, Frame rate & Video resolution.
     *
     * @param criteria for convert video and audio.
     * @param builder  for the format convert audio and video.
     * @param fmpeg    library.
     * @param fprobe   library.
     */
    private void convertAdvancedVideo(CriteriaConverterVideo criteria, FFmpegBuilder builder, FFmpeg fmpeg, FFprobe fprobe) {
        try {
            FFmpegOutputBuilder outputBuilder = new FFmpegOutputBuilder();
            outputBuilder.setFilename(pathDestination);
            if (!criteria.getAudioChannel().isEmpty()) {
                int channel = criteria.getAudioChannel() == "Mono" ? FFmpeg.AUDIO_MONO : FFmpeg.AUDIO_STEREO;
                outputBuilder.setAudioChannels(channel);
            }
            if (criteria.getFrameRate() != 0) {
                outputBuilder.setVideoFrameRate(criteria.getFrameRate());
            }
            if (!criteria.getVideoResolution().isEmpty()) {
                outputBuilder.setVideoResolution(criteria.getVideoResolution());
            }
            if (criteria.getBitRate() != 0) {
                outputBuilder.setAudioBitRate(criteria.getBitRate());
            }
            if (criteria.getSampleRate() != 0) {
                outputBuilder.setAudioSampleRate(criteria.getSampleRate());
            }
            builder.addOutput(outputBuilder);
            FFmpegExecutor executor = new FFmpegExecutor(fmpeg, fprobe);
            FFmpegProbeResult probeResult = fprobe.probe(criteria.getPath());
            convertVideoProgress(executor, builder, probeResult);
        } catch (IOException error) {
            log.error("Error in ConvertAdvancedAudio", error);
        }
    }

    /**
     * Method for convert the video and audio using the FFmpeg and FFprobe and show the progress.
     *
     * @param executor this method is who do the progress.
     * @param builder  is who do the convert.
     * @param probeResult       is the library.
     */
    public void convertVideoProgress(FFmpegExecutor executor, FFmpegBuilder builder, final FFmpegProbeResult probeResult) {
        FFmpegJob job = executor.createJob(builder, new ProgressListener() {
            private final double durationNs = probeResult.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(final Progress progress) {
                double percentage = progress.out_time_ns / durationNs;
                if ((int) (percentage * 100) <= 100) {
                    JPanelConverterVideo.setProgressBarValue((int) (percentage * 100));
                }
            }
        });
        try {
            job.run();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
        }
        if (job.getState() == FFmpegJob.State.FAILED) {
            convertResult = "The Conversion has failed. ";
            log.error("The Convertion has failed.");
        }
        if (job.getState() == FFmpegJob.State.FINISHED) {
            JPanelConverterVideo.setProgressBarValue(100);
            convertResult = "The Conversion has finished successfully.";
            log.info("The Conversion has finished successfully.");
        }
    }
}
