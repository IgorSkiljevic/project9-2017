package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GlavniGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblVreme;
	private JLabel lblKonobar;
	private JLabel lblSmena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniGUI frame = new GlavniGUI();
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
	public GlavniGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(DimMax);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		clock();
	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while (true) {
						Calendar c = new GregorianCalendar();

						int year = c.get(Calendar.YEAR);
						int month = c.get(Calendar.MONTH);
						int day = c.get(Calendar.DAY_OF_MONTH);

						int hour = c.get(Calendar.HOUR);
						int second = c.get(Calendar.SECOND);
						int minute = c.get(Calendar.MINUTE);

						lblVreme.setText("Time : " + hour + " : " + minute + " : " + second + " Date : " + day + "/"
								+ month + "/" + year);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setAutoscrolls(true);
			panel.setLayout(null);
			
			JButton btnSto1 = new JButton("Sto1");
			btnSto1.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto1.setBounds(89, 120, 360, 320);
			panel.add(btnSto1);
			
			JButton btnSto2 = new JButton("Sto2");
			btnSto2.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnSto2.setBounds(1102, 120, 360, 320);
			panel.add(btnSto2);
			
			JButton btnSto3 = new JButton("Sto3");
			btnSto3.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto3.setBounds(598, 346, 360, 320);
			panel.add(btnSto3);
			
			JButton btnSto4 = new JButton("Sto4");
			btnSto4.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto4.setBounds(89, 565, 360, 320);
			panel.add(btnSto4);
			
			JButton btnSto5 = new JButton("Sto5");
			btnSto5.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto5.setBounds(1102, 554, 360, 320);
			panel.add(btnSto5);
			
			JButton btnAdminMode = new JButton("Admin");
			btnAdminMode.setForeground(Color.RED);
			btnAdminMode.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAdminMode.setBounds(1639, 489, 200, 34);
			panel.add(btnAdminMode);
			
			JButton btnStanje = new JButton("Stanje");
			btnStanje.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnStanje.setBounds(1639, 120, 200, 34);
			panel.add(btnStanje);
			
			JButton btnLogOff = new JButton("Log off");
			btnLogOff.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnLogOff.setBounds(1639, 840, 200, 34);
			panel.add(btnLogOff);
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLblVreme());
			panel_1.add(getLblKonobar(), BorderLayout.EAST);
			panel_1.add(getLblSmena(), BorderLayout.WEST);
		}
		return panel_1;
	}

	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("vreme i datum");
			lblVreme.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblVreme.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblVreme;
	}

	private JLabel getLblKonobar() {
		if (lblKonobar == null) {
			lblKonobar = new JLabel("konobar");
			lblKonobar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblKonobar;
	}

	private JLabel getLblSmena() {
		if (lblSmena == null) {
			lblSmena = new JLabel("smena");
			lblSmena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblSmena;
	}
}