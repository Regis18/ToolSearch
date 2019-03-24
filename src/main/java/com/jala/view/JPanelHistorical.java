/**
 * @(#)JPanelHistorical.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view;

import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Module view, ui/JPanelHistorical.
 *
 * @version 0.0.1
 * @autor Melvi Caballero M.
 */
public class JPanelHistorical extends JPanel {
	private JTableResult tbHistorical;
	private Border border;

	/**
	 * @param layout, add the layout in this panel.
	 */
	public JPanelHistorical(LayoutManager layout) {
		super(layout);
		init();
	}

	/**
	 * Gets the historical table.
	 *
	 * @return tbHistorical, get Historical table of the last searches.
	 */
	public JTableResult getTbHistorical() {
		return tbHistorical;
	}

	/**
	 * Method init call to initComponent method.
	 */
	public void init() {
		initComponent();
	}

	/**
	 * Start the components of this panel pList.
	 */
	private void initComponent() {
		JPanel pnlHistorical = new JPanel(new BorderLayout());
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "List Historical: ");
		pnlHistorical.setBorder(titleBorder);

		// Create table with data.
		tbHistorical = new JTableResult();
		JScrollPane scroll = new JScrollPane(tbHistorical);
		pnlHistorical.add(scroll, BorderLayout.CENTER);

		this.add(pnlHistorical, BorderLayout.CENTER);
	}
}
