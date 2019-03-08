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
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.options.VideoEncodingOptions;
import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.options.EncodingOptions;
import net.bramp.ffmpeg.options.AudioEncodingOptions;

import java.beans.XMLEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ws.schild.jave.MultimediaObject;
public class ConvertVideo {


	private static String AUDIO_MP3_CODEC = "libmp3lame";


	public static void main(String [] args) throws Exception {
		/*FFprobe probe  = new FFprobe("C:\\Users\\Admin\\ToolSearch\\src\\main\\resources\\ThirdParty\\ffmpeg\\bin\\ffprobe.exe");
		probe.probe("C:\\Users\\Admin\\Desktop\\o\\hola.mp3");
		List<String> ff = new ArrayList<>();
		probe.run(ff);
		EncodingOptions sss = new EncodingOptions();
		AudioEncodingOptions audioEncodingOptions = new AudioEncodingOptions();
		VideoEncodingOptions a = new VideoEncodingOptions();*/
		FFmpeg ss = new FFmpeg("C:\\Users\\Admin\\ToolSearch\\src\\main\\resources\\ThirdParty\\ffmpeg\\bin\\ffmpeg.exe");
		FFmpegBuilder rr = new FFmpegBuilder();

		rr.addInput("C:\\Users\\Admin\\Desktop\\o\\hola.mp4");
		rr.addOutput("C:\\Users\\Admin\\Desktop\\o\\hola.mp3")
				.setAudioChannels(FFmpeg.AUDIO_MONO)
				.setAudioBitRate(FFmpeg.AUDIO_SAMPLE_48000)
				.setAudioSampleRate(FFmpeg.AUDIO_SAMPLE_16000)
				.done();

		ss.run(rr);

	}
}
