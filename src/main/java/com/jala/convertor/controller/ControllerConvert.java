/*
 * @(#) ControllerConvert.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.convertor.controller;

import com.jala.convertor.models.ConvertorImage;
import com.jala.convertor.models.CriteriaConvertor;
import com.jala.utils.Logs;
import com.jala.view.JPanelConverter;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerConvert implements ActionListener {
	/** It creates to follow up the instruction of the class*/
	private Logger log = Logs.getInstance().getLog();

	/** ViewConvert: create a pointer of JPanelSearchGral the object will provide other class.*/
	private JPanelConverter viewConvert;

	private CriteriaConvertor criteriaConvertor;

	/**
	 * This constructor
	 * @param viewConvert
	 */
	public ControllerConvert(JPanelConverter viewConvert) {
		log.info("Initialize the Control of Search General");
		this.viewConvert = viewConvert;
		log.info("Initialize the adding of listener for the buttons in Convert General");
		viewConvert.getJPanelAdvanced().getBtnConvert().addActionListener(this);
		log.info("Finish the actionListener");
	}

	/**
	 * It is override the method of ActionListener and the objective is listen if button is pressed
	 * @param event this activates when a button is  pressed
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		log.info("Action Detected");
		if (event.getSource() == viewConvert.getJPanelAdvanced().getBtnConvert()) {
			log.info("BtnConvert from Search General was pressed");
			sendPathToConvert();
		}
	}

	/**
	 * This method sends to ConvertImage the criteria that was wrote by user, and that method convert
	 * the image
	 */
	private void sendPathToConvert() {
		log.info("Preparing to send criteria converter to ConvertImage");
		ConvertorImage convertorImage = new ConvertorImage();
		saveCriteria();
		convertorImage.convert(criteriaConvertor);
	}

	/**
	 * Save the information that the Ui provides into CriteriaConvertor to send Converter
	 */
	private void saveCriteria() {
		String pathOrigin = viewConvert.getJPanelAdvanced().getTxtPathFileOrigin();
		String pathDestiny = viewConvert.getJPanelAdvanced().getTxtFolderDestiny();
		String extension = viewConvert.getJPanelAdvanced().getTxtExtension();
		String fileName = viewConvert.getJPanelAdvanced().getTxtFileName();
		String sizeHeight = viewConvert.getJPanelAdvanced().getTxtSizeHeight();
		String sizeWidth = viewConvert.getJPanelAdvanced().getTxtSizeWidth();
		boolean isMaintain = viewConvert.getJPanelAdvanced().isProprotion();
		boolean isPercentage = !viewConvert.getJPanelAdvanced().isPixeles();
		boolean isResize = viewConvert.getJPanelAdvanced().isResize();
		criteriaConvertor = new CriteriaConvertor(pathOrigin, pathDestiny + "\\", "." + extension);
		criteriaConvertor.setNewFileName(fileName);
		if (!sizeHeight.isEmpty()) {
			criteriaConvertor.setHeight(Integer.parseInt(sizeHeight));
		}
		if (!sizeWidth.isEmpty()) {
			criteriaConvertor.setWidth(Integer.parseInt(sizeWidth));
		}
		criteriaConvertor.setMaintainProportion(isMaintain);
		criteriaConvertor.setPercentage(isPercentage);
		criteriaConvertor.setResize(isResize);
	}
}
