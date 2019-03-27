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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

/**
 * Module view, ui/JTableResult.
 * JTableResult class.
 *
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JTableResult extends JTable {
    private ArrayList extensions = new ArrayList();

    DefaultTableModel dtm = new DefaultTableModel(0,0) {

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            boolean isEdit = false;
            if (extensionValid(rowIndex, 3))
                isEdit = true;
            return isEdit;
        }
    };

    // add header of the table
    String[] header = new String[]{"N.", "Path", "File Name", "Extension", "Size (KB)",
            "Hidden", "ReadOnly", "Date Create", "Date Modification", "Date Later Access", "Play"};


    // add header for search a video or Audio
    String[] headerVideo = new String[]{"Id", "Path", "File Name", "Extension", "Size (KB)",
            "Hidden", "ReadOnly", "Date Create", "Date Modification", "Date Later Access",
            "Frame Rate", "Video Codec", "Audio Codec", "Aspect Ratio", "Audio Sample Rate",
            "Duration", "Audio Chanel", "Play"};

    /**
     * Constructor that setting the table DefaultTableModel.
     */
    public JTableResult() {
        super();

        loadExtension(extensions);
        dtm.setColumnIdentifiers(header);
        setFont(new java.awt.Font("Calibri", 0, 12));
        setGridColor(Color.WHITE);
        setForeground(Color.black);
        setBackground(Color.white);
        //set model into the table object
        this.setModel(dtm);
        this.getTableHeader().setForeground(Color.black);
        this.getTableHeader().setFont(new Font("Calibri", 0, 14));
        this.getTableHeader().setBackground(new Color(189, 193, 189));
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
        this.getColumnModel().getColumn(10).setCellEditor(new CellCheckBox());
        this.getColumnModel().getColumn(10).setCellRenderer(new RenderCheckBox());
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    /**
     * The JTableResult method is the constructor of this class.
     * This constructor is using for create a table for advance search video.
     *
     * @param withColumn is data for use in the with of column.
     */
    public JTableResult(int withColumn) {
        super();
        loadExtension(extensions);
        dtm.setColumnIdentifiers(headerVideo);
        setFont(new Font("Calibri", 0, 12));
        setGridColor(Color.WHITE);
        setForeground(Color.black);
        setBackground(Color.white);

        //set model into the table object
        this.setModel(dtm);
        this.getTableHeader().setForeground(Color.black);
        this.getTableHeader().setFont(new Font("Calibri", 0, 14));
        this.getTableHeader().setBackground(new Color(189, 193, 189));
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
        this.getColumnModel().getColumn(17).setCellEditor(new CellCheckBox());
        this.getColumnModel().getColumn(17).setCellRenderer(new RenderCheckBox());
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
        centerData();
    }

    /**
     * The addResultRowVideo method is for add a row in the table of advance search video.
     *
     * @param id               data for Id column.
     * @param path             data for Path column.
     * @param fileName         data for File Name column.
     * @param ext              data for Extension column.
     * @param size             data for Size column.
     * @param hidden           data for Hidden column.
     * @param readOnly         data for Read Only column.
     * @param dateCreate       data for Date Create column.
     * @param dateModification data for Date Modification column.
     * @param dateLaterAccess  data for Date Later Access column.
     * @param frameRate        data for Frame Rate column.
     * @param videoCodec       data for Video Codec column.
     * @param audioCodec       data for Audio Codec column.
     * @param aspectRatio      data for Aspect Ratio column.
     * @param audioSampleRate  data for Audio Sample Rate column.
     * @param duration         data for Duration column.
     */
    public void addResultRowVideo(String id, String path, String fileName, String ext,
                                  String size, String hidden, String readOnly, String dateCreate,
                                  String dateModification, String dateLaterAccess, String frameRate,
                                  String videoCodec, String audioCodec, String aspectRatio,
                                  String audioSampleRate, String duration, String chanel) {
        dtm.addRow(new Object[]{id, path, fileName, ext, size, hidden, readOnly,
                dateCreate, dateModification, dateLaterAccess, frameRate, videoCodec,
                audioCodec, aspectRatio, audioSampleRate, duration, chanel, false});
        centerData();
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
     * Load the list of valid extensions
     */
    public void loadExtension(ArrayList extensions) {
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
        extensions.add("ogg");
        extensions.add("wmv");
        extensions.add("asf");
    }

    /**
     * Method that verifies if a cell is a valid extensions.
     *
     * @param row    row of a table.
     * @param column column of a table.
     * @return true if a cell is valid.
     */
    private boolean extensionValid(int row, int column) {
        boolean isMultimedia = false;
        for (int i = 0; i < extensions.size(); i++) {
            if (dtm.getValueAt(row, column).toString().equalsIgnoreCase(extensions.get(i).toString())) {
                isMultimedia = true;
            }
        }
        return isMultimedia;
    }

    /**
     * Method that a cell is a valid extensions.
     */
    public void centerData() {
        DefaultTableCellRenderer centerModel = new DefaultTableCellRenderer();
        centerModel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getColumnModel().getColumn(5).setCellRenderer(centerModel);
        this.getColumnModel().getColumn(6).setCellRenderer(centerModel);
        this.getColumnModel().getColumn(7).setCellRenderer(centerModel);
        this.getColumnModel().getColumn(8).setCellRenderer(centerModel);
        this.getColumnModel().getColumn(9).setCellRenderer(centerModel);
    }
}
