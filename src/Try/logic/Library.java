package Try.logic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class Library implements Serializable {
	private static Library library;
	private HashSet<Song> songs = new HashSet<Song>();
	
	private Library() {
		super();
	}


	public static Library getLibrary() {
		if(library == null)
			library = new Library();			
		return library;
	}
	
	public void addSong(Song s) {
		songs.add(s);
	}
	
	public void removeSong(Song s) {
		songs.remove(s);
	}
	
	public Song[] getLibrarySongs() {
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
