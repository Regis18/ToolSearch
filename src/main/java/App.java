import com.jala.solidwater.view.console.InputParam;

public class App {

    /**
     * Main
     *This is the method main in order to execute the SolidWater app
     * @param args
     */
    public static void main(String[] args) {
        String[] commands = {"-p", "c://java/test", "-ex", ".mp3", "h", "hide files", "-test", "{name: 'Jose'}"};
        InputParam inputParam = new InputParam(commands);

    }
}
