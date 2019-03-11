package com.jala.view;

import javax.swing.*;

/**
 * TestUI class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class TestUI extends JFrame {
    private JPSearchAdvanced search;

    public TestUI() {
        search = new JPSearchAdvanced();
        setContentPane(search);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("UI Test"); // "super" JFrame sets title
        setSize(300, 100);         // "super" JFrame sets initial size
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestUI(); // Let the constructor do the job
            }
        });
    }
}
