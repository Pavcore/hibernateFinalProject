package com.javarush.korchagin.service;

import com.javarush.korchagin.config.SessionCreator;
import com.javarush.korchagin.entity.Quest;
import jakarta.servlet.http.HttpSession;

public class QuestService {

    private final SessionCreator sessionCreator = new SessionCreator();

    public Quest get(long id) {
        sessionCreator.beginTransactional();
        Quest quest = sessionCreator.getSession().get(Quest.class, id);
        sessionCreator.endTransactional();
        return quest;
    }
    public HttpSession setAttributeQuest(HttpSession session, int level) {
        Quest quest = get(level);
        session.setAttribute("stage", quest.getMainText());
        session.setAttribute("firstAnswer", quest.getCorrectAnswer());
        session.setAttribute("secondAnswer", quest.getWrongAnswer());
        session.setAttribute("loseAttribute", quest.getLooseText());
        return session;
    }
}
