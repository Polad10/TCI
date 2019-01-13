package document_extractor;

import model.Book;
import model.Media;
import model.Movie;
import model.Music;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rest_service.MovieResource;

import javax.crypto.interfaces.PBEKey;
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
    private ArrayList<String> Links;

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
    public DocumentExtractor(Document document) throws DocumentExtractorExceptions {

        if (document == null) {
            throw new DocumentExtractorExceptions("Giving Document is null");
        } else {
            this.document = document;
        }

    }

    /**
     * This method returns the document.
     * @return The document.
     */
    public Document getDocument() {
        return document;
    }

    /**
     * This method sets the document.
     * @param document The document to set.
     */
    public void setDocument(Document document)
    {
	this.document = document;
    }

    /**
     * This method extracts all the links from the document.
     * @return All the links from the document.
     */
    public ArrayList<String> getLinks() throws DocumentExtractorExceptions
    {
        if(document == null)
        {
            throw new DocumentExtractorExceptions("Document is not set.");
        }

        Links = new ArrayList<>();
        Elements linksOnPage = document.select("a[href]");
        for (Element link : linksOnPage) {
            this.Links.add(link.absUrl("href"));
        }

        return Links;
    }

    /**
     * This method extracts the media details from the document and creates a Media object.
     * @return The Media object.
     */

    public Media extractMedia() throws DocumentExtractorExceptions
    {
        if(document == null)
        {
            throw new DocumentExtractorExceptions("Document is not set.");
        }

        for (Element s : document.getElementsByClass("media-details"))
        {
            for( Element r : s.getElementsByTag("td"))
            {
                String cat = r.text();
                if (cat.equals("Movies"))
                {
                   return  extractMovie();
                }

                if (cat.equals("Music"))
                {
                    return  extractMusic();
                }

                if (cat.equals("Books"))
                {
                    return  extractBook();
                }
            }
        }

        return null;
    }

    public Movie extractMovie() throws DocumentExtractorExceptions
    {
        if(document == null)
        {
            throw new DocumentExtractorExceptions("Document is not set.");
        }

        ArrayList<String> MovieAttri = new ArrayList<>();
        String name = null;

        for (Element s : document.getElementsByClass("media-details"))
        {
            for( Element r : s.getElementsByTag("h1"))
            {
                name = r.text();
            }

            for( Element r : s.getElementsByTag("td"))
            {
                String raw = r.text();
                MovieAttri.add(raw);
            }
        }

        ArrayList<String> stars   = new ArrayList<>();
        ArrayList<String> writers = new ArrayList<>();

        String genre=MovieAttri.get(0);
        String format=MovieAttri.get(2);
        int year = Integer.parseInt(MovieAttri.get(3));
        String director = MovieAttri.get(3);

        String[] temp=MovieAttri.get(5).split(",");
        for(String part:temp)
        {
            writers.add(part);
        }

        String[] temp2=MovieAttri.get(6).split(",");
        for(String part:temp2)
        {
            stars.add(part);
        }

        Movie movie = new Movie(name,genre,format,year,director,writers,stars);
        return movie;
    }

    public Music extractMusic() throws DocumentExtractorExceptions
    {
        if(document == null)
        {
            throw new DocumentExtractorExceptions("Document is not set.");
        }

        ArrayList<String> MusicAttri = new ArrayList<>();
        String name = null;

        for (Element s : document.getElementsByClass("media-details"))
        {
            for( Element r : s.getElementsByTag("h1"))
            {
                name = r.text();
            }

            for( Element r : s.getElementsByTag("td"))
            {
                String raw = r.text();
                MusicAttri.add(raw);
            }
        }

        String genre=MusicAttri.get(1);
        String format=MusicAttri.get(2);
        int year = Integer.parseInt(MusicAttri.get(3));
        String artist =MusicAttri.get(4);

        Music music = new Music(name,genre,format,year,artist);

        return music;
    }

    public Book extractBook() throws DocumentExtractorExceptions
    {
        if(document == null)
        {
            throw new DocumentExtractorExceptions("Document is not set.");
        }

        ArrayList<String> BookAttri = new ArrayList<>();
        String name = null;

        for (Element s : document.getElementsByClass("media-details"))
        {
            for( Element r : s.getElementsByTag("h1"))
            {
                name = r.text();
            }

            for( Element r : s.getElementsByTag("td"))
            {
                String raw = r.text();
                BookAttri.add(raw);
            }
        }

        String genre=BookAttri.get(1);
        String format=BookAttri.get(2);
        int year = Integer.parseInt(BookAttri.get(3));
        String Publisher =BookAttri.get(5);
        String ISBN = BookAttri.get(6);

        ArrayList<String> AuthorsList = new ArrayList<>();
        String[] temp2=BookAttri.get(4).split(",");
        for(String part:temp2)
        {
            AuthorsList.add(part);
        }

        Book book = new Book(name,genre,format,year,AuthorsList,Publisher,ISBN);
        return book;

    }

}
