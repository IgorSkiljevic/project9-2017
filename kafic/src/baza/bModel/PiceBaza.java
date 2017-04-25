package baza.bModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import baza.konekcija.Konekcija;
import model.Pice;

public class PiceBaza {
	static Connection c;

	public static void unesiNovoPice(Pice p) {
		c = Konekcija.getInstance();

		try {
			Statement s = c.createStatement();

			String SQL = "INSERT INTO stanje_pica" + "(sifra , ime, tip , cena , stanje)" + "VALUES" + "('"
					+ p.getSifra() + "' , '" + p.getIme() + "' , '" + p.getTip() + "', '" + p.getCena() + "' , '"
					+ p.getStanje() + "')";

			s.executeUpdate(SQL);

			s.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
