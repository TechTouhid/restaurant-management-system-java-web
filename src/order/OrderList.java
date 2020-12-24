package order;

public class OrderList {
    private int id;
    private String foodName;
    private String price;
    private String category;
    private String email;
    private int isApproved;

    public OrderList() {
    }

    public OrderList(int id, String foodName, String price, String category, String email, int isApproved) {
        this.id = id;
        this.foodName = foodName;
        this.price = price;
        this.category = category;
        this.email = email;
        this.isApproved = isApproved;
    }
    public OrderList(int id, String foodName, String price, String category, String email) {
        this.id = id;
        this.foodName = foodName;
        this.price = price;
        this.category = category;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }
}
