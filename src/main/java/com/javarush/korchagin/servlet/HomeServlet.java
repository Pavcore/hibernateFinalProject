package com.javarush.korchagin.servlet;

import com.javarush.korchagin.entity.Character;
import com.javarush.korchagin.entity.CharacterClass;
import com.javarush.korchagin.service.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//todo добавить заполнение liquiBase сюда

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        httpSession.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String classOfCharacter = req.getParameter("characterClass");
        String nameOfCharacter = req.getParameter("characterName");
        Character character = Character.builder()
                .name(nameOfCharacter)
                .characterClass(CharacterClass.getClass(classOfCharacter))
                .build();
        GameService gameData = GameService.getInstance();
        gameData.increaseGameAmount();
        resp.sendRedirect("/game");
    }
}
