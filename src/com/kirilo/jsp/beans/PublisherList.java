package com.kirilo.jsp.beans;

import com.kirilo.jsp.db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublisherList {
    private List<Publisher> publishers;

    public PublisherList() {
        publishers = new ArrayList<>();
    }

    public List<Publisher> getPublishers() {
        if (publishers.isEmpty()) {
            return getPublishersFromDB();
        }
        return publishers;
    }

    private List<Publisher> getPublishersFromDB() {
        try (
                final Statement statement = (Database.getConnection()).createStatement();
                final ResultSet resultSet = statement.executeQuery("select * from publisher")) {
            while (resultSet.next()) {
                final Publisher publisher = new Publisher();
                publisher.setName(resultSet.getString("name"));
                publishers.add(publisher);
            }
        } catch (SQLException throwables) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't get publishers from DB!", throwables);
        }
        return publishers;
    }
}
