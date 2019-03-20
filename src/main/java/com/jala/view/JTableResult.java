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
	String[] header = new String[]{"Id", "Path", "File Name", "Ext.", "Size"};

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
		this.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.getColumnModel().getColumn(4).setPreferredWidth(250);
		this.getColumnModel().getColumn(5).setPreferredWidth(500);
		this.getColumnModel().getColumn(6).setPreferredWidth(400);
		this.getColumnModel().getColumn(7).setPreferredWidth(150);
		this.getColumnModel().getColumn(8).setPreferredWidth(250);
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
	public void addResultRow(String id, String path, String fileName, String ext, String size) {
		dtm.addRow(new Object[]{id, path, fileName, ext, size});
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
