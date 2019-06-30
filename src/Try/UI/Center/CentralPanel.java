package Try.UI.Center;

import javax.swing.*;

import Try.logic.Song;
import Try.logic.User;
import java.awt.Color;

public class CentralPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user;
    static Song[] songs;
	
    public CentralPanel(User user, Song...songs) {
        super();
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        this.user = user;
        this.songs = songs;
        setLayout(null);
        setBounds(155, 34, 832, 500);
        
        for(int i=0 ; i < songs.length ; i++) {
        	JPanel panel = new SongUI(songs[i]);
        	panel.setBounds(5, i*82, 828, 82);
        	add(panel);
        }
    }

	public void setSongs(Song...songs) {
		this.songs = songs;
		for(int i=0 ; i < songs.length ; i++) {
        	JPanel panel = new SongUI(songs[i]);
        	panel.setBounds(5, i*82, 828, 82);
        	add(panel);
		}
	}

	public static Song[] getSongs() {
		return songs;
	}
	
	
}