/*
 * @(#) JTableDB.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
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
public class JTableDB extends JTable{
    DefaultTableModel defaultTableM = new DefaultTableModel(0, 0);

    String[] header = new String[]{"Id", "Path", "File Name", "Ext.", "Size"};

    /**
     * Constructor that setting the table DefaultTableModel.
     */
    public JTableDB() {
        super();
        defaultTableM.setColumnIdentifiers(header);

        //set model into the table object
        this.setModel(defaultTableM);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        this.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.getColumnModel().getColumn(4).setPreferredWidth(250);
    }

    /**
     * Add a row to the table.
     *
     * @param path     file path.
     * @param fileName file name.
     * @param ext      file extension.
     * @param size     file size.
     */
    public void addResultRow(String id, String path, String fileName, String ext, String size) {
        defaultTableM.addRow(new Object[]{id, path, fileName, ext, size});
    }

}
