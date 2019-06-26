package Try.Network;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Try.UI.Main;
import Try.logic.User;


public class Login implements ActionListener {

	JFrame frame = new JFrame("Login");

	JPasswordField password = new JPasswordField();
	
	JTextField email = new JTextField();

	JLabel passLable = new JLabel("Password:");
	JLabel emailLabel = new JLabel("Email:");
	
	JButton loginButton = new JButton("Login");
	JButton signUpButton = new JButton("Sign Up");
	
	public Login(){
	    
	    password.setBounds(100, 100, 140, 30);
	    password.setToolTipText("Enter your Password");
	    
	    passLable.setBounds(10,100, 80,30);
	    
	    email.setBounds(100, 50, 140, 30);
	    email.setToolTipText("Enter your Email");

	    emailLabel.setBounds(20, 50, 80, 30);
	    
	    
	    loginButton.setBounds(100, 200, 100, 30);
	    loginButton.addActionListener(this);
	    
	    signUpButton.setBounds(100, 250, 100, 30);
	    signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}
		});
	    
	    
	    
		ImageIcon image = new ImageIcon("D:\\Java Codes\\Project\\Spotify.jpg");
		frame.setIconImage(image.getImage());
	    frame.add(email);
	    frame.add(emailLabel);
	    frame.add(password);
	    frame.add(passLable);
	    frame.add(loginButton);
	    frame.add(signUpButton);
	    frame.setBounds(600, 200, 300, 400);
	    frame.setLayout(null);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		Main frame = new Main();
		frame.setVisible(true);
		
	}
}
