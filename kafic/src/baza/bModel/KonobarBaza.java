package baza.bModel;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import baza.konekcija.Konekcija;
import model.Konobar;
import model.Pice;;

public class KonobarBaza {

	/**
	 * 
	 * @return vraca sve konobare(i admine) iz MySQL baze
	 */
	public static LinkedList<Konobar> ubaciUListuSveKonobare() {
		LinkedList<Konobar> listaKonobara = new LinkedList<>();

		try {
			Connection c = Konekcija.getInstance();
			Statement s = c.createStatement();

			String SQL = "SELECT * FROM korisnici";

			ResultSet rs = s.executeQuery(SQL);

			while (rs.next()) {
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				boolean admin = false;
				String a = rs.getString("Admin");
				if (a.equals("true")) {
					admin = true;
				}
				Konobar k = new Konobar(username, password, admin);
				listaKonobara.add(k);
			}

			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaKonobara;
	}

	/**
	 * Voditi racuna jer data metoda iz baze brise sve konobare i postavlja u
	 * bazu samo konobare iz liste, pa je potrebno pozvati ovu metodu uvek pri
	 * gasenju aplikacije
	 * 
	 * @param listaKonobara
	 *            lista svih konobara
	 */
	public static void prebaciSveKonobareIzListeUBazu(LinkedList<Konobar> listaKonobara) {
		try {
			Connection c = Konekcija.getInstance();
			Statement s = c.createStatement();

			String SQL = "DELETE FROM korisnici";
			s.executeUpdate(SQL);

			for (Konobar konobar : listaKonobara) {
				String admin = konobar.isAdmin() + "";
				String SQL2 = "INSERT INTO korisnici (Username , Password , Admin)" + " VALUES ('" + konobar.getUser()
						+ "' , '" + konobar.getPass() + "' , '" + admin + " ')";
				System.out.println(SQL2);
				s.executeUpdate(SQL2);
			}

			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// public static void main(String[] args) {
	// Konobar k = new Konobar("Igor", "12345", true);
	// LinkedList<Konobar> konobari = KonobarBaza.ubaciUListuSveKonobare();
	// konobari.add(k);
	// KonobarBaza.prebaciSveKonobareIzListeUBazu(konobari);
	// }
}
