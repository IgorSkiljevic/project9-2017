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

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUnesiteDan;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setResizable(false);
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 320);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dan:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(30, 75, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mesec:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(30, 104, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Godina:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(30, 133, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnStanjeSmene = new JButton("Proverite stanje u smeni");
		btnStanjeSmene.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStanjeSmene.setBounds(30, 23, 201, 25);
		contentPane.add(btnStanjeSmene);
		
		txtUnesiteDan = new JTextField();
		txtUnesiteDan.setVerifyInputWhenFocusTarget(false);
		txtUnesiteDan.setText("01.");
		txtUnesiteDan.setBounds(98, 72, 116, 22);
		contentPane.add(txtUnesiteDan);
		txtUnesiteDan.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("2000.");
		textField_1.setBounds(98, 130, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("01.");
		textField_2.setBounds(98, 101, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnProvera = new JButton("Provera za uneti datum");
		btnProvera.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProvera.setBounds(30, 172, 201, 25);
		contentPane.add(btnProvera);
		
		JButton btnDodavanjeNovogKonobara = new JButton("Dodavanje novog konobara");
		btnDodavanjeNovogKonobara.setForeground(Color.RED);
		btnDodavanjeNovogKonobara.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDodavanjeNovogKonobara.setBounds(12, 230, 250, 25);
		contentPane.add(btnDodavanjeNovogKonobara);
	}
}
