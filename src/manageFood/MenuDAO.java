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
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public MenuDAO() {
//        CreateMenuTable();
        getConnection();
//        createConnection();
    }

    // Creating Database Connection
    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rms?serverTimezone=" + TimeZone.getDefault().getID(), "root", "");
            System.out.println("Db connected");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return connection;
    }

    // created the Book table
//    public void CreateMenuTable() {
//        try {
//            stmt = conn.createStatement();
////            stmt.execute("SET GLOBAL time_zone = '+6:00'");
//
//            stmt.execute(" CREATE TABLE IF NOT EXISTS menu ("
//                    + " id varchar(255) PRIMARY key AUTO_INCREMENT, \n"
//                    + " name varchar (255), \n"
//                    + " price varchar (255), \n"
//                    + " category varchar (100) \n"
//                    + ")");
//
//        } catch (SQLException e) {
//            System.out.println(e.getLocalizedMessage());
//        }
//    }

    // Create insert method
    public void insertMenu(Menu menu) throws SQLException {
        System.out.println(INSERT_MENU);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENU)) {
            preparedStatement.setString(1,menu.getName());
            preparedStatement.setString(2,menu.getCategory());
            preparedStatement.setString(3,menu.getPrice());
            System.out.println(preparedStatement);
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
            System.out.println(preparedStatement);
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
