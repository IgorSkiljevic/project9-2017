package baza.bModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import baza.konekcija.Konekcija;
import model.Pice;

public class PiceBaza {
	static Connection c;

	/**
	 * Metoda unosi pice uneto kao ulazni parametar u MySQL bazu
	 * 
	 * @param p(objekat
	 *            klase Pice) je pice koje treba da se unese
	 */
	public static void unesiNovoPice(Pice p) {
		c = Konekcija.getInstance();

		try {
			Statement s = c.createStatement();

			String SQL = "INSERT INTO stanje_pica" + "(sifra , ime, tip , cena , stanje)" + "VALUES" + "('"
					+ p.getSifra() + "' , '" + p.getIme() + "' , '" + p.getTip() + "', '" + p.getCena() + "' , '"
					+ p.getStanje() + "')";

			s.executeUpdate(SQL);

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	/**
	 * 
	 * @return vraca listu svih pica sa podacima(sifra,ime,tip,stanje,cena)
	 */
	public static LinkedList<Pice> napuniListuTekucimStanjemPica() {
		LinkedList<Pice> listaPica = new LinkedList<>();

		try {
			Connection c = Konekcija.getInstance();
			Statement s = c.createStatement();

			String SQL = "SELECT * FROM stanje_pica";

			ResultSet rs = s.executeQuery(SQL);

			while (rs.next()) {
				int sifra = rs.getInt("sifra");
				String ime = rs.getString("ime");
				String tip = rs.getString("tip");
				int stanje = rs.getInt("stanje");
				int cena = rs.getInt("cena");

				Pice p = new Pice(sifra, ime, tip, stanje, cena);
				listaPica.add(p);
			}

			s.close();
//			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPica;
	}

	/**
	 * Metoda vraca listu pica koja su prodata tog datuma
	 * 
	 * @param datum
	 * @return
	 */
	public static String izlistajSvaPicaZaDatum(Date datum) {
		String ispis = "";
		try {
			Connection c = Konekcija.getInstance();
			Statement s = c.createStatement();

			String SQL = "SELECT smena , proizvod , sifra " + "FROM prihod WHERE dan = '" + datum + "'";

			System.out.println(SQL);

			ResultSet rs = s.executeQuery(SQL);

			while (rs.next()) {
				String smena = rs.getString("smena");
				String proizvod = rs.getString("proizvod");
				String sifra = rs.getString("sifra");

				ispis = ispis + " " + smena + " " + proizvod + " " + sifra + "\n";
			}

			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ispis;
	}

	/**
	 * 
	 * @param pica
	 *            Ulazni parametar je lista koja se unosi u bazu, voditi racuna
	 *            da data lista sadrzi SVA pica, jer data metoda iz liste brise
	 *            predhodno stanje i dodaje ovo novo
	 */
	public static void unesiListuUBazu(LinkedList<Pice> pica) {
		try {
			Connection c = Konekcija.getInstance();
			Statement s = c.createStatement();

			String SQL1 = "DELETE  FROM stanje_pica";

			s.executeUpdate(SQL1);

			for (Pice pice : pica) {
				PiceBaza.unesiNovoPice(pice);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
