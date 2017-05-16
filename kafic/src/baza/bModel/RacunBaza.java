package baza.bModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

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

				String SQL = "INSERT INTO prihod " + "(smena , dan , proizvod , sifra) VALUES " + "('" + r.getSmena() + "' , '"
						+ r.getDatum() + " ' , '" +p.getIme() + "' , '" +p.getSifra() + "')";

				String SQL2 = "UPDATE stanje_pica" + " SET stanje = " + " stanje - '1' WHERE sifra = '" + p.getSifra()
						+ "'";

				s.executeUpdate(SQL2);
				s.executeUpdate(SQL);


			}
			s.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Pice p = new Pice(5, "stok", "zesci", 100, 150);
		Pice v = new Pice(5, "viski", "zesci", 10, 250);
		
		LinkedList<Pice> pica = new LinkedList<>();
		pica.add(v);
		pica.add(p);
		
		Racun r = new Racun("prva",new Date(System.currentTimeMillis()),pica);
		RacunBaza.unesiNoviRacun(r);
		
	}

}
