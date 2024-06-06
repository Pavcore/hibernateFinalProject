package com.javarush.korchagin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.*;
import java.util.Properties;

public class Check {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/wrongAnswer"));
        for (String key : prop.stringPropertyNames()) {
            System.out.println(key + ": " + prop.getProperty(key));
        }

    }
}
