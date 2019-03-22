/*
 * @(#) SearchBasicTest.java Copyright (c) 2019 Jala Foundation.
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
import com.jala.model.search.asset.Asset;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchBasicTest {

	private SearchCommon search;
	private List<Asset> list = new ArrayList<>();
	private CriteriaSearch criteriaSearch;
	@Before
	public void setUp() throws Exception {
		String path = "C:\\Users\\Admin\\Desktop\\o";
		criteriaSearch = new CriteriaSearch(path);

	}

	@Test
	public void search() {
		search = new SearchCommon(criteriaSearch);
		list = search.search();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getPath());
			System.out.println(list.get(i).isReadOnly());
		}
	}

	@Test
	public void search_ReturnHidden_WhenSentReadTrue() {
		criteriaSearch.setReadOnly(TernaryBooleanEnum.OnlyTrue);
		search = new SearchCommon(criteriaSearch);
		list = search.search();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("FIN");
			System.out.println(list.get(i).getPath());
			System.out.println(list.get(i).isReadOnly());

		}
	}

}