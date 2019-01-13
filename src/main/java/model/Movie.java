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
    private String name;
    private String genre;
    private int year;
    private String format;


    /**
     * This is a Movie constructor.
     * @param director Director of this movie.
     * @param writers Writers of this movie.
     * @param stars Stars of this movie.
     */
    public Movie(String name, String genre, String format, int year, String director, ArrayList<String> writers, ArrayList<String> stars)
    {
        this.name = name;
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.director = director;
        this.writers = writers;
        this.stars = stars;
    }

    public String getDirector()
    {
        return director;
    }

    public ArrayList<String> getWriters()
    {
        return writers;
    }

    public ArrayList<String> getStars()
    {
        return stars;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == this)
        {
            return true;
        }

        if(!(o instanceof Movie))
        {
            return false;
        }

        Movie movie = (Movie) o;

        return name.compareTo(movie.name) == 0 &&
                genre.compareTo(movie.genre) == 0 &&
                format.compareTo(movie.format) == 0 &&
                year == movie.year &&
                director.compareTo(movie.director) == 0 &&
                writers.equals(movie.writers) &&
                stars.equals(movie.stars);
    }
}
