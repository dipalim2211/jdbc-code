package org.example.jdbc;

import java.sql.*;

public class DatabaseOperation {

    //static: don't want object to access property

    final static String URL ="jdbc:postgresql://localhost:5433/devgen";
    final static String USERNAME = "postgres";
    final static String PASSWORD = "Java@2211";

    public static void main(String[] args) {

        connectToDBAndRetrieveResult();
        addStudents(9 ,"Sonali",22); //Pass student data to add

    }

    private static void connectToDBAndRetrieveResult() {

        final String SELECT_QUERY = "select * from students";

        //try with Resources
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_QUERY);)
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

    private static void addStudents(int id,String name,int age) {

        /*
        final String insertQuery = "insert into students(id,name,age) values ("+id+",'"+name+"',"+age+")";
        query used by statement obj and issue may occur due to this.
        issue:
        1. SQL injection Attack('""') : Not recommended Approach
        2.it's slow : Because of dynamic value(ex. 1000 times insertion by dynamic value)
        you cant catch the query
        3.Syntax complex to manage

        to Overcome,
        Java introduced new statement : PreparedStatement
        1.No SQL injection Attack
        2.it's fast
        3.syntax is simple
        4.instead of dynamic values use same count place holder(?)
        5.use preparedStatement methode instead statement method and pass query

         */
        final String insertQuery = "insert into students(id,name,age) values (?,?,?)"; //4.

        System.out.println("Query Inserted : "+insertQuery);


        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(insertQuery);)   //5.
        {
            //For first ? I want id
            statement.setInt(1,id);
            //set name for second ?
            statement.setString(2,name);
            statement.setInt(3,age);

            int count = statement.executeUpdate();

            if(count>0){
                System.out.println("Student Record Inserted");
            }else{
                System.out.println("Student Record Not Inserted");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
