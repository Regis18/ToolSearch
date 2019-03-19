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

import com.jala.model.criteria.CriteriaSearch;
import org.junit.Test;

import static org.junit.Assert.*;

public class CriteriaDataBaseTest {

	@Test
	public void saveCriteria() {
		CriteriaDataBase criteriaDataBase = new CriteriaDataBase();
		CriteriaSearch criteria = new CriteriaSearch("C:\\Users\\Admin\\Desktop\\PROG 02");
		criteriaDataBase.saveCriteria(criteria);
	}

	@Test
	public void loadCriteria() {
		CriteriaDataBase criteriaDataBase = new CriteriaDataBase();
		CriteriaSearch criteria = new CriteriaSearch("C:\\Users\\Admin\\Desktop");
		criteriaDataBase.saveCriteria(criteria);
		criteriaDataBase.loadCriteria();
	}
}