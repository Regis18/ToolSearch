/*
 * @(#) RenderCheckBox.java Copyright (c) 2019 Jala Foundation.
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
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/**
 * @version 0.0.1.
 * @author: Luis Guardia
 */
public class RenderCheckBox extends JCheckBox implements TableCellRenderer {
    private JComponent component = new JCheckBox();

    /**
     * Class constructor.
     */
    public RenderCheckBox() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ( (JCheckBox) component).setBackground( new Color(255,255,255) );
        boolean b = ((Boolean) value).booleanValue();
        ( (JCheckBox) component).setSelected( b );
        return ( (JCheckBox) component);
    }
}
