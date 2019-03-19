/*
 * @(#) SearchCommonTest.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.model.criteria.CriteriaSearch;
import org.junit.Test;

public class SearchCommonTest {

	/**
	 * Search just path.
	 */
	@Test
	public void getResult_ReturnPaths_WhenSentPath() {
		CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Usuario\\Desktop\\JALA\\Prog02");
		SearchCommon search = new SearchCommon(criteriaSearch);
		for (int i = 0; i < search.search().size(); i++) {
			System.out.println(search.search().get(i).getPath());
		}
	}

	/**
	 * Extension : mp4.
	 */
	@Test
	public void getResult_ReturnPaths_WhenSentOnlyMP4() {
		CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\o");
		criteriaSearch.setExtension("mp4");
		SearchCommon search = new SearchCommon(criteriaSearch);
		for (int i = 0; i < search.search().size(); i++) {
			System.out.println(search.search().get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * Hidden: true
	 */
	@Test
	public void getResult_ReturnHidden_WhenSentPath() {
		CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\o");
		criteriaSearch.setExtension("mp4");
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		for (int i = 0; i < search.search().size(); i++) {
			System.out.println(search.search().get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * Hidden: false.
	 */
	@Test
	public void getResult_ReturnReadTrue_WhenSentPath() {
		CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\o");
		criteriaSearch.setExtension("mp4");
		criteriaSearch.setReadonly(TernaryBooleanEnum.OnlyFalse);
		SearchCommon search = new SearchCommon(criteriaSearch);
		for (int i = 0; i < search.search().size(); i++) {
			System.out.println(search.search().get(i).getPath());
		}
	}

	/**
	 * Extension : mp3
	 * Hidden: true.
	 * ReadOnly: true.
	 */
	@Test
	public void getResult_ReturnReadHiddenTrue_WhenSentPath() {
		CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\o");
		criteriaSearch.setExtension("mp4");
		criteriaSearch.setReadonly(TernaryBooleanEnum.OnlyTrue);
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		for (int i = 0; i < search.search().size(); i++) {
			System.out.println(search.search().get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * Hidden: true.
	 * ReadOnly: false.
	 */
	@Test
	public void getResult_ReturnReadFalseHiddenTrue_WhenSentPath() {
		CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\o");
		criteriaSearch.setExtension("mp4");
		criteriaSearch.setReadonly(TernaryBooleanEnum.OnlyFalse);
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyTrue);
		SearchCommon search = new SearchCommon(criteriaSearch);
		for (int i = 0; i < search.search().size(); i++) {
			System.out.println(search.search().get(i).getPath());
		}
	}

	/**
	 * Extension : mp4
	 * Hidden: false.
	 * ReadOnly: true.
	 */
	@Test
	public void getResult_ReturnReadTrueHiddenFalse_WhenSentPath() {
		CriteriaSearch criteriaSearch = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\o");
		criteriaSearch.setExtension("mp4");
		criteriaSearch.setReadonly(TernaryBooleanEnum.OnlyTrue);
		criteriaSearch.setHidden(TernaryBooleanEnum.OnlyFalse);
		SearchCommon search = new SearchCommon(criteriaSearch);
		for (int i = 0; i < search.search().size(); i++) {
			System.out.println(search.search().get(i).getPath());
		}
	}
}