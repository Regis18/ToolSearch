/*
 * @(#) CustomCheckBox.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.JCheckBox;
import java.awt.Font;

/**
 * This class is Customizer CheckBox
 *
 * @author by Cristian Lujan
 * @Version 0.0.1
 */
class CustomCheckBox extends JCheckBox {

    /**
     * Class constructor for all JLabel.
     */
    public CustomCheckBox(String valor) {
        setFont(new Font("Calibri", Font.BOLD, 12));
        setText(valor);
        setOpaque(false);
        setSelected(true);
    }

}
