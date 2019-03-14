/*
 * @(#) ConvertMusicTest.java Copyright (c) 2019 Jala Foundation.
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
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConvertMusicTest
 *
 * @version 0.0.3
 * @author Regis Humana
 */
public class ConvertMusicTest {

	private String path = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos\\mMP3.mp3";
	private String pathDestination = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos\\Audio";

	/**
	 * Convert MP3 to WMV basic
	 */
	@Test
	public void convert_ReturnWMAFile_WhenSentBasicMP3File() {
		ConvertMusic convert = new ConvertMusic();
		CriteriaConverterAudio criteria = new CriteriaConverterAudio(path,pathDestination + "\\",".wmv");
		criteria.setNewFileName("AudioWmv");
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".wmv");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP3 to AAC basic
	 */
	@Test
	public void convert_ReturnAACFile_WhenSentBasicMP3File() {
		ConvertMusic convert = new ConvertMusic();
		CriteriaConverterAudio criteria = new CriteriaConverterAudio(path,pathDestination + "\\",".aac");
		criteria.setNewFileName("AudioAAC");
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".aac");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP3 to AAC Advanced
	 * Channel = mono
	 * Sample = 8000
	 * BitRate = 196608
	 */
	@Test
	public void convert_ReturnAACFile_WhenSentAdvancedMP3File() {
		ConvertMusic convert = new ConvertMusic();
		CriteriaConverterAudio criteria = new CriteriaConverterAudio(path,pathDestination + "\\",".aac");
		criteria.setNewFileName("AudioAdvancedAAC");
		criteria.setAdvanced(true);
		criteria.setAudioChannel("Mono");
		criteria.setSampleRate(8000);
		criteria.setBitRate(8000);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".aac");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Verify the information of multimedia
	 * @param path
	 * @throws IOException
	 */
	public void verifyWithFfmpegProbe(String path) throws IOException {
		FFprobe ffprobe = new FFprobe("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\ffmpeg\\bin\\ffprobe.exe");
		System.out.println("Duracion: " + ffprobe.probe(path).getStreams().get(0).duration);
		String ds = ffprobe.probe(path).getStreams().get(0).codec_name;
		List<String> list = new ArrayList<>();
		ffprobe.run(list);
	}
}