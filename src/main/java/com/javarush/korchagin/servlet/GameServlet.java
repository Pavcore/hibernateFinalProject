package com.javarush.korchagin.servlet;

import com.javarush.korchagin.quest.DiabloQuest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private int level = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        DiabloQuest diabloQuest = new DiabloQuest();
        String loseAttribute = "loseAttribute";
        String nextStage = req.getParameter("nextStage");
        if (nextStage != null && nextStage.equals("DiabloQuest/lose")) {
            session.setAttribute(loseAttribute, diabloQuest.getLoseQuest().get(level - 1));
            level = 0;
            session.getServletContext().getRequestDispatcher("/gameOver.jsp").forward(req, resp);
        } else if (level == diabloQuest.getIntroductionQuest().size()) {
            level = 0;
            session.getServletContext().getRequestDispatcher("/gameWin.jsp").forward(req, resp);
        }
        String stage = "stage";
        String firstAnswer = "firstAnswer";
        String secondAnswer = "secondAnswer";
        session.setAttribute(stage, diabloQuest.getIntroductionQuest().get(level));
        session.setAttribute(firstAnswer, diabloQuest.getPositiveAnswer().get(level));
        session.setAttribute(secondAnswer, diabloQuest.getNegativeAnswer().get(level));
        resp.sendRedirect("/game.jsp");
        level++;
    }
}