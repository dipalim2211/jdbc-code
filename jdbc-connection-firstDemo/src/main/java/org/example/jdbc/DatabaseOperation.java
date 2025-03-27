package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperation {

    //static: don't want object to access property

    final static String URL ="jdbc:postgresql://localhost:5433/devgen";
    final static String USERNAME = "postgres";
    final static String PASSWORD = "Java@2211";

    public static void main(String[] args) {

        connectToDBAndRetrieveResult();
        addStudents(8,"Dipak",25); //Pass student data to add

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

        //HardCord Value wrong approach
        //final String insertQuery = "insert into students(id,name,age) values (7,'Reva',20)";

        //Dynamic input: use string inside string : "+id+"
        //sql : "KK" > Not work , 'KK' > work , '"+name+"'
        final String insertQuery = "insert into students(id,name,age) values ("+id+",'"+name+"',"+age+")";

        System.out.println("Query Inserted : "+insertQuery);

        //try with Resources
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();)
        {
            int count = statement.executeUpdate(insertQuery);
            //to insert query:executeUpdate() use > Return int
            //No resource opened just Variable stored int value
            //count > tell number row affected after query

            if(count>0){
                System.out.println("Student '"+name+"' Record Inserted");
            }else{
                System.out.println("Student '"+name+"' Record Not Inserted");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
