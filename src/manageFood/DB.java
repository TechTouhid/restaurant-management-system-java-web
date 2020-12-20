package manageFood;

import java.sql.*;
import java.util.TimeZone;

public class DB {
    public static void main(String[] args) {
// Automatic close the connections and statements
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
//             Statement statement = conn.createStatement()) {
//            statement.execute("CREATE TABLE contacts (name varchar(20), phone INTEGER(20), email varchar(20) )");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rms?serverTimezone=" + TimeZone.getDefault().getID(), "root", "");
//            conn.setAutoCommit(false); // we can set the auto commit false to stop saving the changes in database
            Statement statement = conn.createStatement();

            // Creating the table in student database name contacts
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    " (name varchar(20), phone INTEGER(20), email varchar(20) )");

            // Inserting data into the contacts table
//            statement.execute("INSERT INTO contacts(name, phone, email)" +
//                                  "VALUE ('Touhid', 180503104, 'Touhid@gmail.com')");

//            statement.execute("UPDATE prfile2 SET 'last name' = x 'first name' = ? , address= ? , city= ? , state= ? , telephone= ?  WHERE id = ?");


            // Updating the phone number
//            statement.execute("UPDATE contacts SET phone=01748753174 WHERE name='Touhid' ");

            // Deleting the a row
//            statement.execute("DELETE FROM contacts WHERE name='Touhid'");

            // Getting the data form the database
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();
//            while (results.next()) {
//                System.out.println(results.getString("name") + " " +
//                        results.getInt("phone") + " " +
//                        results.getString("email"));
//            }
//            results.close();

            // Closing the connections and the statements
            // Important note is that statements need to close first
            statement.close();
            conn.close();

            // This will show if have any error in the connection
        } catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
    }
}