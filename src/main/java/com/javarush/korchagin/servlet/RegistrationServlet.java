package com.javarush.korchagin.servlet;

import com.javarush.korchagin.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LoginService loginService = new LoginService();
        if (loginService.register(login, password)) {
            resp.sendRedirect("/");
        } else {
            String incorrectData = "this login is busy";
            session.setAttribute("incorrectData", incorrectData);
            session.setAttribute("jspPath", "/registration.jsp");
            session.getServletContext().getRequestDispatcher("/data_error.jsp").forward(req, resp);
        }
    }
}
