package Try.UI.North;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Try.UI.Center.CentralPanel;
import Try.logic.User;

public class NorthPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	JTextField txtSongSearch = new JTextField();
	
	JLabel lblSearch = new JLabel("Search");
	
	JButton btnSearch = new JButton("Search");
	
	SearchButton searchBtn;

	public NorthPanel(User user, CentralPanel center) {
		
		setBounds(0, 0, 1140, 34);
		setVisible(true);
		setLayout(null);

		lblSearch.setBounds(440, 9, 50, 13);
		lblSearch.setIcon(new ImageIcon("D:\\Java Codes\\Project\\search.png"));
		add(lblSearch);
		
		txtSongSearch.setText("song search");
		txtSongSearch.setBounds(491, 6, 96, 19);
		add(txtSongSearch);
		txtSongSearch.setColumns(10);
		
		btnSearch.setBounds(599, 5, 80, 21);
		searchBtn = new SearchButton(this, user, center);
		btnSearch.addActionListener(searchBtn);
		add(btnSearch);
		
	}
	
	

}
