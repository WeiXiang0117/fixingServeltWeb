package main.java.dao;

import main.java.model.Iteminfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao extends AbstracDao<Iteminfo> {


    @Override
    public Iteminfo insert(Iteminfo itemInsert) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO item_list (item_no_, item_name_, item_price_, item_category_, item_create_time_, item_drop_time_)" +
                            "VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1,itemInsert.getItemNo());
            preparedStatement.setString(2,itemInsert.getItemName());
            preparedStatement.setInt(3,itemInsert.getItemPrice());
            preparedStatement.setString(4,itemInsert.getItemCategory());
            preparedStatement.setTimestamp(5,itemInsert.getItemCreateTime());
            preparedStatement.setTimestamp(6,itemInsert.getItemDropTime());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return itemInsert;
    }

    @Override
    public Iteminfo delete(Iteminfo itemDelete) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM item_list WHERE item_no_=?");
            preparedStatement.setInt(1,itemDelete.getItemNo());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return itemDelete;
    }

    @Override
    public Iteminfo update(Iteminfo itemUpdate) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item_lsit SET item_name_ = ?, item_price_ = ?, item_category_ =?," +
                    "item_create_time_ =?, item_drop_time_ = ? WHERE item_no_ =?");
            preparedStatement.setInt(1, itemUpdate.getItemNo());
            preparedStatement.setString(2, itemUpdate.getItemName());
            preparedStatement.setInt(3, itemUpdate.getItemPrice());
            preparedStatement.setString(4, itemUpdate.getItemCategory());
            preparedStatement.setTimestamp(5, itemUpdate.getItemCreateTime());
            preparedStatement.setTimestamp(6, itemUpdate.getItemDropTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }return itemUpdate;
    }

    @Override
    public Iteminfo find(Iteminfo itemFind) {
        Iteminfo iteminfo = new Iteminfo();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item_list WHERE item_no_ = ? OR item_name_ = ?");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                iteminfo.setItemNo(resultSet.getInt("item_no_"));
                iteminfo.setItemName(resultSet.getNString("item_name_"));
                iteminfo.setItemPrice(resultSet.getInt("item_price_"));
                iteminfo.setItemCategory(resultSet.getString("item_category_"));
                iteminfo.setItemCreateTime(resultSet.getTimestamp("item_create_time_"));
                iteminfo.setItemDropTime(resultSet.getTimestamp("item_drop_time"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return itemFind;
    }

    @Override
    public List<Iteminfo> findAll() {
        List<Iteminfo> listItem = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item_list");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Iteminfo iteminfo = new Iteminfo();
                iteminfo.setItemNo(resultSet.getInt("item_no_"));
                iteminfo.setItemName(resultSet.getString("item_name_"));
                iteminfo.setItemPrice(resultSet.getInt("item_price_"));
                iteminfo.setItemCategory(resultSet.getString("item_category_"));
                iteminfo.setItemCreateTime(resultSet.getTimestamp("item_create_time_"));
                iteminfo.setItemDropTime(resultSet.getTimestamp("item_drop_time_"));
                listItem.add(iteminfo);
            }
    }catch (SQLException e){
            e.printStackTrace();
        }
        return listItem;
}
}
