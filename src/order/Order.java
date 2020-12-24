package order;

public class Order {
    private int id;
    private int menuId;
    private String username;
    private boolean isApproved;
    private String email;

    public Order() {
    }

    public Order(int id, int menuId, String username, boolean isApproved, String email) {
        this.id = id;
        this.menuId = menuId;
        this.username = username;
        this.isApproved = isApproved;
        this.email = email;
    }

    public Order(int menuId, String username, String email) {
        this.menuId = menuId;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
