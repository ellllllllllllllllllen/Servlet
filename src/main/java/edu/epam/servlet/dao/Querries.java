package edu.epam.servlet.dao;

public class Querries {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user_info;";

    public static final String ADD_USER = "INSERT INTO user_info (`login`, `pass`, `firstname`, `lastname`, `email`, `rol`) VALUES ('%s', '%s', '%s', '%s', '%s', 'USER');";


    public static final String SELECT_ALL_BOOKS = "SELECT * FROM books;";

    public static final String ADD_BOOK = "INSERT INTO books (`title`, `author_firstname`, `author_lastname`) VALUES ('%s', '%s', '%s');";

    public static final String DELETE_BOOK = "DELETE FROM books (`title`, `author_firstname`, `author_lastname`) VALUES ('%s', '%s', '%s');";
}
