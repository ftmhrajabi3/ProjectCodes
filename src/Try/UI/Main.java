package Try.UI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Try.Network.Login;
import Try.UI.East.EastPanel;
import Try.UI.North.NorthPanel;
import Try.UI.South.SouthPanel;
import Try.UI.west.WestPanel;

public class Main extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					Main frame = new Main();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
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

	public Main() {
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
		addMenu.add(addPlaylist);
	
		menuBar.add(userMenu);
		
		userMenu.add(findFriend);
		userMenu.add(requests);
		
		getContentPane().add(new SouthPanel());
		getContentPane().add(new EastPanel());
		getContentPane().add(new NorthPanel());
		getContentPane().add(new WestPanel());
		
	}
}
