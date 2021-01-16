package edu.epam.servlet.dao;

import edu.epam.servlet.entity.User;
import edu.epam.servlet.exception.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAllUsers() throws DaoException, SQLException;

    boolean addUser(User user, String password) throws DaoException, SQLException;

}
