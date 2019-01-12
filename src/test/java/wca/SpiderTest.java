package wca;

import document_extractor.DocumentExtractor;
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
    public void searchParticularMediaTypeAndMediaPropertyUsesCrawlInSpiderLegWithCorrectArguments()
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        Spider spider = new Spider(spiderLeg);

        spider.search("url", "mediaType", "property", "value");

        verify(spiderLeg).crawl("url");
    }

    @Test
    public void searchAllMediaUsesSetDocumentInDocumentExtractorWithCorrectArguments()
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        Document document = new Document("url");
        when(spiderLeg.crawl("url")).thenReturn(document);
        spider.search("url");

        verify(documentExtractor).setDocument(document);
    }

    @Test
    public void searchParticularMediaTypeUsesSetDocumentInDocumentExtractorWithCorrectArguments()
    {

        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        Document document = new Document("url");
        when(spiderLeg.crawl("url")).thenReturn(document);
        spider.search("url", "mediaType");

        verify(documentExtractor).setDocument(document);
    }

    @Test
    public void searchParticularMediaTypeAndMediaPropertyUsesSetDocumentInDocumentExtractorWithCorrectArguments()
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        Document document = new Document("url");
        when(spiderLeg.crawl("url")).thenReturn(document);
        spider.search("url", "mediaType", "property", "propertyValue");

        verify(documentExtractor).setDocument(document);
    }

    @Test
    public void searchAllMediaUsesGetLinksInDocumentExtractor()
    {
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(documentExtractor);

        spider.search("url");

        verify(documentExtractor).getLinks();
    }

    @Test
    public void searchParticularMediaTypeUsesGetLinksInDocumentExtractor()
    {
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(documentExtractor);

        spider.search("url", "mediaType");

        verify(documentExtractor).getLinks();
    }

    @Test
    public void searchParticularMediaTypeAndMediaPropertyUsesGetLinksInDocumentExtractor()
    {
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(documentExtractor);

        spider.search("url", "mediaType", "property", "propertyValue");

        verify(documentExtractor).getLinks();
    }

    @Test
    public void searchAllMediaUsesExtractMediaInDocumentExtractor()
    {
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(documentExtractor);

        spider.search("url");

        verify(documentExtractor).extractMedia();
    }

    @Test
    public void searchParticularMediaTypeUsesExtractMediaInDocumentExtractor()
    {
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(documentExtractor);

        spider.search("url", "mediaType");

        verify(documentExtractor).extractMedia();
    }

    @Test
    public void searchParticularMediaTypeAndMediaPropertyUsesExtractMediaInDocumentExtractor()
    {
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(documentExtractor);

        spider.search("url", "mediaType", "property", "propertyValue");

        verify(documentExtractor).extractMedia();
    }
}
