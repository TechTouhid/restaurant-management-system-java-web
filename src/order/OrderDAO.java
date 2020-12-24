package order;

import manageFood.MenuDAO;
import model.Menu;
import model.User;
import user.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class OrderDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/rms?";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private static Connection conn = null;
    private static Statement stmt = null;

    private static final String INSERT_ORDER = "INSERT INTO order_table" + "  (menuId, foodName, price, category, email) VALUES "
            + " (?, ?, ?, ?, ?);";
    private static final String SELECT_ORDER = "SELECT * FROM user WHERE email = ? and password = ?";
    private static final String SELECT_MENU_BY_ID = "select name,price,category from menu where id =?";
    private static final String SELECT_ALL_ORDER = "select * from order_table";
    private static final String UPDATE_ORDER = "update order_table set isApproved =? where id =?;";


    public OrderDAO(){
        getConnection();
    }
    // Creating Database Connection
    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rms?serverTimezone=" + TimeZone.getDefault().getID(), "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return connection;
    }
    // Create insert method
    public void insertOrder(OrderList order) throws SQLException {
        // try-with-resource statement will auto close the connection.

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2,order.getFoodName());
            preparedStatement.setString(3,order.getPrice());
            preparedStatement.setString(4,order.getCategory());
            preparedStatement.setString(5,order.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Select all the menus
    public static List<OrderList> selectAllOrders() {
        List<OrderList> orderitem = new ArrayList<>();
//        String foodName = null;
//        String price = null;
//        String category = null;
//        String email = null;
//        int isApproved = Integer.parseInt(null);
//        int menuId = Integer.parseInt(null);
//        int orderId = Integer.parseInt(null);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                int menuId = rs.getInt("menuId");
                String email = rs.getString("email");
                int isApproved = rs.getInt("isApproved");
                String foodName = rs.getString("foodName");
                String price = rs.getString("price");
                String category = rs.getString("category");
                orderitem.add(new OrderList(orderId, foodName, price, category, email, isApproved));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return orderitem;
    }

    // Update menu
    public static boolean updateOrder(int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER);) {
            statement.setInt(1, 1);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }



    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
