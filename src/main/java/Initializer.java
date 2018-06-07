package main.java;

import main.java.dao.AbstracDao;
import org.h2.tools.RunScript;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebListener
public class Initializer extends AbstracDao implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       Connection connection=getConnection();
       if(null!=connection){
           System.out.println("Initialize success");
           ClassLoader classLoader = getClass().getClassLoader();
           File file1 = new File(classLoader.getResource("/main/resources/data.sql").getFile());
           File file2 = new File(classLoader.getResource("/main/resources/data2.sql").getFile());
           try {
               RunScript.execute(connection,new FileReader(file1));
               RunScript.execute(connection,new FileReader(file2));
           } catch (SQLException e) {
               e.printStackTrace();
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }

       }else{
           System.out.println("Initialize fail");

       }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public Object insert(Object object) {
        return null;
    }

    @Override
    public Object delete(Object object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public Object find(Object object) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
