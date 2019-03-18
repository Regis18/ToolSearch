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
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.builder.FFmpegOutputBuilder;
import org.apache.log4j.Logger;
import com.jala.utils.Common;

import java.io.IOException;

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
	 * Convert formats of video into another extension - basic.
	 * @param criteriaObject criteria for convert video.
	 */
	public void convert(Object criteriaObject) {
		CriteriaConverterVideo criteria = (CriteriaConverterVideo) criteriaObject;
		try {
			String pathFFmpeg = getClass().getClassLoader().getResource("ThirdParty/ffmpeg/bin/").getPath() + "ffmpeg.exe";
			FFmpeg fmpeg = new FFmpeg(Common.cleanPath(pathFFmpeg));
			FFmpegBuilder builder = new FFmpegBuilder();
			pathDestination = criteria.getPathDestination() + criteria.getNewFileName() + criteria.getNewExtension();
			builder.addInput(criteria.getPath()).overrideOutputFiles(true);
			if (! criteria.getIsAdvanced()) {
				builder.addOutput(pathDestination);
				fmpeg.run(builder);
			} else {
				convertAdvancedVideo(criteria, builder, fmpeg);
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
	private void convertAdvancedVideo(CriteriaConverterVideo criteria, FFmpegBuilder builder, FFmpeg fmpeg) {
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
			fmpeg.run(builder);
		} catch (IOException error) {
			log.error("Error in ConvertAdvancedAudio", error);
		}
	}
}
