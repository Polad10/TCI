package rest_service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * This class processes the REST API calls for the music resources.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

@Path("/musics")
public class MusicResource
{
    /**
     * This method makes use of a Spider object to retrieve all the musics from the website.
     * @return All the musics in a json format.
     */
    @GET
    @Produces("application/json")
    public String getAllMusics()
    {
        return null;
    }

    /**
     * This method makes use of a Spider object to retrieve all the musics, which match the required property value, from the website.
     * @param property Music property to look at.
     * @param value Required music property value.
     * @return All the musics, that match the requirement, in a json format.
     */
    @Path("/{property}/{value}")
    @GET
    @Produces("application/json")
    public String getMusicsByProperty(@PathParam("property") String property, @PathParam("value") String value)
    {
        return null;
    }
}
