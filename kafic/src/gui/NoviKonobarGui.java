package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class NoviKonobarGui extends JFrame {

	private JPanel contentPane;
	private  JTextField textFieldAdminUser;
	private JTextField textFieldAdminovPassword;
	private JTextField textFieldNoviUser;
	private  JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoviKonobarGui frame = new NoviKonobarGui();
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
	public NoviKonobarGui() {
		setTitle("Unos novog konobara");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 299);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldAdminUser = new JTextField();
		textFieldAdminUser.setBounds(29, 81, 116, 22);
		contentPane.add(textFieldAdminUser);
		textFieldAdminUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Admin:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 52, 116, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(220, 52, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		textFieldAdminovPassword = new JTextField();
		textFieldAdminovPassword.setBounds(220, 81, 116, 22);
		contentPane.add(textFieldAdminovPassword);
		textFieldAdminovPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Unesite username i password novog konobara:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(29, 116, 324, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(29, 145, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(220, 145, 133, 16);
		contentPane.add(lblNewLabel_4);
		
		textFieldNoviUser = new JTextField();
		textFieldNoviUser.setBounds(29, 174, 116, 22);
		contentPane.add(textFieldNoviUser);
		textFieldNoviUser.setColumns(10);
		
		JButton btnDodajUBazu = new JButton("Dodajte novog konobara");
		btnDodajUBazu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiKontroler.ubaciNovogKonobaraUListu(textFieldNoviUser.getText(),passwordField.getPassword());
				passwordField.setText(""); // ne radi?
				textFieldNoviUser.setText(""); //ne radi?
			}
		});
		btnDodajUBazu.setForeground(Color.RED);
		btnDodajUBazu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDodajUBazu.setBounds(78, 209, 212, 25);
		contentPane.add(btnDodajUBazu);
		
		JLabel lblUnesitePonovoUser = new JLabel("Unesite ponovo user i password:");
		lblUnesitePonovoUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnesitePonovoUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUnesitePonovoUser.setBounds(29, 13, 307, 16);
		contentPane.add(lblUnesitePonovoUser);
		contentPane.add(getPasswordField());
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(220, 174, 116, 22);
		}
		return passwordField;
	}
}
