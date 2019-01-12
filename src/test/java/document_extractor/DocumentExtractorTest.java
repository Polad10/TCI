package document_extractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import wca.SpiderLegException;

import java.io.File;
import java.io.IOException;

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
    public void getLinksReturnsCorrectNumberOfLinksInDocument()throws DocumentExtractorExceptions
    {
        String Path = "/Users/Bram/Desktop/TCI/GitHub/Git version 2/TCI/src/main/sample_site/index.html";
        File input = new File(Path);
        org.jsoup.nodes.Document local_html_doc = null;

        try
        {
            local_html_doc = Jsoup.parse(input, "UTF-8", "");

        }
        catch (IOException ioe)
        {
            System.out.println("Error in loading file " + ioe);

        }

        DocumentExtractor documentExtractor = documentExtractor = new DocumentExtractor(local_html_doc);
        Assert.assertEquals(documentExtractor.getLinks().size(),8);

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