package rest_service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * This class processes the REST API calls for the movie resources.
 *
 * @author Ibrahim
 * @version 1.0
 * @since   2018-12-19
 */

@Path("/movies")
public class MovieResource
{
    /**
     * This method makes use of a Spider object to retrieve all the movies from the website.
     * @return All the movies in a json format.
     */
    @GET
    @Produces("application/json")
    public String getAllMovies()
    {
        return null;
    }



    /**
     * This method makes use of a Spider object to retrieve all the movies, which match the required property value, from the website.
     * @param property Movie property to look at.
     * @param value Required movie property value.
     * @return All the movies, that match the requirement, in a json format.
     */
    @Path("/{property}/{value}")
    @GET
    @Produces("application/json")
    public String getMoviesByProperty(@PathParam("property") String property, @PathParam("value") String value)
    {
        return null;
    }
}
