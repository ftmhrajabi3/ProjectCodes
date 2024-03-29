package Try.UI.North;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Try.UI.Center.CentralPanel;
import Try.logic.Song;
import Try.logic.User;

public class SearchButton implements ActionListener {

	NorthPanel np;
	User user;
	CentralPanel center;
	
	public SearchButton(NorthPanel np, User user, CentralPanel center) {
		this.np = np;
		this.user = user;
		this.center = center;
		
	}
	
	
	public Song findSong() {
		String name = np.txtSongSearch.getText();
		Song[] songs = user.getLibrary().getLibrarySongs();
		
		for(int i=0; i<songs.length ; i++) {
			if(songs[i].getTitle().equals(name))
				return songs[i];
		}
		return null;		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Song song = findSong();
		if(song == null)
		
			JOptionPane.showMessageDialog(new JFrame(), "Not found");
		
		else {
		
			center.setVisible(false);	
			center.removeAll();
			center.setSongs(song);
			center.setVisible(true);
		}
	}

}
