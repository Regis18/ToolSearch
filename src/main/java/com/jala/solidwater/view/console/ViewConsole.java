/*
 * @(#)CriteriaSearch.java
 *
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.view.console;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewConsole class, show the data for console
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ViewConsole {

    /**
     * This list is the size for each column
     */
    private List<Integer> sizeColums = new ArrayList<>();

    /**
     * This is the counter of each row
     */
    private int counterOfRow;

    /**
     * The constructor method of the ViewConsole class to build an instance
     */
    public ViewConsole() {
        sizeColums.add(0);
        sizeColums.add(0);
        sizeColums.add(0);
        sizeColums.add(0);
        sizeColums.add(0);
        counterOfRow = 0;
    }

    /**
     * Section of getter and setter methods
     */
    public List<Integer> getSizeColums() {
        return sizeColums;
    }

    public void setSizeColums(List<Integer> sizeColums) {
        this.sizeColums = sizeColums;
    }

    public int getCounterOfRow() {
        return ++counterOfRow;
    }

    public void setCounterOfRow(int counterOfRow) {
        this.counterOfRow = counterOfRow;
    }

    /**
     * This method is to add a row
     * @param row is a new data to add a table
     */
    private void addRow(List<String> row) {
        setSizeColums(updateSize(row));
        String topLine = horizontalLine(getSizeColums());
        String lowerLine = topLine;
        String leftJustifying = "| %-4d |";
        for (int i = 0; i < row.size(); i++) {
            leftJustifying += " %-" + row.get(i).length() + "s |";
        }
        leftJustifying += "%n";
        String path = row.get(0);
        String fileName = row.get(1);
        String extension = row.get(2);
        String size = row.get(3);
        System.out.println(topLine);
        System.out.format(leftJustifying, getCounterOfRow(), path, fileName, extension, size);
        System.out.println(lowerLine);
    }

    /**
     * @param rows is a list with the new row of data
     * @return a list with the new size of the column
     */
    private List<Integer> updateSize(List<String> rows) {
        List<Integer> updateSizeColumns = new ArrayList<>();
        updateSizeColumns.add(0, 6);
        for (int i = 0; i < rows.size(); i++) {
            int newSizeColumn = (rows.get(i).length()) + 2;
            int counterRow = i + 1;
            if (newSizeColumn > sizeColums.get(counterRow)) {
                updateSizeColumns.add(counterRow, newSizeColumn);
            } else {
                updateSizeColumns.add(counterRow, sizeColums.get(counterRow));
            }
        }
        return updateSizeColumns;
    }

    /**
     * This method print a message of error
     * @param message is a value to print.
     */
    public void errorPrint(String message) {
        String error = "Error: " + message + ".";
        int sizeWithSpace = error.length() + 2;
        List<Integer> sizeHorizontalLine = new ArrayList<>();
        sizeHorizontalLine.add(sizeWithSpace);
        String topLine = horizontalLine(sizeHorizontalLine);
        String lowerLine = topLine;
        String leftJustifying = "| %-" + error.length() + "s |%n";
        System.out.println(topLine);
        System.out.format(leftJustifying, error);
        System.out.print(lowerLine);
    }

    /**
     * This method create a line with divisions
     * @param divisionSize is a array of values for divide a line horizontal
     */
    private String horizontalLine (List<Integer> divisionSize) {
        String border = "+";
        for (Integer division : divisionSize
                ) {
            for (int i = 0; i <= division; i++) {
                border += (i == division) ? "+" : "-";
            }
        }
        return border;
    }
}
