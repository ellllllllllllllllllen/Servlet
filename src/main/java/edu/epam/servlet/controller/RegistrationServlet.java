package edu.epam.servlet.controller;

import edu.epam.servlet.dao.UserDAO;
import edu.epam.servlet.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view  = request.getRequestDispatcher("/registration.jsp");
        view.forward(request,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        String inputLogin = request.getParameter("login");
        String inputPassword = request.getParameter("password");
        String inputConfirmPassword = request.getParameter("confirm_password");
        request.setAttribute("LoginIsNotUnique", request.getSession().getAttribute("LoginIsNotUnique"));
        try {
            if(UserService.isLoginUnique(inputLogin)) {
                if (UserService.checkEqualsPassword(inputPassword, inputConfirmPassword)) {
                    UserDAO.addUser(inputLogin, inputPassword);
                    resp.sendRedirect("/index");
                } else {
                    resp.sendRedirect("/registration");
                }
            }else {
                request.getSession().setAttribute("LoginIsNotUnique", false);
                resp.sendRedirect("/registration");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
