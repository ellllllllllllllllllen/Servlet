package edu.epam.servlet.controller;


import edu.epam.servlet.config.DBConnector;
import edu.epam.servlet.dao.BookDAO;
import edu.epam.servlet.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        request.setAttribute("title", session.getAttribute("title"));

        try {
            request.setAttribute("books", BookDAO.getAllBooks());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher view  = request.getRequestDispatcher("/home.jsp");
        view.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException {


    }

}