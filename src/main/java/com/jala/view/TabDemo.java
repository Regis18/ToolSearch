package com.jala.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */


public class Main {

    private static ViewState viewState;
    private static JPanel mpanel;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JFrame frame;

    public Main() {

        frame = new JFrame();
        mpanel = new JPanel();
        panel1 = new Panel1();
        panel2 = new Panel2();

        // Sets default state
        changeState(ViewState.START_STATE);

        frame.setSize(100, 100);
        frame.add(mpanel);
        frame.setVisible(true);

    }

    /**
     * changeState(ViewState state)
     *
     * Publicly available state changer function
     *
     * @param state
     * @return void
     */
    public static void changeState(ViewState state) {
        viewState = state;
        System.out.println("change state: " + viewState);

        switch (state) {
            case START_STATE:
                mpanel.removeAll();
                mpanel.add(panel1);
                mpanel.revalidate();
                mpanel.repaint();
                break;
            case NEXT_STATE:
                mpanel.removeAll();
                mpanel.add(panel2);
                mpanel.revalidate();
                mpanel.repaint();
                break;
            default:
                System.out.println("UNKNOWN STATE!");
                break;
        }
    }

    /**
     * main(String[] args)
     *
     * Like an opinion, everyone has one.
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Main n = new Main();

    }

}
