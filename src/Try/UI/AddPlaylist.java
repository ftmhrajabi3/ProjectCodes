package Try.UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Try.logic.Playlist;
import Try.logic.Song;
import Try.logic.User;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import javax.swing.JList;

public class AddPlaylist implements ActionListener {

	JFrame frmAddPlaylist = new JFrame();;
	JTextField textField = new JTextField();;
	JLabel lblName = new JLabel("Name:");
	JButton btnCreate = new JButton("Create");
	User user;
	JPanel panel = new JPanel();
	JScrollPane scrollpane = new JScrollPane(panel);
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
		btnCreate.setBounds(353, 424, 85, 21);
		btnCreate.addActionListener(this);
		frmAddPlaylist.getContentPane().add(btnCreate);
		showSongs();
		
		panel.setBounds(new Rectangle(42, 59, 378, 310));
		panel.setLayout(null);
		scrollpane.setBounds(0, 0, 380, 312);
		frmAddPlaylist.getContentPane().add(scrollpane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		user.addPlaylist(new Playlist(true, null, textField.getText(), user));
		
	}
	
	public void showSongs() {
		Song[] songs = user.getLibrary().getLibrarySongs();
		JCheckBox[] checkBoxs = new JCheckBox[songs.length];
		for(int i=0 ; i<songs.length ; i++) {
			checkBoxs[i] = new JCheckBox(songs[i].getTitle());
			panel.add(checkBoxs[i]);
			checkBoxs[i].setBounds(6, i + 40, 100, 30);
		}
	}
}
