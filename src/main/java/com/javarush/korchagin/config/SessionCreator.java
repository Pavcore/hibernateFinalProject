package com.javarush.korchagin.config;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SessionCreator {
    private final SessionFactory sessionFactory;
    private final ThreadLocal<AtomicInteger> levelBox = new ThreadLocal<>();
    private final ThreadLocal<Session> sessionBox = new ThreadLocal<>();

    @SneakyThrows
    public SessionCreator() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session getSession() {
        return sessionBox.get() == null || !sessionBox.get().isOpen()
                ? sessionFactory.openSession()
                : sessionBox.get();
    }

    public void beginTransactional() {
        if (levelBox.get() == null) {
            levelBox.set(new AtomicInteger(0));
        }
        AtomicInteger level = levelBox.get();
        if (level.getAndIncrement() == 0) {
            Session session = getSession();
            sessionBox.set(session);
            session.beginTransaction();
        }
    }

    public void endTransactional() {
        AtomicInteger level = levelBox.get();
        Session session = sessionBox.get();
        if (level.decrementAndGet() == 0) {
            sessionBox.remove();
            try {
                session.getTransaction().commit();
                session.close();
            } catch (RuntimeException e) {
                session.getTransaction().rollback();
                session.close();
                throw e;
            }
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
