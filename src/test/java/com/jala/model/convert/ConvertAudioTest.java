package com.jala.model.convert;

import com.jala.model.criteria.CriteriaConverterVideo;
import com.jala.utils.Common;
import com.jala.view.JPanelConverterVideo;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;

import static org.junit.Assert.assertTrue;

/**
 * Class Converter Model Test.
 * Unit tests to verify the conversion of files by different criteria.
 */
public class ConvertAudioTest {
    private static final String OPATH = "src\\test\\java\\com\\jala\\model\\convert\\test\\";
    private static final String IPATH = "src\\test\\java\\com\\jala\\model\\convert\\test\\mimel.aac";
    private ConvertVideo convertVideo;

    /**
     * Setup.
     *
     * @throws Exception exception..
     */
    @Before
    public void setUp() throws Exception {
        convertVideo = new ConvertVideo();
    }

    /**
     * This test probe the audio conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
    public void convertAudio() throws IOException {
        CriteriaConverterVideo criteriaConverterVideo = new CriteriaConverterVideo(IPATH,OPATH,".mp3");
        criteriaConverterVideo.setNewFileName("test");
        Common.useProgressBar = false;
        convertVideo.convert(criteriaConverterVideo);
        File file = new File(OPATH + "test.mp3");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
    }

    /**
     * This test probe the audio advanced conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
    public void convertAdvancedAudio() throws IOException {
        CriteriaConverterVideo criteriaConverterVideo = new CriteriaConverterVideo(IPATH,OPATH,".aac");
        criteriaConverterVideo.setNewFileName("test");
        criteriaConverterVideo.setIsAdvanced(true);
        Common.useProgressBar = false;
        convertVideo.convert(criteriaConverterVideo);
        File file = new File(OPATH + "test.aac");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
        Common.useProgressBar = true;
    }
}