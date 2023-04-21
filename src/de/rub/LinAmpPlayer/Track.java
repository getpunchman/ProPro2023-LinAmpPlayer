package de.rub.LinAmpPlayer;

public class Track implements Playable{
    private String trackTitle;  // album title
    private Artist artist;  // track artist
    private Album album;  // track album
    private int length;  // length of the track in seconds

    public Track(String trackTitle, Artist artist, Album album, int length) {
        this.trackTitle = trackTitle;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }


    @Override
    public String getDescription() {
        return artist.getArtistName() + " - " + trackTitle + " (" + Playable.getRuntimeString(length) + ")";
    }

    @Override
    public int getLength() {
        return length;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setLength(int hours, int minutes, int seconds) {
        this.length = hours * 60 * 60 + minutes * 60 + seconds;
    }
}
