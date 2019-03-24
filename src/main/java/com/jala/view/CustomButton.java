/*
 * @(#) CustomButton.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CustomButton extends JButton {

    private Color color;

    public CustomButton() {
        setOpaque(true);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBackground(new Color(172, 175, 177));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void changeColor(Color color) {
        this.color = color;
        Graphics g = getGraphics();
        paintComponent(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setPaint(this.color);
        graphics2D.fillRect(50, 50, getWidth(), getHeight());
        graphics2D.dispose();
        super.paintComponent(g);
    }
}
