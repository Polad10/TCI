package converter;

import static org.junit.Assert.*;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import com.owlike.genson.reflect.VisibilityFilter;
import model.Book;
import model.Media;
import model.Music;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MediaConverterTest
{
    Genson genson = new GensonBuilder().useConstructorWithArguments(true).create();

    @Test
    public void getJsonOfBook()
    {
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("author1");
        authors.add("author2");

        Book expectedBook = new Book("name", "genre", "format", 1, authors, "publisher", "isbn");
        String bookJson = MediaConverter.toJson(expectedBook);
        Book actualBook = genson.deserialize(bookJson, Book.class);
        Assert.assertEquals(expectedBook, actualBook);
    }

    @Test
    public void getJsonOfBookAsMedia()
    {
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("author1");
        authors.add("author2");

        Media expectedBook = new Book("name", "genre", "format", 1, authors, "publisher", "isbn");
        String bookJson = MediaConverter.toJson(expectedBook);
        Book actualBook = genson.deserialize(bookJson, Book.class);
        Assert.assertEquals(expectedBook, actualBook);
    }

    @Test
    public void getJsonOfMovie()
    {

    }

    @Test
    public void getJsonOfMovieAsMedia()
    {

    }

    @Test
    public void getJsonOfMusic()
    {
        Music expectedMusic = new Music("name", "genre", "format", 1, "artist");
        String musicJson = MediaConverter.toJson(expectedMusic);
        Music actualMusic = genson.deserialize(musicJson, Music.class);
        Assert.assertEquals(expectedMusic, actualMusic);
    }

    @Test
    public void getJsonOfMusicAsMedia()
    {
        Media expectedMusic = new Music("name", "genre", "format", 1, "artist");
        String musicJson = MediaConverter.toJson(expectedMusic);
        Music actualMusic = genson.deserialize(musicJson, Music.class);
        Assert.assertEquals(expectedMusic, actualMusic);
    }

    @Test
    public void getNullJsonForNullMedia()
    {
        String mediaJson = MediaConverter.toJson(null);
        Assert.assertEquals("null", mediaJson);
    }
}