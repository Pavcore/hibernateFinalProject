package com.javarush.korchagin.dbo;

import com.javarush.korchagin.config.SessionCreator;
import com.javarush.korchagin.entity.Character;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;
import java.util.stream.Stream;

//todo добавить метод для выборки персонажей определенного пользователя

public class CharacterRepository implements Repository<Character> {

    private final SessionCreator sessionCreator = new SessionCreator();

    @Override
    public void create(Character character) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().persist(character);
        sessionCreator.endTransactional();
    }

    @Override
    public Stream<Character> find(Character pattern) {
        sessionCreator.beginTransactional();
        var criteriaBuilder = sessionCreator.getSession().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Character.class);
        JpaRoot<Character> from = criteriaQuery.from(Character.class);
        criteriaQuery.select(from);
        criteriaQuery.where(criteriaBuilder.equal(from.get("name"), pattern.getName()));
        Stream<Character> characterStream = sessionCreator.getSession().createQuery(criteriaQuery).list().stream();
        sessionCreator.endTransactional();
        return characterStream;
    }

    @Override
    public Character get(long id) {
        sessionCreator.beginTransactional();
        Character getCharacter = sessionCreator.getSession().find(Character.class, id);
        sessionCreator.endTransactional();
        return getCharacter;
    }

    @Override
    public List<Character> getAll() {
        String sql = "select * from character";
        sessionCreator.beginTransactional();
        List<Character> getAllCharacter = sessionCreator.getSession().createNativeQuery(sql, Character.class).stream().toList();
        sessionCreator.endTransactional();
        return getAllCharacter;
    }

    @Override
    public void update(Character user) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().merge(user);
        sessionCreator.endTransactional();
    }

    @Override
    public void delete(Character user) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().remove(user);
        sessionCreator.endTransactional();
    }
}
