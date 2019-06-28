package Try.Network;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Server().start();
		if(checkUserInfo()) {
			frame.setVisible(false);
			Main frame = new Main(getUser());
			frame.setVisible(true);
			Runtime.getRuntime().addShutdownHook(new Thread() {
		        public void run(){
		            saveInfo();
		        }
		    });
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "Wrong email or password");
		}
	}
	
	
	private boolean checkUserInfo() {
		boolean check = false;
		try (Socket socket = new Socket("127.0.0.1", 444);
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				DataInputStream dis = new DataInputStream(socket.getInputStream())){
			
			dos.writeUTF("check User Info");
			dos.flush();
			dos.writeUTF(email.getText());
			dos.flush();
			dos.writeUTF(password.getText());
			dos.flush();
			check = dis.readBoolean();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	private void saveInfo() {
		getUser().updateInfo();
		System.out.println(getUser().toString());
	}
	
	private User getUser() {
		User user = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Jpotify\\SampelCode\\Client\\" + email.getText() + ".txt")); 
			user = (User) ois.readObject();
			ois.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
