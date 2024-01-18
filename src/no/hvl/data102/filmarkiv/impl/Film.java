package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

/** En klasse for å skape objektet Film
 * @author Jonatan Dam, Hans Christian Gustafsson
 */
public class Film {

	private int filmNr;
	private String filmtittel;
	private int lanseringsAar;
	private Sjanger filmSjanger;
	private String produsent;
	private String filmselskap;
	
	
	
	/** Skaper et tomt Film objekt */
	public Film() {
		
	} //end default konstruktør
	
	/** Skaper et Film objekt med de nødvendige parametrene
	 * @param filmNr int identifikasjonsnummer til filmen
	 * @param filmtittel 
	 * @param lanseringsAar
	 * @param filmSjanger
	 * @param produsent
	 * @param filmselskap
	 */
	public Film(int filmNr, String filmtittel, int lanseringsAar, Sjanger filmSjanger,
				String produsent, String filmselskap) {
		this.filmNr = filmNr;
		this.filmtittel = filmtittel;
		this.lanseringsAar = lanseringsAar;
		this.filmSjanger = filmSjanger;
		this.produsent = produsent;
		this.filmselskap = filmselskap;
	} //end konstruktør

	public int getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getFilmtittel() {
		return filmtittel;
	}

	public void setFilmtittel(String filmtittel) {
		this.filmtittel = filmtittel;
	}

	public int getLanseringsAar() {
		return lanseringsAar;
	}

	public void setLanseringsAar(int lanseringsAar) {
		this.lanseringsAar = lanseringsAar;
	}

	public Sjanger getFilmSjanger() {
		return filmSjanger;
	}

	public void setFilmSjanger(Sjanger filmSjanger) {
		this.filmSjanger = filmSjanger;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmNr == other.filmNr;
	}
	
	
	
	
	
	
}
