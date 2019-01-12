package converter;

import com.owlike.genson.Genson;
import model.Media;

import java.util.ArrayList;

/**
 * This class converts the media objects into other formats.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public class MediaConverter
{
    /**
     * This method converts the media object into json format.
     * @param mediaObject The media object to convert.
     * @return The Json representation of the media object.
     */
    public static String toJson(Media mediaObject)
    {
        Genson genson = new Genson();
        return genson.serialize(mediaObject);
    }

    /**
     * This method converts the media objects into json format.
     * @param mediaObjects The media objects to convert.
     * @return The Json representation of the media objects.
     */
    public static String toJson(ArrayList<Media> mediaObjects)
    {
        return null;
    }
}
