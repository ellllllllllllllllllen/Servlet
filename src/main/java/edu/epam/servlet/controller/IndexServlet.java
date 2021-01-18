package edu.epam.servlet.controller;

import edu.epam.servlet.exception.DaoException;
import edu.epam.servlet.service.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class IndexServlet extends HttpServlet {
    private static final Logger Logger = LogManager.getLogger();

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
            if (UserService.isUserExists(login)){
                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("role", UserService.findRole(login));
                request.getSession().setAttribute("isAuthorized", true);
                Logger.error("User exists");
                response.sendRedirect("/home");
            }else {
                Logger.error("User doesn't exist");
                response.sendRedirect("/index");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }


    }
}
