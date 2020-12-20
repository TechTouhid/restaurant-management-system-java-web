package manageFood;

import model.Menu;

import java.sql.*;
import java.util.TimeZone;

public class MenuDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/rms?";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private static Connection conn = null;
    private static Statement stmt = null;

    private static final String INSERT_MENU = "INSERT INTO menu" + "  (name, price, category) VALUES "
            + " (?, ?, ?);";

    public MenuDAO() {
//        CreateMenuTable();
        getConnection();
//        createConnection();
    }

    // Creating Database Connection
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rms?serverTimezone=" + TimeZone.getDefault().getID(), "root", "");
//            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
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
            preparedStatement.setDouble(3,menu.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
