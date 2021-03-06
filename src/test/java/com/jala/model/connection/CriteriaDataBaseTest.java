/*
 * @(#) CriteriaDataBaseTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.connection;

import com.jala.model.criteria.CriteriaName;
import com.jala.model.criteria.CriteriaSearch;

import org.junit.Test;

import java.util.List;


public class CriteriaDataBaseTest {
	/**
	 * Save the criteria that user send.
	 */
	@Test
	public void saveCriteria() {
		CriteriaDataBase criteriaDataBase = new CriteriaDataBase();
		CriteriaSearch criteria = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\PROG 02");
		criteria.setNameCriteria("Yudi");
		criteriaDataBase.saveCriteria(criteria);
	}

	/**
	 * Load the criteria.
	 */
	@Test
	public void loadCriteria() {
		CriteriaDataBase criteriaDataBase = new CriteriaDataBase();
		/*CriteriaSearch criteria = new CriteriaSearch("C:\\Users\\Admin\\Desktop");
		criteria.setNameCriteria("Enrique");
		criteriaDataBase.saveCriteria(criteria);*/
		List<CriteriaName> criteriaName;
		criteriaName = criteriaDataBase.loadCriteria();
		for (int i = 0; i < criteriaName.size(); i++) {
			System.out.println(criteriaName.get(i).getName());
			System.out.println(criteriaName.get(i).getId());
		}

	}

	/**
	 * Add and get Criteria.
	 */
	@Test
	public void getCriteria() {
		CriteriaDataBase criteriaDataBase = new CriteriaDataBase();
		CriteriaSearch criteriaSearch = criteriaDataBase.getCriteria(1);
		System.out.println(criteriaSearch.getNameCriteria());
	}

	/**
	 * Delete criteria selected.
	 */
	@Test
	public void deleteCriteria() {
		CriteriaDataBase criteriaDataBase = new CriteriaDataBase();
		List<CriteriaName> criteria = criteriaDataBase.deleteCriteria(2);
		for (int i = 0; i < criteria.size(); i++) {
			System.out.println(criteria.get(i).getName());
		}
	}
}