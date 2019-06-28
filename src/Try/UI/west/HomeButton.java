package Try.UI.west;

import javax.swing.*;

import Try.UI.Center.SongUI;
import Try.logic.Song;
import Try.logic.User;

import java.awt.*;
import java.awt.event.*;

public class HomeButton extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user;
    
    public HomeButton(User user) {
        super();
        this.user = user;
        setVisible(true);
        setLayout(new GridLayout());
        setBounds(150, 34, 832, 500);
        
        for(int i=0 ; i < user.getLibrary().getLibrarySongs().length ; i++)
        	add(new SongUI(user.getLibrary().getLibrarySongs()[i]));
    }

	public JPanel panelCreating(Song song){
        JPanel panel = new JPanel();
        Icon icon = new ImageIcon("D:\\Jpotify\\SampelCode\\SongPic\\" + song.getTitle() + "jpeg");
        JLabel lb = new JLabel();
        
        panel.setLayout(new GridLayout(2,1));
        JButton btn = new JButton(icon);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //playing music
            }
        });
        lb.setText(song.getTitle() + "\n" + song.getArtist() + "\n" + song.getAlbum());

        panel.add(btn);
        panel.add(lb);
        return panel;
    }

}