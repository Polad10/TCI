package wca;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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

    private Document htmlDocument ;
    private ArrayList<String> links;
    private URL validURL = null;
    private boolean notValidUrl = false;

    /**
     * This is a default constructor.
     */
    public SpiderLeg()
    {
        links = new ArrayList<>();

    }

    /**
     * This method crawls the website. It makes an HTTP request, checks the response, and then gather up the html page.
     * @param url The URL to crawl.
     * @return The gathered html page.
     */
    public Document crawl(String url) throws SpiderLegException

    {
        if (url=="")
        {
            throw new SpiderLegException ("URL IS INVALID!");
        }

        else
        {
            try
            {
                validURL = new URL(url);
                Connection connection = Jsoup.connect(validURL.toString()).userAgent(USER_AGENT);
                Document htmlDocument = connection.get();
                this.htmlDocument = htmlDocument;
                notValidUrl= true;

            }
            catch(IOException ioe)
            {
                System.out.println("Error in out HTTP request " + ioe);
            }

        }

        if (notValidUrl== false)
        {
            Path path = Paths.get(url);
            File input = new File(String.valueOf(path));
            Document document = null;
            try
            {
                document = Jsoup.parse(input, "UTF-8");
                this.htmlDocument = document;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }



        return htmlDocument;
    }
}
