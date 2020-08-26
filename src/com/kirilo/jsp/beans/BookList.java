package com.kirilo.jsp.beans;

import com.kirilo.jsp.db.Database;
import com.kirilo.jsp.enums.SearchType;

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

    public List<Book> getAllBooks() {
        if (books.isEmpty()) {
            books = getBooksFromDB("select * from book");
        }
        return books;
    }

    private List<Book> getBooksFromDB(String query) {
        try (
//                Connection connection = Database.getConnection();
                Statement statement = (Database.getConnection()).createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                final Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setGenre(resultSet.getString("genre"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishYear(resultSet.getInt("publish_year"));
                book.setPublisher(resultSet.getString("publisher"));
                books.add(book);
            }
        } catch (SQLException throwables) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't get books from DB!", throwables);
        }
        return books;
    }

    public List<Book> getBooksByGenre(int id) {
        return getBooksFromDB(
                "select b.id, b.name, b.page_count, b.isbn, b.publish_year, "
                        + "g.name as genre, a.full_name as author, p.name as publisher from book b "
                        + "inner join genre g on b.genre_id=g.id "
                        + "inner join author a on b.author_id=a.id "
                        + "inner join publisher p on b.publisher_id=p.id "
                        + "where genre_id=" + id
                        + " order by b.name"
        );
    }

    public List<Book> getBooksByLetter(char c) {
        return getBooksFromDB(
                "select b.id, b.name, b.page_count, b.isbn, b.publish_year, "
                        + "g.name as genre, a.full_name as author, p.name as publisher from book b "
                        + "inner join genre g on b.genre_id=g.id "
                        + "inner join author a on b.author_id=a.id "
                        + "inner join publisher p on b.publisher_id=p.id "
                        + "where b.name like '" + String.valueOf(c).toLowerCase() + "%'"
                        + " order by b.name"
        );
    }

    public List<Book> getBooksByString(String s, SearchType type) {
        return getBooksFromDB(
                "select b.id, b.name, b.page_count, b.isbn, b.publish_year, "
                        + "g.name as genre, a.full_name as author, p.name as publisher from book b "
                        + "inner join genre g on b.genre_id=g.id "
                        + "inner join author a on b.author_id=a.id "
                        + "inner join publisher p on b.publisher_id=p.id "
                        + "where "+ (type==SearchType.AUTHOR?"author":"b.name") +" like '%" + s + "%'"
                        + " order by b.name"
        );
    }
}
