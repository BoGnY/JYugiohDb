/**
 * 
 */

package it.bogny.jyugiohdb.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.bogny.jyugiohdb.util.Log;

/**
 * @author BoGnY
 *
 */
public class DbCardSetsTable {

    /**
     * Select a single row in cardSets table
     * 
     * @param cardId
     *            The id of cards
     * 
     * @return The ResultSet of the selected cardSets table row
     */
    public static ResultSet selectCardSets(int cardId) {
        String sqlString = "SELECT * FROM cardSets WHERE cardId = ?";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        ResultSet dbResultSet = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, cardId);
            dbResultSet = dbPreparedStatement.executeQuery(sqlString);
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        return dbResultSet;
    }

    /**
     * Insert a new row in cardSets table
     *
     * @param cardId
     * @param cardSetLang
     * @param cardSetDate
     * @param cardSetCode
     * @param cardSetName
     * @param cardSetRarity
     * 
     * @return The updated cardSets table rows
     */
    public static ResultSet insertCardSets(int cardId, String cardSetLang, Date cardSetDate, String cardSetCode, String cardSetName, String cardSetRarity) {
        String sqlString = "INSERT INTO cardSets (cardId, cardSetLang, cardSetDate, cardSetCode, cardSetName, cardSetRarity) VALUES (?, ?, ?, ?, ?, ?)";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, cardId);
            dbPreparedStatement.setString(2, cardSetLang);
            dbPreparedStatement.setDate(3, cardSetDate);
            dbPreparedStatement.setString(4, cardSetCode);
            dbPreparedStatement.setString(5, cardSetName);
            dbPreparedStatement.setString(6, cardSetRarity);
            dbPreparedStatement.executeUpdate();
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        // After the insert statement, return the updated cardSets table rows
        ResultSet dbResultSet = selectCardSets(cardId);
        return dbResultSet;
    }

}
