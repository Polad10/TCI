package converter;

import static org.junit.Assert.*;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import com.owlike.genson.reflect.VisibilityFilter;
import model.Book;
import model.Media;
import model.Movie;
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
        ArrayList<String> writers = new ArrayList<String>();
        writers.add("writer1");
        writers.add("writer2");

        ArrayList<String> stars = new ArrayList<String>();
        stars.add("star1");
        stars.add("star2");

        Movie expectedMovie = new Movie("name", "genre", "format", 1, "director", writers, stars);
        String movieJson = MediaConverter.toJson(expectedMovie);
        Movie actualMovie = genson.deserialize(movieJson, Movie.class);
        Assert.assertEquals(expectedMovie, actualMovie);
    }

    @Test
    public void getJsonOfMovieAsMedia()
    {
        ArrayList<String> writers = new ArrayList<String>();
        writers.add("writer1");
        writers.add("writer2");

        ArrayList<String> stars = new ArrayList<String>();
        stars.add("star1");
        stars.add("star2");

        Media expectedMovie = new Movie("name", "genre", "format", 1, "director", writers, stars);
        String movieJson = MediaConverter.toJson(expectedMovie);
        Movie actualMovie = genson.deserialize(movieJson, Movie.class);
        Assert.assertEquals(expectedMovie, actualMovie);
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