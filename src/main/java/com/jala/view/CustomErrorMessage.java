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

/**
 * This class is Customizer Message Error
 *
 * @author by Cristian Lujan
 * @Version 0.0.1
 */
public class CustomErrorMessage extends JOptionPane {

    /**
     * Class constructor for all messages Error.
     */
    public CustomErrorMessage( String message ) {
        showMessageDialog(null, message, "Error!!!", JOptionPane.ERROR_MESSAGE);
    }
}
