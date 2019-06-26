package Try.UI.west;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;

public class WestPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WestPanel() {
		setLayout(null);
		setBounds(0, 34, 166, 500);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(154, 0, 10, 500);
		add(scrollBar);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(9, 10, 125, 29);
		add(btnHome);
		
		JButton btnLibrary = new JButton("Library");
		btnLibrary.setBounds(9, 49, 125, 29);
		add(btnLibrary);
		
		JButton btnPlay = new JButton("Album");
		btnPlay.setBounds(9, 85, 125, 29);
		add(btnPlay);
		
		JToggleButton tglbtnPlaylist = new JToggleButton("Playlist");
		tglbtnPlaylist.setBounds(9, 124, 125, 29);
		add(tglbtnPlaylist);


	}

}
