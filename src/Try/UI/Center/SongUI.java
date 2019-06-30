package Try.UI.Center;

import javax.swing.JPanel;

import Try.UI.South.SouthPanel;
import Try.logic.Song;
import jaco.mp3.player.MP3Player;

import javax.swing.JLabel;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SongUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTitle = new JLabel("title");
	JLabel lblArtist = new JLabel("artist");
	JLabel lblAlbum = new JLabel("Album");
	JButton btnPlay = new JButton("Play");
	JButton btnAddToPlaylist = new JButton("Add to playlist");


	/**
	 * Create the panel.
	 */
	public SongUI(Song song) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		ImageIcon img = new ImageIcon("D:\\Jpotify\\SampelCode\\SongPic\\" + song.getTitle() + ".jpeg");
		img = new ImageIcon(getScaledImage(img.getImage(), 70, 75));
		
		lblTitle.setBounds(131, 10, 195, 13);
		lblTitle.setText(song.getTitle());
		add(lblTitle);
		
		lblArtist.setBounds(131, 33, 195, 13);
		lblArtist.setText(song.getArtist());
		add(lblArtist);
		
		lblAlbum.setBounds(131, 56, 238, 13);
		lblAlbum.setText(song.getAlbum());
		add(lblAlbum);
		btnPlay.setBackground(Color.BLACK);
		
		btnPlay.setBounds(10, 10, 65, 75);
		btnPlay.setIcon(img);
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SouthPanel.setSong(song);
				
			}
		});
		add(btnPlay);
		
		btnAddToPlaylist.setBounds(645, 29, 148, 21);
		add(btnAddToPlaylist);
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
