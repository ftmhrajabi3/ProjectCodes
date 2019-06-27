package Try.logic;

import java.io.Serializable;
import java.util.HashSet;

public class SharedPlayList extends Playlist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SharedPlayList(HashSet<Song> songs, String name) {
		super(false, songs, name);
	}
	
}
