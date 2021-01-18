package edu.epam.servlet.dao;

public class Queries {

    public static final String SELECT_ALL_USERS = "SELECT * FROM users;";

    public static final String ADD_USER = "INSERT INTO users (`login`, `pass`, `firstname`, `lastname`, `email`, `user_role`) " +
            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');";

    public static final String SET_ADMIN_ROLE = "UPDATE users SET user_role = 'ADMIN' where `login` = '%s';";

    public static final String SELECT_ALL_BOOKS = "SELECT * FROM books;";

    public static final String ADD_BOOK = "INSERT INTO books (`title`, `author_firstname`, `author_lastname`) VALUES ('%s', '%s', '%s');";

    public static final String DELETE_BOOK = "DELETE FROM books (`title`, `author_firstname`, `author_lastname`) VALUES ('%s', '%s', '%s');";
}
