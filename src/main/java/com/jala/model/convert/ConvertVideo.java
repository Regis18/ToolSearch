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
 * @version 0.0.3
 * @author Regis Humana
 */
public class ConvertVideo implements IConvertible {

	/** It creates to follow up the instruction of the class.*/
	private Logger log = Logs.getInstance().getLog();

	/** Store the path destination with the path of folder, name of file and the extension.*/
	private String pathDestination;
	/**
	 *
	 */
	private String convertResult;


	/**
	 * Convert formats of video into another extension - basic.
	 * @param criteriaObject criteria for convert video.
	 */
	public void convert(Object criteriaObject) {
		CriteriaConverterVideo criteria = (CriteriaConverterVideo) criteriaObject;
		try {
			String pathFFmpeg = getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin/").getPath() + "ffmpeg.exe";
			FFmpeg fmpeg = new FFmpeg(Common.cleanPath(pathFFmpeg));
			String pathFFprobe = getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin/").getPath() + "ffprobe.exe";
			FFprobe fprobe = new FFprobe(Common.cleanPath(pathFFprobe));
			FFmpegBuilder builder = new FFmpegBuilder();
			pathDestination = criteria.getPathDestination() + criteria.getNewFileName() + criteria.getNewExtension();
			builder.addInput(criteria.getPath()).overrideOutputFiles(true);
			if (! criteria.getIsAdvanced()) {
				builder.addOutput(pathDestination);

				FFmpegProbeResult probeResult = fprobe.probe(criteria.getPath());
				FFmpegExecutor executor = new FFmpegExecutor(fmpeg, fprobe);
				ConvertVideoProgress(executor, builder, probeResult);

			} else {
			convertAdvancedVideo(criteria, builder, fmpeg, fprobe);
		}
		} catch (IOException error) {
			log.error("Error in ConvertVideo", error);
		}
	}

	/**
	 * Convert the video with advances parameters like audioChannel, BitRate, SampleRate, Frame rate & Video resolution.
	 * @param criteria criteria for convert video.
	 * @param builder FFmpeg Builder.
	 * @param fmpeg FFmpeg app.
	 */
	private void convertAdvancedVideo(CriteriaConverterVideo criteria, FFmpegBuilder builder, FFmpeg fmpeg, FFprobe fprobe) {
			try {
			FFmpegOutputBuilder outputBuilder = new FFmpegOutputBuilder();
			outputBuilder.setFilename(pathDestination);
			if (! criteria.getAudioChannel().isEmpty()) {
				int channel = criteria.getAudioChannel() == "Mono" ? FFmpeg.AUDIO_MONO : FFmpeg.AUDIO_STEREO;
				outputBuilder.setAudioChannels(channel);
			}
			if (criteria.getFrameRate() != 0) {
				outputBuilder.setVideoFrameRate(criteria.getFrameRate());
			}
			if (! criteria.getVideoResolution().isEmpty()) {
				outputBuilder.setVideoResolution(criteria.getVideoResolution());
			}
			if (criteria.getBitRate() != 0) {
				outputBuilder.setAudioBitRate(criteria.getBitRate());
			}
			if (criteria.getSampleRate() != 0) {
				outputBuilder.setAudioSampleRate(criteria.getSampleRate());
			}
			builder.addOutput(outputBuilder);
			//fmpeg.run(builder);
				FFmpegExecutor executor = new FFmpegExecutor(fmpeg, fprobe);
				FFmpegProbeResult probeResult = fprobe.probe(criteria.getPath());
				ConvertVideoProgress(executor, builder, probeResult);
		} catch (IOException error) {
			log.error("Error in ConvertAdvancedAudio", error);
		}
	}

	/**
	 *
	 * @param executor
	 * @param builder
	 * @param pr
	 */
	public void ConvertVideoProgress(FFmpegExecutor executor, FFmpegBuilder builder, final FFmpegProbeResult pr) {
		FFmpegJob job = executor.createJob(builder, new ProgressListener() {

			// Using the FFmpegProbeResult determine the duration of the input
			private final double durationNs = pr.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

			@Override
			public void progress(final Progress progress) {
				double percentage = progress.out_time_ns / durationNs;
				// Print out interesting information about the progress
				JPanelConverterVideo.setProgressBarValue((int) (percentage * 100));
			}
		});

		try {
			job.run();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		if (job.getState() == FFmpegJob.State.FAILED) {
			convertResult = "The Convertion has failed. ";
			log.error("The Convertion has failed.");

		}
		if (job.getState() == FFmpegJob.State.FINISHED) {
			convertResult = "The Convertion has finished successfully.";
			log.info("The Convertion has finished successfully.");
		}
	}

}
