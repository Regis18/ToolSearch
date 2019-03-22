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
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
	String[] header = new String[]{"N.", "Path", "File Name", "Extension", "Size",
			"Hidden", "ReadOnly", "Date Create", "Date Modification","Date Later Access "};

	// add header for search a video or Audio
	String[] headerVideo = new String[]{"Frame Rate", "Video Codec", "Audio Codec", "Aspect Ratio", "Audio Sample Rate",
										"Duration", "Audio Channel", "Player"};

	//Join both headers for show a table
	String[] bothHeader = (String[]) ArrayUtils.addAll(header, headerVideo);
	/**
	 * Constructor that setting the table DefaultTableModel.
	 */
	public JTableResult() {
		super();
		dtm.setColumnIdentifiers(header);
		setFont(new java.awt.Font("Calibri", 0, 12));
		setGridColor(Color.WHITE);
		setForeground(Color.black);
		setBackground(Color.white);

		//set model into the table object
		this.setModel(dtm);
		this.tableHeader.getColorModel();
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
		this.getColumnModel().getColumn(10).setPreferredWidth(150);
		this.getColumnModel().getColumn( 10 ).setCellEditor(new CellCheckBox());
		this.getColumnModel().getColumn( 10 ).setCellRenderer(new RenderCheckBox());
		this.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}

	/**
	 * The JTableResult method is the constructor of this class.
	 * This constructor is using for create a table for advance search video.
	 * @param withColumn is data for use in the with of column.
	 */
	public JTableResult(int withColumn) {
		super();
		dtm.setColumnIdentifiers(bothHeader);
		setFont(new java.awt.Font("Calibri", 0, 12));
		setGridColor(Color.WHITE);
		setForeground(new ColorUIResource(0, 180, 158));
		setBackground(Color.DARK_GRAY);
		//set model into the table object
		this.setModel(dtm);

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
		this.getColumnModel().getColumn(16).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn(17).setPreferredWidth(withColumn);
		this.getColumnModel().getColumn( 17).setCellEditor(new CellCheckBox());
		this.getColumnModel().getColumn( 17).setCellRenderer(new RenderCheckBox());
		this.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
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
				dateCreate, dateModification, dateLaterAccess, false});
	}

	/**
	 * The addResultRowVideo method is for add a row in the table of advance search video.
	 * @param id data for Id column.
	 * @param path data for Path column.
	 * @param fileName data for File Name column.
	 * @param ext data for Extension column.
	 * @param size data for Size column.
	 * @param hidden data for Hidden column.
	 * @param readOnly data for Read Only column.
	 * @param dateCreate data for Date Create column.
	 * @param dateModification data for Date Modification column.
	 * @param dateLaterAccess data for Date Later Access column.
	 * @param frameRate data for Frame Rate column.
	 * @param videoCodec data for Video Codec column.
	 * @param audioCodec data for Audio Codec column.
	 * @param aspectRatio data for Aspect Ratio column.
	 * @param audioSampleRate data for Audio Sample Rate column.
	 * @param duration data for Duration column.
	 */
	public void addResultRowVideo(String id, String path, String fileName, String ext,
							 String size, String hidden, String readOnly, String dateCreate,
							 String dateModification, String dateLaterAccess, String frameRate,
								  String videoCodec, String audioCodec, String aspectRatio,
								  String audioSampleRate, String duration, String chanel) {
		dtm.addRow(new Object[]{id, path, fileName, ext, size, hidden, readOnly,
				dateCreate, dateModification, dateLaterAccess, frameRate, videoCodec,
				audioCodec, aspectRatio, audioSampleRate, duration, chanel, false});
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
