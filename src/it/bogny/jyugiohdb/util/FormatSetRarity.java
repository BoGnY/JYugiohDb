/**
 * 
 */

package it.bogny.jyugiohdb.util;

/**
 * @author BoGnY
 *
 */
public class FormatSetRarity {
    /**
     * Returns the converted rarity card's set for English cards
     * 
     * @param cardSetRarity
     *            It is the rarity card's set extracted from Konami db English pages
     * @return The code of rarity card's set
     */
    public static String langEn(String cardSetRarity) {
        switch (cardSetRarity) {
            case "Rare":
                return "R";
            case "Starfoil Rare":
                return "R1";
            case "Mosaic Rare":
                return "R2";
            case "Shatter Rare":
                return "R3";
            case "Super Rare":
                return "SR";
            case "Ultra Rare":
                return "UR";
            case "Secret Rare":
                return "SE";
            case "Ultimate Rare":
                return "UL";
            case "Ghost Rare":
                return "GH";
            case "Gold Rare":
                return "GR";
            case "Gold Secret":
                return "GS";
            case "Parallel Rare":
                return "PR";
            case "Limited":
                return "L";
            default:
                return "N";
        }
    }

    /**
     * Returns the converted rarity card's set for Italian cards
     * 
     * @param cardSetRarity
     *            It is the rarity card's set extracted from Konami db Italian pages
     * @return The code of rarity card's set
     */
    public static String langIt(String cardSetRarity) {
        switch (cardSetRarity) {
            case "Rare":
                return "R";
            case "Rare Starfoil":
                return "R1";
            case "Rare Mosaic":
                return "R2";
            case "Rare Shatter":
                return "R3";
            case "Super Rare":
                return "SR";
            case "Ultra Rare":
                return "UR";
            case "Rare Segrete":
                return "SE";
            case "Rare Ultimate":
                return "UL";
            case "Rara Ghost":
                return "GH";
            case "Rare Oro":
                return "GR";
            case "Segrete Oro":
                return "GS";
            case "Rare Parallele":
                return "PR";
            case "Limitate":
                return "L";
            default:
                return "N";
        }
    }
    // TODO Create functions for the other languages

}
