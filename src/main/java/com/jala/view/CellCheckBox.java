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
 *
 * @version 0.0.1.
 * @author: Luis Guardia
 */
public class CellCheckBox extends DefaultCellEditor implements TableCellRenderer  {

    private JComponent component = new JCheckBox();
    private boolean value = false; // valor de la celda

    /**
     * Class constructor.
     */
    public CellCheckBox() {
        super( new JCheckBox() );
    }

    /**
     * Returns the value of a cell.
     */
    @Override
    public Object getCellEditorValue() {
        return ((JCheckBox)component).isSelected();
    }

    /**
     * The JCheckBox is selected/deleted according to the cell value.
     */

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ((JCheckBox)component).setBackground(new Color(0,50,255));
        boolean b = ((Boolean) value).booleanValue();
        ((JCheckBox)component).setSelected( b );
        return ((JCheckBox)component);
    }

    /**
     * when the cell manipulation is over.
     * @return a value boolean.
     */

    @Override
    public boolean stopCellEditing() {
        value = ((Boolean)getCellEditorValue()).booleanValue();
        ((JCheckBox)component).setSelected( value );
        return super.stopCellEditing();
    }

    /**
     * Returns the checkBox component.
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null)
            return null;
        return ((JCheckBox)component );
    }
}
