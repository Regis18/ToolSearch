/**
 * @(#) ConvertorImage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model;

import com.jala.model.criteria.CriteriaConverterImage;
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
     * @param criteriaObject for convert an image.
     */
    @Override
    public void convert(Object criteriaObject) {
        CriteriaConverterImage criteriaConverter = (CriteriaConverterImage) criteriaObject;
        ConvertCmd convertCmd = new ConvertCmd();
        convertCmd.setSearchPath(IMAGE_MAGICK_PATH);
        existNewFileName(criteriaConverter);
        try {
            IMOperation convertImage = new IMOperation();
            convertImage.addImage(criteriaConverter.getPath());
            if (criteriaConverter.isResize() == true && criteriaConverter.isPercentage() == false) {
                convertByPixel(criteriaConverter, convertImage);
            } else if (criteriaConverter.isResize() == true && criteriaConverter.isPercentage() == true) {
                convertByPercentage(criteriaConverter, convertImage);
            }
            convertImage.addImage(criteriaConverter.getPathAbsoluteNewFile());
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
     * @param criteriaConverter criteria to resize.
     * @param convertImage operation to convert image.
     */
    private void convertByPercentage(CriteriaConverterImage criteriaConverter, IMOperation convertImage) {
        if (criteriaConverter.isMaintainProportion()) {
            if (criteriaConverter.getWidth() > 0 && criteriaConverter.getHeight() == -1) {
                criteriaConverter.setHeight(criteriaConverter.getWidth());
                convertImage.resize(criteriaConverter.getWidth(), criteriaConverter.getHeight(), "%");
            }
        } else if (!criteriaConverter.isMaintainProportion()) {
            if (criteriaConverter.getWidth() > 0 && criteriaConverter.getHeight() > 0) {
                convertImage.resize(criteriaConverter.getWidth(), criteriaConverter.getHeight(), "%");
            }
        }
    }

    /**
     * This method allows to resize the image file by pixels maintain the proportion or
     * without maintain the proportion.
     * @param criteriaConverter criteria to resize.
     * @param convertImage operation to convert image.
     */
    private void convertByPixel(CriteriaConverterImage criteriaConverter, IMOperation convertImage) {
        if (criteriaConverter.isMaintainProportion()) {
            if (criteriaConverter.getWidth() > 0 && criteriaConverter.getHeight() == -1) {
                convertImage.sample(criteriaConverter.getWidth());
            } else if (criteriaConverter.getWidth() > 0 && criteriaConverter.getHeight() > 0) {
                convertImage.sample(criteriaConverter.getWidth(), criteriaConverter.getHeight());
            }
        } else if (!criteriaConverter.isMaintainProportion()) {
            if (criteriaConverter.getWidth() > 0 && criteriaConverter.getHeight() > 0) {
                convertImage.resize(criteriaConverter.getWidth(), criteriaConverter.getHeight(), "!");
            }
        }
    }

    /**
     * This method set the new file name for the new image file
     * by the file name of the image to convert if the user didn't set.
     * @param criteriaConverter to set the file name.
     */
    private void existNewFileName(CriteriaConverterImage criteriaConverter) {
        File imageToChange = new File(criteriaConverter.getPath());
        if (criteriaConverter.getNewFileName().isEmpty()) {
            criteriaConverter.setNewFileName(imageToChange.getName());
        }
    }
}
