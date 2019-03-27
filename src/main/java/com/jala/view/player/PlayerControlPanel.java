/*
 * @(#) PlayerControlPanel.java Copyright (c) 2019 Jala Foundation.
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

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

import javafx.scene.media.MediaPlayer;
import uk.co.caprica.vlcj.binding.LibVlcConst;
import uk.co.caprica.vlcj.filter.swing.SwingFileFilterFactory;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * PlayerControlPanel
 * @version 0.0.3
 * @author Luis Guardia
 */
public class PlayerControlPanel extends JPanel implements ActionListener {
    private static final int SKIP_TIME_MS = 10 * 1000;
    private final EmbeddedMediaPlayerComponent mediaPlayer;
    private JLabel lblPlaybackTime;
    private JSlider sldPositionSlider, sldVolumeSlider;
    private JButton btnPreviousTrack, btnRewindTrack, btnStopTrack, btnPauseTrack, btnPlayTrack, btnFastForwardTrack;
    private JButton btnNextTrack, btnToggleMute, btnLoadTrack;
    private JFileChooser fileChooser;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private boolean mousePressedPlaying = false;
    private ArrayList listMusic;
    private MusicActual controlMusic;
    VideoMusicPlayer listPlayer;

    /**
     * Calls the method CreateUI and initialize the executorService to update info.
     * @param mediaPlayer, listMusic and controlMusic
     */
    public PlayerControlPanel(EmbeddedMediaPlayerComponent mediaPlayer, ArrayList listMusic,MusicActual controlMusic) {
        this.listMusic = listMusic;
        this.mediaPlayer = mediaPlayer;
        this.controlMusic = controlMusic;
        createUI();
        executorService.scheduleAtFixedRate(new UpdateRunnable(mediaPlayer), 0L, 1L, TimeUnit.SECONDS);
    }

    /**
     * Calls to others methods to create UI panel
     */
    private void createUI() {
        createControls();
        layoutControls();
        registerListener();
    }

    /**
     * Register every button with listener.
     */
    private void registerListener() {
        sldPositionSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                if (mediaPlayer.getMediaPlayer().isPlaying()) {
                    mousePressedPlaying = true;
                    mediaPlayer.getMediaPlayer().play();
                } else {
                    mousePressedPlaying = false;
                }
                setSliderBasedPosition();
            }
            @Override
            public void mouseReleased(MouseEvent event) {
                setSliderBasedPosition();
                updateUIState();
            }
        });
        btnPreviousTrack.addActionListener(this);
        btnRewindTrack.addActionListener(this);
        btnStopTrack.addActionListener(this);
        btnPauseTrack.addActionListener(this);
        btnPlayTrack.addActionListener(this);
        btnFastForwardTrack.addActionListener(this);
        btnNextTrack.addActionListener(this);
        btnToggleMute.addActionListener(this);
        btnLoadTrack.addActionListener(this);
        sldVolumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                JSlider source = (JSlider)event.getSource();
                mediaPlayer.getMediaPlayer().setVolume(source.getValue());
            }
        });
    }

    /**
     * Listen the actions that happen in the UI and detect the action and do an action.
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnPreviousTrack) {
            if(controlMusic.getPlayerMusic() > 0){
                mediaPlayer.getMediaPlayer().playMedia(listMusic.get(controlMusic.getPlayerMusic()-1).toString());
                controlMusic.setPlayerMusic(controlMusic.getPlayerMusic()-1);
            }
        }
        if (event.getSource() == btnNextTrack) {
            if (controlMusic.getPlayerMusic() < listMusic.size()-1) {
                mediaPlayer.getMediaPlayer().playMedia(listMusic.get(controlMusic.getPlayerMusic() + 1).toString());
                controlMusic.setPlayerMusic(controlMusic.getPlayerMusic()+1);
            }
        }
        if (event.getSource() == btnRewindTrack) {
            skip(-SKIP_TIME_MS);
        }
        if (event.getSource() == btnStopTrack) {
            mediaPlayer.getMediaPlayer().stop();
            sldPositionSlider.setValue(0);
            lblPlaybackTime.setText("00:00:00");
        }
        if (event.getSource() == btnPauseTrack) {
            mediaPlayer.getMediaPlayer().pause();
        }
        if (event.getSource() == btnPlayTrack) {
            mediaPlayer.getMediaPlayer().play();
        }
        if (event.getSource() == btnFastForwardTrack) {
            skip(SKIP_TIME_MS);
        }
        if (event.getSource() == btnToggleMute) {
            mediaPlayer.getMediaPlayer().mute();
        }
        if (event.getSource() == btnLoadTrack) {
            mediaPlayer.getMediaPlayer().enableOverlay(false);
            if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(PlayerControlPanel.this)) {
                mediaPlayer.getMediaPlayer().playMedia(fileChooser.getSelectedFile().getAbsolutePath());
                listMusic.clear();
                listMusic.add(fileChooser.getSelectedFile().getAbsolutePath());
                listPlayer.loadPlaylist(listMusic);
                mediaPlayer.getMediaPlayer().playMedia(fileChooser.getSelectedFile().getAbsolutePath());
                controlMusic.setPlayerMusic(0);

            }
            mediaPlayer.getMediaPlayer().enableOverlay(true);
        }
    }

    /**
     * Initialize every button, slider and label.
     */
    private void createControls() {
        lblPlaybackTime = new JLabel("hh:mm:ss");
        sldPositionSlider = new JSlider();
        sldPositionSlider.setMaximum(1000);
        sldPositionSlider.setValue(0);
        sldPositionSlider.setToolTipText("Position");

        btnPreviousTrack = new JButton();
        btnPreviousTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_start_blue.png"));
        btnPreviousTrack.setToolTipText("Previous");

        btnRewindTrack = new JButton();
        btnRewindTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_rewind_blue.png"));
        btnRewindTrack.setToolTipText("Skip back");

        btnStopTrack = new JButton();
        btnStopTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_stop_blue.png"));
        btnStopTrack.setToolTipText("Stop");

        btnPauseTrack = new JButton();
        btnPauseTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_pause_blue.png"));
        btnPauseTrack.setToolTipText("Play/pause");

        btnPlayTrack = new JButton();
        btnPlayTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_play_blue.png"));
        btnPlayTrack.setToolTipText("Play");

        btnFastForwardTrack = new JButton();
        btnFastForwardTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_fastforward_blue.png"));
        btnFastForwardTrack.setToolTipText("Skip forward");

        btnNextTrack = new JButton();
        btnNextTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_end_blue.png"));
        btnNextTrack.setToolTipText("Next track");

        btnToggleMute = new JButton();
        btnToggleMute.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\sound_mute.png"));
        btnToggleMute.setToolTipText("Toggle Mute");

        sldVolumeSlider =  new JSlider();
        sldVolumeSlider.setOrientation(JSlider.HORIZONTAL);
        sldVolumeSlider.setMinimum(LibVlcConst.MIN_VOLUME);
        sldVolumeSlider.setMaximum(LibVlcConst.MAX_VOLUME);
        sldVolumeSlider.setPreferredSize(new Dimension(100, 40));
        sldVolumeSlider.setToolTipText("Change Volume");

        btnLoadTrack = new JButton();
        btnLoadTrack.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_eject_blue.png"));
        btnLoadTrack.setToolTipText("Load/eject Media");

        fileChooser = new JFileChooser();
        fileChooser.setApproveButtonText("Play");
        fileChooser.addChoosableFileFilter(SwingFileFilterFactory.newVideoFileFilter());
        fileChooser.addChoosableFileFilter(SwingFileFilterFactory.newAudioFileFilter());
        fileChooser.addChoosableFileFilter(SwingFileFilterFactory.newPlayListFileFilter());
        FileFilter defaultFilter = SwingFileFilterFactory.newMediaFileFilter();
        fileChooser.addChoosableFileFilter(defaultFilter);
        fileChooser.setFileFilter(defaultFilter);
    }

    /**
     * Add the buttons, slider and label to the panel.
     */
    private void layoutControls() {
        setBorder(new EmptyBorder(4,4,4,4));
        setLayout(new BorderLayout());

        JPanel positionPanel = new JPanel();
        positionPanel.setLayout(new GridLayout(1, 1));
        positionPanel.add(sldPositionSlider);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(8, 0));
        topPanel.add(lblPlaybackTime, BorderLayout.WEST);
        topPanel.add(positionPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        JPanel pnlControlButton = new JPanel();
        pnlControlButton.setLayout(new FlowLayout());

        pnlControlButton.add(btnPreviousTrack);
        pnlControlButton.add(btnRewindTrack);
        pnlControlButton.add(btnStopTrack);
        pnlControlButton.add(btnPauseTrack);
        pnlControlButton.add(btnPlayTrack);
        pnlControlButton.add(btnFastForwardTrack);
        pnlControlButton.add(btnNextTrack);
        pnlControlButton.add(sldVolumeSlider);
        pnlControlButton.add(btnToggleMute);
        pnlControlButton.add(btnLoadTrack);
        add(pnlControlButton, BorderLayout.SOUTH);
    }

    /**
     *If the slider is modified by the user, that value will change in the media player too, changing the way of the video.
     */
    private void setSliderBasedPosition() {
        if (!mediaPlayer.getMediaPlayer().isSeekable()) {
            return;
        }
        float positionValue = sldPositionSlider.getValue() / 1000.0f;
        if (positionValue > 0.99f) {
            positionValue = 0.99f;
        }
        mediaPlayer.getMediaPlayer().setPosition(positionValue);
    }

    /**
     * Update the info of the UI about the progress of the video.
     */
    private void updateUIState() {
        if (!mediaPlayer.getMediaPlayer().isPlaying()) {
            if (!mousePressedPlaying) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                }
                mediaPlayer.getMediaPlayer().pause();
            }
        }
        long time = mediaPlayer.getMediaPlayer().getTime();
        int position = (int)(mediaPlayer.getMediaPlayer().getPosition() * 1000.0f);
        updateTime(time);
        updatePosition(position);
    }

    /**
     * Skip 10 seconds in the video
     * @param skipTime int
     */
    public void skip(int skipTime) {
        if (mediaPlayer.getMediaPlayer().getLength() > 0) {
            mediaPlayer.getMediaPlayer().skip(skipTime);
            updateUIState();
        }
    }

    /**
     * Sets a value to positionSlider
     * @param value
     */
    private void updatePosition(int value) {
        sldPositionSlider.setValue(value);
    }

    /**
     * Put the actual time to the timeLabel
     * @param millis
     */
    private void updateTime(long millis) {
        String s = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        lblPlaybackTime.setText(s);
    }

    /**
     * Update the time, position, chapter and chapterCount, to show to the user.
     */
    private final class UpdateRunnable implements Runnable {
        private final EmbeddedMediaPlayerComponent mediaPlayer;
        private UpdateRunnable(EmbeddedMediaPlayerComponent mediaPlayer) {
            this.mediaPlayer = mediaPlayer;
        }
        @Override
        public void run() {
            final long time = mediaPlayer.getMediaPlayer().getTime();
            final int position = (int)(mediaPlayer.getMediaPlayer().getPosition() * 1000.0f);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer.getMediaPlayer().isPlaying()) {
                        if (mediaPlayer.getMediaPlayer().getTime() >= mediaPlayer.getMediaPlayer().getLength() - 1200) {
                            if (controlMusic.getPlayerMusic() < listMusic.size()-1) {
                                mediaPlayer.getMediaPlayer().playMedia(listMusic.get(controlMusic.getPlayerMusic() + 1).toString());
                                controlMusic.setPlayerMusic(controlMusic.getPlayerMusic()+1);
                                updateTime(time);
                                updatePosition(position);
                            }
                        } else {
                            updateTime(time);
                            updatePosition(position);
                        }
                    }

                }
            });
        }
    }
}