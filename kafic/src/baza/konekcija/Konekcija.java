package baza.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {

	private static Connection konekcija = null;

	private Konekcija() {
	}

	public static Connection getInstance() {
		if (konekcija == null) {
			try {
				konekcija = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kafic", "root", "");
			} catch (SQLException e) {
			}
		}
		return konekcija;
	}
}
