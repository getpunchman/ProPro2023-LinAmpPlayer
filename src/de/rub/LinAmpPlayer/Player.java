package de.rub.LinAmpPlayer;

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
            System.out.println("▶ (00:00/" + Track.getRuntimeString(track.length) + ") |o--------------| Now Playing: " + track.getDescription());
            Thread.sleep(track.length);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Plays all tracks on a given album (blocking call).
     * @param album The album to play.
     */
    public void PlayAlbum(Album album) {
        System.out.println("\uD834\uDD60 Playing " + album.getDescription());
        for (Track track: album.tracks) {
            PlayTrack(track);
        }
    }

    public static void main(String[] args) {
        Album wywh = new Album("Wish You Were Here", "Pink Floyd");
        wywh.tracks.add(new Track("Shine On You Crazy Diamond, Pts. 1-5", "Pink Floyd", "Wish You Were Here", 13*60+30));
        wywh.tracks.add(new Track("Welcome To The Machine", "Pink Floyd", "Wish You Were Here", 7*60+33));
        wywh.tracks.add(new Track("Have A Cigar", "Pink Floyd", "Wish You Were Here", 5*60+7));
        wywh.tracks.add(new Track("Wish You Were Here", "Pink Floyd", "Wish You Were Here", 5*60+5));
        wywh.tracks.add(new Track("Shine On You Crazy Diamond, Pts. 6-9", "Pink Floyd", "Wish You Were Here", 12*60+23));
        wywh.updateLength();

        Album lysf = new Album("Lift Your Skinny Fists Like Antennas to Heaven", "Godspeed You! Black Emperor");
        lysf.tracks.add(new Track("Storm", "Godspeed You! Black Emperor", "Wish You Were Here", 22*60+32));
        lysf.tracks.add(new Track("Static", "Godspeed You! Black Emperor", "Wish You Were Here", 22*60+35));
        lysf.tracks.add(new Track("Sleep", "Godspeed You! Black Emperor", "Wish You Were Here", 23*60+17));
        lysf.tracks.add(new Track("Like Antennas To Heaven...", "Godspeed You! Black Emperor", "Wish You Were Here", 18*60+57));
        lysf.updateLength();

        Player player = new Player();
        player.PlayAlbum(wywh);
        player.PlayAlbum(lysf);
    }

}
