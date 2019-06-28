package Try.UI.west;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;

import Try.logic.User;

public class WestPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JScrollBar scrollBar = new JScrollBar();
	JButton btnHome = new JButton("Home");
	JButton btnLibrary = new JButton("Library");
	/**
	 * Create the panel.
	 */
	public WestPanel(User user) {
		setLayout(null);
		setBounds(0, 34, 166, 500);
		
		scrollBar.setBounds(154, 0, 10, 500);
		add(scrollBar);
		
		btnHome.setBounds(9, 10, 125, 29);
		add(btnHome);
		btnHome.addActionListener(new HomeBtn(this, user));
		
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
