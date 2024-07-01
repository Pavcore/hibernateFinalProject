package com.javarush.korchagin.dbo;

import com.javarush.korchagin.config.SessionCreator;
import com.javarush.korchagin.entity.User;
import lombok.AllArgsConstructor;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class UserRepository implements Repository<User> {
    private SessionCreator sessionCreator;

    @Override
    public void create(User user) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().persist(user);
        sessionCreator.endTransactional();
    }

    @Override
    public Stream<User> find(User pattern) {
        sessionCreator.beginTransactional();
        var criteriaBuilder = sessionCreator.getSession().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(User.class);
        JpaRoot<User> from = criteriaQuery.from(User.class);
        criteriaQuery.select(from);
        criteriaQuery.where(criteriaBuilder.equal(from.get("login"), pattern.getLogin()));
        Stream<User> userStream = sessionCreator.getSession().createQuery(criteriaQuery).list().stream();
        sessionCreator.endTransactional();
        return userStream;
    }

    @Override
    public User get(long id) {
        sessionCreator.beginTransactional();
        User getUser = sessionCreator.getSession().find(User.class, id);
        sessionCreator.endTransactional();
        return getUser;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from users";
        return sessionCreator.getSession().createNativeQuery(sql, User.class).stream().toList();
    }

    @Override
    public void update(User user) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().merge(user);
        sessionCreator.endTransactional();
    }

    @Override
    public void delete(User user) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().remove(user);
        sessionCreator.endTransactional();
    }
}