/*
 * @(#) CustomLabel.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.JLabel;

/**
 * This class is Customizer Label
 * @author by Cristian Lujan
 * @Version 0.0.1
 */
public class CustomLabel extends JLabel {

    /**
     * Class constructor.
     */
    public CustomLabel() {
        init();
    }

    /**
     *Class constructor.
     */
    public CustomLabel(String text) {
        setText(text);
        init();
    }

    /**
     * Init of constructor.
     */
    public void init() {
        setFont(new java.awt.Font("Calibri", 1, 14));
        setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setVisible(true);
    }
}
