/*
 * @(#) ConvertTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.convert;


import com.jala.model.criteria.CriteriaConverterVideo;
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
public class ConvertTest {
  // private static final String OPATH = "src\\test\\java\\com\\jala\\model\\convert\\testVideo\\converted";
  //private static final String IPATH = "src\\test\\java\\com\\jala\\model\\convert\\testVideo";

    private static final String OPATH = "c:\\regis1";
    private static final String IPATH = "c:\\regis\\Marvel.mp4";
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
     * This test probe the video conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
   public void convertVideoData() throws IOException {
        CriteriaConverterVideo criteriaConverterVideo = new CriteriaConverterVideo(IPATH,OPATH,".avi");
       criteriaConverterVideo.setFileName("test");
        convertVideo.convert(criteriaConverterVideo);
        //JPanelConverterVideo.setProgressBarValue(100);
        File file = new File(OPATH + "\\" + "test.avi");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
    }
}