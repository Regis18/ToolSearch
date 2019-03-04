package com.jala.convertor.images.models;

import com.jala.convertor.models.CriteriaConvertor;
import com.jala.convertor.models.IConvertible;
import com.jala.utils.Logs;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ConvertorImage implements IConvertible {

    private String pathIM = "C:\\WorkingSpaceProg102\\secondSprint\\ToolSearch\\src\\main\\resources\\ThirdParty\\ImageMagick-7.0.8-28-portable-Q16-x64";

    private URL IM = this.getClass().getResource("");

    @Override
    public void convert(CriteriaConvertor criteriaConvertor) {
        ConvertCmd convertCmd = new ConvertCmd();
        convertCmd.setSearchPath(String.valueOf(pathIM));
        existNewFileName(criteriaConvertor);

            String pathAbsoluteNewImage = criteriaConvertor.getPathDestiny()
                    + criteriaConvertor.getNewFileName() +criteriaConvertor.getNewExtension();
            try {
                IMOperation convertImage = new IMOperation();
                convertImage.addImage(criteriaConvertor.getPathOrigin());
                convertImage.addImage(pathAbsoluteNewImage);
                if (criteriaConvertor.getHorizontal() > 0 && criteriaConvertor.getVertical() > 0) {
                    convertImage.sample(criteriaConvertor.getHorizontal(), criteriaConvertor.getVertical());
                } else if (criteriaConvertor.getHorizontal() > 0 && criteriaConvertor.getVertical() == -1) {

                }
                convertCmd.run(convertImage);
            } catch (InterruptedException interruptedException) {
                Logs.getInstance().getLog().error("", interruptedException);
            } catch (IM4JavaException iM4JavaException) {
                Logs.getInstance().getLog().error("", iM4JavaException);
            } catch (IOException e) {
                Logs.getInstance().getLog().error("", e);
            }
    }

    private void existNewFileName(CriteriaConvertor criteriaConvertor) {
        File imageToChange = new File(criteriaConvertor.getPathOrigin());
        if (criteriaConvertor.getNewFileName().isEmpty()) {
            criteriaConvertor.setNewFileName(imageToChange.getName());
        }
    }

    public void printURL() {
        System.out.println(IM.toString());
    }
}
