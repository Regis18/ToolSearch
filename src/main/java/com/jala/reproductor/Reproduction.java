package com.jala.reproductor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import uk.co.caprica.vlcj.binding.LibVlc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reproduction implements ActionListener{
    private final JFrame frame;
    private JPanel contentPane;

    private EmbeddedMediaPlayerComponent mediaPlayerComponent;

    private JButton pauseButton;
    private JButton rewindButton;
    private JButton skipButton;

    private static final String NATIVE_LIBRARY_SEARCH_PATH = "..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC";

    public static void main(final String [] args) {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
        LibVlc.INSTANCE.libvlc_get_version();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Reproduction(args);
            }
        });
    }
    public Reproduction(String [] args) {
        frame = new JFrame("My First Media Player");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });
        buttonLayout();
        actionListener();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        mediaPlayerComponent.getMediaPlayer().playMedia("C:\\Users\\Usuario\\Documents\\MEGAsync Downloads\\Avengers.infinity.war.2018.1080p-dual-lat-cinecalidad.to.mp4");
    }

    private void buttonLayout() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
        pauseButton = new JButton("Paused");
        controlsPane.add(pauseButton);
        rewindButton = new JButton("Rewind");
        controlsPane.add(rewindButton);
        skipButton = new JButton("Skip");
        controlsPane.add(skipButton);
        contentPane.add(controlsPane, BorderLayout.SOUTH);
    }

    private void actionListener() {
        pauseButton.addActionListener(this);
        rewindButton.addActionListener(this);
        skipButton.addActionListener(this);
        mediaPlayerComponent.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void playing(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        frame.setTitle(String.format(
                                "My First Media Player - %s",
                                mediaPlayerComponent.getMediaPlayer().getMediaMeta().getTitle()
                        ));
                    }
                });
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        closeWindow();
                    }
                });
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Failed to play media",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                        closeWindow();
                    }
                });
            }
        });
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == pauseButton) {
            mediaPlayerComponent.getMediaPlayer().pause();
        }
        if (event.getSource() == skipButton) {
            mediaPlayerComponent.getMediaPlayer().skip(10000);
        }
        if (event.getSource() == rewindButton) {
            mediaPlayerComponent.getMediaPlayer().skip(-10000);
        }
    }

    private void closeWindow() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}

