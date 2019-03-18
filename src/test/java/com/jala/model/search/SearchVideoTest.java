/*
 * @(#) SearchVideoTest.java Copyright (c) 2019 Jala Foundation.
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
import com.jala.model.search.asset.AssetVideo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * SearchVideoTest
 *
 * @version 0.0.3
 * @author Regis Humana
 */
public class SearchVideoTest {
	private SearchVideo searchVideo;
	private CriteriaSearchMultimedia criteria;
	@Before
	public void setUp() {
		criteria = new CriteriaSearchMultimedia("C:\\Users\\Admin\\Desktop\\PROG 02\\Videos");
	}

	/**
	 * Extension : mp4
	 * Channel: stereo
	 */
	@Test
	public void search_returnMP4_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setChannel("stereo");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * AudioCodec: AAC
	 */
	@Test
	public void search_returnAudioCodec_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setAudioCodec("AAC");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetVideo)result.get(i)).getAudioCodec());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * VideoCodec: H.264
	 */
	@Test
	public void search_returnVideoCodec_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setVideoCodec("H.264");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetVideo)result.get(i)).getVideoCodec());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * AudioSampleRate: 44100
	 */
	@Test
	public void search_returnSampleRate_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setAudioSampleRate("44100");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetVideo)result.get(i)).getAudioSampleRate());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * AspectRatio: 16:9
	 */
	@Test
	public void search_returnAspectRatio_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setAspectRatio("16:9");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetVideo)result.get(i)).getAspectRatio());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * FrameRate: 29.97
	 */
	@Test
	public void search_returnFrameRate_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setFrameRate("29.97");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetVideo)result.get(i)).getFrameRate());
			System.out.println(result.get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * Duration: 10
	 */
	@Test
	public void search_returnDuration_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setDuration("10");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((AssetVideo)result.get(i)).getDuration());
			System.out.println(result.get(i).getPath());
		}
	}
}