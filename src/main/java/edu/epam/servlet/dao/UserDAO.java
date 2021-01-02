package edu.epam.servlet.dao;

import edu.epam.servlet.model.Role;
import edu.epam.servlet.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static edu.epam.servlet.config.DBConnector.getConnection;
import static edu.epam.servlet.dao.Querries.SELECT_ALL_USERS;
import static edu.epam.servlet.dao.Querries.ADD_USER    ;

public class UserDAO {
    public static List<User> getAllUsers() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            System.out.println("\nresultSet.getRow() = " + resultSet.getRow());
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
        ResultSet resultSet = statement.executeQuery(ADD_USER);
    }
}
