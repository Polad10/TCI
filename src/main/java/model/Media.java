package model;

/**
 * This is an abstract super class for all concrete media classes.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public abstract class Media
{
    protected String name;
    protected String genre;
    protected String format;
    protected int year;

    public String getName()
    {
        return name;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getFormat()
    {
        return format;
    }

    public int getYear()
    {
        return year;
    }
}


