package wca;

import document_extractor.DocumentExtractor;
import document_extractor.DocumentExtractorExceptions;
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
    public void searchAllMediaUsesCrawlInSpiderLegWithCorrectArguments() throws SpiderLegException
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url");

        verify(spiderLeg).crawl("url");
    }

    @Test
    public void searchParticularMediaTypeUsesCrawlInSpiderLegWithCorrectArguments() throws SpiderLegException
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url", "mediaType");

        verify(spiderLeg).crawl("url");
    }

    @Test
    public void searchParticularMediaTypeAndMediaPropertyUsesCrawlInSpiderLegWithCorrectArguments() throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url", "mediaType", "property", "value");

        verify(spiderLeg).crawl("url");
    }

    @Test
    public void searchAllMediaUsesSetDocumentInDocumentExtractorWithCorrectArguments() throws SpiderLegException
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
    public void searchParticularMediaTypeUsesSetDocumentInDocumentExtractorWithCorrectArguments() throws SpiderLegException
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
    public void searchParticularMediaTypeAndMediaPropertyUsesSetDocumentInDocumentExtractorWithCorrectArguments() throws SpiderLegException
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
    public void searchAllMediaUsesGetLinksInDocumentExtractor() throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url");

        verify(documentExtractor).getLinks();
    }

    @Test
    public void searchParticularMediaTypeUsesGetLinksInDocumentExtractor() throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url", "mediaType");

        verify(documentExtractor).getLinks();
    }

    @Test
    public void searchParticularMediaTypeAndMediaPropertyUsesGetLinksInDocumentExtractor() throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url", "mediaType", "property", "propertyValue");

        verify(documentExtractor).getLinks();
    }

    @Test
    public void searchAllMediaUsesExtractMediaInDocumentExtractor() throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url");

        verify(documentExtractor).extractMedia();
    }

    @Test
    public void searchParticularMediaTypeUsesExtractMediaInDocumentExtractor() throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url", "mediaType");

        verify(documentExtractor).extractMedia();
    }

    @Test
    public void searchParticularMediaTypeAndMediaPropertyUsesExtractMediaInDocumentExtractor() throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        spider.search("url", "mediaType", "property", "propertyValue");

        verify(documentExtractor).extractMedia();
    }

    @Test
    @Parameters(method = "fiveMixedTypeMediaProvider")
    public void searchAllMediaReturnsAllNonDuplicateMediaReceivedFromDocumentExtractor(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        when(documentExtractor.getLinks()).thenReturn(new ArrayList<>(Arrays.asList("url1", "url2", "url3", "url4", "url5", "url6")));
        when(documentExtractor.extractMedia()).thenReturn(mediaList.get(0)).thenReturn(mediaList.get(1)).thenReturn(mediaList.get(2)).thenReturn(mediaList.get(3))
                .thenReturn(mediaList.get(4)).thenReturn(mediaList.get(1));

        ArrayList<Media> actualMedias = spider.search("url");

        Assert.assertEquals(mediaList, actualMedias);
    }

    @Test
    @Parameters(method = "fiveSingleTypeMediaProvider")
    public void searchParticularMediaTypeReturnsAllNonDuplicateMediaReceivedFromDocumentExtractor(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        when(documentExtractor.getLinks()).thenReturn(new ArrayList<>(Arrays.asList("url1", "url2", "url3", "url4", "url5", "url6")));
        when(documentExtractor.extractMedia()).thenReturn(mediaList.get(0)).thenReturn(mediaList.get(1)).thenReturn(mediaList.get(2)).thenReturn(mediaList.get(3))
                .thenReturn(mediaList.get(4)).thenReturn(mediaList.get(1));

        String mediaType;

        if(mediaList.get(0) instanceof Book)
        {
            mediaType = "book";
        }
        else if(mediaList.get(0) instanceof Music)
        {
            mediaType = "music";
        }
        else
        {
            mediaType = "movie";
        }

        ArrayList<Media> actualMedias = spider.search("url", mediaType);

        Assert.assertEquals(mediaList, actualMedias);
    }

    @Test
    @Parameters(method = "oneOfEachMediaTypeProvider")
    public void searchBookMediaTypeReturnsAllBooksAndIgnoresOtherMediaTypesReceivedFromDocumentExtractor(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        searchParticularMediaTypeReturnsAllRequiredMediaTypesAndIgnoresOtherMediaTypesReceivedFromDocumentExtractor(mediaList.get(0), mediaList, "book");
    }

    @Test
    @Parameters(method = "oneOfEachMediaTypeProvider")
    public void searchMusicMediaTypeReturnsAllMusicsAndIgnoresOtherMediaTypesReceivedFromDocumentExtractor(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        searchParticularMediaTypeReturnsAllRequiredMediaTypesAndIgnoresOtherMediaTypesReceivedFromDocumentExtractor(mediaList.get(1), mediaList, "music");
    }

    @Test
    @Parameters(method = "oneOfEachMediaTypeProvider")
    public void searchMovieMediaTypeReturnsAllMoviesAndIgnoresOtherMediaTypesReceivedFromDocumentExtractor(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        searchParticularMediaTypeReturnsAllRequiredMediaTypesAndIgnoresOtherMediaTypesReceivedFromDocumentExtractor(mediaList.get(2), mediaList, "movie");
    }

    private void searchParticularMediaTypeReturnsAllRequiredMediaTypesAndIgnoresOtherMediaTypesReceivedFromDocumentExtractor(Media particularMedia, List<Media> allMedias, String particularType)
            throws SpiderLegException, DocumentExtractorExceptions
    {
        ArrayList<Media> expectedMedias = new ArrayList<>(Arrays.asList(particularMedia));

        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        when(documentExtractor.getLinks()).thenReturn(new ArrayList<>(Arrays.asList("url1", "url2")));
        when(documentExtractor.extractMedia()).thenReturn(allMedias.get(0), allMedias.get(1), allMedias.get(2));

        ArrayList<Media> actualMedias = spider.search("url", particularType);

        Assert.assertEquals(expectedMedias, actualMedias);
    }

    @Test
    @Parameters(method = "oneOfEachMediaTypeProvider")
    public void searchBooksWithParticularBookPropertyReturnsAllNonDuplicateBooksWithRequiredProperty(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        Media expectedMedia = mediaList.get(0);
        String particularType = "book";
        String property = "name";
        String propertyValue = mediaList.get(0).getName();

        searchParticularMediaTypeAndMediaPropertyReturnsAllNonDuplicateMediaWithRequiredPropertyReceivedFromDocumentExtractor(mediaList, Arrays.asList(expectedMedia), particularType, property, propertyValue);
    }

    @Test
    @Parameters(method = "oneOfEachMediaTypeProvider")
    public void searchMusicsWithParticularMusicPropertyReturnsAllNonDuplicateMusicsWithRequiredProperty(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        Media expectedMedia = mediaList.get(1);
        String particularType = "music";
        String property = "artist";
        String propertyValue = ((Music)mediaList.get(1)).getArtist();

        searchParticularMediaTypeAndMediaPropertyReturnsAllNonDuplicateMediaWithRequiredPropertyReceivedFromDocumentExtractor(mediaList, Arrays.asList(expectedMedia), particularType, property, propertyValue);
    }

    @Test
    @Parameters(method = "oneOfEachMediaTypeProvider")
    public void searchMoviesWithParticularMoviePropertyReturnsAllNonDuplicateMoviesWithRequiredProperty(List<Media> mediaList) throws SpiderLegException, DocumentExtractorExceptions
    {
        Media expectedMedia = mediaList.get(2);
        String particularType = "movie";
        String property = "writer";
        String propertyValue = ((Movie)mediaList.get(2)).getWriters().get(0);

        searchParticularMediaTypeAndMediaPropertyReturnsAllNonDuplicateMediaWithRequiredPropertyReceivedFromDocumentExtractor(mediaList, Arrays.asList(expectedMedia), particularType, property, propertyValue);
    }

    private void searchParticularMediaTypeAndMediaPropertyReturnsAllNonDuplicateMediaWithRequiredPropertyReceivedFromDocumentExtractor(List<Media> allMedias, List<Media> expectedMedias,
                                                                                                                                       String particularType, String property, String propertyValue)
                                                                                                                                        throws SpiderLegException, DocumentExtractorExceptions
    {
        SpiderLeg spiderLeg = mock(SpiderLeg.class);
        DocumentExtractor documentExtractor = mock(DocumentExtractor.class);
        Spider spider = new Spider(spiderLeg, documentExtractor);

        when(documentExtractor.getLinks()).thenReturn(new ArrayList<>(Arrays.asList("url1", "url2", "url3", "url4", "url5")));
        when(documentExtractor.extractMedia()).thenReturn(allMedias.get(0), allMedias.get(0), allMedias.get(1), allMedias.get(1), allMedias.get(2), allMedias.get(2));

        List<Media> actualMedias = spider.search("url", particularType, property, propertyValue);

        Assert.assertEquals(expectedMedias, actualMedias);
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

    private Object[] fiveSingleTypeMediaProvider()
    {
        Book book1 = new Book("name1", "genre1", "format1", 1, new ArrayList<>(Collections.singletonList("author1")), "publisher1", "isbn1");
        Book book2 = new Book("name2", "genre2", "format2", 1, new ArrayList<>(Collections.singletonList("author2")), "publisher2", "isbn2");
        Book book3 = new Book("name3", "genre3", "format3", 1, new ArrayList<>(Collections.singletonList("author3")), "publisher3", "isbn3");
        Book book4 = new Book("name4", "genre4", "format4", 1, new ArrayList<>(Collections.singletonList("author4")), "publisher4", "isbn4");
        Book book5 = new Book("name5", "genre5", "format5", 1, new ArrayList<>(Collections.singletonList("author5")), "publisher5", "isbn5");

        Music music1 = new Music("name1", "genre1", "format1", 1, "artist1");
        Music music2 = new Music("name2", "genre2", "format2", 2, "artist2");
        Music music3 = new Music("name3", "genre3", "format3", 2, "artist3");
        Music music4 = new Music("name4", "genre4", "format4", 2, "artist4");
        Music music5 = new Music("name5", "genre5", "format5", 2, "artist5");

        Movie movie1 = new Movie("name1", "genre1", "format1", 1, "director1", new ArrayList<>(Arrays.asList("writer1", "writer2")), new ArrayList<>(Arrays.asList("star1", "star6")));
        Movie movie2 = new Movie("name2", "genre2", "format2", 1, "director2", new ArrayList<>(Arrays.asList("writer3", "writer4")), new ArrayList<>(Arrays.asList("star2", "star7")));
        Movie movie3 = new Movie("name3", "genre3", "format3", 1, "director3", new ArrayList<>(Arrays.asList("writer5", "writer6")), new ArrayList<>(Arrays.asList("star3", "star8")));
        Movie movie4 = new Movie("name4", "genre4", "format4", 1, "director4", new ArrayList<>(Arrays.asList("writer7", "writer8")), new ArrayList<>(Arrays.asList("star4", "star9")));
        Movie movie5 = new Movie("name5", "genre5", "format5", 1, "director5", new ArrayList<>(Arrays.asList("writer9", "writer10")), new ArrayList<>(Arrays.asList("star5", "star10")));

        return new Object[] { Arrays.asList(book1, book2, book3, book4, book5),
                Arrays.asList(music1, music2, music3, music4, music5),
                Arrays.asList(movie1, movie2, movie3, movie4, movie5) };
    }

    private Object[] oneOfEachMediaTypeProvider()
    {
        Book book1 = new Book("name1", "genre1", "format1", 1, new ArrayList<>(Collections.singletonList("author1")), "publisher1", "isbn1");
        Music music1 = new Music("name1", "genre1", "format1", 1, "artist1");
        Movie movie1 = new Movie("name1", "genre1", "format1", 1, "director1", new ArrayList<>(Arrays.asList("writer1", "writer2")), new ArrayList<>(Arrays.asList("star1", "star2")));

        return new Object[] {Arrays.asList(book1, music1, movie1)};
    }
}
