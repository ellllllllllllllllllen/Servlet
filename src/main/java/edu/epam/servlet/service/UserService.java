package edu.epam.servlet.service;

import edu.epam.servlet.dao.UserDAO;
import edu.epam.servlet.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public static boolean checkLoginAndPasswordEqual(String inputLogin, String inputPassword) throws SQLException {
        List<User> users = UserDAO.getAllUsers();
        boolean res = false;
        for (User user : users){
            if(user.getLogin().equals(inputLogin) && user.getPassword().equals(inputPassword)){
                res = true;
            }
        }
        return res;
    }
    public static boolean checkEqualsPassword(String inputPassword, String inputConfirmPassword){
        boolean result = false;
        if(inputPassword.equals(inputConfirmPassword)){
            result = true;
        }
        return result;
    }
    public static String findRole(String inputLogin, String inputPassword) throws SQLException {
        List<User> users = UserDAO.getAllUsers();
        String role = null;
        for (User user: users){
            if (user.getLogin().equals(inputLogin) && user.getPassword().equals(inputPassword)){
                role = user.getRole().name();
            }
        }
        return role;
    }
    public static boolean isLoginUnique(String inputLogin) throws SQLException {
        List<User> users = UserDAO.getAllUsers();
        boolean isUnique = true;
        for (User user: users){
            if (user.getLogin().equals(inputLogin)){
                isUnique = false;
            }
        }
        return isUnique;

    }
}