/**
 * 
 */

package it.bogny.jyugiohdb.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author luca_
 *
 */
public class DbCardDbTable {
    /**
     * Select statement for cardDb database
     */
    public static ResultSet selectCardDb() {
        String sql = "SELECT * FROM cardDb";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnect.dbConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException SQLEx) {
            System.out.println(SQLEx.getMessage());
        }
        return rs;
    }
}
