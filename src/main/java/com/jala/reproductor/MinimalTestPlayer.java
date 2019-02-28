package com.jala.reproductor;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MinimalTestPlayer {

    public MinimalTestPlayer() {
        registerLibrary();
    }

    /** * Runs the audio/video file */
    public void play(final String filename) {
        final Canvas videoSurface = new Canvas();
        final Frame frame = buildFrame(videoSurface);
        final List<String> vlcArgs = new ArrayList<String>();
        configureParameters(vlcArgs);
        final EmbeddedMediaPlayer mediaPlayer = createPlayer(vlcArgs, videoSurface);
        mediaPlayer.playMedia(filename);
    }

    /** * Important: Notice where is the libvlc, which contains all native functions to manipulate the player * * Windows: libvlc.dll * Linux: libvlc.so */
    // the problem is here
    private void registerLibrary() {
        NativeLibrary.addSearchPath( RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files (x86)\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        LibXUtil.initialise();
    }

    /** * Criate the frame where movie will be played */
    private Frame buildFrame(final Canvas videoSurface) {
        final Frame f = new Frame("Test Player");
        f.setSize(800, 600);
        f.addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                System.exit(0); } });
        f.setLayout(new BorderLayout());
        f.add(videoSurface, BorderLayout.CENTER);
        f.setVisible(true); return f;
    }

    /** * Configure VLC parameters */
    private void configureParameters(final List<String> vlcArgs) {
        vlcArgs.add("--no-plugins-cache");
        vlcArgs.add("--no-video-title-show");
        vlcArgs.add("--no-snapshot-preview");
        // Important, if this parameter would not be set on Windows, the app won't work
        if (RuntimeUtil.isWindows()) {
            vlcArgs.add("--plugin-path=C:\\Program Files (x86)\\VideoLAN\\VLC");
        }
    }

    /** * Build the player */
    private EmbeddedMediaPlayer createPlayer(final List<String> vlcArgs, final Canvas videoSurface) {
        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        EmbeddedMediaPlayer embeddedMediaPlayer = mediaPlayerComponent.getMediaPlayer();
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(vlcArgs.toArray(new String[vlcArgs.size()]));
        mediaPlayerFactory.setUserAgent("vlcj test player");
        embeddedMediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(videoSurface));
        embeddedMediaPlayer.setPlaySubItems(true); return embeddedMediaPlayer;
    }

    public static void main(String[] args) throws InterruptedException {
        MinimalTestPlayer player = new MinimalTestPlayer(); // Could be MP4, AVI, MOV, MKV, WMA, MPG, MP3, WAV, etc.
        player.play("C:\\Users\\Usuario\\Documents\\MEGAsync Downloads\\Avengers.infinity.war.2018.1080p-dual-lat-cinecalidad.to.mp4"); // Waits until the player window be closed
        Thread.currentThread().join();
    }
}

