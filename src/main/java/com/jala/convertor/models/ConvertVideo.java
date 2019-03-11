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
		pathDestination = criteria.getPathDestination() + criteria.getFileName() + criteria.getExtension();
		builder.addInput(criteria.getPathOrigin()).overrideOutputFiles(true);
		if (!criteria.getIsAdvanced()) {
			builder.addOutput(pathDestination);
			fmpeg.run(builder);
		} else {
			convertAdvanced(criteria, builder,fmpeg);
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
		int channel = criteria.getAudioChannel() == "Mono" ? FFmpeg.AUDIO_MONO : FFmpeg.AUDIO_STEREO;
		builder.addOutput(pathDestination)
				.setVideoResolution(criteria.getVideoResolution())
				.setVideoFrameRate(criteria.getFrameRate())
				.setAudioChannels(channel)
				//.setVideoBitRate(256000)
				.done();
		fmpeg.run(builder);
	}
}
