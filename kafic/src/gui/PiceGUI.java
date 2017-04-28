package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PiceGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PiceGUI frame = new PiceGUI();
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
	public PiceGUI() {
		setTitle("Porud\u017Ebina");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 598);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Topli napici:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(34, 25, 130, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bezalkoholna pi\u0107a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(218, 25, 130, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alkoholna pi\u0107a:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(34, 291, 130, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Piva:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(218, 291, 130, 16);
		contentPane.add(lblNewLabel_3);
		
		JPanel panelKafe = new JPanel();
		panelKafe.setBounds(34, 54, 150, 224);
		contentPane.add(panelKafe);
		panelKafe.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelKafe.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelAlkohol = new JPanel();
		panelAlkohol.setBounds(34, 320, 150, 224);
		contentPane.add(panelAlkohol);
		panelAlkohol.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelAlkohol.add(scrollPane_2, BorderLayout.CENTER);
		
		JPanel panelSokovi = new JPanel();
		panelSokovi.setBounds(218, 54, 150, 224);
		contentPane.add(panelSokovi);
		panelSokovi.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelSokovi.add(scrollPane_1, BorderLayout.CENTER);
		
		JPanel panelPivo = new JPanel();
		panelPivo.setBounds(218, 320, 150, 224);
		contentPane.add(panelPivo);
		panelPivo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelPivo.add(scrollPane_3, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(458, 54, 323, 420);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane_4, BorderLayout.CENTER);
		
		JTextPane textPanePredracun = new JTextPane();
		textPanePredracun.setEditable(false);
		scrollPane_4.setViewportView(textPanePredracun);
		
		JLabel lblNewLabel_4 = new JLabel("PREDRA\u010CUN:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(458, 25, 323, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(458, 505, 130, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RA\u010CUN");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(651, 505, 130, 39);
		contentPane.add(btnNewButton_1);
	}
}