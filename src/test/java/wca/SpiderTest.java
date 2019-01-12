package wca;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class SpiderTest
{
    @Test
    public void searchAllMediaUsesCrawlInSpiderLegWithCorrectArguments()
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        Spider spider = new Spider(spiderLeg);

        spider.search("url");

        verify(spiderLeg).crawl("url");
    }

    @Test
    public void searchForExistentMediaType()
    {

    }

    @Test
    public void searchForNonExistentMediaType()
    {

    }

    @Test
    public void searchForExistentMediaTypeAndExistentPropertyValue()
    {

    }

    @Test
    public void searchForNonExistentMediaTypeAndExistentPropertyValue()
    {

    }

    @Test
    public void searchForExistentMediaTypeAndNonExistentPropertyValue()
    {

    }

    @Test
    public void searchForNonExistentMediaTypeAndNonExistentPropertyValue()
    {

    }
}
