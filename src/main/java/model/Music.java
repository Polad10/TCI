package model;

/**
 * This class extends the abstract Media class and is a blueprint for music objects.
 *
 * @author
 * @version 1.0
 * @since   2018-12-19
 */

public class Music extends Media
{
    private String artist;

    /**
     * This is a Music constructor.
     * @param artist Artist of this music.
     */
    public Music(String name, String genre, String format, int year, String artist)
    {
        this.name = name;
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == this)
        {
            return true;
        }

        if(!(o instanceof Music))
        {
            return false;
        }

        Music music = (Music) o;

        return name.compareTo(music.name) == 0 &&
                genre.compareTo(music.genre) == 0 &&
                format.compareTo(music.format) == 0 &&
                year == music.year &&
                artist.compareTo(music.artist) == 0;
    }

    public String getArtist()
    {
        return artist;
    }
}
