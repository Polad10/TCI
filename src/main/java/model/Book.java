package model;

import java.util.ArrayList;

/**
 * This class extends the abstract Media class and is a blueprint for book objects.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public class Book extends Media
{
    private ArrayList<String> authors;
    private String publisher;
    private String isbn;

    /**
     * This is a Book constructor.
     * @param authos Authors of this book.
     * @param publisher Publisher of this book.
     * @param isbn  Unique isbn number of this book.
     */
    public Book(ArrayList<String> authos, String publisher, String isbn)
    {

    }

    /**
     * This method converts this Book object into json format.
     * @return The Json representation of this Book object.
     */
    @Override
    public String toJson()
    {
        return null;
    }
}
