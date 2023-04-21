package de.rub.LinAmpPlayer;

public class Album extends MusicCollection {
    public Artist artist;  // artist name

    public Album(String albumTitle, Artist artist) {
        super(albumTitle);
        this.artist = artist;
    }

    @Override
    public String getDescription() {
        return getCollectionTitle() + " by " + artist.getArtistName() + " (" + Playable.getRuntimeString(getLength()) + ")";
    }
}
