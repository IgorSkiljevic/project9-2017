package Logika;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import baza.bModel.KonobarBaza;
import baza.bModel.PiceBaza;
import baza.bModel.RacunBaza;
import interfejsi.ZaKontroler;
import model.Konobar;
import model.Pice;
import model.Racun;

public class ImpZaKontroler implements ZaKontroler {

	public static LinkedList<Pice> listaPica;
	public static LinkedList<Konobar> listaKonobara;

	public ImpZaKontroler() {
		listaPica = PiceBaza.napuniListuTekucimStanjemPica();
		listaKonobara = KonobarBaza.ubaciUListuSveKonobare();
	}

	@Override
	public String proveriDaLiJeRegistrovan(String user, char[] password) {
		for (int i = 0; i < listaKonobara.size(); i++) {
			if (user.equals(listaKonobara.get(i).getUser())) {
				String pass = "";
				for (int j = 0; j < password.length; j++) {
					pass += password[j];
				}
				// if(password.toString().equals(listaKonobara.get(i).getPass())){
				if (pass.equals(listaKonobara.get(i).getPass())) {
//					System.out.println(listaKonobara.get(i).isAdmin());
					if (listaKonobara.get(i).isAdmin()) {
						
						return "admin";
					} else {
						return listaKonobara.get(i).getUser();
					}
				}
			}
		}
		return "";
	}

	@Override
	public boolean proveriDaLiImaDatogUsera(String user) {
		if (user.equals(""))
			return false;

		for (int i = 0; i < listaKonobara.size(); i++) {
			if (listaKonobara.get(i).getUser().equals(user))
				return true;
		}

		return false;
	}

	@Override
	public void dodajUListuUsera(String user, String password) {
		if (user == null || user.equals(""))
			throw new RuntimeException();

		Konobar k = new Konobar(user, password, false);
		listaKonobara.add(k);

	}
	
	@Override
	public String[] izvuciSvaPicaZadatogTipaIzListe(String tip) {
		ArrayList<Pice> pica = new ArrayList<>();
		
		for (Pice p : listaPica) {
			if(p.getTip().equalsIgnoreCase(tip)){
				pica.add(p);
			}
		}
		String [] nizPica = new String[pica.size()];
		
		for (int i = 0; i < nizPica.length; i++) {
			nizPica[i] = pica.get(i).getIme() +  " - " + pica.get(i).getCena();
		}
		return nizPica;
	}

	public void dodajPicaUModel(DefaultListModel model, String[] elementi) {
		for (String string : elementi) {
			model.addElement(string);
		}
	}

	public Pice pronadjiDatoPiceISmanjiMuKolicinu(String ime_cena) {
		String ime = ime_cena.substring(0, ime_cena.indexOf(" "));
		for (Pice pice : listaPica) {
			if(pice.getIme().equalsIgnoreCase(ime)){
				pice.setStanje(pice.getStanje() - 1);
				return pice;
			}
		}
		return null;
	}

}

