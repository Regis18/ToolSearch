/**
 * @(#)ViewConsole.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.console.view;

import com.jala.model.search.asset.Asset;

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
     * This list is the size for each column.
     */
    private List<Integer> sizeColumns = new ArrayList<>();

    /**
     * This is the list with the titles of tha table.
     */
    private List<String> headTitle = new ArrayList<>();

    /**
     * This is the counter of each row.
     */
    private int rowCounter;

    /**
     * The constructor method of the ViewConsole class to build an instance.
     */
    public ViewConsole() {
        sizeColumns.add(6);
        sizeColumns.add(6);
        sizeColumns.add(11);
        sizeColumns.add(11);
        sizeColumns.add(6);
        rowCounter = 0;
        headTitle.add("Nº");
        headTitle.add("Path");
        headTitle.add("File Name");
        headTitle.add("Extension");
        headTitle.add("Size");
    }

    /**
     * Return a list whit the size for the column.
     */
    public List<Integer> getSizeColumns() {
        return sizeColumns;
    }

    /**
     * Set the a list with columns size.
     *
     * @param sizeColumns
     */
    public void setSizeColumns(List<Integer> sizeColumns) {
        this.sizeColumns = sizeColumns;
    }

    /**
     * Get the row counter incremented in one.
     *
     * @return row counter.
     */
    public int getRowCounter() {
        return ++rowCounter;
    }

    /**
     * Set the row counter.
     *
     * @param rowCounter as int.
     */
    public void setRowCounter(int rowCounter) {
        this.rowCounter = rowCounter;
    }

    /**
     * This method is to add a row.
     *
     * @param row is a new data to add a table.
     */
    private void addRow(List<String> row) {
        String lowerLine = printHorizontalLine(sizeColumns);
        String leftJustifying = "| %-4d |";
        for (int i = 1; i < sizeColumns.size(); i++) {
            leftJustifying += " %-" + (sizeColumns.get(i) - 2) + "s |";
        }
        leftJustifying += "%n";
        String path = row.get(0);
        String fileName = row.get(1);
        String extension = row.get(2);
        String size = row.get(3);
        System.out.format(leftJustifying, getRowCounter(), path, fileName, extension, size);
        System.out.println(lowerLine);
    }

    /**
     * This method update the size columns with row list.
     *
     * @param rows is a list with the new row of data.
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
     * This method print a message of error.
     *
     * @param message is a value to print.
     */
    public void printMessage(String message) {
        int sizeWithSpace = message.length() + 2;
        List<Integer> sizeHorizontalLine = new ArrayList<>();
        sizeHorizontalLine.add(sizeWithSpace);
        String topLine = printHorizontalLine(sizeHorizontalLine);
        String lowerLine = topLine;
        String leftJustifying = "| %-" + message.length() + "s |%n";
        System.out.println(topLine);
        System.out.format(leftJustifying, message);
        System.out.println(lowerLine);
    }

    /**
     * This method create a line with divisions.
     *
     * @param size to put a line between each row.
     * @return horizontal border as string.
     */
    private String printHorizontalLine(List<Integer> size) {
        String border = "+";
        for (Integer division : size) {
            for (int i = 0; i <= division; i++) {
                border += (i == division) ? "+" : "-";
            }
        }
        return border;
    }

    /**
     * This method print the list of assets in console.
     *
     * @param assets are data that have to show.
     */
    public void showAssets(List<Asset> assets) {
        for (Asset asset : assets) {
            updateSize(convertToString(asset));
        }
        addTitles();
        for (Asset asset : assets) {
            addRow(convertToString(asset));
        }
    }

    /**
     * This method print the head titles of asset table.
     */
    private void addTitles() {
        String lowerLine = printHorizontalLine(sizeColumns);
        String topLine = lowerLine;
        String leftJustifying = "|";
        for (int i = 0; i < sizeColumns.size(); i++) {
            leftJustifying += " %-" + (sizeColumns.get(i) - 2) + "s |";
        }
        leftJustifying += "%n";
        String nro = headTitle.get(0);
        String path = headTitle.get(1);
        String fileName = headTitle.get(2);
        String extension = headTitle.get(3);
        String size = headTitle.get(4);
        System.out.println(topLine);
        System.out.format(leftJustifying, nro, path, fileName, extension, size);
        System.out.println(lowerLine);
    }

    /**
     * This method convert an asset to string.
     *
     * @param asset to be converter a string list.
     * @return a asset as string list.
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
