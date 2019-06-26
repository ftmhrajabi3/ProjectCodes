package Try.logic;

import java.util.HashSet;
import java.util.Iterator;

public class Playlist {
	protected boolean deletable;
	
	protected HashSet<Song> songs = new HashSet<Song>();
	
	protected String name;
	
	public Playlist(boolean deletable, HashSet<Song> songs, String name) {
		super();
		this.deletable = deletable;
		this.songs = songs;
		this.name = name;
	}

	public void addSong(Song s) {
		songs.add(s);
	}
	
	public void removeSong(Song s) {
		songs.remove(s);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getDeletable() {
		return deletable;
	}
	
	public Song[] getPlaylistSongs() {
		Song[] allSongs = new Song[songs.size()];
		int i = 0;
		Iterator<Song> it = songs.iterator(); 
        while (it.hasNext()) {
        	allSongs[i] = it.next();
        	i++;
        }
        return allSongs;
	}
}
