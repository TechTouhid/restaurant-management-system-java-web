package user;

import model.Menu;
import model.User;

import java.sql.*;
import java.util.TimeZone;

public class UserDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/rms?";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private static Connection conn = null;
    private static Statement stmt = null;

    private static final String INSERT_USER = "INSERT INTO users" + "  (fullname, email, password) VALUES "
            + " (?, ?, ?);";
    private static final String SELECT_USER = "SELECT * FROM users WHERE email = ? and password = ?";

    public UserDAO(){
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
    public void insertUser(User user) throws SQLException {
        // try-with-resource statement will auto close the connection.

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getFullname());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        User user = null;
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);){
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user = new User();
                user.setFullname(result.getString("fullname"));
                user.setEmail(email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    public User adminCheckLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        User user = null;
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);){
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user = new User();
                user.setFullname(result.getString("fullname"));
                user.setEmail(email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
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
