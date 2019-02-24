package modifyimageformat;
import java.io.IOException;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

/**
 * The ModifyImageFormat class is used to change the format of an image.
 * @version 0.0.1
 * @author: Luis Guardia
 */
public class ModifyImageFormat {
    
     /**
     * Stores the installation address of the ImageMagick program
     */
    private String imPath = "c:\\ImageMagick\\";
    
    public ModifyImageFormat(){
    }
    /**
     * Metodo que realiza el cambio de formato de una imagen
     * @param pathOrigin The pathOrigin parameter indicates the absolute path of the image you want to change the format.
     * @param pathDestiny The pathDestiny parameter indicates the absolute path where the new image will be saved with the new format. 
     */
    public void changeFormatImage(String pathOrigin , String pathDestiny) throws IM4JavaException, IOException{
        ConvertCmd cmdConvert = new ConvertCmd();
        cmdConvert.setSearchPath(imPath);
        IMOperation operatorConvert = new IMOperation();
        operatorConvert.addImage(pathOrigin);
        operatorConvert.addImage(pathDestiny);
        try {
            cmdConvert.run(operatorConvert);
            
        } catch (IM4JavaException | InterruptedException e) {
        }
    }
}
