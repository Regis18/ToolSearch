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
import java.awt.Color;
import java.awt.Font;

/**
 * JTableResult class.
 *
 * @version 0.0.1.
 * @autor Cxristian
 */
public class JTableDB extends JTable {
    DefaultTableModel defaultTableM = new DefaultTableModel(0, 0);

    String[] header = new String[]{"N.","id", "File Name", "Date"};

    /**
     * Constructor that setting the table DefaultTableModel.
     */
    public JTableDB() {
        super();
        defaultTableM.setColumnIdentifiers(header);
        this.setModel(defaultTableM);
        setFont(new Font("Calibri", 0, 12));
        setGridColor(Color.BLACK);
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        this.getTableHeader().setForeground(new Color(255, 255, 255, 0));
        this.getTableHeader().setFont(new Font("Calibri", 0, 14));
        this.getTableHeader().setBackground(new Color(141, 145, 141, 140));
        this.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.getColumnModel().getColumn(1).setMaxWidth(0);
        this.getColumnModel().getColumn(1).setMinWidth(0);
        this.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    /**
     * Add a row to the table.
     *
     * @param num number.
     * @param id file id.
     * @param fileName file name.
     * @param date file date.
     */
    public void addResultRow(String num,String id, String fileName, String date) {
        defaultTableM.addRow(new Object[]{num,id , fileName, date, });
    }

    /**
     * Clean the table.
     */
    public void removeRow() {
        int rowCount = defaultTableM.getRowCount();
        for (int index = rowCount - 1; index >= 0; index--) {
            defaultTableM.removeRow(index);
        }
    }

}
