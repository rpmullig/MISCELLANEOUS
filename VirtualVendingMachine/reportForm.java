import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;


public class reportForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void report(final String s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportForm frame = new reportForm(s);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public reportForm(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(s);
		contentPane.add(textPane, BorderLayout.CENTER);
	}

}
