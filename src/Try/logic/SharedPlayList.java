package Try.logic;

import java.io.Serializable;
import java.util.HashSet;

public class SharedPlayList extends Playlist implements Serializable {

	public SharedPlayList(HashSet<Song> songs, String name) {
		super(false, songs, name);
	}
	
}
