package Try.logic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class Playlist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected boolean deletable;
	
	protected HashSet<Song> songs = new HashSet<Song>();
	
	protected String name;
	
	protected User user;
	
	public Playlist(boolean deletable, HashSet<Song> songs, String name, User user) {
		super();
		this.deletable = deletable;
		this.songs = songs;
		this.name = name;
		this.user = user;
		user.updateInfo();
	}

	public void addSong(Song s) {
		songs.add(s);
		user.updateInfo();
	}
	
	public void removeSong(Song s) {
		songs.remove(s);
		user.updateInfo();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (deletable ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (deletable != other.deletable)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		return true;
	}
	
	
	
}
