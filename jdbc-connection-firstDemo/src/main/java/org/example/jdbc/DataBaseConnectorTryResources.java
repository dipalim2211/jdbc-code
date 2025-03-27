package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnectorTryResources {

    public static void main(String[] args) {

        final String url ="jdbc:postgresql://localhost:5433/devgen";
        final String username = "postgres";
        final String password = "Java@2211";
        final String query = "select * from students";

        connectToDBAndRetriveResult(url, username, password, query);

    }

    //Extract Methode :
    //Select method from try and  ctrl+alt+m and give name to methode
    private static void connectToDBAndRetriveResult(String url, String username, String password, String query) {
        //try with Resources
        try(Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);)
        {
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID "+id+", NAME "+name+", AGE "+age);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
