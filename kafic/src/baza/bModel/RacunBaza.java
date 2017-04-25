package baza.bModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import baza.konekcija.Konekcija;
import model.Pice;
import model.Racun;

public class RacunBaza {
	static Connection c;

	public static void unesiNoviRacun(Racun r) {
		c = Konekcija.getInstance();

		try {
			Statement s = c.createStatement();

			for (Pice p : r.getPica()) {

				String SQL = "INSERT INTO prihod " + "(smena , dan , sifra) VALUES " + "('" + r.getSmena() + "' , '"
						+ r.getDatum() + " ' , '" + p.getSifra() + "')";

				String SQL2 = "UPDATE stanje_pica" + " SET stanje = " + " stanje - '1' WHERE sifra = '" + p.getSifra()
						+ "'";

				s.executeUpdate(SQL2);
				s.executeUpdate(SQL);

				s.close();
				c.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
