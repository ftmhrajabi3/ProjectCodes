package Try.logic;

import java.io.Serializable;

public class SharedPlayList extends Playlist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SharedPlayList(String name, User user) {
		super(false, "Shared Playlist", user);
	}
}
