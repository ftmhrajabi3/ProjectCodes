package Try.UI.North;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NorthPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public NorthPanel() {
		
		setBounds(0, 0, 1140, 34);
		setVisible(true);
		setLayout(null);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(440, 9, 50, 13);
		lblSearch.setIcon(new ImageIcon("D:\\Java Codes\\Project\\search.png"));
		add(lblSearch);
		
		JTextField txtSongSearch = new JTextField();
		txtSongSearch.setText("song search");
		txtSongSearch.setBounds(491, 6, 96, 19);
		add(txtSongSearch);
		txtSongSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(599, 5, 80, 21);
		add(btnSearch);
		
	}

}
