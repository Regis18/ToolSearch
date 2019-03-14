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

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.LayoutManager;
import java.awt.BorderLayout;

/**
 * JPanelVideo
 *
 * @version 0.0.3
 * @author Luis Guardia
 */
public class JPanelVideo extends JPanel {
    private JPanelConverterVideo panelConverterVideo;
    private Border border;

    /**
     * Gets the panel panelConverterImage
     * @return panelConverterImage
     */
    public JPanelConverterVideo getJPanelVideo() {
        return panelConverterVideo;
    }

    /**
     * Class constructor.
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
        TitledBorder titleBorderVideo = BorderFactory.createTitledBorder(border, "Options Convert");
        panelConverterVideo.setBorder(titleBorderVideo);
        this.add(panelConverterVideo, BorderLayout.NORTH);
    }
}
