/**
 * 
 */

package it.bogny.jyugiohdb.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import it.bogny.jyugiohdb.util.Log;
import it.bogny.jyugiohdb.util.LogType;

/**
 * @author BoGnY
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
            if (new File("yugiohdb.db").exists()) {
                // create a database connection
                dbConnection = DriverManager.getConnection("jdbc:sqlite:yugiohdb.db");
                Log.save(LogType.DEBUG, "Database file found: yugiohdb.db");
            } else {
                Log.save(LogType.FATAL, "SQL error or missing database");
            }
        } catch (Exception Ex) {
            Log.save(LogType.FATAL, Ex);
        }
        return dbConnection;
    }
}
