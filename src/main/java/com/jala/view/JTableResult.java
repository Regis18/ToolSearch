/**
 * @(#)JTableResult.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view;

import org.apache.commons.lang3.ArrayUtils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Module view, ui/JTableResult.
 * JTableResult class.
 *
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JTableResult extends JTable {
	DefaultTableModel dtm = new DefaultTableModel(0, 0);

	// add header of the table
	String[] header = new String[]{"Id", "Path", "File Name", "Extension", "Size",
			"Hidden", "ReadOnly", "Date Create", "Date Modification","Date Later Access "};

	// add header for search a video or Audio
	String[] headerVideo = new String[]{"Frame Rate", "Video Codec", "Audio Codec", "Aspect Ratio", "Audio Sample Rate",
										"Duration"};

	//Join both headers for show a table
	String[] bothHeader = (String[]) ArrayUtils.addAll(header, headerVideo);
	/**
	 * Constructor that setting the table DefaultTableModel.
	 */
	public JTableResult() {
		super();
		dtm.setColumnIdentifiers(header);

		//set model into the table object
		this.setModel(dtm);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		this.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.getColumnModel().getColumn(1).setPreferredWidth(500);
		this.getColumnModel().getColumn(2).setPreferredWidth(400);
		this.getColumnModel().getColumn(3).setPreferredWidth(200);
		this.getColumnModel().getColumn(4).setPreferredWidth(150);
		this.getColumnModel().getColumn(5).setPreferredWidth(150);
		this.getColumnModel().getColumn(6).setPreferredWidth(150);
		this.getColumnModel().getColumn(7).setPreferredWidth(150);
		this.getColumnModel().getColumn(8).setPreferredWidth(150);
		this.getColumnModel().getColumn(9).setPreferredWidth(150);
	}

	/**
	 * @param withColumn ............. without comment
	 */
	public JTableResult(int withColumn) {
		super();
		dtm.setColumnIdentifiers(bothHeader);

		//set model into the table object
		this.setModel(dtm);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		this.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.getColumnModel().getColumn(1).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(2).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(3).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(4).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(5).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(6).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(7).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(8).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(9).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(10).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(11).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(12).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(13).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(14).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(15).setPreferredWidth(withColumn);
	}
	/**
	 * Add a row to the table.
	 *
	 * @param id       identifier.
	 * @param path     file path.
	 * @param fileName file name.
	 * @param ext      file extension.
	 * @param size     file size.
	 */
	public void addResultRow(String id, String path, String fileName, String ext,
							 String size, String hidden, String readOnly, String dateCreate,
							 String dateModification, String dateLaterAccess) {
		dtm.addRow(new Object[]{id, path, fileName, ext, size, hidden, readOnly,
				dateCreate, dateModification, dateLaterAccess});
	}

	/**
	 * @param id
	 * @param path
	 * @param fileName
	 * @param ext
	 * @param size
	 * @param hidden
	 * @param readOnly
	 * @param dateCreate
	 * @param dateModification
	 * @param dateLaterAccess
	 * @param frameRate
	 * @param videoCodec
	 * @param audioCodec
	 * @param aspectRatio
	 * @param audioSampleRate
	 * @param duration
	 */
	public void addResultRowVideo(String id, String path, String fileName, String ext,
							 String size, String hidden, String readOnly, String dateCreate,
							 String dateModification, String dateLaterAccess, String frameRate,
								  String videoCodec, String audioCodec, String aspectRatio,
								  String audioSampleRate, String duration) {
		dtm.addRow(new Object[]{id, path, fileName, ext, size, hidden, readOnly,
				dateCreate, dateModification, dateLaterAccess, frameRate, videoCodec,
				audioCodec, aspectRatio, audioSampleRate, duration});
	}

	/**
	 * Clean the table.
	 */
	public void removeRow() {
		int rowCount = dtm.getRowCount();

		//Remove rows one by one from the end of the table.
		for (int index = rowCount - 1; index >= 0; index--) {
			dtm.removeRow(index);
		}
	}
}
