
package it.bogny.jyugiohdb.view;

import it.bogny.jyugiohdb.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed
 * 
 * @author Marco Jakob
 */
public class MainLayoutController {

    // Reference to the main application
    private MainApp MainApp;

    /**
     * Is called by the main application to give a reference back to itself
     * 
     * @param MainApp
     */
    public void setMainApp(MainApp MainApp) {
        this.MainApp = MainApp;
    }

    /**
     * Close the application
     */
    @FXML
    private void handleClose() {
        System.exit(0);
    }

    /**
     * Update the cards database
     */
    @FXML
    private void handleManageFullDatabaseUpdates() {

    }

    /**
     * Empty the cards database
     */
    @FXML
    private void handleManageFullDatabaseEmpties() {

    }

    /**
     * Open an alert dialog
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("JYugiohDb");
        alert.setHeaderText("About");

        alert.showAndWait();
    }

}
