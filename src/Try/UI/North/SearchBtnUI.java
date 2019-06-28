package Try.UI.North;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Try.UI.Center.SongUI;
import Try.logic.Song;

import java.awt.Rectangle;

public class SearchBtnUI extends JFrame {

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
	public SearchBtnUI(Song song) {
		setVisible(true);
		setBounds(new Rectangle(150, 34, 832, 500));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 832, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		SongUI songUI = new SongUI(song);
		add(songUI);
		
	}

}
