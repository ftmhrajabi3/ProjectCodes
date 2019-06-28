package Try.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Try.logic.Song;
import Try.logic.User;

public class AddSong implements ActionListener {

	JFrame main;
	User user;
	
	public AddSong(JFrame main, User user) {
		super();
		this.main = main;
		this.user = user;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser filechooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 File", "mp3");
		filechooser.setFileFilter(filter);
		int i = filechooser.showOpenDialog(main);
		if(i == JFileChooser.APPROVE_OPTION) {
			user.getLibrary().addSong(new Song(filechooser.getSelectedFile().getPath()));
			System.out.println(new Song(filechooser.getSelectedFile().getPath()).getTitle());
		}
	}
}
