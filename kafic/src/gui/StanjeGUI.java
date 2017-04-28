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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class StanjeGUI extends JFrame {

	private JPanel contentPane;
	public JTextArea textArea;
	public JTextField txtDatum;


	public StanjeGUI() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GuiKontroler.zatvoriProzorStanjeGUI();
			}
		});
		
		setResizable(false);
		setTitle("Dnevni pazar");
		setSize(new Dimension(999, 736));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 763, 736);
		setLocationRelativeTo(null);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
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
		scrollPane.setViewportView(getTextArea());
		contentPane.add(getTxtDatum());
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JTextField getTxtDatum() {
		if (txtDatum == null) {
			txtDatum = new JTextField();
			txtDatum.setBounds(452, 16, 159, 20);
			txtDatum.setColumns(10);
		}
		return txtDatum;
	}
}