package gui;

import java.awt.EventQueue;

public class GUIKontroler {
	
	private static Glavni glavniFrame;
	private static Admin admin;
	private static Login login;
	private static NoviKonobar noviKonobar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
