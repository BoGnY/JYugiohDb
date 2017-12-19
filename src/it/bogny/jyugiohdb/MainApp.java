
package it.bogny.jyugiohdb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.core.config.Configurator;
import it.bogny.jyugiohdb.database.DbCardDbTable;
import it.bogny.jyugiohdb.model.Card;
import it.bogny.jyugiohdb.util.Log;
import it.bogny.jyugiohdb.util.Version;
import it.bogny.jyugiohdb.view.CardOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class
 *
 * @author BoGnY
 */
public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane mainLayout;
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
     * @param primaryStage
     *            the primary stage for this application, onto which the application
     *            scene can be set. The primary stage will be embedded in the
     *            browser if the application was launched as an applet. Applications
     *            may create other stages, if needed, but they will not be primary
     *            stages and will not be embedded in the browser.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("YugiohDb v" + Version.formatVersion());

        initMainLayout();

        showCardOverview();

        ResultSet rs = DbCardDbTable.selectCardDb();
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("cardId") + "\t" + rs.getString("cardNameIT") + "\t" + rs.getString("cardNameEN"));
                cardData.add(new Card(rs.getInt("cardId")));
            }
        } catch (SQLException SQLEx) {
            Log.save("fatal", SQLEx);
            // SQLEx.printStackTrace();
        } catch (Exception Ex) {
            Log.save("fatal", Ex);
            // Ex.printStackTrace();
        }
        // Add some sample data
        /*
         * cardData.add(new Card(4007));
         * cardData.add(new Card(666));
         * cardData.add(new Card(6969));
         * cardData.add(new Card(13191));
         */

    }

    /**
     * Initializes the main layout.
     */
    public void initMainLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/MainLayout.fxml"));
            mainLayout = (BorderPane) fxmlLoader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException IOEx) {
            Log.save("fatal", IOEx);
        }
    }

    /**
     * Shows the card overview inside the main layout.
     */
    public void showCardOverview() {
        try {
            // Load card overview.
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/CardOverview.fxml"));
            AnchorPane cardOverview = (AnchorPane) fxmlLoader.load();

            // Set card overview into the center of main layout.
            mainLayout.setCenter(cardOverview);

            // Give the controller access to the main app.
            CardOverviewController cardOverviewController = fxmlLoader.getController();
            cardOverviewController.setMainApp(this);
        } catch (IOException IOEx) {
            Log.save("fatal", IOEx);
        }
    }

    /**
     * Returns the main stage.
     * 
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * The data as an observable list of Cards.
     */
    public static ObservableList<Card> cardData = FXCollections.observableArrayList();

    /**
     * Main constructor
     */
    public MainApp() {}

    /**
     * Returns the data as an observable list of Cards.
     * 
     * @return
     */
    public ObservableList<Card> getCardData() {
        return cardData;
    }

    /**
     * The main entry point for all Java applications.
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {
        // Set instantly the configuration of log4j2
        Configurator.initialize(null, "config" + fileSeparator + "log4j2.xml");

        // Set immediately the configuration properties of app
        try {
            inputProp = new FileInputStream("config" + fileSeparator + "app.properties");
            configProp.load(inputProp);
        } catch (FileNotFoundException FileNotFoundEx) {
            Log.save("fatal", FileNotFoundEx);
        } catch (IOException IOEx) {
            Log.save("fatal", IOEx);
        }

        launch(args);
    }
}
