package Try.UI.East;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EastPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EastPanel() {
		setLayout(null);
		setBounds(982, 34, 166, 500);
		
		JLabel lblFreiendActivity = new JLabel("Freind Activity");
		lblFreiendActivity.setBounds(6, 8, 128, 28);
		lblFreiendActivity.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblFreiendActivity);
		

	}

}
