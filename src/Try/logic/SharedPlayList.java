package Try.logic;

import java.util.HashSet;

public class SharedPlayList extends Playlist {

	public SharedPlayList(HashSet<Song> songs, String name) {
		super(false, songs, name);
	}
	
}
