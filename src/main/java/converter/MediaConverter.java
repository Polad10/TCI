package converter;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import model.Book;
import model.Media;
import model.Movie;
import model.Music;

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
    private static Genson genson = new GensonBuilder().useConstructorWithArguments(true).addAlias("book", Book.class).addAlias("music", Music.class).addAlias("movie", Movie.class)
            .useRuntimeType(true).create();
    /**
     * This method converts the media object into json format.
     * @param mediaObject The media object to convert.
     * @return The Json representation of the media object.
     */
    public static String toJson(Media mediaObject)
    {
        return genson.serialize(mediaObject);
    }

    /**
     * This method converts the media objects into json format.
     * @param mediaObjects The media objects to convert.
     * @return The Json representation of the media objects.
     */
    public static String toJson(ArrayList<Media> mediaObjects)
    {
        return genson.serialize(mediaObjects);
    }
}
