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

    public DocumentExtractor(Document document) throws DocumentExtractorExceptions
    {

        if(document == null)
        {
            throw new DocumentExtractorExceptions("Giving Document is null");
        }
        else
        {
            this.document= document;
        }


    }

    public Document getDocument()

    {
        return null;
    }

    /**
     * This method extracts all the links from the document.
     * @return All the links from the document.
     */
    public ArrayList<String> getLinks()
    {
        return null;
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
