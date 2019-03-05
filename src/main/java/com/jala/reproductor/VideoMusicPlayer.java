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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

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
import uk.co.caprica.vlcj.player.MediaDetails;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;

import com.sun.jna.platform.WindowUtils;
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
    public static void main(final String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VideoMusicPlayer(args);
            }
        });
    }

    /**
     * This constructor
     * @param args
     */
    public VideoMusicPlayer(String[] args) {
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

        mediaPlayer.getMediaPlayer().addMediaPlayerEventListener(new TestPlayerMediaPlayerEventListener());
        boolean transparentWindowsSupport = true;
        try {
            Class.forName("com.sun.awt.AWTUtilities");
        }
        catch(Exception e) {
            transparentWindowsSupport = false;
        }

        logger.debug("transparentWindowsSupport={}" + transparentWindowsSupport);

        if (transparentWindowsSupport) {
            final Window test = new Window(null, WindowUtils.getAlphaCompatibleGraphicsConfiguration()) {
                private static final long serialVersionUID = 1L;

                @Override
                public void paint(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;

                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

                    g.setColor(Color.white);
                    g.fillRoundRect(100, 150, 100, 100, 32, 32);

                    g.setFont(new Font("Sans", Font.BOLD, 32));
                    g.drawString("Heavyweight overlay test", 100, 300);
                }
            };
            test.setBackground(new Color(0,0,0)); // This is what you do in JDK7
        }
    }

    private final class TestPlayerMediaPlayerEventListener extends MediaPlayerEventAdapter {
        @Override
        public void playing(MediaPlayer mediaPlayer) {
            logger.debug("playing(mediaPlayer={})" + mediaPlayer);
            MediaDetails mediaDetails = mediaPlayer.getMediaDetails();
            logger.info("mediaDetails={}" + mediaDetails);
        }

        @Override
        public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
            logger.debug("videoOutput(mediaPlayer={},newCount={})" + mediaPlayer + newCount);
            if(newCount == 0) {
                return;
            }
            final Dimension dimension = mediaPlayer.getVideoDimension();
            logger.debug("dimension={}" + dimension);
            if(dimension != null) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        videoSurface.setSize(dimension);
                        mainFrame.pack();
                    }
                });
            }
        }
    }

    @SuppressWarnings("unused")
    private void enableMousePointer(boolean enable) {
        logger.debug("enableMousePointer(enable={})" + enable);
        if (enable) {
            videoSurface.setCursor(null);
        } else {
            Image blankImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            videoSurface.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(blankImage, new Point(0, 0), ""));
        }
    }
}