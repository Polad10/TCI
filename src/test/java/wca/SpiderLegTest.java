package wca;
import org.junit.Assert;
import org.junit.Test;


public class SpiderLegTest
{

    @Test
    public void Testing_connection_with_GivingURL_Must_return_true()
    {
        SpiderLeg spiderLeg = new SpiderLeg();

        spiderLeg.crawl("http://i307047.hera.fhict.nl/");

        Assert.assertTrue(spiderLeg.isConnected());


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
