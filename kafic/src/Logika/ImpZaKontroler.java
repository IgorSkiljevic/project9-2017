package Logika;

import java.util.ArrayList;
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
	
	@Override
	public String proveriDaLiJeRegistrovan(String user, char[] password) {
		for (int i = 0; i < listaKonobara.size(); i++) {
			if(user.equals(listaKonobara.get(i).getUser())){
				String pass = "";
				for (int j = 0; j < password.length; j++) {
					pass += password[j];
				}
				if(pass.equals(listaKonobara.get(i).getPass())){
					if(listaKonobara.get(i).isAdmin()){
						return "admin";
					}else{
						return listaKonobara.get(i).getUser();
					}
				}
			}
		}
		return "";			
	}

	@Override
	public boolean proveriDaLiImaDatogUsera(String user) {
		if(user.equals(""))
			return false;
		
		for (int i = 0; i < listaKonobara.size(); i++) {
			if(listaKonobara.get(i).getUser().equals(user))
				return true;
		}
		
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
		ArrayList<Pice> pice = new ArrayList(); 
		for (int i = 0; i < listaPica.size(); i++) {
			if(listaPica.get(i).getTip().equals(tip)){
				pice.add(listaPica.get(i));
			}
		}
		
		String[] niz = new String[pice.size()];
		for (int i = 0; i < niz.length; i++) {
			//ovde dodati format za ispis
			niz[i] = pice.get(i).getIme() ;
		}
		return null;
	}

	public void dodajPicaUModel(DefaultListModel model, String[] elementi) {
		for (String string : elementi) {
			model.addElement(string);
		}
	}

}
