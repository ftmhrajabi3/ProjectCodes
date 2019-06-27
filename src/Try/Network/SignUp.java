package Try.Network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Try.logic.User;


public class SignUp implements ActionListener {

	JFrame frame = new JFrame("Login");
	ImageIcon image = new ImageIcon("D:\\Java Codes\\Project\\Spotify.jpg");

	JLabel nameLabel = new JLabel("Name:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel passLable = new JLabel("Password:");

	JTextField name = new JTextField();
	JTextField email = new JTextField();

	JPasswordField password = new JPasswordField();

	JButton signUpButton = new JButton("Register");

	public SignUp() {
		
		
		nameLabel.setBounds(20, 50, 80, 30);
	    name.setBounds(100, 50, 140, 30);
		name.setToolTipText("Enter your name");
	    
	    emailLabel.setBounds(20, 100, 80, 30);
	    email.setBounds(100, 100, 140, 30);
	    email.setToolTipText("Enter your Email");
	    
	    
	    passLable.setBounds(10,150, 80,30);
	    password.setBounds(100, 150, 140, 30);
	    password.setToolTipText("Enter your Password");
	    
	    
	    signUpButton.setBounds(100, 260, 100, 30);
	    signUpButton.addActionListener(this);
	    
		frame.setIconImage(image.getImage());
		frame.setBounds(600, 200, 300, 400);
	    frame.setLayout(null);
		frame.add(nameLabel);
		frame.add(name);
		frame.add(emailLabel);
		frame.add(email);
	    frame.add(passLable);
	    frame.add(password);
	    frame.add(signUpButton);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Server().start();
		if(notExist()) {
			frame.setVisible(false);
			File file = new File("D:\\Jpotify\\SampelCode\\Client\\" + email.getText() + ".txt");
			try {
				file.createNewFile();
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(new User(name.getText(), email.getText(), password.getText()));
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "This Email Already Exists");
		}
		
	}
	
	private boolean notExist() {
		boolean check = false;
		try (Socket socket = new Socket("127.0.0.1", 444);
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				DataInputStream dis = new DataInputStream(socket.getInputStream())){
			
			dos.writeUTF("user sign up");
			dos.flush();
			dos.writeUTF(name.getText());
			dos.flush();
			dos.writeUTF(email.getText());
			dos.flush();
			dos.writeUTF(password.getText());
			dos.flush();
			check = dis.readBoolean();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return check;
	}
}
