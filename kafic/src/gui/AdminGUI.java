package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAdmin;
	private JTextField textFieldPass;
	private JTextField textFieldNoviUser;
	private JTextField textFieldDan;
	private JTextField textFieldMesec;
	private JTextField textFieldGodina;
	private JTextField textFieldNoviUserPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
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
	public AdminGUI() {
		setResizable(false);
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(254, 74, 116, 22);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
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
		
		JButton btnVerfikacija = new JButton("Log in");
		btnVerfikacija.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVerfikacija.setBounds(139, 121, 116, 25);
		contentPane.add(btnVerfikacija);
		
		JButton btnProveri = new JButton("Proveri");
		btnProveri.setEnabled(false);
		btnProveri.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProveri.setBounds(272, 240, 98, 25);
		contentPane.add(btnProveri);
		
		JButton btnNewButton_2 = new JButton("Unesi");
		btnNewButton_2.setEnabled(false);
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
	}
}