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
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.builder.FFmpegOutputBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;

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
			FFmpegBuilder builder = new FFmpegBuilder();
			pathDestination = criteria.getPathDestination() + criteria.getNewFileName() + criteria.getNewExtension();
			builder.addInput(criteria.getPath()).overrideOutputFiles(true);
			if (! criteria.isAdvanced()) {
				builder.addOutput(pathDestination);
				fmpeg.run(builder);
			} else {
				convertAdvancedMusic(criteria, builder, fmpeg);
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
	private void convertAdvancedMusic(CriteriaConverterAudio criteria, FFmpegBuilder builder, FFmpeg fmpeg) {
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
			fmpeg.run(builder);
		} catch (IOException error) {
			log.error("Error in ConvertAdvancedMusic", error);
		}
	}
}
