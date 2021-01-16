package edu.epam.servlet.controller;

import edu.epam.servlet.entity.User;
import edu.epam.servlet.exception.DaoException;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view  = request.getRequestDispatcher("/registration.jsp");
        view.forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        User user = new User(login, firstname, lastname, email);
        try {
            if (UserService.isLoginUnique(login)) {
                if (UserService.checkConfirmationPassword(password, confirmPassword)) {
                    UserService.addUser(user, password);
                    response.sendRedirect("/index");
                } else {
                    response.sendRedirect("/registration");
                }

            } else {
                response.sendRedirect("/registration");
            }
        }catch (SQLException | DaoException throwables){
            throwables.printStackTrace();
        }



//        try {
//            if(UserService.isLoginUnique(login)) {
//                if (UserService.checkConfirmationPassword(password, confirmPassword)) {
//                    UserService.addUser(login, password);
//                    response.sendRedirect("/index");
//                } else {
//                    response.sendRedirect("/registration");
//                }
//            }else {
//                request.getSession().setAttribute("LoginIsNotUnique", false);
//                response.sendRedirect("/registration");
//            }
//        } catch (SQLException | DaoException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
