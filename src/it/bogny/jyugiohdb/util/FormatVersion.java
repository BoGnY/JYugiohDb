/**
 * 
 */

package it.bogny.jyugiohdb.util;

import com.sun.corba.se.impl.util.Version;

/**
 * @author BoGnY
 *
 */
public class FormatVersion {

    /**
     * Returns the application version as a well formatted String.
     * 
     * @return formatted string
     */
    public static String formatVersion() {
        String[] appVersion = Version.VERSION.split("[0-9]");
        String appVersionMajor = appVersion[0];
        String appVersionMinor = appVersion[1];
        String appVersionRevision = appVersion[2];
        String appVersionBuild = appVersion[3];
        if (appVersionRevision != "0") {
            return appVersionMajor + "." + appVersionMinor + "." + appVersionRevision + " build " + appVersionBuild;
        } else {
            return appVersionMajor + "." + appVersionMinor + " build " + appVersionBuild;
        }
    }
}
