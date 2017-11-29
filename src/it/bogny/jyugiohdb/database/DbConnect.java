/**
 * 
 */

package it.bogny.jyugiohdb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author luca_
 *
 */
public class DbConnect {
    Connection dbConnection = null;
    {
        try {
            // create a database connection
            dbConnection = DriverManager.getConnection("jdbc:sqlite:yugiohdb.db");
            Statement statement = dbConnection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            // statement.executeUpdate("create table person (id integer, name string)");
            // statement.executeUpdate("insert into person values(1, 'leo')");
            ResultSet rs = statement.executeQuery("select * from cardDb");
            while (rs.next()) {
                // read the result set
                System.out.println("cardId = " + rs.getInt("cardId"));
                System.out.println("cardNameIT = " + rs.getString("cardNameIT"));
            }
        } catch (SQLException SQLEx) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(SQLEx.getMessage());
        } finally {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException SQLEx) {
                // connection close failed.
                System.err.println(SQLEx);
            }
        }
    }
}
