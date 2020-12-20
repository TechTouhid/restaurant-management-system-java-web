package model;

public class Menu {
    protected int id;
    protected String name;
    protected String  price;
    protected String category;

    public Menu() {
    }

    public Menu(String name, String price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public Menu(int id, String name, String price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
