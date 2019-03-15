/*
 * @(#) ConvertVideoTest.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.model.ConvertVideo;
import com.jala.model.criteria.CriteriaConverterVideo;
import org.junit.Test;
import net.bramp.ffmpeg.FFprobe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConvertVideoTest
 *
 * @version 0.0.3
 * @author Regis Humana
 */
public class ConvertVideoTest {
	private String path = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos\\Marvel.mp4";
	private String pathDestination = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos";

	/**
	 * Convert MP4 to WMV basic
	 */
	@Test
	public void convert_ReturnFlvFile_WhenSentBasicMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".wmv");
		criteria.setNewFileName("Ver");
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".wmv");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to FLV advanced with only MONO
	 */
	@Test
	public void convert_ReturnFlvFile_WhenSentAdvancedSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".flv");
		criteria.setNewFileName("mAdvanced");
		criteria.setIsAdvanced(true);
		criteria.setAudioChannel("Mono");
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".flv");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to FLV advanced with only resolution
	 */
	@Test
	public void convert_ReturnFlvFileResolution_WhenSentAdvancedSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".flv");
		criteria.setNewFileName("mAdvanced");
		criteria.setIsAdvanced(true);
		criteria.setVideoResolution("svga");
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".flv");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to WMV advanced with only resolution
	 */
	@Test
	public void convert_ReturnWmvFileResolution_WhenSentAdvancedSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".wmv");
		criteria.setNewFileName("mAdvanced");
		criteria.setIsAdvanced(true);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".wmv");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to 3gp advanced with only resolution
	 */
	@Test
	public void convert_Return3gpFile_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".3gp");
		criteria.setNewFileName("m3gp");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".3gp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to MKV advanced with only resolution
	 */
	@Test
	public void convert_ReturnMKVFile_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".mkv");
		criteria.setNewFileName("mmkv");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".mkv");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to AVI advanced with only resolution
	 */
	@Test
	public void convert_ReturnAVIFile_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".avi");
		criteria.setNewFileName("mAVI");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".avi");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to MOV advanced with only resolution
	 */
	@Test
	public void convert_ReturnMOVFile_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".mov");
		criteria.setNewFileName("mAVI");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".mov");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to VOB advanced with only resolution
	 */
	@Test
	public void convert_ReturnVOBFile_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".VOB");
		criteria.setNewFileName("mAVI");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".VOB");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**Delete, is not correct.
	 * Convert MP4 to DVD advanced with only resolution
	 */
	@Test
	public void convert_ReturnDVDFile_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".DVD");
		criteria.setNewFileName("mDVD");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".DVD");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to OGV advanced with only resolution
	 */
	@Test
	public void convert_ReturnOGVFile_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".ogv");
		criteria.setNewFileName("mOGV");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".ogv");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to mp3 advanced with only resolution
	 */
	@Test
	public void convert_ReturnMP3File_WhenSentBasicSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".aac");
		criteria.setNewFileName("mAAC");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".aac");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to mp3 advanced with only resolution
	 */
	@Test
	public void convert_ReturnMP4File_WhenSentBasicSentMP3File() {
		path = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos\\mMP3.mp3";
		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".mp4");
		criteria.setNewFileName("pruebaMp3toMp4");
		criteria.setIsAdvanced(false);
		criteria.setFrameRate(60.0);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".mp4");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Convert MP4 to mp3 advanced with only resolution
	 */
	@Test
	public void convert_ReturnMP4File_WhenSendAdvancedSentMP4File() {
		path = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos\\mMP3.mp3";
		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".mp4");
		criteria.setNewFileName("MP4File");
		criteria.setIsAdvanced(true);
		criteria.setAudioChannel("Stereo");
		criteria.setVideoResolution("hd720");
		criteria.setFrameRate(60.0);
		criteria.setSampleRate(8000);
		criteria.setBitRate(8000);
		try {
			convert.convert(criteria);
			verifyWithFfmpegProbe(pathDestination + "\\" + criteria.getNewFileName() + ".mp4");
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