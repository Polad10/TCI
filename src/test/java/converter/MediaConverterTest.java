package converter;

import static org.junit.Assert.*;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import com.owlike.genson.reflect.VisibilityFilter;
import model.Media;
import model.Music;
import org.junit.Assert;
import org.junit.Test;

public class MediaConverterTest
{
    Genson genson = new GensonBuilder().useConstructorWithArguments(true).create();

    @Test
    public void getJsonOfBook()
    {

    }

    @Test
    public void getJsonOfBookAsMedia()
    {

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
    public void getEmptyJsonForNullMedia()
    {

    }
}