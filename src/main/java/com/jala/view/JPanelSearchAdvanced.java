/**
 * @(#)JPanelSearchAdvanced.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import com.jala.view.player.VideoMusicPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Module view, ui/JPanelSearchAdvanced.
 *
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JPanelSearchAdvanced extends JPanel {
    private JTableResult tbSearchAdvanced;
    private Border border;
    private JPanelAdvanced panelSearchAdvanced;
    private JTableDB tbDataBase;
    private JPanel panelInferior;
    private JButton btnDelete, btnCharge, btnSave, btnPlay;
    private ArrayList myListPlayer = new ArrayList();


    /**
     * Gets the delete button.
     *
     * @return btnDelete, the Search button.
     */
    public JButton getBtnDelete() {
        return btnDelete;
    }

    /**
     * Gets the save button.
     *
     * @return btnSave, the Search button.
     */
    public JButton getBtnSave() {
        return btnSave;
    }

    /**
     * Gets the charge button.
     *
     * @return btnCharge, the Search button.
     */
    public JButton getBtnCharge() {
        return btnCharge;
    }

    /**
     * Get the table of database.
     * @return
     */

    /**
     * Gets the btnPlay button.
     *
     * @return btnPlay, the Advanced Search button.
     */
    public JButton getBtnPlay() {
        return btnPlay;
    }

    public JTableDB getTbDataBase() {
        return tbDataBase;
    }

    /**
     * Class constructor.
     *
     * @param layout define the main layout.
     */
    public JPanelSearchAdvanced(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * Gets the panel getJPanelAdvanced.
     *
     * @return panelSearchAdvanced.
     */
    public JPanelAdvanced getJPanelAdvanced() {
        return panelSearchAdvanced;
    }

    /**
     * Returns the table with the Advanced Search information.
     *
     * @return the result table.
     */
    public JTableResult getTbSearchAdvanced() {
        return tbSearchAdvanced;
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
        panelSearchAdvanced = new JPanelAdvanced(new BorderLayout());
        TitledBorder titleBorder = new CustomTitleBorder("Search Advanced: ");
        panelSearchAdvanced.setBorder(titleBorder);
        panelSearchAdvanced.setBackground(new Color(172, 175, 177));

        this.add(panelSearchAdvanced, BorderLayout.CENTER);

        JPanel pnlTableDB = pnlTableDB();
        this.add(pnlTableDB, BorderLayout.WEST);

        JPanel pnlCentral = pnlTableResult();
        this.add(pnlCentral, BorderLayout.SOUTH);

        JPanel pnlSouth = pnlPlayBtn();
        this.add(pnlSouth, BorderLayout.EAST);
    }

    /**
     * Return the instance of center panel with the Table Result.
     *
     * @return pnlTable the panel of the table.
     */
    private JPanel pnlTableResult() {
        JPanel pnlSearchAdvanced = new JPanel(new BorderLayout());
        TitledBorder titleBorder = new CustomTitleBorder("List Search Advanced: ");
        pnlSearchAdvanced.setBorder(titleBorder);
        pnlSearchAdvanced.setBackground(new Color(172, 175, 177));

        tbSearchAdvanced = new JTableResult();
        JScrollPane scroll = new JScrollPane(tbSearchAdvanced);
        pnlSearchAdvanced.add(scroll, BorderLayout.CENTER);

        return pnlSearchAdvanced;
    }

    /**
     * Return the instance of Table Criteria.
     *
     * @return pnlTableDB the criteria of the table.
     */
    private JPanel pnlTableDB() {
        JPanel pnlSearchGral = new JPanel(new BorderLayout());
        TitledBorder titleBorder = new CustomTitleBorder("List Search Data Base: ");
        pnlSearchGral.setBorder(titleBorder);
        pnlSearchGral.setBackground(new Color(172, 175, 177));
        pnlButtonInferiorDB();

        tbDataBase = new JTableDB();
        JScrollPane scroll = new JScrollPane(tbDataBase);
        pnlSearchGral.add(scroll, BorderLayout.CENTER);
        pnlSearchGral.add(panelInferior, BorderLayout.SOUTH);

        return pnlSearchGral;
    }

    /**
     * Return the instance of center panel with the Advanced button.
     * @return pnlButtonAdvanced the Advanced button panel.
     */
    private JPanel pnlPlayBtn() {
        JPanel pnlSearchAdvanced = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlSearchAdvanced.setBackground(new Color(172, 175, 177));
        btnPlay = new CustomButton();
        btnPlay.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\videoPlayer36.png"));
        btnPlay.setToolTipText("Play Video");
        pnlSearchAdvanced.add(btnPlay);
        return pnlSearchAdvanced;
    }

    /**
     * Create panel for buttons
     */
    private void pnlButtonInferiorDB() {
        panelInferior = new JPanel();
        btnCharge = new JButton("Load");
        btnDelete = new JButton("Delete");
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setOpaque(false);
        panelInferior.add(btnCharge);
        panelInferior.add(btnDelete);
    }


    /**
     * Return the instance of south panel with the label messages.
     * @return pnlMessage the panel for messages.
     */
    private JPanel pnlMessages() {
        JPanel pnlMessage = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlMessage.setPreferredSize(new Dimension(200, 50));
        return pnlMessage;
    }

    /**
     * method that adds audio and video path to an ArrayList
     * @return ArrayList.
     */
    public ArrayList getMyListPlayer() {
        myListPlayer.clear();
        for (int i = 0; i < tbSearchAdvanced.getRowCount(); i++) {
            if (tbSearchAdvanced.getValueAt(i, 10).toString().equals("true")) {
                myListPlayer.add(tbSearchAdvanced.getValueAt(i, 1));
            }
        }
        return myListPlayer;
    }
}
