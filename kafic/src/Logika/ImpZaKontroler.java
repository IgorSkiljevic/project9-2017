package Logika;

import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import interfejsi.ZaKontroler;
import model.Pice;

public class ImpZaKontroler implements ZaKontroler {

	public String proveriDaLiJeRegistrovan(String user, char[] password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean proveriDaLiImaDatogUsera(String user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dodajUListuUsera(String user, String password) {
		// TODO Auto-generated method stub

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
