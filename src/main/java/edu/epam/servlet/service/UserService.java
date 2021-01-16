package edu.epam.servlet.service;

import edu.epam.servlet.dao.impl.UserDaoImpl;
import edu.epam.servlet.entity.User;
import edu.epam.servlet.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public class UserService {
//    public static boolean isUserExists(String login, String password) throws SQLException, DaoException {
//        UserDaoImpl userDao = new UserDaoImpl();
//        List<User> users = userDao.getAllUsers();
//        boolean isExist = false;
//        for (User user : users){
//            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
//                isExist = true;
//            }
//        }
//        return isExist;
//    }
    public static boolean checkConfirmationPassword(String password, String confirmPassword){
        boolean result = false;
        if(password.equals(confirmPassword)){
            result = true;
        }
        return result;
    }
//    public static String findRole(String login, String password) throws SQLException, DaoException {
//        UserDaoImpl userDao = new UserDaoImpl();
//        List<User> users = userDao.getAllUsers();
//        String role = null;
//        for (User user: users){
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
//                role = user.getRole().name();
//            }
//        }
//        return role;
//    }
    public static boolean isLoginUnique(String login) throws SQLException, DaoException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        List<User> users = userDao.getAllUsers();
        boolean isUnique = true;
        for (User user: users){
            if (user.getLogin().equals(login)){
                isUnique = false;
            }
        }
        return isUnique;
    }

    public static void addUser(User user, String password) throws SQLException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        userDao.addUser(user, password);
    }

}