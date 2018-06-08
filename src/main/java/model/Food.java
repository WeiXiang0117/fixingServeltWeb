package main.java.model;

public class Food {
    private String name;
    private int price;
    private String category;
    private String buydate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public String getEatdate() {
        return eatdate;
    }

    public void setEatdate(String eatdate) {
        this.eatdate = eatdate;
    }

    private String eatdate;
}
