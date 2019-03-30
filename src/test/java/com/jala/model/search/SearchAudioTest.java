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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * SearchAudioTest
 *
 * @version 0.0.3
 * @author Regis Humana
 */
public class SearchAudioTest {
	private CriteriaSearchMultimedia criteria;
	private SearchAudio searchAudio;
	@Before
	public void setUp() {
		String path = "..\\ToolSearch\\src\\test\\resources\\audio";
		criteria = new CriteriaSearchMultimedia(path);
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
		Assert.assertFalse(result.isEmpty());
	}

	/**
	 * Extension : aac
	 * Channel: mono
	 */
	@Test
	public void search_returnAac_WhenSendPathMultimediaMono() {
		criteria.setExtension("aac");
		criteria.setChannel("mono");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		Assert.assertFalse(result.isEmpty());
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
		Assert.assertFalse(result.isEmpty());
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
		Assert.assertFalse(result.isEmpty());
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
		Assert.assertFalse(result.isEmpty());
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
		Assert.assertTrue(result.isEmpty());
	}

	/**
	 * Extension : mp3
	 * Creation Date: 2019-03-29
	 */
	@Test
	public void search_returnMP3_WhenSendPathMultimediaCreationDate() {
		criteria.setExtension("mp3");
		criteria.setCreationDateFrom("2019-03-29");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		Assert.assertFalse(result.isEmpty());
	}

	/**
	 * Extension : mp3
	 * Modification Date: 2018-04-05
	 */
	@Test
	public void search_returnMP3_WhenSendPathMultimediaModificationDate() {
		criteria.setExtension("mp3");
		criteria.setModificationDateFrom("2016-11-21");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		Assert.assertFalse(result.isEmpty());
	}

	/**
	 * Extension : mp3
	 * Modification Date: 2021-04-05
	 */
	@Test
	public void search_returnError_WhenSendPathMultimediaModificationDate() {
		criteria.setExtension("mp3");
		criteria.setModificationDateFrom("2021-11-21");
		searchAudio = new SearchAudio(criteria);
		List<Asset> result = searchAudio.search();
		Assert.assertTrue(result.isEmpty());
	}
}