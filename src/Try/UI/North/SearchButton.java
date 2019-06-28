package Try.UI.North;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Try.logic.Song;
import Try.logic.User;

public class SearchButton implements ItemListener {

	NorthPanel np;
	User user;
	SearchBtnUI ui;
	
	public SearchButton(NorthPanel np, User user) {
		this.np = np;
		this.user = user;
		
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
	public void itemStateChanged(ItemEvent e) {
		if(np.btnSearch.isSelected()) {
			Song song = findSong();
			if(song == null)
				JOptionPane.showMessageDialog(new JFrame(), "Not found");
			else {
				ui = new SearchBtnUI(song);
				ui.setVisible(true);
			}
		}else {
			ui.setVisible(false);
			System.out.println("not selected");
		}
	}

}
