package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordField;

	public LoginGUI() {

		
		setResizable(false);
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 260);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(50, 108, 69, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(50, 145, 69, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiKontroler.logInDugme(textFieldUser.getText(), passwordField.getPassword());
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(269, 122, 97, 25);
		contentPane.add(btnLogin);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(129, 105, 116, 25);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sre\u0107an rad!");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(131, 31, 116, 30);
		contentPane.add(lblNewLabel_2);
		contentPane.add(getPasswordField());
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(129, 142, 116, 25);
		}
		return passwordField;
	}
}