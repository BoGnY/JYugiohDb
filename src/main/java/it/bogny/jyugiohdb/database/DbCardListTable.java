/**
 * 
 */

package it.bogny.jyugiohdb.database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.bogny.jyugiohdb.util.Log;

/**
 * @author BoGnY
 *
 */
public class DbCardListTable {

    /**
     * Select specified rows in cardList table
     * 
     * @param listId
     *            Used to link cardSets rows with the corresponding cardList rows
     * @param cardId
     *            The id of cards
     * @param cardSetCode
     *            The code of set
     * 
     * @return The ResultSet of all matched cardList row
     */
    public static ResultSet selectCardList(int listId, int cardId, String cardSetCode) {
        String sqlString = "SELECT * FROM cardList WHERE listId = ? AND cardId = ? AND cardSetCode = ?";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        ResultSet dbResultSet = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, listId);
            dbPreparedStatement.setInt(2, cardId);
            dbPreparedStatement.setString(3, cardSetCode);
            dbResultSet = dbPreparedStatement.executeQuery(sqlString);
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        return dbResultSet;
    }

    /**
     * Insert a new row in cardList table
     *
     * @param listId
     * @param cardId
     * @param cardSetCode
     * @param cardCount
     * @param cardCondition
     * @param cardPriceHigh
     * @param cardPriceLow
     * @param cardPriceAverage
     * 
     * @return The ResultSet of all matched cardList row
     */
    public static ResultSet insertCardList(int listId, int cardId, String cardSetCode, int cardCount, String cardCondition, BigDecimal cardPriceHigh, BigDecimal cardPriceLow, BigDecimal cardPriceAverage) {
        String sqlString = "INSERT INTO cardList (listId, cardId, cardSetCode, cardCount, cardCondition, cardPriceHigh, cardPriceLow, cardPriceAverage) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, listId);
            dbPreparedStatement.setInt(2, cardId);
            dbPreparedStatement.setString(3, cardSetCode);
            dbPreparedStatement.setInt(4, cardCount);
            dbPreparedStatement.setString(5, cardCondition);
            dbPreparedStatement.setBigDecimal(6, cardPriceHigh);
            dbPreparedStatement.setBigDecimal(7, cardPriceLow);
            dbPreparedStatement.setBigDecimal(8, cardPriceAverage);
            dbPreparedStatement.executeUpdate();
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        // After the insert statement, return the updated cardSets table rows
        ResultSet dbResultSet = selectCardList(listId, cardId, cardSetCode);
        return dbResultSet;
    }

    /**
     * Update an existing row in cardList table
     *
     * @param listId
     * @param cardId
     * @param cardSetCode
     * @param cardCount
     * @param cardCondition
     * @param cardPriceHigh
     * @param cardPriceLow
     * @param cardPriceAverage
     * 
     * @return The ResultSet of all matched cardList row
     */
    public static ResultSet updateCardList(int listId, int cardId, String cardSetCode, int cardCount, String cardCondition, BigDecimal cardPriceHigh, BigDecimal cardPriceLow, BigDecimal cardPriceAverage) {
        String sqlString = "UPDATE cardList SET cardCount = ?, cardCondition = ?, cardPriceHigh = ?, cardPriceLow = ?, cardPriceAverage = ? WHERE listId = ? AND cardId = ? AND cardSetCode = ?";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, cardCount);
            dbPreparedStatement.setString(2, cardCondition);
            dbPreparedStatement.setBigDecimal(3, cardPriceHigh);
            dbPreparedStatement.setBigDecimal(4, cardPriceLow);
            dbPreparedStatement.setBigDecimal(5, cardPriceAverage);
            dbPreparedStatement.setInt(6, listId);
            dbPreparedStatement.setInt(7, cardId);
            dbPreparedStatement.setString(8, cardSetCode);
            dbPreparedStatement.executeUpdate();
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        // After the update statement, return the updated cardList table rows
        ResultSet dbResultSet = selectCardList(listId, cardId, cardSetCode);
        return dbResultSet;
    }

}
