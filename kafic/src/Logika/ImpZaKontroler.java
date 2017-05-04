package Logika;

import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import baza.bModel.KonobarBaza;
import baza.bModel.PiceBaza;
import interfejsi.ZaKontroler;
import model.Konobar;
import model.Pice;

public class ImpZaKontroler implements ZaKontroler {
	
	private LinkedList<Pice> listaPica;
	private LinkedList<Konobar> listaKonobara;
	private LinkedList<Pice> prodatoPice;
	
	

	public ImpZaKontroler() {
		listaPica = PiceBaza.napuniListuTekucimStanjemPica();
		listaKonobara = KonobarBaza.ubaciUListuSveKonobare();
		prodatoPice = new LinkedList<Pice>();
	}

	public String proveriDaLiJeRegistrovan(String user, char[] password) {
		for (int i = 0; i < listaKonobara.size(); i++) {
			if(user.equals(listaKonobara.get(i).getUser())){
				if(password.toString().equals(listaKonobara.get(i).getPass())){
					if(listaKonobara.get(i).isAdmin())
						return "admin";
					else return listaKonobara.get(i).getUser();
				}
			}
		}
		return "";			
	}

	@Override
	public boolean proveriDaLiImaDatogUsera(String user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dodajUListuUsera(String user, String password) {
		if(user == null || user.equals("") || user == null || user.equals(""))
			throw new RuntimeException();
		
		Konobar k = new Konobar(user, password, false);
		listaKonobara.add(k);

	}

	@Override
	public String[] izvuciSvaPicaZadatogTipaIzListe(String tip) {
		// TODO Auto-generated method stub
		return null;
	}

	public void dodajPicaUModel(DefaultListModel model, String[] elementi) {
		for (String string : elementi) {
			model.addElement(string);
		}
	}

}
