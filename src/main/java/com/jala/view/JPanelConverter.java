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

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPanelConverter extends JPanel{

    private JPanelConverterImage panelConverterImage;
    private Border border;

    public JPanelConverter(LayoutManager layout){
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
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Search Advanced");
        panelConverterImage.setBorder(titleBorder);
        this.add(panelConverterImage, BorderLayout.NORTH);
    }
}
