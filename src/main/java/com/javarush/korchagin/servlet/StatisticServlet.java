package com.javarush.korchagin.servlet;

import com.javarush.korchagin.service.GameService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/statistic")
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        GameService gameService = GameService.getInstance();
        session.setAttribute("gameQuantity", gameService.gameQuantity());
        session.setAttribute("characterList", gameService.getAllUserCharacters(session));
        resp.sendRedirect("/statistic.jsp");
    }
}
