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

package com.jala.search.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchVideoTest {
	private SearchVideo searchVideo;
	private CriteriaSearchMultimedia criteria;
	@Before
	public void setUp() throws Exception {
		 criteria = new CriteriaSearchMultimedia("C:\\Users\\Admin\\Desktop\\o");
	}

	@Test
	public void search_returnMP4_WhenSendPathMultimedia() {
		criteria.setExtension("mp4");
		criteria.setChannel("mono");
		searchVideo = new SearchVideo(criteria);
		List<Asset> result = searchVideo.search();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getPath());
		}
	}
}