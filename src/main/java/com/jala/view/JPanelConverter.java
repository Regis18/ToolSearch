/*
 * @(#) JPanelConverter.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

/**
 * Module view, ui/JPanelConverter.
 * @version 0.0.1.
 * @autor Luis Guardia.
 */
public class JPanelConverter extends JPanel {

    private JPanelConverterImage panelConverterImage;
    private Border border;

    /**
     * Gets the panel panelConverterImage
     * @return panelConverterImage
     */
    public JPanelConverterImage getJPanelAdvanced() {
        return panelConverterImage;
    }

    /**
     * Class constructor.
     * @param layout
     */
    public JPanelConverter(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * The init method will initialize this panel.
     */
    public void init() {
        initComponent();
    }

    /**
     * The initComponent method will initialize the components.
     */
    private void initComponent() {
        panelConverterImage = new JPanelConverterImage(new BorderLayout());
        TitledBorder titleBorder = new CustomTitleBorder("Options Convert: ");
        panelConverterImage.setBorder(titleBorder);
        panelConverterImage.setBackground(new Color(172, 175, 177));
        this.add(panelConverterImage,BorderLayout.NORTH);
    }
}
