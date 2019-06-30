package Try.UI.MenuBar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Try.logic.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class FriendRequest extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	JLabel lblEmail = new JLabel("Email");
	
	JPanel panel = new JPanel();
	
	JButton btnAccept = new JButton("Accept");

	User user;
	/**
	 * Create the frame.
	 */
	public FriendRequest(User user) {
		
		this.user = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);		
		setBounds(100, 100, 450, 300);
		setTitle("Friend Requests");
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEmail.setBounds(69, 16, 30, 16);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(109, 16, 140, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnAccept.setBounds(259, 15, 89, 21);
		btnAccept.addActionListener(this);
		contentPane.add(btnAccept);
		
		panel.setBackground(Color.PINK);
		panel.setBounds(69, 58, 279, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		user.getRequests();
		System.out.println("in friend request, looking for requests");
		for(int i=0 ; i<user.requests().length ; i++) {
			JLabel l = new JLabel(user.requests()[i].getEmail());
			l.setSize(40, 20);
			l.setLocation(5, 5 + (i)*20);
			panel.add(l);
			System.out.println("in friend request, request frome : " + user.requests()[i].getEmail());
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(getClass() + " : " + "you pushed accept");
		new AcceptRequest(user, textField.getText());
	}
	
	
	
}
