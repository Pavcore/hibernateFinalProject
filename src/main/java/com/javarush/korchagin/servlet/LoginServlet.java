package com.javarush.korchagin.servlet;

import com.javarush.korchagin.config.SessionCreator;
import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LoginService loginService = new LoginService(new UserRepository(new SessionCreator()));
        if (loginService.login(login, password)) {
            session.setAttribute("login", login);
            resp.sendRedirect("/home");
        } else {
            String incorrectData = "incorrect login or password";
            session.setAttribute("incorrectData", incorrectData);
            session.setAttribute("jspPath", "/login.jsp");
            session.getServletContext().getRequestDispatcher("/data_error.jsp").forward(req, resp);
        }
    }
}