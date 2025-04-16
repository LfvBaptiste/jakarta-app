package fr.formation.jakarta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bonjour")
public class BonjourServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspName;

        if(req.getParameter("name") != null && ! req.getParameter("name").isEmpty()) {
            jspName = "bonjour.jsp";
        } else {
            jspName = "bonjour-form.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspName);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bonjour-form.jsp");
        dispatcher.forward(req, resp);
    }
}
