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
package com.jala.reproductor;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * PlayerControlPanel
 * @version 0.0.2
 * @author Regis Humana
 */
public class PlayerControlPanel extends JPanel implements ActionListener {

    private static final int SKIP_TIME_MS = 10 * 1000;
    private final EmbeddedMediaPlayerComponent mediaPlayer;

    private JLabel timeLabel, chapterLabel;
    private JSlider positionSlider, volumeSlider;
    private JButton previousChapterButton, rewindButton, stopButton, pauseButton, playButton, fastForwardButton, nextChapterButton;
    private JButton toggleMuteButton, captureButton, ejectButton, connectButton, fullScreenButton, subTitlesButton;
    private JFileChooser fileChooser;

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private boolean mousePressedPlaying = false;

    /**
     * Calls the method CreateUI and initialize the executorService to update info.
     * @param mediaPlayer
     */
    public PlayerControlPanel(EmbeddedMediaPlayerComponent mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
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

        positionSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                if (mediaPlayer.getMediaPlayer().isPlaying()) {
                    mousePressedPlaying = true;
                    mediaPlayer.getMediaPlayer().pause();
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

        previousChapterButton.addActionListener(this);
        rewindButton.addActionListener(this);
        stopButton.addActionListener(this);
        pauseButton.addActionListener(this);
        playButton.addActionListener(this);
        fastForwardButton.addActionListener(this);
        nextChapterButton.addActionListener(this);
        toggleMuteButton.addActionListener(this);
        captureButton.addActionListener(this);
        ejectButton.addActionListener(this);
        connectButton.addActionListener(this);
        fullScreenButton.addActionListener(this);
        subTitlesButton.addActionListener(this);
        volumeSlider.addChangeListener(new ChangeListener(){
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
        if (event.getSource() == previousChapterButton) {
            mediaPlayer.getMediaPlayer().previousChapter();
        }
        if (event.getSource() == rewindButton) {
            skip(-SKIP_TIME_MS);
        }
        if (event.getSource() == stopButton) {
            mediaPlayer.getMediaPlayer().stop();
            positionSlider.setValue(0);
            timeLabel.setText("00:00:00");
        }
        if (event.getSource() == pauseButton) {
            mediaPlayer.getMediaPlayer().pause();
        }
        if (event.getSource() == playButton) {
            mediaPlayer.getMediaPlayer().play();
        }
        if (event.getSource() == fastForwardButton) {
            skip(SKIP_TIME_MS);
        }
        if (event.getSource() == nextChapterButton) {
            mediaPlayer.getMediaPlayer().nextChapter();
        }
        if (event.getSource() == toggleMuteButton) {
            mediaPlayer.getMediaPlayer().mute();
        }
        if (event.getSource() == captureButton) {
            mediaPlayer.getMediaPlayer().saveSnapshot();
        }
        if (event.getSource() == ejectButton) {
            mediaPlayer.getMediaPlayer().enableOverlay(false);
            if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(PlayerControlPanel.this)) {
                mediaPlayer.getMediaPlayer().playMedia(fileChooser.getSelectedFile().getAbsolutePath());
            }
            mediaPlayer.getMediaPlayer().enableOverlay(true);
        }
        if(event.getSource() == connectButton) {
            mediaPlayer.getMediaPlayer().enableOverlay(false);
            String url = JOptionPane.showInputDialog(PlayerControlPanel.this, "Enter a media URL",
                    "Connect to media", JOptionPane.QUESTION_MESSAGE);
            if (url != null && url.length() > 0) {
                mediaPlayer.getMediaPlayer().playMedia(url);
            }
            mediaPlayer.getMediaPlayer().enableOverlay(true);
        }
        if (event.getSource() == fullScreenButton) {
            mediaPlayer.getMediaPlayer().toggleFullScreen();
        }
        if (event.getSource() ==subTitlesButton) {
            int spu = mediaPlayer.getMediaPlayer().getSpu();
            if (spu > -1) {
                spu ++;
                if (spu > mediaPlayer.getMediaPlayer().getSpuCount()) {
                    spu = -1;
                }
            } else  {
                spu = 0;
            }
            mediaPlayer.getMediaPlayer().setSpu(spu);
        }
    }

    /**
     * Initialize every button, slider and label.
     */
    private void createControls() {
        timeLabel = new JLabel("hh:mm:ss");
        positionSlider = new JSlider();
        positionSlider.setMaximum(1000);
        positionSlider.setValue(0);
        positionSlider.setToolTipText("Position");

        chapterLabel = new JLabel("00/00");

        previousChapterButton = new JButton();
        previousChapterButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_start_blue.png"));
        previousChapterButton.setToolTipText("Go to previous chapter");

        rewindButton = new JButton();
        rewindButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_rewind_blue.png"));
        rewindButton.setToolTipText("Skip back");

        stopButton = new JButton();
        stopButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_stop_blue.png"));
        stopButton.setToolTipText("Stop");

        pauseButton = new JButton();
        pauseButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_pause_blue.png"));
        pauseButton.setToolTipText("Play/pause");

        playButton = new JButton();
        playButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_play_blue.png"));
        playButton.setToolTipText("Play");

        fastForwardButton = new JButton();
        fastForwardButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_fastforward_blue.png"));
        fastForwardButton.setToolTipText("Skip forward");

        nextChapterButton = new JButton();
        nextChapterButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_end_blue.png"));
        nextChapterButton.setToolTipText("Go to next chapter");

        toggleMuteButton = new JButton();
        toggleMuteButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\sound_mute.png"));
        toggleMuteButton.setToolTipText("Toggle Mute");

        volumeSlider =  new JSlider();
        volumeSlider.setOrientation(JSlider.HORIZONTAL);
        volumeSlider.setMinimum(LibVlcConst.MIN_VOLUME);
        volumeSlider.setMaximum(LibVlcConst.MAX_VOLUME);
        volumeSlider.setPreferredSize(new Dimension(100, 40));
        volumeSlider.setToolTipText("Change Volume");

        captureButton = new JButton();
        captureButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\camera.png"));
        captureButton.setToolTipText("Take a picture");

        ejectButton = new JButton();
        ejectButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\control_eject_blue.png"));
        ejectButton.setToolTipText("Load/eject Media");

        connectButton = new JButton();
        connectButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\connect.png"));
        connectButton.setToolTipText("Connect to Media");

        fileChooser = new JFileChooser();
        fileChooser.setApproveButtonText("Play");
        fileChooser.addChoosableFileFilter(SwingFileFilterFactory.newVideoFileFilter());
        fileChooser.addChoosableFileFilter(SwingFileFilterFactory.newAudioFileFilter());
        fileChooser.addChoosableFileFilter(SwingFileFilterFactory.newPlayListFileFilter());
        FileFilter defaultFilter = SwingFileFilterFactory.newMediaFileFilter();
        fileChooser.addChoosableFileFilter(defaultFilter);
        fileChooser.setFileFilter(defaultFilter);

        fullScreenButton = new JButton();
        fullScreenButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\monitor.png"));
        fullScreenButton.setToolTipText("Full Screen");

        subTitlesButton = new JButton();
        subTitlesButton.setIcon(new ImageIcon("..\\ToolSearch\\src\\main\\resources\\ThirdParty\\VLC\\icons\\script.png"));
        subTitlesButton.setToolTipText("Cycle subtitles");
    }

    /**
     * Add the buttons, slider and label to the panel.
     */
    private void layoutControls() {
        setBorder(new EmptyBorder(4,4,4,4));
        setLayout(new BorderLayout());

        JPanel positionPanel = new JPanel();
        positionPanel.setLayout(new GridLayout(1, 1));
        positionPanel.add(positionSlider);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(8, 0));
        topPanel.add(timeLabel, BorderLayout.WEST);
        topPanel.add(positionPanel, BorderLayout.CENTER);
        topPanel.add(chapterLabel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(previousChapterButton);
        buttonPanel.add(rewindButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(playButton);
        buttonPanel.add(fastForwardButton);
        buttonPanel.add(nextChapterButton);
        buttonPanel.add(volumeSlider);
        buttonPanel.add(toggleMuteButton);
        buttonPanel.add(captureButton);
        buttonPanel.add(ejectButton);
        buttonPanel.add(connectButton);
        buttonPanel.add(fullScreenButton);
        buttonPanel.add(subTitlesButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     *If the slider is modified by the user, that value will change in the media player too, changing the way of the video.
     */
    private void setSliderBasedPosition() {
        if (!mediaPlayer.getMediaPlayer().isSeekable()) {
            return;
        }
        float positionValue = positionSlider.getValue() / 1000.0f;
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
                    //TODO LOGS
                }
                mediaPlayer.getMediaPlayer().pause();
            }
        }
        long time = mediaPlayer.getMediaPlayer().getTime();
        int position = (int)(mediaPlayer.getMediaPlayer().getPosition() * 1000.0f);
        int chapter = mediaPlayer.getMediaPlayer().getChapter();
        int chapterCount = mediaPlayer.getMediaPlayer().getChapterCount();
        updateTime(time);
        updatePosition(position);
        updateChapter(chapter, chapterCount);
    }

    /**
     * Skip 10 seconds in the video
     * @param skipTime int
     */
    private void skip(int skipTime) {
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
        positionSlider.setValue(value);
    }

    /**
     * Put the actual time to the timeLabel
     * @param millis
     */
    private void updateTime(long millis) {
        String s = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        timeLabel.setText(s);
    }

    /**
     * Sets the chapterLabel with the actual chapter
     * @param chapter
     * @param chapterCount
     */
    private void updateChapter(int chapter, int chapterCount) {
        String s = chapterCount != -1 ? (chapter + 1) + "/" + chapterCount : "-";
        chapterLabel.setText(s);
        chapterLabel.invalidate();
        validate();
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
            final int chapter = mediaPlayer.getMediaPlayer().getChapter();
            final int chapterCount = mediaPlayer.getMediaPlayer().getChapterCount();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer.getMediaPlayer().isPlaying()) {
                        updateTime(time);
                        updatePosition(position);
                        updateChapter(chapter, chapterCount);
                    }
                }
            });
        }
    }
}
