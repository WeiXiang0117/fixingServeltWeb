package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstracDao {
    final static String Driver = "org.h2.Driver";
    final static String URI = "jdbc:h2:./testdb;DB_CLOSE_DELAY=-1";
    final static String USERNAME = "sa";
    final static String PASSWORD = "";
    private Connection connection=null;
     Connection getConnection(){
        if(connection==null){
            try {
                Class.forName(Driver);
                connection = DriverManager
                        .getConnection(URI,USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  connection;
    }
}
