package wca;

import org.jsoup.nodes.Document;
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
    public void searchParticularMediaTypeUsesCrawlInSpiderLegWithCorrectArguments()
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        Spider spider = new Spider(spiderLeg);

        spider.search("url", "mediaType");

        verify(spiderLeg).crawl("url");
    }

    @Test
    public void searchParrticularMediaTypeAndMediaPropertyUsesCrawlInSpiderLegWithCorrectArguments()
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        Spider spider = new Spider(spiderLeg);

        spider.search("url", "mediaType", "property", "value");

        verify(spiderLeg).crawl("url");
    }
}
