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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import net.bramp.ffmpeg.FFprobe;
import java.util.ArrayList;
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
	private static final String IPATH = "src\\test\\java\\com\\jala\\model\\search\\testsearch";

	@Before

	public void setUp() {
		criteria = new CriteriaSearchMultimedia(IPATH);
	}

	/**
	 * Extension : mp4
	 * Channel: stereo
	 */
	@Test
	public void searchVideoExtensionChannelTest() {
		criteria.setExtension("mp4");
		criteria.setChannel("stereo");
		searchVideo = new SearchVideo(criteria);
		SearchFile sf = new SearchFile();
		List<Asset> assetList = sf.search(criteria);
		assertEquals(1, assetList.size());
	}

	/**
	 * Extension : mp4
	 * AudioCodec: H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10
	 */
	@Test
	public void searchVideoAudioCodecTestExtension() {
		criteria.setExtension("mp4");
			criteria.setAudioCodec("H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(1, result.size());
	}

	/**
	 * Extension : mp4
	 * VideoCodec: H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10
	 */
	@Test
	public void searchVideVideoCodecExtensionTest() {
		criteria.setExtension("mp4");
			criteria.setVideoCodec("H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(1, result.size());
	}

	/**
	 * Extension : mp4
	 * AudioSampleRate: 44100
	 */
	@Test
	public void searchVideoSampleRatExtensioneTest() {
		criteria.setExtension("mp4");
		criteria.setAudioSampleRate("44100");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(1, result.size());
	}

	/**
	 * AspectRatio: 320:133
	 */
	@Test
	public void searchVideoAspectRatioTest() {
		criteria.setAspectRatio("320:133");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(2, result.size());
	}
	/**
	 * Extension : mp4
	 * AspectRatio: 320:133
	 */
	@Test
	public void searchVideoAspectRatioExtensionTest() {
		criteria.setExtension("mp4");
		criteria.setAspectRatio("320:133");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(1, result.size());
	}
	/**
	 * Extension : mp4
	 * FrameRate: 23.98
	 */
	@Test
	public void searchVideoFrameRateTest() {
		criteria.setExtension("mp4");
		criteria.setFrameRate("23.98");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(1, result.size());
	}

	/**
	 * Extension : mp4
	 * Duration: emply
	 */
	@Test
	public void searchVideoDurationTest() {
		criteria.setExtension("mp4");
		criteria.setDuration("");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(1, result.size());
	}

	/**
	 * AspectRatio: 320:133
	 * AudioSampleRate: 44100
	 */
	@Test
	public void searchVideoAspectRatioAudioSampleRateTest() {
		criteria.setAspectRatio("320:133");
		criteria.setAudioSampleRate("44100");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(1, result.size());
	}

	/**
	 * AspectRatio: 320:133
	 * AudioSampleRate: 44100
	 */
	@Test
	public void searchVideoFrameRateAudioSampleRateTest() {
		criteria.setFrameRate("60");
		criteria.setAudioSampleRate("44100");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		assertEquals(3, result.size());
	}
}