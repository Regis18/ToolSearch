/*
 * @(#) ConvertImageTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.convertor.models;

import com.jala.model.convert.ConvertorImage;
import com.jala.model.criteria.CriteriaConvertImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Test ConvertImage.
 */
public class ConvertImageTest {

    private final String OriginPath = "C:\\View\\ToolSearch\\src\\test\\resources\\Images\\Origin\\Cacho.jpg";
    private final String DestinationPath = "C:\\View\\ToolSearch\\src\\test\\resources\\Images\\Destination";
    private  File folder;
    int sizeFolderInit;

    /**
     * Method to set file list initialization.
     */
    @Before
    public void setup() {
        folder = new File(DestinationPath);
        sizeFolderInit = folder.list().length + 1;
    }

    /**
     * Test to convert image changing format and set file name.
     */
    @Test
    public void convert_ReturnJPG_WhenSentBasicBmpFile() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".bmp");
        convertImage.convert(criteria);
        criteria.setFileName("hi");
        assertEquals(2, sizeFolderInit);
    }

    /**
     * Test to convert Jpg only changing format.
     */
    @Test
    public void convert_ReturnJPG_WhenSentBasicPngFile1() {

        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".png");
        convertImage.convert(criteria);
        assertEquals(2, sizeFolderInit);
    }

    /**
     * Test to this method returns the folder to the initial state.
     */
    @After
    public void clear() {
            String[] files = folder.list();
            int i = 0;
            while (i< files.length) {
                String nameFile = files[i];
                System.out.println("matar : " + nameFile);
                File file = new File(DestinationPath + "\\" + nameFile);
                System.out.println("path : " + file.getPath());
                file.delete();
                i++;
            }
    }

}