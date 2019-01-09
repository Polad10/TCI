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
     * @param authors Authors of this book.
     * @param publisher Publisher of this book.
     * @param isbn  Unique isbn number of this book.
     */
    public Book(String name, String genre, String format, int year, ArrayList<String> authors, String publisher, String isbn)
    {
        this.name = name;
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public ArrayList<String> getAuthors()
    {
        return authors;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public String getIsbn()
    {
        return isbn;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == this)
        {
            return true;
        }

        if(!(o instanceof Book))
        {
            return false;
        }

        Book book = (Book) o;

        return name.compareTo(book.name) == 0 &&
                genre.compareTo(book.genre) == 0 &&
                format.compareTo(book.format) == 0 &&
                year == book.year &&
                publisher.compareTo(book.publisher) == 0 &&
                isbn.compareTo(book.isbn) == 0 &&
                authors.equals(book.authors);
    }
}
