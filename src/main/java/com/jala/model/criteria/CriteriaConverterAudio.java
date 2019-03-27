/*
 * @(#) CriteriaConverterAudio.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.criteria;

/**
 * CriteriaConverterAudio
 *
 * @version 0.0.3
 * @author Regis Humana
 */
public class CriteriaConverterAudio extends CriteriaConverter {

	/**
	 * Audio channel can be stereo or mono
	 */
	private String audioChannel;

	/**
	 * Determinate if the converter is advanced.
	 */
	private boolean isAdvanced;

	/**
	 * Keep the long variable on bitRate
	 */
	private long bitRate;

	/**
	 * Keep the int variable on sampleRate
	 */
	private int sampleRate;

	/**
	 * This initialize with parameters of audioChannel, isAdvanced, bitRate and SampleRate.
	 * Even with the predefinition of path, pathDestination and newExtension.
	 * @param path
	 * @param pathDestination
	 * @param newExtension
	 */
	public CriteriaConverterAudio(String path, String pathDestination, String newExtension) {
		super(path, pathDestination, newExtension);
		audioChannel = "";
		isAdvanced = false;
		bitRate = 0;
		sampleRate = 0;
	}

	/**
	 * Obtain the AudioChannel
	 * @return
	 */
	public String getAudioChannel() {
		return audioChannel;
	}

	/**
	 * Set the AudioChannel
	 * @return
	 */
	public void setAudioChannel(String audioChannel) {
		this.audioChannel = audioChannel;
	}

	/**
	 * Obtain the isAdvanced boolean
	 * @return
	 */
	public boolean isAdvanced() {
		return isAdvanced;
	}

	/**
	 * Set the isAdvanced boolean
	 * @return
	 */
	public void setAdvanced(boolean advanced) {
		isAdvanced = advanced;
	}

	/**
	 * Obtain the BitRate
	 * @return
	 */
	public long getBitRate() {
		return bitRate;
	}

	/**
	 * Set the BitRate
	 * @return
	 */
	public void setBitRate(long bitRate) {
		this.bitRate = bitRate;
	}

	/**
	 * Obtain the SampleRate
	 * @return
	 */
	public int getSampleRate() {
		return sampleRate;
	}

	/**
	 * Set the SampleRate
	 * @return
	 */
	public void setSampleRate(int sampleRate) {
		this.sampleRate = sampleRate;
	}
}
