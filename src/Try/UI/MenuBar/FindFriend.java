package Try.UI.MenuBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Try.logic.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FindFriend extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEnterYourFriends;

	/**
	 * Create the frame.
	 */
	public FindFriend(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Find Friend");
		setVisible(true);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(148, 121, 204, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(41, 121, 58, 27);
		contentPane.add(lblEmail);
		
		lblEnterYourFriends = new JLabel("Enter your friend's email address:");
		lblEnterYourFriends.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterYourFriends.setBounds(41, 25, 358, 27);
		contentPane.add(lblEnterYourFriends);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.setBounds(310, 199, 103, 21);
		btnRequest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("requesting to " + textField.getText());
				user.requestTo(textField.getText());
			}
		});
		contentPane.add(btnRequest);
	}
}
