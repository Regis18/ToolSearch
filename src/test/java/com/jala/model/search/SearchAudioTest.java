/*
 * @(#) SearchAudioTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.search;


import com.jala.model.criteria.CriteriaSearchMultimedia;
import com.jala.model.search.asset.Asset;
import com.jala.model.search.asset.AssetAudio;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SearchAudioTest {
	CriteriaSearchMultimedia criteria;
	SearchAudio searchAudio;
	@Before
	public void setUp() {
		criteria = new CriteriaSearchMultimedia("C:\\Users\\Usuario\\Desktop\\Semana Santa");
	}

	/**
	 * Extension : mp3
	 * Channel: stereo
	 */
	@Test
	public void search_returnMP3_WhenSendPathMultimediaStereo() {
		criteria.setExtension("mp3");
		criteria.setChannel("stereo");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp3
	 * Channel: mono
	 */
	@Test
	public void search_returnMP3_WhenSendPathMultimediaMono() {
		criteria.setExtension("mp3");
		criteria.setChannel("mono");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp3
	 * Audio Codec: MPEG
	 */
	@Test
	public void search_returnMP3_WhenSendPathMultimediaAudioCodec() {
		criteria.setExtension("mp3");
		criteria.setAudioCodec("MPEG");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetAudio)result.get(i)).getAudioCodec());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp3
	 * Sample Rate: 44100
	 */
	@Test
	public void search_returnMP3_WhenSendPathMultimediaSampleRate() {
		criteria.setExtension("mp3");
		criteria.setAudioSampleRate("44105");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetAudio)result.get(i)).getAudioSampleRate());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp3
	 * Duration: 4.5 min
	 */
	@Test
	public void search_returnMP3_WhenSendPathMultimediaDuration() {
		criteria.setExtension("mp3");
		criteria.setDuration("4.5");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetAudio)result.get(i)).getDuration());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp3
	 * Duration: letters 4.5L
	 */
	@Test
	public void search_returnERROR_WhenSendPathMultimediaDuration() {
		criteria.setExtension("mp3");
		criteria.setDuration("4.5L");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetAudio)result.get(i)).getDuration());
			System.out.println(result.get(i).getPath());
		}
	}
}