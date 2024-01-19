package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {
	
	/** Leser inn filminformasjon i konsollen via tastatur, og skriver så informasjonen ut som bekreftelse */
	public Film lesFilm() {
		Scanner tastatur = new Scanner(System.in);
		
		System.out.println("Tast inn filmnummer:");
		int filmNr = Integer.parseInt(tastatur.nextLine());
		
		System.out.println("Tast inn filmtittel:");
		String filmTittel = tastatur.nextLine();
				
		System.out.println("Tast inn lanseringsår::");
		int lanseringsaar = Integer.parseInt(tastatur.nextLine());
		
		System.out.println("Tast inn sjanger");
		String sjanger = tastatur.nextLine();
		Sjanger filmSjanger = Sjanger.valueOf(sjanger); 
		
		System.out.println("Tast inn produsent:");
		String produsent = tastatur.nextLine();
		
		System.out.println("Tast inn filmselskap:");
		String filmselskap = tastatur.nextLine();
		
		Film nyFilm = new Film(filmNr, filmTittel, lanseringsaar, filmSjanger, produsent, filmselskap);
		
		System.out.println("Følgende film er lest inn:");
		skrivUtFilm(nyFilm);
		return nyFilm;
	} //end lesFilm
	
	/** Skriver ut en gitt film
	 * @param film Filmen som skal skrives ut */
	public void skrivUtFilm(Film film) {
		String ut = "Filmnr: " + film.getFilmNr() + "\n" +
					"Tittel: " + film.getFilmtittel() + "\n" +
					"Lanseringsår: " + film.getLanseringsAar() + "\n" +
					"Sjanger: " + film.getFilmSjanger().toString() + "\n" +
					"Produsent: " + film.getProdusent() + "\n" +
					"Filmselskap: " + film.getFilmselskap() + "\n";
		System.out.println(ut);
		System.out.println();
	} //end skrivUtFilm
	
	/** Skriver ut alle filmer med en delstreng i tittelen
	 * @param arkiv Filmarkivet det skal søkes i
	 * @param delstreng Delstrengen som skal søkes etter */
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] søkeResultat = arkiv.soekTittel(delstreng);
		for(Film resultat : søkeResultat) {
			skrivUtFilm(resultat);
		}
	} //end skrivUtFilmDelstrengITittel
	
	
	/** Skriver ut alle filmer med en delstreng i produsentnavnet
	 * @param arkiv Filmarkivet det skal søkes i
	 * @param delstreng Delstrengen som skal søkes etter */
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] søkeResultat = arkiv.soekProdusent(delstreng);
		for(Film resultat : søkeResultat) {
			skrivUtFilm(resultat);
		}
	} //end skrivUtFilmProdusent
	
	/** Skriver ut antall filmer i arkivet samt antall filmer i hver sjanger
	 * @param arkiv Hvilket arkiv man skal hente statistikken fra */
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		int antallFilmer = arkiv.antall();
		Sjanger[] sjangTab = Sjanger.values();
		
		System.out.println("Antall filmer i arkivet: " + antallFilmer);
		for(Sjanger sjanger : sjangTab) {
			System.out.println("Antall filmer i sjangeren" + sjanger + ": " + arkiv.antall(sjanger));
		}
	} //end skrivUtStatistikk
}
