package com.jala.view;

import javax.swing.*;
import java.awt.*;

/**
 * JPSearchVideo class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class JPSearchVideo extends JPanel{
    private JLabel lbSourcFil, lbOutputFil, lbFramRat, lbVideoCod,
                               lbAudioCod, lbAspectRadio, lbDimention;
    private JTextField tfSourcFil, tfOutputFil;
    private JButton btSourcFil, btOutputFil, btConvert;
    private JComboBox cbFramRat, cbVideoCod, cbAudioCod, cbAspectRadio,
                                cbDimention;

    public JPSearchVideo() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        lbSourcFil = new JLabel("Source File: ");
        constraintComponent(lbSourcFil, 0, 0, GridBagConstraints.EAST);
        lbOutputFil = new JLabel("Output test File: ");
        constraintComponent(lbOutputFil, 0, 1, GridBagConstraints.EAST);
        tfSourcFil = new JTextField(20);
        constraintComponent(tfSourcFil, 1, 0, GridBagConstraints.WEST);
        tfOutputFil = new JTextField(20);
        constraintComponent(tfOutputFil, 1, 1, GridBagConstraints.WEST);
        btSourcFil = new JButton("...");
        constraintComponent(btSourcFil, 2, 0, GridBagConstraints.WEST);
        btOutputFil = new JButton("...");
        constraintComponent(btOutputFil, 2, 1, GridBagConstraints.WEST);
        lbFramRat = new JLabel("Frame Rate: ");
        constraintComponent(lbFramRat, 0, 2, GridBagConstraints.EAST);
        lbVideoCod = new JLabel("Video Codec: ");
        constraintComponent(lbVideoCod, 0, 3, GridBagConstraints.EAST);
        lbAudioCod = new JLabel("Audio Codec: ");
        constraintComponent(lbAudioCod, 0, 4, GridBagConstraints.EAST);
        cbFramRat = new JComboBox();
        cbFramRat.addItem("24");
        constraintComponent(cbFramRat, 1, 2, GridBagConstraints.WEST);
        cbVideoCod = new JComboBox();
        cbVideoCod.addItem("H264");
        constraintComponent(cbVideoCod, 1, 3, GridBagConstraints.WEST);
        cbAudioCod = new JComboBox();
        cbAudioCod.addItem("mp3");
        constraintComponent(cbAudioCod, 1, 4, GridBagConstraints.WEST);
        lbAspectRadio = new JLabel("Aspect Ratio: ");
        constraintComponent(lbAspectRadio, 2, 2, GridBagConstraints.EAST);
        lbDimention = new JLabel("Dimension: ");
        constraintComponent(lbDimention, 2, 3, GridBagConstraints.EAST);
        cbAspectRadio = new JComboBox();
        cbAspectRadio.addItem("4/3");
        constraintComponent(cbAspectRadio, 3, 2, GridBagConstraints.WEST);
        cbDimention = new JComboBox();
        cbDimention.addItem("400/300");
        constraintComponent(cbDimention, 3, 3, GridBagConstraints.WEST);
        btConvert = new JButton("Convert");
        constraintComponent(btConvert, 3, 5, GridBagConstraints.EAST);
    }

    private void constraintComponent(Component component, int posX, int posY, int align) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.anchor = align;
        add(component, constraints);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPSearchVideo test = new JPSearchVideo();
        frame.setContentPane(test);
        frame.setSize(600,400);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
