
package it.bogny.jyugiohdb.view;

import java.io.IOException;
import it.bogny.jyugiohdb.MainApp;
import it.bogny.jyugiohdb.util.Log;
import it.bogny.jyugiohdb.util.LogType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Utility class for controlling navigation between layouts.<br>
 * <br>
 * All methods on the navigator are static to facilitate simple access
 * from anywhere in the application.<br>
 * <br>
 * Based on jewelsea vista navigator
 * {@link https://gist.github.com/jewelsea/6460130}
 *
 * @author BoGnY
 */
public class LayoutSwitcher {
    private static MainApp mainApp;
    /**
     * Convenience constants for fxml layouts managed by the switcher.
     */
    public static final String MAIN = "it/bogny/jyugiohdb/view/MainLayout.fxml";
    public static final String CARD_OVERVIEW = "it/bogny/jyugiohdb/view/CardOverview.fxml";
    // public static final String OTHER_OVERVIEW = "";
    /**
     * The main application layout controller.
     */
    private static LayoutController layoutController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param layoutController
     *            The main application layout controller.
     */
    public static void setMainController(LayoutController layoutController) {
        LayoutSwitcher.layoutController = layoutController;
    }

    /**
     * Loads the layout specified by the fxml file into the layoutHolder AnchorPane
     * of the main application layout.
     *
     * @param layoutFxml
     *            The fxml file to be loaded.
     */
    public static void loadLayout(String layoutFxml) {
        try {
            layoutController.setLayout(FXMLLoader.load(ClassLoader.getSystemResource(layoutFxml)));
        } catch (IOException IOEx) {
            Log.save(LogType.FATAL, IOEx);
        }
    }

    /**
     * Loads the main fxml layout. Sets up the layout switching LayoutSwitcher.<br>
     * Loads the first layout into the fxml layout.
     *
     * @return The loaded pane.
     *
     * @throws IOException
     *             If the pane could not be loaded.
     */
    public static Pane loadMainPane() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();

        Pane mainPane = (Pane) fxmlLoader.load(ClassLoader.getSystemResourceAsStream(LayoutSwitcher.MAIN));

        LayoutController layoutController = fxmlLoader.getController();
        layoutController.setMainApp(mainApp);

        LayoutSwitcher.setMainController(layoutController);
        LayoutSwitcher.loadLayout(LayoutSwitcher.CARD_OVERVIEW);

        return mainPane;
    }

    /**
     * Creates the main application scene.
     *
     * @param mainPane
     *            The main application layout.
     *
     * @return The created scene.
     */
    public static Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().setAll(ClassLoader.getSystemResource("it/bogny/jyugiohdb/css/application.css").toExternalForm());

        return scene;
    }

}
