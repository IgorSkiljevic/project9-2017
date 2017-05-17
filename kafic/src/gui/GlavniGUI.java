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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GlavniGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	public JLabel lblVreme;
	private JLabel lblKonobar;
	public JLabel lblSmena;
	private JMenuBar menuBar;

	public GlavniGUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GuiKontroler.zatvoriProzorGlavniGUI();
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(DimMax);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setJMenuBar(getMenuBar_1());
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

						int hour = c.get(Calendar.HOUR_OF_DAY);
						int second = c.get(Calendar.SECOND);
						int minute = c.get(Calendar.MINUTE);

						lblVreme.setText("Time : " + hour + " : " + minute + " : " + second + " Date : " + day + "/"
								+ month + "/" + year);

						if (hour > 16) {
							lblSmena.setText("druga");
						} else {
							if (hour < 8) {
								lblSmena.setText("Smena : treca");
							} else {
								lblSmena.setText("Smena : prva");
							}
						}
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
			btnSto1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GuiKontroler.otvoriPiceGUI();
				}
			});
			btnSto1.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto1.setBounds(89, 120, 360, 320);
			panel.add(btnSto1);

			JButton btnSto2 = new JButton("Sto2");
			btnSto2.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GuiKontroler.otvoriPiceGUI();
				}
			});
			btnSto2.setBounds(1102, 120, 360, 320);
			panel.add(btnSto2);

			JButton btnSto3 = new JButton("Sto3");
			btnSto3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuiKontroler.otvoriPiceGUI();
				}
			});
			btnSto3.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto3.setBounds(598, 346, 360, 320);
			panel.add(btnSto3);

			JButton btnSto4 = new JButton("Sto4");
			btnSto4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GuiKontroler.otvoriPiceGUI();
				}
			});
			btnSto4.setIcon(new ImageIcon("C:\\Users\\urosm\\git\\project9-2017\\kafic\\icons\\sto.png"));
			btnSto4.setBounds(89, 565, 360, 320);
			panel.add(btnSto4);

			JButton btnSto5 = new JButton("Sto5");
			btnSto5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuiKontroler.otvoriPiceGUI();
				}
			});
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

	public void setLblKonobar(String text) {
		lblKonobar.setText(text);
	}

	private JLabel getLblSmena() {
		if (lblSmena == null) {
			lblSmena = new JLabel("smena");
			lblSmena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblSmena;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			
			JMenu mnDodajPice = new JMenu("Dodaj pice");
			mnDodajPice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					GuiKontroler.otvoriProzorDodavanjePica();
				}
			});
			menuBar.add(mnDodajPice);
		}
		return menuBar;
	}
}