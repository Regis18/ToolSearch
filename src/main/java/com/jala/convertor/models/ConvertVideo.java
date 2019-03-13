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

package com.jala.convertor.models;

import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.builder.FFmpegOutputBuilder;

/**
 * ConvertVideo
 *
 * @version 0.0.3
 * @author Regis Humana
 */
public class ConvertVideo {

	private String pathDestination;
	/**
	 * Convert formats of video into another extension - basic.
	 * @param criteria
	 * @throws Exception
	 */
	public void convert(CriteriaConverterVideo criteria) throws Exception {

		FFmpeg fmpeg = new FFmpeg("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\ffmpeg\\bin\\ffmpeg.exe");
		FFmpegBuilder builder = new FFmpegBuilder();
		pathDestination = criteria.getPathDestination() + criteria.getNewFileName() + criteria.getNewExtension();
		builder.addInput(criteria.getPath()).overrideOutputFiles(true);
		if (!criteria.getIsAdvanced()) {
			builder.addOutput(pathDestination);
			fmpeg.run(builder);
		} else {
			convertAdvanced(criteria, builder, fmpeg);
		}
	}

	/**
	 * Convert with advanced parameters.
	 * @param criteria
	 * @param builder
	 * @param fmpeg
	 * @throws Exception
	 */
	private void convertAdvanced(CriteriaConverterVideo criteria, FFmpegBuilder builder, FFmpeg fmpeg) throws Exception {
		FFmpegOutputBuilder outputBuilder = new FFmpegOutputBuilder();
		outputBuilder.setFilename(pathDestination);
		if (!criteria.getAudioChannel().isEmpty()) {
			int channel = criteria.getAudioChannel() == "Mono" ? FFmpeg.AUDIO_MONO : FFmpeg.AUDIO_STEREO;
			outputBuilder.setAudioChannels(channel);
		}
		if (criteria.getFrameRate() != 0) {
			outputBuilder.setVideoFrameRate(criteria.getFrameRate());
		}
		if (!criteria.getVideoResolution().isEmpty()){
			outputBuilder.setVideoResolution(criteria.getVideoResolution());
		}
		builder.addOutput(outputBuilder);
		fmpeg.run(builder);
	}
}
