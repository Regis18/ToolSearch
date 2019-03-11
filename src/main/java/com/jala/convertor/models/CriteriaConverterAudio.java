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

package com.jala.convertor.models;

public class CriteriaConverterAudio extends CriteriaConverter {

	/**
	 * Audio channel can be stereo or mono
	 */
	private String audioChannel;

	/**
	 * Determinate if the converter is advanced.
	 */
	private boolean isAdvanced;

	public CriteriaConverterAudio(String path, String pathDestination, String newExtension) {
		super(path, pathDestination, newExtension);
		audioChannel = "";
		isAdvanced = false;
	}

	public String getAudioChannel() {
		return audioChannel;
	}

	public void setAudioChannel(String audioChannel) {
		this.audioChannel = audioChannel;
	}

	public boolean isAdvanced() {
		return isAdvanced;
	}

	public void setAdvanced(boolean advanced) {
		isAdvanced = advanced;
	}
}
