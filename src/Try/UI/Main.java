package Try.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Try.UI.Center.CentralPanel;
import Try.UI.East.EastPanel;
import Try.UI.MenuBar.AddPlaylist;
import Try.UI.MenuBar.AddSong;
import Try.UI.MenuBar.FindFriend;
import Try.UI.MenuBar.FriendRequest;
import Try.UI.North.NorthPanel;
import Try.UI.South.SouthPanel;
import Try.UI.west.WestPanel;
import Try.logic.User;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	User user;
	
	JSeparator separator = new JSeparator();
	JSeparator separator_1 = new JSeparator();
	JSeparator separator_2 = new JSeparator();
	JSeparator separator_3 = new JSeparator();
	
	JMenuBar menuBar = new JMenuBar();
	JMenu addMenu = new JMenu("New");
	JMenuItem addSong = new JMenuItem("Add Song");
	JMenuItem addPlaylist = new JMenuItem("Add Playlist");
	JMenu userMenu = new JMenu("User Info");
	JMenuItem findFriend = new JMenuItem("Find Friend");
	JMenuItem requests = new JMenuItem("Friend Requests");
	JPanel panel;

	CentralPanel center;

	public Main(User user) {
		this.user = user;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		separator.setBounds(3, 34, 1130, 5);
		contentPane.add(separator);
		
		
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(982, 34, 5, 500);
		contentPane.add(separator_1);
		
		
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(150, 34, 5, 500);
		contentPane.add(separator_2);
		
		separator_3.setBounds(3, 534, 1130, 5);
		contentPane.add(separator_3);
		
		setJMenuBar(menuBar);
		menuBar.add(addMenu);
		
		addMenu.add(addSong);
		addSong.addActionListener(new AddSong(this, user));
		addMenu.add(addPlaylist);
		addPlaylist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddPlaylist(user);
				
			}
		});
	
		menuBar.add(userMenu);
		
		userMenu.setText(user.getName());
		userMenu.add(findFriend);
		findFriend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindFriend(user);
				
			}
		});
		
		userMenu.add(requests);
		requests.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FriendRequest(user);
			}
		});
		center = new CentralPanel(user, user.getLibrary().getLibrarySongs());
		getContentPane().add(new SouthPanel(user));
		getContentPane().add(new EastPanel(user));
		getContentPane().add(new NorthPanel(user, center));
		getContentPane().add(new WestPanel(user, center));
		getContentPane().add(center);
	}
}
