package wca;

import java.util.ArrayList;
import org.jsoup.nodes.Document;
import model.Movie;
import model.Book;
import model.Music;

/**
 *This class crawls and scraps the website.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */
public class SpiderLeg
{
    private ArrayList<String> links;
    private Document htmlDocument;

    /**
     * This is a default constructor.
     */
    public SpiderLeg()
    {

    }

    /**
     * This method crawls the website. It makes an HTTP request, checks the response, and then gather up the html page and all the links on the page.
     * @param url The URL to crawl.
     */
    public void crawl(String url)
    {

    }

    /**
     *
     * @return All the links from the last crawled page.
     */
    public ArrayList<String> getLinks()
    {
        return null;
    }

    /**
     * This method scraps the movie details from the last crawled page and creates a Movie object.
     * @return The Movie object.
     */
    public Movie extractMovie()
    {
        return null;
    }

    /**
     * This method scraps the music details from the last crawled page and creates a Music object.
     * @return The Music object.
     */
    public Music extractMusic()
    {
        return null;
    }

    /**
     * This method scraps the book details from the last crawled page and creates a Book object.
     * @return The Book object.
     */
    public Book extractBook()
    {
        return null;
    }
}
