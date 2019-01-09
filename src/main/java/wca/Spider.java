package wca;

import java.util.ArrayList;
import java.util.HashSet;
import model.Media;

/**
 *This class provides an interface for retrieving the necessary products from the website.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public class Spider
{
    private static final int MAX_PAGES_TO_SEARCH = 20;
    private HashSet<String> pagesVisited;
    private ArrayList<String> pagesToVisit;

    /**
     * This is a default constructor.
     */
    public Spider()
    {

    }

    /**
     * This method searches for all media products.
     * Internally it creates spider legs that make an HTTP request and parse the response (the web page).
     * @param url The URL to search.
     * @return All media products that were found.
     */
    public ArrayList<Media> search(String url)

    {
        while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
        {
            String currentUrl;
            SpiderLeg leg = new SpiderLeg();
            if(this.pagesToVisit.isEmpty())
            {
                currentUrl = url;
                this.pagesVisited.add(url);
            }
            else
            {
                currentUrl = this.nextUrl();
            }

            try
            {
                leg.crawl (currentUrl);
            } catch (CustomException e) {
                e.printStackTrace();
            }
            leg.extractMovie();
            this.pagesToVisit.addAll(leg.getLinks());
        }
        System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
    }

    /**
     * This method searches for a particular type of media products.
     * Internally it creates spider legs that make an HTTP request and parse the response (the web page).
     * @param url The URL to search.
     * @param mediaType The media type to search for.
     * @return All media products that were found.
     */
    public ArrayList<Media> search(String url, String mediaType)
    {
        return null;
    }

    /**
     * This method searches for a particular type of media products and with a specific property value.
     * Internally it creates spider legs that make an HTTP request and parse the response (the web page).
     * @param url The URL to search.
     * @param mediaType The media type to search for.
     * @param property Specific property to look at.
     * @param propertyValue The value of the specific property to look for in the products.
     * @return All media products that were found.
     */
    public ArrayList<Media> search(String url, String mediaType, String property, String propertyValue)
    {
        return null;
    }

    /**
     * This method gets the next URL from the list that has not been visited yet.
     * @return The next URL to visit.
     */
    private String nextUrl()
    {
        return null;
    }
}
