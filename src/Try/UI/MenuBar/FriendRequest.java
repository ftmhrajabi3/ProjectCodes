package Try.UI.MenuBar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;


public class FriendRequest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public FriendRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblEmail = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmail, 118, SpringLayout.WEST, contentPane);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 11, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 153, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAccept = new JButton("Accept");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAccept, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAccept, 254, SpringLayout.WEST, contentPane);
		contentPane.add(btnAccept);
		
		
		
	}
}
