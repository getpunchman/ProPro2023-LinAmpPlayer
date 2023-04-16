package de.rub.LinAmpPlayer;

import java.util.ArrayList;

public class Album {
    public String albumTitle;  // album title
    public String artist;  // artist name
    public ArrayList<Track> tracks = new ArrayList<>();  // tracks
    public int length;  // length of the album in seconds

    public Album(String albumTitle, String artist) {
        this.albumTitle = albumTitle;
        this.artist = artist;
    }

    public String getDescription() {
        return albumTitle + " by " + artist + " (" + getRuntimeString(length) + ")";
    }

    public void setLength(int hours, int minutes, int seconds) {
        this.length = hours * 60 * 60 + minutes * 60 + seconds;
    }

    /**
     * Updates the length of the album by calculating the sum of track lengths
     * Developer Note: Call this after adding tracks!
     */
    public void updateLength() {
        this.length = 0;
        for (Track track :
                tracks) {
            this.length += track.length;
        }
    }

    /**
     * Formats a time in seconds into a String with the format hh:mm:ss or mm:ss if hours = 0
     * @param timeInSeconds The time in seconds
     * @return The formatted String
     */
    public static String getRuntimeString(int timeInSeconds) {
        int tAbs = Math.abs(timeInSeconds);
        if(timeInSeconds >= 60 * 60) {
            int hours = Math.floorDiv(tAbs, 60 * 60);
            int minutes = Math.floorDiv(tAbs % (60 * 60), 60);
            int seconds = tAbs % 60;
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            int minutes = Math.floorDiv(tAbs, 60);
            int seconds = tAbs % 60;
            return String.format("%02d:%02d", minutes, seconds);
        }
    }


}
