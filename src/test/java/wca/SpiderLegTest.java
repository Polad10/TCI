package wca;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


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
    public void extractExistentMovieFromDocument()
    {

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
