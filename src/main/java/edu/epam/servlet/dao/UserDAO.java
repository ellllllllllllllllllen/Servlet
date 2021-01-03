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

        int rowsUpdated = statement.executeUpdate(String.format(ADD_USER, login, password));
//        ResultSet resultSet = statement.executeQuery("INSERT INTO user_info (`login`, `pass`, `rol`) VALUES " +
//                "('" + login + "', '" + password + "', 'USER');");
    }

//    public static int registerUser(User user) throws ClassNotFoundException {
//        String INSERT_USERS_SQL = "INSERT INTO user_info" +
//                "  (id, login, password, rol) VALUES " +
//                " (?, ?, ?, ?);";
//
//        int result = 0;
//
//        Class.forName("com.mysql.jdbc.Driver");
//
//        try (Connection connection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//             preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, user.getLogin());
//            preparedStatement.setString(3, user.getPassword());
//            preparedStatement.setString(4, "USER");
//
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            result = preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
//        return result;
//    }
//    private static void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
}
