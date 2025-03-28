package org.example.jdbc;

import java.sql.*;

public class DatabaseOperation {

    //static: don't want object to access property

    final static String URL ="jdbc:postgresql://localhost:5433/devgen";
    final static String USERNAME = "postgres";
    final static String PASSWORD = "Java@2211";

    public static void main(String[] args) {

       // connectToDBAndRetrieveResult();
       // addStudents(9 ,"Sonali",22);   //Pass student data to add
       // updateStudents(9,"Monali",21); //Pass student data to update
        deleteStudents(9); //delete whose id=9

    }

    //CRUD:READ
    private static void connectToDBAndRetrieveResult() {

        final String SELECT_QUERY = "select * from students";

        //try with Resources
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_QUERY))
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

    //CRUD:CREATE
    private static void addStudents(int id,String name,int age) {

        final String insertQuery = "insert into students(id,name,age) values (?,?,?)"; //4.

        System.out.println("Query Inserted : "+insertQuery);

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(insertQuery))   //5.
        {

            statement.setInt(1,id);
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


    //CRUD : UPDATE
    private static void updateStudents(int id,String name,int age) {

        final String updateQuery = "update students set age = ? , name = ? where id = ?";

        System.out.println("Query Inserted : "+updateQuery);

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(updateQuery))   //5.
        {

            //Arrange as per placeholder ?
            statement.setInt(1,age);
            statement.setString(2,name);
            statement.setInt(3,id);

            int count = statement.executeUpdate();

            if(count>0){
                System.out.println("Student Record Updated");
            }else{
                System.out.println("Student Record Not Updated");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //CRUD : DELETE
    private static void deleteStudents(int id) {
        //delete id on basis of id

        final String deleteQuery = "delete from students where id = ?";

        System.out.println("Query Inserted : "+deleteQuery);

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(deleteQuery);)
        {

            //Arrange as per placeholder ?
            statement.setInt(1,id);

            int count = statement.executeUpdate();

            if(count>0){
                System.out.println("Student Record Deleted");
            }else{
                System.out.println("Student Record Not Deleted");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
