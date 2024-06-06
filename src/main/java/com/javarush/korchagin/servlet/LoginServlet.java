package com.javarush.korchagin.servlet;

import com.javarush.korchagin.entity.User;
import com.javarush.korchagin.service.UserDataService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDataService.getInstance().fillBase();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User authorizeUser = new User();
        authorizeUser.setLogin(login);
        authorizeUser.setPassword(password);
        ServletContext servletContext = req.getSession(true).getServletContext();
        if (UserDataService.getInstance().authorize(authorizeUser)) {
            resp.sendRedirect("/home");
        } else {
            servletContext.getRequestDispatcher("/no_login.jsp").forward(req, resp);
        }
    }
}