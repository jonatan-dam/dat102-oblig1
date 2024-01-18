package no.hvl.data102.filmarkiv.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

	Filmarkiv testArkiv;
	Film førsteFilm;
	Film andreFilm;
	Film tredjeFilm;
	
	
	@BeforeEach
	void setUp() {
		testArkiv = new Filmarkiv(5);
		førsteFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		andreFilm = new Film(2, "The Dark Knight", 2008, Sjanger.ACTION, "Emma Thomas", "Warner Bros. Pictures");
		tredjeFilm = new Film(3, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
	}
	
	
	@Test
	void leggTilFilm() {
		// Legger til en film til i index 0 til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		
		// Henter film i arkivet på index 0
		Film førsteFilmIArkiv = testArkiv.getArkiv()[0];
		
		// Sammenligner filmNr på filmene
		assertEquals(førsteFilm.getFilmNr(), førsteFilmIArkiv.getFilmNr());	
	}
	
	@Test
	void finnFilm() {
		// Legger til en film til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		
		// Tester finnFilm ved å sjekke at filmNr på retur-film er lik som parameter-film.
		Film returFilm = testArkiv.finnFilm(1);
		assertEquals(returFilm.getFilmNr(), førsteFilm.getFilmNr());
	}
	
	@Test
	void slettFilm() {
		// Legger til en film til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		
		// Henter filmNr
		int filmNr = førsteFilm.getFilmNr();
		
		assertTrue(testArkiv.slettFilm(filmNr));
		assertEquals(testArkiv.finnFilm(filmNr), null);
	}
	
	@Test
	void soekTittel() {
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
		// Legger til tre filmer til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		testArkiv.leggTilFilm(andreFilm);
		testArkiv.leggTilFilm(tredjeFilm);
		
		// Tester at antall returnerer 2, da vi har lagt til 2 filmer med sjangeren "THRILLER"
		assertEquals(testArkiv.antall(Sjanger.THRILLER), 2);
	}
	
	@Test
	void antallIArkiv() {
		// Legger til tre filmer til arkivet
		testArkiv.leggTilFilm(førsteFilm);
		testArkiv.leggTilFilm(andreFilm);
		testArkiv.leggTilFilm(tredjeFilm);
		
		// Tester at antall returnerer 3, da vi har lagt til 3 filmer i arkivet
		assertEquals(testArkiv.antall(), 3);
	}
	

	
	
}
