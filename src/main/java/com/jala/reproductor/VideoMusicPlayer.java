/*
 * @(#) VideoMusicPlayer.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.reproductor;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import com.jala.utils.Logs;
import com.sun.jna.NativeLibrary;
import org.apache.log4j.Logger;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.AudioOutput;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;

import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 * VideoMusicPlayer
 * @version 0.0.2
 * @author Regis Humana
 */
public class VideoMusicPlayer {

    private static final Logger logger = Logs.getInstance().getLog();

    private final JFrame mainFrame;
    private final Canvas videoSurface;
    private final JPanel controlsPanel;

    private EmbeddedMediaPlayerComponent mediaPlayer;
    private static final String NATIVE_LIBRARY_SEARCH_PATH = "..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC";

    /**
     * This method has to erase because this main it just for PoC
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VideoMusicPlayer();
            }
        });
    }

    /**
     * This constructor create the connection with VLClib and the plugins.
     * Creates the main frame for the reproduction of video and music, and call to the panel of Control Panel
     * to add the buttons of play, stop, pause, etc.
     */
    public VideoMusicPlayer() {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
        LibVlc.INSTANCE.libvlc_get_version();

        videoSurface = new Canvas();

        videoSurface.setBackground(Color.black);
        videoSurface.setSize(800, 600);
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        mainFrame = new JFrame("Reproductions");

        FullScreenStrategy fullScreenStrategy = new DefaultFullScreenStrategy(mainFrame);

        mediaPlayer = new EmbeddedMediaPlayerComponent();
        mediaPlayer.getMediaPlayerFactory().newEmbeddedMediaPlayer(fullScreenStrategy);
        mediaPlayer.getMediaPlayerFactory().setUserAgent("reproductions");

        List<AudioOutput> audioOutputs = mediaPlayer.getMediaPlayerFactory().getAudioOutputs();
        for (int i = 0; i < audioOutputs.size(); i++) {
            logger.debug("audioOutputs={}" + audioOutputs.get(i).getName());
        }
        mediaPlayer.getMediaPlayer().setVideoSurface(mediaPlayer.getMediaPlayerFactory().newVideoSurface(videoSurface));
        mediaPlayer.getMediaPlayer().setPlaySubItems(true);
        mediaPlayer.getMediaPlayer().setEnableKeyInputHandling(false);
        mediaPlayer.getMediaPlayer().setEnableMouseInputHandling(false);

        controlsPanel = new PlayerControlPanel(mediaPlayer);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayer.release();
                System.exit(0);
            }
        });
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setBackground(Color.black);
        mainFrame.add(videoSurface, BorderLayout.CENTER);
        mainFrame.add(controlsPanel, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                logger.debug("windowClosing(evt={})"  + evt);

                if (mediaPlayer != null) {
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                if (mediaPlayer.getMediaPlayerFactory() != null) {
                    mediaPlayer.getMediaPlayerFactory().release();
                }
            }
        });
        mainFrame.setVisible(true);
    }
}