/**
 * @(#)JPanelSearchGral.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jala.view.player.VideoMusicPlayer;

import java.util.ArrayList;

/**
 * Module view, ui/JPanelSearchAdvanced.
 *
 * @version 0.0.1.
 * @autor Melvi Caballero M.
 */
public class JPanelSearchGral extends JPanel implements ActionListener {
    private JLabel lblPath;
    private JTextField txtPath;
    private JButton btnSearch, btnSearchAdvanced, btnPathFolder, btnPlay;
    private JTableResult tbSearchGral;
    private ArrayList myListPlayer = new ArrayList();
    private Border border;
    private CustomErrorMessage msgError;

    /**
     * Class constructor.
     *
     * @param layout define the main layout.
     */
    public JPanelSearchGral(LayoutManager layout) {
        super(layout);
        init();
    }

    /**
     * Get the table with the general search.
     *
     * @return tbSearchGral the table with the general search.
     */
    public JTableResult getTbSearchGral() {
        return tbSearchGral;
    }

    /**
     * Gets the Path of the location to search.
     *
     * @return txtPath, the location of file to search.
     */
    public JTextField getTxtPath() {
        return txtPath;
    }

    /**
     * Sets the path field for the search location.
     *
     * @param txtPath, the location where to search.
     */
    public void setTxtPath(JTextField txtPath) {
        this.txtPath = txtPath;
    }

    /**
     * Gets the search button.
     *
     * @return btnSearch, the Search button.
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * Gets the advanced search button.
     *
     * @return btnSearchAdvanced, the Advanced Search button.
     */
    public JButton getBtnPlay() {
        return btnPlay;
    }

    /**
     * Gets the advanced search button.
     *
     * @return btnSearchAdvanced, the Advanced Search button.
     */
    public JButton getBtnSearchAdvanced() {
        return btnSearchAdvanced;
    }

    /**
     * Sets the Message Error for a pop-up
     * @param msgError define the message of error.
     */
    public void setMsgError(String msgError) {
        this.msgError = new CustomErrorMessage(msgError);
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

        JPanel pnlNorth = pnlCriteria();
        this.add(pnlNorth, BorderLayout.NORTH);

        JPanel pnlCentral = pnlTableResult();
        this.add(pnlCentral, BorderLayout.CENTER);
    }

    /**
     * Return the instance of panel central with the path, file name, extension and Search button.
     *
     * @return pnlCriteria  the panel with path, file name, extension.
     */
    private JPanel pnlCriteria() {
        JPanel pnlPath = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TitledBorder titleBorder = new CustomTitleBorder("Search: ");
        pnlPath.setBorder(titleBorder);
        pnlPath.setBackground(new Color(172, 175, 177));

        lblPath = new CustomLabel();
        lblPath.setText("Path :");
        pnlPath.add(lblPath);
        txtPath = new CustomTextField(50);
        pnlPath.add(txtPath);

        btnPathFolder = new CustomButton();
        btnPathFolder.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\examine24.png"));
        btnPathFolder.setToolTipText("Examine");
        btnPathFolder.addActionListener(this);
        pnlPath.add(btnPathFolder);

        btnSearch = new CustomButton();
        btnSearch.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\search24.png"));
        btnSearch.setToolTipText("Search");
        pnlPath.add(btnSearch);
        pnlPath.add(pnlButtonPlayer());
        return pnlPath;
    }

    /**
     * Return the instance of center panel with the Advanced button.
     *
     * @return pnlButtonAdvanced the Advanced button panel.
     */
    private JPanel pnlButtonPlayer() {
        JPanel pnlSearchAdvanced = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        btnPlay = new CustomButton();
        pnlSearchAdvanced.setBackground(new Color(172, 175, 177));
        btnPlay.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\Icons\\videoPlayer36.png"));
        btnPlay.setToolTipText("Play Video");
        pnlSearchAdvanced.add(btnPlay);
        btnPlay.addActionListener(this);
        return pnlSearchAdvanced;
    }

    /**
     * Return the instance of south panel with the table of file founds.
     *
     * @return pnlTableResult the south panel with the table of file founds.
     */
    private JPanel pnlTableResult() {
        JPanel pnlSearchGral = new JPanel(new BorderLayout());
        TitledBorder titleBorder = new CustomTitleBorder("List Search General: ");
        pnlSearchGral.setBorder(titleBorder);
        pnlSearchGral.setBackground(new Color(172, 175, 177));

        tbSearchGral = new JTableResult();
        JScrollPane scroll = new JScrollPane(tbSearchGral);
        pnlSearchGral.add(scroll, BorderLayout.CENTER);
        return pnlSearchGral;
    }

    /**
     * method that adds action to a button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnPathFolder)) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                txtPath.setText("" + chooser.getSelectedFile());
            }
        }
        if (e.getSource().equals(btnPlay)) {
            myListPlayer.clear();
            for (int i = 0; i < tbSearchGral.getRowCount(); i++) {
                //boolean isMultimedia = (Boolean)tbSearchGral.getValueAt(i,10);
                if (tbSearchGral.getValueAt(i, 10).toString().equals("true")) {
                    myListPlayer.add(tbSearchGral.getValueAt(i, 1));
                }
            }
            VideoMusicPlayer listPlayer = new VideoMusicPlayer(myListPlayer);
        }
    }
}
