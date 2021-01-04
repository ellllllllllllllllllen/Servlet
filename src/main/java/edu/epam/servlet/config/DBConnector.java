package edu.epam.servlet.config;

import java.sql.*;

public class DBConnector {
    public static final String URL = "jdbc:mysql://localhost:3306/javaee";
    public static final String USER = "root";
    public static final String PASSWORD = "4521";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

//    public static ArrayList<Book> select() {
//
//        ArrayList<Book> books = new ArrayList<Book>();
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
//
//                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
//                while(resultSet.next()){
//
//                    int id = resultSet.getInt(1);
//                    String title = resultSet.getString(2);
//                    String authorFirstName = resultSet.getString(3);
//                    String authorLastName = resultSet.getString(4);
//                    Book book = new Book(id, title, authorFirstName, authorLastName);
//                    books.add(book);
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//        return books;
//    }
//    public static Book selectOne(int id) {
//
//        Book book = null;
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
//
//                String sql = "SELECT * FROM books WHERE id=?";
//                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//                    preparedStatement.setInt(1, id);
//                    ResultSet resultSet = preparedStatement.executeQuery();
//                    if(resultSet.next()){
//
//                        int bookId = resultSet.getInt(1);
//                        String title = resultSet.getString(2);
//                        String authorFirstName = resultSet.getString(3);
//                        String authorLastName = resultSet.getString(4);
//                        book = new Book(bookId, title, authorFirstName, authorLastName);
//                    }
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//        return book;
//    }
//    public static int insert(Book book) {
//
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
//
//                String sql = "INSERT INTO books (title, author_firstname, author_lastname) Values (?, ?, ?)";
//                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//                    preparedStatement.setString(1, book.getTitle());
//                    preparedStatement.setString(2, book.getAuthorFirstName());
//                    preparedStatement.setString(3, book.getAuthorLastName());
//
//                    return  preparedStatement.executeUpdate();
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//        return 0;
//    }
//
//    public static int update(Book book) {
//
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
//
//                String sql = "UPDATE books SET title = ?, author_firstname = ?, author_lastname = ? WHERE id = ?";
//                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//                    preparedStatement.setString(1, book.getTitle());
//                    preparedStatement.setString(2, book.getAuthorFirstName());
//                    preparedStatement.setString(3, book.getAuthorLastName());
//
//                    return  preparedStatement.executeUpdate();
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//        return 0;
//    }
//    public static int delete(int id) {
//
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
//
//                String sql = "DELETE FROM books WHERE id = ?";
//                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//                    preparedStatement.setInt(1, id);
//
//                    return  preparedStatement.executeUpdate();
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//        return 0;
//    }
}
