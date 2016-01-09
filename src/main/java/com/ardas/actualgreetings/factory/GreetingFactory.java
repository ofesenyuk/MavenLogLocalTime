/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardas.actualgreetings.factory;

import com.ardas.actualgreetings.App;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author sf
 */
public class GreetingFactory {
    
    private static final Logger LOGGER 
            = Logger.getLogger(GreetingFactory.class.getName());
    private final static SortedMap<LocalTime, String> moments = new TreeMap<>();
    private final ApplicationContext context;
    private final Locale locale;
    private LocalTime localTime = LocalTime.now();    
    
    static {
        moments.put(LocalTime.parse("06:00:00"), "good.morning");
        moments.put(LocalTime.parse("09:00"), "good.day");
        moments.put(LocalTime.parse("19:00"), "good.evening");
        moments.put(LocalTime.parse("23:00"), "good.night");
        
        Handler fileHandler = App.fileHandler;
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(fileHandler);
    }

    public GreetingFactory(ApplicationContext context, Locale locale) {
        this.context = context;
        this.locale = locale;
        LOGGER.log(Level.INFO, "GreetingFactory: context is {0}, locale is {1}",
                new Object[]{context, locale});
    }

    public String generateActualMessage() {
        SortedMap<LocalTime, String> headMap = moments.headMap(localTime);
        LocalTime messageKey = headMap.isEmpty() ? moments.lastKey() 
                                                 : headMap.lastKey();
        String message = moments.get(messageKey);
        LOGGER.log(Level.INFO, "GreetingFactory: local time is {0}, "
                + "message is {1}", new Object[]{localTime, message});
        return context.getMessage(message, null, locale);
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
    
}
