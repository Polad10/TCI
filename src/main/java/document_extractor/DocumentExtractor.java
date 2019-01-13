package document_extractor;

import model.Book;
import model.Media;
import model.Movie;
import model.Music;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rest_service.MovieResource;

import java.util.ArrayList;

/**
 *This class extracts the information from the html document.
 *
 * @author
 * @version 1.0
 * @since   2019-01-12
 */
public class DocumentExtractor {
    private Document document;
    private ArrayList<String> Links;

    public DocumentExtractor(Document document) throws DocumentExtractorExceptions {

        if (document == null) {
            throw new DocumentExtractorExceptions("Giving Document is null");
        } else {
            this.document = document;
        }

    }


    public Document getDocument() {
        return document;
    }

    /**
     * This method extracts all the links from the document.
     *
     * @return All the links from the document.
     */
    public ArrayList<String> getLinks() {
        Links = new ArrayList<>();
        Elements linksOnPage = document.select("a[href]");
        for (Element link : linksOnPage) {
            this.Links.add(link.absUrl("href"));
        }

        return Links;
    }

    /**
     * This method extracts the media details from the document and creates a Media object.
     *
     * @return The Media object.
     */

    public Movie extractMovie()
    {
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



    public Music extractMusic()
    {

       return  null;
    }
    public Book extractBook()
    {

       return null;
    }




    public Media extractMedia()
    {
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

}

