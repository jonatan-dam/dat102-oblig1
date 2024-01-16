package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivTest {

	@Test
	void test() {
		Filmarkiv testArkiv = new Filmarkiv(2);
		Film nyFilm = new Film();
		
		// Legger til en film til arkivet
		testArkiv.leggTilFilm(nyFilm);
		
		// Henter første film i arkivet
		Film førsteFilmIArkiv = testArkiv.getArkiv()[0];
		
		// Sammenligner filmNr på filmene
		assertEquals(nyFilm.getFilmNr(), førsteFilmIArkiv.getFilmNr());
	}
}
