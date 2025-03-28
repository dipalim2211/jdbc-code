package org.example.jdbc;

import java.sql.*;

public class DbConnectionTest {

    //when called class connection will establish
    private static Connection connection = DBConnection.getConnection();

    public static void main(String[] args) {

        connectToDBAndRetrieveResult();
        addStudents(10,"Test10",22);
    }


    //CRUD:CREATE
    private static void addStudents(int id,String name,int age) {

        final String insertQuery = "insert into students(id,name,age) values (?,?,?)"; //4.

        System.out.println("Query Inserted : "+insertQuery);

        try(PreparedStatement statement = connection.prepareStatement(insertQuery))   //5.
        {
            System.out.println("Connection : "+connection);

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

    //CRUD:READ
    private static void connectToDBAndRetrieveResult() {

        final String SELECT_QUERY = "select * from students";

        //try with Resources
        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_QUERY))
        {
            System.out.println("Connection : "+connection);

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

    //CRUD : UPDATE
    private static void updateStudents(int id,String name,int age) {

        final String updateQuery = "update students set age = ? , name = ? where id = ?";

        System.out.println("Query Inserted : "+updateQuery);

        try(PreparedStatement statement = connection.prepareStatement(updateQuery))
        {
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

        final String deleteQuery = "delete from students where id = ?";

        System.out.println("Query Inserted : "+deleteQuery);

        try(PreparedStatement statement = connection.prepareStatement(deleteQuery);)
        {

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
