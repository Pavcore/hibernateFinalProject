package com.javarush.korchagin.servlet;

import com.javarush.korchagin.config.LiquibaseInit;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.SneakyThrows;

@WebListener
public class LiquibaseListener implements ServletContextListener {
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LiquibaseInit liquibaseInit = new LiquibaseInit();
        liquibaseInit.start();
    }
}
