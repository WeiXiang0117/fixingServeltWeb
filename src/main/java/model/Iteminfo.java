package main.java.model;

import main.java.dao.AbstracDao;

import java.sql.Timestamp;
import java.util.List;

public class Iteminfo {
    private String itemName, itemCategory;
    private int itemNo, itemPrice;
    private Timestamp itemCreateTime, itemDropTime;

    public int getItemNo() {
        return itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public Timestamp getItemCreateTime() {
        return itemCreateTime;
    }

    public Timestamp getItemDropTime() {
        return itemDropTime;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemCreateTime(Timestamp itemCreateTime) {
        this.itemCreateTime = itemCreateTime;
    }

    public void setItemDropTime(Timestamp itemDropTime) {
        this.itemDropTime = itemDropTime;
    }

    @Override
    public String toString() {
        return "Item [itemNO=" + itemNo + ", itemName=" + itemName
                + ", itemPrice=" + itemPrice + ", itemCategory=" + itemCategory + ", itemCreateTime="
                + itemCreateTime + ", itemDropTime =" + itemDropTime + "]";
    }
}
