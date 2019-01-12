package wca;

import document_extractor.DocumentExtractor;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import model.Book;
import model.Media;
import model.Movie;
import model.Music;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    @Parameters(method = "fiveMixedTypeMediaProvider")
    public void searchAllMediaReturnsAllNonDuplicateMediaReceivedFromDocumentExtractor(List<Media> mediaList)
    {
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(documentExtractor);

        when(documentExtractor.getLinks()).thenReturn(new ArrayList<>(Arrays.asList("url1", "url2", "url3", "url4", "url5", "url6")));
        when(documentExtractor.extractMedia()).thenReturn(mediaList.get(0)).thenReturn(mediaList.get(1)).thenReturn(mediaList.get(2)).thenReturn(mediaList.get(3))
                .thenReturn(mediaList.get(4)).thenReturn(mediaList.get(1));

        ArrayList<Media> actualMedias = spider.search("url");

        Assert.assertEquals(mediaList, actualMedias);
    }

    private Object[] fiveMixedTypeMediaProvider()
    {
        Book book1 = new Book("name1", "genre1", "format1", 1, new ArrayList<>(Collections.singletonList("author1")), "publisher1", "isbn1");
        Book book2 = new Book("name2", "genre2", "format2", 1, new ArrayList<>(Collections.singletonList("author2")), "publisher2", "isbn2");
        Music music1 = new Music("name1", "genre1", "format1", 1, "artist1");
        Music music2 = new Music("name2", "genre2", "format2", 2, "artist2");
        Movie movie1 = new Movie("name1", "genre1", "format1", 1, "director1", new ArrayList<>(Arrays.asList("writer1", "writer2")), new ArrayList<>(Arrays.asList("star1", "star2")));

        return new Object[] {Arrays.asList(book1, book2, music1, music2, movie1)};
    }
}
