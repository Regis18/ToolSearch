/*
 * @(#) JPanelVideo.java Copyright (c) 2019 Jala Foundation.
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * JPanelVideo
 *
 * @author Luis Guardia
 * @version 0.0.3
 */
public class JPanelVideo extends JPanel {
    private JPanelConverterVideo panelConverterVideo;
    private Border border;

    /**
     * Gets the panel panelConverterImage
     *
     * @return panelConverterImage
     */
    public JPanelConverterVideo getJPanelVideo() {
        return panelConverterVideo;
    }

    /**
     * Class constructor.
     *
     * @param layout
     */
    public JPanelVideo(LayoutManager layout) {
        super(layout);
        initComponent();
    }

    /**
     * The initComponent method will initialize the components.
     */
    private void initComponent() {
        panelConverterVideo = new JPanelConverterVideo(new BorderLayout());
        TitledBorder titleBorderVideo = new CustomTitleBorder("Options Convert: ");
        panelConverterVideo.setBorder(titleBorderVideo);
        panelConverterVideo.setBackground(new Color(172, 175, 177));
        this.add(panelConverterVideo, BorderLayout.NORTH);
    }
}
