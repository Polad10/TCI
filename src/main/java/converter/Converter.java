package converter;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import model.Book;
import model.Media;
import model.Movie;
import model.Music;

import java.util.ArrayList;

/**
 * This class converts the objects into other formats.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public class Converter
{
    private static Genson genson = new GensonBuilder().useConstructorWithArguments(true).addAlias("book", Book.class).addAlias("music", Music.class).addAlias("movie", Movie.class)
            .useRuntimeType(true).create();
    /**
     * This method converts the object into json format.
     * @param object The object to convert.
     * @return The Json representation of the object.
     */
    public static String toJson(Object object)
    {
        return genson.serialize(object);
    }

    /**
     * This method converts the objects into json format.
     * @param objects The objects to convert.
     * @return The Json representation of the objects.
     */
    public static String toJson(ArrayList<Object> objects)
    {
        return genson.serialize(objects);
    }
}
