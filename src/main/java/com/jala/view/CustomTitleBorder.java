/*
 * @(#) CustomTitleBorder.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.BorderFactory;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.Font;

/**
 * This class is Customizer TextField
 *
 * @author by Cristian Lujan
 * @Version 0.0.1
 */
public class CustomTitleBorder extends TitledBorder {

    /**
     * Class constructor for all Title Border.
     *
     * @param title define the title.
     */
    public CustomTitleBorder(String title) {

        super(title);
        setBorder(BorderFactory.createTitledBorder(title));
        setTitlePosition(TitledBorder.DEFAULT_POSITION);
        setTitleFont(new Font("Bahnschrift", 1, 12));
        setTitleColor(new ColorUIResource(19, 0, 76));
        setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(new Color(249, 255, 250), 1)));
    }
}
