/*
 * @(#) CriteriaName.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.criteria;

public class CriteriaName {
	private String name;
	private String dateCreation;
	private int id;

	public CriteriaName(String name, String dateCreation, int id) {
		this.name = name;
		this.dateCreation = dateCreation;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public int getId() {
		return id;
	}
}
