/**
 * 
 */

package it.bogny.jyugiohdb.util;

import it.bogny.jyugiohdb.MainApp;

/**
 * @author BoGnY
 *
 */
public class Version {
    public static String appVersion = MainApp.configProp.getProperty("specification.version");
    public static String appBuild = MainApp.configProp.getProperty("implementation.version");

    /**
     * Returns the application version as a well formatted String.
     * 
     * @return Formatted version string
     */
    public static String formatVersion() {
        String[] appVersions = appVersion.split("[.]");
        String appVersionMajor = appVersions[0];
        String appVersionMinor = appVersions[1];
        String appVersionRevision = null;
        String appVersionBuild = appBuild;
        try {
            appVersionRevision = appVersions[2];
        } catch (ArrayIndexOutOfBoundsException Ex) {
        } catch (Exception Ex) {
            Log.save("error", Ex);
        }
        if ((appVersionRevision != null) & (appVersionRevision != "0")) {
            return appVersionMajor + "." + appVersionMinor + "." + appVersionRevision + " build " + appVersionBuild;
        } else {
            return appVersionMajor + "." + appVersionMinor + " build " + appVersionBuild;
        }
    }
}
