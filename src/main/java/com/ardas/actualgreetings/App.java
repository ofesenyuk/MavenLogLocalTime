package com.ardas.actualgreetings;

import com.ardas.actualgreetings.config.AppConfig;
import com.ardas.actualgreetings.factory.GreetingFactory;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());    
    public static Handler fileHandler = null;
    
    static {
        LOGGER.setUseParentHandlers(false);
        try {
            fileHandler  = new FileHandler("./logs/myapp.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Configuration done.");
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void main( String[] args ) {
        
        ApplicationContext context 
                = new AnnotationConfigApplicationContext(AppConfig.class);
//        ApplicationContext context 
//                = new ClassPathXmlApplicationContext("locale.xml"); 
        LOGGER.log(Level.INFO, "main: context is set to {0}", context);
        GreetingFactory greetingFactory = new GreetingFactory(context, 
                Locale.US);
        String actualMessage = greetingFactory.generateActualMessage();
        LOGGER.log(Level.INFO, "main: message is {0}", actualMessage);
        System.out.println(actualMessage);
    }
}
