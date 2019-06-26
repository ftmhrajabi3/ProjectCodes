package Try.logic;

import java.util.HashSet;
import java.util.Iterator;

public class User {
	private String name;
	private String email;
	private String password;
	private HashSet<Playlist> playlists = new HashSet<Playlist>();
	private HashSet<User> friends = new HashSet<User>();
	private HashSet<User> requests = new HashSet<User>();
	
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}
	
	
	public Playlist[] getPlaylists() {
		Playlist[] allPlaylists = new Playlist[playlists.size()];
		int i = 0;
		Iterator<Playlist> it = playlists.iterator(); 
        while (it.hasNext()) {
        	allPlaylists[i] = it.next();
        	i++;
        }
        return allPlaylists;
	}
	
	
	public void addPlaylist(Playlist playlist) {
		playlists.add(playlist);
	}
	
	
	public void removePlaylist(Playlist playlist) {
		playlists.remove(playlist);
	}
	
	
	public void requestTo(User u) {
		
	}
	
	
	public void  acceptRequestOf(User u) {
		
	}
	
	
	public User[] requests() {
		User[] allRequests = new User[requests.size()];
		int i = 0;
		Iterator<User> it = requests.iterator(); 
        while (it.hasNext()) {
        	allRequests[i] = it.next();
        	i++;
        }
        return allRequests;
	}
	
}
