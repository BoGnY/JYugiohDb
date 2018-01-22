/**
 * 
 */

package it.bogny.jyugiohdb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import it.bogny.jyugiohdb.MainApp;

/**
 * @author BoGnY
 *
 */
public class Misc {
    public static String imagePath;

    /**
     * Download the card image of specified cardId
     * 
     * @param cardId
     *            The id of card used for local image saving
     * @param cardNameEN
     *            The name of card used to identify it on remote server
     * @throws IOException
     */
    public static void downloadCardImage(int cardId, String cardNameEN) throws IOException {
        imagePath = "images" + MainApp.fileSeparator + cardId + ".jpg";
        // ! Check if card image exist, else download it
        if (!new File(imagePath).exists()) {
            try {
                URL imageUrl = new URL("http://yugiohprices.com/api/card_image/" + cardNameEN);
                ReadableByteChannel readableByteChannel = Channels.newChannel(imageUrl.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
                fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                fileOutputStream.close();
                readableByteChannel.close();
                if (new File(imagePath).exists()) {
                    Log.save("debug", "Downloaded image for cardId " + cardId + " correctly!");
                } else {
                    Log.save("debug", "Error while downloading image for cardId " + cardId + "!!");
                }
            } catch (IOException IOEx) {
                Log.save("warn", IOEx);
            }
        }
    }
}
