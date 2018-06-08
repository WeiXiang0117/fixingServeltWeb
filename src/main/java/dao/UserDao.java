package main.java.dao;

import main.java.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstracDao<User>{

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

    @Override
    public User insert(User object) {
        try {
            Connection connection=getConnection();
            PreparedStatement pstmt=connection.prepareStatement("insert into user (user_name_,password_) VALUES (?,?)");
            pstmt.setString(1,object.getUserName());
            pstmt.setString(2,object.getPassword());
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public User delete(User object) {
        try {
            Connection connection=getConnection();
            PreparedStatement pstmt=connection.prepareStatement("delete from user where user_name_=?");
            pstmt.setString(1,object.getUserName());
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public User update(User object) {
        try {
            Connection connection=getConnection();
            PreparedStatement pstmt=connection.prepareStatement("update user set password_=? where user_name_=?");
            pstmt.setString(1,object.getPassword());
            pstmt.setString(2,object.getUserName());
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public User find(User object) {
        User data=new User();
        try {
            Connection connection=getConnection();
            PreparedStatement pstmt=connection.prepareStatement("select * from user where user_name_=?");
            pstmt.setString(1,object.getUserName());
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                data.setUserName(rs.getString("user_name_"));
                data.setPassword(rs.getString("password_"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

}
