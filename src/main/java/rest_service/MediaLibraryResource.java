package rest_service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
        return null;
    }
}
