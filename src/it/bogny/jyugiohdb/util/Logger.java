
package it.bogny.jyugiohdb.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @author BoGnY
 *
 */
public class Logger {

    /**
     * Log all infos on txt file (user mainly for bugs resolution)
     * 
     * @param logType
     *            string of log type
     * @param Ex
     *            exception object
     * 
     */
    public void Log(String logType, Exception Ex) {
        try {
            String exClass = Ex.getClass().getName();
            String exString = Ex.getMessage();
            LocalDate currentLocalDate = LocalDate.now();
            String logFileName = DateUtil.formatGeneric(currentLocalDate);
            // String exStack = Ex.printStackTrace().toString();
            File logFile = new File("logs\\" + logFileName + ".txt");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(logFile.getName(), true);
            BufferedWriter bufferWriterFile = new BufferedWriter(fileWritter);
            switch (logType) {
                case "info":
                    bufferWriterFile.write(DateUtil.formatGeneric(currentLocalDate) + "  |  INFO: (" + exClass + ") " + exString);
                case "err":
                    bufferWriterFile.write(DateUtil.formatGeneric(currentLocalDate) + "  |  ERROR: (" + exClass + ") " + exString);// + "STACK TRACE:
                                                                                                                                   // " );
            }
            bufferWriterFile.close();
        } catch (IOException IOEx) {
            IOEx.printStackTrace();
        }

    }
}
