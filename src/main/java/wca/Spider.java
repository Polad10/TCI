package wca;

import java.util.ArrayList;
import java.util.HashSet;

import document_extractor.DocumentExtractor;
import model.Media;
import org.jsoup.nodes.Document;

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
    private SpiderLeg spiderLeg;
    private DocumentExtractor documentExtractor;

    /**
     * This is a default constructor.
     */
    public Spider()
    {

    }

    /**
     * This constructor sets the spiderLeg and creates documentExtractor without document.
     * @param spiderLeg SpiderLeg object to set.
     */
    public Spider(SpiderLeg spiderLeg)
    {
        this.spiderLeg = spiderLeg;
        this.documentExtractor = new DocumentExtractor();
    }

    /**
     * This constructor initializes spiderLeg and documentExtractor.
     * @param spiderLeg SpiderLeg object to set.
     * @param documentExtractor DocumentExtractor object to set.
     */
    public Spider(SpiderLeg spiderLeg, DocumentExtractor documentExtractor)
    {
        this.spiderLeg = spiderLeg;
        this.documentExtractor = documentExtractor;
    }

    /**
     * This constructor sets documentExtractor and creates spiderLeg.
     * @param documentExtractor DocumentExtractor object to set.
     */
    public Spider(DocumentExtractor documentExtractor)
    {
        this.spiderLeg = new SpiderLeg();
        this.documentExtractor = documentExtractor;
    }

    /**
     * This method searches for all media products.
     * Internally it uses spider leg that makes an HTTP request and parse the response (the web page).
     * @param url The URL to search.
     * @return All media products that were found.
     */
    public ArrayList<Media> search(String url)
    {
        Document document = spiderLeg.crawl(url);
        documentExtractor.setDocument(document);
        ArrayList<String> links = documentExtractor.getLinks();
        Media media = documentExtractor.extractMedia();

        return null;
    }

    /**
     * This method searches for a particular type of media products.
     * Internally it uses spider leg that makes an HTTP request and parse the response (the web page).
     * @param url The URL to search.
     * @param mediaType The media type to search for.
     * @return All media products that were found.
     */
    public ArrayList<Media> search(String url, String mediaType)
    {
        Document document = spiderLeg.crawl(url);
        documentExtractor.setDocument(document);
        ArrayList<String> links = documentExtractor.getLinks();
        Media media = documentExtractor.extractMedia();

        return null;
    }

    /**
     * This method searches for a particular type of media products and with a specific property value.
     * Internally it uses spider leg that makes an HTTP request and parse the response (the web page).
     * @param url The URL to search.
     * @param mediaType The media type to search for.
     * @param property Specific property to look at.
     * @param propertyValue The value of the specific property to look for in the products.
     * @return All media products that were found.
     */
    public ArrayList<Media> search(String url, String mediaType, String property, String propertyValue)
    {
        Document document = spiderLeg.crawl(url);
        documentExtractor.setDocument(document);
        ArrayList<String> links = documentExtractor.getLinks();
        Media media = documentExtractor.extractMedia();

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
