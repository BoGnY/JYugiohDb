
package it.bogny.jyugiohdb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.bogny.jyugiohdb.database.DbCardDbTable;
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

    /**
     * 
     * 
     * 
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("YugiohDb");

        initRootLayout();

        showCardOverview();

        // DbConnect.dbConnection();

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
     * Main constructor
     */
    public MainApp() {
        // TODO Create SELECT db function and add value to cardData
        ResultSet rs = DbCardDbTable.selectCardDb();
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("cardId") + "\t" + rs.getString("cardNameIT") + "\t" + rs.getString("cardNameEN"));
                cardData.add(new Card(rs.getInt("cardId")));
            }
        } catch (SQLException SQLEx) {
            // TODO Auto-generated catch block
            SQLEx.printStackTrace();
        }
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

    public static void main(String[] args) {
        launch(args);
    }
}
