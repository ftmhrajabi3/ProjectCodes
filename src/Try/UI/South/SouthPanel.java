package Try.UI.South;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import Try.logic.User;
//import jaco.mp3.player.MP3Player;

import java.awt.Font;
import java.awt.Color;


public class SouthPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	
	JLabel timer = new JLabel("00:00:00");
	JLabel timeLeft = new JLabel("00:00:00");
	
	JLabel lblSongName = new JLabel("Title");
	JLabel lblArtist = new JLabel("Artist");
	JLabel lblNewLabel = new JLabel("Album");
	
	JSlider slider = new JSlider();
	JSlider volum = new JSlider();
	
	JPanel panel = new JPanel();
	
	public SouthPanel(User user) {
		setBounds(0, 534, 1148, 124);
		setLayout(null);
		
//		MP3Player player = new MP3Player();

		timer.setSize(50, 21);
		timer.setLocation(323, 40);
		add(timer);
		
		timeLeft.setLocation(798, 40);
		timeLeft.setSize(50, 21);
		add(timeLeft);
		
		slider.setValue(0);
		slider.setSize(420, 5);
		slider.setLocation(370, 50);
		add(slider);
		
		volum.setLocation(1046, 40);
		volum.setSize(80, 10);
		add(volum);
		
		lblSongName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSongName.setBounds(97, 14, 132, 21);
		add(lblSongName);
		
		lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblArtist.setBounds(97, 45, 132, 21);
		add(lblArtist);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(97, 76, 132, 21);
		add(lblNewLabel);
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 10, 77, 87);
		add(panel);
	}
	
	
}
