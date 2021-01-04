package edu.epam.servlet.dao;

import edu.epam.servlet.model.Role;
import edu.epam.servlet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.epam.servlet.config.DBConnector.getConnection;
import static edu.epam.servlet.dao.Querries.ADD_USER;
import static edu.epam.servlet.dao.Querries.SELECT_ALL_USERS;

public class UserDAO {

    public static List<User> getAllUsers() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            System.out.println("\nCount of users in db = " + resultSet.getRow());
            User user = new User();

            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setRole(Role.valueOf(resultSet.getString(4)));
            users.add(user);
        }
        return users;
    }
    public static void addUser(String login, String password) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        int rowsUpdated = statement.executeUpdate(String.format(ADD_USER, login, password));
    }
}
