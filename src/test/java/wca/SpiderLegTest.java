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


public class SpiderLegTest
{
    @Test
    public void crawlThrowsPageNotFoundExceptionForInvalidUrl()
    {
        SpiderLeg spiderLeg = new SpiderLeg();

        String URL = "http://i307047.hera.fhict.nl/";
        String Path = "/Users/Bram/TCT/GitHub/Git version2/TCI/src/main/sample_site/index.html";
        Document expectedReturnDocu = Mockito.mock(Document.class);

        Assert.assertEquals(spiderLeg.crawl(Path),expectedReturnDocu);

    }

    @Test
    public void crawlReturnsCorrectDocumentForValidUrl()
    {

    }
}
