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
    public static String appMajor = MainApp.configProp.getProperty("VERSION_MAJOR");
    public static String appMinor = MainApp.configProp.getProperty("VERSION_MINOR");
    public static String appRevision = MainApp.configProp.getProperty("VERSION_PATCH");
    public static String appPreRelease = MainApp.configProp.getProperty("VERSION_PRERELEASE");
    public static String appBuild = MainApp.configProp.getProperty("VERSION_BUILD");

    /**
     * Returns the application version as a well formatted String.
     * 
     * @return Formatted version string
     */
    public static String formatVersion() {
        String appVersionMajor = appMajor;
        String appVersionMinor = appMinor;
        String appVersionRevision = appRevision;
        String appVersionPreRelease = appPreRelease;
        String appVersionBuild = appBuild;

        if (!appPreRelease.equals("")) {
            appVersionPreRelease = "-" + appPreRelease;
        }

        if ((appVersionRevision != null) & (!appVersionRevision.equals("0"))) {
            return appVersionMajor + "." + appVersionMinor + "." + appVersionRevision + appVersionPreRelease + " build " + appVersionBuild;
        } else {
            return appVersionMajor + "." + appVersionMinor + appVersionPreRelease + " build " + appVersionBuild;
        }
    }
}
