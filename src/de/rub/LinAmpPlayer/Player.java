package de.rub.LinAmpPlayer;

import java.util.ArrayList;

public class Player {

    public Player() {
        System.out.println("\uD834\uDD60 LinAmpPlayer initialized \uD834\uDD60");
    }

    /**
     * Plays a single track (blocking call).
     * Mock implementation at 1000x speed.
     * @param track The track to play.
     */
    public void PlayTrack(Track track) {
        try {
            System.out.println("▶ (00:00/" + Playable.getRuntimeString(track.getLength()) + ") |o--------------| Now Playing: " + track.getDescription());
            Thread.sleep(track.getLength());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Plays all tracks on a given collection (blocking call).
     * @param collection The collection to play.
     */
    public void PlayCollection(MusicCollection collection) {
        System.out.println("\uD834\uDD60 Playing " + collection.getDescription());

        for (int i = 0; i < collection.getNumberOfTracks(); i++) {
            Track track = collection.getTrack(i);
            PlayTrack(track);
        }
    }

    public static void main(String[] args) {
        Artist pf = new Artist("Pink Floyd");
        Album wywh = new Album("Wish You Were Here", pf);
        Track shine = new Track("Shine On You Crazy Diamond, Pts. 1-5", pf, wywh, 13 * 60 + 30);
        wywh.addTrack(shine);
        wywh.addTrack(new Track("Welcome To The Machine", pf, wywh, 7*60+33));
        wywh.addTrack(new Track("Have A Cigar", pf, wywh, 5*60+7));
        wywh.addTrack(new Track("Wish You Were Here", pf, wywh, 5*60+5));
        wywh.addTrack(new Track("Shine On You Crazy Diamond, Pts. 6-9", pf, wywh, 12*60+23));

        Artist gybe = new Artist("Godspeed You! Black Emperor");
        Album lysf = new Album("Lift Your Skinny Fists Like Antennas to Heaven", gybe);
        Track storm = new Track("Storm", gybe, lysf, 22 * 60 + 32);
        lysf.addTrack(storm);
        lysf.addTrack(new Track("Static", gybe, lysf, 22*60+35));
        lysf.addTrack(new Track("Sleep", gybe, lysf, 23*60+17));
        lysf.addTrack(new Track("Like Antennas To Heaven...", gybe, lysf, 18*60+57));

        Playlist playlist = new Playlist("Ambient Rock");
        playlist.addTrack(shine);
        playlist.addTrack(storm);

        Player player = new Player();
        player.PlayCollection(wywh);
        player.PlayCollection(lysf);
        player.PlayCollection(playlist);
    }

}
