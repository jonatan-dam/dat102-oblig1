package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	
	public Film lesFilm() {
		int filmNr;
		String filmTittel;
		int lanseringsaar;
		String sjanger;
		Sjanger filmSjanger = Sjanger.valueOf(sjanger); 
		String produsent;
		String filmselskap;
		
		Film nyFilm = new Film(filmNr, filmTittel, lanseringsaar, filmSjanger, produsent, filmselskap);
		return nyFilm;
	}
	
	public void skrivUtFilm(Film film) {
		String ut = "Filmnr: " + film.getFilmNr() + "\n" +
					"Tittel: " + film.getFilmtittel() + "\n" +
					"Lanseringsår: " + film.getLanseringsAar() + "\n" +
					"Sjanger: " + film.getFilmSjanger().toString() + "\n" +
					"Produsent: " + film.getProdusent() + "\n" +
					"Filmselskap: " + film.getFilmselskap() + "\n";
		System.out.println(ut);
		System.out.println();
	}
	
	public void skrivUtFilmDelStrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] søkeResultat = arkiv.soekTittel(delstreng);
		for(Film resultat : søkeResultat) {
			skrivUtFilm(resultat);
		}
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] søkeResultat = arkiv.soekProdusent(delstreng);
		for(Film resultat : søkeResultat) {
			skrivUtFilm(resultat);
		}
	}
	
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		int antallFilmer = arkiv.antall();
		Sjanger[] sjangTab = Sjanger.values();
		
		System.out.println("Antall filmer i arkivet: " + antallFilmer);
		for(Sjanger sjanger : sjangTab) {
			System.out.println("Antall filmer i sjangeren" + sjanger + ": " + arkiv.antall(sjanger));
		}
		
	}
}
