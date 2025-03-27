package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector {

    public static void main(String[] args) {

        //steps: For connection

        //1. Load the driver
        //2. Register the driver with DriverManager
        //3. Establish Connection
        //4. Create statement to write query
        //5. Execute Query
        //6. Process Result(Iterate and Print)
        //7. Close the Connection/Statement/resultSet


        //1&2 : Study Purpose

        // Class.forName("com.mysql.cj.jdbc.Driver");

        try {

            //3 . Establish Connection

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devgen", "root", "Java@2211");

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/devgen",
                    "postgres", "Java@2211");

            //4 . Create Statement

            Statement statement = connection.createStatement();

            //5. Execute Query

            ResultSet rs = statement.executeQuery("select * from students");

            //6. Process Result

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID "+id+", NAME "+name+", AGE "+age);
            }

            //7. Close Connection

            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
