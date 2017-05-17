package gui;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Logika.ImpZaKontroler;
import baza.bModel.KonobarBaza;
import baza.bModel.PiceBaza;
import baza.bModel.RacunBaza;
import model.Pice;
import model.Racun;

public class GuiKontroler {
	private static AdminGUI adminGui;
	private static GlavniGUI glavniGui;
	private static LoginGUI loginGui;
	private static NoviKonobarGui noviKonobarGui;
	private static PiceGUI piceGui;
	private static StanjeGUI stanjeGui;
	private static DodavanjePica dodavanjePicaGui;
	public static DefaultListModel<Object> model;

	static ImpZaKontroler util = new ImpZaKontroler();

	public static void main(String[] args) {
		util = new ImpZaKontroler();
		loginGui = new LoginGUI();
		loginGui.setVisible(true);
	}

	public static void zatvoriProzorLoginGUI() {
		loginGui.dispose();
		loginGui = null;
	}

	public static void logInDugme(String user, char[] password) {

		String prolaz = util.proveriDaLiJeRegistrovan(user, password);
		System.out.println(prolaz);

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
		int opcija = JOptionPane.showConfirmDialog(adminGui, "Da li ZAISTA zelite da izadjete iz apliacije", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {

			KonobarBaza.prebaciSveKonobareIzListeUBazu(ImpZaKontroler.listaKonobara);
			// PiceBaza.unesiListuUBazu(ImpZaKontroler.listaPica);
			adminGui.dispose();
			adminGui = null;
			loginGui.setVisible(true);
		}
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
			JOptionPane.showMessageDialog(adminGui, "Uspesno ste dodali novog konobara", "",
					JOptionPane.INFORMATION_MESSAGE);
			GuiKontroler.obrisiText(adminGui.textFieldNoviUser);
			GuiKontroler.obrisiText(adminGui.textFieldNoviUserPass);
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
		int opcija = JOptionPane.showConfirmDialog(glavniGui, "Da li ZAISTA zelite da izadjete iz apliacije", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {

			glavniGui.dispose();
			glavniGui = null;
			loginGui.setVisible(true);
			KonobarBaza.prebaciSveKonobareIzListeUBazu(ImpZaKontroler.listaKonobara);

			PiceBaza.unesiListuUBazu(ImpZaKontroler.listaPica);
		}
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

		DefaultListModel<Object> modelAlkohol = new DefaultListModel<>();
		DefaultListModel<Object> modelBezAlkohol = new DefaultListModel<>();
		DefaultListModel<Object> modelPiva = new DefaultListModel<>();
		DefaultListModel<Object> modelTopliNapici = new DefaultListModel<>();

		util.dodajPicaUModel(modelAlkohol, alkoholna);
		util.dodajPicaUModel(modelBezAlkohol, bezalkoholna);
		util.dodajPicaUModel(modelTopliNapici, topliNapici);
		util.dodajPicaUModel(modelPiva, piva);

		piceGui.listaAlkoholnaPica.setModel(modelAlkohol);
		piceGui.listaBezalkoholnaPica.setModel(modelBezAlkohol);
		piceGui.listaPiva.setModel(modelPiva);
		piceGui.listaTopliNapici.setModel(modelTopliNapici);

	}

	public static void zatvoriProzorPiceGUI() {
		if (piceGui.list.getModel().getSize() != 0) {
			DefaultListModel listModel = (DefaultListModel) piceGui.list.getModel();
			listModel.removeAllElements();
		}
		piceGui.dispose();
		piceGui = null;
	}

	public static void odselektujOstale(JList<?> lista1, JList<?> lista2, JList<?> lista3) {
		// Ovo verovatno moze mnogo bolje da se uradi
		// try {
		// lista1.setSelectedIndices(null);
		// } catch (NullPointerException e) {
		// try {
		// lista2.setSelectedIndices(null);
		// } catch (Exception e1) {
		// try {
		// lista3.setSelectedIndices(null);
		// } catch (Exception e2) {
		// }
		// }
		// }
		lista1.clearSelection();
		lista2.clearSelection();
		lista3.clearSelection();
	}

	public static void ispisiUJListu(String ispis, JList<Object> Jlista) {
		if (model == null) {
			model = new DefaultListModel<>();
		}
		model.addElement(ispis);
		Jlista.setModel(model);
	}

	public static void PiceGuiRacun() {
		int velicina = piceGui.list.getModel().getSize();
		if (velicina == 0) {
			JOptionPane.showMessageDialog(glavniGui, "Prazan racun", "Greska", JOptionPane.ERROR_MESSAGE);
		} else {
			String smena = glavniGui.lblSmena.getText();

			LinkedList<Pice> pica = new LinkedList<>();

			for (int i = 0; i < velicina; i++) {
				Pice p = util.pronadjiDatoPiceISmanjiMuKolicinu(piceGui.list.getModel().getElementAt(i).toString());
				pica.add(p);
			}

			Racun r = new Racun(smena, new Date(System.currentTimeMillis()), pica);
			RacunBaza.unesiNoviRacun(r);

			ispisiUJListu("", piceGui.list);

			GuiKontroler.zatvoriProzorPiceGUI();

			JOptionPane.showMessageDialog(glavniGui, "Uspesno ste naplatili racun", "",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static String obrisiStavkuIzListe(JList<?> lista, int index) {
		String zaBrisanje = lista.getModel().getElementAt(index).toString();
		model.remove(index);

		return zaBrisanje;
	}

	public static void ubaciNovogKonobaraUListu(String username, char[] password) {
		String pass = "";
		if (!util.proveriDaLiImaDatogUsera(username)) {
			for (int i = 0; i < password.length; i++) {
				pass += password[i];
			}
			util.dodajUListuUsera(username, pass);

		}

	}

	public static void obrisiText(JTextField polje) {
		polje.setText("");
	}

	public static void otvoriProzorDodavanjePica() {
		dodavanjePicaGui = new DodavanjePica();
		dodavanjePicaGui.setVisible(true);
	}

	public static void zatvoriProzorDodavanjePica() {
		dodavanjePicaGui.setVisible(false);
		dodavanjePicaGui = null;
	}

	public static void dodajPiceUListu(String ime, String cena, String kolicina, String sifra, String tip) {
		try {
			int c = Integer.parseInt(cena);
			int k = Integer.parseInt(kolicina);
			int sif = Integer.parseInt(sifra);

			Pice p = new Pice(sif, ime, tip, k, c);
			ImpZaKontroler.listaPica.add(p);

			JOptionPane.showMessageDialog(glavniGui, "Uspesno ste dodali pice", "", JOptionPane.INFORMATION_MESSAGE);
			zatvoriProzorDodavanjePica();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(dodavanjePicaGui, "Los unos u polja !", "Grska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void dodajCenu(int c, JTextField iznosTxt) {
		int trenutniIznos = 0;
		if (!iznosTxt.getText().equalsIgnoreCase("")) {
			trenutniIznos = Integer.parseInt(iznosTxt.getText());
		}
		trenutniIznos += c;
		iznosTxt.setText(trenutniIznos + "");
	}

}
