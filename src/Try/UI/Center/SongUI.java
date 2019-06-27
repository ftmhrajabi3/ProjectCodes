package Try.UI.Center;

import javax.swing.JPanel;

import Try.logic.Song;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class SongUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblPicture = new JLabel("Picture");
	JLabel lblTitle = new JLabel("title");
	JLabel lblArtist = new JLabel("artist");
	JLabel lblAlbum = new JLabel("Album");
	JButton btnPlay = new JButton("Play");
	JButton btnAddToPlaylist = new JButton("Add to playlist");

	/**
	 * Create the panel.
	 */
	public SongUI(Song song) {
		setLayout(null);
		
		lblPicture.setBounds(10, 10, 65, 75);
		lblPicture.setIcon(new ImageIcon("D:\\Jpotify\\SampelCode\\SongPic\\" + song.getTitle() + ".jpeg"));
		add(lblPicture);
		
		lblTitle.setBounds(131, 10, 121, 13);
		lblTitle.setText(song.getTitle());
		add(lblTitle);
		
		lblArtist.setBounds(131, 33, 101, 13);
		lblArtist.setText(song.getArtist());
		add(lblArtist);
		
		lblAlbum.setBounds(131, 56, 46, 13);
		lblAlbum.setText(song.getAlbum());
		add(lblAlbum);
		
		btnPlay.setBounds(737, 30, 85, 21);
		add(btnPlay);
		
		btnAddToPlaylist.setBounds(571, 30, 148, 21);
		add(btnAddToPlaylist);

	}
}
