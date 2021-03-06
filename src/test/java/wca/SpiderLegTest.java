package wca;
import model.Book;
import model.Media;
import model.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import javax.swing.text.Document;
import java.util.ArrayList;


public class SpiderLegTest {


    @Test(expected = SpiderLegException.class)
    public void crawlThrowsPageNotFoundExceptionForInvalidUrl() throws SpiderLegException {
        SpiderLeg spiderLeg = new SpiderLeg();

        String URL = "";
        String Path = "src/main/sample_site/index.html";

        spiderLeg.crawl(URL);
    }



    @Test
    public void crawlReturnsCorrectDocumentForValidUrl() throws SpiderLegException
    {
        SpiderLeg spiderLeg = new SpiderLeg();

        String URL = "http://i307047.hera.fhict.nl/";
        String Path = "src/main/sample_site/index.html";

        Assert.assertNotNull(spiderLeg.crawl(URL));
    }


}
