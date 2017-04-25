package model;

public class Pice {

	private int sifra;
	private String ime;
	private String tip;
	private int stanje;
	private int cena;

	public Pice(int sifra, String ime, String tip, int stanje, int cena) {
		this.ime = ime;
		this.sifra = sifra;
		this.tip = tip;
		this.stanje = stanje;
		this.cena = cena;
	}

	public Pice() {
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getStanje() {
		return stanje;
	}

	public void setStanje(int stanje) {
		this.stanje = stanje;
	}

}
