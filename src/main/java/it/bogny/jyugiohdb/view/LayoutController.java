
package it.bogny.jyugiohdb.view;

import it.bogny.jyugiohdb.MainApp;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 *
 * @author BoGnY
 *
 */
public class LayoutController {
    /**
     * Holder of a switchable layout.
     */
    @FXML
    private AnchorPane layoutHolder;

    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Replaces the layout displayed in the layout holder with a new layout.
     *
     * @param layoutNode
     *            The layout node to be swapped in.
     */
    public void setLayout(Node layoutNode) {
        layoutHolder.getChildren().setAll(layoutNode);
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
