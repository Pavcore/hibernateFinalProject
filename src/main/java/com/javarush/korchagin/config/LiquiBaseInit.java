package com.javarush.korchagin.config;

import liquibase.Scope;
import liquibase.command.CommandScope;
import liquibase.resource.ClassLoaderResourceAccessor;

//todo переделать мэйн, чтобы его можно было запускать в сервлете

public class LiquiBaseInit {
    public static void main(String[] args) throws Exception {
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
