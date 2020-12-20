package manageFood;

import model.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MenuDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/rms?";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private static Connection conn = null;
    private static Statement stmt = null;

    private static final String INSERT_MENU = "INSERT INTO menu" + "  (name, price, category) VALUES "
            + " (?, ?, ?);";
    private static final String SELECT_ALL_MENU = "select * from menu";
    private static final String DELETE_MENU = "delete from menu where id = ?;";
    private static final String UPDATE_USERS = "update menu set name =?,price =?, category =? where id =?;";
    private static final String SELECT_MENU_BY_ID = "select name,price,category from menu where id =?";

    public MenuDAO() {
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
    public void insertMenu(Menu menu) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENU)) {
            preparedStatement.setString(1, menu.getName());
            preparedStatement.setString(2, menu.getPrice());
            preparedStatement.setString(3, menu.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Select all the menus
    public static List<Menu> selectAllMenus() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Menu> menuitem = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MENU);) {
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String category = rs.getString("category");
                menuitem.add(new Menu(id, name, price, category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return menuitem;
    }

    // Delete menu
    public static boolean deleteMenu(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_MENU);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Update menu
    public static boolean updateMenu(Menu menu) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);) {
            statement.setString(1, menu.getName());
            statement.setString(2, menu.getPrice());
            statement.setString(3, menu.getCategory());
            statement.setInt(4, menu.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public static Menu selectMenu(int id) {
        Menu menu = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENU_BY_ID);) {
            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String category = rs.getString("category");
                menu = new Menu(id, name, price, category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return menu;
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
