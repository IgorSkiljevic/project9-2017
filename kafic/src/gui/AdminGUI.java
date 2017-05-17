package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldAdmin;
	public JTextField textFieldNoviUser;
	public JTextField textFieldDan;
	public JTextField textFieldMesec;
	public JTextField textFieldGodina;
	public JTextField textFieldNoviUserPass;
	public JPasswordField passwordField;
	public JButton btnLogOut;
	public JButton btnLogIn;

	public AdminGUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GuiKontroler.zatvoriProzorAdminGUI();
			}
		});

		setResizable(false);
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 407, 522);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldAdmin = new JTextField();
		textFieldAdmin.setBounds(29, 74, 116, 22);
		contentPane.add(textFieldAdmin);
		textFieldAdmin.setColumns(10);

		textFieldNoviUser = new JTextField();
		textFieldNoviUser.setEnabled(false);
		textFieldNoviUser.setBounds(29, 397, 116, 22);
		contentPane.add(textFieldNoviUser);
		textFieldNoviUser.setColumns(10);

		textFieldDan = new JTextField();
		textFieldDan.setText("01.");
		textFieldDan.setEnabled(false);
		textFieldDan.setBounds(139, 206, 116, 22);
		contentPane.add(textFieldDan);
		textFieldDan.setColumns(10);

		textFieldMesec = new JTextField();
		textFieldMesec.setText("01.");
		textFieldMesec.setEnabled(false);
		textFieldMesec.setBounds(139, 241, 116, 22);
		contentPane.add(textFieldMesec);
		textFieldMesec.setColumns(10);

		textFieldGodina = new JTextField();
		textFieldGodina.setText("2000.");
		textFieldGodina.setEnabled(false);
		textFieldGodina.setBounds(139, 276, 116, 22);
		contentPane.add(textFieldGodina);
		textFieldGodina.setColumns(10);

		textFieldNoviUserPass = new JTextField();
		textFieldNoviUserPass.setEnabled(false);
		textFieldNoviUserPass.setBounds(254, 397, 116, 22);
		contentPane.add(textFieldNoviUserPass);
		textFieldNoviUserPass.setColumns(10);

		JLabel lblNewLabel = new JLabel("Verifikacija admina");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(29, 13, 341, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Admin:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(29, 42, 116, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(254, 42, 116, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mesec:");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(29, 240, 98, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Godina:");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(29, 275, 98, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("User:");
		lblNewLabel_5.setEnabled(false);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(29, 368, 116, 16);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(254, 368, 116, 16);
		contentPane.add(lblNewLabel_6);

		JButton btnProveri = new JButton("Proveri");
		btnProveri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String godina = textFieldGodina.getText();
				if (godina.endsWith(".")) {
					godina = godina.substring(0, godina.length() - 1);
				}

				String mesec = textFieldMesec.getText();
				if (mesec.startsWith("0")) {
					mesec = mesec.substring(1, mesec.length());
				}
				if (mesec.endsWith(".")) {
					mesec = mesec.substring(0, mesec.length() - 1);
				}

				String dan = textFieldDan.getText();
				if (dan.startsWith("0")) {
					dan = dan.substring(1, dan.length());
				}
				if (dan.endsWith(".")) {
					dan = dan.substring(0, dan.length() - 1);
				}

				 GuiKontroler.otvoriProzorStanje(godina,mesec,dan);
			}
		});
		btnProveri.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProveri.setBounds(272, 240, 98, 25);
		contentPane.add(btnProveri);

		JButton btnNewButton_2 = new JButton("Unesi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiKontroler.AdminGuiDodajKonobara(textFieldNoviUser.getText(), textFieldNoviUserPass.getText());
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(139, 445, 116, 25);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_7 = new JLabel("Provera prometa na datum");
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(29, 169, 341, 16);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Dodavanje novog konobara");
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(29, 329, 341, 16);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Dan:");
		lblNewLabel_9.setEnabled(false);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(29, 209, 98, 16);
		contentPane.add(lblNewLabel_9);

		passwordField = new JPasswordField();
		passwordField.setBounds(237, 74, 116, 22);
		contentPane.add(passwordField);
		contentPane.add(getBtnLogOut());
		contentPane.add(getBtnLogIn());
	}

	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("Log out");
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuiKontroler.zatvoriProzorAdminGUI();
				}
			});
			btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnLogOut.setBounds(139, 123, 116, 23);
			btnLogOut.setVisible(false);
		}
		return btnLogOut;
	}

	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log in");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuiKontroler.adminLogIn(textFieldAdmin.getText(), passwordField.getPassword());
				}
			});
			btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnLogIn.setBounds(139, 123, 116, 23);
			btnLogIn.setVisible(true);
		}
		return btnLogIn;
	}
}