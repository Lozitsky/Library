package com.kirilo.jsp.beans;

import com.kirilo.jsp.db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookList {
    private List<Book> books;

    public BookList() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        if (books.isEmpty()) {
            books = getBooksDromDB();
        }
        return books;
    }

    private List<Book> getBooksDromDB() {
        try (
                Connection connection = Database.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery("select * from book")) {
            while (resultSet.next()) {
                final Book book = new Book();
                book.setName(resultSet.getString("name"));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setGenre(resultSet.getString("genre_id"));
                book.setGenre(resultSet.getString("author_id"));
                book.setPublishYear(resultSet.getInt("publish_year"));
                book.setPublisher(resultSet.getString("publisher_id"));
            }
        } catch (SQLException throwables) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't get books from DB!", throwables);
        }
        return books;
    }
}
