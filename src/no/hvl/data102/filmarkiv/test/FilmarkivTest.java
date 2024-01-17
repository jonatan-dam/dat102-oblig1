package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

	@Test
	void leggTilFilm() {
		Filmarkiv testArkiv = new Filmarkiv(5);
		Film nyFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		
		// Legger til en film til arkivet
		testArkiv.leggTilFilm(nyFilm);
		
		// Henter første film i arkivet
		Film førsteFilmIArkiv = testArkiv.getArkiv()[0];
		
		// Sammenligner filmNr på filmene
		assertEquals(nyFilm.getFilmNr(), førsteFilmIArkiv.getFilmNr());	
	}
	
	@Test
	void finnFilm() {
		Filmarkiv testArkiv = new Filmarkiv(5);
		Film nyFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		
		// Legger til en film til arkivet
		testArkiv.leggTilFilm(nyFilm);
		
		// Tester finnFilm ved å sjekke at filmNr på retur-film er lik som parameter-film.
		Film returFilm = testArkiv.finnFilm(1);
		assertEquals(returFilm.getFilmNr(), nyFilm.getFilmNr());
	}
	
	@Test
	void slettFilm() {
		Filmarkiv testArkiv = new Filmarkiv(5);
		Film nyFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		
		// Legger til en film til arkivet
		testArkiv.leggTilFilm(nyFilm);
		
		// Henter filmNr
		int filmNr = nyFilm.getFilmNr();
		
		assertTrue(testArkiv.slettFilm(filmNr));
		assertEquals(testArkiv.finnFilm(filmNr), null);
	}
	
	@Test
	void soekTittel() {
		Filmarkiv testArkiv = new Filmarkiv(5);
		Film førsteFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		Film andreFilm = new Film(2, "The Dark Knight", 2008, Sjanger.ACTION, "Emma Thomas", "Warner Bros. Pictures");
		Film tredjeFilm = new Film(3, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		
		// Legger til tre filmer til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		testArkiv.leggTilFilm(andreFilm);
		testArkiv.leggTilFilm(tredjeFilm);
		
		// Bruker soekTittel for å lage en tabell med søkeresultater
		Film[] søkeResultater = testArkiv.soekTittel("ar");
		
		// Tester at de riktige filmene legges til i riktig rekkefølge
		assertEquals(søkeResultater[0].getFilmNr(), andreFilm.getFilmNr());
		assertEquals(søkeResultater[1].getFilmNr(), tredjeFilm.getFilmNr());
	}
	
	@Test
	void soekProdusent() {
		Filmarkiv testArkiv = new Filmarkiv(5);
		Film førsteFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		Film andreFilm = new Film(2, "The Dark Knight", 2008, Sjanger.ACTION, "Emma Thomas", "Warner Bros. Pictures");
		Film tredjeFilm = new Film(3, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		
		// Legger til tre filmer til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		testArkiv.leggTilFilm(andreFilm);
		testArkiv.leggTilFilm(tredjeFilm);
		
		// Bruker soekProdusent for å lage en tabell med søkeresultater
		Film[] søkeResultater = testArkiv.soekProdusent("bR");
		
		// Tester at de riktige filmene legges til i riktig rekkefølge
		assertEquals(søkeResultater[0].getFilmNr(), førsteFilm.getFilmNr());
		assertEquals(søkeResultater[1].getFilmNr(), tredjeFilm.getFilmNr());
	}
	
	@Test
	void antallISjanger() {
		Filmarkiv testArkiv = new Filmarkiv(5);
		Film førsteFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		Film andreFilm = new Film(2, "The Dark Knight", 2008, Sjanger.ACTION, "Emma Thomas", "Warner Bros. Pictures");
		Film tredjeFilm = new Film(3, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		
		// Legger til tre filmer til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		testArkiv.leggTilFilm(andreFilm);
		testArkiv.leggTilFilm(tredjeFilm);
		
		// Tester at antall returnerer 2, da vi har lagt til 2 filmer med sjangeren "THRILLER"
		assertEquals(testArkiv.antall(Sjanger.THRILLER), 2);
	}
	
	@Test
	void antallIArkiv() {
		Filmarkiv testArkiv = new Filmarkiv(5);
		Film førsteFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		Film andreFilm = new Film(2, "The Dark Knight", 2008, Sjanger.ACTION, "Emma Thomas", "Warner Bros. Pictures");
		Film tredjeFilm = new Film(3, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		
		// Legger til tre filmer til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		testArkiv.leggTilFilm(andreFilm);
		testArkiv.leggTilFilm(tredjeFilm);
		
		// Tester at antall returnerer 3, da vi har lagt til 3 filmer i arkivet
		assertEquals(testArkiv.antall(), 3);
	}
	

	
	
}
