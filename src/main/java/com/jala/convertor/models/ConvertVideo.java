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
import com.google.common.base.Joiner;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.FFmpeg;

public class ConvertVideo {


	private static String AUDIO_MP3_CODEC = "libmp3lame";
	private static String pathOrigin;
	private static String pathDestination;

	public static void main(String [] args) throws Exception {
		pathOrigin = "C:\\Users\\Usuario\\Desktop\\JALA\\Prog02\\Videos\\try1.mp4";
		pathDestination = "C:\\Users\\Usuario\\Desktop\\JALA\\Prog02\\Videos\\try123.3gp";
		FFmpeg fmpeg = new FFmpeg("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\ffmpeg\\bin\\ffmpeg.exe");
		FFmpegBuilder builder = new FFmpegBuilder();

		builder.addInput(pathOrigin)
					.overrideOutputFiles(true)
					.addOutput(pathDestination)
					.setVideoResolution("qcif")
					.setAudioChannels(FFmpeg.AUDIO_MONO)
					.setVideoBitRate(256000)
					.done();/*.
				setAudioChannels(FFmpeg.AUDIO_STEREO).
				setVideoFrameRate(FFmpeg.FPS_29_97).
				setVideoResolution("svga");
		/*builder.addOutput("C:\\Users\\Admin\\Desktop\\o\\hola.mp3").setAudioCodec("libmp3lane")
				.setAudioChannels(FFmpeg.AUDIO_MONO)
				.setAudioBitRate(FFmpeg.AUDIO_SAMPLE_48000)
				.setAudioSampleRate(FFmpeg.AUDIO_SAMPLE_16000)
				.done();*/
		String actual = Joiner.on(" ").join(fmpeg.path(builder.build()));
		System.out.println(actual);
		fmpeg.run(builder);

	}
}
