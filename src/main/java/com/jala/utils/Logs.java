package com.jala.utils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Logs
 * This is the Class created to have a unique object log
 * in order to centralize our logs
 */
public class Logs {
    private static Logs instance = null;
    protected final static Logger log = Logger.getLogger(Logs.class);

    /**
     * Logs
     * Is the private constructor of our Singleton class
     */
    private Logs(){
        super();
    }

    /**
     * getInstance
     * In this method, a instance is created at the beginning and
     * if it just was created, returns just the object created
     * It has a log4j.properties to config the syntax's logs. That
     * file is in the folder resources
     * @return Logger
     */
    public static Logs getInstance(){
        if (instance == null) {
            instance = new Logs();
            PropertyConfigurator.configure("../ToolSearch/src/main/java/com/jala/resources/log4j.properties");
            log.setLevel(Level.ALL);
        }
        return instance;
    }


}
