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

/**
 * CriteriaName
 * Save fields of DataBase to use in UI.
 *
 * @version 0.0.1
 * @author Regis Humana.
 */
public class CriteriaName {

	/** Save the name. */
	private String name;

	/** Save the creation. */
	private String dateCreation;

	/** Save the criteria id. */
	private int id;

	/**
	 * Save the value of Name, dataCreation and ID.
	 * @param name
	 * @param dateCreation
	 * @param id
	 */
	public CriteriaName(String name, String dateCreation, int id) {
		this.name = name;
		this.dateCreation = dateCreation;
		this.id = id;
	}

	/**
	 * Get name to send to the UI table.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get Date creation of the name of criteria.
	 * @return
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * Get the ID of criteria DB.
	 * @return
	 */
	public int getId() {
		return id;
	}
}
