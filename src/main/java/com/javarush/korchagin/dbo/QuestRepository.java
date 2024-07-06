package com.javarush.korchagin.dbo;

import com.javarush.korchagin.config.SessionCreator;
import com.javarush.korchagin.entity.Quest;
import lombok.AllArgsConstructor;
import org.hibernate.query.criteria.JpaRoot;

import java.util.Collection;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository
@AllArgsConstructor
public class QuestRepository implements Repository<Quest> {

    private SessionCreator sessionCreator;

    @Override
    public void create(Quest quest) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().persist(quest);
        sessionCreator.endTransactional();
    }

    @Override
    public Stream<Quest> find(Quest pattern) {
        sessionCreator.beginTransactional();
        var criteriaBuilder = sessionCreator.getSession().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Quest.class);
        JpaRoot<Quest> from = criteriaQuery.from(Quest.class);
        criteriaQuery.select(from);
        criteriaQuery.where(criteriaBuilder.equal(from.get("main_text"), pattern.getMainText()));
        criteriaQuery.where(criteriaBuilder.equal(from.get("correct_answer"), pattern.getCorrectAnswer()));
        criteriaQuery.where(criteriaBuilder.equal(from.get("wrong_answer"), pattern.getWrongAnswer()));
        criteriaQuery.where(criteriaBuilder.equal(from.get("loose_text"), pattern.getLooseText()));
        Stream<Quest> questStream = sessionCreator.getSession().createQuery(criteriaQuery).list().stream();
        sessionCreator.endTransactional();
        return questStream;
    }

    @Override
    public Quest get(long id) {
        sessionCreator.beginTransactional();
        Quest quest = sessionCreator.getSession().get(Quest.class, id);
        sessionCreator.endTransactional();
        return quest;
    }

    @Override
    public Collection<Quest> getAll() {
        String sql = "select * from quest";
        return sessionCreator.getSession().createNativeQuery(sql, Quest.class).stream().toList();
    }

    @Override
    public void update(Quest quest) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().merge(quest);
        sessionCreator.endTransactional();
    }

    @Override
    public void delete(Quest quest) {
        sessionCreator.beginTransactional();
        sessionCreator.getSession().remove(quest);
        sessionCreator.endTransactional();
    }
}
