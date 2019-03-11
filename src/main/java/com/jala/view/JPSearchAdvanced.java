package com.jala.view;

import javax.swing.*;
import java.awt.*;

/**
 * JPSearchAdvanced class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPSearchAdvanced extends JPanel{
    private JPanelAdvanced pnlAdvaced;
    private JTabbedPane jtpAdvanced;
    private JTableResult jtResult;
    private JPanel jpTableResult;

    public JPSearchAdvanced() {
        setLayout(new BorderLayout());
        initComponent();
    }

    public void init() {
        setLayout(new BorderLayout());
        initComponent();
    }

    private void initComponent() {
       pnlAdvaced = new JPanelAdvanced(new BorderLayout());
        jtpAdvanced = new JTabbedPane();
        //System.out.println("value: " + pnlAdvaced);
        jtpAdvanced.addTab("General", pnlAdvaced);
        jtpAdvanced.addTab("Video", pnlAdvaced);
        jtpAdvanced.addTab("Audio", pnlAdvaced);
        jtResult = new JTableResult();
        System.out.println("value1 tab: " + jtpAdvanced);
        jpTableResult = new JPanel(new BorderLayout());
        jpTableResult.add(jtResult, BorderLayout.CENTER);
        System.out.println("value2 table: " + jtpAdvanced);
        this.add(jtpAdvanced, BorderLayout.NORTH);
        //this.add(pnlAdvaced, BorderLayout.CENTER);
        this.add(jpTableResult, BorderLayout.SOUTH);


    }
}
