package com.javarush.korchagin.config;

import liquibase.Scope;
import liquibase.command.CommandScope;
import liquibase.resource.ClassLoaderResourceAccessor;

public class LiquibaseInit {
    public void start() throws Exception {
        System.out.println("Running Liquibase...");

        Scope.child(Scope.Attr.resourceAccessor, new ClassLoaderResourceAccessor(), () -> {
            CommandScope update = new CommandScope("update");

            update.addArgumentValue("changelogFile", "db/changelog.xml");
            update.addArgumentValue("url", "jdbc:postgresql://localhost:7432/postgres");
            update.addArgumentValue("username", "postgres");
            update.addArgumentValue("password", "postgres");

            update.execute();
        });

        System.out.println("Running Liquibase...DONE");
    }
}
