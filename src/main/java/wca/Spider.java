package wca;

import java.util.ArrayList;
import java.util.HashSet;

import document_extractor.DocumentExtractor;
import model.Book;
import model.Media;
import model.Movie;
import model.Music;
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
     * This constructor sets the spiderLeg, creates documentExtractor without document and initializes other fields.
     * @param spiderLeg SpiderLeg object to set.
     */
    public Spider(SpiderLeg spiderLeg)
    {
        this.spiderLeg = spiderLeg;
        this.documentExtractor = new DocumentExtractor();
        pagesToVisit = new ArrayList<>();
        pagesVisited = new HashSet<>();
    }

    /**
     * This constructor initializes spiderLeg, documentExtractor and other fields.
     * @param spiderLeg SpiderLeg object to set.
     * @param documentExtractor DocumentExtractor object to set.
     */
    public Spider(SpiderLeg spiderLeg, DocumentExtractor documentExtractor)
    {
        this.spiderLeg = spiderLeg;
        this.documentExtractor = documentExtractor;
        pagesToVisit = new ArrayList<>();
        pagesVisited = new HashSet<>();
    }

    /**
     * This constructor sets documentExtractor, creates spiderLeg and initializes other fields.
     * @param documentExtractor DocumentExtractor object to set.
     */
    public Spider(DocumentExtractor documentExtractor)
    {
        this.spiderLeg = new SpiderLeg();
        this.documentExtractor = documentExtractor;
        pagesToVisit = new ArrayList<>();
        pagesVisited = new HashSet<>();
    }

    /**
     * This method searches for all media products.
     * Internally it uses spider leg that makes an HTTP request and parse the response (the web page).
     * @param url The URL to search.
     * @return All media products that were found.
     */
    public ArrayList<Media> search(String url)
    {
        ArrayList<Media> medias = new ArrayList<>();

        do
        {
            if(pagesToVisit.isEmpty())
            {
                crawlLink(url);
            }
            else
            {
                crawlLink(nextUrl());
            }

            Media media = documentExtractor.extractMedia();

            if(media != null && !medias.contains(media))
            {
                medias.add(media);
            }

        } while(pagesVisited.size() < MAX_PAGES_TO_SEARCH && !pagesToVisit.isEmpty());

        return medias;
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
        ArrayList<Media> medias = new ArrayList<>();

        do
        {
            if(pagesToVisit.isEmpty())
            {
                crawlLink(url);
            }
            else
            {
                crawlLink(nextUrl());
            }

            Media media = documentExtractor.extractMedia();

            if(media != null && !medias.contains(media))
            {
                if( (mediaType.equals("book") && media instanceof Book) ||
                    (mediaType.equals("music") && media instanceof Music) ||
                    (mediaType.equals("movie") && media instanceof Movie) )
                {
                    medias.add(media);
                }
            }

        } while(pagesVisited.size() < MAX_PAGES_TO_SEARCH && !pagesToVisit.isEmpty());

        return medias;
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
        ArrayList<Media> medias = new ArrayList<>();

        do
        {
            if(pagesToVisit.isEmpty())
            {
                crawlLink(url);
            }
            else
            {
                crawlLink(nextUrl());
            }

            Media media = documentExtractor.extractMedia();

            if(media != null && !medias.contains(media))
            {
                switch(property)
                {
                    case "name":
                        if(media.getName().toLowerCase().equals(propertyValue.toLowerCase()))
                        {
                            if( (mediaType.equals("book") && media instanceof Book) ||
                                    (mediaType.equals("music") && media instanceof Music) ||
                                    (mediaType.equals("movie") && media instanceof Movie) )
                            {
                                medias.add(media);
                            }
                        }
                        break;
                    case "director":
                        if(mediaType.equals("movie") && media instanceof Movie && ((Movie) media).getDirector().toLowerCase().equals(propertyValue.toLowerCase()))
                        {
                            medias.add(media);
                        }
                        break;
                    case "writer":
                        if(mediaType.equals("movie") && media instanceof Movie && ((Movie) media).getWriters().contains(propertyValue))
                        {
                            medias.add(media);
                        }
                        break;
                    case "star":
                        if(mediaType.equals("movie") && media instanceof Movie && ((Movie) media).getStars().contains(propertyValue))
                        {
                            medias.add(media);
                        }
                        break;
                    case "artist":
                        if(mediaType.equals("music") && media instanceof Music && ((Music) media).getArtist().toLowerCase().equals(propertyValue.toLowerCase()))
                        {
                            medias.add(media);
                        }
                        break;
                    case "author":
                        if(mediaType.equals("book") && media instanceof Book && ((Book) media).getAuthors().contains(propertyValue))
                        {
                            medias.add(media);
                        }
                        break;
                }
            }

        } while(pagesVisited.size() < MAX_PAGES_TO_SEARCH && !pagesToVisit.isEmpty());

        return medias;
    }

    /**
     * This method sets updates the document in documentExtractor by using spiderLeg object
     * and it also retrieves all the links to visit next.
     * @param url URL to crawl.
     */
    private void crawlLink(String url)
    {
        Document document = spiderLeg.crawl(url);
        documentExtractor.setDocument(document);
        ArrayList<String> links = documentExtractor.getLinks();

        for(String link : links)
        {
            if(!pagesVisited.contains(link))
            {
                pagesToVisit.add(link);
            }
        }
    }

    /**
     * This method gets the next URL from the list that has not been visited yet.
     * @return The next URL to visit.
     */
    private String nextUrl()
    {
        String url = pagesToVisit.remove(0);
        pagesVisited.add(url);

        return url;
    }
}
