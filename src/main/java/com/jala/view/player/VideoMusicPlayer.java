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

package com.jala.view.player;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
import com.jala.utils.Logs;
import com.sun.jna.NativeLibrary;
import org.apache.log4j.Logger;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.AudioOutput;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import com.jala.view.CustomTitleBorder;
import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JOptionPane;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * VideoMusicPlayer
 * @version 0.0.3
 * @author Luis Guardia
 */
public class VideoMusicPlayer {

    private static final Logger logger = Logs.getInstance().getLog();

    private  JFrame mainFrame;
    private  Canvas videoSurface;
    private  JPanel controlsPanel;
    private EmbeddedMediaPlayerComponent mediaPlayer;
    private static final String NATIVE_LIBRARY_SEARCH_PATH = "..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC";
    private JList playList, playListTitles;
    private DefaultListModel model, modelTitles;
    private MusicActual controlMusic = new MusicActual();
    private JScrollPane scrollListPlayer, pnlListPlayer;

    /**
     * This constructor create the connection with VLClib and the plugins.
     * Creates the main frame for the reproduction of video and music, and call to the panel of Control Panel
     * to add the buttons of play, stop, pause, etc.
     */
    public VideoMusicPlayer(ArrayList listMusic) {
        init(listMusic);
    }
    public void init(ArrayList listMusic) {
        loadPlaylist(listMusic);
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
        mediaPlayer.getMediaPlayerFactory().setUserAgent("Reproductions");
        mediaPlayer.getMediaPlayer().setVideoSurface(mediaPlayer.getMediaPlayerFactory().newVideoSurface(videoSurface));
        mediaPlayer.getMediaPlayer().setPlaySubItems(true);
        mediaPlayer.getMediaPlayer().setEnableKeyInputHandling(false);
        mediaPlayer.getMediaPlayer().setEnableMouseInputHandling(false);

        controlsPanel = new PlayerControlPanel(mediaPlayer, listMusic, controlMusic);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setBackground(Color.black);
        pnlListPlayer = pnlPlayer();
        mainFrame.add(videoSurface, BorderLayout.CENTER);
        mainFrame.add(pnlListPlayer, BorderLayout.EAST);
        mainFrame.add(controlsPanel, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayer.release();
            }
        });
        if(listMusic.size() > 0) {
            mediaPlayer.getMediaPlayer().playMedia(listMusic.get(0).toString());
            controlMusic.setPlayerMusic(0);
        }
        mainFrame.setVisible(true);

    }

    /**
     * Method that plays a video giving as parameter a ArrayList.
     */
    public void playVideo(ArrayList listTitle) {
        try {
            loadPlaylist(listTitle);
            mediaPlayer.getMediaPlayer().playMedia(listTitle.get(0).toString());
            controlMusic.setPlayerMusic(0);
            pnlListPlayer = pnlPlayer();

            mainFrame.setVisible(true);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Cannot play this file");
        }
    }

    /**
     * Method that plays a video giving as parameter a path.
     */
    public void playList(String path) {
        try {
            mediaPlayer.getMediaPlayer().playMedia(path);
            mainFrame.setVisible(true);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Cannot play this file");
        }
    }

    /**
     * Method that loads the ArrayList to a JList component
     * where the music and video list is added.
     */
    public void loadPlaylist(ArrayList listMusic) {
        model = new DefaultListModel();
        modelTitles = new DefaultListModel();
        playList = new JList(model);
        playListTitles = new JList(modelTitles);
        for(int i=0 ; i< listMusic.size(); i++) {
            model.addElement(listMusic.get(i));
            String[] title = listMusic.get(i).toString().split("\\\\");
            modelTitles.addElement(title[title.length-1]);
        }
        playListTitles.setBackground(Color.WHITE );
        playListTitles.setSize(300,600);
        playListTitles.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    playList(model.getElementAt(index).toString());
                    controlMusic.setPlayerMusic(index);
                }
            }
        });
    }



    /**
     * Method that return a JScrollPane and load the ArrayList to a JList.
     */
    private JScrollPane pnlPlayer(){
        JPanel pPlayer = new JPanel(new BorderLayout());
        TitledBorder titleBorder =  new CustomTitleBorder("List Reproduction: ");
        pPlayer.setBorder(titleBorder);
        pPlayer.setBackground(new Color(0,0,0,65));
        JLabel listTitle = new JLabel("List of Reproduction: ");
        pPlayer.add(listTitle, BorderLayout.NORTH);
        pPlayer.add(playListTitles, BorderLayout.CENTER);
        scrollListPlayer = new JScrollPane(pPlayer);
        return scrollListPlayer;
    }
}
