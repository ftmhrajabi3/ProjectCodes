package Try.UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Try.logic.Playlist;
import Try.logic.Song;
import Try.logic.User;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlaylist implements ActionListener {

	JFrame frmAddPlaylist = new JFrame();;
	JTextField textField = new JTextField();;
	JLabel lblName = new JLabel("Name:");
	JButton btnCreate = new JButton("Create");
	User user;
	JTextField textField_1 = new JTextField();;
	Playlist playlist;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AddPlaylist(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddPlaylist.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Codes\\Project\\Spotify.jpg"));
		frmAddPlaylist.setTitle("Add PlayList");
		frmAddPlaylist.setBounds(100, 100, 497, 505);
		frmAddPlaylist.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddPlaylist.setVisible(true);
		frmAddPlaylist.getContentPane().setLayout(null);
		lblName.setBounds(42, 28, 50, 21);
		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmAddPlaylist.getContentPane().add(lblName);
		textField.setBounds(144, 30, 278, 21);
		frmAddPlaylist.getContentPane().add(textField);
		textField.setColumns(10);
		btnCreate.setBounds(353, 77, 85, 21);
		btnCreate.addActionListener(this);
		frmAddPlaylist.getContentPane().add(btnCreate);
		
		JLabel lblSongsName = new JLabel("Song's Name");
		lblSongsName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSongsName.setBounds(32, 116, 95, 21);
		frmAddPlaylist.getContentPane().add(lblSongsName);
		
		textField_1.setBounds(144, 118, 278, 19);
		frmAddPlaylist.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Song[] songs = user.getLibrary().getLibrarySongs();
				int i;
				for(i=0 ; i<songs.length ; i++) {
					if(songs[i].getTitle().equalsIgnoreCase(textField_1.getText())) {
						if(playlist != null) {
							playlist.addSong(songs[i]);
							break;
						}
					}	
				}
				if(i >= songs.length)
					JOptionPane.showMessageDialog(new JFrame(), "Song Not Found");
			}
		});
		btnAdd.setBounds(353, 161, 85, 21);
		frmAddPlaylist.getContentPane().add(btnAdd);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		playlist = new Playlist(true, textField.getText(), user);
		user.addPlaylist(playlist);
	}
}
