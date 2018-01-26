
package it.bogny.jyugiohdb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.logging.log4j.core.config.Configurator;
import it.bogny.jyugiohdb.database.DbCardDbTable;
import it.bogny.jyugiohdb.database.DbCardSetsList;
import it.bogny.jyugiohdb.model.Card;
import it.bogny.jyugiohdb.model.CardSet;
import it.bogny.jyugiohdb.util.Log;
import it.bogny.jyugiohdb.util.LogType;
import it.bogny.jyugiohdb.util.Version;
import it.bogny.jyugiohdb.view.LayoutSwitcher;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Main class
 *
 * @author BoGnY
 */
public class MainApp extends Application {
    private static Stage mainStage;
    public static final String fileSeparator = System.getProperty("file.separator");
    public static final String lineSeparator = System.getProperty("line.separator");
    public static Properties configProp = new Properties();
    public static InputStream inputProp = null;

    /**
     * The main entry point for all JavaFX applications. The start method is called
     * after the init method has returned, and after the system is ready for the
     * application to begin running.<br>
     * <br>
     * NOTE: This method is called on the JavaFX Application Thread.
     * 
     * @param stage
     *            The primary stage for this application, onto which the application
     *            scene can be set. The primary stage will be embedded in the
     *            browser if the application was launched as an applet. Applications
     *            may create other stages, if needed, but they will not be primary
     *            stages and will not be embedded in the browser.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        mainStage.setTitle("YugiohDb v" + Version.formatVersion());

        // Set the application icon.
        mainStage.getIcons().add(new Image("file:it/bogny/jyugiohdb/images/app_icon.png"));

        mainStage.setScene(LayoutSwitcher.createScene(LayoutSwitcher.loadMainPane()));

        mainStage.show();
    }

    /**
     * Returns the main stage.
     * 
     * @return
     */
    public static Stage getMainStage() {
        return mainStage;
    }

    /**
     * Main constructor
     */
    public MainApp() {
        // Load all cards on cardData ObservableList
        ResultSet cardsResultSet = DbCardDbTable.selectCardDb();
        try {
            while (cardsResultSet.next()) {
                System.out.println(cardsResultSet.getInt("cardId") + "\t" + cardsResultSet.getString("cardNameIT") + "\t" + cardsResultSet.getString("cardNameEN"));
                Card.cardData.add(new Card(cardsResultSet.getInt("cardId"), cardsResultSet.getString("cardNameIT"), cardsResultSet.getString("cardNameEN"), cardsResultSet.getString("cardAttribute"), cardsResultSet.getInt("cardLevel"), cardsResultSet.getString("cardMonsterType"), cardsResultSet.getString("cardType"), cardsResultSet.getString("cardPendulumValue"), cardsResultSet.getString("cardPendulumText"), cardsResultSet.getString("cardAtk"), cardsResultSet.getString("cardDef"), cardsResultSet.getString("cardText")));

                // Load all card sets on cardSetsData ObservableList
                ResultSet cardsSetResultSet = DbCardSetsList.selectCardSetsList(cardsResultSet.getInt("cardId"));
                while (cardsSetResultSet.next()) {
                    System.out.println(cardsSetResultSet.getInt("cardId") + "\t" + cardsSetResultSet.getInt("listId") + "\t" + cardsSetResultSet.getString("cardSetCode"));
                    CardSet.cardSetData.add(new CardSet(cardsSetResultSet.getInt("cardId"), cardsSetResultSet.getInt("listId"), cardsSetResultSet.getString("cardSetLang"), LocalDate.parse(cardsSetResultSet.getObject("cardSetDate").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")), cardsSetResultSet.getString("cardSetCode"), cardsSetResultSet.getString("cardSetName"), cardsSetResultSet.getString("cardSetRarity"), cardsSetResultSet.getInt("cardCount"), cardsSetResultSet.getString("cardCondition"), cardsSetResultSet.getFloat("cardPriceHigh"), cardsSetResultSet.getFloat("cardPriceLow"), cardsSetResultSet.getFloat("cardPriceAverage")));
                }
            }
        } catch (SQLException SQLEx) {
            Log.save(LogType.FATAL, SQLEx);
        } catch (Exception Ex) {
            Log.save(LogType.FATAL, Ex);
        }
    }

    /**
     * The main entry point for all Java applications.
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {
        // Set instantly the configuration of log4j2
        Configurator.initialize(null, ClassLoader.getSystemResource("config" + fileSeparator + "log4j2.xml").toString());

        // Set immediately the configuration properties of app
        try {
            inputProp = ClassLoader.getSystemResourceAsStream(("config" + fileSeparator + "version.properties"));
            configProp.load(inputProp);
        } catch (FileNotFoundException FileNotFoundEx) {
            Log.save(LogType.FATAL, FileNotFoundEx);
        } catch (IOException IOEx) {
            Log.save(LogType.FATAL, IOEx);
        }

        launch(args);
    }
}
