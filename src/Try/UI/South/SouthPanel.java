package Try.UI.South;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import Try.UI.Center.CentralPanel;
import Try.logic.Song;
import Try.logic.User;
import jaco.mp3.player.MP3Player;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class SouthPanel extends JPanel implements ActionListener {

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
	JLabel lblAlbum = new JLabel("Album");
	
	JSlider slider = new JSlider();
	JSlider volum = new JSlider();

	JButton btnPrevious = new JButton("Previous");
	JButton btnNext = new JButton("Next");
	JButton btnPlay = new JButton("Play");
	
	JLabel picPanel = new JLabel();
	
	static Song songPlay;
	
	static MP3Player player;
	Timer playTimer = new Timer(timer, slider, timeLeft);
	
	boolean isPlaying;
	boolean isPaused;
	User user;
	
	public SouthPanel(User user) {
		this.user = user;
		setBounds(0, 534, 1148, 124);
		setLayout(null);		

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
		
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlbum.setBounds(97, 76, 132, 21);
		add(lblAlbum);
		
		picPanel.setBounds(10, 10, 77, 87);
		add(picPanel);
		
		btnPlay.setBounds(536, 15, 85, 21);
		btnPlay.addActionListener(this);
		add(btnPlay);
		
		btnNext.setBounds(631, 15, 85, 21);
		btnNext.addActionListener(this);
		add(btnNext);
		
		btnPrevious.setBounds(441, 15, 85, 21);
		btnPrevious.addActionListener(this);
		add(btnPrevious);
	}

	public static void setSong(Song song) {
		System.out.println("you sent the song");
		songPlay = song;
		player = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("player got your song");
		
		if(player == null) {
			player = new MP3Player(new File(songPlay.getPath()));
			playTimer.start();
			playTimer.setTotalTime(songPlay.getTotalTimeSecond());
		}
		
		if(e.getSource() == btnPlay) {
			if(songPlay != null) {
				setLabels();
				if(!isPlaying) {
					player.play();
					isPlaying = true;
					playTimer.resumeTimer();
				}
				else {
					player.pause();
					isPlaying = false;
					playTimer.pauseTimer();
				}
			}
		}
		else if(e.getSource() == btnNext) {
			player.stop();
			getSong(1);
			setLabels();
			playTimer.reset();
			playTimer.setTotalTime(songPlay.getTotalTimeSecond());
			player.play();
		}
		else if(e.getSource() == btnPrevious) {
			player.stop();
			getSong(-1);
			setLabels();
			playTimer.reset();
			playTimer.setTotalTime(songPlay.getTotalTimeSecond());
			player.play();
		}
			
		
	}
	
	
	private void setLabels() {
		setVisible(false);
		lblSongName.setText(songPlay.getTitle());
		lblArtist.setText(songPlay.getArtist());
		lblAlbum.setText(songPlay.getAlbum());
		ImageIcon img = new ImageIcon("D:\\Jpotify\\SampelCode\\SongPic\\" + songPlay.getTitle() + ".jpeg");
		img = new ImageIcon(getScaledImage(img.getImage(), 70, 75));
		picPanel.setIcon(img);
		setVisible(true);
	}
	
	private void getSong(int j) {
		Song[] songs = CentralPanel.getSongs();
		for(int i=0 ; i<songs.length ; i++) {
			if(songs[i].equals(songPlay) && (i+j)<(songs.length)) {
				songPlay = songs[i+j];
				player = new MP3Player(new File(songPlay.getPath()));
				return;
			}
		}
	}
	
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
