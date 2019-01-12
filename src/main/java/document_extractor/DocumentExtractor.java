package document_extractor;

import model.Media;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

/**
 *This class extracts the information from the html document.
 *
 * @author
 * @version 1.0
 * @since   2019-01-12
 */
public class DocumentExtractor
{
    private Document document;

    /**
     * This is the default constructor.
     */
    public DocumentExtractor()
    {

    }

    /**
     * This is the constructor which initializes the document.
     * @param document
     */
    public DocumentExtractor(Document document)
    {

    }

    /**
     * This method returns the document.
     * @return The document.
     */
    public Document getDocument()
    {
        return null;
    }

    /**
     * This method sets the document.
     * @param document The document to set.
     */
    public void setDocument(Document document)
    {

    }

    /**
     * This method extracts all the links from the document.
     * @return All the links from the document.
     */
    public ArrayList<String> getLinks()
    {
        return new ArrayList<>();
    }

    /**
     * This method extracts the media details from the document and creates a Media object.
     * @return The Media object.
     */

    public Media extractMedia()

    {
        return null;
    }
}
