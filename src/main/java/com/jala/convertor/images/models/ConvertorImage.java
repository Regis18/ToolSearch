package com.jala.convertor.images.models;

import com.jala.convertor.models.CriteriaConvertor;
import com.jala.convertor.models.IConvertible;
import com.jala.utils.Logs;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

import java.io.IOException;
import java.net.URL;

public class ConvertorImage implements IConvertible {

    private String pathIM = "C:\\WorkingSpaceProg102\\secondSprint\\ToolSearch\\src\\main\\resources\\ThirdParty\\ImageMagick-7.0.8-28-portable-Q16-x64\"";

    //private URL IM = getClass().getResource("/ImageMagick-7.0.8-28-portable-Q16-x64");

    @Override
    public void convert(CriteriaConvertor criteriaConvertor) {
        ConvertCmd convertCmd = new ConvertCmd();
        convertCmd.setSearchPath(pathIM);
        try {
            IMOperation convertImage = new IMOperation();
            convertImage.addImage(criteriaConvertor.getPathOrigin());
            convertImage.addImage(criteriaConvertor.getPathDestiny());
            convertCmd.run(convertImage);
        } catch (InterruptedException interruptedException) {
            Logs.getInstance().getLog().error("", interruptedException);
        } catch (IM4JavaException iM4JavaException) {
            Logs.getInstance().getLog().error("", iM4JavaException);
        } catch (IOException e) {
            Logs.getInstance().getLog().error("", e);
        }
    }
}
