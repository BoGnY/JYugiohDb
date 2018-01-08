/**
 * 
 */

package it.bogny.jyugiohdb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import it.bogny.jyugiohdb.util.Log;

/**
 * @author BoGnY
 *
 */
public class DbCardDbTable {

    /**
     * Select all rows in cardDb table
     * 
     * @return The ResultSet of all cardDb table rows
     */
    public static ResultSet selectCardDb() {
        String sqlString = "SELECT * FROM cardDb ORDER BY cardId ASC";

        Connection dbConnection = null;
        Statement dbStatement = null;
        ResultSet dbResultSet = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery(sqlString);
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        return dbResultSet;
    }

    /**
     * Select a single row in cardDb table
     * 
     * @param cardId
     * 
     * @return The ResultSet of the selected cardDb table row
     */
    public static ResultSet selectCardDb(int cardId) {
        String sqlString = "SELECT * FROM cardDb WHERE cardId = ?";

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
     * Insert a new row in cardDb table
     *
     * @param cardId
     * @param cardNameIT
     * @param cardNameEN
     * @param cardAttribute
     * @param cardLevel
     * @param cardMonsterType
     * @param cardType
     * @param cardPendulumValue
     * @param cardPendulumText
     * @param cardAtk
     * @param cardDef
     * @param cardText
     * 
     * @return The updated cardDb table rows
     */
    public static ResultSet insertCardDb(int cardId, String cardNameIT, String cardNameEN, String cardAttribute, int cardLevel, String cardMonsterType, String cardType, int cardPendulumValue, String cardPendulumText, String cardAtk, String cardDef, String cardText) {
        String sqlString = "INSERT INTO cardDb (cardId, cardNameIT, cardNameEN, cardAttribute, cardLevel, cardMonsterType, cardType, cardPendulumValue, cardPendulumText, cardAtk, cardDef, cardText) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, cardId);
            dbPreparedStatement.setString(2, cardNameIT);
            dbPreparedStatement.setString(3, cardNameEN);
            dbPreparedStatement.setString(4, cardAttribute);
            dbPreparedStatement.setInt(5, cardLevel);
            dbPreparedStatement.setString(6, cardMonsterType);
            dbPreparedStatement.setString(7, cardType);
            dbPreparedStatement.setInt(8, cardPendulumValue);
            dbPreparedStatement.setString(9, cardPendulumText);
            dbPreparedStatement.setString(10, cardAtk);
            dbPreparedStatement.setString(11, cardDef);
            dbPreparedStatement.setString(12, cardText);
            dbPreparedStatement.executeUpdate();
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        // After the insert statement, return the updated cardDb table rows
        ResultSet dbResultSet = selectCardDb();
        return dbResultSet;
    }

    /**
     * Update the specified row in cardDb table with the given params value
     *
     * @param cardId
     * @param cardNameIT
     * @param cardNameEN
     * @param cardAttribute
     * @param cardLevel
     * @param cardMonsterType
     * @param cardType
     * @param cardPendulumValue
     * @param cardPendulumText
     * @param cardAtk
     * @param cardDef
     * @param cardText
     * 
     * @return The updated cardDb table rows
     */
    public static ResultSet updateCardDb(int cardId, String cardNameIT, String cardNameEN, String cardAttribute, int cardLevel, String cardMonsterType, String cardType, int cardPendulumValue, String cardPendulumText, String cardAtk, String cardDef, String cardText) {
        String sqlString = "UPDATE cardDb SET cardNameIT = ?, cardNameEN = ?, cardAttribute = ?, cardLevel = ?, cardMonsterType = ?, cardType = ?, cardPendulumValue = ?, cardPendulumText = ?, cardAtk = ?, cardDef = ?, cardText = ? WHERE cardId = ?";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setString(1, cardNameIT);
            dbPreparedStatement.setString(2, cardNameEN);
            dbPreparedStatement.setString(3, cardAttribute);
            dbPreparedStatement.setInt(4, cardLevel);
            dbPreparedStatement.setString(5, cardMonsterType);
            dbPreparedStatement.setString(6, cardType);
            dbPreparedStatement.setInt(7, cardPendulumValue);
            dbPreparedStatement.setString(8, cardPendulumText);
            dbPreparedStatement.setString(9, cardAtk);
            dbPreparedStatement.setString(10, cardDef);
            dbPreparedStatement.setString(11, cardText);
            dbPreparedStatement.setInt(12, cardId);
            dbPreparedStatement.executeUpdate();
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        // After the insert statement, return the updated cardDb table rows
        ResultSet dbResultSet = selectCardDb();
        return dbResultSet;
    }

    /**
     * Delete the specified row in cardDb table
     * 
     * @param cardId
     * 
     * @return The updated cardDb table rows
     */
    public static ResultSet deleteCardDb(int cardId) {
        String sqlString = "DELETE FROM cardDb WHERE cardId = ?";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, cardId);
            dbPreparedStatement.executeUpdate();
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        // After the insert statement, return the updated cardDb table rows
        ResultSet dbResultSet = selectCardDb();
        return dbResultSet;
    }
}
