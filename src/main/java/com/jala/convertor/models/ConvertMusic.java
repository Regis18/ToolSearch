/*
 * @(#) ConvertMusic.java Copyright (c) 2019 Jala Foundation.
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

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.builder.FFmpegOutputBuilder;

public class ConvertMusic {
	private String pathDestination;

	/**
	 * Convert formats of video into another extension - basic.
	 * @param criteria
	 * @throws Exception
	 */
	public void convert(CriteriaConverterAudio criteria) throws Exception {

		FFmpeg fmpeg = new FFmpeg(getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin").getPath());
		FFmpegBuilder builder = new FFmpegBuilder();
		pathDestination = criteria.getPathDestination() + criteria.getNewFileName() + criteria.getNewExtension();
		builder.addInput(criteria.getPath()).overrideOutputFiles(true);
		if (!criteria.isAdvanced()) {
			builder.addOutput(pathDestination);
			fmpeg.run(builder);
		} else {
			convertAdvancedVideo(criteria, builder, fmpeg);
		}
	}

	/**
	 * Convert with advanced parameters.
	 * @param criteria
	 * @param builder
	 * @param fmpeg
	 * @throws Exception
	 */
	private void convertAdvancedVideo(CriteriaConverterAudio criteria, FFmpegBuilder builder, FFmpeg fmpeg) throws Exception {
		FFmpegOutputBuilder outputBuilder = new FFmpegOutputBuilder();
		outputBuilder.setFilename(pathDestination);
		if (!criteria.getAudioChannel().isEmpty()) {
			int channel = criteria.getAudioChannel() == "Mono" ? FFmpeg.AUDIO_MONO : FFmpeg.AUDIO_STEREO;
			outputBuilder.setAudioChannels(channel);
		}
		if (criteria.getFrameRate() != 0) {
			outputBuilder.setVideoFrameRate(criteria.getFrameRate())
						.setAudioSampleRate(FFmpeg.);
		}
		if (!criteria.getVideoResolution().isEmpty()) {
			outputBuilder.setVideoResolution(criteria.getVideoResolution());
		}
		builder.addOutput(outputBuilder);
		fmpeg.run(builder);
	}
}
