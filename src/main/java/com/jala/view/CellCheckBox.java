/*
 * @(#) CellCheckBox.java Copyright (c) 2019 Jala Foundation.
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

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Class CellCheckBox
 *
 * @version 0.0.1.
 * @author: Luis Guardia
 */
public class CellCheckBox extends DefaultCellEditor implements TableCellRenderer {

    private JComponent componentCheckBox = new JCheckBox();
    private boolean isCellSelected = false;

    /**
     * Class constructor.
     */
    public CellCheckBox() {
        super(new JCheckBox());
    }

    /**
     * Returns the value of a cell.
     */
    @Override
    public Object getCellEditorValue() {
        return ((JCheckBox) componentCheckBox).isSelected();
    }

    /**
     * The JCheckBox is selected/deleted according to the cell value.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object cell, boolean isSelected, int row, int column) {
        componentCheckBox.setBackground(new Color(0, 30, 145, 201));
        boolean cellSelect = ((Boolean) cell).booleanValue();
        ((JCheckBox) componentCheckBox).setSelected(cellSelect);
        return componentCheckBox;
    }

    /**
     * when the cell manipulation is over.
     *
     * @return a value boolean.
     */
    @Override
    public boolean stopCellEditing() {
        isCellSelected = ((Boolean) getCellEditorValue()).booleanValue();
        ((JCheckBox) componentCheckBox).setSelected(isCellSelected);
        return super.stopCellEditing();
    }

    /**
     * Returns the checkBox components.
     *
     * @param table
     * @param isCellSelected
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     */
    public Component getTableCellRendererComponent(JTable table, Object isCellSelected, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isCellSelected == null) {
            return null;
        }
        return ((JCheckBox)componentCheckBox );
    }
}
