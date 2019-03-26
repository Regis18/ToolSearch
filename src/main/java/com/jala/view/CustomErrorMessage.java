/*
 * @(#) CustomErrorMessage.java Copyright (c) 2019 Jala Foundation.
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


import javax.swing.JOptionPane;

public class CustomErrorMessage extends JOptionPane {

    public CustomErrorMessage( String message, String title) {

        showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
