package rest_service;

import converter.Converter;
import model.Media;
import wca.Spider;
import wca.SpiderLegException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class processes the REST API calls for the base address.
 *
 * @author Ibrahim
 * @version 1.0
 * @since   2018-12-19
 */

@Path("/")
public class MediaLibraryResource
{
    /**
     * This method makes use of a Spider object to retrieve all the media products from the website.
     * @return All media products in a json format.
     */
    @GET
    @Produces("application/json")
    public String getAllResources()
    {
        try
        {
            Spider spider = new Spider();
            ArrayList<Object> medias = new ArrayList<>(spider.search("http://localhost:10000/"));
            Map<String, Object> searchStat = new HashMap<String, Object>() {{
                put("time_elapsed", spider.getTimeElapsed());
                put("pages_explored", spider.getNrPagesVisited());
                put("search_depth", spider.getSearchDepth());
            }};

            medias.add(searchStat);

            return Converter.toJson(medias);
        }
        catch(SpiderLegException ex)
        {
            return ex.getMessage();
        }
    }
}
