package Try.UI.west;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Try.logic.User;

public class HomeBtn implements ActionListener {

	WestPanel wp;
	User user;
	
	public HomeBtn(WestPanel wp, User user) {
		super();
		this.wp = wp;
		this.user = user;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		new HomeButton(user);
	}
}
