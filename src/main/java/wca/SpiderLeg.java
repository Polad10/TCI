package wca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import model.Movie;
import model.Book;
import model.Music;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

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

    private boolean isConnected = false;

    public boolean isConnected() {
        return isConnected;
    }

    public void crawl(String url)
    {
       //

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
