package edu.epam.servlet.controller;

import edu.epam.servlet.exception.DaoException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
        view.forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            if (UserService.isUserExists(login, password)){
                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("role", UserService.findRole(login, password));
                request.getSession().setAttribute("isAuthorized", true);
                response.sendRedirect("/home");
            }else {
                response.sendRedirect("/index");

            }
        } catch (SQLException | DaoException throwables) {
            throwables.printStackTrace();
        }


    }
}
