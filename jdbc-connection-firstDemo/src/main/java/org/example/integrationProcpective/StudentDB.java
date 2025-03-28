package org.example.integrationProcpective;

import org.example.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {

    private static Connection connection = DBConnection.getConnection();

    public static void main(String[] args) {

        List<Student> studentList=getStudents();
        studentList.forEach(System.out::println);
    }

    //CRUD:READ
    /*
        1.Don't want print Operation as per standard
        2.So return List of student

     */
    private static List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        final String SELECT_QUERY = "select * from students";

        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_QUERY))
        {
            System.out.println("Connection : "+connection);

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

             //   System.out.println("ID "+id+", NAME "+name+", AGE "+age);

                Student student = new Student(id,name,age);
                //read the student data one by one and store in object
                students.add(student);
                //one by one object added to list
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return students;
        //object return :  You can print from main

    }
}
