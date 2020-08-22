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

public class AuthorList {
    private final List<Author> authors;

    public AuthorList() {
        authors = new ArrayList<>();
    }

    public List<Author> getAuthors() {
        if (authors.isEmpty()) {
            return getAuthorsFromDB();
        }
        return authors;
    }

    private List<Author> getAuthorsFromDB() {
        try (
//                Connection connection = Database.getConnection();
                Statement statement = (Database.getConnection()).createStatement();
                ResultSet resultSet = statement.executeQuery("select * from author order by full_name")
        ) {

            while (resultSet.next()) {
                final Author author = new Author();
                author.setName(resultSet.getString("full_name"));
                authors.add(author);
            }
        } catch (SQLException throwables) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "DB Exception!", throwables);
        }

        return authors;
    }


}
