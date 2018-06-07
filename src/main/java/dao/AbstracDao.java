package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstracDao<T> {
    final static String Driver = "org.h2.Driver";
    final static String URI = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;";
    final static String USERNAME = "sa";
    final static String PASSWORD = "";
    private Connection connection=null;
     public Connection getConnection(){
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
    public abstract T insert(T object);
    public abstract T delete(T object);
    public abstract T update(T object);
    public abstract T find(T object);
    public abstract List<T> findAll();


}
