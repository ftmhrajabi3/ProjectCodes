package Try.logic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password;
	private Library library = Library.getLibrary();
	private HashSet<Playlist> playlists = new HashSet<Playlist>();
	private HashSet<User> friends = new HashSet<User>();
	private HashSet<User> requests = new HashSet<User>();
	
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		updateInfo(this);
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
		updateInfo(this);
	}
	
	
	public void removePlaylist(Playlist playlist) {
		playlists.remove(playlist);
		updateInfo(this);
	}
	
	
	public void requestTo(User u) {
		
	}
	
	
	public void  acceptRequestOf(User u) {
		requests.remove(u);
		friends.add(u);
		updateInfo(this);
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
	
	public void updateInfo(User u) {
		
		try(FileOutputStream fout = new FileOutputStream("D:\\Jpotify\\SampelCode\\Server\\" + email + ".txt");
				ObjectOutputStream out = new ObjectOutputStream(fout);) {
			out.writeObject(u);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		  
		  
	}
}
