package wca;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *This class crawls the website and deals with HTTP request and responses.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */
public class SpiderLeg
{
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    /**
     * This is a default constructor.
     */
    public SpiderLeg()
    {

    }

    /**
     * This method crawls the website. It makes an HTTP request, checks the response, and then gather up the html page.
     * @param url The URL to crawl.
     * @return The gathered html page.
     */
    public Document crawl(String url)

    {
        return null;
    }
}
