package model;

/**
 * This class extends the abstract Media class and is a blueprint for music objects.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public class Music extends Media
{
    private String artist;

    /**
     * This is a Music constructor.
     * @param artist Artist of this music.
     */
    public Music(String artist)
    {

    }

    /**
     * This method converts this Music object into json format.
     * @return The Json representation of this Music object.
     */
    @Override
    public String toJson()
    {
        return null;
    }
}
