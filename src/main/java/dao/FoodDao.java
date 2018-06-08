package main.java.dao;

import main.java.model.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDao extends AbstracDao<Food> {
    @Override
    public Food insert(Food object) {
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into Food(food_name_,food_price_,food_category_,food_buydate_,food_eatdate_) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(2, object.getName());
            pstmt.setInt(3,object.getPrice());
            pstmt.setString(4, object.getCategory());
            pstmt.setString(5, object.getBuydate());
            pstmt.setString(6, object.getEatdate());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public Food delete(Food object) {
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("delete from food where food_name_=?");
            pstmt.setString(1, object.getName());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public Food update(Food object) {
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("update food set food_category_=? where food_name_=?");
            pstmt.setString(1, object.getCategory());
            pstmt.setString(2, object.getName());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public Food find(Food object) {
        Food data = new Food();
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from food where food_name_=?");
            pstmt.setString(1, object.getName());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                data.setName(rs.getString("food_name_"));
                data.setCategory(rs.getString("food_category_"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List findAll() {
        List<Food> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from FOOD");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Food food = new Food();
                food.setCategory(rs.getString("food_category_"));
                food.setName(rs.getString("food_name_"));
                list.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
