/**
 * 
 */

package it.bogny.jyugiohdb.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper functions for handling dates.<br>
 * <br>
 * Original code by Marco Jakob<br>
 * Modified code by BoGnY
 * 
 * @author Marco Jakob {@link <a href="http://code.makery.ch/">(website)</a>}
 * @author BoGnY {@link <a href="http://www.bogny.it/">(website)</a>}
 */
public class DateUtil {
    /**
     * The date pattern that is used for conversion.
     */
    private static final String DATE_PATTERN_GENERIC = "dd/MM/yyyy hh:mm:ss";

    /**
     * The date formatter.
     */
    private static final DateTimeFormatter DATE_FORMATTER_GENERIC = DateTimeFormatter.ofPattern(DATE_PATTERN_GENERIC);

    /**
     * Returns the given date as a well formatted String.<br>
     * The above defined {@link DateUtil#DATE_PATTERN_GENERIC} is used.
     * 
     * @param date
     *            The date to be returned as a string
     * @return Formatted string
     */
    public static String formatGeneric(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER_GENERIC.format(date);
    }

    /**
     * Converts a String in the format of the defined
     * {@link DateUtil#DATE_PATTERN_GENERIC}
     * to a {@link LocalDate} object.<br>
     * 
     * Returns null if the String could not be converted.
     * 
     * @param dateString
     *            The date as String
     * @return The date object or null if it could not be converted
     */
    public static LocalDate parseGeneric(String dateString) {
        try {
            return DATE_FORMATTER_GENERIC.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException DateTimeParseEx) {
            return null;
        }
    }

    /**
     * Checks the String whether it is a valid date.
     * 
     * @param dateString
     *            The date as String
     * @return True if the String is a valid date
     */
    public static boolean validDateGeneric(String dateString) {
        // Try to parse the String.
        return DateUtil.parseGeneric(dateString) != null;
    }

    /**
     * The date pattern that is used for conversion.
     */
    private static final String DATE_PATTERN_SHORT = "yyyyMMdd";

    /**
     * The date formatter.
     */
    private static final DateTimeFormatter DATE_FORMATTER_SHORT = DateTimeFormatter.ofPattern(DATE_PATTERN_SHORT);

    /**
     * Returns the given date as a well formatted String.<br>
     * The above defined {@link DateUtil#DATE_PATTERN_SHORT} is used.
     * 
     * @param date
     *            The date to be returned as a string
     * @return Formatted string
     */
    public static String formatShort(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER_SHORT.format(date);
    }

    /**
     * Converts a String in the format of the defined
     * {@link DateUtil#DATE_PATTERN_SHORT}
     * to a {@link LocalDate} object.<br>
     * 
     * Returns null if the String could not be converted.
     * 
     * @param dateString
     *            The date as String
     * @return The date object or null if it could not be converted
     */
    public static LocalDate parseShort(String dateString) {
        try {
            return DATE_FORMATTER_SHORT.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException DateTimeParseEx) {
            return null;
        }
    }

    /**
     * Checks the String whether it is a valid date.
     * 
     * @param dateString
     *            The date as String
     * @return True if the String is a valid date
     */
    public static boolean validDateShort(String dateString) {
        return DateUtil.parseShort(dateString) != null;
    }

}
