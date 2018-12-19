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

    /**
     * This method must be overwritten by inherited classes.
     * @return The Json representation of this object.
     */
    public abstract String toJson();
}
