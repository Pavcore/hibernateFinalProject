package com.javarush.korchagin.servlet;

import com.javarush.korchagin.service.CharacterService;
import com.javarush.korchagin.service.GameService;
import jakarta.persistence.Enumerated;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        httpSession.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        GameService gameData = GameService.getInstance();
        HttpSession session = req.getSession(true);
        CharacterService characterService = new CharacterService();
        Enumeration<String> stringEnumerated = req.getParameterNames();
        String actionWithCharacter = stringEnumerated.nextElement();
        if (actionWithCharacter.equals("createCharacter") && characterService.haveCharacterCreated(req, session)) {
            gameData.increaseGameAmount();
            resp.sendRedirect("/game");
        } else if (actionWithCharacter.equals("characterName") && characterService.save(req, session)) {
            gameData.increaseGameAmount();
            resp.sendRedirect("/game");
        } else {
            session.getServletContext().getRequestDispatcher("/data_error.jsp").forward(req, resp);
        }
    }
}
