
package it.bogny.jyugiohdb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.bogny.jyugiohdb.util.Log;

/**
 * @author BoGnY
 *
 */
public class DbCardSetsList {
    /**
     * Select statement to show list of sets for the specified card
     * 
     * @param cardId
     *            The id of card
     * 
     * @return The ResultSet of the list of sets for the specified card
     */
    public static ResultSet selectCardSetsList(int cardId) {
        String sqlString = "SELECT cardSets.listId AS listIdSets, cardSets.cardId, cardSets.cardSetLang, cardSets.cardSetDate, TRIM(cardSets.cardSetCode) AS cardSetCode, cardSets.cardSetName, TRIM(cardSets.cardSetRarity) AS cardSetRarity, cardList.listId AS listIdList, cardList.cardCount, cardList.cardCondition, cardList.cardPriceHigh, cardList.cardPriceLow, cardList.cardPriceAverage FROM cardSets LEFT OUTER JOIN cardList ON (cardSets.listId = cardList.listId) AND (cardSets.cardSetCode = cardList.cardSetCode) WHERE (cardSets.cardId = ?) ORDER BY cardSets.cardSetDate DESC";

        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
        ResultSet dbResultSet = null;
        try {
            dbConnection = DbConnect.dbConnection();
            dbPreparedStatement = dbConnection.prepareStatement(sqlString);
            dbPreparedStatement.setInt(1, cardId);
            dbResultSet = dbPreparedStatement.executeQuery();
        } catch (SQLException SQLEx) {
            Log.save("error", SQLEx);
        }
        return dbResultSet;
    }

}
