package edu.epam.servlet.dao;

import edu.epam.servlet.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static edu.epam.servlet.config.DBConnector.getConnection;
import static edu.epam.servlet.dao.Querries.ADD_BOOK;
import static edu.epam.servlet.dao.Querries.DELETE_BOOK;
import static edu.epam.servlet.dao.Querries.SELECT_ALL_BOOKS;

public class BookDAO {
    public static List<Book> getAllBooks() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_BOOKS);
        List<Book> books = new ArrayList<>();
        while (resultSet.next()){
            System.out.println("\nCount of books in db = " + resultSet.getRow());

            Book book = new Book();
            book.setId(resultSet.getInt(1));
            book.setTitle(resultSet.getString(2));
            book.setAuthorFirstName(resultSet.getString(3));
            book.setAuthorLastName(resultSet.getString(4));
            books.add(book);
        }
        return books;
    }

    public static void addBook(String title, String authorFirstName, String authorLastName) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        int rowsUpdated = statement.executeUpdate(String.format(ADD_BOOK, title, authorFirstName, authorLastName));
    }

    public static void deleteBook(String title, String authorFirstName, String authorLastName) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        int rowsUpdated = statement.executeUpdate(String.format(DELETE_BOOK, title, authorFirstName, authorLastName));
    }
}
