package edu.epam.servlet.service;

import edu.epam.servlet.dao.UserDAO;
import edu.epam.servlet.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public static boolean checkIfLoginAndPasswordEqual(String inputLogin, String inputPassword) throws SQLException {
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
}