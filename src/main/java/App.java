import com.jala.solidwater.view.console.InputParameter;
import com.jala.solidwater.view.console.ViewConsole;

public class App {

    /**
     * Main
     *This is the method main in order to execute the SolidWater app
     * @param args
     */
    public static void main(String[] args) {

        InputParameter validator = new InputParameter();
        validator.validateCommands(args);
        ViewConsole viewConsole = new ViewConsole();
        viewConsole.testShow();
    }
}
