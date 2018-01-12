
package it.bogny.jyugiohdb.util;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import it.bogny.jyugiohdb.MainApp;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @author BoGnY
 *
 */
public class Log {
    public static Logger logger = LogManager.getLogger(MainApp.class);

    /**
     * Initialize log function with package {@link org.apache.logging.log4j.Logger}
     * and call {@link #alert(Exception, boolean)} if logType param isn't "trace" or
     * "debug", to show the error message to the user
     * 
     * @param logType
     *            The type of logs, <b>MUST BE</b> one of this:
     *            "<i>trace</i>", "<i>debug</i>", "<i>warn</i>", "<i>error</i>",
     *            "<i>fatal</i>"
     * @param Ex
     *            The Exception to save on log file
     */
    public static void save(String logType, Exception Ex) {
        String stackTraceText = "";
        for (StackTraceElement stackTraceElement : Ex.getStackTrace()) {
            stackTraceText = stackTraceText + stackTraceElement.toString() + MainApp.lineSeparator + "    ";
        }
        switch (logType) {
            case "trace":
                logger.trace(stackTraceText);
                break;
            case "debug":
                logger.debug(stackTraceText);
                break;
            case "warn":
                logger.warn(stackTraceText);
                alert(Ex, false);
                break;
            case "error":
                logger.error(stackTraceText);
                alert(Ex, false);
                break;
            case "fatal":
                logger.fatal(stackTraceText);
                alert(Ex, true);
                break;
            default:
                break;
        }
    }

    /**
     * Initialize log function with package {@link org.apache.logging.log4j.Logger}
     * and call {@link #alert(String, boolean)} if logType param isn't "trace" or
     * "debug", to show the error message to the user
     * 
     * @param logType
     *            The type of logs, <b>MUST BE</b> one of this:
     *            "<i>trace</i>", "<i>debug</i>", "<i>warn</i>", "<i>error</i>",
     *            "<i>fatal</i>"
     * @param message
     *            The message to save on log file
     */
    public static void save(String logType, String message) {
        switch (logType) {
            case "trace":
                logger.trace(message);
                break;
            case "debug":
                logger.debug(message);
                break;
            case "warn":
                logger.warn(message);
                alert(message, false);
                break;
            case "error":
                logger.error(message);
                alert(message, false);
                break;
            case "fatal":
                logger.fatal(message);
                alert(message, true);
                break;
            default:
                break;
        }
    }

    /**
     * 
     * @param Ex
     *            The Exception to extract class name, message and stack trace to
     *            show exception infos to the user
     * @param close
     *            A boolean to determine whether to close the application
     */
    public static void alert(Exception Ex, boolean close) {
        String stackTraceText = "";
        for (StackTraceElement stackTraceElement : Ex.getStackTrace()) {
            stackTraceText = stackTraceText + stackTraceElement.toString() + MainApp.lineSeparator + "    ";
        }
        Alert alert = new Alert(AlertType.ERROR);
        alert.initOwner(null);
        alert.setTitle("ERROR");
        alert.setHeaderText(Ex.getMessage());
        alert.setContentText("A serious error has occurred so, please, go to the project page https://github.com/BoGnY/JYugiohDB and open a new issue, describe your problem and attach this log file on report: /log/log-" + DateUtil.formatShort(LocalDate.now()) + ".log" + MainApp.lineSeparator + MainApp.lineSeparator + "Please past even this stack trace: " + MainApp.lineSeparator + stackTraceText + MainApp.lineSeparator + MainApp.lineSeparator + "Thanks," + MainApp.lineSeparator + "BoGnY");
        alert.showAndWait();
        if (close) {
            System.exit(1);
        }
    }

    /**
     * 
     * @param message
     *            The message for show error infos to the user
     * @param close
     *            A boolean to determine whether to close the application
     */
    public static void alert(String message, boolean close) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.initOwner(null);
        alert.setTitle("ERROR");
        alert.setHeaderText(message);
        alert.setContentText("A serious error has occurred so, please, go to the project page https://github.com/BoGnY/JYugiohDB and open a new issue, describe your problem and attach this log file on report: /log/log-" + DateUtil.formatShort(LocalDate.now()) + ".log" + MainApp.lineSeparator + MainApp.lineSeparator + "Thanks," + MainApp.lineSeparator + "BoGnY");
        alert.showAndWait();
        if (close) {
            System.exit(1);
        }
    }
}
