package main.java.dao;

import main.java.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstracDao{
    public List<User> findAll(){
        List<User> list=new ArrayList<>();
        try {
            Connection connection=getConnection();
            PreparedStatement pstmt=connection.prepareStatement("select * from user");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setPassword(rs.getString("password_"));
                user.setUserName(rs.getString("user_name_"));
                list.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
