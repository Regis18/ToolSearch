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

package com.jala.model.convert;

import com.jala.model.convert.ConvertorImage;
import com.jala.model.criteria.CriteriaConvertImage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Test Convert Image.
 *
 * @version 0.0.1
 * @author Cristian Lujan
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
     * Test to convert image date.
     */
    @Test
    public void convertReturnJpgImageData() throws IOException {
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteriaImage = new CriteriaConvertImage(OriginPath, DestinationPath+ "\\",".jpg");
        criteriaImage.setNewFileName("test");
        convertImage.convert(criteriaImage);
        File file = new File(DestinationPath + "\\", "test.jpg");
        assertTrue(file.exists());
    }

    /**
     * Test to convert image changing set File Name, set Percentage, set Resize.
     */
    @Test
    public void convert_ReturnJpg_WhenSetProportionTruePdfFile() {
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".pdf");
        convertImage.convert(criteria);
        criteria.setFileName("test");
        criteria.setMaintainProportion(true);
        criteria.setPercentage(true);
        criteria.setResize(true);
        assertEquals(1, sizeFolderInit);
    }

    /**
     * Test to convert image with valor null.
     */
    @Test
    public void convert_ReturnNull() {
        ConvertorImage convertImage = new ConvertorImage();
        CriteriaConvertImage criteria = new CriteriaConvertImage(OriginPath, DestinationPath + "\\",  ".webp");
        try {
            convertImage.convert(criteria);
            criteria.setFileName(null);
        }
        catch (Exception e) {
            Assert.fail("There is some null data" + e);
        }
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
