package rest_service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * This class processes the REST API calls for the book resources.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

@Path("/books")
public class BookResource
{
    /**
     * This method makes use of a Spider object to retrieve all the books from the website.
     * @return All the books in a json format.
     */
    @GET
    @Produces("application/json")
    public String getAllBooks()
    {
        return null;
    }

    /**
     * This method makes use of a Spider object to retrieve all the books, which match the required property value, from the website.
     * @param property Book property to look at.
     * @param value Required book property value.
     * @return All the books, that match the requirement, in a json format.
     */
    @Path("/{property}/{value}")
    @GET
    @Produces("application/json")
    public String getBooksByProperty(@PathParam("property") String property, @PathParam("value") String value)
    {
        return null;
    }
}
