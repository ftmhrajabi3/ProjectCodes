package Try.UI.west;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;

import Try.UI.Center.CentralPanel;
import Try.logic.Song;
import Try.logic.User;

public class WestPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JScrollBar scrollBar = new JScrollBar();

	JButton btnHome = new JButton("Home");
	JButton btnLibrary = new JButton("Library");
	JButton btnPlay = new JButton("Album");
	
	JToggleButton tglbtnPlaylist = new JToggleButton("Playlist");

	User user;
	
	CentralPanel center;
	
	/**
	 * Create the panel.
	 */
	public WestPanel(User user, CentralPanel center) {
		this.user = user;
		this.center = center;
		setLayout(null);
		setBounds(0, 34, 166, 500);
		
		scrollBar.setBounds(154, 0, 10, 500);
		add(scrollBar);
		
		btnHome.setBounds(9, 10, 125, 29);
		add(btnHome);
		btnHome.addActionListener(this);
		btnLibrary.setBounds(9, 49, 125, 29);
		add(btnLibrary);
		
		btnPlay.setBounds(9, 85, 125, 29);
		add(btnPlay);
		
		tglbtnPlaylist.setBounds(9, 124, 125, 29);
		add(tglbtnPlaylist);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnHome) {
			center.setVisible(false);
			center.removeAll();
//			center.setSongs(songs);
			center.setVisible(true);
		}
	}
}
