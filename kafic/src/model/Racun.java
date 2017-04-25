package model;

import java.sql.Date;
import java.util.LinkedList;

public class Racun {
	
	private String smena;
	private Date datum;
	LinkedList<Pice> pica;
	
	public Racun(String smena, Date datum, LinkedList<Pice> pica) {
		this.smena =smena;
		this.datum = datum;
		this.pica = pica;
		}
	
	public Racun() {
	}

	public String getSmena() {
		return smena;
	}

	public void setSmena(String smena) {
		this.smena = smena;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public LinkedList<Pice> getPica() {
		return pica;
	}

	public void setPica(LinkedList<Pice> pica) {
		this.pica = pica;
	}
	
	
	
}
