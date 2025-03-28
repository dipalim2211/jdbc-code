package imdb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class to create single instance of connection
public class DBConnectionMovie {

    //1.Make Constructor Private
    //2.Static Methode to return connection Object
    //3.Static instance of variable

    static final String URL ="jdbc:postgresql://localhost:5433/devgen";
    static final String USERNAME = "postgres";
    static final  String PASSWORD = "Java@2211";

    private static Connection connection = null;        //3.

    private DBConnectionMovie(){                             //1.

    }

    public static Connection getConnection(){           //2.
        if(connection==null){
            //create connection
            try {
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }


}
