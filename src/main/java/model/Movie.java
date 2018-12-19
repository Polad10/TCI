package model;

import java.util.ArrayList;

/**
 * This class extends the abstract Media class and is a blueprint for movie objects.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public class Movie extends Media
{
    private String director;
    private ArrayList<String> writers;
    private ArrayList<String> stars;

    /**
     * This is a Movie constructor.
     * @param director Director of this movie.
     * @param writers Writers of this movie.
     * @param stars Stars of this movie.
     */
    public Movie(String director, ArrayList<String> writers, ArrayList<String> stars)
    {

    }

    /**
     * This method converts this Movie object into json format.
     * @return The Json representation of this Movie object.
     */
    @Override
    public String toJson()
    {
        return null;
    }
}
