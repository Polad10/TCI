package document_extractor;

import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import wca.SpiderLegException;

import static org.junit.Assert.*;

public class DocumentExtractorTest
{
    @Test (expected = DocumentExtractorExceptions.class)
    public void creatingDocumentExtractorWithInvalidDocumentThrowsInvalidDocumentException() throws DocumentExtractorExceptions
    {
        org.jsoup.nodes.Document mockDocu = Mockito.mock(Document.class);

        DocumentExtractor documentExtractor = new DocumentExtractor(null);

    }

    @Test
    public void creatingDocumentExtractorWithValidDocumentInitializesTheFields() throws DocumentExtractorExceptions
    {
        org.jsoup.nodes.Document mockDocu = Mockito.mock(Document.class);
        DocumentExtractor documentExtractor = new DocumentExtractor(mockDocu);

        Assert.assertEquals(documentExtractor.getDocument(),mockDocu);

    }

    @Test
    public void getLinksReturnsCorrectNumberOfLinksInDocument()
    {

    }

    @Test
    public void extractMediaReturnsCorrectMediaFromDocument()
    {

    }

    @Test
    public void extractMediaReturnsNullWhenDocumentDoesNotContainMedia()
    {

    }
}