package org.example.jdbc;

import java.sql.Connection;

public class DbConnectionTest {

    public static void main(String[] args) {

        Connection connection1 = DBConnection.getConnection();
        System.out.println(connection1);

        Connection connection2 = DBConnection.getConnection();
        System.out.println(connection2);

        Connection connection3 = DBConnection.getConnection();
        System.out.println(connection3);
    }
}
