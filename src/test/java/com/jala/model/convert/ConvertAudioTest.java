package com.jala.model.convert;

import com.jala.model.criteria.CriteriaConverterAudio;
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
    private ConvertAudio convertAudio;

    /**
     * Setup.
     *
     * @throws Exception exception..
     */
    @Before
    public void setUp() throws Exception {
        convertAudio = new ConvertAudio();
    }

    /**
     * This test probe the audio conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
    public void convertAudio() throws IOException {
        CriteriaConverterAudio criteriaConverterAudio = new CriteriaConverterAudio(IPATH,OPATH,".mp3");
        criteriaConverterAudio.setNewFileName("test");
        Common.useProgressBar = false;
        convertAudio.convert(criteriaConverterAudio);
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
        CriteriaConverterAudio criteriaConverterAudio = new CriteriaConverterAudio(IPATH,OPATH,".aac");
        criteriaConverterAudio.setNewFileName("test");
        criteriaConverterAudio.setAdvanced(true);
        Common.useProgressBar = false;
        convertAudio.convert(criteriaConverterAudio);
        File file = new File(OPATH + "test.aac");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
        Common.useProgressBar = true;
    }
}