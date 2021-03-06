/*
 * @(#) CustomTextField.java Copyright (c) 2019 Jala Foundation.
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


import javax.swing.JTextField;

/**
 * This class is Customizer TextField
 *
 * @author by Cristian Lujan
 * @Version 0.0.1
 */
public class CustomTextField extends JTextField {

    /**
     * Class constructor for all JTextField.
     *
     * @param valor define the size textBox.
     */
    public CustomTextField(int valor) {
        setColumns(valor);
        init();
    }

    /**
     * Class constructor for all JTextField.
     */
    public CustomTextField() {
        init();
    }

    /**
     * Init of constructors.
     */
    public void init() {
        setFont(new java.awt.Font("Calibri", 0, 11));
        setHorizontalAlignment(JTextField.LEFT);
        setVisible(true);
    }

}
