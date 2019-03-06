/**
 * @(#) ConvertorImage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.convertor.models;

import com.jala.utils.Logs;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

import java.io.File;
import java.io.IOException;

/**
 * ConvertorImage class allows to do a conversion the images.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class ConvertorImage implements IConvertible {

    /**
     * Constant for the path of image magick.
     */
    private final String IMAGE_MAGICK_PATH = getClass().getClassLoader()
            .getResource("ThirdParty/ImageMagick-7.0.8-28-portable-Q16-x64").getPath();

    /**
     * This method changes an image by criteria format set.
     * @param criteriaConvertor for convert an image.
     */
    @Override
    public void convert(CriteriaConvertor criteriaConvertor) {
        ConvertCmd convertCmd = new ConvertCmd();
        convertCmd.setSearchPath(IMAGE_MAGICK_PATH);
        existNewFileName(criteriaConvertor);
        try {
            IMOperation convertImage = new IMOperation();
            convertImage.addImage(criteriaConvertor.getPathOrigin());
            if (criteriaConvertor.isResize() == true && criteriaConvertor.isPercentage() == false) {
                convertByPixel(criteriaConvertor, convertImage);
            } else if (criteriaConvertor.isResize() == true && criteriaConvertor.isPercentage() == true) {
                convertByPercentage(criteriaConvertor, convertImage);
            }
            convertImage.addImage(criteriaConvertor.getPathAbsoluteNewFile());
            convertCmd.run(convertImage);
        } catch (InterruptedException interruptedException) {
            Logs.getInstance().getLog().error("The conversion was interrupted", interruptedException);
        } catch (IM4JavaException iM4JavaException) {
            Logs.getInstance().getLog().error("The conversion was interrupted", iM4JavaException);
        } catch (IOException e) {
            Logs.getInstance().getLog().error("There is some null data", e);
        }
    }

    /**
     * This method allows to resize the image file by percentage.
     * @param criteriaConvertor criteria to resize.
     * @param convertImage operation to convert image.
     */
    private void convertByPercentage(CriteriaConvertor criteriaConvertor, IMOperation convertImage) {
        if (criteriaConvertor.isMaintainProportion()) {
            if (criteriaConvertor.getWidth() > 0 && criteriaConvertor.getHeight() == -1) {
                criteriaConvertor.setHeight(criteriaConvertor.getWidth());
                convertImage.resize(criteriaConvertor.getWidth(), criteriaConvertor.getHeight(), "%");
            }
        } else if (!criteriaConvertor.isMaintainProportion()) {
            if (criteriaConvertor.getWidth() > 0 && criteriaConvertor.getHeight() > 0) {
                convertImage.resize(criteriaConvertor.getWidth(), criteriaConvertor.getHeight(), "%");
            }
        }
    }

    /**
     * This method allows to resize the image file by pixels maintain the proportion or
     * without maintain the proportion.
     * @param criteriaConvertor criteria to resize.
     * @param convertImage operation to convert image.
     */
    private void convertByPixel(CriteriaConvertor criteriaConvertor, IMOperation convertImage) {
        if (criteriaConvertor.isMaintainProportion()) {
            if (criteriaConvertor.getWidth() > 0 && criteriaConvertor.getHeight() == -1) {
                convertImage.sample(criteriaConvertor.getWidth());
            } else if (criteriaConvertor.getWidth() > 0 && criteriaConvertor.getHeight() > 0) {
                convertImage.sample(criteriaConvertor.getWidth(), criteriaConvertor.getHeight());
            }
        } else if (!criteriaConvertor.isMaintainProportion()) {
            if (criteriaConvertor.getWidth() > 0 && criteriaConvertor.getHeight() > 0) {
                convertImage.resize(criteriaConvertor.getWidth(), criteriaConvertor.getHeight(), "!");
            }
        }
    }

    /**
     * This method set the new file name for the new image file
     * by the file name of the image to convert if the user didn't set.
     * @param criteriaConvertor to set the file name.
     */
    private void existNewFileName(CriteriaConvertor criteriaConvertor) {
        File imageToChange = new File(criteriaConvertor.getPathOrigin());
        if (criteriaConvertor.getNewFileName().isEmpty()) {
            criteriaConvertor.setNewFileName(imageToChange.getName());
        }
    }
}
