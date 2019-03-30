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

import static org.junit.Assert.assertEquals;

/**
 * Test ConvertImage.
 */
public class ConvertImageTest {

    private final String OriginPath = "..\\ToolSearch\\src\\test\\resources\\Images\\Origin\\Cacho.jpg";
    private final String DestinationPath = "..\\ToolSearch\\src\\test\\resources\\Images\\Destination";
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
    public void convert_ReturnJpg_WhenSetFileNameBmp() {
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".bmp");
        convertImage.convert(criteria);
        criteria.setFileName("hi");
        assertEquals(1, sizeFolderInit);
    }

    /**
     * Test to convert Jpg only changing format.
     */
    @Test
    public void convert_ReturnJpg_WhenSentBasicPngFile() {
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".png");
        convertImage.convert(criteria);
        assertEquals(1, sizeFolderInit);
    }

    /**
     * Test to convert image changing size Width and Height.
     */
    @Test
    public void convert_ReturnJpg_WhenSetWidthAndHeightGifFile() {
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".gif");
        convertImage.convert(criteria);
        criteria.setWidth(100);
        criteria.setHeight(200);
        assertEquals(1, sizeFolderInit);
    }

    /**
     * Test to convert image changing size Width and Height.
     */
    @Test
    public void convert_ReturnJpg_WhenSetProportionFalseGifFile() {
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".tif");
        convertImage.convert(criteria);
        criteria.setMaintainProportion(false);
        assertEquals(1, sizeFolderInit);
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
                File file = new File(DestinationPath + "\\" + nameFile);
                file.delete();
                i++;
            }
    }
}
