/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardas.actualgreetings.factory;

import com.ardas.actualgreetings.config.AppConfig;
import java.time.LocalTime;
import java.util.Locale;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author sf
 */
public class GreetingFactoryTest extends TestCase {
    
    public GreetingFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageNight() {
        System.out.println("testGenerateActualMessageNight");
        ApplicationContext context 
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context, Locale.US);
        instance.setLocalTime(LocalTime.parse("00:00"));
        String expResult = "Good night, World!";
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("06:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageMorning() {
        System.out.println("testGenerateActualMessageMorning");
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context, Locale.US);
        String expResult = "Good morning, World!";
        instance.setLocalTime(LocalTime.parse("08:20"));
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("09:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageDay() {
        System.out.println("testGenerateActualMessageDay");
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context, Locale.US);
        String expResult = "Good day, World!";
        instance.setLocalTime(LocalTime.parse("09:22"));
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("19:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }
    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageEvening() {
        System.out.println("testGenerateActualMessageEvening");
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context, Locale.US);
        String expResult = "Good evening, World!";
        instance.setLocalTime(LocalTime.parse("20:32"));
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("23:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageNightRu() {
        System.out.println("testGenerateActualMessageNightRu");
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context, 
                new Locale("ru", "RU"));
        instance.setLocalTime(LocalTime.parse("00:00"));
        String expResult = "Доброй ночи, мир!";
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("06:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageMorningRu() {
        System.out.println("testGenerateActualMessageMorningRu");
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context,
                new Locale("ru", "RU"));
        instance.setLocalTime(LocalTime.parse("08:00"));
        String expResult = "Доброе утро, мир!";
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("09:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageDayRu() {
        System.out.println("testGenerateActualMessageDayRu");
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context,
                new Locale("ru", "RU"));
        instance.setLocalTime(LocalTime.parse("10:05"));
        String expResult = "Добрый день, мир!";
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("19:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of generateActualMessage method, of class GreetingFactory.
     */
    public void testGenerateActualMessageEveningRu() {
        System.out.println("testGenerateActualMessageEveningRu");
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingFactory instance = new GreetingFactory(context,
                new Locale("ru", "RU"));
        instance.setLocalTime(LocalTime.parse("19:05"));
        String expResult = "Добрый вечер, мир!";
        String result = instance.generateActualMessage();
        assertEquals(expResult, result);
        instance.setLocalTime(LocalTime.parse("23:00"));
        result = instance.generateActualMessage();
        assertEquals(expResult, result);
    }
}
