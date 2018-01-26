
package it.bogny.jyugiohdb.util;

/**
 * @author BoGnY
 *
 */
public enum LogType {
    TRACE("TRACE"), DEBUG("DEBUG"), WARN("WARN"), ERROR("ERROR"), FATAL("FATAL");
    /**
     * It's the log type, and <b>MUST BE</b> an element of this
     * array [TRACE, DEBUG, WARN, ERROR, FATAL].
     */
    private final String logType;

    private LogType(String logType) {
        this.logType = logType;
    }

    public String getLogType() {
        return logType;
    }

}
