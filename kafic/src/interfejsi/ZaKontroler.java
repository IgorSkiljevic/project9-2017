package interfejsi;

import java.util.LinkedList;

import model.Pice;

public interface ZaKontroler {
	/**
	 * 
	 * @param user
	 *            Username konobara/admina u bazi
	 * @param password
	 *            Password konobara/admina u bazi
	 * @return Vraca String "admin" ako dati user i password odgovaraju adminu ;
	 *         vraca String user(Ulazni parametar metode) ako dati user postoji u bazi i unet mu je
	 *         odgovarajuci password ili vraca prazan string ako su podaci lose
	 *         uneseni
	 *
	 */
	public String proveriDaLiJeRegistrovan(String user, char[] password);

	/**
	 * Proverava da li je dati UserName iskoriscen
	 * 
	 * @param user
	 * @return true - iskoriscen usr ; false - nije iskoriscen user
	 */
	public boolean proveriDaLiImaDatogUsera(String user);

	/**
	 * Metoda dodaje datog usera u lokalnu listu sa kojom radimo, koja se puni
	 * iz baze i puni bazu pri zavrsetku rada.
	 * 
	 * @param user
	 * @param password
	 *            voiditi racuna gde je pasword String, a gde char []
	 */
	public void dodajUListuUsera(String user, String password);
	
	
	/**
	 * 
	 * @param tip Predstavlja tip pica(alkoholna, bezalkoholna, pivo, toplinapitak)
	 * @return vraca niz Stringova. Svaki string u nizu je tip pica koji se nalazi u listi pica u ponudi.
	 */
	public String [] izvuciSvaPicaZadatogTipaIzListe(String tip);

}
