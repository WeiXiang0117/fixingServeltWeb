package main.java;

import main.java.dao.AbstracDao;
import org.h2.tools.RunScript;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.sql.Connection;

@WebListener
public class Initializer extends AbstracDao implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       Connection connection=getConnection();
       if(null!=connection){
           System.out.println("Initialize success");
       }else{
           System.out.println("Initialize fail");

       }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
