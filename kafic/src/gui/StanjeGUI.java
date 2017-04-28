package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class StanjeGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StanjeGUI frame = new StanjeGUI();
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
	public StanjeGUI() {
		setResizable(false);
		setTitle("Dnevni pazar");
		setSize(new Dimension(999, 736));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 736);
		setLocationRelativeTo(null);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JTextPane textPaneDatumIzvestaja = new JTextPane();
		textPaneDatumIzvestaja.setEditable(false);
		textPaneDatumIzvestaja.setBounds(434, 13, 120, 22);
		contentPane.add(textPaneDatumIzvestaja);
		
		JLabel lblNewLabel_1 = new JLabel("Dnevni pazar na datum:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(212, 13, 210, 22);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 45, 733, 643);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrAsdAsDa = new JTextArea();
		txtrAsdAsDa.setLineWrap(true);
		txtrAsdAsDa.setWrapStyleWord(true);
		txtrAsdAsDa.setText("asd jvhjchfxfgx rx hdz hfdz hfdxhfxhfx hfgx fgx gfx gfx jgfxgfx hgfx jfgx hfgx hgfxh f xh hgfx hgfx hfgx hfgxfg hgf\r\nas\r\nda\r\nsd\r\nas\r\nd\r\nas\r\nda\r\n\r\nd\r\na\r\nd\r\na\r\nsd\r\n\r\nasd\r\n\r\nas\r\nd\r\nas\r\nd\r\na\r\nsd\r\nas\r\nd\r\nas\r\nd\r\na\r\nd\r\nas\r\nd\r\na\r\nd\r\nas\r\nd\r\nas\r\nd\r\na\r\nd\r\nasd\r\na\r\nd\r\na\r\nd\r\na\r\nd\r\nad\r\na\r\nd\r\nas\r\nd\r\nasd\r\n\r\nasd\r\na\r\nsd\r\nas\r\ndad");
		txtrAsdAsDa.setEditable(false);
		txtrAsdAsDa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(txtrAsdAsDa);
	}
}