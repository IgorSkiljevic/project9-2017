package gui;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import Logika.ImpZaKontroler;
import baza.bModel.PiceBaza;
import model.Pice;

public class GuiKontroler {
	private static AdminGUI adminGui;
	private static GlavniGUI glavniGui;
	private static LoginGUI loginGui;
	private static NoviKonobarGui noviKonobarGui;
	private static PiceGUI piceGui;
	private static StanjeGUI stanjeGui;
	public static DefaultListModel model;
	static ImpZaKontroler util = new ImpZaKontroler();

	public static void main(String[] args) {
		loginGui = new LoginGUI();
		loginGui.setVisible(true);
	}

	public static void zatvoriProzorLoginGUI() {
		loginGui.dispose();
		loginGui = null;
	}

	public static void logInDugme(String user, char[] password) {
		// String prolaz = util.proveriDaLiJeRegistrovan(user, password);

		String prolaz = "Uros Momcilovic";
		// String prolaz = "admin"; test

		if (prolaz.equals("admin")) {
			otvoriProzorAdminGUI();
		} else {
			if (prolaz.equals("")) {
				JOptionPane.showMessageDialog(loginGui, "Pogresan user/password", "Greska", JOptionPane.ERROR_MESSAGE);
			} else {
				otvoriProzorGlavniGUI(prolaz);
			}
		}
	}

	public static void zatvoriProzorAdminGUI() {
		adminGui.dispose();
		adminGui = null;
		loginGui.setVisible(true);
	}

	public static void otvoriProzorAdminGUI() {
		adminGui = new AdminGUI();
		adminGui.setVisible(true);
		loginGui.setVisible(false);
	}

	public static void adminLogIn(String user, char[] password) {
		if (util.proveriDaLiJeRegistrovan(user, password).equals("admin")) {

			adminGui.textFieldDan.setEnabled(true);
			adminGui.textFieldMesec.setEnabled(true);
			adminGui.textFieldGodina.setEnabled(true);
			adminGui.textFieldNoviUser.setEnabled(true);
			adminGui.textFieldNoviUserPass.setEnabled(true);
			adminGui.btnLogOut.setVisible(true);
			adminGui.btnLogIn.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(adminGui, "Los username/password.", "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void AdminGuiDodajKonobara(String user, String password) {
		if (!util.proveriDaLiImaDatogUsera(user)) {
			util.dodajUListuUsera(user, password);
		} else {
			JOptionPane.showMessageDialog(adminGui, "Uneti user vec postoji.", "Greska", JOptionPane.ERROR_MESSAGE);
		}

	}

	private static void otvoriProzorGlavniGUI(String prolaz) {
		glavniGui = new GlavniGUI();
		glavniGui.setVisible(true);
		glavniGui.setLblKonobar("Konobar : " + prolaz);
		loginGui.setVisible(false);
	}

	public static void zatvoriProzorGlavniGUI() {
		glavniGui.dispose();
		glavniGui = null;
		loginGui.setVisible(true);
	}

	public static void otvoriProzorStanje(String godina, String mesec, String dan) {
		int g;
		int m;
		int d;
		try {
			g = Integer.parseInt(godina);
			m = Integer.parseInt(mesec);
			d = Integer.parseInt(dan);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(adminGui, "Uneli ste lose parametre za dan/mesec/godinu", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		stanjeGui = new StanjeGUI();
		stanjeGui.setVisible(true);
		stanjeGui.txtDatum.setText(dan + "." + mesec + "." + godina + ".");

		Calendar cal = new GregorianCalendar(g, m - 1, d);
		System.out.println(cal.toString());
		Date datum = new Date(cal.getTimeInMillis());
		System.out.println(datum);
		String ispis = PiceBaza.izlistajSvaPicaZaDatum(datum);

		stanjeGui.textArea.setText(ispis);

	}

	public static void zatvoriProzorStanjeGUI() {
		stanjeGui.dispose();
		stanjeGui = null;

	}

	public static void otvoriPiceGUI() {
		piceGui = new PiceGUI();
		piceGui.setVisible(true);

		String[] bezalkoholna = util.izvuciSvaPicaZadatogTipaIzListe("bezalkoholno");
		String[] alkoholna = util.izvuciSvaPicaZadatogTipaIzListe("alkoholno");
		String[] piva = util.izvuciSvaPicaZadatogTipaIzListe("pivo");
		String[] topliNapici = util.izvuciSvaPicaZadatogTipaIzListe("topliNapitak");

		DefaultListModel modelAlkohol = new DefaultListModel<>();
		DefaultListModel modelBezAlkohol = new DefaultListModel<>();
		DefaultListModel modelPiva = new DefaultListModel<>();
		DefaultListModel modelTopliNapici = new DefaultListModel<>();

		piceGui.listaAlkoholnaPica.setModel(modelAlkohol);
		piceGui.listaBezalkoholnaPica.setModel(modelBezAlkohol);
		piceGui.listaPiva.setModel(modelPiva);
		piceGui.listaTopliNapici.setModel(modelTopliNapici);

		String[] picaA = { "vino", "rakija" };
		String[] picaBA = { "sok", "limunada" };
		String[] picaT = { "caj", "kafa" };
		String[] picaP = { "niksicnko", "lav" };

		alkoholna = picaA;
		bezalkoholna = picaBA;
		topliNapici = picaT;
		piva = picaP;

		util.dodajPicaUModel(modelAlkohol, alkoholna);
		util.dodajPicaUModel(modelBezAlkohol, bezalkoholna);
		util.dodajPicaUModel(modelTopliNapici, topliNapici);
		util.dodajPicaUModel(modelPiva, piva);

	}

	public static void zatvoriProzorPiceGUI() {
		piceGui.dispose();
		piceGui = null;
	}

	public static void odselektujOstale(JList lista1, JList lista2, JList lista3) {
		// Ovo verovatno moze mnogo bolje da se uradi
		try {
			lista1.setSelectedIndices(null);
		} catch (NullPointerException e) {
			try {
				lista2.setSelectedIndices(null);
			} catch (Exception e1) {
				try {
					lista3.setSelectedIndices(null);
				} catch (Exception e2) {
				}
			}
		}
	}

	public static void ispisiUJListu(String ispis, JList Jlista) {
		if (model == null) {
			model = new DefaultListModel<>();
		}
		model.addElement(ispis);
		Jlista.setModel(model);
	}

	public static void PiceGuiRacun() {

		model = null;
		ispisiUJListu("", piceGui.list);

	}

	public static void obrisiStavkuIzListe(JList lista, int index) {
		model.remove(index);
	}

}
