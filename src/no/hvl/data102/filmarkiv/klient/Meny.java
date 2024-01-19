package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		
		// Oppretter alle de nødvendige filmene
		Film førsteFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		Film andreFilm = new Film(2, "The Dark Knight", 2008, Sjanger.ACTION, "Emma Thomas", "Warner Bros. Pictures");
		Film tredjeFilm = new Film(3, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		Film fjerdeFilm = new Film(4, "The Shawshank Redemption", 1994, Sjanger.DRAMA, "Niki Marvin", "Castle Rock Entertainment");
		Film femteFilm = new Film(5, "The Godfather", 1972, Sjanger.KRIM, "Albert S. Ruddy", "Paramount Pictures");
		Film sjetteFilm = new Film(6, "12 Angry Men", 1957, Sjanger.DRAMA, "Henry Fonda", "United Artists");
		Film syvendeFilm = new Film(7, "The Godfather Part 2", 1974, Sjanger.KRIM, "Francis Ford Coppola", "Paramount Pictures");
		Film aattendeFilm = new Film(8, "Schindler's list", 1993, Sjanger.THRILLER, "Steven Spielberg", "Universal Pictures");
		Film niendeFilm = new Film(9, "The Lord of the Rings: The Return of the King", 2003, Sjanger.FANTASY, "Peter Jackson", "Warner Bros. Pictures");
		Film tiendeFilm = new Film(10, "Pulp Fiction", 1994, Sjanger.KRIM, "Lawrence Bender", "Miramax Films");
		Film ellevteFilm = new Film(11, "The Lord of the Rings: The Fellowship of the Ring", 2001, Sjanger.FANTASY, "Peter Jackson", "New Line Cinema");
		Film tolvteFilm = new Film(12, "The Good, the Bad and the Ugly", 1966, Sjanger.WESTERN, "Alberto Grimaldi", "Produzioni Europee");
		Film trettendeFilm = new Film(13, "Forrest Gump", 1983, Sjanger.DIVERSE, "Wendy Finerman", "Paramount Pictures");
		Film fjortendeFilm = new Film(14, "Fight Club", 1999, Sjanger.DIVERSE, "Art Linson", "20th Century Fox");
		Film femtendeFilm = new Film(15, "The Lord of the Rings: The Two Towers", 2002, Sjanger.FANTASY, "Peter Jackson", "New Line Cinema");
		Film sekstendeFilm = new Film(16, "Inception", 2010, Sjanger.SCIFI, "Christopher Nolan", "Warner Bros. Pictures");
		Film syttendeFilm = new Film(17, "Star Wars Episode V: The Empire Strikes Back", 1980, Sjanger.DIVERSE, "Gary Kurtz", "20th Century Fox");
		Film attendeFilm = new Film(18, "The Matrix", 1999, Sjanger.SCIFI, "Joel Silver", "Warner Bros. Pictures");
		
		// Legger de opprettede filmene til i arkivet
		filmarkiv.leggTilFilm(førsteFilm);
		filmarkiv.leggTilFilm(andreFilm);
		filmarkiv.leggTilFilm(tredjeFilm);
		filmarkiv.leggTilFilm(fjerdeFilm);
		filmarkiv.leggTilFilm(femteFilm);
		filmarkiv.leggTilFilm(sjetteFilm);
		filmarkiv.leggTilFilm(syvendeFilm);
		filmarkiv.leggTilFilm(aattendeFilm);
		filmarkiv.leggTilFilm(niendeFilm);
		filmarkiv.leggTilFilm(tiendeFilm);
		filmarkiv.leggTilFilm(ellevteFilm);
		filmarkiv.leggTilFilm(tolvteFilm);
		filmarkiv.leggTilFilm(trettendeFilm);
		filmarkiv.leggTilFilm(fjortendeFilm);
		filmarkiv.leggTilFilm(femtendeFilm);
		filmarkiv.leggTilFilm(sekstendeFilm);
		filmarkiv.leggTilFilm(syttendeFilm);
		filmarkiv.leggTilFilm(attendeFilm);
		
		uendeligLookke();
		
	}
	
	public void uendeligLookke() {
		Scanner tastatur = new Scanner(System.in);
		
		System.out.println("\nHva ønsker du å gjøre? Tast: " + "\n" +
							"1 for å legge til film" + "\n" +
							"2 for å finne en film" + "\n" +
							"3 for å skrive ut alle filmer med en delstreng i tittelen" + "\n" +
							"4 for å skrive ut alle filmer med en delstreng i produsentnavn" + "\n" +
							"5 for å skrive ut statistikk fra filmarkivet" + "\n" +
							"0 for å avslutte programmet");
		
		int nyttValg = Integer.parseInt(tastatur.nextLine());
		String delstreng;
		
		switch(nyttValg) {
		case 0:
			System.exit(0);
			break;
		case 1:
			Film filmSomLeggesTil = tekstgr.lesFilm();
			filmarkiv.leggTilFilm(filmSomLeggesTil);
			break;
			
		case 2:
			System.out.println("Skriv filmnummer på filmen du ønsker å skrive ut: ");
			int FNr = Integer.parseInt(tastatur.nextLine());
			tekstgr.skrivUtFilm(filmarkiv.finnFilm(FNr));
			break;
			
		case 3:
			System.out.println("Skriv delstrengen du ønsker å søke på: ");
			tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tastatur.nextLine());
			break;
			
		case 4:
			System.out.println("Skriv delstrengen du ønsker å søke på: ");
			tekstgr.skrivUtFilmProdusent(filmarkiv, tastatur.nextLine());
			break;
			
		case 5:
			tekstgr.skrivUtStatistikk(filmarkiv);
			break;
			
		default:
			uendeligLookke();
		}
		
		uendeligLookke();
	}
}
