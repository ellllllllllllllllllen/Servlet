package edu.epam.servlet.controller;

import edu.epam.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException {

        String inputLogin = request.getParameter("login");
        String inputRole = request.getParameter("role");
        String inputPassword = request.getParameter("password");

        try {
            if (UserService.checkLoginAndPasswordEqual(inputLogin, inputPassword)){
                request.getSession().setAttribute("login", inputLogin);
                request.getSession().setAttribute("role", UserService.findRole(inputLogin, inputPassword));
                request.getSession().setAttribute("isAuthorized", true);
                resp.sendRedirect("/home");
            }else {
                resp.sendRedirect("/index");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
