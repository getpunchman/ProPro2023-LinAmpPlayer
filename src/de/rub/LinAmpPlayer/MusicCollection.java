package de.rub.LinAmpPlayer;

import java.util.ArrayList;

public abstract class MusicCollection implements Playable {

    protected String collectionTitle;  // album title
    private ArrayList<Track> tracks = new ArrayList<>();  // tracks
    private int length;  // length of the album in seconds


    public MusicCollection(String collectionTitle) {
        this.collectionTitle = collectionTitle;
    }

    @Override
    public int getLength() {
        return length;
    }

    public void addTrack(Track track) {
        tracks.add(track);
        updateLength();
    }

    public Track getTrack(int numberOfTrack) {
        return tracks.get(numberOfTrack);
    }

    public int getNumberOfTracks() {
        return tracks.size();
    }

    /**
     * Updates the length of the album by calculating the sum of track lengths
     * Developer Note: Call this after adding tracks!
     */
    private void updateLength() {
        this.length = 0;
        for (Track track :
                tracks) {
            this.length += track.getLength();
        }
    }

    public String getCollectionTitle() {
        return collectionTitle;
    }

    public void setCollectionTitle(String collectionTitle) {
        this.collectionTitle = collectionTitle;
    }

    @Override
    public String getDescription() {
        return collectionTitle + " (" + Playable.getRuntimeString(getLength()) + ")";
    }
}
