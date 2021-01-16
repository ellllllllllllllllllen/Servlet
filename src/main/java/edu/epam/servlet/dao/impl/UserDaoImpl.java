package edu.epam.servlet.dao.impl;

import edu.epam.servlet.connection.ConnectionPool;
import edu.epam.servlet.dao.Querries;
import edu.epam.servlet.dao.UserDao;
import edu.epam.servlet.entity.Role;
import edu.epam.servlet.entity.User;
import edu.epam.servlet.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.epam.servlet.config.DBConnector.getConnection;
import static edu.epam.servlet.dao.Querries.ADD_USER;
import static edu.epam.servlet.dao.Querries.SELECT_ALL_USERS;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = new UserDaoImpl();

    private UserDaoImpl(){

    }

    public static UserDaoImpl getInstance() {
        return instance;
    }
    @Override
    public List<User> getAllUsers() throws DaoException, SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            System.out.println("\nCount of users in db = " + resultSet.getRow());
            User user = new User();

            user.setLogin(resultSet.getString(1));
            user.setFirstname(resultSet.getString(2));
            user.setLastname(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            users.add(user);
        }
        return users;
    }

//    @Override
//    public void addUser(String login, String password) throws SQLException {
//        Connection connection = getConnection();
//        Statement statement = connection.createStatement();
//
//        int rowsUpdated = statement.executeUpdate(String.format(ADD_USER, login, password));
//    }

    @Override
    public boolean addUser(User user, String password) throws SQLException {

        boolean update;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(ADD_USER);
        statement.setString(1, user.getLogin());
        statement.setString(2, password);
        statement.setString(3, user.getFirstname());
        statement.setString(4, user.getLastname());
        statement.setString(5, user.getEmail());
        update = statement.executeUpdate() > 0;
        return update;

    }


}
