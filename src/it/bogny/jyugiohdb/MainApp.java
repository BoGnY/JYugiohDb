
package it.bogny.jyugiohdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import it.bogny.jyugiohdb.model.Card;
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
 * Main class for application.
 *
 * @author BoGnY
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("YugiohDb");

        initRootLayout();

        showCardOverview();

        createNewDatabase("yugiohdb.db");

    }

    /**
     * Initializes the main layout.
     */
    public void initRootLayout() {
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
            IOEx.printStackTrace();
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
            IOEx.printStackTrace();
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
    private ObservableList<Card> cardData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        cardData.add(new Card(4007));
        cardData.add(new Card(10200));
        cardData.add(new Card(666));
        cardData.add(new Card(6969));
        cardData.add(new Card(11111));
        cardData.add(new Card(9999));
        cardData.add(new Card(13191));
    }

    /**
     * Returns the data as an observable list of Cards.
     * 
     * @return
     */
    public ObservableList<Card> getCardData() {
        return cardData;
    }

    /**
     * Connect to a sample database
     *
     * @param fileName
     *            the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (id integer PRIMARY KEY, name text NOT NULL, capacity real);";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
