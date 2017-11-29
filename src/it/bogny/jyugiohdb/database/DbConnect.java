/**
 * 
 */

package it.bogny.jyugiohdb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author luca_
 *
 */
public class DbConnect {
    /**
     * Connect to the sqlite database
     * 
     * @return The connection object
     */
    public static Connection dbConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:yugiohdb.db");
            // create a database connection
            // Statement statement = dbConnection.createStatement();
            // statement.setQueryTimeout(30); // set timeout to 30 sec.
        } catch (SQLException SQLEx) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(SQLEx.getMessage());
        } catch (Exception Ex) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(Ex.getMessage());
        }
        return dbConnection;
    }
}
