package com.javarush.korchagin.servlet;

import com.javarush.korchagin.service.QuestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private int level = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestService questService = new QuestService();
        HttpSession session = req.getSession(true);
        String nextStage = req.getParameter("nextStage");
        if (nextStage != null && nextStage.equals("lose")) {
            level = 1;
            session.getServletContext().getRequestDispatcher("/gameOver.jsp").forward(req, resp);
        } else if (level == 7) {
            level = 1;
            session.getServletContext().getRequestDispatcher("/gameWin.jsp").forward(req, resp);
        }
        questService.setAttributeQuest(session, level);
        resp.sendRedirect("/game.jsp");
        level++;
    }
}