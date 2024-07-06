package com.javarush.korchagin.config;

import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Data
public class SpringApplicationContext {
    private static ApplicationContext applicationContext;

    private SpringApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new AnnotationConfigApplicationContext("com.javarush.korchagin");
            return applicationContext;
        } else return applicationContext;
    }
}
