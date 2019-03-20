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

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Module view, ui/JTableResult.
 * JTableResult class.
 *
 * @version 0.0.1.
 * @autor Luis Guardia.
 */
public class JTableResult extends JTable {
	private ArrayList extensions = new ArrayList();
	DefaultTableModel dtm = new DefaultTableModel(0, 0){
		public boolean isCellEditable(int rowIndex , int columnIndex){
			boolean isEdit = false;
			if(extensionValida(rowIndex,3))
				isEdit = true;
			return isEdit;
		}
	};

	String[] header = new String[]{"Id", "Path", "File Name", "Extension", "Size",
			"Hidden", "ReadOnly", "Date Create", "Date Modification", "Date Later Access", "Player"};

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
		this.getColumnModel().getColumn( 10 ).setCellEditor(new CellCheckBox());
		this.getColumnModel().getColumn( 10 ).setCellRenderer(new RenderCheckBox());
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
	 * Clean the table.
	 */
	public void removeRow() {
		int rowCount = dtm.getRowCount();

		//Remove rows one by one from the end of the table.
		for (int index = rowCount - 1; index >= 0; index--) {
			dtm.removeRow(index);
		}
	}

	/**
	 * Method that an extension is valid.
	 * @return true if an extension is valid.
	 * @param multimedia: extension of a file.
	 */
	private boolean extensionValid(String multimedia) {
		extensions.add("mp3");
		extensions.add("wma");
		extensions.add("aac");
		extensions.add("flv");
		extensions.add("mpeg");
		extensions.add("mpg");
		extensions.add("avi");
		extensions.add("mp4");
		extensions.add("vob");
		extensions.add("mkv");
		extensions.add("dat");
		extensions.add("mov");
		extensions.add("asf");
		boolean isMultimedia = false;
		for (int i = 0 ; i < extensions.size() ; i++){
			if (multimedia.equalsIgnoreCase(extensions.get(i).toString())) {
				isMultimedia = true;
			}
		}
		return isMultimedia;
	}

	/**
	 * Method that verifies if a cell is a valid extensions.
	 * @param row     row of a table.
	 * @param column     column of a table.
	 * @return true if a cell is valid.
	 */
	private boolean extensionValida(int row , int column) {
		extensions.add("mp3");
		extensions.add("wma");
		extensions.add("aac");
		extensions.add("flv");
		extensions.add("mpeg");
		extensions.add("mpg");
		extensions.add("avi");
		extensions.add("mp4");
		extensions.add("vob");
		extensions.add("mkv");
		extensions.add("dat");
		extensions.add("mov");
		extensions.add("asf");
		boolean isMultimedia = false;
		for (int i = 0 ; i < extensions.size() ; i++) {
			if (dtm.getValueAt(row , column).toString().equalsIgnoreCase(extensions.get(i).toString())) {
				isMultimedia = true;
			}
		}
		return isMultimedia;
	}
}
