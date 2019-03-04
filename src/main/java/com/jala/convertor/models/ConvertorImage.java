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
 * @version 0.0.1
 * @author Areliez Vargas
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

        String pathAbsoluteNewImage = criteriaConvertor.getPathDestiny()
                + criteriaConvertor.getNewFileName() + criteriaConvertor.getNewExtension();
        try {
            IMOperation convertImage = new IMOperation();
            convertImage.addImage(criteriaConvertor.getPathOrigin());
            convertImage.addImage(pathAbsoluteNewImage);
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
