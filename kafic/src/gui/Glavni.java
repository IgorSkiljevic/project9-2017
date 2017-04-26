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

public class Glavni extends JFrame {

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
					Glavni frame = new Glavni();
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
	public Glavni() {
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
