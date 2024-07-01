package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.QuestRepository;
import com.javarush.korchagin.entity.Quest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuestService {

    private QuestRepository questRepository;

    public void setAttributeQuest(HttpSession session, int level) {
        Quest quest = questRepository.get(level);
        session.setAttribute("stage", quest.getMainText());
        session.setAttribute("firstAnswer", quest.getCorrectAnswer());
        session.setAttribute("secondAnswer", quest.getWrongAnswer());
        session.setAttribute("loseAttribute", quest.getLooseText());
    }
}
