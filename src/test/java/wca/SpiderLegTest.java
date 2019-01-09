package wca;
import model.Book;
import model.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;


public class SpiderLegTest
{

    @Test
    public void Testing_connection_with_GivingURL_Must_return_true() throws CustomException {
        SpiderLeg spiderLeg = new SpiderLeg();

        spiderLeg.crawl("http://i307047.hera.fhict.nl/");

        Assert.assertTrue(spiderLeg.isConnected());

    }



    @Test (expected = CustomException.class)
    public void If_URL_IS_NULL_MUST_Give_exceptions() throws CustomException {
        SpiderLeg spiderLeg = new SpiderLeg();

        spiderLeg.crawl("");

    }

    @Test
    public void Test_if_WeGot_All_Link_In_TheGivingURL()throws CustomException
    {
        SpiderLeg spiderLeg = new SpiderLeg();

        spiderLeg.crawl("http://i307047.hera.fhict.nl/");

        Assert.assertEquals(spiderLeg.getLinks().size(), 11);

    }


    @Test
    public void extractExistentMovieFromDocument()throws CustomException
    {
        SpiderLeg spiderLeg = new SpiderLeg();
        spiderLeg.crawl("http://i307047.hera.fhict.nl/");

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> stars = new ArrayList<>();
        String director = "Test";
        Movie  movie = new Movie(director,list,stars);

        Assert.assertEquals(spiderLeg.extractMovie(),movie);


    }

    @Test
    public void extractNonExistentMovieFromDocument()
    {

    }

    @Test
    public void extractExistentMusicFromDocument()
    {

    }

    @Test
    public void extractNonExistentMusicFromDocument()
    {

    }

    @Test
    public void extractExistentBookFromDocument()
    {

    }

    @Test
    public void extractNonExistentBookFromDocument()
    {

    }
}
