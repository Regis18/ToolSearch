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

import com.jala.search.models.Asset;

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
    private List<Integer> sizeColumns = new ArrayList<>();

    /**
     * This is the list with the titles of tha table
     */
    private List<String> titleHead = new ArrayList<>();

    /**
     * This is the counter of each row
     */
    private int counterOfRow;

    /**
     * The constructor method of the ViewConsole class to build an instance
     */
    public ViewConsole() {
        sizeColumns.add(6);
        sizeColumns.add(6);
        sizeColumns.add(11);
        sizeColumns.add(11);
        sizeColumns.add(6);
        counterOfRow = 0;
        titleHead.add("Nº");
        titleHead.add("Path");
        titleHead.add("File Name");
        titleHead.add("Extension");
        titleHead.add("Size");
    }

    /**
     * Section of getter and setter methods
     */
    public List<Integer> getSizeColumns() {
        return sizeColumns;
    }

    public void setSizeColumns(List<Integer> sizeColumns) {
        this.sizeColumns = sizeColumns;
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
        String lowerLine = printhorizontalLine(sizeColumns);
        String leftJustifying = "| %-4d |";
        for (int i = 1; i < sizeColumns.size(); i++) {
            leftJustifying += " %-" + (sizeColumns.get(i) - 2) + "s |";
        }
        leftJustifying += "%n";
        String path = row.get(0);
        String fileName = row.get(1);
        String extension = row.get(2);
        String size = row.get(3);
        System.out.format(leftJustifying, getCounterOfRow(), path, fileName, extension, size);
        System.out.println(lowerLine);
    }

    /**
     * @param rows is a list with the new row of data
     */
    private void updateSize(List<String> rows) {
        for (int i = 0; i < rows.size(); i++) {
            int newSizeColumn = (rows.get(i).length()) + 2;
            int counterRow = i + 1;
            if (newSizeColumn > sizeColumns.get(counterRow)) {
                sizeColumns.remove(counterRow);
                sizeColumns.add(counterRow, newSizeColumn);
            }
        }
    }

    /**
     * This method print a message of error
     * @param message is a value to print.
     */
    public void printMessage(String message) {
        int sizeWithSpace = message.length() + 2;
        List<Integer> sizeHorizontalLine = new ArrayList<>();
        sizeHorizontalLine.add(sizeWithSpace);
        String topLine = printhorizontalLine(sizeHorizontalLine);
        String lowerLine = topLine;
        String leftJustifying = "| %-" + message.length() + "s |%n";
        System.out.println(topLine);
        System.out.format(leftJustifying, message);
        System.out.println(lowerLine);
    }

    /**
     * This method create a line with divisions
     */
    private String printhorizontalLine(List<Integer> size ) {
        String border = "+";
        for (Integer division : size
                ) {
            for (int i = 0; i <= division; i++) {
                border += (i == division) ? "+" : "-";
            }
        }
        return border;
    }

    /**
     * @param assets are data that have to show
     */
    public void showAssets(List<Asset> assets) {

        for ( Asset asset : assets
             ) {
            updateSize(convertToString(asset));
        }
        addTitles();
        for ( Asset asset : assets
                ) {
            addRow(convertToString(asset));
        }
    }

    private void addTitles() {

    }

    /**
     * @param asset is a data that will be converter on a list
     * @return a string list
     */
    private List<String> convertToString(Asset asset) {
        List<String> row = new ArrayList<>();
        row.add(asset.getPath());
        row.add(asset.getFileName());
        row.add(asset.getExtension());
        row.add(asset.getSize());
        return row;
     }
}
