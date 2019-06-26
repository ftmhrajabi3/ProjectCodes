package Try.UI.South;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SouthPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JButton playBtn = new JButton("Play");
	JButton nextBtn = new JButton("Next");
	JButton pauseBtn = new JButton("Pause");
	JButton previousBtn = new JButton("Previous");
	
	JLabel timer = new JLabel("00:00:00");
	JLabel timeLeft = new JLabel("00:00:00");
	
	JLabel lblSongName = new JLabel("Title");
	JLabel lblArtist = new JLabel("Artist");
	JLabel lblNewLabel = new JLabel("Album");
	
	JSlider slider = new JSlider();
	JSlider volum = new JSlider();
	
	JPanel panel = new JPanel();
	
	public SouthPanel() {
		setBounds(0, 534, 1148, 124);
		setLayout(null);
		
		playBtn.setLocation(588, 10);
		playBtn.setSize(80, 21);
		add(playBtn);
		
		nextBtn.setLocation(678, 10);
		nextBtn.setSize(80, 21);
		add(nextBtn);
		
		
		pauseBtn.setSize(80, 21);
		pauseBtn.setLocation(499, 10);
		add(pauseBtn);
		
		previousBtn.setBounds(399, 10, 90, 21);
		add(previousBtn);

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
