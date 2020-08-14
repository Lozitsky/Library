package com.kirilo.jsp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public void check() {
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/Library");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from publisher");
            if (resultSet != null) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                }
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
