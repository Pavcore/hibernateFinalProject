package com.javarush.korchagin.dbo;

import com.javarush.korchagin.config.SessionCreator;
import com.javarush.korchagin.entity.Character;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class CharacterRepository implements Repository<Character> {

    private SessionCreator sessionCreator;

    @Override
    public void create(Character character) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().persist(character);
        sessionCreator.endTransactional();
    }

    @Override
    public Stream<Character> find(Character pattern) {
        Session session = sessionCreator.getSession();
        var criteriaBuilder = sessionCreator.getSession().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Character.class);
        JpaRoot<Character> from = criteriaQuery.from(Character.class);
        criteriaQuery.select(from);
        criteriaQuery.where(criteriaBuilder.equal(from.get("name"), pattern.getName()));
        return session.createQuery(criteriaQuery).list().stream();
    }

    @Override
    public Character get(long id) {
        return sessionCreator.getSession().find(Character.class, id);
    }

    @Override
    public List<Character> getAll() {
        String sql = "select * from character";
        return sessionCreator.getSession().createNativeQuery(sql, Character.class).stream().toList();
    }

    public List<Character> getAllCurrentUserCharacters(Long id){
        String sql = "select * from character where user_id = :id";
        NativeQuery<Character> query = sessionCreator.getSession().createNativeQuery(sql, Character.class);
        query.setParameter("id", id);
        return query.stream().toList();
    }

    @Override
    public void update(Character character) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().merge(character);
        sessionCreator.endTransactional();
    }

    @Override
    public void delete(Character character) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().remove(character);
        sessionCreator.endTransactional();
    }
}
