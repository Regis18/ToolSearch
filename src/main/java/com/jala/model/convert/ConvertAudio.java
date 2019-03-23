/*
 * @(#) ConvertAudio.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.model.criteria.CriteriaConverterAudio;
import com.jala.utils.Common;
import com.jala.utils.Logs;
import com.jala.view.JPanelConverterVideo;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.builder.FFmpegOutputBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * This class used the FFmpeg app for Convert of format an audio .
 * @author Regis Humana
 * @version 0.0.3
 */
public class ConvertAudio implements IConvertible {

	/**Save the real path destination to send to FFMPEG.*/
	private String pathDestination;

	/** It creates to follow up the instruction of the class.*/
	private Logger log = Logs.getInstance().getLog();

	/** Var for error messages.*/
	private String convertResult;

	/**
	 * Convert formats of music into another extension - basic.
	 * @param criteriaObject criteria for convert audio.
	 */
	@Override
	public void convert(Object criteriaObject) {
		CriteriaConverterAudio criteria = (CriteriaConverterAudio) criteriaObject;
		try {
			String pathFFmpeg = getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin/").getPath() + "ffmpeg.exe";
			FFmpeg fmpeg = new FFmpeg(Common.cleanPath(pathFFmpeg));
			String pathFFprobe = getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin/").getPath() + "ffprobe.exe";
			FFprobe fprobe = new FFprobe(Common.cleanPath(pathFFprobe));
			FFmpegBuilder builder = new FFmpegBuilder();
			pathDestination = criteria.getPathDestination() + criteria.getNewFileName() + criteria.getNewExtension();
			builder.addInput(criteria.getPath()).overrideOutputFiles(true);
			if (! criteria.isAdvanced()) {
				builder.addOutput(pathDestination);
				FFmpegProbeResult probeResult = fprobe.probe(criteria.getPath());
				FFmpegExecutor executor = new FFmpegExecutor(fmpeg, fprobe);
				ConvertVideoProgress(executor, builder, probeResult);
			} else {
				convertAdvancedAudio(criteria, builder, fmpeg, fprobe);
			}
		} catch (IOException error) {
			log.error("Error in ConvertAudio", error);
		}
	}

	/**
	 * Convert the music with advances parameters like audioChannel, BitRate and SampleRate.
	 * @param criteria for convert audio.
	 * @param builder FFmpeg builder.
	 * @param fmpeg converter app.
	 */
	private void convertAdvancedAudio(CriteriaConverterAudio criteria, FFmpegBuilder builder, FFmpeg fmpeg, FFprobe fprobe) {
		try {
			FFmpegOutputBuilder outputBuilder = new FFmpegOutputBuilder();
			outputBuilder.setFilename(pathDestination);
			if (! criteria.getAudioChannel().isEmpty()) {
				int channel = criteria.getAudioChannel() == "Mono" ? FFmpeg.AUDIO_MONO : FFmpeg.AUDIO_STEREO;
				outputBuilder.setAudioChannels(channel);
			}
			if (criteria.getBitRate() != 0) {
				outputBuilder.setAudioBitRate(criteria.getBitRate());
			}
			if (criteria.getSampleRate() != 0) {
				outputBuilder.setAudioSampleRate(criteria.getSampleRate());
			}
			builder.addOutput(outputBuilder);
			FFmpegProbeResult probeResult = fprobe.probe(criteria.getPath());
			FFmpegExecutor executor = new FFmpegExecutor(fmpeg, fprobe);
			ConvertVideoProgress(executor, builder, probeResult);
		} catch (IOException error) {
			log.error("Error in ConvertAdvancedAudio", error);
		}
	}

	/**
	 * Method for convert the video and audio using the FFmpeg and FFprobe and show the progress.
	 * @param executor this method is who do the progress.
	 * @param builder is who do the convert.
	 * @param pr is the library.
	 */
	public void ConvertVideoProgress(FFmpegExecutor executor, FFmpegBuilder builder, final FFmpegProbeResult pr) {
		FFmpegJob job = executor.createJob(builder, new ProgressListener() {
			private final double durationNs = pr.getFormat().duration * TimeUnit.SECONDS.toNanos(1);
			@Override
			public void progress(final Progress progress) {
				double percentage = progress.out_time_ns / durationNs;
				if((int) (percentage * 100) <= 100) {
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
			convertResult = "The Convertion has failed. ";
			log.error("The Convertion has failed.");
		}
		if (job.getState() == FFmpegJob.State.FINISHED) {
			JPanelConverterVideo.setProgressBarValue(100);
			convertResult = "The Convertion has finished successfully.";
			log.info("The Convertion has finished successfully.");
		}
	}
}
